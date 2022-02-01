package com.tencent.mobileqq.activity.history;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.multimsg.save.FileSaveDialog;
import com.tencent.mobileqq.multimsg.save.FileSaveResult;
import com.tencent.mobileqq.multimsg.save.FileSaveToastUtils;
import com.tencent.mobileqq.multimsg.save.ISaveCallBack;
import com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager;
import java.util.List;

class ChatHistoryMediaBaseFragment$3
  implements ISaveCallBack
{
  ChatHistoryMediaBaseFragment$3(ChatHistoryMediaBaseFragment paramChatHistoryMediaBaseFragment, FileSaveDialog paramFileSaveDialog, MultiRichMediaSaveManager paramMultiRichMediaSaveManager, List paramList) {}
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.a(new ChatHistoryMediaBaseFragment.3.1(this));
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.show();
  }
  
  public void a(FileSaveResult paramFileSaveResult)
  {
    if ((paramFileSaveResult != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryMediaBaseFragment.getBaseActivity().isFinishing()))
    {
      int i = paramFileSaveResult.a;
      if (i != -1)
      {
        if (i != 0)
        {
          if (i == 3) {
            FileSaveToastUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryMediaBaseFragment.getBaseActivity());
          }
        }
        else {
          FileSaveToastUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryMediaBaseFragment.getBaseActivity());
        }
      }
      else {
        FileSaveToastUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryMediaBaseFragment.getBaseActivity());
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryMediaBaseFragment.w();
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
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryMediaBaseFragment.w();
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.b();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryMediaBaseFragment.getBaseActivity(), this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryMediaBaseFragment.3
 * JD-Core Version:    0.7.0.1
 */