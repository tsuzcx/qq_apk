package com.tencent.av.video.call;

import android.content.Context;
import android.os.SystemClock;
import com.qq.jce.wup.UniPacket;
import com.tencent.av.AVLog;
import com.tencent.av.report.AVReport;
import com.tencent.av.report.AVReport.ReceiverNodeStage;
import com.tencent.av.report.AVReport.SenderNodeStage;
import com.tencent.av.report.TraeConfigUpdate;
import com.tencent.av.video.jce.QQService.strupbuff;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClientLogReport
{
  private static final String BUSSINESS_DETAIL = "param_bussinesstype";
  private static final String CONFIG_TRAE = "param_config_trae";
  private static final String DETAIL = "param_detail";
  private static final String DETAIL_TRAE = "param_detail_trae";
  private static final int GACSReportNewKey = 2085;
  private static final int GACSReportNewKey2 = 2207;
  private static final int LogSendRet_FAIL = 0;
  private static final int LogSendRet_OK = 1;
  private static final int LogSendRet_PENDING = 2;
  private static final String MSF_DETAIL = "param_msf_detail";
  private static final String NewGACSReport = "dc02085";
  private static final String NewGACSReport2 = "dc02207";
  private static final String RECEIVER = "actAVQualityReportReceiver";
  private static final String SDK_VERSION_DETAIL = "param_sdkversion";
  private static final String SENDER = "actAVQualityReportSender";
  private static final String SESSION_DETAIL = "param_sessionid";
  private static final String ServerDataKey = "Data";
  private static final String ServerFilterKey = "video_log";
  private static final int SharpLogServerFilterKey = 607;
  private static final int SharpReportServerFilterKey = 617;
  private static final String TAG = "ClientLogReport";
  private static final String TERMINAL_TYPE = "param_terminaltype";
  private static final String UIN_DETAIL = "param_peeruin";
  private static final String UdpCheckResultServerFilterKey = "video_udpcheck_log";
  private static ClientLogReport instance;
  private static final String serviceCmd = "CliLogSvc.UploadReq";
  private int appid;
  private UniPacket client;
  private boolean init;
  private Map jceMap;
  private strupbuff logJce;
  private boolean mNativeInit;
  private MsfServiceSdk msfSub;
  
  static
  {
    try
    {
      cacheMethodIds();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      AVLog.e("ClientLogReport", localUnsatisfiedLinkError.getMessage());
    }
  }
  
  private ClientLogReport()
  {
    try
    {
      init();
      this.mNativeInit = true;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      AVLog.e("ClientLogReport", localUnsatisfiedLinkError.getMessage());
    }
  }
  
  private static native void cacheMethodIds();
  
  private native void init();
  
  public static ClientLogReport instance()
  {
    if (instance == null) {
      instance = new ClientLogReport();
    }
    return instance;
  }
  
  public int callbackSendLog(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    if (!this.init) {
      return 0;
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return 0;
    }
    Object localObject = String.valueOf(paramInt);
    if (paramInt == 0) {
      localObject = "video_log";
    }
    while ((this.jceMap == null) || (this.msfSub == null))
    {
      return 0;
      if (paramInt == 1) {
        localObject = "video_udpcheck_log";
      } else if (paramInt == 2085) {
        localObject = "dc02085";
      } else if (paramInt == 2207) {
        localObject = "dc02207";
      }
    }
    try
    {
      this.jceMap.clear();
      this.jceMap.put(localObject, new ArrayList());
      ((ArrayList)this.jceMap.get(localObject)).add(paramArrayOfByte);
      this.client.put("Data", this.logJce);
      paramArrayOfByte = this.client.encode();
      localObject = new ToServiceMsg(this.msfSub.getMsfServiceName(), String.valueOf(paramLong), "CliLogSvc.UploadReq");
      ((ToServiceMsg)localObject).setNeedCallback(false);
      ((ToServiceMsg)localObject).putWupBuffer(paramArrayOfByte);
      paramInt = this.msfSub.sendMsg((ToServiceMsg)localObject);
      if (paramInt >= 0) {
        return 1;
      }
      return 0;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return 0;
  }
  
  public void callbackSendNodeData(long paramLong1, int paramInt, long paramLong2, long paramLong3)
  {
    paramLong1 = SystemClock.elapsedRealtime();
    AVReport localAVReport = AVReport.a();
    if (localAVReport == null) {
      return;
    }
    if (paramLong3 != 0L) {
      localAVReport.S = paramLong3;
    }
    if (paramLong2 != 0L) {
      localAVReport.R = paramLong2;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 100: 
      AVReport.a().jdField_f_of_type_Long = paramLong1;
      AVReport.a().jdField_a_of_type_ComTencentAvReportAVReport$SenderNodeStage = AVReport.SenderNodeStage.SendRequestReq;
      return;
    case 118: 
      AVReport.a().jdField_b_of_type_Long = paramLong1;
      AVReport.a().jdField_a_of_type_ComTencentAvReportAVReport$SenderNodeStage = AVReport.SenderNodeStage.SendAVRoomReq;
      localAVReport.jdField_b_of_type_Boolean = false;
      return;
    case 119: 
      AVReport.a().jdField_e_of_type_Long = paramLong1;
      AVReport.a().jdField_a_of_type_ComTencentAvReportAVReport$SenderNodeStage = AVReport.SenderNodeStage.RecvAVRoomReqACK;
      return;
    }
    localAVReport.r = paramLong1;
    localAVReport.jdField_a_of_type_ComTencentAvReportAVReport$ReceiverNodeStage = AVReport.ReceiverNodeStage.other;
  }
  
  public int callbackSendQualityLog(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return 0;
    }
    HashMap localHashMap = new HashMap();
    if (AVReport.a().jdField_b_of_type_JavaLangString != null) {
      localHashMap.put("param_peeruin", AVReport.a().jdField_b_of_type_JavaLangString);
    }
    localHashMap.put("param_sessionid", String.valueOf(paramLong3));
    localHashMap.put("param_sdkversion", String.valueOf(paramInt3));
    localHashMap.put("param_bussinesstype", String.valueOf(paramInt1));
    localHashMap.put("param_terminaltype", String.valueOf(paramInt2));
    localHashMap.put("param_msf_detail", AVReport.a().a(paramBoolean));
    localHashMap.put("param_config_trae", TraeConfigUpdate.a().a());
    paramArrayOfByte = new String(paramArrayOfByte).split("&");
    if (paramArrayOfByte.length > 0)
    {
      localHashMap.put("param_detail", paramArrayOfByte[0]);
      if (paramArrayOfByte.length > 1) {
        localHashMap.put("param_detail_trae", paramArrayOfByte[1]);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ClientLogReport", 2, localHashMap.toString());
    }
    if (paramBoolean) {
      StatisticCollector.a(BaseApplication.getContext()).a(String.valueOf(paramLong1), "actAVQualityReportSender", true, 0L, 0L, localHashMap, "", true);
    }
    for (;;)
    {
      return 1;
      StatisticCollector.a(BaseApplication.getContext()).a(String.valueOf(paramLong1), "actAVQualityReportReceiver", true, 0L, 0L, localHashMap, "", true);
    }
  }
  
  public int callbackSendQualityLogBuf(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return 0;
    }
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "UTF-8").split("#");
      if (paramArrayOfByte.length >= 8)
      {
        long l1 = Long.parseLong(paramArrayOfByte[1]);
        long l2 = Long.parseLong(paramArrayOfByte[2]);
        paramInt = Integer.parseInt(paramArrayOfByte[3]);
        int i = Integer.parseInt(paramArrayOfByte[4]);
        if (Integer.parseInt(paramArrayOfByte[5]) != 0) {}
        for (boolean bool = true;; bool = false)
        {
          int j = Integer.parseInt(paramArrayOfByte[6]);
          paramArrayOfByte = paramArrayOfByte[7];
          paramInt = callbackSendQualityLog(paramLong, l1, l2, paramInt, i, j, bool, paramArrayOfByte.length(), paramArrayOfByte.getBytes());
          return paramInt;
        }
      }
      return 0;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public void init(Context paramContext, int paramInt)
  {
    if (this.mNativeInit)
    {
      this.client = new UniPacket(true);
      this.jceMap = new ConcurrentHashMap();
      this.logJce = new strupbuff(this.jceMap);
      this.msfSub = MsfServiceSdk.get();
      this.appid = paramInt;
      this.init = true;
    }
  }
  
  public void processNode(int paramInt, long paramLong1, long paramLong2)
  {
    long l = SystemClock.elapsedRealtime();
    AVReport localAVReport = AVReport.a();
    if (localAVReport == null) {
      return;
    }
    if (paramLong2 != 0L) {
      localAVReport.S = paramLong2;
    }
    if (paramLong1 != 0L) {
      localAVReport.R = paramLong1;
    }
    switch (paramInt)
    {
    case 105: 
    case 108: 
    case 115: 
    case 121: 
    default: 
      return;
    case 100: 
      AVReport.a().jdField_f_of_type_Long = l;
      AVReport.a().jdField_a_of_type_ComTencentAvReportAVReport$SenderNodeStage = AVReport.SenderNodeStage.SendRequestReq;
      return;
    case 118: 
      AVReport.a().jdField_b_of_type_Long = l;
      AVReport.a().jdField_a_of_type_ComTencentAvReportAVReport$SenderNodeStage = AVReport.SenderNodeStage.SendAVRoomReq;
      localAVReport.jdField_b_of_type_Boolean = false;
      return;
    case 119: 
      AVReport.a().jdField_e_of_type_Long = l;
      AVReport.a().jdField_a_of_type_ComTencentAvReportAVReport$SenderNodeStage = AVReport.SenderNodeStage.RecvAVRoomReqACK;
      return;
    case 122: 
      AVReport.a().l = l;
      return;
    case 123: 
      AVReport.a().jdField_m_of_type_Long = l;
      return;
    case 104: 
      localAVReport.g = true;
      localAVReport.J = l;
      localAVReport.jdField_p_of_type_Boolean = true;
      return;
    case 109: 
      localAVReport.h = true;
      localAVReport.K = l;
      localAVReport.jdField_p_of_type_Boolean = true;
      return;
    case 110: 
      localAVReport.i = true;
      localAVReport.L = l;
      localAVReport.jdField_p_of_type_Boolean = true;
      return;
    case 102: 
      localAVReport.j = true;
      localAVReport.M = l;
      localAVReport.jdField_p_of_type_Boolean = true;
      return;
    case 103: 
      localAVReport.j = true;
      localAVReport.M = l;
      localAVReport.jdField_p_of_type_Boolean = true;
      return;
    case 111: 
      if (localAVReport.jdField_a_of_type_Boolean) {
        localAVReport.jdField_n_of_type_Long = l;
      }
      for (;;)
      {
        localAVReport.jdField_p_of_type_Boolean = true;
        return;
        localAVReport.C = l;
      }
    case 106: 
      if (localAVReport.jdField_a_of_type_Boolean) {
        localAVReport.o = l;
      }
      for (;;)
      {
        localAVReport.jdField_p_of_type_Boolean = true;
        localAVReport.jdField_m_of_type_Boolean = true;
        localAVReport.P = l;
        return;
        localAVReport.D = l;
      }
    case 112: 
      if (localAVReport.jdField_a_of_type_Boolean) {
        localAVReport.jdField_p_of_type_Long = l;
      }
      for (;;)
      {
        localAVReport.jdField_p_of_type_Boolean = true;
        localAVReport.jdField_n_of_type_Boolean = true;
        localAVReport.Q = l;
        return;
        localAVReport.E = l;
      }
    case 117: 
      localAVReport.jdField_b_of_type_Boolean = true;
      return;
    case 120: 
      localAVReport.c = true;
      return;
    case 101: 
      localAVReport.F = l;
      return;
    case 107: 
      localAVReport.r = l;
      localAVReport.jdField_a_of_type_ComTencentAvReportAVReport$ReceiverNodeStage = AVReport.ReceiverNodeStage.other;
      return;
    case 124: 
      localAVReport.A = l;
      return;
    case 125: 
      localAVReport.B = l;
      return;
    case 116: 
      localAVReport.d = true;
      localAVReport.G = l;
      return;
    case 113: 
      localAVReport.jdField_e_of_type_Boolean = true;
      localAVReport.H = l;
      return;
    }
    localAVReport.jdField_f_of_type_Boolean = true;
    localAVReport.I = l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.video.call.ClientLogReport
 * JD-Core Version:    0.7.0.1
 */