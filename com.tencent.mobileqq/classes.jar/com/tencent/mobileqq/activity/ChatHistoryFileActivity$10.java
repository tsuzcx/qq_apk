package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.multimsg.save.FileSaveDialog;
import com.tencent.mobileqq.multimsg.save.FileSaveResult;
import com.tencent.mobileqq.multimsg.save.FileSaveToastUtils;
import com.tencent.mobileqq.multimsg.save.ISaveCallBack;
import com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager;
import java.util.List;

class ChatHistoryFileActivity$10
  implements ISaveCallBack
{
  ChatHistoryFileActivity$10(ChatHistoryFileActivity paramChatHistoryFileActivity, FileSaveDialog paramFileSaveDialog, MultiRichMediaSaveManager paramMultiRichMediaSaveManager, List paramList) {}
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.a(new ChatHistoryFileActivity.10.1(this));
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.show();
  }
  
  public void a(FileSaveResult paramFileSaveResult)
  {
    if ((paramFileSaveResult != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.isFinishing()))
    {
      int i = paramFileSaveResult.a;
      if (i != -1)
      {
        if (i != 0)
        {
          if (i == 3) {
            FileSaveToastUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity);
          }
        }
        else {
          FileSaveToastUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity);
        }
      }
      else {
        FileSaveToastUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a();
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.b();
  }
  
  public void a(FileSaveResult paramFileSaveResult, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.a(paramInt);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a();
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.b();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity, this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryFileActivity.10
 * JD-Core Version:    0.7.0.1
 */