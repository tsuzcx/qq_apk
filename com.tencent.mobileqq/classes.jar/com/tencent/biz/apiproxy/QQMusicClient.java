package com.tencent.biz.apiproxy;

import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;

public class QQMusicClient
{
  TroopMemberApiClient a;
  
  public QQMusicClient(TroopMemberApiClient paramTroopMemberApiClient)
  {
    this.a = paramTroopMemberApiClient;
  }
  
  public void a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(QQMusicService.a, 2);
    this.a.a(8, localBundle);
  }
  
  public void a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(QQMusicService.a, 5);
    localBundle.putInt("mode", paramInt);
    this.a.a(8, localBundle);
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    int i = paramBundle.getInt("seq", -1);
    if (i != -1)
    {
      ITroopMemberApiClientApi.Callback localCallback = this.a.a(i);
      if (localCallback != null) {
        localCallback.callback(paramBundle);
      }
    }
  }
  
  public void a(ITroopMemberApiClientApi.Callback paramCallback)
  {
    if (paramCallback == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(QQMusicService.a, 4);
    localBundle.putInt("seq", this.a.a(paramCallback));
    this.a.a(8, localBundle);
  }
  
  public void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(QQMusicService.a, 1);
    localBundle.putString("music", paramString);
    this.a.a(8, localBundle);
  }
  
  public void b()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(QQMusicService.a, 3);
    this.a.a(8, localBundle);
  }
  
  public void b(ITroopMemberApiClientApi.Callback paramCallback)
  {
    if (paramCallback == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(QQMusicService.a, 6);
    localBundle.putInt("seq", this.a.a(paramCallback));
    this.a.a(8, localBundle);
  }
  
  public void c()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(QQMusicService.a, 8);
    this.a.a(8, localBundle);
  }
  
  public void c(ITroopMemberApiClientApi.Callback paramCallback)
  {
    if (paramCallback == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(QQMusicService.a, 7);
    localBundle.putInt("seq", this.a.a(paramCallback));
    this.a.a(8, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.apiproxy.QQMusicClient
 * JD-Core Version:    0.7.0.1
 */