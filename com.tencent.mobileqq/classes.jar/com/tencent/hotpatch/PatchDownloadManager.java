package com.tencent.hotpatch;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.zip.QZipFile;
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
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap<String, NetReq> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public PatchDownloadManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
  }
  
  static void a(QZipFile paramQZipFile, String paramString)
  {
    DexPatchInstaller.a(paramQZipFile.getInputStream(paramQZipFile.getEntry("classes.dex")), new File(paramString, "classes.dex"));
  }
  
  /* Error */
  private void a(PatchConfig paramPatchConfig)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 75	com/tencent/hotpatch/config/PatchConfig:b	()Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: aconst_null
    //   9: astore 4
    //   11: aconst_null
    //   12: astore_3
    //   13: aload_3
    //   14: astore_2
    //   15: aload_1
    //   16: invokevirtual 78	com/tencent/hotpatch/config/PatchConfig:b	()Ljava/lang/String;
    //   19: invokestatic 84	com/tencent/mobileqq/msf/core/net/patch/PatchCommonUtil:getPatchPath	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore 5
    //   24: aload_3
    //   25: astore_2
    //   26: new 46	com/tencent/commonsdk/zip/QZipFile
    //   29: dup
    //   30: aload 5
    //   32: invokespecial 87	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   35: astore_1
    //   36: new 56	java/io/File
    //   39: dup
    //   40: aload 5
    //   42: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: invokevirtual 91	java/io/File:getParent	()Ljava/lang/String;
    //   48: astore_2
    //   49: aload_1
    //   50: ldc 93
    //   52: invokevirtual 50	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   55: astore_3
    //   56: aload_1
    //   57: ldc 95
    //   59: invokevirtual 50	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   62: astore 4
    //   64: aload_1
    //   65: ldc 97
    //   67: invokevirtual 50	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   70: astore 5
    //   72: aload_3
    //   73: ifnull +77 -> 150
    //   76: aload 4
    //   78: ifnull +72 -> 150
    //   81: aload 5
    //   83: ifnull +67 -> 150
    //   86: ldc 99
    //   88: iconst_1
    //   89: ldc 101
    //   91: invokestatic 107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: aload_1
    //   95: aload_3
    //   96: invokevirtual 54	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   99: new 56	java/io/File
    //   102: dup
    //   103: aload_2
    //   104: ldc 93
    //   106: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: invokestatic 64	com/tencent/hotpatch/DexPatchInstaller:a	(Ljava/io/InputStream;Ljava/io/File;)V
    //   112: aload_1
    //   113: aload 4
    //   115: invokevirtual 54	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   118: new 56	java/io/File
    //   121: dup
    //   122: aload_2
    //   123: ldc 95
    //   125: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: invokestatic 64	com/tencent/hotpatch/DexPatchInstaller:a	(Ljava/io/InputStream;Ljava/io/File;)V
    //   131: aload_1
    //   132: aload 5
    //   134: invokevirtual 54	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   137: new 56	java/io/File
    //   140: dup
    //   141: aload_2
    //   142: ldc 97
    //   144: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   147: invokestatic 64	com/tencent/hotpatch/DexPatchInstaller:a	(Ljava/io/InputStream;Ljava/io/File;)V
    //   150: aload_1
    //   151: ldc 109
    //   153: invokevirtual 50	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   156: astore_3
    //   157: aload_3
    //   158: ifnull +62 -> 220
    //   161: ldc 99
    //   163: iconst_1
    //   164: ldc 111
    //   166: invokestatic 107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: new 56	java/io/File
    //   172: dup
    //   173: aload_2
    //   174: ldc 109
    //   176: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: astore 4
    //   181: aload 4
    //   183: invokevirtual 114	java/io/File:exists	()Z
    //   186: ifne +16 -> 202
    //   189: aload_1
    //   190: aload_3
    //   191: invokevirtual 54	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   194: aload 4
    //   196: invokestatic 64	com/tencent/hotpatch/DexPatchInstaller:a	(Ljava/io/InputStream;Ljava/io/File;)V
    //   199: goto +21 -> 220
    //   202: aload_1
    //   203: aload_3
    //   204: invokevirtual 54	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   207: new 56	java/io/File
    //   210: dup
    //   211: aload_2
    //   212: ldc 116
    //   214: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   217: invokestatic 64	com/tencent/hotpatch/DexPatchInstaller:a	(Ljava/io/InputStream;Ljava/io/File;)V
    //   220: invokestatic 118	com/tencent/hotpatch/DexPatchInstaller:a	()Z
    //   223: ifeq +8 -> 231
    //   226: aload_1
    //   227: aload_2
    //   228: invokestatic 120	com/tencent/hotpatch/PatchDownloadManager:a	(Lcom/tencent/commonsdk/zip/QZipFile;Ljava/lang/String;)V
    //   231: aload_1
    //   232: invokevirtual 123	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   235: return
    //   236: astore_2
    //   237: goto +40 -> 277
    //   240: astore_3
    //   241: goto +15 -> 256
    //   244: astore_3
    //   245: aload_2
    //   246: astore_1
    //   247: aload_3
    //   248: astore_2
    //   249: goto +28 -> 277
    //   252: astore_3
    //   253: aload 4
    //   255: astore_1
    //   256: aload_1
    //   257: astore_2
    //   258: aload_3
    //   259: invokevirtual 126	java/lang/Throwable:printStackTrace	()V
    //   262: aload_1
    //   263: ifnull +13 -> 276
    //   266: aload_1
    //   267: invokevirtual 123	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   270: return
    //   271: astore_1
    //   272: aload_1
    //   273: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   276: return
    //   277: aload_1
    //   278: ifnull +15 -> 293
    //   281: aload_1
    //   282: invokevirtual 123	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   285: goto +8 -> 293
    //   288: astore_1
    //   289: aload_1
    //   290: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   293: aload_2
    //   294: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	this	PatchDownloadManager
    //   0	295	1	paramPatchConfig	PatchConfig
    //   14	214	2	localObject1	Object
    //   236	10	2	localObject2	Object
    //   248	46	2	localObject3	Object
    //   12	192	3	localZipEntry	java.util.zip.ZipEntry
    //   240	1	3	localThrowable1	Throwable
    //   244	4	3	localObject4	Object
    //   252	7	3	localThrowable2	Throwable
    //   9	245	4	localObject5	Object
    //   22	111	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   36	72	236	finally
    //   86	150	236	finally
    //   150	157	236	finally
    //   161	199	236	finally
    //   202	220	236	finally
    //   220	231	236	finally
    //   36	72	240	java/lang/Throwable
    //   86	150	240	java/lang/Throwable
    //   150	157	240	java/lang/Throwable
    //   161	199	240	java/lang/Throwable
    //   202	220	240	java/lang/Throwable
    //   220	231	240	java/lang/Throwable
    //   15	24	244	finally
    //   26	36	244	finally
    //   258	262	244	finally
    //   15	24	252	java/lang/Throwable
    //   26	36	252	java/lang/Throwable
    //   231	235	271	java/io/IOException
    //   266	270	271	java/io/IOException
    //   281	285	288	java/io/IOException
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
    if ((localObject1 != null) && (((PatchDownloadManager.PatchRequestData)localObject1).jdField_a_of_type_ComTencentHotpatchConfigPatchConfig != null))
    {
      if (paramNetResp.mResult == 3)
      {
        QLog.d("PatchLogTag", 1, "PatchDownloadManager doOnResp is downloading");
        return;
      }
      l1 = SystemClock.elapsedRealtime();
      l2 = ((PatchDownloadManager.PatchRequestData)localObject1).jdField_a_of_type_Long;
      localObject3 = ((PatchDownloadManager.PatchRequestData)localObject1).jdField_a_of_type_ComTencentHotpatchConfigPatchConfig.b();
      str = ((PatchDownloadManager.PatchRequestData)localObject1).jdField_a_of_type_ComTencentHotpatchConfigPatchConfig.c();
      i = ((PatchDownloadManager.PatchRequestData)localObject1).jdField_a_of_type_ComTencentHotpatchConfigPatchConfig.c();
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
    label753:
    label759:
    for (;;)
    {
      try
      {
        if (paramNetResp.mResult != 0) {
          break label759;
        }
        if (paramNetResp.mTotalFileLen == i)
        {
          if ((((PatchDownloadManager.PatchRequestData)localObject1).jdField_a_of_type_ComTencentHotpatchConfigPatchConfig.b()) || (!PatchCommonUtil.isArtGeN())) {
            break label753;
          }
          bool1 = PatchFileManager.a(((PatchDownloadManager.PatchRequestData)localObject1).jdField_a_of_type_ComTencentHotpatchConfigPatchConfig);
          boolean bool2 = bool1;
          if (bool1) {
            bool2 = PatchChecker.checkPatchValid(((PatchDownloadManager.PatchRequestData)localObject1).jdField_a_of_type_JavaLangString, (String)localObject3);
          }
          if (bool2)
          {
            a(((PatchDownloadManager.PatchRequestData)localObject1).jdField_a_of_type_ComTencentHotpatchConfigPatchConfig);
            SafeModeUtil.c();
            SafeModeUtil.a(HardCodeUtil.a(2131707909));
            new DexClassLoader((String)localObject4, BaseApplicationImpl.sApplication.getDir("dex", 0).getAbsolutePath(), (String)localObject4, BaseApplicationImpl.sApplication.getClassLoader());
          }
          else
          {
            paramNetResp = new File((String)localObject4);
            if (paramNetResp.exists()) {
              paramNetResp.delete();
            }
          }
          PatchReporter.reportPatchEvent(BaseApplicationImpl.sApplication, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actPatchDownload", 200, str);
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
          if (((PatchDownloadManager.PatchRequestData)localObject1).jdField_a_of_type_Int < 3)
          {
            a(((PatchDownloadManager.PatchRequestData)localObject1).jdField_a_of_type_Int, ((PatchDownloadManager.PatchRequestData)localObject1).jdField_a_of_type_JavaLangString, ((PatchDownloadManager.PatchRequestData)localObject1).jdField_a_of_type_ComTencentHotpatchConfigPatchConfig);
            return;
          }
          SafeModeUtil.c();
          paramNetResp = new File((String)localObject2);
          if (paramNetResp.exists()) {
            paramNetResp.delete();
          }
          PatchReporter.reportPatchEvent(BaseApplicationImpl.sApplication, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actPatchDownload", 201, str);
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
        return;
      }
      catch (Throwable paramNetResp)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("PatchDownloadManager doOnResp throwable=");
        ((StringBuilder)localObject1).append(paramNetResp);
        QLog.d("PatchLogTag", 1, ((StringBuilder)localObject1).toString());
        PatchReporter.reportPatchEvent(BaseApplicationImpl.sApplication, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actPatchDownload", 202, str);
        return;
      }
      QLog.d("PatchLogTag", 1, "PatchDownloadManager doOnResp requestData is null");
      return;
      boolean bool1 = true;
    }
  }
  
  public void a(int paramInt, String paramString, PatchConfig paramPatchConfig)
  {
    String str1 = paramPatchConfig.d();
    String str2 = paramPatchConfig.c();
    Object localObject = new StringBuilder("PatchDownloadManager tryDownloadPatch retryCount=");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", downloadPatchName=");
    ((StringBuilder)localObject).append(str2);
    ((StringBuilder)localObject).append(", downloadUrl=");
    ((StringBuilder)localObject).append(str1);
    QLog.d("PatchLogTag", 1, ((StringBuilder)localObject).toString());
    if ((paramInt < 3) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.contains(str2))) {
      return;
    }
    localObject = (IHttpEngineService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IHttpEngineService.class, "all");
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = this;
    localHttpNetReq.mSupportBreakResume = true;
    localHttpNetReq.mReqUrl = str1;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = PatchCommonUtil.getPatchPath(str2);
    localHttpNetReq.setUserData(new PatchDownloadManager.PatchRequestData(this, paramInt + 1, SystemClock.elapsedRealtime(), paramString, paramPatchConfig));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str2, localHttpNetReq);
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
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
  
  public void onResp(NetResp paramNetResp)
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.obtainMessage(1, paramNetResp).sendToTarget();
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, (int)paramLong1, (int)paramLong2, paramNetReq).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hotpatch.PatchDownloadManager
 * JD-Core Version:    0.7.0.1
 */