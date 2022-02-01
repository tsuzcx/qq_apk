package com.tencent.TMG.sdk;

import android.util.Log;

public class AVVideoCtrl$EnableCameraCompleteCallback
{
  static final String TAG = "SdkJni";
  
  protected void onComplete(boolean paramBoolean, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EnableCameraCompleteCallback.OnComplete. result = ");
    localStringBuilder.append(paramInt);
    Log.d("SdkJni", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVVideoCtrl.EnableCameraCompleteCallback
 * JD-Core Version:    0.7.0.1
 */