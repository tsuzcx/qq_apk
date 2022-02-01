package com.tencent.biz.pubaccount.NativeAd.module;

import android.view.View;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageDownListener;
import com.tencent.mobileqq.kandian.base.view.widget.ResizeURLImageView;
import java.net.URL;

class AdModuleSinglePic$1
  implements IPublicAccountImageDownListener
{
  AdModuleSinglePic$1(AdModuleSinglePic paramAdModuleSinglePic, View paramView, ResizeURLImageView paramResizeURLImageView) {}
  
  public void a(URL paramURL, int paramInt) {}
  
  public void a(URL paramURL, Object paramObject)
  {
    this.c.b = 2;
    this.a.findViewById(2131437626).setVisibility(8);
    this.b.setPublicAccountImageDownListener(null);
    AdModuleSinglePic.a(this.c, null);
  }
  
  public void a(URL paramURL, Throwable paramThrowable)
  {
    this.c.b = 3;
    this.a.findViewById(2131437626).setVisibility(8);
    this.a.findViewById(2131432776).setVisibility(0);
    this.a.findViewById(2131432776).setOnClickListener(new AdModuleSinglePic.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.module.AdModuleSinglePic.1
 * JD-Core Version:    0.7.0.1
 */