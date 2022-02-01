package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoHolderBase;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

class MoreVideoInfoWidget$1
  implements View.OnLongClickListener
{
  MoreVideoInfoWidget$1(MoreVideoInfoWidget paramMoreVideoInfoWidget) {}
  
  public boolean onLongClick(View paramView)
  {
    int i = 0;
    paramView = (StoryConfigManager)SuperManager.a(10);
    boolean bool;
    if (!((Boolean)paramView.b("player_show_debug_panel", Boolean.valueOf(false))).booleanValue())
    {
      bool = true;
      paramView.b("player_show_debug_panel", Boolean.valueOf(bool));
      paramView = ((StoryPlayerGroupHolder)this.a.a()).a();
      if (paramView != null)
      {
        paramView = (VideoViewVideoHolder)paramView.a(VideoViewVideoHolder.class);
        if (paramView != null) {
          if (!bool) {
            break label90;
          }
        }
      }
    }
    for (;;)
    {
      paramView.a(i);
      return true;
      bool = false;
      break;
      label90:
      i = 8;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.MoreVideoInfoWidget.1
 * JD-Core Version:    0.7.0.1
 */