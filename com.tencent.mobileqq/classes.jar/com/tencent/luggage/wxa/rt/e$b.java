package com.tencent.luggage.wxa.rt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Message;
import com.tencent.luggage.wxa.ry.b;

final class e$b
  extends BroadcastReceiver
{
  private boolean b;
  private boolean c;
  private CancellationSignal d;
  
  private e$b(e parame) {}
  
  private void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Idle status changed: charging = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", interactive = ");
    localStringBuilder.append(this.c);
    b.d("VFS.FileSystemManager", localStringBuilder.toString());
    if ((this.b) && (!this.c) && (this.d == null))
    {
      long l = e.a(this.a);
      if (l < 0L) {
        return;
      }
      this.d = new CancellationSignal();
      e.b(this.a).sendMessageDelayed(Message.obtain(e.b(this.a), 2, this.d), l);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("System idle, trigger maintenance timer for ");
      localStringBuilder.append(l / 1000L);
      localStringBuilder.append(" seconds.");
      b.c("VFS.FileSystemManager", localStringBuilder.toString());
      return;
    }
    if (((!this.b) || (this.c)) && (this.d != null))
    {
      e.b(this.a).removeMessages(2);
      this.d.cancel();
      this.d = null;
      b.c("VFS.FileSystemManager", "Exit idle state, maintenance cancelled.");
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {
      return;
    }
    int i = -1;
    switch (paramContext.hashCode())
    {
    default: 
      break;
    case 1019184907: 
      if (paramContext.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
        i = 2;
      }
      break;
    case -1454123155: 
      if (paramContext.equals("android.intent.action.SCREEN_ON")) {
        i = 0;
      }
      break;
    case -1886648615: 
      if (paramContext.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
        i = 3;
      }
      break;
    case -2128145023: 
      if (paramContext.equals("android.intent.action.SCREEN_OFF")) {
        i = 1;
      }
      break;
    }
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            this.b = false;
          }
        }
        else {
          this.b = true;
        }
      }
      else {
        this.c = false;
      }
    }
    else {
      this.c = true;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rt.e.b
 * JD-Core Version:    0.7.0.1
 */