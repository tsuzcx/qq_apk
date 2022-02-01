package com.tencent.ilivesdk.musicservice_interface;

import com.tencent.falco.base.libapi.downloader.DownLoaderInterface;
import com.tencent.falco.base.libapi.log.LogInterface;

public abstract interface MusicDubAdapter
{
  public abstract DownLoaderInterface getDownLoader();
  
  public abstract LogInterface getLogger();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.musicservice_interface.MusicDubAdapter
 * JD-Core Version:    0.7.0.1
 */