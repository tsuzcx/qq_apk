package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.view.Gravity;
import vpa;
import vpb;
import wta;

public class StoryPlayerGlobalHolder$GroupOnPageChangeListener$1
  implements Runnable
{
  public StoryPlayerGlobalHolder$GroupOnPageChangeListener$1(vpb paramvpb) {}
  
  public void run()
  {
    if (Gravity.isVertical(this.a.a.a.b()))
    {
      wta.a("play_video", "slide_up_down", 0, 0, new String[] { "1", "", "", "" });
      return;
    }
    wta.a("play_video", "slide_zuoyou", 0, 0, new String[] { "1", "", "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGlobalHolder.GroupOnPageChangeListener.1
 * JD-Core Version:    0.7.0.1
 */