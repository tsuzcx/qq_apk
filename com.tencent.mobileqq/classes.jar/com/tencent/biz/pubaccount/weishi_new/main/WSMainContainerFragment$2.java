package com.tencent.biz.pubaccount.weishi_new.main;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.weishi_new.ui.videotransition.WSDragFrameLayout;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WSMainContainerFragment$2
  implements ViewPager.OnPageChangeListener
{
  WSMainContainerFragment$2(WSMainContainerFragment paramWSMainContainerFragment) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSVerticalMainFragment.java][initAdapter] onPageSelected position:");
    ((StringBuilder)localObject).append(paramInt);
    WSLog.d("WSVerticalMainFragment", ((StringBuilder)localObject).toString());
    WSMainContainerFragment.a(this.a, paramInt);
    ((WSMainContract.Presenter)this.a.aO_()).onRightLeftPageSelected(paramInt);
    localObject = WSMainContainerFragment.b(this.a);
    boolean bool2 = true;
    boolean bool1;
    if (paramInt == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((WSDragFrameLayout)localObject).setEnableDragHorizontal(bool1);
    localObject = WSMainContainerFragment.b(this.a);
    if ((paramInt == 0) && (WSMainContainerFragment.f(this.a))) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    ((WSDragFrameLayout)localObject).setEnableDragVertical(bool1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.main.WSMainContainerFragment.2
 * JD-Core Version:    0.7.0.1
 */