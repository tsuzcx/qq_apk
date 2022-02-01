package com.tencent.falco.base.libapi.music;

public abstract interface MusicDubStateCallback
{
  public static final int MUSIC_DUB_STATE_NO_PLAY = 1;
  public static final int MUSIC_DUB_STATE_PLAY = 0;
  
  public abstract void onPlay(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.libapi.music.MusicDubStateCallback
 * JD-Core Version:    0.7.0.1
 */