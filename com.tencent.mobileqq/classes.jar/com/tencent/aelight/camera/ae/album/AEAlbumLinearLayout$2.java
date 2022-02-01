package com.tencent.aelight.camera.ae.album;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class AEAlbumLinearLayout$2
  extends D8SafeAnimatorListener
{
  AEAlbumLinearLayout$2(AEAlbumLinearLayout paramAEAlbumLinearLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    AEAlbumLinearLayout.b(this.a, 0);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (AEAlbumLinearLayout.a(this.a) != null)
    {
      paramAnimator = AEAlbumLinearLayout.a(this.a);
      int i = AEAlbumLinearLayout.c(this.a);
      AEAlbumLinearLayout localAEAlbumLinearLayout = this.a;
      paramAnimator.a(i, AEAlbumLinearLayout.a(localAEAlbumLinearLayout, AEAlbumLinearLayout.c(localAEAlbumLinearLayout)));
    }
    AEAlbumLinearLayout.b(this.a, 0);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (AEAlbumLinearLayout.a(this.a) != null) {
      AEAlbumLinearLayout.a(this.a).a(AEAlbumLinearLayout.c(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.AEAlbumLinearLayout.2
 * JD-Core Version:    0.7.0.1
 */