package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJStringUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;

class ReadInjoyTextView$3$1
  implements Runnable
{
  ReadInjoyTextView$3$1(ReadInjoyTextView.3 param3, ReadInJoyUserInfo paramReadInJoyUserInfo) {}
  
  public void run()
  {
    QLog.d("ReadInjoyTextView", 2, new Object[] { "setNickName callback, nick = ", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadInJoyUserInfo.nick });
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewReadInjoyTextView$3.a.setText(RIJStringUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadInJoyUserInfo.nick));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInjoyTextView.3.1
 * JD-Core Version:    0.7.0.1
 */