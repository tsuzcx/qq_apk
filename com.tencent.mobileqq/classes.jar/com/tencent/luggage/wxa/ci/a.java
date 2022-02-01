package com.tencent.luggage.wxa.ci;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.kx.j;
import com.tencent.luggage.wxa.kx.k;
import com.tencent.luggage.wxa.qz.o;

public class a
{
  public static void a(d paramd, int paramInt)
  {
    o.d("WMPF.WMPFBackgroundRunningMonitor", "handleUserAuthChanged been called, flag = %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramd != null)
    {
      Object localObject = (j)paramd.c(j.class);
      if (!(localObject instanceof k))
      {
        o.c("WMPF.WMPFBackgroundRunningMonitor", "handleUserAuthChanged, invalid location state manager");
        return;
      }
      localObject = (k)localObject;
      int i;
      if ((paramInt >> 1 & 0x1) == 1) {
        i = 1;
      } else {
        i = 0;
      }
      if ((paramInt & 0x1) == 1) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      boolean bool1;
      if ((!((k)localObject).a()) && (i == 0)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool2;
      if ((((k)localObject).a()) && ((paramInt == 0) || (i == 0))) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      o.d("WMPF.WMPFBackgroundRunningMonitor", "handleUserAuthChanged, should stop location foreground:%s, should stop location background:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) || (bool2))
      {
        ((k)localObject).j();
        ((k)localObject).a(paramd);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ci.a
 * JD-Core Version:    0.7.0.1
 */