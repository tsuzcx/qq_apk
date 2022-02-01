package com.tencent.biz.qqstory.playvideo.playerwidget;

import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager.SimpleOnPageChangeListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

class AbsVideoInfoWidget$1
  extends XViewPager.SimpleOnPageChangeListener
{
  AbsVideoInfoWidget$1(AbsVideoInfoWidget paramAbsVideoInfoWidget, StoryPlayerGroupHolder paramStoryPlayerGroupHolder) {}
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    paramInt = this.a.l;
    if ((paramInt < this.b.f.size()) && (paramInt >= 0))
    {
      StoryPlayerVideoData localStoryPlayerVideoData = (StoryPlayerVideoData)this.b.f.get(paramInt);
      AbsVideoInfoWidget.a(this.b, localStoryPlayerVideoData);
      return;
    }
    SLog.d(this.b.i, "Position error , get data error, current position = %d , size = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.b.f.size()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget.1
 * JD-Core Version:    0.7.0.1
 */