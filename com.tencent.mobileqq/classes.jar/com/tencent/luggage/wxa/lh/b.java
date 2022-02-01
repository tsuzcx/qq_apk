package com.tencent.luggage.wxa.lh;

import android.os.Bundle;
import com.tencent.luggage.wxa.iu.c;
import com.tencent.luggage.wxa.iu.c.c;
import com.tencent.luggage.wxa.qz.o;

public class b
{
  private static String a;
  private static boolean b = true;
  private static c.c c = new b.1();
  
  public static void a(String paramString)
  {
    String str = a;
    if ((str != null) && (c != null))
    {
      o.d("MicroMsg.HCEEventLogic", "alvinluo remove HCELifeCycleListener before add, appId: %s", new Object[] { str });
      c.b(a, c);
    }
    a = paramString;
    c.a(paramString, c);
  }
  
  public static void a(String paramString, int paramInt, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    o.d("MicroMsg.HCEEventLogic", "alvinluo HCEEventLogic sendHCEEventToMM appId: %s, eventType: %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    paramString = new b.a(paramString, paramInt, localBundle, null);
    paramString.h();
    paramString.g();
  }
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      b = paramBoolean;
      return;
    }
    finally {}
  }
  
  public static boolean a()
  {
    try
    {
      boolean bool = b;
      return bool;
    }
    finally {}
  }
  
  public static void b(String paramString)
  {
    if (paramString != null) {
      c.b(paramString, c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lh.b
 * JD-Core Version:    0.7.0.1
 */