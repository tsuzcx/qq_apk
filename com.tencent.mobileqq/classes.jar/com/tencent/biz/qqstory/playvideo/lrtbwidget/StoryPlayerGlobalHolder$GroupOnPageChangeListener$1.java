package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.view.Gravity;
import xqp;
import xqq;
import yup;

public class StoryPlayerGlobalHolder$GroupOnPageChangeListener$1
  implements Runnable
{
  public StoryPlayerGlobalHolder$GroupOnPageChangeListener$1(xqq paramxqq) {}
  
  public void run()
  {
    if (Gravity.isVertical(this.a.a.a.b()))
    {
      yup.a("play_video", "slide_up_down", 0, 0, new String[] { "1", "", "", "" });
      return;
    }
    yup.a("play_video", "slide_zuoyou", 0, 0, new String[] { "1", "", "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGlobalHolder.GroupOnPageChangeListener.1
 * JD-Core Version:    0.7.0.1
 */