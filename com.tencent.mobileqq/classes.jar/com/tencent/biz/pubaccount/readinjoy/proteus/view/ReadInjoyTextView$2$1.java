package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJStringUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;

class ReadInjoyTextView$2$1
  implements Runnable
{
  ReadInjoyTextView$2$1(ReadInjoyTextView.2 param2, ReadInJoyUserInfo paramReadInJoyUserInfo) {}
  
  public void run()
  {
    QLog.d("ReadInjoyTextView", 2, new Object[] { "setDecorationName callback, nick = ", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadInJoyUserInfo.decorationName });
    ReadInjoyTextView localReadInjoyTextView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewReadInjoyTextView$2.a;
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadInJoyUserInfo.decorationName)) {}
    for (String str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewReadInjoyTextView$2.b;; str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadInJoyUserInfo.decorationName)
    {
      localReadInjoyTextView.setText(RIJStringUtils.a(str));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInjoyTextView.2.1
 * JD-Core Version:    0.7.0.1
 */