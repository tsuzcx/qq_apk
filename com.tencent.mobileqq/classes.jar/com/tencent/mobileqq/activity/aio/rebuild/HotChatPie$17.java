package com.tencent.mobileqq.activity.aio.rebuild;

import agrn;
import aluj;
import bcgx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;

public class HotChatPie$17
  implements Runnable
{
  public HotChatPie$17(agrn paramagrn, HotChatInfo paramHotChatInfo) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Bcgx == null) {
      this.this$0.jdField_a_of_type_Bcgx = new bcgx(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, agrn.b(this.this$0), agrn.b(this.this$0), this.this$0.jdField_a_of_type_Bbqg, this.this$0.V, null);
    }
    aluj localaluj = (aluj)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35);
    if (this.a.userCreate == 1) {
      localaluj.a(this.a.troopUin);
    }
    while (this.a.uuid == null) {
      return;
    }
    localaluj.a(this.a.uuid.getBytes(), this.a.troopUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.17
 * JD-Core Version:    0.7.0.1
 */