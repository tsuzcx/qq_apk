package com.tencent.hotpatch;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hotpatch.config.PatchConfig;
import com.tencent.hotpatch.config.PatchConfigManager;
import com.tencent.hotpatch.utils.PatchCommonUtil;
import com.tencent.hotpatch.utils.PatchReporter;
import com.tencent.kingkong.UpdateManager;
import com.tencent.mobileqq.app.QQAppInterface;
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
    Object localObject = PatchCommonUtil.a(str1);
    String str2 = PatchCommonUtil.a("");
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
      localObject = new File(PatchCommonUtil.a(paramPatchConfig.b()));
      if ((((File)localObject).exists()) && (((File)localObject).length() == paramPatchConfig.b())) {
        i = 700;
      }
    }
    for (;;)
    {
      PatchReporter.a(BaseApplicationImpl.sApplication, "", "actPatchUnzip", i, str1);
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
    String str;
    File localFile;
    int i;
    if ((localPatchConfig != null) && (localPatchConfig.a(BaseApplicationImpl.sApplication, false)))
    {
      str = localPatchConfig.b();
      localFile = new File(PatchCommonUtil.a(str));
      if ((localFile.exists()) && (localFile.length() == localPatchConfig.b())) {
        break label107;
      }
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
        ((PatchDownloadManager)paramQQAppInterface.getManager(119)).a(0, "dex", localPatchConfig);
      }
      return;
      label107:
      if (!PatchChecker.a("dex", str))
      {
        localFile.delete();
        i = j;
      }
      else
      {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.hotpatch.PatchFileManager
 * JD-Core Version:    0.7.0.1
 */