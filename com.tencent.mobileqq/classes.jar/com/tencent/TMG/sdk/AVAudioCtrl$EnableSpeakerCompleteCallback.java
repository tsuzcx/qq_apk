package com.tencent.TMG.sdk;

import android.util.Log;

public class AVAudioCtrl$EnableSpeakerCompleteCallback
{
  static final String TAG = "SdkJni";
  
  protected void onComplete(boolean paramBoolean, int paramInt)
  {
    Log.d("SdkJni", "EnableSpeakerCompleteCallback.OnComplete. enable = " + paramBoolean + "  result = " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVAudioCtrl.EnableSpeakerCompleteCallback
 * JD-Core Version:    0.7.0.1
 */