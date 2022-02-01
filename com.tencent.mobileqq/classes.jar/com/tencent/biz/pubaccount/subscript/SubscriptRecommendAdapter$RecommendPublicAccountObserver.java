package com.tencent.biz.pubaccount.subscript;

import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.qphone.base.util.QLog;

public class SubscriptRecommendAdapter$RecommendPublicAccountObserver
  extends PublicAccountObserver
{
  SubscriptRecommendAdapter.RecommendItem jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem = null;
  
  public SubscriptRecommendAdapter$RecommendPublicAccountObserver(SubscriptRecommendAdapter paramSubscriptRecommendAdapter, SubscriptRecommendAdapter.RecommendItem paramRecommendItem)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem = paramRecommendItem;
  }
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubscriptRecommendAdapter", 2, "onFollowPublicAccount isSuccess: " + paramBoolean + " | uin: " + paramString + " | mRecommendItem: " + this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem != null)
    {
      paramString = this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem;
      if (!paramBoolean) {
        break label76;
      }
    }
    label76:
    for (int i = 1;; i = 0)
    {
      paramString.a(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptRecommendAdapter.RecommendPublicAccountObserver
 * JD-Core Version:    0.7.0.1
 */