package com.tencent.biz.pubaccount.weishi_new.main;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.pubaccount.weishi_new.WSFragmentAdapter;
import com.tencent.biz.pubaccount.weishi_new.ui.videotransition.WSDragFrameLayout.OnDragListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;

class WSMainContainerFragment$4
  implements WSDragFrameLayout.OnDragListener
{
  WSMainContainerFragment$4(WSMainContainerFragment paramWSMainContainerFragment) {}
  
  public void a()
  {
    ((WSVerticalPageContract.View)WSMainContainerFragment.i(this.a).a(0)).x();
    WSMainContainerFragment localWSMainContainerFragment = this.a;
    WSMainContainerFragment.a(localWSMainContainerFragment, ((WSMainContract.Presenter)WSMainContainerFragment.j(localWSMainContainerFragment)).getIntentFeedId(), WSMainContainerFragment.h(this.a), false);
  }
  
  public void a(boolean paramBoolean)
  {
    ((WSVerticalPageContract.View)WSMainContainerFragment.i(this.a).a(0)).y();
    if (paramBoolean)
    {
      FragmentActivity localFragmentActivity = this.a.getActivity();
      if (localFragmentActivity != null) {
        localFragmentActivity.onBackPressed();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.main.WSMainContainerFragment.4
 * JD-Core Version:    0.7.0.1
 */