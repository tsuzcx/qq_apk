package com.tencent.TMG.sdk;

import android.util.Log;

public class AVVideoCtrl$EnableExternalCaptureCompleteCallback
{
  static final String TAG = "SdkJni";
  
  protected void onComplete(boolean paramBoolean, int paramInt)
  {
    Log.d("SdkJni", "EnableExternalCaptureCompleteCallback.OnComplete. enable = " + paramBoolean + "  result = " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVVideoCtrl.EnableExternalCaptureCompleteCallback
 * JD-Core Version:    0.7.0.1
 */