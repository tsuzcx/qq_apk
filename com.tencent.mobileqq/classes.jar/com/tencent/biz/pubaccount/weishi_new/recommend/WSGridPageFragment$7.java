package com.tencent.biz.pubaccount.weishi_new.recommend;

import android.os.Build.VERSION;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.view.WSXRecyclerView;

class WSGridPageFragment$7
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  WSGridPageFragment$7(WSGridPageFragment paramWSGridPageFragment) {}
  
  public void onGlobalLayout()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSGridPageFragment.java][onGlobalLayout] mSubTabId:");
    ((StringBuilder)localObject).append(WSGridPageFragment.b(this.a));
    WSLog.e("WSGridPageFragmentLog", ((StringBuilder)localObject).toString());
    if (Build.VERSION.SDK_INT >= 16) {
      WSGridPageFragment.d(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
    } else {
      WSGridPageFragment.d(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
    localObject = this.a;
    ((WSGridPageFragment)localObject).b(true, ((WSGridPageContract.Presenter)((WSGridPageFragment)localObject).aO_()).f());
    WSGridPageFragment.h(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.WSGridPageFragment.7
 * JD-Core Version:    0.7.0.1
 */