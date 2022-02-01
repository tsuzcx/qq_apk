package com.tencent.hippy.qq.update;

import android.text.TextUtils;
import com.tencent.hippy.qq.update.sign.MD5;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

public abstract class UpdateBase
  implements HippyQQFileUtil.DownLoadCallBack
{
  private static final String TAG = "UpdateBase";
  protected String mMd5;
  protected String mModule;
  protected String mModuleFilePath;
  protected String mPatchMd5;
  protected HippyQQUpdateManager.PackageUpdateListener mUpdateListener;
  protected String mUrl;
  protected int mVersion;
  
  public UpdateBase(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, HippyQQUpdateManager.PackageUpdateListener paramPackageUpdateListener)
  {
    this.mUrl = paramString1;
    this.mMd5 = paramString2;
    this.mPatchMd5 = paramString3;
    this.mModule = paramString4;
    this.mVersion = paramInt;
    this.mUpdateListener = paramPackageUpdateListener;
  }
  
  public static void checkAndResetLocalVersion(String paramString, int paramInt)
  {
    int i = UpdateSetting.getInstance().getModuleVersion(paramString);
    if ((i > 0) && (i < paramInt)) {
      cleanHistoryVersion(HippyQQFileUtil.getModuleFile(paramString, -1), i);
    }
    UpdateSetting.getInstance().setModuleVersion(paramString, paramInt);
  }
  
  public static void cleanHistoryVersion(File paramFile, int paramInt)
  {
    int i = 0;
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory())) {}
    do
    {
      return;
      paramFile = paramFile.listFiles();
    } while (paramFile == null);
    int j = paramFile.length;
    while (i < j)
    {
      Object localObject = paramFile[i];
      String str;
      if ((localObject != null) && (localObject.exists()) && (localObject.isDirectory())) {
        str = localObject.getName();
      }
      try
      {
        if (Integer.parseInt(str) < paramInt) {
          FileUtils.a(localObject.getAbsolutePath(), false);
        }
        label89:
        i += 1;
      }
      catch (Exception localException)
      {
        break label89;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label89;
      }
    }
  }
  
  void doAfterDownLoadBusiness(File paramFile)
  {
    int i;
    if (TextUtils.equals(MD5.getFileMd5(paramFile.getAbsolutePath()), this.mMd5)) {
      if (patch(paramFile)) {
        if (unzipFile(paramFile))
        {
          checkAndResetLocalVersion(this.mModule, this.mVersion);
          i = 0;
        }
      }
    }
    for (;;)
    {
      if (this.mUpdateListener != null) {
        this.mUpdateListener.onUpdateComplete(i, "", this.mModuleFilePath);
      }
      return;
      i = -1;
      continue;
      i = -2;
      continue;
      i = -3;
    }
  }
  
  abstract boolean isPatchEnable();
  
  public void onDownloadResult(int paramInt, File paramFile)
  {
    if (paramInt == 0) {
      doAfterDownLoadBusiness(paramFile);
    }
    while (this.mUpdateListener == null) {
      return;
    }
    paramFile = "download result: " + paramInt;
    this.mUpdateListener.onUpdateComplete(-4, paramFile, this.mModuleFilePath);
  }
  
  abstract boolean patch(File paramFile);
  
  public void startDownload()
  {
    try
    {
      if (isPatchEnable()) {}
      for (File localFile = HippyQQFileUtil.getDiffFile(this.mModule, this.mVersion);; localFile = HippyQQFileUtil.getZipFile(this.mModule, this.mVersion))
      {
        HippyQQFileUtil.downLoad(this.mUrl, localFile, this);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  abstract boolean unzipFile(File paramFile);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.update.UpdateBase
 * JD-Core Version:    0.7.0.1
 */