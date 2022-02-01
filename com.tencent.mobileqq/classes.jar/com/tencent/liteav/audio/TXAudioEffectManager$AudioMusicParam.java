package com.tencent.liteav.audio;

public class TXAudioEffectManager$AudioMusicParam
{
  public long endTimeMS;
  public int id;
  public boolean isShortFile;
  public int loopCount;
  public String path;
  public boolean publish;
  public long startTimeMS;
  
  public TXAudioEffectManager$AudioMusicParam(int paramInt, String paramString)
  {
    this.path = paramString;
    this.id = paramInt;
    this.loopCount = 0;
    this.publish = false;
    this.isShortFile = false;
    this.startTimeMS = 0L;
    this.endTimeMS = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.audio.TXAudioEffectManager.AudioMusicParam
 * JD-Core Version:    0.7.0.1
 */