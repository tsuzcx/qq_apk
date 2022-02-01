package com.tencent.biz.pubaccount.readinjoyAd.ad.proteus;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInjoyImageView;

class AdQQMiniGameVideoProteusItem$1
  implements Runnable
{
  AdQQMiniGameVideoProteusItem$1(AdQQMiniGameVideoProteusItem paramAdQQMiniGameVideoProteusItem) {}
  
  public void run()
  {
    if ((AdQQMiniGameVideoProteusItem.a(this.this$0) != null) && (!TextUtils.isEmpty(AdQQMiniGameVideoProteusItem.a(this.this$0))))
    {
      ((ReadInjoyImageView)AdQQMiniGameVideoProteusItem.a(this.this$0)).mSrc = AdQQMiniGameVideoProteusItem.a(this.this$0);
      ((ReadInjoyImageView)AdQQMiniGameVideoProteusItem.a(this.this$0)).loadImage(AdQQMiniGameVideoProteusItem.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdQQMiniGameVideoProteusItem.1
 * JD-Core Version:    0.7.0.1
 */