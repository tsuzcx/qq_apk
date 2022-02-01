package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;
import prg;
import qve;
import qvf;

public class ReadInjoyTextView$1$1
  implements Runnable
{
  public ReadInjoyTextView$1$1(qvf paramqvf, ReadInJoyUserInfo paramReadInJoyUserInfo) {}
  
  public void run()
  {
    QLog.d("ReadInjoyTextView", 2, new Object[] { "setContentWithNickName callback, nick = ", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadInJoyUserInfo.nick });
    this.jdField_a_of_type_Qvf.a.setText(qve.a(this.jdField_a_of_type_Qvf.a, this.jdField_a_of_type_Qvf.b, prg.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadInJoyUserInfo.nick)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInjoyTextView.1.1
 * JD-Core Version:    0.7.0.1
 */