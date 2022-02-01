package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;
import prg;
import qve;
import qvg;

public class ReadInjoyTextView$2$1
  implements Runnable
{
  public ReadInjoyTextView$2$1(qvg paramqvg, ReadInJoyUserInfo paramReadInJoyUserInfo) {}
  
  public void run()
  {
    QLog.d("ReadInjoyTextView", 2, new Object[] { "setDecorationName callback, nick = ", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadInJoyUserInfo.decorationName });
    qve localqve = this.jdField_a_of_type_Qvg.a;
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadInJoyUserInfo.decorationName)) {}
    for (String str = this.jdField_a_of_type_Qvg.b;; str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadInJoyUserInfo.decorationName)
    {
      localqve.setText(prg.a(str));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInjoyTextView.2.1
 * JD-Core Version:    0.7.0.1
 */