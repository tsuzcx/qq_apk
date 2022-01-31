package com.tencent.hotpatch;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hotpatch.config.BasePatchConfig;
import com.tencent.hotpatch.config.DexPatchConfigArtAfterN;
import com.tencent.hotpatch.utils.PatchCommonUtil;
import com.tencent.hotpatch.utils.PatchReporter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.QQCatchedExceptionReporter;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import qnn;

public class PatchDownloadManager
  implements Handler.Callback, INetEngine.IBreakDownFix, INetEngine.INetEngineListener, Manager
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public PatchDownloadManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private void b(NetResp paramNetResp)
  {
    qnn localqnn = (qnn)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.a();
    if ((localqnn == null) || (localqnn.jdField_a_of_type_ComTencentHotpatchConfigBasePatchConfig == null))
    {
      QLog.d("PatchLogTag", 1, "PatchDownloadManager doOnResp requestData is null");
      return;
    }
    if (paramNetResp.jdField_a_of_type_Int == 3)
    {
      QLog.d("PatchLogTag", 1, "PatchDownloadManager doOnResp is downloading");
      return;
    }
    long l1 = SystemClock.elapsedRealtime();
    long l2 = localqnn.jdField_a_of_type_Long;
    String str1;
    int i;
    label115:
    String str2;
    String str3;
    if (PatchCommonUtil.c())
    {
      str1 = "androidN7z_" + localqnn.jdField_a_of_type_ComTencentHotpatchConfigBasePatchConfig.c;
      if (!PatchCommonUtil.c()) {
        break label392;
      }
      i = ((DexPatchConfigArtAfterN)localqnn.jdField_a_of_type_ComTencentHotpatchConfigBasePatchConfig).c;
      QLog.d("PatchLogTag", 1, "PatchDownloadManager doOnResp reslut=" + paramNetResp.jdField_a_of_type_Int + ", mTotalFileLen=" + paramNetResp.jdField_a_of_type_Long + ", downloadPatchSize=" + i + ", cost time=" + (l1 - l2));
      str2 = PatchCommonUtil.a(localqnn.jdField_a_of_type_JavaLangString, str1);
      str3 = PatchCommonUtil.a(localqnn.jdField_a_of_type_JavaLangString, localqnn.jdField_a_of_type_ComTencentHotpatchConfigBasePatchConfig.c);
    }
    for (;;)
    {
      try
      {
        if ((paramNetResp.jdField_a_of_type_Int != 0) || (paramNetResp.jdField_a_of_type_Long != i)) {
          break label429;
        }
        boolean bool = true;
        if (PatchCommonUtil.c()) {
          bool = PatchFileManager.a((DexPatchConfigArtAfterN)localqnn.jdField_a_of_type_ComTencentHotpatchConfigBasePatchConfig);
        }
        if (!bool) {
          break label701;
        }
        bool = PatchChecker.a(localqnn.jdField_a_of_type_JavaLangString, localqnn.jdField_a_of_type_ComTencentHotpatchConfigBasePatchConfig.c);
        if (!bool) {
          break label404;
        }
        new DexClassLoader(str3, BaseApplicationImpl.sApplication.getDir("dex", 0).getAbsolutePath(), str3, BaseApplicationImpl.sApplication.getClassLoader());
        PatchReporter.a(BaseApplicationImpl.sApplication, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actPatchDownload", 200, str1);
        label321:
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str1);
        return;
      }
      catch (Throwable paramNetResp)
      {
        QLog.d("PatchLogTag", 1, "PatchDownloadManager doOnResp throwable=" + paramNetResp);
        PatchReporter.a(BaseApplicationImpl.sApplication, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actPatchDownload", 202, str1);
        return;
      }
      str1 = localqnn.jdField_a_of_type_ComTencentHotpatchConfigBasePatchConfig.c;
      break;
      label392:
      i = localqnn.jdField_a_of_type_ComTencentHotpatchConfigBasePatchConfig.b;
      break label115;
      label404:
      paramNetResp = new File(str3);
      if (paramNetResp.exists()) {
        paramNetResp.delete();
      }
    }
    label429:
    int j;
    if (paramNetResp.jdField_a_of_type_Int != 0)
    {
      str3 = "PatchDownloadManager doOnResp NOT ResultOk mErrCode=" + paramNetResp.b + ", mErrDesc=" + paramNetResp.jdField_a_of_type_JavaLangString;
      QLog.d("PatchLogTag", 1, str3);
      SharedPreferences localSharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("hotpatch_preference", 0);
      l1 = localSharedPreferences.getLong("patch_download_fail_report_time", 0L);
      l2 = System.currentTimeMillis();
      if (l2 - l1 > 21600000L)
      {
        QQCatchedExceptionReporter.reportQQCatchedException(new RuntimeException(), "PatchDownloadCatchedException", str3);
        localSharedPreferences.edit().putLong("patch_download_fail_report_time", l2).commit();
      }
      if ((paramNetResp.b == 9039) || (paramNetResp.b == 9040))
      {
        paramNetResp = new File(PatchCommonUtil.a(localqnn.jdField_a_of_type_JavaLangString, "")).listFiles();
        if (paramNetResp != null)
        {
          j = paramNetResp.length;
          i = 0;
        }
      }
    }
    for (;;)
    {
      if (i < j)
      {
        str3 = paramNetResp[i];
        if (str3 != null) {
          str3.delete();
        }
      }
      else
      {
        if (localqnn.jdField_a_of_type_Int < 3)
        {
          a(localqnn.jdField_a_of_type_Int, localqnn.jdField_a_of_type_JavaLangString, localqnn.jdField_a_of_type_ComTencentHotpatchConfigBasePatchConfig);
          return;
        }
        paramNetResp = new File(str2);
        if (paramNetResp.exists()) {
          paramNetResp.delete();
        }
        PatchReporter.a(BaseApplicationImpl.sApplication, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actPatchDownload", 201, str1);
        break label321;
        label701:
        break;
      }
      i += 1;
    }
  }
  
  public void a(int paramInt, String paramString, BasePatchConfig paramBasePatchConfig)
  {
    if (PatchCommonUtil.c()) {}
    for (String str = "androidN7z_" + paramBasePatchConfig.c;; str = paramBasePatchConfig.c)
    {
      QLog.d("PatchLogTag", 1, "PatchDownloadManager tryDownloadPatch retryCount=" + paramInt + ", downloadPatchName=" + str + ", downloadUrl=" + paramBasePatchConfig.d);
      if ((paramInt >= 3) || (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.contains(str))) {
        break;
      }
      return;
    }
    INetEngine localINetEngine = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0);
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = this;
    localHttpNetReq.jdField_a_of_type_JavaLangString = paramBasePatchConfig.d;
    localHttpNetReq.jdField_a_of_type_Int = 0;
    localHttpNetReq.c = PatchCommonUtil.a(paramString, str);
    localHttpNetReq.a(new qnn(this, paramInt + 1, SystemClock.elapsedRealtime(), paramString, paramBasePatchConfig));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localHttpNetReq);
    localINetEngine.a(localHttpNetReq);
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, (int)paramLong1, (int)paramLong2, paramNetReq).sendToTarget();
  }
  
  public void a(NetReq paramNetReq, NetResp paramNetResp)
  {
    if ((paramNetReq == null) || (paramNetResp == null)) {}
    while (!(paramNetReq instanceof HttpNetReq)) {
      return;
    }
    paramNetReq = (HttpNetReq)paramNetReq;
    paramNetReq.jdField_a_of_type_Long += paramNetResp.c;
    paramNetResp.c = 0L;
    paramNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + paramNetReq.jdField_a_of_type_Long + "-");
  }
  
  public void a(NetResp paramNetResp)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, paramNetResp).sendToTarget();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      b((NetResp)paramMessage.obj);
      continue;
      QLog.d("PatchLogTag", 1, "PatchDownloadManager patch download on progress curOffset=" + paramMessage.arg1 + ", totalLen=" + paramMessage.arg2);
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.hotpatch.PatchDownloadManager
 * JD-Core Version:    0.7.0.1
 */