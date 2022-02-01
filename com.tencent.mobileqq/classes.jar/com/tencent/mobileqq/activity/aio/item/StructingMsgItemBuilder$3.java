package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import bcxy;
import bdsh;
import bdzx;
import bljl;
import bljv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import java.net.URL;

class StructingMsgItemBuilder$3
  implements Runnable
{
  StructingMsgItemBuilder$3(StructingMsgItemBuilder paramStructingMsgItemBuilder, bcxy parambcxy, int paramInt, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    Object localObject = bdzx.a(this.jdField_a_of_type_Bcxy.a, 1);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((URL)localObject).toString())
    {
      localObject = bdsh.d((String)localObject);
      bljl.a(this.jdField_a_of_type_Bcxy.ac, this.jdField_a_of_type_Int, this.jdField_a_of_type_Bcxy.ab, this.jdField_a_of_type_Bcxy.c, (String)localObject, this.jdField_a_of_type_Bcxy.d).b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage).a((Activity)this.this$0.jdField_a_of_type_AndroidContentContext, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      bljv.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 3);
      bljv.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, 0, this.jdField_a_of_type_Int);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */