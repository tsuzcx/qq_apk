package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;

class ChatHistoryImageView$4
  implements DialogInterface.OnClickListener
{
  ChatHistoryImageView$4(ChatHistoryImageView paramChatHistoryImageView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a;
    ChatHistoryImageView.DownloadAndSaveTask localDownloadAndSaveTask = new ChatHistoryImageView.DownloadAndSaveTask(this.a, this.a.jdField_a_of_type_JavaUtilArrayList, true, false);
    paramDialogInterface.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask = localDownloadAndSaveTask;
    ThreadManager.post(localDownloadAndSaveTask, 5, null, true);
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryImageView.4
 * JD-Core Version:    0.7.0.1
 */