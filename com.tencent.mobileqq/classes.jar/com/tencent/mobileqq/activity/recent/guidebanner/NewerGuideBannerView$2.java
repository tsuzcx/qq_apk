package com.tencent.mobileqq.activity.recent.guidebanner;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

class NewerGuideBannerView$2
  implements LifecycleObserver
{
  NewerGuideBannerView$2(NewerGuideBannerView paramNewerGuideBannerView) {}
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onDestroy(LifecycleOwner paramLifecycleOwner)
  {
    NewerGuideBannerView.a(this.a);
    NewerGuideBannerView.b(this.a);
    paramLifecycleOwner.getLifecycle().removeObserver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerView.2
 * JD-Core Version:    0.7.0.1
 */