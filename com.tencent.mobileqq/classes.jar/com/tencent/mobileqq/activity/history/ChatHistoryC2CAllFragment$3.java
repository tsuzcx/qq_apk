package com.tencent.mobileqq.activity.history;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

class ChatHistoryC2CAllFragment$3
  extends Handler
{
  ChatHistoryC2CAllFragment$3(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      if ((this.a.a != null) && (this.a.a.isShowing())) {
        this.a.a.dismiss();
      }
      this.a.a = new QQProgressDialog(this.a.getActivity(), this.a.getActivity().getTitleBarHeight());
      this.a.a.setCancelable(false);
      this.a.a.c(2131691577);
      this.a.a.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment.3
 * JD-Core Version:    0.7.0.1
 */