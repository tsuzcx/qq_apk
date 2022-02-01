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
  long jdField_a_of_type_Long = 0L;
  TroopMemberApiService jdField_a_of_type_ComTencentBizTroopTroopMemberApiService;
  QQPlayerCallback jdField_a_of_type_ComTencentMobileqqMusicQQPlayerCallback = new QQMusicService.1(this);
  private final String c = "QQMusicService";
  
  public QQMusicService(TroopMemberApiService paramTroopMemberApiService)
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService = paramTroopMemberApiService;
  }
  
  private JSONObject a(SongInfo paramSongInfo)
  {
    if (paramSongInfo == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", paramSongInfo.jdField_a_of_type_Long);
    }
    catch (JSONException localJSONException1)
    {
      localJSONException1.printStackTrace();
    }
    try
    {
      localJSONObject.put("audio_url", paramSongInfo.b);
    }
    catch (JSONException localJSONException2)
    {
      localJSONException2.printStackTrace();
    }
    try
    {
      localJSONObject.put("title", paramSongInfo.c);
    }
    catch (JSONException localJSONException3)
    {
      localJSONException3.printStackTrace();
    }
    try
    {
      localJSONObject.put("desc", paramSongInfo.d);
    }
    catch (JSONException localJSONException4)
    {
      localJSONException4.printStackTrace();
    }
    try
    {
      localJSONObject.put("image_url", paramSongInfo.e);
    }
    catch (JSONException localJSONException5)
    {
      localJSONException5.printStackTrace();
    }
    try
    {
      localJSONObject.put("share_url", paramSongInfo.f);
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
    localSongInfo.jdField_a_of_type_Long = paramString.optLong("id");
    localSongInfo.b = paramString.optString("audio_url");
    localSongInfo.c = paramString.optString("title");
    localSongInfo.d = paramString.optString("desc");
    localSongInfo.e = paramString.optString("image_url");
    localSongInfo.f = paramString.optString("share_url");
    this.jdField_a_of_type_Long = localSongInfo.jdField_a_of_type_Long;
    QQPlayerService.a(new Intent(BaseApplication.getContext(), MusicPlayerActivity.class));
    QQPlayerService.a(this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerCallback);
    QQPlayerService.a(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerCallback.getToken(), localSongInfo);
  }
  
  public void a(AppRuntime paramAppRuntime, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    int i = paramBundle.getInt(jdField_a_of_type_JavaLangString);
    paramAppRuntime = new Bundle();
    paramAppRuntime.putInt(jdField_a_of_type_JavaLangString, i);
    int j = paramBundle.getInt("seq", -1);
    if (j != -1) {
      paramAppRuntime.putInt("seq", j);
    }
    switch (i)
    {
    default: 
      return;
    case 8: 
      QQPlayerService.c(BaseApplication.getContext());
      return;
    case 7: 
      QQPlayerService.a(this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerCallback);
      paramBundle = a(QQPlayerService.b());
      if (paramBundle != null) {
        paramAppRuntime.putString("music", paramBundle.toString());
      }
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(8, paramAppRuntime);
      return;
    case 6: 
      QQPlayerService.a(this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerCallback);
      paramAppRuntime.putInt("mode", QQPlayerService.b());
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(8, paramAppRuntime);
      return;
    case 5: 
      QQPlayerService.a(paramBundle.getInt("mode"));
      return;
    case 4: 
      QQPlayerService.a(this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerCallback);
      paramAppRuntime.putInt("state", QQPlayerService.a());
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(8, paramAppRuntime);
      return;
    case 3: 
      QQPlayerService.b(BaseApplication.getContext());
      return;
    case 2: 
      QQPlayerService.a(BaseApplication.getContext());
      return;
    }
    a(paramBundle.getString("music"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.apiproxy.QQMusicService
 * JD-Core Version:    0.7.0.1
 */