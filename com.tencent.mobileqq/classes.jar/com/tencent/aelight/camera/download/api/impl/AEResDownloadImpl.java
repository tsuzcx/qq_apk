package com.tencent.aelight.camera.download.api.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.aelight.camera.ae.download.AEResManager;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEDownloadCallBack;
import com.tencent.aelight.camera.download.api.IAEResDownload;

public class AEResDownloadImpl
  implements IAEResDownload
{
  public int getResPackageStatus(@NonNull AEResInfo paramAEResInfo)
  {
    return AEResManager.a().a(paramAEResInfo);
  }
  
  public void preDownloadAERes()
  {
    AEResManager.a().a();
  }
  
  public void removeCallBack(@Nullable IAEDownloadCallBack paramIAEDownloadCallBack)
  {
    AEResManager.a().a(paramIAEDownloadCallBack);
  }
  
  public void requestDownload(@NonNull AEResInfo paramAEResInfo, @Nullable IAEDownloadCallBack paramIAEDownloadCallBack, boolean paramBoolean)
  {
    AEResManager.a().a(paramAEResInfo, paramIAEDownloadCallBack, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.download.api.impl.AEResDownloadImpl
 * JD-Core Version:    0.7.0.1
 */