package com.tencent.biz.qqstory.takevideo;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.transfile.StoryUploadProcessor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class TakeVideoButtonMainPart
  implements View.OnClickListener
{
  protected long a;
  protected View a;
  public TakeVideoButtonMainPart.OnTakeVideoButtonClickListener a;
  
  public TakeVideoButtonMainPart(TakeVideoButtonMainPart.OnTakeVideoButtonClickListener paramOnTakeVideoButtonClickListener, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTakeVideoButtonMainPart$OnTakeVideoButtonClickListener = paramOnTakeVideoButtonClickListener;
    this.jdField_a_of_type_AndroidViewView = paramView;
    paramView.setOnClickListener(this);
  }
  
  private boolean a()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.jdField_a_of_type_Long;
    if ((l2 > 0L) && (l2 < 2000L)) {
      return true;
    }
    this.jdField_a_of_type_Long = l1;
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (!a())
    {
      StoryReportor.a("home_page", "clk_shoot", 0, 0, new String[0]);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTakeVideoButtonMainPart$OnTakeVideoButtonClickListener.a();
    }
    StoryUploadProcessor.checkUploadSessionKey();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.TakeVideoButtonMainPart
 * JD-Core Version:    0.7.0.1
 */