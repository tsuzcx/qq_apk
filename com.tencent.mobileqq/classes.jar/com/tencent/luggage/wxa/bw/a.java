package com.tencent.luggage.wxa.bw;

import android.os.Build.VERSION;
import android.view.WindowInsets;
import com.tencent.luggage.wxa.bp.b;
import com.tencent.luggage.wxa.or.n;
import com.tencent.luggage.wxa.pc.g;
import com.tencent.luggage.wxa.qz.o;

public class a
{
  public static int a(com.tencent.luggage.wxa.du.c paramc)
  {
    if ((paramc.i() != null) && (paramc.d(com.tencent.luggage.wxa.bp.a.class) != null)) {
      if (((b)paramc.d(b.class) != null) && ((paramc.y() instanceof n)))
      {
        int i;
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramc = paramc.G();
          if (paramc != null)
          {
            paramc = com.tencent.mm.ui.c.b(paramc);
            if (paramc != null)
            {
              i = paramc.getStableInsetTop();
              if (i > 0) {
                return g.a(i);
              }
            }
          }
        }
        else
        {
          i = com.tencent.mm.ui.a.a(paramc.getContext(), 0);
          if (i > 0) {
            return g.a(i);
          }
        }
      }
      else
      {
        o.a("MicroMsg.WAGameCommonUtil", new com.tencent.luggage.wxa.bp.c(), "hy: not game service", new Object[0]);
      }
    }
    return 0;
  }
  
  public static void a(a.a parama, Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    if (parama != null)
    {
      if (a.a.a(parama)) {
        return;
      }
      boolean bool = false;
      try
      {
        if (!a.a.a(parama)) {
          bool = a.a.a(parama, true);
        }
        if (bool) {
          paramRunnable.run();
        }
        return;
      }
      finally {}
    }
    throw new IllegalStateException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bw.a
 * JD-Core Version:    0.7.0.1
 */