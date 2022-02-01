package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

public class MediaPlayer$SeekMode
{
  private int a = 0;
  
  MediaPlayer$SeekMode(int paramInt)
  {
    this.a = paramInt;
  }
  
  public static SeekMode a(int paramInt)
  {
    return new SeekMode(paramInt);
  }
  
  public int a()
  {
    int i = this.a;
    if ((i != 3) && (i != 4) && (i != 5) && (i != 6)) {
      return i;
    }
    return 0;
  }
  
  public int b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer.SeekMode
 * JD-Core Version:    0.7.0.1
 */