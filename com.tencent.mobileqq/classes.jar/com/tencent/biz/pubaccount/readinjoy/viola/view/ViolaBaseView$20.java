package com.tencent.biz.pubaccount.readinjoy.viola.view;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

class ViolaBaseView$20
  implements ViolaBaseView.LoadAsyBack
{
  ViolaBaseView$20(ViolaBaseView paramViolaBaseView, boolean paramBoolean) {}
  
  public void a()
  {
    if (ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView) != null) {
      ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView).c();
    }
    ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView, 2, this.jdField_a_of_type_Boolean);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(ViolaBaseView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView))) {
      ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView, paramString, this.jdField_a_of_type_Boolean);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        ThreadManager.post(new ViolaBaseView.20.1(this, paramString), 8, null, true);
      }
      return;
      if (!this.jdField_a_of_type_Boolean) {
        ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView, paramString, this.jdField_a_of_type_Boolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.20
 * JD-Core Version:    0.7.0.1
 */