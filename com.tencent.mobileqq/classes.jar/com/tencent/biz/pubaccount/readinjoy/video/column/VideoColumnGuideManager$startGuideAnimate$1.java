package com.tencent.biz.pubaccount.readinjoy.video.column;

import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class VideoColumnGuideManager$startGuideAnimate$1
  implements Runnable
{
  VideoColumnGuideManager$startGuideAnimate$1(VideoColumnGuideManager paramVideoColumnGuideManager) {}
  
  public final void run()
  {
    DiniFlyAnimationView localDiniFlyAnimationView = VideoColumnGuideManager.a(this.this$0);
    if (localDiniFlyAnimationView != null) {
      localDiniFlyAnimationView.addAnimatorListener((Animator.AnimatorListener)new VideoColumnGuideManager.startGuideAnimate.1.1(this));
    }
    localDiniFlyAnimationView = VideoColumnGuideManager.a(this.this$0);
    if (localDiniFlyAnimationView != null) {
      localDiniFlyAnimationView.resumeAnimation();
    }
    VideoColumnGuideManager.d(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.column.VideoColumnGuideManager.startGuideAnimate.1
 * JD-Core Version:    0.7.0.1
 */