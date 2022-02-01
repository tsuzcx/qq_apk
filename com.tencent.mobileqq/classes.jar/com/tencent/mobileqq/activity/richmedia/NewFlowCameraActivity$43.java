package com.tencent.mobileqq.activity.richmedia;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

class NewFlowCameraActivity$43
  implements Animation.AnimationListener
{
  NewFlowCameraActivity$43(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (NewFlowCameraActivity.b(this.a) != null) {
      NewFlowCameraActivity.b(this.a).setVisibility(4);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.43
 * JD-Core Version:    0.7.0.1
 */