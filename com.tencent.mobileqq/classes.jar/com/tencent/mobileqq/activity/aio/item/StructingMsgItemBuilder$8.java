package com.tencent.mobileqq.activity.aio.item;

import bawl;
import bawm;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;

class StructingMsgItemBuilder$8
  implements Runnable
{
  StructingMsgItemBuilder$8(StructingMsgItemBuilder paramStructingMsgItemBuilder, bawl parambawl, bawm parambawm) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Bawl.d == 1L) && (this.jdField_a_of_type_Bawl.b.equalsIgnoreCase(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
    {
      this.jdField_a_of_type_Bawm.a(6L, this.jdField_a_of_type_Bawl.a);
      ((BaseActivity)this.this$0.jdField_a_of_type_AndroidContentContext).runOnUiThread(new StructingMsgItemBuilder.8.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.8
 * JD-Core Version:    0.7.0.1
 */