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
  private long jdField_a_of_type_Long = 0L;
  
  CommonHobbyForAIOShowItemBuilder$1(CommonHobbyForAIOShowItemBuilder paramCommonHobbyForAIOShowItemBuilder) {}
  
  public void onClick(View paramView)
  {
    Resources localResources = paramView.getContext().getResources();
    long l = SystemClock.uptimeMillis();
    if (l - this.jdField_a_of_type_Long >= 500L)
    {
      this.jdField_a_of_type_Long = l;
      if ((paramView.getTag() != null) && ((paramView.getTag() instanceof JSONObject))) {
        break label56;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label56:
      Object localObject2 = (JSONObject)paramView.getTag();
      String str2;
      Context localContext;
      try
      {
        String str1 = ((JSONObject)localObject2).getString("url");
        str2 = ((JSONObject)localObject2).getString("name");
        localContext = paramView.getContext();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCommonHobbyForAIOShowItemBuilder.a != null) {
          MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCommonHobbyForAIOShowItemBuilder.a).a(true);
        }
        if (!QQPlayerService.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCommonHobbyForAIOShowItemBuilder)) {
          break label164;
        }
        QQPlayerService.c(localContext);
        paramView.setContentDescription(localResources.getString(2131690294));
      }
      catch (Exception localException) {}
      if (QLog.isColorLevel())
      {
        QLog.i("CommonHobbyForAIOShowItemBuilder", 0, Log.getStackTraceString(localException));
        continue;
        label164:
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCommonHobbyForAIOShowItemBuilder.a != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCommonHobbyForAIOShowItemBuilder.a.isVideoChatting()))
        {
          if (QLog.isColorLevel()) {
            QLog.i("CommonHobbyForAIOShowItemBuilder", 0, "Video Chatting is going on, don't play music.");
          }
        }
        else
        {
          SongInfo localSongInfo = new SongInfo();
          localSongInfo.jdField_b_of_type_JavaLangString = localException;
          localSongInfo.jdField_b_of_type_Int = 4;
          QQPlayerService.a(new Intent(localContext, MusicPlayerActivity.class));
          localObject2 = QQPlayerService.a();
          Object localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new Bundle();
            QQPlayerService.a((Bundle)localObject1);
          }
          ((Bundle)localObject1).putString("KEY_SOURCE_NAME", str2);
          QQPlayerService.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCommonHobbyForAIOShowItemBuilder);
          QQPlayerService.a(localContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCommonHobbyForAIOShowItemBuilder.getToken(), localSongInfo);
          paramView.setContentDescription(localResources.getString(2131690292));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.CommonHobbyForAIOShowItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */