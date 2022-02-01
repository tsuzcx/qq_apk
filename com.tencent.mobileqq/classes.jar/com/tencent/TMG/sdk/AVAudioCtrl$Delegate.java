package com.tencent.TMG.sdk;

import android.util.Log;

public class AVAudioCtrl$Delegate
{
  static final String TAG = "SdkJni";
  
  protected void onOutputModeChange(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onOutputModeChange outputMode = ");
    localStringBuilder.append(paramInt);
    Log.d("SdkJni", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVAudioCtrl.Delegate
 * JD-Core Version:    0.7.0.1
 */