package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.view.Gravity;
import xgv;
import xgw;
import ykv;

public class StoryPlayerGlobalHolder$GroupOnPageChangeListener$1
  implements Runnable
{
  public StoryPlayerGlobalHolder$GroupOnPageChangeListener$1(xgw paramxgw) {}
  
  public void run()
  {
    if (Gravity.isVertical(this.a.a.a.b()))
    {
      ykv.a("play_video", "slide_up_down", 0, 0, new String[] { "1", "", "", "" });
      return;
    }
    ykv.a("play_video", "slide_zuoyou", 0, 0, new String[] { "1", "", "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGlobalHolder.GroupOnPageChangeListener.1
 * JD-Core Version:    0.7.0.1
 */