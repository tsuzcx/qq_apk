package com.tencent.biz.pubaccount.readinjoy.view.pullrefresh;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.widget.IPullRefreshHeader;
import com.tencent.mobileqq.widget.PullRefreshHeader;

public class ReadInJoyAnimOldManager
  extends ReadInJoyAnimBaseManager
{
  public ReadInJoyAnimOldManager(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298917);
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559765, paramViewGroup, false));
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
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.a(0L);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader == null) {
      return;
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.a(0, paramString);
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.a(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.a(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoyAnimOldManager
 * JD-Core Version:    0.7.0.1
 */