package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceReportUtil;
import com.tencent.mobileqq.util.DisplayUtil;

class TextItemBuilder$3
  implements Runnable
{
  TextItemBuilder$3(TextItemBuilder paramTextItemBuilder, TextItemBuilder.Holder paramHolder, ChatMessage paramChatMessage1, ChatMessage paramChatMessage2) {}
  
  public void run()
  {
    String str = null;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder$Holder.jdField_a_of_type_AndroidViewView.getMeasuredWidth() < DisplayUtil.a(this.this$0.jdField_a_of_type_AndroidContentContext, 70.0F)) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend())) {
      TextItemBuilder.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder$Holder.d);
    }
    for (;;)
    {
      QQAppInterface localQQAppInterface = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      View localView = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder$Holder.d;
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
        str = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
      }
      TroopEssenceReportUtil.a(localQQAppInterface, localView, str);
      return;
      this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder$Holder.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, null, this.b, 0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TextItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */