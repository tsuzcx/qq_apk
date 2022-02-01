package com.tencent.aelight.camera.download.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IAEResDownload
  extends QRouteApi
{
  @Deprecated
  public abstract int getResPackageStatus(@NonNull AEResInfo paramAEResInfo);
  
  public abstract void preDownloadAERes();
  
  public abstract void removeCallBack(@Nullable IAEDownloadCallBack paramIAEDownloadCallBack);
  
  public abstract void requestDownload(@NonNull AEResInfo paramAEResInfo, @Nullable IAEDownloadCallBack paramIAEDownloadCallBack, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.download.api.IAEResDownload
 * JD-Core Version:    0.7.0.1
 */