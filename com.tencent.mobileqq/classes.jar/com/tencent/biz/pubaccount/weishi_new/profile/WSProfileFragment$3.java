package com.tencent.biz.pubaccount.weishi_new.profile;

import com.tencent.biz.pubaccount.weishi_new.profile.toolbar.WSProfileToolbarController;
import com.tencent.biz.pubaccount.weishi_new.ui.WSBehaviorSuite.OnViewTranslateListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.view.WSSwipeRefreshLayout;
import com.tencent.biz.pubaccount.weishi_new.view.WSViewPager;

class WSProfileFragment$3
  implements WSBehaviorSuite.OnViewTranslateListener
{
  WSProfileFragment$3(WSProfileFragment paramWSProfileFragment) {}
  
  public void a(float paramFloat, int paramInt)
  {
    WSProfileFragment.e(this.a).a(paramInt);
    Object localObject = this.a;
    ((WSProfileFragment)localObject).a(WSProfileFragment.e((WSProfileFragment)localObject).a());
    localObject = WSProfileFragment.f(this.a);
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((WSSwipeRefreshLayout)localObject).setEnabled(bool);
    WSProfileFragment.g(this.a).requestDisallowInterceptTouchEvent(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.WSProfileFragment.3
 * JD-Core Version:    0.7.0.1
 */