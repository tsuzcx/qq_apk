package com.qflutter.audio;

import io.flutter.plugin.common.MethodChannel.Result;

public abstract interface BasePlayer
{
  public abstract void audioPreDownLoad(String paramString, MethodChannel.Result paramResult);
  
  public abstract void continueAudioPlay(MethodChannel.Result paramResult);
  
  public abstract void pauseAudioPlay(MethodChannel.Result paramResult);
  
  public abstract void removeAudioPlayerListener();
  
  public abstract void setAudioPlayerListener(IPlayerStatusListener paramIPlayerStatusListener);
  
  public abstract void startAudioPlay(String paramString, MethodChannel.Result paramResult);
  
  public abstract void stopAudioPlay(MethodChannel.Result paramResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.audio.BasePlayer
 * JD-Core Version:    0.7.0.1
 */