package com.tencent.biz.qqstory.view.widget;

import android.util.LruCache;
import friendlist.GetOnlineInfoResp;

class StoryQIMBadgeView$1$1
  implements Runnable
{
  StoryQIMBadgeView$1$1(StoryQIMBadgeView.1 param1, GetOnlineInfoResp paramGetOnlineInfoResp, String paramString) {}
  
  public void run()
  {
    boolean bool;
    if (this.a.eIconType == 11) {
      bool = true;
    } else {
      bool = false;
    }
    StoryQIMBadgeView.c().put(this.b, Boolean.valueOf(bool));
    this.c.a.a(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.StoryQIMBadgeView.1.1
 * JD-Core Version:    0.7.0.1
 */