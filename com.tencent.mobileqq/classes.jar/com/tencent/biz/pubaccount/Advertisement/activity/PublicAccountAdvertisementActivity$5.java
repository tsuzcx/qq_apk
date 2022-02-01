package com.tencent.biz.pubaccount.Advertisement.activity;

import com.tencent.biz.pubaccount.Advertisement.fragment.WebpageFragment;
import com.tencent.biz.pubaccount.Advertisement.view.VerticalPagerView.OnInterceptTouchListener;
import com.tencent.biz.pubaccount.CustomWebView;

class PublicAccountAdvertisementActivity$5
  implements VerticalPagerView.OnInterceptTouchListener
{
  PublicAccountAdvertisementActivity$5(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity) {}
  
  public boolean a(int paramInt)
  {
    return (PublicAccountAdvertisementActivity.s(this.a)) && (PublicAccountAdvertisementActivity.f(this.a));
  }
  
  public boolean b(int paramInt)
  {
    return (PublicAccountAdvertisementActivity.s(this.a)) && (!PublicAccountAdvertisementActivity.f(this.a)) && (PublicAccountAdvertisementActivity.t(this.a) != null) && (PublicAccountAdvertisementActivity.t(this.a).getWebView() != null) && (PublicAccountAdvertisementActivity.t(this.a).getWebView().getWebScrollY() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity.5
 * JD-Core Version:    0.7.0.1
 */