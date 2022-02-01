package com.tencent.biz.pubaccount.weishi_new.main;

import android.app.Activity;
import com.tencent.biz.pubaccount.weishi_new.ui.videotransition.WSVideoTransitionManager.OnExitAnimEndListener;

class WSMainContainerFragment$3
  implements WSVideoTransitionManager.OnExitAnimEndListener
{
  WSMainContainerFragment$3(WSMainContainerFragment paramWSMainContainerFragment) {}
  
  public void a()
  {
    Object localObject = this.a;
    WSMainContainerFragment.a((WSMainContainerFragment)localObject, ((WSMainContract.Presenter)WSMainContainerFragment.g((WSMainContainerFragment)localObject)).getIntentFeedId(), WSMainContainerFragment.h(this.a), true);
    localObject = this.a.getActivity();
    if (localObject != null)
    {
      ((Activity)localObject).finish();
      ((Activity)localObject).overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.main.WSMainContainerFragment.3
 * JD-Core Version:    0.7.0.1
 */