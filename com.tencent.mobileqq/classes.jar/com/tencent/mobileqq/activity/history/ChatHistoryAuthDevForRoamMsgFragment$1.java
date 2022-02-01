package com.tencent.mobileqq.activity.history;

import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

class ChatHistoryAuthDevForRoamMsgFragment$1
  implements Handler.Callback
{
  ChatHistoryAuthDevForRoamMsgFragment$1(ChatHistoryAuthDevForRoamMsgFragment paramChatHistoryAuthDevForRoamMsgFragment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    ChatHistoryAuthDevForRoamMsgFragment.a(this.a).findViewById(2131381023).setEnabled(true);
    if ((this.a.a != null) && (this.a.a.isShowing())) {
      this.a.a.dismiss();
    }
    if (paramMessage.arg1 == 0) {
      QQToast.a(this.a.getActivity(), 2, HardCodeUtil.a(2131701689), 0).b(this.a.getActivity().getTitleBarHeight());
    }
    for (;;)
    {
      this.a.getActivity().setResult(1);
      this.a.getActivity().finish();
      return false;
      QQToast.a(this.a.getActivity(), 2, HardCodeUtil.a(2131701699), 0).b(this.a.getActivity().getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryAuthDevForRoamMsgFragment.1
 * JD-Core Version:    0.7.0.1
 */