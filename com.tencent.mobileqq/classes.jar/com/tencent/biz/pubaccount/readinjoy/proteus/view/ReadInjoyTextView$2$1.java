package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;
import ozs;
import qdc;
import qde;

public class ReadInjoyTextView$2$1
  implements Runnable
{
  public ReadInjoyTextView$2$1(qde paramqde, ReadInJoyUserInfo paramReadInJoyUserInfo) {}
  
  public void run()
  {
    QLog.d("ReadInjoyTextView", 2, new Object[] { "setNickName callback, nick = ", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadInJoyUserInfo.nick });
    this.jdField_a_of_type_Qde.a.setText(ozs.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadInJoyUserInfo.nick));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInjoyTextView.2.1
 * JD-Core Version:    0.7.0.1
 */