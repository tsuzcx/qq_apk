package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.qqstory.album.model.StoryAlbum;
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
    if ((paramView == paramBaseViewHolder.a(2131375010)) || (paramView == paramBaseViewHolder.a(2131375011)) || (paramView == paramBaseViewHolder.a(2131375014))) {
      if (LocalVideoPushSegment.a(this.a)) {
        SLog.d("Q.qqstory.home.LocalVideoPushSegment", "now is opening the new page, so ignore the click");
      }
    }
    while (paramView != paramBaseViewHolder.a(2131375009))
    {
      return;
      LocalVideoPushSegment.a(this.a, true);
      paramObject = new Bundle();
      paramObject.putInt("capture_intent_mode", 3);
      if (LocalVideoPushSegment.a(this.a) == 1) {
        paramObject.putString("story_capture_album_id", "default_id");
      }
      for (;;)
      {
        StoryPublishLauncher.a().a((Activity)LocalVideoPushSegment.a(this.a), paramObject, 20000);
        StoryReportor.a("home_page", "clk_smartalbum", 0, 0, new String[] { LocalVideoPushSegment.a(this.a, LocalVideoPushSegment.a(this.a)) });
        return;
        if (LocalVideoPushSegment.a(this.a) == 2)
        {
          if (LocalVideoPushSegment.a(this.a) != null) {}
          for (paramView = String.valueOf(LocalVideoPushSegment.a(this.a).a());; paramView = "default_id")
          {
            paramObject.putString("story_capture_album_id", paramView);
            break;
          }
        }
        if (LocalVideoPushSegment.a(this.a) != 3) {}
      }
    }
    this.a.a.b("last_cancel_time", Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
    this.a.a(null, 4);
    StoryReportor.a("home_page", "close_smartalbum", 0, 0, new String[] { LocalVideoPushSegment.a(this.a, LocalVideoPushSegment.a(this.a)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.LocalVideoPushSegment.4
 * JD-Core Version:    0.7.0.1
 */