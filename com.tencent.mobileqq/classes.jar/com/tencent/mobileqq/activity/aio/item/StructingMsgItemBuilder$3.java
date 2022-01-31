package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import awwr;
import axoa;
import axwd;
import bfhl;
import bfhz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import java.net.URL;

class StructingMsgItemBuilder$3
  implements Runnable
{
  StructingMsgItemBuilder$3(StructingMsgItemBuilder paramStructingMsgItemBuilder, awwr paramawwr, int paramInt, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    Object localObject = axwd.a(this.jdField_a_of_type_Awwr.a, 1);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((URL)localObject).toString())
    {
      localObject = axoa.d((String)localObject);
      bfhl.a(this.jdField_a_of_type_Awwr.U, this.jdField_a_of_type_Int, this.jdField_a_of_type_Awwr.T, this.jdField_a_of_type_Awwr.c, (String)localObject, this.jdField_a_of_type_Awwr.d).b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage).a((Activity)this.this$0.jdField_a_of_type_AndroidContentContext, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      bfhz.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 3);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */