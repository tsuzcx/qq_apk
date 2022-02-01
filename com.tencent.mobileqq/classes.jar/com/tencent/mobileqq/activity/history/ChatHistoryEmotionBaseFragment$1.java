package com.tencent.mobileqq.activity.history;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.multimsg.save.FileSaveDialog;
import com.tencent.mobileqq.multimsg.save.FileSaveResult;
import com.tencent.mobileqq.multimsg.save.FileSaveToastUtils;
import com.tencent.mobileqq.multimsg.save.ISaveCallBack;
import com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager;
import java.util.List;

class ChatHistoryEmotionBaseFragment$1
  implements ISaveCallBack
{
  ChatHistoryEmotionBaseFragment$1(ChatHistoryEmotionBaseFragment paramChatHistoryEmotionBaseFragment, FileSaveDialog paramFileSaveDialog, MultiRichMediaSaveManager paramMultiRichMediaSaveManager, List paramList) {}
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.a(new ChatHistoryEmotionBaseFragment.1.1(this));
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.show();
  }
  
  public void a(FileSaveResult paramFileSaveResult)
  {
    if ((paramFileSaveResult != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryEmotionBaseFragment.getActivity().isFinishing())) {
      switch (paramFileSaveResult.a)
      {
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.dismiss();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryEmotionBaseFragment.v();
      this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.b();
      return;
      FileSaveToastUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryEmotionBaseFragment.getActivity());
      continue;
      FileSaveToastUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryEmotionBaseFragment.getActivity());
      continue;
      FileSaveToastUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryEmotionBaseFragment.getActivity());
    }
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
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryEmotionBaseFragment.v();
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.b();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryEmotionBaseFragment.getActivity(), this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryEmotionBaseFragment.1
 * JD-Core Version:    0.7.0.1
 */