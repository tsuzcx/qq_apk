package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.ix.b;
import com.tencent.luggage.wxa.jx.n;
import java.util.HashMap;

public final class i
  extends n
{
  private static final int CTRL_INDEX = -2;
  private static final String NAME = "onAppRunningStatusChange";
  
  public static void a(d paramd, b paramb)
  {
    HashMap localHashMap = new HashMap();
    int i = i.1.a[paramb.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        paramb = "suspend";
      }
      else
      {
        paramb = "active";
      }
    }
    else {
      paramb = "background";
    }
    localHashMap.put("status", paramb);
    new i().a(localHashMap).a(paramd.ae()).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.i
 * JD-Core Version:    0.7.0.1
 */