package com.tencent.aelight.camera.entry.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
public abstract interface IAECameraLauncher
  extends QRouteApi
{
  public abstract boolean isCameraResReady();
  
  public abstract void launchAECameraFromCircle(Context paramContext, @Nullable Bundle paramBundle);
  
  public abstract void launchAECameraUnit(Activity paramActivity, int paramInt, Bundle paramBundle);
  
  public abstract void launchAEMutiCameraFromCircle(Context paramContext, @Nullable Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.entry.api.IAECameraLauncher
 * JD-Core Version:    0.7.0.1
 */