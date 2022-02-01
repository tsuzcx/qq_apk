package com.tencent.hippy.qq.update;

import android.text.TextUtils;
import com.tencent.hippy.qq.update.sign.MD5;
import java.io.File;

public abstract class UpdateBase
  implements HippyQQFileUtil.DownLoadCallBack
{
  private static final String TAG = "UpdateBase";
  String mMd5;
  String mModule;
  protected String mModuleFilePath;
  String mPatchMd5;
  protected HippyQQUpdateManager.PackageUpdateListener mUpdateListener;
  String mUrl;
  int mVersion;
  
  public UpdateBase(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, HippyQQUpdateManager.PackageUpdateListener paramPackageUpdateListener)
  {
    this.mUrl = paramString1;
    this.mMd5 = paramString2;
    this.mPatchMd5 = paramString3;
    this.mModule = paramString4;
    this.mVersion = paramInt;
    this.mUpdateListener = paramPackageUpdateListener;
  }
  
  void doAfterDownLoadBusiness(File paramFile)
  {
    int i;
    if (TextUtils.equals(MD5.getFileMd5(paramFile.getAbsolutePath()), this.mMd5)) {
      if (patch(paramFile)) {
        if (unzipFile(paramFile))
        {
          UpdateSetting.getInstance().setModuleVersion(this.mModule, this.mVersion);
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
  
  void startDownload()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.update.UpdateBase
 * JD-Core Version:    0.7.0.1
 */