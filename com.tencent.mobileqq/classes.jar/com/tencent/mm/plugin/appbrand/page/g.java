package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.wxa.iu.c;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jx.n;
import java.util.HashMap;

public class g
  extends n
{
  private static final int CTRL_INDEX = 49;
  private static final String NAME = "onAppEnterBackground";
  
  public void a(d paramd)
  {
    HashMap localHashMap = new HashMap(1);
    Object localObject = c.i(paramd.aa());
    int i = g.1.a[localObject.ordinal()];
    String str = "hide";
    localObject = str;
    switch (i)
    {
    default: 
      localObject = str;
      break;
    case 7: 
      localObject = "launchMiniProgram";
      break;
    case 6: 
      localObject = "hang";
      break;
    case 2: 
      localObject = "back";
      break;
    case 1: 
      localObject = "close";
    }
    localHashMap.put("mode", localObject);
    a(localHashMap).a(paramd.ae()).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.g
 * JD-Core Version:    0.7.0.1
 */