package com.tencent.biz.apiproxy;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.music.QQPlayerCallback;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class QQMusicService
{
  public static String a = "msg_key";
  public static String b = "msg_back";
  TroopMemberApiService c;
  long d = 0L;
  QQPlayerCallback e = new QQMusicService.1(this);
  private final String f = "QQMusicService";
  
  public QQMusicService(TroopMemberApiService paramTroopMemberApiService)
  {
    this.c = paramTroopMemberApiService;
  }
  
  private JSONObject a(SongInfo paramSongInfo)
  {
    if (paramSongInfo == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", paramSongInfo.a);
    }
    catch (JSONException localJSONException1)
    {
      localJSONException1.printStackTrace();
    }
    try
    {
      localJSONObject.put("audio_url", paramSongInfo.d);
    }
    catch (JSONException localJSONException2)
    {
      localJSONException2.printStackTrace();
    }
    try
    {
      localJSONObject.put("title", paramSongInfo.e);
    }
    catch (JSONException localJSONException3)
    {
      localJSONException3.printStackTrace();
    }
    try
    {
      localJSONObject.put("desc", paramSongInfo.f);
    }
    catch (JSONException localJSONException4)
    {
      localJSONException4.printStackTrace();
    }
    try
    {
      localJSONObject.put("image_url", paramSongInfo.g);
    }
    catch (JSONException localJSONException5)
    {
      localJSONException5.printStackTrace();
    }
    try
    {
      localJSONObject.put("share_url", paramSongInfo.h);
      return localJSONObject;
    }
    catch (JSONException paramSongInfo)
    {
      paramSongInfo.printStackTrace();
    }
    return localJSONObject;
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    SongInfo localSongInfo = null;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      paramString = localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("playQQMusic err:");
        localStringBuilder.append(paramString);
        QLog.i("QQMusicService", 2, localStringBuilder.toString());
      }
      localJSONException.printStackTrace();
      paramString = localSongInfo;
    }
    if (paramString == null) {
      return;
    }
    paramString.optInt("mtype", 1);
    localSongInfo = new SongInfo();
    localSongInfo.a = paramString.optLong("id");
    localSongInfo.d = paramString.optString("audio_url");
    localSongInfo.e = paramString.optString("title");
    localSongInfo.f = paramString.optString("desc");
    localSongInfo.g = paramString.optString("image_url");
    localSongInfo.h = paramString.optString("share_url");
    this.d = localSongInfo.a;
    QQPlayerService.a(new Intent(BaseApplication.getContext(), MusicPlayerActivity.class));
    QQPlayerService.a(this.e);
    QQPlayerService.a(BaseApplication.getContext(), this.e.getToken(), localSongInfo);
  }
  
  public void a(AppRuntime paramAppRuntime, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    int i = paramBundle.getInt(a);
    paramAppRuntime = new Bundle();
    paramAppRuntime.putInt(a, i);
    int j = paramBundle.getInt("seq", -1);
    if (j != -1) {
      paramAppRuntime.putInt("seq", j);
    }
    switch (i)
    {
    default: 
      return;
    case 8: 
      QQPlayerService.e(BaseApplication.getContext());
      return;
    case 7: 
      QQPlayerService.a(this.e);
      paramBundle = a(QQPlayerService.g());
      if (paramBundle != null) {
        paramAppRuntime.putString("music", paramBundle.toString());
      }
      this.c.a(8, paramAppRuntime);
      return;
    case 6: 
      QQPlayerService.a(this.e);
      paramAppRuntime.putInt("mode", QQPlayerService.d());
      this.c.a(8, paramAppRuntime);
      return;
    case 5: 
      QQPlayerService.b(paramBundle.getInt("mode"));
      return;
    case 4: 
      QQPlayerService.a(this.e);
      paramAppRuntime.putInt("state", QQPlayerService.c());
      this.c.a(8, paramAppRuntime);
      return;
    case 3: 
      QQPlayerService.d(BaseApplication.getContext());
      return;
    case 2: 
      QQPlayerService.c(BaseApplication.getContext());
      return;
    }
    a(paramBundle.getString("music"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.apiproxy.QQMusicService
 * JD-Core Version:    0.7.0.1
 */