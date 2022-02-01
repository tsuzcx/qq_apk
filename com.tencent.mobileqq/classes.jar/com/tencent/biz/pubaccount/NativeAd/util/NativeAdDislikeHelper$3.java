package com.tencent.biz.pubaccount.NativeAd.util;

import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.biz.dislike.ReadInJoyDisLikeDialogView.OnComplainListener;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

class NativeAdDislikeHelper$3
  implements ReadInJoyDisLikeDialogView.OnComplainListener
{
  NativeAdDislikeHelper$3(NativeAdDislikeHelper paramNativeAdDislikeHelper, AdvertisementInfo paramAdvertisementInfo) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdDislikeHelper", 2, "onComplain");
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_from_type", 1);
    localIntent.putExtra("key_ad_info", this.a);
    ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchReadInJoyUninterestComplainFragmentForResult(NativeAdDislikeHelper.b(this.b), localIntent);
    NativeAdDislikeHelper.c(this.b).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.NativeAdDislikeHelper.3
 * JD-Core Version:    0.7.0.1
 */