package com.tencent.biz.pubaccount.weishi_new;

import android.text.TextUtils;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.pubaccount.weishi_new.recommend.data.WSSubTabData;
import com.tencent.biz.pubaccount.weishi_new.view.WSFeedsLinearLayout;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabLayout;

class WSRecommendFragment$3
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  WSRecommendFragment$3(WSRecommendFragment paramWSRecommendFragment, WSSubTabData paramWSSubTabData) {}
  
  public void onGlobalLayout()
  {
    WSRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    WSSubTabData localWSSubTabData = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendDataWSSubTabData;
    if (localWSSubTabData == null) {
      return;
    }
    boolean bool2 = TextUtils.equals(localWSSubTabData.jdField_a_of_type_JavaLangString, "2");
    boolean bool1 = true;
    if (bool2)
    {
      WSRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment).b(false);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment.a(false);
      bool1 = false;
    }
    else
    {
      WSRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment).a(false);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment.a(true);
    }
    WSTabBeaconReport.a(bool1, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendDataWSSubTabData.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment.3
 * JD-Core Version:    0.7.0.1
 */