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
      if ((this.a.V != null) && (this.a.V.isShowing()) && (!this.a.isFinishing())) {
        this.a.V.dismiss();
      }
      paramMessage = this.a;
      paramMessage.V = new QQProgressDialog(paramMessage, paramMessage.getTitleBarHeight());
      this.a.V.setCancelable(false);
      this.a.V.c(2131888457);
      if (!this.a.isFinishing()) {
        this.a.V.show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.2
 * JD-Core Version:    0.7.0.1
 */