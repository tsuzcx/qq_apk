package com.tencent.biz.pubaccount.readinjoy.view.pullrefresh;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.widget.IPullRefreshHeader;
import com.tencent.mobileqq.widget.PullRefreshHeader;

public class ReadInJoyAnimDefaultManager
  extends ReadInJoyAnimBaseManager
{
  private RefreshAnimView a;
  
  public ReadInJoyAnimDefaultManager(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298850);
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader == null)
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562889, paramViewGroup, false);
      paramViewGroup.findViewById(2131376853).getLayoutParams().width = -2;
      this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader = ((IPullRefreshHeader)paramViewGroup);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView = ((RefreshAnimView)((PullRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader).findViewById(2131376845));
    }
    return (View)this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.a(0L);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.ah_();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    super.a(paramInt, paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader == null) {
      return;
    }
    if (paramInt == 100)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.b(0L);
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.ah_();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.c(0L);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a(paramInt / 100.0D);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.a(0L);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.b();
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a(paramBoolean, paramString);
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a(1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoyAnimDefaultManager
 * JD-Core Version:    0.7.0.1
 */