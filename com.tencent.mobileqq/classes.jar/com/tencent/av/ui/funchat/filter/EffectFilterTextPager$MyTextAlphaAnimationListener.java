package com.tencent.av.ui.funchat.filter;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.av.AVLog;
import java.lang.ref.WeakReference;

class EffectFilterTextPager$MyTextAlphaAnimationListener
  implements Animation.AnimationListener
{
  private WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  
  EffectFilterTextPager$MyTextAlphaAnimationListener(EffectFilterTextPager paramEffectFilterTextPager, View paramView)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    AVLog.printColorLog("EffectFilterTextPager", "onAnimationEnd :" + localView + "|" + paramAnimation);
    if (localView != null) {
      localView.setVisibility(4);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.funchat.filter.EffectFilterTextPager.MyTextAlphaAnimationListener
 * JD-Core Version:    0.7.0.1
 */