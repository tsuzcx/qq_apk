package com.tencent.biz.qqstory.takevideo.slideshow;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SlideShowAdapter$2
  implements View.OnClickListener
{
  SlideShowAdapter$2(SlideShowAdapter paramSlideShowAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (SlideShowAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowAdapter) != null) {
      SlideShowAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowAdapter).a(this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideShowAdapter.2
 * JD-Core Version:    0.7.0.1
 */