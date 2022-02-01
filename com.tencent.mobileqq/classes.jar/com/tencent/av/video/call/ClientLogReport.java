package com.tencent.av.video.call;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.qq.jce.wup.UniPacket;
import com.tencent.av.AVPathUtil;
import com.tencent.av.VideoRecoveryReporter;
import com.tencent.av.ui.funchat.record.QavRecordDpc;
import com.tencent.avcore.jni.log.ClientLogReportJni;
import com.tencent.avcore.jni.log.IClientLogReport;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClientLogReport
  implements IClientLogReport
{
  private static final String CONN_RATE_BEACON_REPORT_APP_KEY = "0DOU09AAM746YHNI";
  private static final String CONN_RATE_BEACON_REPORT_DAV_EVENT = "DAV_Conn_Rate";
  private static final String CONN_RATE_BEACON_REPORT_MAV_EVENT = "MAV_Conn_Rate";
  private static final String GACS_REPORT_NEW_KEY = "2085";
  private static final String GACS_REPORT_NEW_KEY_2 = "2207";
  private static final String HW_CODEC_CAPABILITY_TEST_KEY = "dc05274";
  public static final String HW_CODEC_CAPABILITY_TEST_TOPIC_ID = "5274";
  private static final String KEY_CLIENT_IP = "client_ip";
  private static final int LOG_SEND_RET_FAIL = 0;
  private static final int LOG_SEND_RET_OK = 1;
  private static final int LOG_SEND_RET_PENDING = 2;
  private static final String NEW_GACS_REPORT = "dc02085";
  private static final String NEW_GACS_REPORT_2 = "dc02207";
  private static final String REPORT_FAIL_LOG_DIR = AVPathUtil.n();
  private static final long REPORT_FAIL_RETRY_MAX_INTERVAL = 86400000L;
  private static final String REPORT_RECORD_IS_RETRY = "report_record_is_retry";
  private static final String REPORT_RECORD_SEQ = "report_record_seq";
  private static final String SEND_LOG_ID = "0";
  private static final String SERVER_FILTER_KEY = "video_log";
  private static final String[] S_CONN_RATE_KEYS = { "selfUin", "client_type", "client_version", "net_type", "net_status", "client_ip", "buss_type", "cmd", "union_room_id", "f9", "f10", "f11", "f12", "f13", "f14", "conn_ip", "conn_family", "tcp_socket_status", "conn_count", "conn_status", "ret_code", "cost_time", "conn_index", "f22", "f23", "f24", "f25", "f26" };
  private static final String TAG = "ClientLogReport";
  private static final String TECH_QUA_LOG_ID = "918";
  private static final String UDP_CHECK_LOG_ID = "1";
  private static final String UDP_CHECK_RESULT_SERVER_FILTER_KEY = "video_udpcheck_log";
  private static ClientLogReport instance = null;
  public static volatile String sGatewayIP = "";
  public static volatile int sGatewayPort;
  private int mAppId;
  private AppInterface mAppInterface;
  private Context mContext;
  private boolean mInit = false;
  private final ClientLogReportJni mJni = new ClientLogReportJni(this);
  private MsfServiceSdk mMsfSub;
  private Map<Integer, ClientLogReport.ReportRecord> mReportRecordCache = new ConcurrentHashMap();
  private boolean mReportRetryEnable;
  private int mSeqNo;
  
  public static ClientLogReport instance()
  {
    if (instance == null) {
      instance = new ClientLogReport();
    }
    return instance;
  }
  
  private Map<String, String> unPacketConnRateData(byte[] paramArrayOfByte)
  {
    HashMap localHashMap = new HashMap();
    String[] arrayOfString = S_CONN_RATE_KEYS;
    int m = arrayOfString.length;
    int k = 0;
    int j;
    for (int i = 0; k < m; i = j)
    {
      String str = arrayOfString[k];
      StringBuilder localStringBuilder = new StringBuilder();
      for (;;)
      {
        j = i;
        if (i >= paramArrayOfByte.length) {
          break;
        }
        j = i + 1;
        char c = (char)paramArrayOfByte[i];
        if (c == '|')
        {
          localHashMap.put(str, localStringBuilder.toString());
          break;
        }
        localStringBuilder.append(c);
        i = j;
      }
      k += 1;
    }
    localHashMap.put("client_ip", sGatewayIP);
    return localHashMap;
  }
  
  public void checkLocalReportRecord()
  {
    QLog.d("ClientLogReport", 1, "checkLocalReportRecord");
    if (!this.mInit)
    {
      QLog.e("ClientLogReport", 1, "checkLocalReportRecord mInit is false.");
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(this.mContext))
    {
      QLog.e("ClientLogReport", 1, "checkLocalReportRecord network is invalid.");
      return;
    }
    new Handler(ThreadManagerV2.getFileThreadLooper()).post(new ClientLogReport.1(this));
  }
  
  public void handleServerResp(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ClientLogReport", 2, String.format("handleServerResp request=%s response=%s", new Object[] { paramIntent, paramFromServiceMsg }));
    }
    if ((paramIntent != null) && (paramFromServiceMsg != null))
    {
      paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
      int i = ((Integer)paramIntent.getAttribute("report_record_seq")).intValue();
      boolean bool1 = ((Boolean)paramIntent.getAttribute("report_record_is_retry")).booleanValue();
      boolean bool2 = paramFromServiceMsg.isSuccess();
      paramIntent = (ClientLogReport.ReportRecord)this.mReportRecordCache.get(Integer.valueOf(i));
      QLog.d("ClientLogReport", 1, String.format("handleServerResp seq=%s isRetry=%s success=%s record=%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramIntent }));
      if (paramIntent != null) {
        if (bool1)
        {
          VideoRecoveryReporter.a(bool2);
        }
        else if (!bool2)
        {
          paramFromServiceMsg = new File(REPORT_FAIL_LOG_DIR);
          if (!paramFromServiceMsg.exists()) {
            paramFromServiceMsg.mkdirs();
          }
          paramIntent.writeToFile(new File(REPORT_FAIL_LOG_DIR, String.valueOf(paramIntent.mTimestamp)));
          VideoRecoveryReporter.c();
        }
      }
      this.mReportRecordCache.remove(Integer.valueOf(i));
    }
  }
  
  public void init(Context paramContext, int paramInt)
  {
    if (this.mJni.mNativeInit)
    {
      this.mContext = paramContext;
      this.mAppId = paramInt;
      this.mMsfSub = MsfServiceSdk.get();
      boolean bool;
      if (QavRecordDpc.a().q == 1) {
        bool = true;
      } else {
        bool = false;
      }
      this.mReportRetryEnable = bool;
      QQBeaconReport.a();
      this.mInit = true;
      QLog.d("ClientLogReport", 1, String.format("init mReportRetryEnable=%s", new Object[] { Boolean.valueOf(this.mReportRetryEnable) }));
    }
  }
  
  public int sendLog(long paramLong, String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (!this.mInit)
    {
      QLog.e("ClientLogReport", 1, "sendLog mInit is false.");
      return 0;
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      if (this.mMsfSub == null)
      {
        QLog.e("ClientLogReport", 1, "sendLog mMsfSub is null.");
        return 0;
      }
      Object localObject1;
      if ("0".equalsIgnoreCase(paramString)) {
        localObject1 = "video_log";
      } else if ("1".equalsIgnoreCase(paramString)) {
        localObject1 = "video_udpcheck_log";
      } else if ("2085".equalsIgnoreCase(paramString)) {
        localObject1 = "dc02085";
      } else if ("2207".equalsIgnoreCase(paramString)) {
        localObject1 = "dc02207";
      } else if ("5274".equalsIgnoreCase(paramString)) {
        localObject1 = "dc05274";
      } else if ("0DOU09AAM746YHNI_DAV_Conn_Rate".equalsIgnoreCase(paramString)) {
        localObject1 = "DAV_Conn_Rate";
      } else if ("0DOU09AAM746YHNI_MAV_Conn_Rate".equalsIgnoreCase(paramString)) {
        localObject1 = "MAV_Conn_Rate";
      } else {
        localObject1 = paramString;
      }
      if ((!"DAV_Conn_Rate".equals(localObject1)) && (!"MAV_Conn_Rate".equals(localObject1))) {
        try
        {
          Object localObject2 = new ConcurrentHashMap();
          ((Map)localObject2).put(localObject1, new ArrayList());
          ((ArrayList)((Map)localObject2).get(localObject1)).add(paramArrayOfByte);
          boolean bool = this.mReportRetryEnable;
          if ((bool) && (this.mAppInterface != null) && ("918".equalsIgnoreCase(paramString)))
          {
            this.mSeqNo += 1;
            localObject1 = new QQService.strupbuff();
            ((QQService.strupbuff)localObject1).logstring = ((Map)localObject2);
            ((QQService.strupbuff)localObject1).seqno = this.mSeqNo;
            localObject2 = new UniPacket(true);
            ((UniPacket)localObject2).setServantName("QQService.CliLogSvc.MainServantObj");
            ((UniPacket)localObject2).setFuncName("UploadReq");
            ((UniPacket)localObject2).put("Data", localObject1);
            localObject1 = ((UniPacket)localObject2).encode();
            if (QLog.isColorLevel()) {
              QLog.d("ClientLogReport", 2, String.format("sendLog with response length=%s wupBuf=%s", new Object[] { Integer.valueOf(localObject1.length), Arrays.toString((byte[])localObject1) }));
            }
            localObject1 = Arrays.copyOfRange((byte[])localObject1, 4, localObject1.length);
            if (QLog.isColorLevel()) {
              QLog.d("ClientLogReport", 2, String.format("sendLog length=%s wupBuf1=%s", new Object[] { Integer.valueOf(localObject1.length), Arrays.toString((byte[])localObject1) }));
            }
            localObject2 = new ClientLogReport.ReportRecord();
            ((ClientLogReport.ReportRecord)localObject2).mUin = paramLong;
            ((ClientLogReport.ReportRecord)localObject2).mTopicId = paramString;
            ((ClientLogReport.ReportRecord)localObject2).mLog = paramArrayOfByte;
            ((ClientLogReport.ReportRecord)localObject2).mTimestamp = System.currentTimeMillis();
            this.mReportRecordCache.put(Integer.valueOf(this.mSeqNo), localObject2);
            paramString = new ToServiceMsg(null, String.valueOf(paramLong), "CliLogSvc.UploadReq");
            paramString.putWupBuffer((byte[])localObject1);
            paramString.setNeedCallback(true);
            paramString.setTimeout(15000L);
            paramString.addAttribute("report_record_seq", Integer.valueOf(this.mSeqNo));
            paramString.addAttribute("report_record_is_retry", Boolean.valueOf(paramBoolean));
            this.mAppInterface.sendToService(paramString);
            return 1;
          }
          paramString = new com.tencent.av.video.jce.QQService.strupbuff();
          paramString.logstring = ((Map)localObject2);
          paramArrayOfByte = new UniPacket(true);
          paramArrayOfByte.put("Data", paramString);
          paramString = paramArrayOfByte.encode();
          if (QLog.isColorLevel()) {
            QLog.d("ClientLogReport", 2, String.format("sendLog without response length=%s wupBuf=%s", new Object[] { Integer.valueOf(paramString.length), Arrays.toString(paramString) }));
          }
          paramArrayOfByte = new ToServiceMsg(this.mMsfSub.getMsfServiceName(), String.valueOf(paramLong), "CliLogSvc.UploadReq");
          paramArrayOfByte.putWupBuffer(paramString);
          paramArrayOfByte.setNeedCallback(false);
          this.mMsfSub.sendMsg(paramArrayOfByte);
          return 1;
        }
        catch (Throwable paramString)
        {
          QLog.e("ClientLogReport", 1, "callbackSendLog fail.", paramString);
          return 0;
        }
      }
      paramString = unPacketConnRateData(paramArrayOfByte);
      QQBeaconReport.a("0DOU09AAM746YHNI", String.valueOf(paramLong), (String)localObject1, true, paramString, true);
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("report conn rate, ip[");
        paramArrayOfByte.append((String)paramString.get("client_ip"));
        paramArrayOfByte.append("], event[");
        paramArrayOfByte.append((String)localObject1);
        paramArrayOfByte.append("]");
        QLog.i("ClientLogReport", 2, paramArrayOfByte.toString());
      }
      return 1;
    }
    QLog.e("ClientLogReport", 1, "sendLog log is empty.");
    return 0;
  }
  
  public void setAppInterface(AppInterface paramAppInterface)
  {
    this.mAppInterface = paramAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.video.call.ClientLogReport
 * JD-Core Version:    0.7.0.1
 */