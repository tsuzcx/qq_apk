package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;

class FriendProfileMoreInfoActivity$4
  extends FriendListObserver
{
  FriendProfileMoreInfoActivity$4(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin.equals(paramString1))
    {
      if (!ProfilePAUtils.isPaTypeFriend(this.a.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne)) {
        return;
      }
      if (paramBoolean)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardName = paramString2;
        return;
      }
      paramString1 = (FriendsManager)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (paramString1 == null) {
        paramString1 = null;
      } else {
        paramString1 = paramString1.e(this.a.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin);
      }
      if ((paramString1 != null) && (paramString1.remark != null) && (paramString1.isRemark == 1)) {
        this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardName = paramString1.remark;
      }
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2) && (this.a.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin != null) && (ProfilePAUtils.isPaTypeFriend(this.a.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne)))
    {
      Object localObject = (FriendsManager)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((FriendsManager)localObject).e(this.a.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin);
      }
      if ((localObject != null) && (((Friends)localObject).remark != null) && (((Friends)localObject).isRemark == 1)) {
        this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardName = ((Friends)localObject).remark;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity.4
 * JD-Core Version:    0.7.0.1
 */