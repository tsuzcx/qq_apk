package com.tencent.ilivesdk.musicmanagerservice_interface;

import com.tencent.falco.base.libapi.music.MusicItem;

public abstract interface MusicDownloaderInterface$MusicDownloadListener
{
  public abstract void downloadComplete(MusicItem paramMusicItem, String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void downloadFailed(MusicItem paramMusicItem, String paramString1, int paramInt, String paramString2);
  
  public abstract void onProgressUpdate(MusicItem paramMusicItem, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.musicmanagerservice_interface.MusicDownloaderInterface.MusicDownloadListener
 * JD-Core Version:    0.7.0.1
 */