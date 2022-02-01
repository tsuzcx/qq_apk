package com.tencent.biz.pubaccount.readinjoy.viola.view;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyWebRenderEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyWebRenderEngine.LoadLibCallback;
import com.tencent.biz.pubaccount.readinjoy.viola.adapter.ViolaReportDelegate;
import com.tencent.biz.pubaccount.readinjoy.viola.so.ViolaSoLoaderManager;
import com.tencent.biz.pubaccount.readinjoy.viola.so.ViolaSoLoaderManager.Companion;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaEnvironment;

class ViolaBaseView$4
  implements ReadInJoyWebRenderEngine.LoadLibCallback
{
  ViolaBaseView$4(ViolaBaseView paramViolaBaseView, int paramInt) {}
  
  public void onError(int paramInt)
  {
    if ((this.jdField_a_of_type_Int == ViolaBaseView.c()) && (ViolaSoLoaderManager.a.a().b()))
    {
      ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView, System.currentTimeMillis());
      ViolaBaseView.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView);
    }
    for (;;)
    {
      QLog.e(ViolaBaseView.a(), 2, "loadSoIfNeed error,code=" + paramInt + ",isActivityDestroy:" + ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView));
      return;
      ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView, 100);
    }
  }
  
  public void onFinish(int paramInt)
  {
    if (paramInt == ReadInJoyWebRenderEngine.g) {
      ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView).addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_END_EXIT);
    }
    for (;;)
    {
      ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView);
      ViolaBaseView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView);
      return;
      if (this.jdField_a_of_type_Int == ViolaBaseView.c())
      {
        ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView).addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_END_NET);
        ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView).addReportData(ViolaEnvironment.TIME_SO, Long.toString(System.currentTimeMillis() - ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView)));
      }
      else
      {
        ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView).addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_END_OFFLINE);
        ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView).addReportData(ViolaEnvironment.TIME_SO, Long.toString(System.currentTimeMillis() - ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.4
 * JD-Core Version:    0.7.0.1
 */