package com.tencent.biz.apiproxy;

import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.music.QQPlayerCallback;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

class QQMusicService$1
  implements QQPlayerCallback
{
  QQMusicService$1(QQMusicService paramQQMusicService) {}
  
  public String getToken()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.a.d);
    return QQPlayerService.a(5, localStringBuilder.toString());
  }
  
  public void onPlaySongChanged(SongInfo paramSongInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPlaySongChanged:");
      localStringBuilder.append(paramSongInfo.e);
      QLog.i("QQMusicService", 2, localStringBuilder.toString());
    }
  }
  
  public void onPlayStateChanged(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPlayStateChanged:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("QQMusicService", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = QQPlayerService.g();
    localObject = QQMusicService.a(this.a, (SongInfo)localObject);
    if (localObject != null)
    {
      try
      {
        ((JSONObject)localObject).put("state", paramInt);
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onPlayStateChanged:");
          localStringBuilder.append(localJSONException.getStackTrace());
          QLog.d("QQMusicService", 2, localStringBuilder.toString());
        }
        localJSONException.printStackTrace();
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("*.qq.com");
      EventApiPlugin.a("qbrowserMusicStateChange", (JSONObject)localObject, localArrayList, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.apiproxy.QQMusicService.1
 * JD-Core Version:    0.7.0.1
 */