package com.tencent.biz.qqstory.playvideo.playerwidget;

import com.tencent.biz.qqstory.playvideo.lrtbwidget.SimpleActivityLifeCycle;
import com.tencent.biz.qqstory.support.logging.SLog;

public class AbsVideoInfoWidget$MyActivityLifeCycle
  extends SimpleActivityLifeCycle
{
  public AbsVideoInfoWidget$MyActivityLifeCycle(AbsVideoInfoWidget paramAbsVideoInfoWidget) {}
  
  public void h()
  {
    super.h();
    if (this.a.m)
    {
      AbsVideoInfoWidget.a(this.a);
      SLog.b(this.a.i, "destroy by activity");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget.MyActivityLifeCycle
 * JD-Core Version:    0.7.0.1
 */