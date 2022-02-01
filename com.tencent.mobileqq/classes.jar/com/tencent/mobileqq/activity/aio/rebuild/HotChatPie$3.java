package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.hotchat.api.IHotChatPostListAdapter;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;

class HotChatPie$3
  implements AbsListView.OnScrollListener
{
  HotChatPie$3(HotChatPie paramHotChatPie) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.a.jdField_a_of_type_ComTencentWidgetXListView != null) && (this.a.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition() == this.a.jdField_a_of_type_ComTencentWidgetXListView.getCount() - 1) && (this.a.jdField_a_of_type_ComTencentMobileqqHotchatApiIHotChatPostListAdapter != null) && (this.a.jdField_a_of_type_ComTencentMobileqqHotchatApiIHotChatPostListAdapter.getLastPullUpEndIndex() != 0) && (this.a.jdField_a_of_type_ComTencentMobileqqHotchatApiIHotChatPostListAdapter.isLastPullUpEnded()))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqHotchatApiIHotChatPostListAdapter.setPullUpStarted();
      paramAbsListView = this.a;
      HotChatPie.a(paramAbsListView, paramAbsListView.jdField_a_of_type_ComTencentMobileqqHotchatApiIHotChatPostListAdapter.getLastPullUpEndIndex(), 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.3
 * JD-Core Version:    0.7.0.1
 */