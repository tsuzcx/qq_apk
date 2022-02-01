package com.tencent.mobileqq.ark.api.module;

import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.music.QQPlayerCallback;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.qroute.QRoute;

final class ArkAppMusicModule$GlobalMusicCallback
  implements QQPlayerCallback
{
  private String a;
  
  public ArkAppMusicModule$GlobalMusicCallback(String paramString)
  {
    this.a = paramString;
  }
  
  public String getToken()
  {
    return ArkAppMusicModule.d();
  }
  
  public void onPlaySongChanged(SongInfo paramSongInfo)
  {
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(this.a, new ArkAppMusicModule.GlobalMusicCallback.2(this, paramSongInfo));
  }
  
  public void onPlayStateChanged(int paramInt)
  {
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(this.a, new ArkAppMusicModule.GlobalMusicCallback.1(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppMusicModule.GlobalMusicCallback
 * JD-Core Version:    0.7.0.1
 */