package com.tencent.mobileqq.activity.selectmember;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.gamecenter.util.QQGameTroopManager;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class TroopMemberListInnerFrame$9
  implements AbsListView.OnScrollListener
{
  TroopMemberListInnerFrame$9(TroopMemberListInnerFrame paramTroopMemberListInnerFrame) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (QQGameTroopManager.b(this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity)) && (QQGameTroopManager.a(this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity))) {
      ((QQGameTroopManager)this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getManager(QQManagerFactory.GAME_TROOP_MANAGER)).a(this.a.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame.9
 * JD-Core Version:    0.7.0.1
 */