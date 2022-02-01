package com.tencent.av.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.SessionMgr;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.QQAudioHelper;

class MultiIncomingCallsActivity$4
  extends BroadcastReceiver
{
  MultiIncomingCallsActivity$4(MultiIncomingCallsActivity paramMultiIncomingCallsActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("tencent.av.EXIT_QZONE_LIVE_RSP_ACTION"))
    {
      long l = QQAudioHelper.d();
      paramContext = SessionMgr.a().b();
      paramIntent = this.a;
      paramIntent.a(l, "BroadcastReceiver_qzone", paramIntent.getIntent(), paramContext);
      this.a.e.a(new Object[] { Integer.valueOf(67), Long.valueOf(this.a.b), Integer.valueOf(3) });
      this.a.b("BroadcastReceiver_qzone");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallsActivity.4
 * JD-Core Version:    0.7.0.1
 */