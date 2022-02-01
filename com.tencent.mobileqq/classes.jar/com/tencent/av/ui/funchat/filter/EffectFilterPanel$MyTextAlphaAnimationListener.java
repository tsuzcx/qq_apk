package com.tencent.av.ui.funchat.filter;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.av.AVLog;
import java.lang.ref.WeakReference;

class EffectFilterPanel$MyTextAlphaAnimationListener
  implements Animation.AnimationListener
{
  private WeakReference<View> b;
  
  EffectFilterPanel$MyTextAlphaAnimationListener(EffectFilterPanel paramEffectFilterPanel, View paramView)
  {
    this.b = new WeakReference(paramView);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    View localView = (View)this.b.get();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MyTextAlphaAnimationListener onAnimationEnd :");
    localStringBuilder.append(localView);
    localStringBuilder.append("|");
    localStringBuilder.append(paramAnimation);
    AVLog.printColorLog("EffectFilterPanel", localStringBuilder.toString());
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.filter.EffectFilterPanel.MyTextAlphaAnimationListener
 * JD-Core Version:    0.7.0.1
 */