package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.data.ChatMessage;

class WriteTogetherItemBuilder$2
  implements Runnable
{
  WriteTogetherItemBuilder$2(WriteTogetherItemBuilder paramWriteTogetherItemBuilder, TextItemBuilder.Holder paramHolder, int paramInt, ChatMessage paramChatMessage1, RelativeLayout paramRelativeLayout, ChatMessage paramChatMessage2) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder$Holder.jdField_a_of_type_AndroidViewView.getMeasuredWidth() < this.jdField_a_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()))
    {
      WriteTogetherItemBuilder.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder$Holder.d, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      return;
    }
    WriteTogetherItemBuilder.a(this.this$0, this.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder$Holder.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, Integer.valueOf(2131382002), this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, -4, Boolean.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.WriteTogetherItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */