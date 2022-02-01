package com.tencent.mobileqq.activity.history;

import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

class ChatHistoryAuthDevForRoamMsgFragment$1
  implements Handler.Callback
{
  ChatHistoryAuthDevForRoamMsgFragment$1(ChatHistoryAuthDevForRoamMsgFragment paramChatHistoryAuthDevForRoamMsgFragment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return false;
    }
    ChatHistoryAuthDevForRoamMsgFragment.a(this.a).findViewById(2131449210).setEnabled(true);
    if ((this.a.a != null) && (this.a.a.isShowing())) {
      this.a.a.dismiss();
    }
    if (paramMessage.arg1 == 0) {
      QQToast.makeText(this.a.getBaseActivity(), 2, HardCodeUtil.a(2131899846), 0).show(this.a.getBaseActivity().getTitleBarHeight());
    } else {
      QQToast.makeText(this.a.getBaseActivity(), 2, HardCodeUtil.a(2131899856), 0).show(this.a.getBaseActivity().getTitleBarHeight());
    }
    this.a.getBaseActivity().setResult(1);
    this.a.getBaseActivity().finish();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryAuthDevForRoamMsgFragment.1
 * JD-Core Version:    0.7.0.1
 */