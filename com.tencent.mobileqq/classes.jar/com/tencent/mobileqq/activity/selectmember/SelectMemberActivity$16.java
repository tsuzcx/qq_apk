package com.tencent.mobileqq.activity.selectmember;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.widget.QQToast;

class SelectMemberActivity$16
  extends Handler
{
  SelectMemberActivity$16(SelectMemberActivity paramSelectMemberActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
      } while ((this.this$0.pd == null) || (!this.this$0.pd.isShowing()));
      this.this$0.pd.dismiss();
      paramMessage = new Intent();
      paramMessage.putExtra("select_member_add_request_ok", true);
      this.this$0.setResult(-1, paramMessage);
      if (!TextUtils.isEmpty(this.this$0.mInviteSuccToastWording))
      {
        paramMessage = this.this$0.mInviteSuccToastWording;
        QQToast.a(this.this$0, 2, paramMessage, 1500).b(this.this$0.getTitleBarHeight());
        postDelayed(new SelectMemberActivity.16.1(this), 1500L);
        return;
      }
      if (this.this$0.mIsTroopAdmin) {}
      for (int i = 2131693378;; i = 2131693377)
      {
        paramMessage = this.this$0.getResources().getString(i);
        break;
      }
    } while ((this.this$0.pd == null) || (!this.this$0.pd.isShowing()));
    this.this$0.pd.dismiss();
    String str = (String)paramMessage.obj;
    paramMessage = str;
    if (str == null) {
      paramMessage = this.this$0.getString(2131693376);
    }
    QQToast.a(this.this$0, 1, paramMessage, 1500).b(this.this$0.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.16
 * JD-Core Version:    0.7.0.1
 */