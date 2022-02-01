package com.tencent.beacon.core.b;

import android.content.Context;
import com.tencent.beacon.core.network.volley.RequestQueue;
import com.tencent.beacon.core.network.volley.Volley;
import java.util.Map;

public class f
  implements a
{
  private static volatile f a;
  private static boolean b;
  private RequestQueue c;
  private Context d;
  
  public static f a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new f();
      }
      return a;
    }
    finally {}
  }
  
  public void a(Context paramContext)
  {
    if (b) {
      return;
    }
    b = true;
    this.c = Volley.newRequestQueue(paramContext.getApplicationContext());
    this.d = paramContext;
    this.c.start();
  }
  
  public void a(String paramString, Map<String, String> paramMap, b<String> paramb)
  {
    paramb = new e(this, 1, paramString, new c(this, paramb), new d(this, paramb), paramMap);
    com.tencent.beacon.core.e.d.a("[net] requestUrl: %s, params: %s", new Object[] { paramString, com.tencent.beacon.core.e.c.a(paramMap) });
    this.c.add(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.b.f
 * JD-Core Version:    0.7.0.1
 */