package com.tencent.aelight.camera.download.old.api;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IAEOldResUtil
  extends QRouteApi
{
  @NonNull
  public abstract String getFinalUnzippedPackageDir(@NonNull AEOldResInfo paramAEOldResInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.download.old.api.IAEOldResUtil
 * JD-Core Version:    0.7.0.1
 */