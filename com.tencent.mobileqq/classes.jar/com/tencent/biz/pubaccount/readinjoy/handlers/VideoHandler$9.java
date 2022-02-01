package com.tencent.biz.pubaccount.readinjoy.handlers;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

class VideoHandler$9
  extends AnimatorListenerAdapter
{
  VideoHandler$9(VideoHandler paramVideoHandler) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    VideoHandler.a(this.a).setLayerType(0, null);
    VideoHandler.a(this.a).setVisibility(8);
    VideoHandler.a(this.a).setAlpha(1.0F);
    if (this.a.a() != null) {
      this.a.j();
    }
    VideoHandler.a(this.a).setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.videoanimation", 2, "trans animation end");
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.9
 * JD-Core Version:    0.7.0.1
 */