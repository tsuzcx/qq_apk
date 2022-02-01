package com.tencent.component.media.gif;

public abstract interface GifPlayerControl
{
  public abstract boolean canPause();
  
  public abstract boolean canSeekBackward();
  
  public abstract boolean canSeekForward();
  
  public abstract int getBufferPercentage();
  
  public abstract int getCurrentPosition();
  
  public abstract int getDuration();
  
  public abstract boolean isPlaying();
  
  public abstract void pause();
  
  public abstract void seekTo(int paramInt);
  
  public abstract void start();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.gif.GifPlayerControl
 * JD-Core Version:    0.7.0.1
 */