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
    paramView = (StoryConfigManager)SuperManager.a(10);
    int i = 0;
    boolean bool = ((Boolean)paramView.c("player_show_debug_panel", Boolean.valueOf(false))).booleanValue() ^ true;
    paramView.d("player_show_debug_panel", Boolean.valueOf(bool));
    paramView = ((StoryPlayerGroupHolder)this.a.d()).h();
    if (paramView != null)
    {
      paramView = (VideoViewVideoHolder)paramView.a(VideoViewVideoHolder.class);
      if (paramView != null)
      {
        if (!bool) {
          i = 8;
        }
        paramView.a(i);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.MoreVideoInfoWidget.1
 * JD-Core Version:    0.7.0.1
 */