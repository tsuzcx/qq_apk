package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import mqq.os.MqqHandler;

class FriendProfileMoreInfoActivity$16$1
  implements Runnable
{
  FriendProfileMoreInfoActivity$16$1(FriendProfileMoreInfoActivity.16 param16, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4) {}
  
  public void run()
  {
    ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$16.a.app.getManager(QQManagerFactory.TROOP_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$16.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int, this.c, this.d);
    ThreadManager.getUIHandler().post(new FriendProfileMoreInfoActivity.16.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity.16.1
 * JD-Core Version:    0.7.0.1
 */