package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.qphone.base.util.QLog;

public class StrangerAddFriendHelper
  extends AddFriendHelper
{
  private ShieldListObserver a;
  
  public StrangerAddFriendHelper(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
    this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver = new StrangerAddFriendHelper.1(this);
  }
  
  protected boolean a()
  {
    return true;
  }
  
  protected boolean b()
  {
    if (((FullScreenInputHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(24)).c()) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.b()) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006)
    {
      PhoneContact localPhoneContact = ((IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).queryContactByCodeNumber(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("StrangerChatPie.showorhideAddFriend curFriendUin=");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(" contact=");
        String str;
        if (localPhoneContact == null) {
          str = "null";
        } else {
          str = "real";
        }
        localStringBuilder.append(str);
        QLog.d("StrangerAddFriendHelper", 2, localStringBuilder.toString());
      }
      if (localPhoneContact != null) {
        return false;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10004) {
      return false;
    }
    return !((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void onMoveToState(int paramInt)
  {
    super.onMoveToState(paramInt);
    if (paramInt != 4)
    {
      if (paramInt != 15) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.StrangerAddFriendHelper
 * JD-Core Version:    0.7.0.1
 */