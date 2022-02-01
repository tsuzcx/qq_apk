package com.tencent.mobileqq.activity.history;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

class ChatHistoryC2CAllFragment$3
  extends Handler
{
  ChatHistoryC2CAllFragment$3(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      if ((this.a.Q != null) && (this.a.Q.isShowing())) {
        this.a.Q.dismiss();
      }
      paramMessage = this.a;
      paramMessage.Q = new QQProgressDialog(paramMessage.getBaseActivity(), this.a.getBaseActivity().getTitleBarHeight());
      this.a.Q.setCancelable(false);
      this.a.Q.c(2131888457);
      this.a.Q.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment.3
 * JD-Core Version:    0.7.0.1
 */