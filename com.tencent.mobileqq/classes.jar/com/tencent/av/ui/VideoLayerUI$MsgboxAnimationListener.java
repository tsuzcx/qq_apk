package com.tencent.av.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.av.widget.RotateLayout;

class VideoLayerUI$MsgboxAnimationListener
  implements Animation.AnimationListener
{
  private VideoLayerUI$MsgboxAnimationListener(VideoLayerUI paramVideoLayerUI) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    VideoLayerUI.a(this.a).setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI.MsgboxAnimationListener
 * JD-Core Version:    0.7.0.1
 */