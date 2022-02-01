package com.tencent.hotpatch;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hotpatch.config.PatchConfig;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.net.patch.PatchChecker;
import com.tencent.mobileqq.msf.core.net.patch.PatchCommonUtil;
import com.tencent.mobileqq.msf.core.net.patch.PatchReporter;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import com.tencent.qqperf.monitor.crash.safemode.SafeModeUtil;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class PatchDownloadManager
  implements Handler.Callback, INetEngineListener, Manager
{
  private ConcurrentHashMap<String, NetReq> a = new ConcurrentHashMap();
  private QQAppInterface b;
  private Handler c;
  
  public PatchDownloadManager(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
    this.c = new Handler(ThreadManager.getFileThreadLooper(), this);
  }
  
  /* Error */
  private void a(PatchConfig paramPatchConfig)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 51	com/tencent/hotpatch/config/PatchConfig:b	()Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: aload_1
    //   9: invokevirtual 55	com/tencent/hotpatch/config/PatchConfig:e	()Ljava/lang/String;
    //   12: invokestatic 61	com/tencent/mobileqq/msf/core/net/patch/PatchCommonUtil:getPatchPath	(Ljava/lang/String;)Ljava/lang/String;
    //   15: astore_2
    //   16: new 63	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   23: astore_3
    //   24: aload_3
    //   25: aload_1
    //   26: invokevirtual 68	com/tencent/hotpatch/config/PatchConfig:d	()I
    //   29: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_3
    //   34: ldc 74
    //   36: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_2
    //   41: aload_3
    //   42: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 61	com/tencent/mobileqq/msf/core/net/patch/PatchCommonUtil:getPatchPath	(Ljava/lang/String;)Ljava/lang/String;
    //   48: invokestatic 86	com/tencent/mobileqq/qfix/Relax:unzipRelaxConfig	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: return
    //   52: astore_1
    //   53: goto +9 -> 62
    //   56: astore_1
    //   57: aload_1
    //   58: invokevirtual 89	java/lang/Throwable:printStackTrace	()V
    //   61: return
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	PatchDownloadManager
    //   0	64	1	paramPatchConfig	PatchConfig
    //   15	26	2	str	String
    //   23	19	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   8	51	52	finally
    //   57	61	52	finally
    //   8	51	56	java/lang/Throwable
  }
  
  private void a(NetResp paramNetResp)
  {
    Object localObject1 = (PatchDownloadManager.PatchRequestData)paramNetResp.mReq.getUserData();
    long l1;
    long l2;
    Object localObject3;
    String str;
    int i;
    Object localObject2;
    Object localObject4;
    if ((localObject1 != null) && (((PatchDownloadManager.PatchRequestData)localObject1).d != null))
    {
      if (paramNetResp.mResult == 3)
      {
        QLog.d("PatchLogTag", 1, "PatchDownloadManager doOnResp is downloading");
        return;
      }
      l1 = SystemClock.elapsedRealtime();
      l2 = ((PatchDownloadManager.PatchRequestData)localObject1).b;
      localObject3 = ((PatchDownloadManager.PatchRequestData)localObject1).d.e();
      str = ((PatchDownloadManager.PatchRequestData)localObject1).d.f();
      i = ((PatchDownloadManager.PatchRequestData)localObject1).d.h();
      localObject2 = new StringBuilder("PatchDownloadManager doOnResp reslut=");
      ((StringBuilder)localObject2).append(paramNetResp.mResult);
      ((StringBuilder)localObject2).append(", mTotalFileLen=");
      ((StringBuilder)localObject2).append(paramNetResp.mTotalFileLen);
      ((StringBuilder)localObject2).append(", downloadPatchSize=");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(", cost time=");
      ((StringBuilder)localObject2).append(l1 - l2);
      QLog.d("PatchLogTag", 1, ((StringBuilder)localObject2).toString());
      localObject2 = PatchCommonUtil.getPatchPath(str);
      localObject4 = PatchCommonUtil.getPatchPath((String)localObject3);
    }
    label745:
    label751:
    for (;;)
    {
      try
      {
        if (paramNetResp.mResult != 0) {
          break label751;
        }
        if (paramNetResp.mTotalFileLen == i)
        {
          if ((((PatchDownloadManager.PatchRequestData)localObject1).d.b()) || (!PatchCommonUtil.isArtGeN())) {
            break label745;
          }
          bool1 = PatchFileManager.a(((PatchDownloadManager.PatchRequestData)localObject1).d);
          boolean bool2 = bool1;
          if (bool1) {
            bool2 = PatchChecker.checkPatchValid(((PatchDownloadManager.PatchRequestData)localObject1).c, (String)localObject3);
          }
          if (bool2)
          {
            a(((PatchDownloadManager.PatchRequestData)localObject1).d);
            SafeModeUtil.c();
            SafeModeUtil.a(HardCodeUtil.a(2131905723));
            new DexClassLoader((String)localObject4, BaseApplicationImpl.sApplication.getDir("dex", 0).getAbsolutePath(), (String)localObject4, BaseApplicationImpl.sApplication.getClassLoader());
          }
          else
          {
            paramNetResp = new File((String)localObject4);
            if (paramNetResp.exists()) {
              paramNetResp.delete();
            }
          }
          PatchReporter.reportPatchEvent(BaseApplicationImpl.sApplication, this.b.getCurrentAccountUin(), "actPatchDownload", 200, str);
        }
        else
        {
          if (paramNetResp.mResult != 0)
          {
            localObject3 = new StringBuilder("PatchDownloadManager doOnResp NOT ResultOk mErrCode=");
            ((StringBuilder)localObject3).append(paramNetResp.mErrCode);
            ((StringBuilder)localObject3).append(", mErrDesc=");
            ((StringBuilder)localObject3).append(paramNetResp.mErrDesc);
            localObject3 = ((StringBuilder)localObject3).toString();
            QLog.d("PatchLogTag", 1, (String)localObject3);
            localObject4 = BaseApplicationImpl.sApplication.getSharedPreferences("hotpatch_preference", 4);
            l1 = ((SharedPreferences)localObject4).getLong("patch_download_fail_report_time", 0L);
            l2 = System.currentTimeMillis();
            if (l2 - l1 > 21600000L)
            {
              CaughtExceptionReport.a(new RuntimeException(), (String)localObject3);
              ((SharedPreferences)localObject4).edit().putLong("patch_download_fail_report_time", l2).commit();
            }
            if ((paramNetResp.mErrCode == 9039) || (paramNetResp.mErrCode == 9301))
            {
              paramNetResp = new File(paramNetResp.mReq.mTempPath);
              localObject3 = new StringBuilder("write temp patch fail path=");
              ((StringBuilder)localObject3).append(paramNetResp.getAbsolutePath());
              ((StringBuilder)localObject3).append(", isExist=");
              ((StringBuilder)localObject3).append(paramNetResp.exists());
              ((StringBuilder)localObject3).append(", canWrite=");
              ((StringBuilder)localObject3).append(paramNetResp.canWrite());
              QLog.d("PatchLogTag", 1, ((StringBuilder)localObject3).toString());
            }
          }
          if (((PatchDownloadManager.PatchRequestData)localObject1).a < 3)
          {
            a(((PatchDownloadManager.PatchRequestData)localObject1).a, ((PatchDownloadManager.PatchRequestData)localObject1).c, ((PatchDownloadManager.PatchRequestData)localObject1).d);
            return;
          }
          SafeModeUtil.c();
          paramNetResp = new File((String)localObject2);
          if (paramNetResp.exists()) {
            paramNetResp.delete();
          }
          PatchReporter.reportPatchEvent(BaseApplicationImpl.sApplication, this.b.getCurrentAccountUin(), "actPatchDownload", 201, str);
        }
        this.a.remove(str);
        return;
      }
      catch (Throwable paramNetResp)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("PatchDownloadManager doOnResp throwable=");
        ((StringBuilder)localObject1).append(paramNetResp);
        QLog.d("PatchLogTag", 1, ((StringBuilder)localObject1).toString());
        PatchReporter.reportPatchEvent(BaseApplicationImpl.sApplication, this.b.getCurrentAccountUin(), "actPatchDownload", 202, str);
        return;
      }
      QLog.d("PatchLogTag", 1, "PatchDownloadManager doOnResp requestData is null");
      return;
      boolean bool1 = true;
    }
  }
  
  public void a(int paramInt, String paramString, PatchConfig paramPatchConfig)
  {
    String str1 = paramPatchConfig.i();
    String str2 = paramPatchConfig.f();
    Object localObject = new StringBuilder("PatchDownloadManager tryDownloadPatch retryCount=");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", downloadPatchName=");
    ((StringBuilder)localObject).append(str2);
    ((StringBuilder)localObject).append(", downloadUrl=");
    ((StringBuilder)localObject).append(str1);
    QLog.d("PatchLogTag", 1, ((StringBuilder)localObject).toString());
    if ((paramInt < 3) && (this.a.contains(str2))) {
      return;
    }
    localObject = (IHttpEngineService)this.b.getRuntimeService(IHttpEngineService.class, "all");
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = this;
    localHttpNetReq.mSupportBreakResume = true;
    localHttpNetReq.mReqUrl = str1;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = PatchCommonUtil.getPatchPath(str2);
    localHttpNetReq.setUserData(new PatchDownloadManager.PatchRequestData(this, paramInt + 1, SystemClock.elapsedRealtime(), paramString, paramPatchConfig));
    this.a.put(str2, localHttpNetReq);
    ((IHttpEngineService)localObject).sendReq(localHttpNetReq);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i == 2)
      {
        StringBuilder localStringBuilder = new StringBuilder("PatchDownloadManager patch download on progress curOffset=");
        localStringBuilder.append(paramMessage.arg1);
        localStringBuilder.append(", totalLen=");
        localStringBuilder.append(paramMessage.arg2);
        QLog.d("PatchLogTag", 1, localStringBuilder.toString());
      }
    }
    else {
      a((NetResp)paramMessage.obj);
    }
    return false;
  }
  
  public void onDestroy()
  {
    Handler localHandler = this.c;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.c = null;
    }
  }
  
  public void onResp(NetResp paramNetResp)
  {
    Handler localHandler = this.c;
    if (localHandler != null) {
      localHandler.obtainMessage(1, paramNetResp).sendToTarget();
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    this.c.obtainMessage(2, (int)paramLong1, (int)paramLong2, paramNetReq).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hotpatch.PatchDownloadManager
 * JD-Core Version:    0.7.0.1
 */