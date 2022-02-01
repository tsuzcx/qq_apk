package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

class TroopRequestActivity$16$1
  implements Runnable
{
  TroopRequestActivity$16$1(TroopRequestActivity.16 param16, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity$16.a.app != null)
    {
      localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity$16.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localObject != null)
      {
        localObject = ((FriendsManager)localObject).a(this.jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity$16.a.runOnUiThread(new TroopRequestActivity.16.1.1(this, (Card)localObject));
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      Object localObject;
      return;
    }
    QLog.d("Q.systemmsg.TroopRequestActivity", 2, "onUpdateFriendInfo app is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.16.1
 * JD-Core Version:    0.7.0.1
 */