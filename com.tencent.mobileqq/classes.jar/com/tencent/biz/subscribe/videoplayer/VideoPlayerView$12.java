package com.tencent.biz.subscribe.videoplayer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.SparseBooleanArray;
import android.view.View;
import java.util.HashMap;

class VideoPlayerView$12
  extends AnimatorListenerAdapter
{
  VideoPlayerView$12(VideoPlayerView paramVideoPlayerView, int paramInt1, View paramView, boolean paramBoolean, int paramInt2) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Boolean) {
      VideoPlayerView.a(this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Int, this.b, false);
    }
    while ((this.jdField_a_of_type_Int != 0) || (VideoPlayerView.a() == null) || (VideoPlayerView.a().get(this.jdField_a_of_type_AndroidViewView.getId()))) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if ((this.jdField_a_of_type_Int == 1) && (VideoPlayerView.a() != null) && (!VideoPlayerView.a().get(this.jdField_a_of_type_AndroidViewView.getId()))) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    if ((this.jdField_a_of_type_Int == 0) && (VideoPlayerView.a() != null) && (!VideoPlayerView.a().get(this.jdField_a_of_type_AndroidViewView.getId()))) {
      VideoPlayerView.a().put(this.jdField_a_of_type_AndroidViewView, Integer.valueOf(this.jdField_a_of_type_AndroidViewView.getVisibility()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView.12
 * JD-Core Version:    0.7.0.1
 */