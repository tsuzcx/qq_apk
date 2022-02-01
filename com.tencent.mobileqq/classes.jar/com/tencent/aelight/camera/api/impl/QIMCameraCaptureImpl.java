package com.tencent.aelight.camera.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.aelight.camera.aebase.QIMCameraCaptureActivity;
import com.tencent.aelight.camera.api.IQIMCameraCapture;

public class QIMCameraCaptureImpl
  implements IQIMCameraCapture
{
  public Intent getLaunchIntent(Context paramContext, Bundle paramBundle)
  {
    return QIMCameraCaptureActivity.b(paramContext, paramBundle);
  }
  
  public Class getQIMCameraCaptureActivityClass()
  {
    return QIMCameraCaptureActivity.class;
  }
  
  public void launch(Context paramContext, Bundle paramBundle)
  {
    QIMCameraCaptureActivity.a(paramContext, paramBundle);
  }
  
  public void launchForResult(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    QIMCameraCaptureActivity.a(paramActivity, paramBundle, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.api.impl.QIMCameraCaptureImpl
 * JD-Core Version:    0.7.0.1
 */