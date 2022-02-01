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
    if (this.c)
    {
      VideoPlayerView.a(this.e, this.b, this.a, this.d, false);
      return;
    }
    if ((this.a == 0) && (VideoPlayerView.x() != null) && (!VideoPlayerView.x().get(this.b.getId()))) {
      this.b.setVisibility(8);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if ((this.a == 1) && (VideoPlayerView.x() != null) && (!VideoPlayerView.x().get(this.b.getId()))) {
      this.b.setVisibility(0);
    }
    if ((this.a == 0) && (VideoPlayerView.x() != null) && (!VideoPlayerView.x().get(this.b.getId())))
    {
      paramAnimator = VideoPlayerView.y();
      View localView = this.b;
      paramAnimator.put(localView, Integer.valueOf(localView.getVisibility()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView.12
 * JD-Core Version:    0.7.0.1
 */