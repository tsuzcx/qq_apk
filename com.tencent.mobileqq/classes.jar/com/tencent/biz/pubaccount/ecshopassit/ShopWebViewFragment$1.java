package com.tencent.biz.pubaccount.ecshopassit;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ShopWebViewFragment$1
  implements View.OnClickListener
{
  ShopWebViewFragment$1(ShopWebViewFragment paramShopWebViewFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.g != null) {
      this.a.g.b(this.a.getQBaseActivity(), this.a.h[0]);
    }
    try
    {
      this.a.g.f.a(134248548, null, null, null, null, 0L, false);
      label57:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label57;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.ShopWebViewFragment.1
 * JD-Core Version:    0.7.0.1
 */