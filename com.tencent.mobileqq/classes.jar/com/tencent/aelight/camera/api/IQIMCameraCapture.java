package com.tencent.aelight.camera.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQIMCameraCapture
  extends QRouteApi
{
  public abstract Intent getLaunchIntent(Context paramContext, Bundle paramBundle);
  
  public abstract Class getQIMCameraCaptureActivityClass();
  
  public abstract void launch(Context paramContext, Bundle paramBundle);
  
  public abstract void launchForResult(Activity paramActivity, Bundle paramBundle, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.api.IQIMCameraCapture
 * JD-Core Version:    0.7.0.1
 */