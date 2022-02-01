package com.tencent.biz.pubaccount.ecshopassit;

import android.view.View;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;

class BusinessBrowser$BusinessBrowserFragment$3
  implements TouchWebView.OnScrollChangedListener
{
  BusinessBrowser$BusinessBrowserFragment$3(BusinessBrowser.BusinessBrowserFragment paramBusinessBrowserFragment) {}
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    paramInt1 = paramInt2 - paramInt4;
    if (paramInt1 > 0)
    {
      if (this.a.n < 0) {
        this.a.n = 0;
      }
      paramView = this.a;
      paramView.n += paramInt1;
      if ((this.a.n > this.a.r) && (this.a.o))
      {
        paramView = this.a;
        paramView.o = false;
        if (paramView.d != null)
        {
          paramView = this.a;
          paramView.a(paramView.j, 0);
          this.a.d.clearAnimation();
          this.a.d.startAnimation(this.a.q);
        }
      }
    }
    else
    {
      if (this.a.n > 0) {
        this.a.n = 0;
      }
      paramView = this.a;
      paramView.n += paramInt1;
      if ((-this.a.n > this.a.r) && (!this.a.o))
      {
        paramView = this.a;
        paramView.o = true;
        if (paramView.d != null)
        {
          this.a.d.clearAnimation();
          this.a.d.startAnimation(this.a.p);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.BusinessBrowser.BusinessBrowserFragment.3
 * JD-Core Version:    0.7.0.1
 */