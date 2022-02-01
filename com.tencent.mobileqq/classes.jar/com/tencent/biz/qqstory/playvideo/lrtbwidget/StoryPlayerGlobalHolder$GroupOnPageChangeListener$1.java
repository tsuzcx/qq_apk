package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.view.Gravity;
import com.tencent.biz.qqstory.support.report.StoryReportor;

class StoryPlayerGlobalHolder$GroupOnPageChangeListener$1
  implements Runnable
{
  StoryPlayerGlobalHolder$GroupOnPageChangeListener$1(StoryPlayerGlobalHolder.GroupOnPageChangeListener paramGroupOnPageChangeListener) {}
  
  public void run()
  {
    if (Gravity.isVertical(this.a.a.a.b()))
    {
      StoryReportor.a("play_video", "slide_up_down", 0, 0, new String[] { "1", "", "", "" });
      return;
    }
    StoryReportor.a("play_video", "slide_zuoyou", 0, 0, new String[] { "1", "", "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGlobalHolder.GroupOnPageChangeListener.1
 * JD-Core Version:    0.7.0.1
 */