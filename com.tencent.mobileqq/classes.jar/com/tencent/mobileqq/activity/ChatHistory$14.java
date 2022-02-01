package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatHistory$14
  implements View.OnClickListener
{
  ChatHistory$14(ChatHistory paramChatHistory) {}
  
  public void onClick(View paramView)
  {
    if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      this.a.Y.setVisibility(8);
      if (this.a.f == 0) {
        this.a.n();
      }
    }
    else
    {
      this.a.m.setEnabled(true);
      if (this.a.w != null) {
        this.a.w.dismiss();
      }
      this.a.Y.setVisibility(0);
      this.a.C.setText(this.a.getString(2131889169));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.14
 * JD-Core Version:    0.7.0.1
 */