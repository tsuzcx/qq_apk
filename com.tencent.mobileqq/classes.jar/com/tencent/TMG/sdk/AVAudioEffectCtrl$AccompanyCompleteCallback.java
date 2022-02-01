package com.tencent.TMG.sdk;

import android.util.Log;

public class AVAudioEffectCtrl$AccompanyCompleteCallback
{
  static final String TAG = "SdkJni";
  
  protected void onComplete(int paramInt, String paramString)
  {
    paramString = new StringBuilder();
    paramString.append("AccompanyCompleteCallback.OnComplete. result = ");
    paramString.append(paramInt);
    Log.d("SdkJni", paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVAudioEffectCtrl.AccompanyCompleteCallback
 * JD-Core Version:    0.7.0.1
 */