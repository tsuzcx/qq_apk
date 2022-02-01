package com.tencent.mobileqq.activity.aio.item;

import agqd;
import agql;
import android.view.View;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.util.DisplayUtil;

public class TextItemBuilder$3
  implements Runnable
{
  public TextItemBuilder$3(agqd paramagqd, agql paramagql, ChatMessage paramChatMessage1, ChatMessage paramChatMessage2) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Agql.jdField_a_of_type_AndroidViewView.getMeasuredWidth() < DisplayUtil.dip2px(this.this$0.a, 70.0F)) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()))
    {
      agqd.a(this.this$0, this.jdField_a_of_type_Agql.c);
      return;
    }
    this.this$0.a(this.jdField_a_of_type_Agql.c, this.jdField_a_of_type_Agql.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, null, this.b, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TextItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */