package com.tencent.luggage.wxa.hj;

import android.os.Parcelable;
import com.tencent.luggage.wxa.hl.a;

final class h$1
  implements Runnable
{
  h$1(String paramString, Class paramClass, Parcelable paramParcelable, e parame) {}
  
  public void run()
  {
    if (g.a(this.a))
    {
      localObject1 = (c)p.a(this.b, c.class);
      if (localObject1 == null)
      {
        com.tencent.luggage.wxa.hs.b.b("IPC.IPCInvoker", "invokeAsync failed, newInstance(%s) return null.", new Object[] { this.b });
        return;
      }
      ((c)localObject1).a(this.c, this.d);
      return;
    }
    Object localObject2 = d.a().a(this.a);
    if (localObject2 == null)
    {
      com.tencent.luggage.wxa.hs.b.b("IPC.IPCInvoker", "invokeAsync failed, get bridge is null by process(%s).", new Object[] { this.a });
      localObject1 = this.d;
      if ((localObject1 instanceof f)) {
        ((f)localObject1).a();
      }
      return;
    }
    Object localObject1 = null;
    try
    {
      if (this.d != null) {
        localObject1 = new h.a(this.a, this.d);
      }
      ((a)localObject2).a(h.a(this.c, this.b), this.b.getName(), (com.tencent.luggage.wxa.hl.b)localObject1);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.luggage.wxa.hs.b.d("IPC.IPCInvoker", "invokeAsync failed, ipc invoke error : %s", new Object[] { localException });
      localObject2 = this.d;
      if ((localObject2 instanceof f)) {
        ((f)localObject2).a(localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hj.h.1
 * JD-Core Version:    0.7.0.1
 */