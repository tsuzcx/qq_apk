package com.tencent.aelight.camera.ae.camera.ui.bottom;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;

class AEBottomListPart$13
  implements Animation.AnimationListener
{
  AEBottomListPart$13(AEBottomListPart paramAEBottomListPart, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.b.b != null) && (!AEBottomListPart.e(this.b)))
    {
      this.b.b.setAlpha(1.0F);
      this.b.b.setVisibility(4);
    }
    if (AEBottomListPart.l(this.b) != null)
    {
      AEBottomListPart.m(this.b).b(this.a, new Object[0]);
      AEBottomListPart.n(this.b).b(196612, new Object[0]);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.b.a.am().a(true, 150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart.13
 * JD-Core Version:    0.7.0.1
 */