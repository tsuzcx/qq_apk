package com.tencent.biz.pubaccount.weishi_new;

import android.text.TextUtils;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.pubaccount.weishi_new.recommend.data.WSSubTabData;
import com.tencent.biz.pubaccount.weishi_new.view.WSFeedsLinearLayout;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabLayout;

class WSRecommendFragment$5
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  WSRecommendFragment$5(WSRecommendFragment paramWSRecommendFragment, WSSubTabData paramWSSubTabData) {}
  
  public void onGlobalLayout()
  {
    boolean bool = false;
    WSRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendDataWSSubTabData == null) {
      return;
    }
    if (TextUtils.equals(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendDataWSSubTabData.jdField_a_of_type_JavaLangString, "2"))
    {
      WSRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment).b(false);
      WSRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment, false);
    }
    for (;;)
    {
      WSTabBeaconReport.a(bool, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendDataWSSubTabData.jdField_a_of_type_JavaUtilArrayList);
      return;
      WSRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment).c();
      WSRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment, true);
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment.5
 * JD-Core Version:    0.7.0.1
 */