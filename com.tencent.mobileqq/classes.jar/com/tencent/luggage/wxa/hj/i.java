package com.tencent.luggage.wxa.hj;

import android.app.Application;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.hk.c;
import com.tencent.luggage.wxa.hs.b;
import junit.framework.a;

public class i
{
  public static void a(@NonNull Application paramApplication, @NonNull c paramc)
  {
    a.a(paramApplication);
    g.a(paramApplication);
    i.1 local1 = new i.1(paramApplication);
    paramc.b(local1);
    paramc.a(new i.2());
    paramc.a(local1);
    b.a("IPC.IPCInvokerBoot", "setup IPCInvoker(process : %s, application : %s)", new Object[] { g.b(), Integer.valueOf(paramApplication.hashCode()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hj.i
 * JD-Core Version:    0.7.0.1
 */