package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.adapter.HotChatPostListAdapter;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;

class HotChatPie$4
  implements AbsListView.OnScrollListener
{
  HotChatPie$4(HotChatPie paramHotChatPie) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.a.jdField_a_of_type_ComTencentWidgetXListView != null) && (this.a.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition() == this.a.jdField_a_of_type_ComTencentWidgetXListView.getCount() - 1) && (this.a.jdField_a_of_type_ComTencentMobileqqAdapterHotChatPostListAdapter != null) && (this.a.jdField_a_of_type_ComTencentMobileqqAdapterHotChatPostListAdapter.a() != 0) && (this.a.jdField_a_of_type_ComTencentMobileqqAdapterHotChatPostListAdapter.a()))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAdapterHotChatPostListAdapter.b();
      HotChatPie.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqAdapterHotChatPostListAdapter.a(), 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.4
 * JD-Core Version:    0.7.0.1
 */