package com.tencent.mobileqq.activity.history;

import com.tencent.mobileqq.app.BaseActivity;
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
    this.a.a(new ChatHistoryEmotionBaseFragment.1.1(this));
    this.a.show();
  }
  
  public void a(FileSaveResult paramFileSaveResult)
  {
    if ((paramFileSaveResult != null) && (!this.d.getBaseActivity().isFinishing()))
    {
      int i = paramFileSaveResult.b;
      if (i != -1)
      {
        if (i != 0)
        {
          if (i == 3) {
            FileSaveToastUtils.c(this.d.getBaseActivity());
          }
        }
        else {
          FileSaveToastUtils.a(this.d.getBaseActivity());
        }
      }
      else {
        FileSaveToastUtils.b(this.d.getBaseActivity());
      }
    }
    if (this.a.isShowing()) {
      this.a.dismiss();
    }
    this.d.changeToUnSelected();
    this.b.b();
  }
  
  public void a(FileSaveResult paramFileSaveResult, int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void b()
  {
    if (this.a.isShowing()) {
      this.a.dismiss();
    }
    this.d.changeToUnSelected();
    this.b.b();
  }
  
  public void c()
  {
    this.b.a(this.d.getBaseActivity(), this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryEmotionBaseFragment.1
 * JD-Core Version:    0.7.0.1
 */