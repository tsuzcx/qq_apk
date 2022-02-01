package com.tencent.biz.qqstory.takevideo.music;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

class EditVideoMusicCache$1
  extends BroadcastReceiver
{
  EditVideoMusicCache$1(EditVideoMusicCache paramEditVideoMusicCache) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(localObject))
    {
      localObject = paramIntent.getStringExtra("data");
      paramIntent = paramIntent.getStringExtra("event");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onReceive:");
        localStringBuilder.append((String)localObject);
        QLog.d("MusicCache", 2, localStringBuilder.toString());
      }
      if ((!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("kTribeSelectMusic")))
      {
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return;
        }
        EditVideoMusicCache.a(this.a).a();
        try
        {
          paramIntent = new JSONObject((String)localObject);
          int i = paramIntent.optInt("id");
          paramContext = paramContext.getSharedPreferences("VideoMusicCache", 0).getString(String.valueOf(i), null);
          if ((paramContext != null) && (new File(paramContext).exists()))
          {
            localObject = new QQStoryMusicInfo();
            ((QQStoryMusicInfo)localObject).e = paramIntent.optString("title");
            ((QQStoryMusicInfo)localObject).k = 2;
            ((QQStoryMusicInfo)localObject).d = String.valueOf(i);
            ((QQStoryMusicInfo)localObject).m = paramContext;
            EditVideoMusicCache.a(this.a).a((QQStoryMusicInfo)localObject);
          }
          else
          {
            paramContext = new MusicItemInfo();
            paramContext.mType = 5;
            paramContext.mItemId = i;
            paramContext.mMusicName = paramIntent.optString("title");
            paramContext.mSingername = paramIntent.optString("desc");
            paramContext.mSongMid = paramIntent.optString("mid");
            EditVideoMusicCache.a(this.a, paramIntent.optBoolean("is_from_story", false));
            EditVideoMusicCache.a(this.a, paramContext.mSongMid);
          }
        }
        catch (JSONException paramContext)
        {
          if (QLog.isColorLevel()) {
            QLog.e("MusicCache", 2, "on receiver error, ", paramContext);
          }
        }
        VideoEditReport.a("0X80076D6");
        return;
      }
      return;
    }
    if ("action_music_start".equals(localObject))
    {
      EditVideoMusicCache.a(this.a).b();
      return;
    }
    if ("action_music_refresh_list".equals(localObject)) {
      EditVideoMusicCache.b(this.a).sendEmptyMessage(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.music.EditVideoMusicCache.1
 * JD-Core Version:    0.7.0.1
 */