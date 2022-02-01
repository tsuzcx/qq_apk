package com.tencent.biz.pubaccount.readinjoyAd.ad.proteus;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInjoyImageView;

class AdQQMiniGameTripleImgProteusItem$1
  implements Runnable
{
  AdQQMiniGameTripleImgProteusItem$1(AdQQMiniGameTripleImgProteusItem paramAdQQMiniGameTripleImgProteusItem) {}
  
  public void run()
  {
    if ((AdQQMiniGameTripleImgProteusItem.a(this.this$0) != null) && (!TextUtils.isEmpty(AdQQMiniGameTripleImgProteusItem.a(this.this$0))))
    {
      ((ReadInjoyImageView)AdQQMiniGameTripleImgProteusItem.a(this.this$0)).mSrc = AdQQMiniGameTripleImgProteusItem.a(this.this$0);
      ((ReadInjoyImageView)AdQQMiniGameTripleImgProteusItem.a(this.this$0)).loadImage(AdQQMiniGameTripleImgProteusItem.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdQQMiniGameTripleImgProteusItem.1
 * JD-Core Version:    0.7.0.1
 */