package com.tencent.TMG.sdk;

import android.util.Log;

public class AVVideoCtrl$SwitchCameraCompleteCallback
{
  static final String TAG = "SdkJni";
  
  protected void onComplete(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SwitchCameraCompleteCallback.OnComplete. result = ");
    localStringBuilder.append(paramInt2);
    Log.d("SdkJni", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVVideoCtrl.SwitchCameraCompleteCallback
 * JD-Core Version:    0.7.0.1
 */