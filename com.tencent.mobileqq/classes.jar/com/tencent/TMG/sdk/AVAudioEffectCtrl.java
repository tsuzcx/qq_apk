package com.tencent.TMG.sdk;

import android.content.Context;
import android.util.Log;

public class AVAudioEffectCtrl
{
  public static final int AUDIO_ERROR = -1;
  static final String TAG = "SdkJni";
  int nativeObj = 0;
  
  public native int SetAccompanyFileCurrentPlayedTimeByMs(int paramInt);
  
  public native int enableAccompanyLoopBack(boolean paramBoolean);
  
  public native int enableAccompanyPlay(boolean paramBoolean);
  
  public native int getAccompanyFileCurrentPlayedTimeByMs();
  
  public native int getAccompanyFileTotalTimeByMs();
  
  public native int getAccompanyVolumeDB();
  
  public native int getEffectsVolume();
  
  boolean init(Context paramContext, int paramInt)
  {
    return initNative(paramInt);
  }
  
  native boolean initNative(int paramInt);
  
  public native boolean isAccompanyPlayEnd();
  
  public native int pauseAccompany();
  
  public native int pauseAllEffects();
  
  public native int pauseEffect(int paramInt);
  
  public native int playEffect(int paramInt, String paramString, boolean paramBoolean, double paramDouble1, double paramDouble2, double paramDouble3);
  
  public native int preloadEffect(int paramInt, String paramString);
  
  public native int resumeAccompany();
  
  public native int resumeAllEffects();
  
  public native int resumeEffect(int paramInt);
  
  public native int setAccompanyVolumeDB(int paramInt);
  
  public native int setEffectsVolume(int paramInt);
  
  public native int startAccompany(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, AccompanyCompleteCallback paramAccompanyCompleteCallback);
  
  public native int stopAccompany(int paramInt);
  
  public native int stopAllEffects();
  
  public native int stopEffect(int paramInt);
  
  void uninit()
  {
    uninitNative();
  }
  
  native boolean uninitNative();
  
  public native int unloadEffect(int paramInt);
  
  public static class AccompanyCompleteCallback
  {
    static final String TAG = "SdkJni";
    
    protected void onComplete(int paramInt, String paramString)
    {
      Log.d("SdkJni", "AccompanyCompleteCallback.OnComplete. result = " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVAudioEffectCtrl
 * JD-Core Version:    0.7.0.1
 */