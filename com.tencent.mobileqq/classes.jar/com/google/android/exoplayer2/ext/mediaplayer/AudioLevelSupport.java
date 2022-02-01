package com.google.android.exoplayer2.ext.mediaplayer;

public abstract interface AudioLevelSupport
{
  public abstract double getAudioDuration();
  
  public abstract double getAudioEnergy();
  
  public abstract double getAudioLevel();
  
  public abstract void setCalculateAudioLevel(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.mediaplayer.AudioLevelSupport
 * JD-Core Version:    0.7.0.1
 */