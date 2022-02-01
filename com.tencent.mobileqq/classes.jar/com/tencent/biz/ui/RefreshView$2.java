package com.tencent.biz.ui;

import android.view.View;
import com.tencent.mobileqq.widget.IPullRefreshHeader;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;

class RefreshView$2
  implements OverScrollViewListener
{
  RefreshView$2(RefreshView paramRefreshView) {}
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if (this.a.jdField_a_of_type_Int == 2)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.f();
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.c(0L);
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if (this.a.jdField_a_of_type_Int != 2) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.b(0L);
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (this.a.jdField_a_of_type_Int != 2)
    {
      RefreshView.a(this.a, false);
      paramView = this.a;
      paramView.a(RefreshView.a(paramView));
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.a(0L);
      paramView = this.a;
      paramView.jdField_a_of_type_Int = 2;
      RefreshView.a(paramView);
    }
    return false;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.ui.RefreshView.2
 * JD-Core Version:    0.7.0.1
 */