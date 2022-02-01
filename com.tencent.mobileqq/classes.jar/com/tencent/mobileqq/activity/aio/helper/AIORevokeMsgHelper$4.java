package com.tencent.mobileqq.activity.aio.helper;

import android.view.View;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AIORevokeMsgHelper$4
  implements ActionSheet.OnButtonClickListener
{
  AIORevokeMsgHelper$4(AIORevokeMsgHelper paramAIORevokeMsgHelper, ChatMessage paramChatMessage, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 3000) {
        FileManagerReporter.a("0X8005E4F");
      } else {
        FileManagerReporter.a("0X8005E4D");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIORevokeMsgHelper.e(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIORevokeMsgHelper.4
 * JD-Core Version:    0.7.0.1
 */