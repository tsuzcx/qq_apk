package com.tencent.hotpatch;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hotpatch.config.PatchConfig;
import com.tencent.hotpatch.config.PatchConfigManager;
import com.tencent.kingkong.UpdateManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.msf.core.net.patch.PatchChecker;
import com.tencent.mobileqq.msf.core.net.patch.PatchCommonUtil;
import com.tencent.mobileqq.msf.core.net.patch.PatchReporter;
import com.tencent.mobileqq.vas.LzmaUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.safemode.SafeModeUtil;
import java.io.File;

public class PatchFileManager
{
  private static void a()
  {
    PatchConfig localPatchConfig = PatchConfigManager.a(BaseApplicationImpl.sApplication, "Native");
    if (localPatchConfig != null) {
      UpdateManager.a(localPatchConfig.e());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    b(paramQQAppInterface);
    a();
  }
  
  public static boolean a(PatchConfig paramPatchConfig)
  {
    String str1 = paramPatchConfig.c();
    Object localObject = PatchCommonUtil.getPatchPath(str1);
    String str2 = PatchCommonUtil.getPatchPath("");
    int j = 701;
    int i;
    try
    {
      i = LzmaUtils.a(BaseApplicationImpl.sApplication, (String)localObject, str2);
      if (i == 0) {
        i = 700;
      } else {
        i = 701;
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PatchFileManager un7zNPatchFile throwable=");
      localStringBuilder.append(localThrowable);
      QLog.d("PatchLogTag", 1, localStringBuilder.toString());
      i = 702;
    }
    localObject = new File((String)localObject);
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    if (700 == i)
    {
      localObject = new File(PatchCommonUtil.getPatchPath(paramPatchConfig.b()));
      if ((((File)localObject).exists()) && (((File)localObject).length() == paramPatchConfig.b()))
      {
        i = 700;
      }
      else
      {
        i = j;
        if (((File)localObject).exists())
        {
          i = 703;
          ((File)localObject).delete();
        }
      }
    }
    PatchReporter.reportPatchEvent(BaseApplicationImpl.sApplication, "", "actPatchUnzip", i, str1);
    return 700 == i;
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    PatchConfig localPatchConfig = PatchConfigManager.a(BaseApplicationImpl.sApplication, "dex");
    if ((localPatchConfig != null) && (localPatchConfig.a(BaseApplicationImpl.sApplication, null)))
    {
      String str = localPatchConfig.b();
      File localFile = new File(PatchCommonUtil.getPatchPath(str));
      boolean bool = localFile.exists();
      int j = 1;
      int i;
      if ((bool) && (localFile.length() == localPatchConfig.b()))
      {
        if (!PatchChecker.checkPatchValid("dex", str))
        {
          localFile.delete();
          i = j;
        }
        else
        {
          SafeModeUtil.c();
          i = 0;
        }
      }
      else
      {
        i = j;
        if (localFile.exists())
        {
          localFile.delete();
          i = j;
        }
      }
      if (i != 0) {
        ((PatchDownloadManager)paramQQAppInterface.getManager(QQManagerFactory.PATCH_DOWNLOAD_MANAGER)).a(0, "dex", localPatchConfig);
      }
    }
    else
    {
      SafeModeUtil.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hotpatch.PatchFileManager
 * JD-Core Version:    0.7.0.1
 */