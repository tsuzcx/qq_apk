package com.tencent.beacon.e;

import com.tencent.beacon.a.a.d;
import com.tencent.beacon.a.c.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class b
  implements d
{
  private static volatile b a;
  private boolean A = true;
  protected int B = 10000;
  protected boolean C = false;
  protected int D = 1;
  protected int b = 48;
  protected int c = 2000;
  protected int d = 48;
  protected int e = 3000;
  protected boolean f = true;
  protected boolean g = true;
  protected Set<String> h = null;
  protected Map<String, Float> i = null;
  protected boolean j = false;
  protected boolean k = false;
  protected boolean l = false;
  protected float m = 1.0F;
  protected boolean n = false;
  protected boolean o = false;
  protected boolean p = false;
  protected int q = 1;
  protected long r = 6400L;
  protected int s = 20;
  protected int t = 300;
  protected boolean u = true;
  protected boolean v = true;
  protected boolean w = true;
  protected boolean x = true;
  protected boolean y = true;
  protected boolean z = true;
  
  protected b()
  {
    com.tencent.beacon.a.a.b.a().a(8, this);
  }
  
  public static b a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new b();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void b(Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("d_m", new HashMap(paramMap));
    com.tencent.beacon.a.a.b.a().b(new com.tencent.beacon.a.a.c(2, localHashMap));
  }
  
  public void a(Map<String, String> paramMap)
  {
    if (paramMap != null) {
      try
      {
        b(paramMap);
        try
        {
          this.b = com.tencent.beacon.base.util.b.a((String)paramMap.get("realtimeUploadNum"), this.b, 5, 15);
          this.c = com.tencent.beacon.base.util.b.a((String)paramMap.get("realtimePollingTime"), this.c, 1000, 10000);
          this.e = com.tencent.beacon.base.util.b.a((String)paramMap.get("normalPollingTime"), this.e, 2000, 15000);
          this.d = com.tencent.beacon.base.util.b.a((String)paramMap.get("normalUploadNum"), this.d, 1, 15);
          this.g = com.tencent.beacon.base.util.b.a((String)paramMap.get("heartOnOff"), this.g);
          this.j = com.tencent.beacon.base.util.b.a((String)paramMap.get("tidyEF"), this.j);
          this.k = com.tencent.beacon.base.util.b.a((String)paramMap.get("lauEveSim"), this.k);
          this.l = com.tencent.beacon.base.util.b.a((String)paramMap.get("zeroPeakOnOff"), this.l);
          Object localObject = (String)paramMap.get("zeroPeakRate");
          if (localObject != null)
          {
            localObject = ((String)localObject).trim();
            int i1 = ((String)localObject).length();
            if (i1 > 0)
            {
              localObject = ((String)localObject).split(",");
              i1 = localObject.length;
              if (i1 == 2) {
                try
                {
                  this.m = (Float.valueOf(localObject[0]).floatValue() / Float.valueOf(localObject[1]).floatValue());
                }
                catch (Exception localException)
                {
                  com.tencent.beacon.base.util.c.a(localException);
                }
              }
            }
          }
          this.C = com.tencent.beacon.base.util.b.a((String)paramMap.get("straOnOff"), this.C);
          this.D = com.tencent.beacon.base.util.b.a((String)paramMap.get("straDayMaxCount"), this.D, 1, 2147483647);
          this.n = com.tencent.beacon.base.util.b.a((String)paramMap.get("acceleEnable"), this.n);
          this.o = com.tencent.beacon.base.util.b.a((String)paramMap.get("gyroEnable"), this.o);
          this.p = com.tencent.beacon.base.util.b.a((String)paramMap.get("magneticEnable"), this.p);
          this.q = com.tencent.beacon.base.util.b.a((String)paramMap.get("gatherCount"), this.q, 1, 50);
          this.r = com.tencent.beacon.base.util.b.a((String)paramMap.get("gatherDur"), this.r, 1000L, 20000L);
          this.s = com.tencent.beacon.base.util.b.a((String)paramMap.get("hertzCount"), this.s, 20, 100);
          this.t = com.tencent.beacon.base.util.b.a((String)paramMap.get("consuming"), this.t, 60, 86400);
          this.u = com.tencent.beacon.base.util.b.a((String)paramMap.get("bidEnable"), this.u);
          this.v = com.tencent.beacon.base.util.b.a((String)paramMap.get("auditEnable"), this.v);
          this.B = com.tencent.beacon.base.util.b.a((String)paramMap.get("maxDBCount"), this.B, 10000, 100000);
          com.tencent.beacon.base.net.c.b.c((String)paramMap.get("eventUrl"));
          com.tencent.beacon.base.net.c.b.e((String)paramMap.get("strategyUrl"));
        }
        catch (Exception paramMap)
        {
          com.tencent.beacon.base.util.c.a(paramMap);
        }
      }
      finally {}
    }
  }
  
  public void a(Set<String> paramSet)
  {
    try
    {
      this.h = paramSet;
      return;
    }
    finally
    {
      paramSet = finally;
      throw paramSet;
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    try
    {
      Set localSet = this.h;
      boolean bool1 = bool2;
      if (localSet != null)
      {
        bool1 = bool2;
        if (localSet.size() > 0) {
          bool1 = this.h.contains(paramString);
        }
      }
      return bool1;
    }
    finally {}
  }
  
  public int b()
  {
    return this.B;
  }
  
  public void b(Set<String> paramSet)
  {
    try
    {
      if (this.i == null) {
        this.i = new HashMap();
      }
      if (paramSet == null) {
        return;
      }
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
      {
        String[] arrayOfString = ((String)paramSet.next()).split(",");
        int i1 = arrayOfString.length;
        if (i1 == 3) {
          try
          {
            float f1 = Float.valueOf(arrayOfString[1]).floatValue() / Float.valueOf(arrayOfString[2]).floatValue();
            this.i.put(arrayOfString[0].toLowerCase(), Float.valueOf(f1));
          }
          catch (Exception localException)
          {
            com.tencent.beacon.base.util.c.a(localException);
          }
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramSet;
    }
  }
  
  public boolean b(String paramString)
  {
    try
    {
      Map localMap = this.i;
      boolean bool = true;
      if ((localMap != null) && (localMap.get(paramString.toLowerCase()) != null))
      {
        int i1 = (int)(((Float)this.i.get(paramString.toLowerCase())).floatValue() * 1000.0F);
        int i2 = new Random().nextInt(1000);
        if (i2 + 1 > i1) {
          bool = false;
        }
        return bool;
      }
      return true;
    }
    finally {}
  }
  
  public int c()
  {
    try
    {
      int i1 = this.D;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean d()
  {
    return this.y;
  }
  
  public boolean e()
  {
    return this.v;
  }
  
  public boolean f()
  {
    return this.u;
  }
  
  public boolean g()
  {
    return this.x;
  }
  
  public boolean h()
  {
    try
    {
      boolean bool = this.k;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean i()
  {
    return this.w;
  }
  
  public boolean j()
  {
    return this.A;
  }
  
  public boolean k()
  {
    return this.f;
  }
  
  public boolean l()
  {
    return this.z;
  }
  
  public boolean m()
  {
    try
    {
      boolean bool = this.C;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onEvent(com.tencent.beacon.a.a.c paramc)
  {
    if (paramc.a != 8) {
      return;
    }
    boolean bool;
    if (paramc.b.containsKey("u_c_a_e")) {
      bool = ((Boolean)paramc.b.get("u_c_a_e")).booleanValue();
    } else {
      bool = this.v;
    }
    this.v = bool;
    if (paramc.b.containsKey("u_c_b_e")) {
      bool = ((Boolean)paramc.b.get("u_c_b_e")).booleanValue();
    } else {
      bool = this.u;
    }
    this.u = bool;
    if (paramc.b.containsKey("u_c_m_e")) {
      bool = ((Boolean)paramc.b.get("u_c_m_e")).booleanValue();
    } else {
      bool = this.w;
    }
    this.w = bool;
    if (paramc.b.containsKey("u_c_i_e")) {
      bool = ((Boolean)paramc.b.get("u_c_i_e")).booleanValue();
    } else {
      bool = this.x;
    }
    this.x = bool;
    int i1;
    if (paramc.b.containsKey("u_c_d_s")) {
      i1 = ((Integer)paramc.b.get("u_c_d_s")).intValue();
    } else {
      i1 = this.B;
    }
    this.B = i1;
    if (paramc.b.containsKey("u_c_p_s")) {
      bool = ((Boolean)paramc.b.get("u_c_p_s")).booleanValue();
    } else {
      bool = this.f;
    }
    this.f = bool;
    if (paramc.b.containsKey("u_c_a_i_e")) {
      bool = ((Boolean)paramc.b.get("u_c_a_i_e")).booleanValue();
    } else {
      bool = this.y;
    }
    this.y = bool;
    if (paramc.b.containsKey("u_c_p_i_e")) {
      bool = ((Boolean)paramc.b.get("u_c_p_i_e")).booleanValue();
    } else {
      bool = this.z;
    }
    this.z = bool;
    if (paramc.b.containsKey("u_c_o_e")) {
      bool = ((Boolean)paramc.b.get("u_c_o_e")).booleanValue();
    } else {
      bool = this.A;
    }
    this.A = bool;
    if (a != null) {
      f.p().N();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.e.b
 * JD-Core Version:    0.7.0.1
 */