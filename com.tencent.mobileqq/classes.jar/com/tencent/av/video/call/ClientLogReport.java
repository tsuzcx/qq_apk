package com.tencent.av.video.call;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import bbfj;
import com.qq.jce.wup.UniPacket;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lcj;
import ldy;
import mnm;

public class ClientLogReport
{
  private static final int GACSReportNewKey = 2085;
  private static final int GACSReportNewKey2 = 2207;
  private static final String HWCodecCapabilityTestKey = "dc05274";
  public static final int HWCodecCapabilityTestTopicId = 5274;
  private static final int LogSendRet_FAIL = 0;
  private static final int LogSendRet_OK = 1;
  private static final int LogSendRet_PENDING = 2;
  private static final String NewGACSReport = "dc02085";
  private static final String NewGACSReport2 = "dc02207";
  private static final String REPORT_FAIL_LOG_DIR = ;
  private static final long REPORT_FAIL_RETRY_MAX_INTERVAL = 86400000L;
  private static final String REPORT_RECORD_IS_RETRY = "report_record_is_retry";
  private static final String REPORT_RECORD_SEQ = "report_record_seq";
  private static final String ServerFilterKey = "video_log";
  private static final String TAG = "ClientLogReport";
  private static final String UdpCheckResultServerFilterKey = "video_udpcheck_log";
  private static ClientLogReport instance;
  private int mAppId;
  private Context mContext;
  private boolean mInit;
  private MsfServiceSdk mMsfSub;
  private boolean mNativeInit;
  private Map<Integer, ClientLogReport.ReportRecord> mReportRecordCache = new ConcurrentHashMap();
  private boolean mReportRetryEnable;
  private int mSeqNo;
  private VideoAppInterface mVideoApp;
  
  static
  {
    try
    {
      cacheMethodIds();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ClientLogReport", 1, "cacheMethodIds fail.", localThrowable);
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
    catch (Throwable localThrowable)
    {
      QLog.e("ClientLogReport", 1, "ClientLogReport fail.", localThrowable);
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
  
  private int sendLog(long paramLong, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (!this.mInit)
    {
      QLog.e("ClientLogReport", 1, "sendLog mInit is false.");
      return 0;
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      QLog.e("ClientLogReport", 1, "sendLog log is empty.");
      return 0;
    }
    if (this.mMsfSub == null)
    {
      QLog.e("ClientLogReport", 1, "sendLog mMsfSub is null.");
      return 0;
    }
    Object localObject1 = String.valueOf(paramInt);
    if (paramInt == 0) {
      localObject1 = "video_log";
    }
    try
    {
      Object localObject2 = new ConcurrentHashMap();
      ((Map)localObject2).put(localObject1, new ArrayList());
      ((ArrayList)((Map)localObject2).get(localObject1)).add(paramArrayOfByte);
      if ((this.mReportRetryEnable) && (this.mVideoApp != null) && (paramInt == 918))
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
        localObject2 = new ClientLogReport.ReportRecord(null);
        ((ClientLogReport.ReportRecord)localObject2).mUin = paramLong;
        ((ClientLogReport.ReportRecord)localObject2).mTopicId = paramInt;
        ((ClientLogReport.ReportRecord)localObject2).mLog = paramArrayOfByte;
        ((ClientLogReport.ReportRecord)localObject2).mTimestamp = System.currentTimeMillis();
        this.mReportRecordCache.put(Integer.valueOf(this.mSeqNo), localObject2);
        paramArrayOfByte = new ToServiceMsg(null, String.valueOf(paramLong), "CliLogSvc.UploadReq");
        paramArrayOfByte.putWupBuffer((byte[])localObject1);
        paramArrayOfByte.setNeedCallback(true);
        paramArrayOfByte.setTimeout(15000L);
        paramArrayOfByte.addAttribute("report_record_seq", Integer.valueOf(this.mSeqNo));
        paramArrayOfByte.addAttribute("report_record_is_retry", Boolean.valueOf(paramBoolean));
        this.mVideoApp.sendToService(paramArrayOfByte);
      }
      for (;;)
      {
        return 1;
        if (paramInt == 1)
        {
          localObject1 = "video_udpcheck_log";
          break;
        }
        if (paramInt == 2085)
        {
          localObject1 = "dc02085";
          break;
        }
        if (paramInt == 2207)
        {
          localObject1 = "dc02207";
          break;
        }
        if (paramInt != 5274) {
          break;
        }
        localObject1 = "dc05274";
        break;
        paramArrayOfByte = new com.tencent.av.video.jce.QQService.strupbuff();
        paramArrayOfByte.logstring = ((Map)localObject2);
        localObject1 = new UniPacket(true);
        ((UniPacket)localObject1).put("Data", paramArrayOfByte);
        paramArrayOfByte = ((UniPacket)localObject1).encode();
        if (QLog.isColorLevel()) {
          QLog.d("ClientLogReport", 2, String.format("sendLog without response length=%s wupBuf=%s", new Object[] { Integer.valueOf(paramArrayOfByte.length), Arrays.toString(paramArrayOfByte) }));
        }
        localObject1 = new ToServiceMsg(this.mMsfSub.getMsfServiceName(), String.valueOf(paramLong), "CliLogSvc.UploadReq");
        ((ToServiceMsg)localObject1).putWupBuffer(paramArrayOfByte);
        ((ToServiceMsg)localObject1).setNeedCallback(false);
        this.mMsfSub.sendMsg((ToServiceMsg)localObject1);
      }
      return 0;
    }
    catch (Throwable paramArrayOfByte)
    {
      QLog.e("ClientLogReport", 1, "callbackSendLog fail.", paramArrayOfByte);
    }
  }
  
  /* Error */
  private void writeToFile(File paramFile, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 303	java/io/FileOutputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 306	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   8: astore_3
    //   9: aload_3
    //   10: astore_1
    //   11: aload_3
    //   12: aload_2
    //   13: invokevirtual 309	java/io/FileOutputStream:write	([B)V
    //   16: aload_3
    //   17: astore_1
    //   18: aload_3
    //   19: invokevirtual 312	java/io/FileOutputStream:flush	()V
    //   22: aload_3
    //   23: ifnull +7 -> 30
    //   26: aload_3
    //   27: invokevirtual 315	java/io/FileOutputStream:close	()V
    //   30: return
    //   31: astore 4
    //   33: aconst_null
    //   34: astore_2
    //   35: aload_2
    //   36: astore_1
    //   37: ldc 44
    //   39: iconst_1
    //   40: ldc_w 317
    //   43: aload 4
    //   45: invokestatic 87	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   48: aload_2
    //   49: ifnull -19 -> 30
    //   52: aload_2
    //   53: invokevirtual 315	java/io/FileOutputStream:close	()V
    //   56: return
    //   57: astore_1
    //   58: return
    //   59: astore_2
    //   60: aconst_null
    //   61: astore_1
    //   62: aload_1
    //   63: ifnull +7 -> 70
    //   66: aload_1
    //   67: invokevirtual 315	java/io/FileOutputStream:close	()V
    //   70: aload_2
    //   71: athrow
    //   72: astore_1
    //   73: return
    //   74: astore_1
    //   75: goto -5 -> 70
    //   78: astore_2
    //   79: goto -17 -> 62
    //   82: astore 4
    //   84: aload_3
    //   85: astore_2
    //   86: goto -51 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	ClientLogReport
    //   0	89	1	paramFile	File
    //   0	89	2	paramArrayOfByte	byte[]
    //   8	77	3	localFileOutputStream	java.io.FileOutputStream
    //   31	13	4	localThrowable1	Throwable
    //   82	1	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	9	31	java/lang/Throwable
    //   52	56	57	java/lang/Throwable
    //   0	9	59	finally
    //   26	30	72	java/lang/Throwable
    //   66	70	74	java/lang/Throwable
    //   11	16	78	finally
    //   18	22	78	finally
    //   37	48	78	finally
    //   11	16	82	java/lang/Throwable
    //   18	22	82	java/lang/Throwable
  }
  
  public int callbackSendLog(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    QLog.d("ClientLogReport", 1, String.format("callbackSendLog sendUin=%s topicId=%s log=%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), paramArrayOfByte }));
    return sendLog(paramLong, paramInt, paramArrayOfByte, false);
  }
  
  public void checkLocalReportRecord()
  {
    QLog.d("ClientLogReport", 1, "checkLocalReportRecord");
    if (!this.mInit)
    {
      QLog.e("ClientLogReport", 1, "checkLocalReportRecord mInit is false.");
      return;
    }
    if (!bbfj.g(this.mContext))
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
    int i;
    boolean bool2;
    if ((paramIntent != null) && (paramFromServiceMsg != null))
    {
      paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
      i = ((Integer)paramIntent.getAttribute("report_record_seq")).intValue();
      boolean bool1 = ((Boolean)paramIntent.getAttribute("report_record_is_retry")).booleanValue();
      bool2 = paramFromServiceMsg.isSuccess();
      paramIntent = (ClientLogReport.ReportRecord)this.mReportRecordCache.get(Integer.valueOf(i));
      QLog.d("ClientLogReport", 1, String.format("handleServerResp seq=%s isRetry=%s success=%s record=%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramIntent }));
      if (paramIntent != null)
      {
        if (!bool1) {
          break label173;
        }
        ldy.a(bool2);
      }
    }
    for (;;)
    {
      this.mReportRecordCache.remove(Integer.valueOf(i));
      return;
      label173:
      if (!bool2)
      {
        paramFromServiceMsg = new File(REPORT_FAIL_LOG_DIR);
        if (!paramFromServiceMsg.exists()) {
          paramFromServiceMsg.mkdirs();
        }
        paramIntent.writeToFile(new File(REPORT_FAIL_LOG_DIR, String.valueOf(paramIntent.mTimestamp)));
        ldy.c();
      }
    }
  }
  
  public void init(Context paramContext, int paramInt)
  {
    if (this.mNativeInit)
    {
      this.mContext = paramContext;
      this.mAppId = paramInt;
      this.mMsfSub = MsfServiceSdk.get();
      if (mnm.a().q != 1) {
        break label73;
      }
    }
    label73:
    for (boolean bool = true;; bool = false)
    {
      this.mReportRetryEnable = bool;
      this.mInit = true;
      QLog.d("ClientLogReport", 1, String.format("init mReportRetryEnable=%s", new Object[] { Boolean.valueOf(this.mReportRetryEnable) }));
      return;
    }
  }
  
  public void setVideoAppInterface(VideoAppInterface paramVideoAppInterface)
  {
    this.mVideoApp = paramVideoAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.video.call.ClientLogReport
 * JD-Core Version:    0.7.0.1
 */