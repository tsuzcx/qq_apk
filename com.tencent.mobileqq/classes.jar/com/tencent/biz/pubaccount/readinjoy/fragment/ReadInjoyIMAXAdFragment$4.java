package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.animation.Animator;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class ReadInjoyIMAXAdFragment$4
  extends D8SafeAnimatorListener
{
  ReadInjoyIMAXAdFragment$4(ReadInjoyIMAXAdFragment paramReadInjoyIMAXAdFragment) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(null, 110, true, new String[0]);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(null, 110, true, new String[0]);
    if (ReadInjoyIMAXAdFragment.l(this.a) != null)
    {
      ReadInjoyIMAXAdFragment.l(this.a).setVisibility(0);
      ReadInjoyIMAXAdFragment.m(this.a).setVisibility(0);
      ReadInjoyIMAXAdFragment.n(this.a).setVisibility(0);
      ReadInjoyIMAXAdFragment.o(this.a).setVisibility(0);
      if (ReadInjoyIMAXAdFragment.p(this.a) == 1001)
      {
        ReadInjoyIMAXAdFragment.q(this.a).setVisibility(0);
        return;
      }
      if (ReadInjoyIMAXAdFragment.p(this.a) == 1002) {
        ReadInjoyIMAXAdFragment.q(this.a).setVisibility(8);
      }
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(null, 110, false, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInjoyIMAXAdFragment.4
 * JD-Core Version:    0.7.0.1
 */