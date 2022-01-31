package com.tencent.mobileqq.activity.aio.rebuild;

import aeqb;
import ajyg;
import baec;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;

public class HotChatPie$17
  implements Runnable
{
  public HotChatPie$17(aeqb paramaeqb, HotChatInfo paramHotChatInfo) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Baec == null) {
      this.this$0.jdField_a_of_type_Baec = new baec(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, aeqb.b(this.this$0), aeqb.b(this.this$0), this.this$0.jdField_a_of_type_Azno, this.this$0.V, null);
    }
    ajyg localajyg = (ajyg)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35);
    if (this.a.userCreate == 1) {
      localajyg.a(this.a.troopUin);
    }
    while (this.a.uuid == null) {
      return;
    }
    localajyg.a(this.a.uuid.getBytes(), this.a.troopUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.17
 * JD-Core Version:    0.7.0.1
 */