package com.tencent.falco.base.libapi.music;

public abstract interface MusicDubInterface
{
  public abstract void enableLoop(int paramInt);
  
  public abstract void enableLoopback(int paramInt);
  
  public abstract void enableMix(int paramInt);
  
  public abstract int getLength();
  
  public abstract int getTimestamp();
  
  public abstract float getVolume();
  
  public abstract boolean init();
  
  public abstract boolean open(String paramString1, String paramString2);
  
  public abstract void pause();
  
  public abstract boolean play();
  
  public abstract void replay();
  
  public abstract void setKmusicMode(boolean paramBoolean);
  
  public abstract void setMicrophoneVolume(float paramFloat);
  
  public abstract void setMusicDubStateCallback(MusicDubStateCallback paramMusicDubStateCallback);
  
  public abstract void setMusicDubVolume(float paramFloat);
  
  public abstract void setNotify(MusicDubNotify paramMusicDubNotify);
  
  public abstract void setVolume(float paramFloat);
  
  public abstract void stop(int paramInt);
  
  public abstract void switchMode(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.libapi.music.MusicDubInterface
 * JD-Core Version:    0.7.0.1
 */