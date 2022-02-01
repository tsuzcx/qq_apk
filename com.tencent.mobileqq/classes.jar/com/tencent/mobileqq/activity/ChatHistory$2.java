package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.QQProgressDialog;

class ChatHistory$2
  extends Handler
{
  ChatHistory$2(ChatHistory paramChatHistory) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      if ((this.a.a != null) && (this.a.a.isShowing()) && (!this.a.isFinishing())) {
        this.a.a.dismiss();
      }
      paramMessage = this.a;
      paramMessage.a = new QQProgressDialog(paramMessage, paramMessage.getTitleBarHeight());
      this.a.a.setCancelable(false);
      this.a.a.c(2131691498);
      if (!this.a.isFinishing()) {
        this.a.a.show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.2
 * JD-Core Version:    0.7.0.1
 */