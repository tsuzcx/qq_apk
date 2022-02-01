package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class CloseBtnGroupHolder$1
  implements View.OnClickListener
{
  CloseBtnGroupHolder$1(CloseBtnGroupHolder paramCloseBtnGroupHolder) {}
  
  public void onClick(View paramView)
  {
    Object localObject = ((StoryPlayerGroupHolder)this.a.a()).a();
    if (localObject != null) {
      ((VideoViewVideoHolder)localObject).d = 2;
    }
    this.a.a().finish();
    String str = "";
    localObject = str;
    if (this.a.jdField_a_of_type_Int >= 0)
    {
      localObject = str;
      if (this.a.jdField_a_of_type_Int < this.a.jdField_a_of_type_JavaUtilList.size()) {
        localObject = ((StoryPlayerVideoData)this.a.jdField_a_of_type_JavaUtilList.get(this.a.jdField_a_of_type_Int)).a;
      }
    }
    StoryReportor.a("play_video", "clk_quit", 0, 0, new String[] { "", "", "", localObject });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.CloseBtnGroupHolder.1
 * JD-Core Version:    0.7.0.1
 */