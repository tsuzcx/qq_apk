package com.tencent.mobileqq.activity.aio.rebuild;

import aibv;
import anno;
import bfhl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;

public class HotChatPie$16
  implements Runnable
{
  public HotChatPie$16(aibv paramaibv, HotChatInfo paramHotChatInfo) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Bfhl == null) {
      this.this$0.jdField_a_of_type_Bfhl = new bfhl(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, aibv.b(this.this$0), aibv.b(this.this$0), this.this$0.jdField_a_of_type_Beqr, this.this$0.U, null);
    }
    anno localanno = (anno)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35);
    if (this.a.userCreate == 1) {
      localanno.a(this.a.troopUin);
    }
    while (this.a.uuid == null) {
      return;
    }
    localanno.a(this.a.uuid.getBytes(), this.a.troopUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.16
 * JD-Core Version:    0.7.0.1
 */