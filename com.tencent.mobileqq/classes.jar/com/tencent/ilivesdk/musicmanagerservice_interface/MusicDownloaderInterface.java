package com.tencent.ilivesdk.musicmanagerservice_interface;

import com.tencent.falco.base.libapi.music.MusicItem;

public abstract interface MusicDownloaderInterface
{
  public abstract void download(MusicItem paramMusicItem, MusicDownloaderInterface.MusicDownloadListener paramMusicDownloadListener);
  
  public abstract void setFolder(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.musicmanagerservice_interface.MusicDownloaderInterface
 * JD-Core Version:    0.7.0.1
 */