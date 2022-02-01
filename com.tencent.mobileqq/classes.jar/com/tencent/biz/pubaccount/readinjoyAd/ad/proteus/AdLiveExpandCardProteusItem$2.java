package com.tencent.biz.pubaccount.readinjoyAd.ad.proteus;

import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;

class AdLiveExpandCardProteusItem$2
  implements URLDrawable.URLDrawableListener
{
  AdLiveExpandCardProteusItem$2(AdLiveExpandCardProteusItem paramAdLiveExpandCardProteusItem, IReadInJoyModel paramIReadInJoyModel) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    ReadInJoyAdLog.b("AdLiveExpandCardProteusItem", "onLoadCanceled ");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append("onLoadFialed throwable:");
    paramURLDrawable.append(paramThrowable.getMessage());
    ReadInJoyAdLog.b("AdLiveExpandCardProteusItem", paramURLDrawable.toString());
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    ReadInJoyAdLog.a("AdLiveExpandCardProteusItem", "AdLiveExpandCardProteusItem.onLoadSuccessed");
    AdLiveExpandCardProteusItem.a(this.b, this.a, paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdLiveExpandCardProteusItem.2
 * JD-Core Version:    0.7.0.1
 */