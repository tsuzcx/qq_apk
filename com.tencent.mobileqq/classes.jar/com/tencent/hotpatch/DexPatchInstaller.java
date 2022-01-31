package com.tencent.hotpatch;

import android.content.Context;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hotpatch.config.PatchConfig;
import com.tencent.hotpatch.config.PatchConfigManager;
import com.tencent.hotpatch.utils.PatchCommonUtil;
import com.tencent.hotpatch.utils.PatchReporter;
import com.tencent.hotpatch.utils.PatchSharedPreUtil;
import com.tencent.mobileqq.app.SystemClassLoaderInjector;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import qsd;

public class DexPatchInstaller
{
  public static int a;
  public static String a;
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_JavaLangString = "";
  }
  
  public static void a(Context paramContext)
  {
    long l = System.currentTimeMillis();
    PatchConfig localPatchConfig = PatchConfigManager.a(paramContext, "dex");
    if ((jdField_a_of_type_Int == 0) && (a(paramContext, localPatchConfig)))
    {
      a(localPatchConfig);
      if ((500 == jdField_a_of_type_Int) && (PatchCommonUtil.a())) {
        PatchResolveForDalvik.a(paramContext, localPatchConfig);
      }
      a(paramContext, localPatchConfig);
      PatchReporter.a(paramContext, "", "actPatchInstall", jdField_a_of_type_Int, localPatchConfig.b());
      QLog.d("PatchLogTag", 1, "DexPatchInstaller installDexPatch total cost time=" + (System.currentTimeMillis() - l) + " ms.");
      return;
    }
    QLog.d("PatchLogTag", 1, "DexPatchInstaller installDexPatch Not inject patch, status=" + jdField_a_of_type_Int);
  }
  
  private static void a(Context paramContext, PatchConfig paramPatchConfig)
  {
    paramContext = new qsd(paramPatchConfig, paramContext);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.post(paramContext, 5, null, true);
      return;
    }
    paramContext.run();
  }
  
  private static void a(PatchConfig paramPatchConfig)
  {
    long l = System.currentTimeMillis();
    try
    {
      paramPatchConfig = paramPatchConfig.b();
      String str = PatchCommonUtil.a(paramPatchConfig);
      if ("Success".equals(SystemClassLoaderInjector.a(BaseApplicationImpl.sApplication, str, null, false)))
      {
        jdField_a_of_type_Int = 500;
        jdField_a_of_type_JavaLangString = paramPatchConfig;
      }
      for (;;)
      {
        QLog.d("PatchLogTag", 1, "DexPatchInstaller injectDexPatch result=" + jdField_a_of_type_Int + ", inject cost time=" + (System.currentTimeMillis() - l) + " ms.");
        return;
        jdField_a_of_type_Int = 501;
      }
    }
    catch (Throwable paramPatchConfig)
    {
      for (;;)
      {
        jdField_a_of_type_Int = 502;
        QLog.d("PatchLogTag", 1, "DexPatchInstaller injectDexPatch throwable=" + paramPatchConfig);
      }
    }
  }
  
  private static boolean a(Context paramContext, PatchConfig paramPatchConfig)
  {
    if (paramPatchConfig == null) {
      QLog.d("PatchLogTag", 1, "DexPatchInstaller checkDexPatchConfigAndStatus patch config is null");
    }
    while (!paramPatchConfig.a(paramContext, true)) {
      return false;
    }
    String str = paramPatchConfig.b();
    File localFile = new File(PatchCommonUtil.a(str));
    if (!localFile.exists())
    {
      QLog.d("PatchLogTag", 1, "DexPatchInstaller checkDexPatchConfigAndStatus patch file not exist");
      return false;
    }
    if (localFile.length() != paramPatchConfig.b())
    {
      QLog.d("PatchLogTag", 1, "DexPatchInstaller checkDexPatchConfigAndStatus patch file length not match");
      return false;
    }
    if (!PatchSharedPreUtil.a(paramContext, str))
    {
      QLog.d("PatchLogTag", 1, "DexPatchInstaller checkDexPatchConfigAndStatus verify failed");
      return false;
    }
    if (PatchSharedPreUtil.a(paramContext, BaseApplicationImpl.processName, str) >= 3)
    {
      QLog.d("PatchLogTag", 1, "DexPatchInstaller checkDexPatchConfigAndStatus install patch failed max count");
      return false;
    }
    if (PatchSharedPreUtil.b(paramContext, BaseApplicationImpl.processName, str) > 5)
    {
      jdField_a_of_type_Int = 503;
      PatchReporter.a(paramContext, "", "actPatchInstall", 503, str);
      QLog.d("PatchLogTag", 1, "DexPatchInstaller checkDexPatchConfigAndStatus start failed max count as install patch");
      return false;
    }
    QLog.d("PatchLogTag", 1, "DexPatchInstaller checkDexPatchConfigAndStatus return true");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.hotpatch.DexPatchInstaller
 * JD-Core Version:    0.7.0.1
 */