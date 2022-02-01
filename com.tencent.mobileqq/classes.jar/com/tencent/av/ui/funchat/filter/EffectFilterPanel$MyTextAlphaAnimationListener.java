package com.tencent.av.ui.funchat.filter;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.av.AVLog;
import java.lang.ref.WeakReference;

class EffectFilterPanel$MyTextAlphaAnimationListener
  implements Animation.AnimationListener
{
  private WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  
  EffectFilterPanel$MyTextAlphaAnimationListener(EffectFilterPanel paramEffectFilterPanel, View paramView)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    AVLog.printColorLog("EffectFilterPanel", "MyTextAlphaAnimationListener onAnimationEnd :" + localView + "|" + paramAnimation);
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.funchat.filter.EffectFilterPanel.MyTextAlphaAnimationListener
 * JD-Core Version:    0.7.0.1
 */