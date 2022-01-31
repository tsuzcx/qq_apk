package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.view.Gravity;
import uai;
import uaj;
import vei;

public class StoryPlayerGlobalHolder$GroupOnPageChangeListener$1
  implements Runnable
{
  public StoryPlayerGlobalHolder$GroupOnPageChangeListener$1(uaj paramuaj) {}
  
  public void run()
  {
    if (Gravity.isVertical(this.a.a.a.b()))
    {
      vei.a("play_video", "slide_up_down", 0, 0, new String[] { "1", "", "", "" });
      return;
    }
    vei.a("play_video", "slide_zuoyou", 0, 0, new String[] { "1", "", "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGlobalHolder.GroupOnPageChangeListener.1
 * JD-Core Version:    0.7.0.1
 */