package com.tencent.beacon.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.beacon.event.o;

public final class k
{
  protected Runnable a = new Runnable()
  {
    public final void run()
    {
      com.tencent.beacon.d.a.b(" db events to up on screen_on", new Object[0]);
      try
      {
        o.d(true);
        return;
      }
      catch (Throwable localThrowable)
      {
        com.tencent.beacon.d.a.a(localThrowable);
      }
    }
  };
  private Context b;
  private a c;
  
  public k(Context paramContext)
  {
    this.b = paramContext;
    this.c = new a((byte)0);
  }
  
  public final void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    this.b.registerReceiver(this.c, localIntentFilter);
  }
  
  final class a
    extends BroadcastReceiver
  {
    private String a = null;
    
    private a() {}
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      this.a = paramIntent.getAction();
      paramContext = o.d();
      if ("android.intent.action.SCREEN_ON".equals(this.a))
      {
        com.tencent.beacon.d.a.b("on screen", new Object[0]);
        if ((paramContext != null) && (paramContext.c != null)) {
          paramContext.c.a(true);
        }
        c.a().a(k.this.a);
      }
      do
      {
        do
        {
          return;
        } while (!"android.intent.action.SCREEN_OFF".equals(this.a));
        com.tencent.beacon.d.a.b("off screen", new Object[0]);
      } while ((paramContext == null) || (paramContext.c == null));
      paramContext.c.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.k
 * JD-Core Version:    0.7.0.1
 */