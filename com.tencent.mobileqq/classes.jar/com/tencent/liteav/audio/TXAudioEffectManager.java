package com.tencent.liteav.audio;

public abstract interface TXAudioEffectManager
{
  public abstract void enableVoiceEarMonitor(boolean paramBoolean);
  
  public abstract long getMusicCurrentPosInMS(int paramInt);
  
  public abstract long getMusicDurationInMS(String paramString);
  
  public abstract void pausePlayMusic(int paramInt);
  
  public abstract void resumePlayMusic(int paramInt);
  
  public abstract void seekMusicToPosInMS(int paramInt1, int paramInt2);
  
  public abstract void setAllMusicVolume(int paramInt);
  
  public abstract void setMusicObserver(int paramInt, TXAudioEffectManager.TXMusicPlayObserver paramTXMusicPlayObserver);
  
  public abstract void setMusicPitch(int paramInt, float paramFloat);
  
  public abstract void setMusicPlayoutVolume(int paramInt1, int paramInt2);
  
  public abstract void setMusicPublishVolume(int paramInt1, int paramInt2);
  
  public abstract void setMusicSpeedRate(int paramInt, float paramFloat);
  
  public abstract void setVoiceCaptureVolume(int paramInt);
  
  public abstract void setVoiceChangerType(TXAudioEffectManager.TXVoiceChangerType paramTXVoiceChangerType);
  
  public abstract void setVoiceEarMonitorVolume(int paramInt);
  
  public abstract void setVoiceReverbType(TXAudioEffectManager.TXVoiceReverbType paramTXVoiceReverbType);
  
  public abstract boolean startPlayMusic(TXAudioEffectManager.AudioMusicParam paramAudioMusicParam);
  
  public abstract void stopPlayMusic(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.TXAudioEffectManager
 * JD-Core Version:    0.7.0.1
 */