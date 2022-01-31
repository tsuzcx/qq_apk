package com.tencent.hotpatch;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hotpatch.config.BasePatchConfig;
import com.tencent.hotpatch.config.DexPatchConfigArtAfterN;
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
    BasePatchConfig localBasePatchConfig = PatchConfigManager.a(BaseApplicationImpl.sApplication, "Native");
    if (localBasePatchConfig != null) {
      UpdateManager.a(localBasePatchConfig.a());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    b(paramQQAppInterface);
    a();
  }
  
  public static boolean a(DexPatchConfigArtAfterN paramDexPatchConfigArtAfterN)
  {
    int j = 701;
    String str1 = "androidN7z_" + paramDexPatchConfigArtAfterN.c;
    Object localObject = PatchCommonUtil.a("dex", str1);
    String str2 = PatchCommonUtil.a("dex", "");
    try
    {
      i = LzmaUtils.a(BaseApplicationImpl.sApplication, (String)localObject, str2);
      if (i != 0) {
        break label160;
      }
      i = 700;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        label160:
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
      localObject = new File(PatchCommonUtil.a("dex", paramDexPatchConfigArtAfterN.c));
      if ((((File)localObject).exists()) && (((File)localObject).length() == paramDexPatchConfigArtAfterN.b)) {
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
    BasePatchConfig localBasePatchConfig = PatchConfigManager.a(BaseApplicationImpl.sApplication, "dex");
    File localFile;
    int i;
    if ((localBasePatchConfig != null) && (localBasePatchConfig.a(BaseApplicationImpl.sApplication, false)))
    {
      localFile = new File(PatchCommonUtil.a("dex", localBasePatchConfig.c));
      if ((localFile.exists()) && (localFile.length() == localBasePatchConfig.b)) {
        break label105;
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
        ((PatchDownloadManager)paramQQAppInterface.getManager(119)).a(0, "dex", localBasePatchConfig);
      }
      return;
      label105:
      if (!PatchChecker.a("dex", localBasePatchConfig.c))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.hotpatch.PatchFileManager
 * JD-Core Version:    0.7.0.1
 */