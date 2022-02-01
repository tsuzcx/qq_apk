package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.view.View;
import com.tencent.image.Utils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ChatHistory$27
  implements ActionSheet.OnButtonClickListener
{
  ChatHistory$27(ChatHistory paramChatHistory, MessageRecord paramMessageRecord, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a.obtainMessage(1);
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a.sendMessageDelayed(paramView, 800L);
      Utils.executeAsyncTaskOnThreadPool(new ChatHistory.27.1(this), new MessageRecord[] { this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.27
 * JD-Core Version:    0.7.0.1
 */