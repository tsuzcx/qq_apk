package com.tencent.biz.pubaccount.readinjoy.viola.adapter.ui;

import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.RefreshAnimView;
import com.tencent.viola.ui.view.VRefreshLayout;
import com.tencent.viola.ui.view.VRefreshLayout.onRefreshStateChangeListener;

class ComponentAdapter$1
  implements VRefreshLayout.onRefreshStateChangeListener
{
  ComponentAdapter$1(ComponentAdapter paramComponentAdapter, RefreshAnimView paramRefreshAnimView, VRefreshLayout paramVRefreshLayout) {}
  
  public void onRefreshMove(int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentViolaUiViewVRefreshLayout.getHeaderHeight();
    if ((paramInt <= i) && (!ComponentAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterUiComponentAdapter)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a(paramInt / i);
    }
  }
  
  public void onStateEnd()
  {
    ComponentAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterUiComponentAdapter, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a(1000L);
  }
  
  public void onStateFinish(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a(paramBoolean, paramString);
  }
  
  public void onStateIdel()
  {
    ComponentAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterUiComponentAdapter, false);
  }
  
  public void onStatePulling() {}
  
  public void onStateRefreshing()
  {
    ComponentAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterUiComponentAdapter, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.adapter.ui.ComponentAdapter.1
 * JD-Core Version:    0.7.0.1
 */