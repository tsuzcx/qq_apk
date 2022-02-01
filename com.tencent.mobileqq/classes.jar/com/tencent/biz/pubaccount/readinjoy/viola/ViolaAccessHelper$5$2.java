package com.tencent.biz.pubaccount.readinjoy.viola;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.LoadAsyBack;
import com.tencent.mobileqq.app.ThreadManager;

class ViolaAccessHelper$5$2
  implements ViolaBaseView.LoadAsyBack
{
  ViolaAccessHelper$5$2(ViolaAccessHelper.5 param5) {}
  
  public void a()
  {
    ViolaAccessHelper.a(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaAccessHelper$SDKInitCallback);
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      ViolaAccessHelper.a(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaAccessHelper$SDKInitCallback);
      ThreadManager.post(new ViolaAccessHelper.5.2.1(this, paramString), 8, null, true);
      return;
    }
    ViolaAccessHelper.a(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterViolaReportDelegate, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaAccessHelper$SDKInitCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper.5.2
 * JD-Core Version:    0.7.0.1
 */