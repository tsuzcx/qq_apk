package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import azsp;
import bame;
import baul;
import biqt;
import birh;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import java.net.URL;

class StructingMsgItemBuilder$3
  implements Runnable
{
  StructingMsgItemBuilder$3(StructingMsgItemBuilder paramStructingMsgItemBuilder, azsp paramazsp, int paramInt, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    Object localObject = baul.a(this.jdField_a_of_type_Azsp.a, 1);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((URL)localObject).toString())
    {
      localObject = bame.d((String)localObject);
      biqt.a(this.jdField_a_of_type_Azsp.U, this.jdField_a_of_type_Int, this.jdField_a_of_type_Azsp.T, this.jdField_a_of_type_Azsp.c, (String)localObject, this.jdField_a_of_type_Azsp.d).b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage).a((Activity)this.this$0.jdField_a_of_type_AndroidContentContext, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      birh.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 3);
      birh.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, 0, this.jdField_a_of_type_Int);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */