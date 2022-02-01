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
    this.a.a(new ChatHistoryFileActivity.10.1(this));
    this.a.show();
  }
  
  public void a(FileSaveResult paramFileSaveResult)
  {
    if ((paramFileSaveResult != null) && (!this.d.isFinishing()))
    {
      int i = paramFileSaveResult.b;
      if (i != -1)
      {
        if (i != 0)
        {
          if (i == 3) {
            FileSaveToastUtils.c(this.d);
          }
        }
        else {
          FileSaveToastUtils.a(this.d);
        }
      }
      else {
        FileSaveToastUtils.b(this.d);
      }
    }
    if (this.a.isShowing()) {
      this.a.dismiss();
    }
    this.d.a();
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
    this.d.a();
    this.b.b();
  }
  
  public void c()
  {
    this.b.a(this.d, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryFileActivity.10
 * JD-Core Version:    0.7.0.1
 */