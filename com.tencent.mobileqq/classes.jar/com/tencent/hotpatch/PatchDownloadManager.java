package com.tencent.hotpatch;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hotpatch.config.PatchConfig;
import com.tencent.hotpatch.utils.PatchCommonUtil;
import com.tencent.hotpatch.utils.PatchReporter;
import com.tencent.mobileqq.app.InjectUtils;
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
import qse;

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
    qse localqse = (qse)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.a();
    if ((localqse == null) || (localqse.jdField_a_of_type_ComTencentHotpatchConfigPatchConfig == null))
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
    long l2 = localqse.jdField_a_of_type_Long;
    Object localObject1 = localqse.jdField_a_of_type_ComTencentHotpatchConfigPatchConfig.b();
    String str1 = localqse.jdField_a_of_type_ComTencentHotpatchConfigPatchConfig.c();
    int i = localqse.jdField_a_of_type_ComTencentHotpatchConfigPatchConfig.c();
    QLog.d("PatchLogTag", 1, "PatchDownloadManager doOnResp reslut=" + paramNetResp.jdField_a_of_type_Int + ", mTotalFileLen=" + paramNetResp.jdField_a_of_type_Long + ", downloadPatchSize=" + i + ", cost time=" + (l1 - l2));
    String str2 = PatchCommonUtil.a(str1);
    Object localObject2 = PatchCommonUtil.a((String)localObject1);
    label865:
    for (;;)
    {
      try
      {
        if ((paramNetResp.jdField_a_of_type_Int != 0) || (paramNetResp.jdField_a_of_type_Long != i)) {
          break label356;
        }
        boolean bool = true;
        if (PatchCommonUtil.c()) {
          bool = PatchFileManager.a(localqse.jdField_a_of_type_ComTencentHotpatchConfigPatchConfig);
        }
        if (!bool) {
          break label865;
        }
        bool = PatchChecker.a(localqse.jdField_a_of_type_JavaLangString, (String)localObject1);
        if (bool)
        {
          new DexClassLoader((String)localObject2, BaseApplicationImpl.sApplication.getDir("dex", 0).getAbsolutePath(), (String)localObject2, BaseApplicationImpl.sApplication.getClassLoader());
          PatchReporter.a(BaseApplicationImpl.sApplication, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actPatchDownload", 200, str1);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str1);
          return;
        }
      }
      catch (Throwable paramNetResp)
      {
        QLog.d("PatchLogTag", 1, "PatchDownloadManager doOnResp throwable=" + paramNetResp);
        PatchReporter.a(BaseApplicationImpl.sApplication, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actPatchDownload", 202, str1);
        return;
      }
      paramNetResp = new File((String)localObject2);
      if (paramNetResp.exists())
      {
        paramNetResp.delete();
        continue;
        label356:
        if (paramNetResp.jdField_a_of_type_Int != 0)
        {
          localObject1 = "PatchDownloadManager doOnResp NOT ResultOk mErrCode=" + paramNetResp.b + ", mErrDesc=" + paramNetResp.jdField_a_of_type_JavaLangString;
          QLog.d("PatchLogTag", 1, (String)localObject1);
          localObject2 = BaseApplicationImpl.sApplication.getSharedPreferences("hotpatch_preference", 0);
          l1 = ((SharedPreferences)localObject2).getLong("patch_download_fail_report_time", 0L);
          l2 = System.currentTimeMillis();
          if (l2 - l1 > 86400000L)
          {
            QQCatchedExceptionReporter.reportQQCatchedException(new RuntimeException(), "PatchDownloadCatchedException", (String)localObject1);
            ((SharedPreferences)localObject2).edit().putLong("patch_download_fail_report_time", l2).commit();
          }
          if ((paramNetResp.b == 9039) || (paramNetResp.b == 9301))
          {
            localObject1 = InjectUtils.getTotalInternalMemorySize();
            QLog.d("PatchLogTag", 1, "write temp patch fail totalInternalSize=" + localObject1[1] + ", availableInternalSize=" + localObject1[0] + ", fileDir=" + BaseApplicationImpl.sApplication.getFilesDir().getAbsolutePath());
            paramNetResp = new File(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.d);
            try
            {
              QLog.d("PatchLogTag", 1, "write temp patch fail path=" + paramNetResp.getAbsolutePath() + ", isExist=" + paramNetResp.exists() + ", canWrite=" + paramNetResp.canWrite());
              paramNetResp.delete();
              paramNetResp = new File(PatchCommonUtil.a("")).listFiles();
              if (paramNetResp != null)
              {
                int j = paramNetResp.length;
                i = 0;
                if (i < j)
                {
                  localObject1 = paramNetResp[i];
                  if (localObject1 == null) {}
                }
              }
            }
            catch (Exception paramNetResp)
            {
              try
              {
                for (;;)
                {
                  QLog.d("PatchLogTag", 1, "clear patch dir file=" + ((File)localObject1).getAbsolutePath() + ", canWrite=" + ((File)localObject1).canWrite());
                  ((File)localObject1).delete();
                  i += 1;
                }
                paramNetResp = paramNetResp;
                QLog.d("PatchLogTag", 1, "delete temp patch exception=" + paramNetResp);
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  QLog.d("PatchLogTag", 1, "clear patch dir exception=" + localException);
                }
              }
            }
          }
        }
        if (localqse.jdField_a_of_type_Int < 3)
        {
          a(localqse.jdField_a_of_type_Int, localqse.jdField_a_of_type_JavaLangString, localqse.jdField_a_of_type_ComTencentHotpatchConfigPatchConfig);
          return;
        }
        paramNetResp = new File(str2);
        if (paramNetResp.exists()) {
          paramNetResp.delete();
        }
        PatchReporter.a(BaseApplicationImpl.sApplication, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actPatchDownload", 201, str1);
      }
    }
  }
  
  public void a(int paramInt, String paramString, PatchConfig paramPatchConfig)
  {
    String str1 = paramPatchConfig.d();
    String str2 = paramPatchConfig.c();
    QLog.d("PatchLogTag", 1, "PatchDownloadManager tryDownloadPatch retryCount=" + paramInt + ", downloadPatchName=" + str2 + ", downloadUrl=" + str1);
    if ((paramInt < 3) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.contains(str2))) {
      return;
    }
    INetEngine localINetEngine = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0);
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = this;
    localHttpNetReq.jdField_a_of_type_JavaLangString = str1;
    localHttpNetReq.jdField_a_of_type_Int = 0;
    localHttpNetReq.c = PatchCommonUtil.a(str2);
    localHttpNetReq.a(new qse(this, paramInt + 1, SystemClock.elapsedRealtime(), paramString, paramPatchConfig));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str2, localHttpNetReq);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.hotpatch.PatchDownloadManager
 * JD-Core Version:    0.7.0.1
 */