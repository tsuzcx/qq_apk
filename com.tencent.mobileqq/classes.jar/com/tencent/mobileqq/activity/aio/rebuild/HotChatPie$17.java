package com.tencent.mobileqq.activity.aio.rebuild;

import aeqd;
import ajyi;
import bado;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;

public class HotChatPie$17
  implements Runnable
{
  public HotChatPie$17(aeqd paramaeqd, HotChatInfo paramHotChatInfo) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Bado == null) {
      this.this$0.jdField_a_of_type_Bado = new bado(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, aeqd.b(this.this$0), aeqd.b(this.this$0), this.this$0.jdField_a_of_type_Aznm, this.this$0.V, null);
    }
    ajyi localajyi = (ajyi)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35);
    if (this.a.userCreate == 1) {
      localajyi.a(this.a.troopUin);
    }
    while (this.a.uuid == null) {
      return;
    }
    localajyi.a(this.a.uuid.getBytes(), this.a.troopUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.17
 * JD-Core Version:    0.7.0.1
 */