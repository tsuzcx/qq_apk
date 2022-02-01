package com.tencent.biz.pubaccount.weishi_new.main;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.pubaccount.weishi_new.ui.videotransition.WSDragFrameLayout;
import com.tencent.biz.pubaccount.weishi_new.ui.videotransition.WSVideoTransitionManager;

class WSMainContainerFragment$1
  implements ViewTreeObserver.OnPreDrawListener
{
  WSMainContainerFragment$1(WSMainContainerFragment paramWSMainContainerFragment, WSDragFrameLayout paramWSDragFrameLayout) {}
  
  public boolean onPreDraw()
  {
    this.a.getViewTreeObserver().removeOnPreDrawListener(this);
    WSMainContainerFragment localWSMainContainerFragment = this.b;
    WSMainContainerFragment.a(localWSMainContainerFragment, this.a, ((WSMainContract.Presenter)WSMainContainerFragment.a(localWSMainContainerFragment)).getIntentFeed());
    WSMainContainerFragment.e(this.b).a(WSMainContainerFragment.b(this.b), WSMainContainerFragment.c(this.b), WSMainContainerFragment.d(this.b));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.main.WSMainContainerFragment.1
 * JD-Core Version:    0.7.0.1
 */