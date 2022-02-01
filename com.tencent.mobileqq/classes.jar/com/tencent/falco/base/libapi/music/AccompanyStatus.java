package com.tencent.falco.base.libapi.music;

public class AccompanyStatus
{
  public int accompanyVolume = 0;
  public boolean isPlaying = true;
  public AccompanyStatus.LoopMode loopMode = AccompanyStatus.LoopMode.LOOP;
  public AccompanyStatus.LyricStatus lyricStatus = AccompanyStatus.LyricStatus.HAS_LYRIC;
  public int micVolume = 0;
  public AccompanyStatus.MusicResStatus musicResStatus = AccompanyStatus.MusicResStatus.BOTH;
  public AccompanyStatus.MusicStatus musicStatus = AccompanyStatus.MusicStatus.ACCOMPANY;
  public MusicItem playingMusic = null;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.libapi.music.AccompanyStatus
 * JD-Core Version:    0.7.0.1
 */