package com.qflutter.audio;

import androidx.annotation.UiThread;

public abstract interface IPlayerStatusListener
{
  @UiThread
  public abstract void onAudioFinishPlay(String paramString);
  
  @UiThread
  public abstract void onAudioPlayFailed(String paramString1, int paramInt, String paramString2);
  
  @UiThread
  public abstract void onAudioStartPlay(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.audio.IPlayerStatusListener
 * JD-Core Version:    0.7.0.1
 */