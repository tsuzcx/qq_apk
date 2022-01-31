package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import azwy;
import baqn;
import bayu;
import biva;
import bivo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import java.net.URL;

class StructingMsgItemBuilder$3
  implements Runnable
{
  StructingMsgItemBuilder$3(StructingMsgItemBuilder paramStructingMsgItemBuilder, azwy paramazwy, int paramInt, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    Object localObject = bayu.a(this.jdField_a_of_type_Azwy.a, 1);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((URL)localObject).toString())
    {
      localObject = baqn.d((String)localObject);
      biva.a(this.jdField_a_of_type_Azwy.U, this.jdField_a_of_type_Int, this.jdField_a_of_type_Azwy.T, this.jdField_a_of_type_Azwy.c, (String)localObject, this.jdField_a_of_type_Azwy.d).b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage).a((Activity)this.this$0.jdField_a_of_type_AndroidContentContext, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      bivo.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 3);
      bivo.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, 0, this.jdField_a_of_type_Int);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */