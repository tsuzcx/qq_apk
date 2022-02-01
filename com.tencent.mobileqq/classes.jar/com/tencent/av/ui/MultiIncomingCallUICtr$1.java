package com.tencent.av.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.av.SessionMgr;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.SeqUtil;

class MultiIncomingCallUICtr$1
  extends BroadcastReceiver
{
  MultiIncomingCallUICtr$1(MultiIncomingCallUICtr paramMultiIncomingCallUICtr) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    long l = SeqUtil.a(paramIntent);
    if (paramContext.equals("tencent.av.EXIT_QZONE_LIVE_RSP_ACTION"))
    {
      if (this.a.g == 1)
      {
        this.a.c.a().postDelayed(new MultiIncomingCallUICtr.1.1(this), 500L);
        return;
      }
      paramContext = SessionMgr.a().b();
      this.a.a(l, paramContext);
      this.a.c.a(new Object[] { Integer.valueOf(67), Long.valueOf(this.a.d), Integer.valueOf(3) });
      if (this.a.o != null) {
        this.a.o.a();
      }
    }
    else
    {
      if (paramContext.equals("tencent.video.invite.multiaccept"))
      {
        paramContext = SessionMgr.a().b();
        this.a.a(l, paramContext);
        return;
      }
      if (paramContext.equals("tencent.video.invite.multirefuse"))
      {
        if (!this.a.b(0)) {
          this.a.a(l, true, null);
        }
      }
      else {
        paramContext.equals("tencent.video.destroyService");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallUICtr.1
 * JD-Core Version:    0.7.0.1
 */