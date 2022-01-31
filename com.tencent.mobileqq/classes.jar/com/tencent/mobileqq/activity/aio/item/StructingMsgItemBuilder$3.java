package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import axwv;
import ayoi;
import aywm;
import bgpu;
import bgqi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import java.net.URL;

class StructingMsgItemBuilder$3
  implements Runnable
{
  StructingMsgItemBuilder$3(StructingMsgItemBuilder paramStructingMsgItemBuilder, axwv paramaxwv, int paramInt, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    Object localObject = aywm.a(this.jdField_a_of_type_Axwv.a, 1);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((URL)localObject).toString())
    {
      localObject = ayoi.d((String)localObject);
      bgpu.a(this.jdField_a_of_type_Axwv.U, this.jdField_a_of_type_Int, this.jdField_a_of_type_Axwv.T, this.jdField_a_of_type_Axwv.c, (String)localObject, this.jdField_a_of_type_Axwv.d).b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage).a((Activity)this.this$0.jdField_a_of_type_AndroidContentContext, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      bgqi.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 3);
      bgqi.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, 0, this.jdField_a_of_type_Int);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */