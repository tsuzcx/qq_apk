package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;

class ReadInjoyIMAXAdFragment$4
  implements Animator.AnimatorListener
{
  ReadInjoyIMAXAdFragment$4(ReadInjoyIMAXAdFragment paramReadInjoyIMAXAdFragment) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(null, 110, true, null);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(null, 110, true, null);
    if (ReadInjoyIMAXAdFragment.a(this.a) != null)
    {
      ReadInjoyIMAXAdFragment.a(this.a).setVisibility(0);
      ReadInjoyIMAXAdFragment.b(this.a).setVisibility(0);
      ReadInjoyIMAXAdFragment.c(this.a).setVisibility(0);
      ReadInjoyIMAXAdFragment.b(this.a).setVisibility(0);
      if (ReadInjoyIMAXAdFragment.e(this.a) != 1001) {
        break label90;
      }
      ReadInjoyIMAXAdFragment.c(this.a).setVisibility(0);
    }
    label90:
    while (ReadInjoyIMAXAdFragment.e(this.a) != 1002) {
      return;
    }
    ReadInjoyIMAXAdFragment.c(this.a).setVisibility(8);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(null, 110, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInjoyIMAXAdFragment.4
 * JD-Core Version:    0.7.0.1
 */