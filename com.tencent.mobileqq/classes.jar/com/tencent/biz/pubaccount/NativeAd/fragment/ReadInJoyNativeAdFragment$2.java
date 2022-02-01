package com.tencent.biz.pubaccount.NativeAd.fragment;

import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageDownListener;
import com.tencent.mobileqq.kandian.base.view.widget.ResizeURLImageView;
import java.net.URL;

class ReadInJoyNativeAdFragment$2
  implements IPublicAccountImageDownListener
{
  ReadInJoyNativeAdFragment$2(ReadInJoyNativeAdFragment paramReadInJoyNativeAdFragment) {}
  
  public void a(URL paramURL, int paramInt) {}
  
  public void a(URL paramURL, Object paramObject)
  {
    ReadInJoyNativeAdFragment.b(this.a, 2);
    ReadInJoyNativeAdFragment.g(this.a).setPublicAccountImageDownListener(null);
    ReadInJoyNativeAdFragment.a(this.a, null);
  }
  
  public void a(URL paramURL, Throwable paramThrowable)
  {
    ReadInJoyNativeAdFragment.b(this.a, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdFragment.2
 * JD-Core Version:    0.7.0.1
 */