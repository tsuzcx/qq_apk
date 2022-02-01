package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.ChildViewClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

class LocalVideoPushSegment$4
  extends ChildViewClickListener
{
  LocalVideoPushSegment$4(LocalVideoPushSegment paramLocalVideoPushSegment) {}
  
  public void a(int paramInt, View paramView, Object paramObject, BaseViewHolder paramBaseViewHolder)
  {
    if ((paramView != paramBaseViewHolder.a(2131442711)) && (paramView != paramBaseViewHolder.a(2131442712)) && (paramView != paramBaseViewHolder.a(2131442715)))
    {
      if (paramView == paramBaseViewHolder.a(2131442710))
      {
        this.a.a.d("last_cancel_time", Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
        this.a.a(null, 4);
        paramView = this.a;
        StoryReportor.a("home_page", "close_smartalbum", 0, 0, new String[] { LocalVideoPushSegment.a(paramView, LocalVideoPushSegment.e(paramView)) });
      }
    }
    else
    {
      if (LocalVideoPushSegment.d(this.a))
      {
        SLog.d("Q.qqstory.home.LocalVideoPushSegment", "now is opening the new page, so ignore the click");
        return;
      }
      LocalVideoPushSegment.a(this.a, true);
      paramView = new Bundle();
      paramView.putInt("capture_intent_mode", 3);
      if ((LocalVideoPushSegment.e(this.a) != 1) && (LocalVideoPushSegment.e(this.a) != 2)) {
        LocalVideoPushSegment.e(this.a);
      }
      StoryPublishLauncher.a().a((Activity)LocalVideoPushSegment.f(this.a), paramView, 20000);
      paramView = this.a;
      StoryReportor.a("home_page", "clk_smartalbum", 0, 0, new String[] { LocalVideoPushSegment.a(paramView, LocalVideoPushSegment.e(paramView)) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.LocalVideoPushSegment.4
 * JD-Core Version:    0.7.0.1
 */