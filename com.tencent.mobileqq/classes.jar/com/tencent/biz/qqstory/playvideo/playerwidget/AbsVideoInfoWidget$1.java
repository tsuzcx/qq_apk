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
    paramInt = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.b;
    if ((paramInt < this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.a.size()) && (paramInt >= 0))
    {
      StoryPlayerVideoData localStoryPlayerVideoData = (StoryPlayerVideoData)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.a.get(paramInt);
      AbsVideoInfoWidget.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget, localStoryPlayerVideoData);
      return;
    }
    SLog.d(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.b, "Position error , get data error, current position = %d , size = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.a.size()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget.1
 * JD-Core Version:    0.7.0.1
 */