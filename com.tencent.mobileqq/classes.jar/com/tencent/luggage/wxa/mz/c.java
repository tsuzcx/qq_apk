package com.tencent.luggage.wxa.mz;

import com.tencent.luggage.wxa.jx.ah;
import java.util.HashMap;

public class c
  extends ah
{
  private static final int CTRL_INDEX = 675;
  private static final String NAME = "onXWebCanvasSurfaceChange";
  private static final c a = new c();
  
  public static void a(com.tencent.luggage.wxa.jx.c paramc, int paramInt)
  {
    try
    {
      HashMap localHashMap = new HashMap(1);
      localHashMap.put("viewId", Integer.valueOf(paramInt));
      a.b(localHashMap);
      paramc.a(a, null);
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mz.c
 * JD-Core Version:    0.7.0.1
 */