package com.tencent.hippy.qq.update;

import bgmg;
import java.io.File;

public class UpdateTotal
  extends UpdateBase
{
  public UpdateTotal(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, HippyQQUpdateManager.PackageUpdateListener paramPackageUpdateListener)
  {
    super(paramString1, paramString2, paramString3, paramString4, paramInt, paramPackageUpdateListener);
  }
  
  boolean isPatchEnable()
  {
    return false;
  }
  
  boolean patch(File paramFile)
  {
    return true;
  }
  
  boolean unzipFile(File paramFile)
  {
    this.mModuleFilePath = HippyQQFileUtil.getModuleFile(this.mModule, this.mVersion).getAbsolutePath();
    try
    {
      bgmg.a(paramFile.getAbsolutePath(), this.mModuleFilePath, false);
      return true;
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.update.UpdateTotal
 * JD-Core Version:    0.7.0.1
 */