package com.tencent.luggage.wxa.lx;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.jx.n;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.util.HashMap;

public class a
  extends n
{
  private static final int CTRL_INDEX = 153;
  private static final String NAME = "onNetworkStatusChange";
  
  public static void c(c paramc)
  {
    HashMap localHashMap = new HashMap();
    f.c localc = f.a(r.a());
    boolean bool;
    if (localc != f.c.a) {
      bool = true;
    } else {
      bool = false;
    }
    localHashMap.put("isConnected", Boolean.valueOf(bool));
    localHashMap.put("networkType", localc.h);
    o.d("MicroMsg.AppBrandOnNetworkStatusChangeEvent", "networkType = %s", new Object[] { localc.h });
    new a().a(paramc).a(localHashMap).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lx.a
 * JD-Core Version:    0.7.0.1
 */