package com.tencent.biz.pubaccount.readinjoy.video;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;

class VideoFeedsSoftAdBarDelegateForNormal$2
  extends AnimatorListenerAdapter
{
  VideoFeedsSoftAdBarDelegateForNormal$2(VideoFeedsSoftAdBarDelegateForNormal paramVideoFeedsSoftAdBarDelegateForNormal, int paramInt) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    if (VideoFeedsSoftAdBarDelegateForNormal.a(this.b).bE != null) {
      VideoFeedsSoftAdBarDelegateForNormal.a(this.b).bE.setTag(2131428370, null);
    }
    paramAnimator = this.b;
    paramAnimator.b(VideoFeedsSoftAdBarDelegateForNormal.a(paramAnimator));
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    paramAnimator = this.b.b();
    VideoFeedsSoftAdBarDelegateForNormal localVideoFeedsSoftAdBarDelegateForNormal = this.b;
    VideoFeedsSoftAdBarDelegateForNormal.a(localVideoFeedsSoftAdBarDelegateForNormal, VideoFeedsSoftAdBarDelegateForNormal.a(localVideoFeedsSoftAdBarDelegateForNormal).bu, paramAnimator, this.a, 18, -1);
    if (VideoFeedsSoftAdBarDelegateForNormal.a(this.b).bE != null) {
      VideoFeedsSoftAdBarDelegateForNormal.a(this.b).bE.setTag(2131428370, null);
    }
    paramAnimator = this.b;
    paramAnimator.c(VideoFeedsSoftAdBarDelegateForNormal.a(paramAnimator));
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    paramAnimator = this.b;
    paramAnimator.a(VideoFeedsSoftAdBarDelegateForNormal.a(paramAnimator));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsSoftAdBarDelegateForNormal.2
 * JD-Core Version:    0.7.0.1
 */