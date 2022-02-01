package com.tencent.mobileqq.activity.aio.rebuild;

import ailn;
import anzp;
import bghm;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;

public class HotChatPie$16
  implements Runnable
{
  public HotChatPie$16(ailn paramailn, HotChatInfo paramHotChatInfo) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Bghm == null) {
      this.this$0.jdField_a_of_type_Bghm = new bghm(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ailn.b(this.this$0), ailn.b(this.this$0), this.this$0.jdField_a_of_type_Bfpy, this.this$0.U, null);
    }
    anzp localanzp = (anzp)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35);
    if (this.a.userCreate == 1) {
      localanzp.a(this.a.troopUin);
    }
    while (this.a.uuid == null) {
      return;
    }
    localanzp.a(this.a.uuid.getBytes(), this.a.troopUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.16
 * JD-Core Version:    0.7.0.1
 */