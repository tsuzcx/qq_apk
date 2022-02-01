package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoHolderBase;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.mobileqq.widget.QQToast;

class BottomVideoInfoWidget$1
  implements View.OnLongClickListener
{
  BottomVideoInfoWidget$1(BottomVideoInfoWidget paramBottomVideoInfoWidget) {}
  
  public boolean onLongClick(View paramView)
  {
    int j = paramView.getId();
    int i = 0;
    boolean bool;
    if (j != 2131431033)
    {
      if ((j != 2131438844) && (j != 2131445753)) {
        return true;
      }
      paramView = (StoryConfigManager)SuperManager.a(10);
      bool = ((Boolean)paramView.c("player_show_debug_panel", Boolean.valueOf(false))).booleanValue() ^ true;
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
          return true;
        }
      }
    }
    else
    {
      paramView = (StoryConfigManager)SuperManager.a(10);
      bool = ((Boolean)paramView.c("player_use_tvk", Boolean.valueOf(false))).booleanValue() ^ true;
      paramView.d("player_use_tvk", Boolean.valueOf(bool));
      paramView = this.a.y();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("UserTVK: ");
      localStringBuilder.append(bool);
      QQToast.makeText(paramView, localStringBuilder.toString(), 0).show();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget.1
 * JD-Core Version:    0.7.0.1
 */