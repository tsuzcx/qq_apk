package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.jx.n;
import java.util.HashMap;

public class j
  extends n
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "onPageReload";
  
  public void a(u paramu, c paramc)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("path", paramu.an());
    a(localHashMap).a(paramc, paramu.getComponentId()).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.j
 * JD-Core Version:    0.7.0.1
 */