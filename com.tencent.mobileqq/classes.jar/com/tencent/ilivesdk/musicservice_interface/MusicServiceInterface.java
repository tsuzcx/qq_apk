package com.tencent.ilivesdk.musicservice_interface;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.falco.base.libapi.music.MusicDubInterface;

public abstract interface MusicServiceInterface
  extends ServiceBaseInterface, MusicDubInterface
{
  public abstract void setMusicDubAdapter(MusicDubAdapter paramMusicDubAdapter);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.musicservice_interface.MusicServiceInterface
 * JD-Core Version:    0.7.0.1
 */