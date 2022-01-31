package com.tencent.biz.pubaccount.readinjoy.view.pullrefresh;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.ui.IPullRefreshHeader;
import com.tencent.mobileqq.widget.PullRefreshHeader;

public class ReadInJoyAnimDefaultManager
  extends ReadInJoyAnimBaseManager
{
  public ReadInJoyAnimDefaultManager(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558434);
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader == null) {
      this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969237, paramViewGroup, false));
    }
    return (View)this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.a(0L);
    this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.aa_();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    super.a(paramInt, paramBoolean);
    if (this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader == null) {
      return;
    }
    if (paramInt == 100)
    {
      this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.b(0L);
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.aa_();
      return;
    }
    this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.c(0L);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.a(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoyAnimDefaultManager
 * JD-Core Version:    0.7.0.1
 */