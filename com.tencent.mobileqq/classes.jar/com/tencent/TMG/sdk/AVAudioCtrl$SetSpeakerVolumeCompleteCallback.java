package com.tencent.TMG.sdk;

import android.util.Log;

public class AVAudioCtrl$SetSpeakerVolumeCompleteCallback
{
  static final String TAG = "SdkJni";
  
  protected void onComplete(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SetSpeakerVolumeCompleteCallback.OnComplete， result = ");
    localStringBuilder.append(paramInt);
    Log.e("SdkJni", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVAudioCtrl.SetSpeakerVolumeCompleteCallback
 * JD-Core Version:    0.7.0.1
 */