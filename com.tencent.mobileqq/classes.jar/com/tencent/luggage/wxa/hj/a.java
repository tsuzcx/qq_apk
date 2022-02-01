package com.tencent.luggage.wxa.hj;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.hl.a.a;
import com.tencent.luggage.wxa.hs.b;

public abstract class a
  extends Service
{
  private volatile boolean a;
  private volatile boolean b;
  private final a.a c = new a.1(this);
  
  @Nullable
  public IBinder onBind(Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("__bind_key_invoke_id__", 0L);
    paramIntent = paramIntent.getStringExtra("__bind_key_invoke_process__");
    b.a("IPC.BaseIPCService", "onBind, myProcess:%s, invokeProcess:%s, invokeId:%d, killSelf(%s)", new Object[] { g.b(), paramIntent, Long.valueOf(l), Boolean.valueOf(this.a) });
    if (this.a)
    {
      b.a("IPC.BaseIPCService", "need to kill self, return null Binder object.", new Object[0]);
      return null;
    }
    j.a().a(g.b(), this);
    this.b = true;
    return this.c;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    b.a("IPC.BaseIPCService", "onUnbind(%s)", new Object[] { paramIntent });
    boolean bool = super.onUnbind(paramIntent);
    this.b = false;
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hj.a
 * JD-Core Version:    0.7.0.1
 */