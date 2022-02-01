package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.teamwork.TeamWorkSender;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class StructingMsgItemBuilder$24
  implements ActionSheet.OnButtonClickListener
{
  StructingMsgItemBuilder$24(StructingMsgItemBuilder paramStructingMsgItemBuilder, boolean paramBoolean, ChatMessage paramChatMessage, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing)) {
        new TeamWorkSender(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a((MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
    }
    else {
      try
      {
        paramInt = Integer.parseInt(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("peerType"));
        paramView = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("filePath");
        String str1 = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("peerUin");
        String str2 = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("strSendUin");
        if (1 == paramInt) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(paramView, str1);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(paramView, str2, str1, paramInt, true);
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.24
 * JD-Core Version:    0.7.0.1
 */