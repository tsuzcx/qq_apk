package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoViewVideoHolder$9
  implements View.OnClickListener
{
  VideoViewVideoHolder$9(VideoViewVideoHolder paramVideoViewVideoHolder) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.g(this.a.jdField_a_of_type_AndroidViewView.getContext())) {
      QQToast.a(this.a.jdField_a_of_type_AndroidViewView.getContext(), 1, 2131694457, 0).a();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      SLog.d(this.a.jdField_a_of_type_JavaLangString, "video view error, retry, show loading view");
      this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(0);
      this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
      this.a.a(10, true, "retry play");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.9
 * JD-Core Version:    0.7.0.1
 */