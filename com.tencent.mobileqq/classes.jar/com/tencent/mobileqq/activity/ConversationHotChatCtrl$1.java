package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

class ConversationHotChatCtrl$1
  extends HotChatObserver
{
  ConversationHotChatCtrl$1(ConversationHotChatCtrl paramConversationHotChatCtrl, BaseActivity paramBaseActivity) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    this.a.removeObserver(this);
    if (paramBoolean)
    {
      if ((this.b.b != null) && (this.b.b.isShowing())) {
        this.b.b.dismiss();
      }
      QQToast.makeText(this.a, 0, HardCodeUtil.a(2131900759), 0).show(this.a.getTitleBarHeight());
      return;
    }
    if ((this.b.b != null) && (this.b.b.isShowing())) {
      this.b.b.dismiss();
    }
    QQToast.makeText(this.a, 0, HardCodeUtil.a(2131900760), 0).show(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationHotChatCtrl.1
 * JD-Core Version:    0.7.0.1
 */