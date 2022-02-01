package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.StartupTrackerForAio;
import com.tencent.qqperf.opt.suspendthread.SuspendThreadManager;

public class ChatFragment$MyDispatchDrawListener
{
  public ChatFragment$MyDispatchDrawListener(ChatFragment paramChatFragment) {}
  
  public void a()
  {
    if ((ChatFragment.b()) && (this.a.b))
    {
      StartupTrackerForAio.a("AIO_Start_cost", null);
      SuspendThreadManager.a().d();
      StartupTracker.a("AIO_onDrawView", "AIO_SysMsgCost");
      ChatFragment.a(this.a);
      if (this.a.a.getIntent().getIntExtra("uintype", -1) == 1008)
      {
        String str = this.a.a.getIntent().getStringExtra("uin");
        PAStartupTracker.a("pubAcc_aio_open", null, str);
        PAStartupTracker.a("pubAcc_structMsg_display", null, str);
      }
      ChatFragment.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatFragment.MyDispatchDrawListener
 * JD-Core Version:    0.7.0.1
 */