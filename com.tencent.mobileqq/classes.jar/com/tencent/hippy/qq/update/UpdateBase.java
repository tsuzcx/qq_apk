package com.tencent.hippy.qq.update;

import android.text.TextUtils;
import com.tencent.hippy.qq.api.PackageUpdateListener;
import com.tencent.hippy.qq.update.sign.MD5;
import java.io.File;

public abstract class UpdateBase
  implements HippyQQFileUtil.DownLoadCallBack
{
  private static final String TAG = "UpdateBase";
  protected String mMd5;
  protected String mModule;
  protected String mModuleFilePath;
  protected String mPatchMd5;
  protected PackageUpdateListener mUpdateListener;
  protected String mUrl;
  protected int mVersion;
  
  public UpdateBase(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, PackageUpdateListener paramPackageUpdateListener)
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
      HippyQQFileUtil.cleanHistoryVersion(paramString, i);
    }
    UpdateSetting.getInstance().setModuleVersion(paramString, paramInt);
  }
  
  void doAfterDownLoadBusiness(File paramFile)
  {
    int i;
    if (TextUtils.equals(MD5.getFileMd5(paramFile.getAbsolutePath()), this.mMd5))
    {
      if (patch(paramFile))
      {
        if (unzipFile(paramFile))
        {
          checkAndResetLocalVersion(this.mModule, this.mVersion);
          i = 0;
        }
        else
        {
          i = -1;
        }
      }
      else {
        i = -2;
      }
    }
    else {
      i = -3;
    }
    paramFile = this.mUpdateListener;
    if (paramFile != null) {
      paramFile.onUpdateComplete(i, "", this.mModuleFilePath);
    }
  }
  
  abstract boolean isPatchEnable();
  
  public void onDownloadResult(int paramInt, File paramFile)
  {
    if (paramInt == 0)
    {
      doAfterDownLoadBusiness(paramFile);
      return;
    }
    if (this.mUpdateListener != null)
    {
      paramFile = new StringBuilder();
      paramFile.append("download result: ");
      paramFile.append(paramInt);
      paramFile = paramFile.toString();
      this.mUpdateListener.onUpdateComplete(-4, paramFile, this.mModuleFilePath);
    }
  }
  
  abstract boolean patch(File paramFile);
  
  public void startDownload()
  {
    try
    {
      File localFile;
      if (isPatchEnable()) {
        localFile = HippyQQFileUtil.getDiffFile(this.mModule, this.mVersion);
      } else {
        localFile = HippyQQFileUtil.getZipFile(this.mModule, this.mVersion);
      }
      HippyQQFileUtil.downLoad(this.mUrl, localFile, this);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  abstract boolean unzipFile(File paramFile);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.update.UpdateBase
 * JD-Core Version:    0.7.0.1
 */