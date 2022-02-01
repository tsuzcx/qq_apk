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
    localIntent.putExtra("key_ad_info", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
    ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchReadInJoyUninterestComplainFragmentForResult(NativeAdDislikeHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilNativeAdDislikeHelper), localIntent);
    NativeAdDislikeHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilNativeAdDislikeHelper).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.NativeAdDislikeHelper.3
 * JD-Core Version:    0.7.0.1
 */