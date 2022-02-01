package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.ComponentName;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MusicPlayerBannerProcessor$1
  implements View.OnClickListener
{
  MusicPlayerBannerProcessor$1(MusicPlayerBannerProcessor paramMusicPlayerBannerProcessor) {}
  
  public void onClick(View paramView)
  {
    Object localObject = QQPlayerService.a();
    int i;
    if (localObject != null)
    {
      MusicPlayerBannerProcessor.a(this.a).startActivity((Intent)localObject);
      localObject = ((Intent)localObject).getComponent().getClassName();
      if (!((String)localObject).equals(MusicPlayerActivity.class.getName())) {
        break label132;
      }
      i = 0;
    }
    for (;;)
    {
      ReportController.a(MusicPlayerBannerProcessor.b(this.a).getAppRuntime(), "dc00898", "", "", "0X8009EE4", "0X8009EE4", 1, 0, "", "", "", "");
      ReportController.b(MusicPlayerBannerProcessor.c(this.a).getAppRuntime(), "CliOper", "", "", "Msg_tab", "Mt_music_tips", 0, 0, "" + i, "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label132:
      if (((String)localObject).equals(MusicGeneQQBrowserActivity.class.getName())) {
        i = 1;
      } else {
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.MusicPlayerBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */