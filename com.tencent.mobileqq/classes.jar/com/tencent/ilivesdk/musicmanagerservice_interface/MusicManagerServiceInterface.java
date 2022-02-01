package com.tencent.ilivesdk.musicmanagerservice_interface;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.falco.base.libapi.music.AccompanyStatus;
import com.tencent.falco.base.libapi.music.MusicItem;
import java.util.List;

public abstract interface MusicManagerServiceInterface
  extends ServiceBaseInterface
{
  public abstract void accompanyMode();
  
  public abstract void deleteMusic(String paramString);
  
  public abstract MusicItem getPlayingMusicItem();
  
  public abstract void init(MusicManagerServiceAdapter paramMusicManagerServiceAdapter);
  
  public abstract void originMode();
  
  public abstract void playMusic(List<MusicItem> paramList, int paramInt);
  
  public abstract void setAccompanyStatus(AccompanyStatus paramAccompanyStatus);
  
  public abstract void setLyricDisplayListener(MusicManagerServiceInterface.LyricDisplayListener paramLyricDisplayListener);
  
  public abstract void setMicrophoneVolume(float paramFloat);
  
  public abstract void setMusicDubVolume(float paramFloat);
  
  public abstract void setMusicStatusListener(MusicManagerServiceInterface.MusicStatusListener paramMusicStatusListener);
  
  public abstract void stopAccompany();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.musicmanagerservice_interface.MusicManagerServiceInterface
 * JD-Core Version:    0.7.0.1
 */