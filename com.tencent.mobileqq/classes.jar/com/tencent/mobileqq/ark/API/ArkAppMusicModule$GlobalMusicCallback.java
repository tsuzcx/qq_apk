package com.tencent.mobileqq.ark.API;

import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.music.QQPlayerService.QQPlayerCallback;
import com.tencent.mobileqq.music.SongInfo;

final class ArkAppMusicModule$GlobalMusicCallback
  implements QQPlayerService.QQPlayerCallback
{
  private String a;
  
  public ArkAppMusicModule$GlobalMusicCallback(String paramString)
  {
    this.a = paramString;
  }
  
  public String getToken()
  {
    return ArkAppMusicModule.a();
  }
  
  public void onPlaySongChanged(SongInfo paramSongInfo)
  {
    ArkAppCenter.a().post(this.a, new ArkAppMusicModule.GlobalMusicCallback.2(this, paramSongInfo));
  }
  
  public void onPlayStateChanged(int paramInt)
  {
    ArkAppCenter.a().post(this.a, new ArkAppMusicModule.GlobalMusicCallback.1(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppMusicModule.GlobalMusicCallback
 * JD-Core Version:    0.7.0.1
 */