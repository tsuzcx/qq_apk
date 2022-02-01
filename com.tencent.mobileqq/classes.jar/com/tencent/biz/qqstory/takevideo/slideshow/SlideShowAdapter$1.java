package com.tencent.biz.qqstory.takevideo.slideshow;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SlideShowAdapter$1
  implements View.OnClickListener
{
  SlideShowAdapter$1(SlideShowAdapter paramSlideShowAdapter, SlideShowAdapter.SlideShowViewHolder paramSlideShowViewHolder) {}
  
  public void onClick(View paramView)
  {
    if (SlideShowAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowAdapter) != null) {
      SlideShowAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowAdapter).a((SlideItemInfo)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowAdapter$SlideShowViewHolder.a.getTag());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideShowAdapter.1
 * JD-Core Version:    0.7.0.1
 */