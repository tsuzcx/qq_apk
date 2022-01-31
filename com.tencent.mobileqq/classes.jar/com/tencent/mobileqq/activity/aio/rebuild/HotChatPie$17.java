package com.tencent.mobileqq.activity.aio.rebuild;

import agmy;
import alpu;
import bcco;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;

public class HotChatPie$17
  implements Runnable
{
  public HotChatPie$17(agmy paramagmy, HotChatInfo paramHotChatInfo) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Bcco == null) {
      this.this$0.jdField_a_of_type_Bcco = new bcco(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, agmy.b(this.this$0), agmy.b(this.this$0), this.this$0.jdField_a_of_type_Bblx, this.this$0.V, null);
    }
    alpu localalpu = (alpu)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35);
    if (this.a.userCreate == 1) {
      localalpu.a(this.a.troopUin);
    }
    while (this.a.uuid == null) {
      return;
    }
    localalpu.a(this.a.uuid.getBytes(), this.a.troopUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.17
 * JD-Core Version:    0.7.0.1
 */