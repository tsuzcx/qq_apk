package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

final class ChatActivityFacade$17
  implements Runnable
{
  ChatActivityFacade$17(Context paramContext, ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ChatActivityFacade.jdField_a_of_type_ComTencentWidgetActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    ChatActivityFacade.jdField_a_of_type_ComTencentMobileqqDataChatMessage = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    String str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131696093);
    ChatActivityFacade.jdField_a_of_type_ComTencentWidgetActionSheet.setMainTitle(str);
    ChatActivityFacade.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131691479, 3);
    ChatActivityFacade.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690728);
    ChatActivityFacade.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new ChatActivityFacade.17.1(this));
    ChatActivityFacade.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.17
 * JD-Core Version:    0.7.0.1
 */