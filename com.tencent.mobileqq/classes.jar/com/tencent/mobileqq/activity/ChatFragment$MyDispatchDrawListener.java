package com.tencent.mobileqq.activity;

import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.StartupTrackerForAio;
import com.tencent.qqperf.opt.suspendthread.SuspendThreadManager;

public class ChatFragment$MyDispatchDrawListener
{
  public ChatFragment$MyDispatchDrawListener(ChatFragment paramChatFragment) {}
  
  public void a()
  {
    if ((ChatFragment.r()) && (this.a.i))
    {
      StartupTrackerForAio.a("AIO_Start_cost", null);
      SuspendThreadManager.a().e();
      StartupTracker.a("AIO_onDrawView", "AIO_SysMsgCost");
      ChatFragment.a(this.a);
      if (this.a.f.getIntent().getIntExtra("uintype", -1) == 1008)
      {
        String str = this.a.f.getIntent().getStringExtra("uin");
        PAStartupTracker.a("pubAcc_aio_open", null, str);
        PAStartupTracker.a("pubAcc_structMsg_display", null, str);
      }
      ChatFragment.c(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatFragment.MyDispatchDrawListener
 * JD-Core Version:    0.7.0.1
 */