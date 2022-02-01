package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

class ChatHistory$19
  implements DialogInterface.OnClickListener
{
  ChatHistory$19(ChatHistory paramChatHistory) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      this.a.m.setEnabled(false);
      this.a.j();
      ReportController.b(this.a.app, "CliOper", "", "", "AIO", "AIO_chatlog_lately", 0, 0, "", "", "", "");
      return;
    }
    this.a.m.setEnabled(true);
    this.a.ab.dismiss();
    if (this.a.w != null) {
      this.a.w.dismiss();
    }
    this.a.Y.setVisibility(0);
    this.a.C.setText(this.a.getString(2131889169));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.19
 * JD-Core Version:    0.7.0.1
 */