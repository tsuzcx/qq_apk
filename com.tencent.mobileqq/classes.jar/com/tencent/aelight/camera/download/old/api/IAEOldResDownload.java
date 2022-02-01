package com.tencent.aelight.camera.download.old.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IAEOldResDownload
  extends QRouteApi
{
  public abstract void requestDownload(@NonNull AEOldResInfo paramAEOldResInfo, @Nullable AEOldDownloadCallBack paramAEOldDownloadCallBack, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.download.old.api.IAEOldResDownload
 * JD-Core Version:    0.7.0.1
 */