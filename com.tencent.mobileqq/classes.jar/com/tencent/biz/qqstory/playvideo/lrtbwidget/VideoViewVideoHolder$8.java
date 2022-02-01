package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoViewVideoHolder$8
  implements View.OnClickListener
{
  VideoViewVideoHolder$8(VideoViewVideoHolder paramVideoViewVideoHolder, ErrorMessage paramErrorMessage) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_AndroidViewView.getContext()))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_AndroidViewView.getContext(), 1, 2131694422, 0).a();
    }
    else
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
      VideoViewVideoHolder localVideoViewVideoHolder = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("retry ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode);
      localVideoViewVideoHolder.a(10, true, localStringBuilder.toString());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.8
 * JD-Core Version:    0.7.0.1
 */