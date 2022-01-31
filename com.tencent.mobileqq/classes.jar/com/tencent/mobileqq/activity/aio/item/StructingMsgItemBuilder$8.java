package com.tencent.mobileqq.activity.aio.item;

import bdyu;
import bdyv;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;

class StructingMsgItemBuilder$8
  implements Runnable
{
  StructingMsgItemBuilder$8(StructingMsgItemBuilder paramStructingMsgItemBuilder, bdyu parambdyu, bdyv parambdyv) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Bdyu.d == 1L) && (this.jdField_a_of_type_Bdyu.b.equalsIgnoreCase(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
    {
      this.jdField_a_of_type_Bdyv.a(6L, this.jdField_a_of_type_Bdyu.a);
      ((BaseActivity)this.this$0.jdField_a_of_type_AndroidContentContext).runOnUiThread(new StructingMsgItemBuilder.8.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.8
 * JD-Core Version:    0.7.0.1
 */