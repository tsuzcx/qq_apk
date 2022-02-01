package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class CommonHobbyForAIOShowItemBuilder$1
  implements View.OnClickListener
{
  private long b = 0L;
  
  CommonHobbyForAIOShowItemBuilder$1(CommonHobbyForAIOShowItemBuilder paramCommonHobbyForAIOShowItemBuilder) {}
  
  public void onClick(View paramView)
  {
    Resources localResources = paramView.getContext().getResources();
    long l = SystemClock.uptimeMillis();
    if (l - this.b >= 500L)
    {
      this.b = l;
      if ((paramView.getTag() != null) && ((paramView.getTag() instanceof JSONObject)))
      {
        Object localObject2 = (JSONObject)paramView.getTag();
        try
        {
          Object localObject1 = ((JSONObject)localObject2).getString("url");
          String str = ((JSONObject)localObject2).getString("name");
          Context localContext = paramView.getContext();
          if (this.a.a != null) {
            MediaPlayerManager.a(this.a.a).a(true);
          }
          if (QQPlayerService.d(this.a))
          {
            QQPlayerService.e(localContext);
            paramView.setContentDescription(localResources.getString(2131887112));
          }
          else if ((this.a.a != null) && (this.a.a.isVideoChatting()))
          {
            if (QLog.isColorLevel()) {
              QLog.i("CommonHobbyForAIOShowItemBuilder", 0, "Video Chatting is going on, don't play music.");
            }
          }
          else
          {
            SongInfo localSongInfo = new SongInfo();
            localSongInfo.d = ((String)localObject1);
            localSongInfo.m = 4;
            QQPlayerService.a(new Intent(localContext, MusicPlayerActivity.class));
            localObject2 = QQPlayerService.n();
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = new Bundle();
              QQPlayerService.a((Bundle)localObject1);
            }
            ((Bundle)localObject1).putString("KEY_SOURCE_NAME", str);
            QQPlayerService.a(this.a);
            QQPlayerService.a(localContext, this.a.getToken(), localSongInfo);
            paramView.setContentDescription(localResources.getString(2131887110));
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.i("CommonHobbyForAIOShowItemBuilder", 0, Log.getStackTraceString(localException));
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.CommonHobbyForAIOShowItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */