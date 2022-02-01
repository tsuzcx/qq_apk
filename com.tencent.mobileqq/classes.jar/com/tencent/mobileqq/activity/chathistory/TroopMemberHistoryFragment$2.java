package com.tencent.mobileqq.activity.chathistory;

import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class TroopMemberHistoryFragment$2
  implements AbsListView.OnScrollListener
{
  private int jdField_a_of_type_Int;
  private int b;
  
  TroopMemberHistoryFragment$2(TroopMemberHistoryFragment paramTroopMemberHistoryFragment) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment$TroopMemberChatHisListAdapter.getCount();
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.c))
    {
      int i = this.b;
      if (i <= 0) {
        return;
      }
      if ((paramInt == 0) && (i <= this.jdField_a_of_type_Int)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.a(21);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment.2
 * JD-Core Version:    0.7.0.1
 */