package com.tencent.biz.pubaccount.readinjoy.activity;

import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import qkb;

class ReadInJoySelfActivity$1
  implements Runnable
{
  ReadInJoySelfActivity$1(ReadInJoySelfActivity paramReadInJoySelfActivity) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoySelfFragment.a();
    qkb localqkb;
    String str;
    if (this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager != null)
    {
      localqkb = qkb.a();
      str = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (!this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.i()) {
        break label57;
      }
    }
    label57:
    for (int i = 0;; i = 1)
    {
      localqkb.a(str, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySelfActivity.1
 * JD-Core Version:    0.7.0.1
 */