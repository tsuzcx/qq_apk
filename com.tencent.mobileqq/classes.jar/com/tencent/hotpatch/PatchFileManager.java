package com.tencent.hotpatch;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.SafeModeUtil;
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
    int j = 701;
    String str1 = paramPatchConfig.c();
    Object localObject = PatchCommonUtil.getPatchPath(str1);
    String str2 = PatchCommonUtil.getPatchPath("");
    try
    {
      i = LzmaUtils.a(BaseApplicationImpl.sApplication, (String)localObject, str2);
      if (i != 0) {
        break label136;
      }
      i = 700;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        label136:
        int i = 702;
        QLog.d("PatchLogTag", 1, "PatchFileManager un7zNPatchFile throwable=" + localThrowable);
        continue;
        i = j;
        if (((File)localObject).exists())
        {
          i = 703;
          ((File)localObject).delete();
        }
      }
    }
    localObject = new File((String)localObject);
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    if (700 == i)
    {
      localObject = new File(PatchCommonUtil.getPatchPath(paramPatchConfig.b()));
      if ((((File)localObject).exists()) && (((File)localObject).length() == paramPatchConfig.b())) {
        i = 700;
      }
    }
    for (;;)
    {
      PatchReporter.reportPatchEvent(BaseApplicationImpl.sApplication, "", "actPatchUnzip", i, str1);
      if (700 == i)
      {
        return true;
        i = 701;
        break;
      }
      return false;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    int j = 1;
    PatchConfig localPatchConfig = PatchConfigManager.a(BaseApplicationImpl.sApplication, "dex");
    if ((localPatchConfig != null) && (localPatchConfig.a(BaseApplicationImpl.sApplication, null)))
    {
      String str = localPatchConfig.b();
      File localFile = new File(PatchCommonUtil.getPatchPath(str));
      int i;
      if ((!localFile.exists()) || (localFile.length() != localPatchConfig.b()))
      {
        i = j;
        if (localFile.exists())
        {
          localFile.delete();
          i = j;
        }
      }
      for (;;)
      {
        if (i != 0) {
          ((PatchDownloadManager)paramQQAppInterface.getManager(QQManagerFactory.PATCH_DOWNLOAD_MANAGER)).a(0, "dex", localPatchConfig);
        }
        return;
        if (!PatchChecker.checkPatchValid("dex", str))
        {
          localFile.delete();
          i = j;
        }
        else
        {
          i = 0;
          SafeModeUtil.c();
        }
      }
    }
    SafeModeUtil.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hotpatch.PatchFileManager
 * JD-Core Version:    0.7.0.1
 */