package com.tencent.mm.plugin.appbrand.debugger;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.qw.jm;
import com.tencent.luggage.wxa.qw.ju;
import com.tencent.luggage.wxa.qw.kg;
import com.tencent.luggage.wxa.qw.kl;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class e
{
  private com.tencent.luggage.wxa.du.c a;
  private final jm b = new jm();
  private String c;
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private kl g;
  private f h;
  private AtomicInteger i = new AtomicInteger(0);
  private long j = 0L;
  private long k = 0L;
  private long l;
  private long m = System.currentTimeMillis();
  private AtomicInteger n = new AtomicInteger(0);
  private boolean o;
  private boolean p;
  private final HashMap<String, Method> q = new HashMap();
  private final HashMap<String, kg> r = new HashMap();
  private LinkedList<Pair<String, ValueCallback<String>>> s = new LinkedList();
  private final LinkedList<h> t = new LinkedList();
  private final Map<String, d> u = new HashMap();
  private final LinkedList<ju> v = new LinkedList();
  private final HashMap<Integer, a> w = new HashMap();
  private final Object x = new Object();
  private int y = 0;
  private long z = 0L;
  
  public e()
  {
    this.b.a = 654316592;
  }
  
  public boolean A()
  {
    return i() == 4;
  }
  
  public boolean B()
  {
    return i() == 5;
  }
  
  public boolean C()
  {
    return (!A()) && (this.y < 10L);
  }
  
  public void D()
  {
    this.y = 0;
  }
  
  public void E()
  {
    this.y += 1;
  }
  
  public long F()
  {
    return this.z;
  }
  
  public boolean G()
  {
    return this.h.e == 3;
  }
  
  public boolean H()
  {
    return l.a(this.h.h);
  }
  
  public com.tencent.luggage.wxa.du.c a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    try
    {
      this.d = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    try
    {
      if ((this.e >= paramInt1) && (this.e <= paramInt2)) {
        this.e = paramInt2;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(com.tencent.luggage.wxa.du.c paramc, String paramString)
  {
    this.a = paramc;
    l.a(this.a.i().j().a);
    this.h = l.a(paramString);
    paramString = this.a.i().i();
    if (paramString != null)
    {
      paramString.e = this.h.g;
      paramString.f = true;
      paramc = (com.tencent.luggage.wxa.nz.a)paramc.i().b(com.tencent.luggage.wxa.nz.a.class);
      if (paramc != null) {
        paramc.b = (paramString.e ^ true);
      }
    }
  }
  
  public void a(kl paramkl)
  {
    this.g = paramkl;
  }
  
  public void a(String paramString)
  {
    try
    {
      this.c = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      this.o = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public jm b()
  {
    return this.b;
  }
  
  public void b(int paramInt)
  {
    try
    {
      if (this.e < paramInt) {
        this.e = paramInt;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      this.p = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String c()
  {
    try
    {
      String str = this.c;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c(int paramInt)
  {
    try
    {
      this.f = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int d()
  {
    try
    {
      int i1 = this.d;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void d(int paramInt)
  {
    this.z += paramInt;
  }
  
  public int e()
  {
    try
    {
      int i1 = this.e;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public LinkedList<h> f()
  {
    return this.t;
  }
  
  public Map<String, d> g()
  {
    return this.u;
  }
  
  public LinkedList<ju> h()
  {
    return this.v;
  }
  
  public int i()
  {
    try
    {
      int i1 = this.f;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public f j()
  {
    return this.h;
  }
  
  public int k()
  {
    return this.i.incrementAndGet();
  }
  
  public long l()
  {
    return this.j;
  }
  
  public void m()
  {
    this.j = System.currentTimeMillis();
    q();
  }
  
  public long n()
  {
    return this.k;
  }
  
  public void o()
  {
    this.k = System.currentTimeMillis();
  }
  
  public long p()
  {
    return this.l;
  }
  
  public void q()
  {
    this.l = System.currentTimeMillis();
  }
  
  public long r()
  {
    return this.m;
  }
  
  public void s()
  {
    this.m = System.currentTimeMillis();
  }
  
  public int t()
  {
    return this.n.incrementAndGet();
  }
  
  public boolean u()
  {
    try
    {
      boolean bool = this.o;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public LinkedList<Pair<String, ValueCallback<String>>> v()
  {
    return this.s;
  }
  
  public HashMap<Integer, a> w()
  {
    return this.w;
  }
  
  public boolean x()
  {
    try
    {
      int i1 = i();
      boolean bool;
      if (i1 == 3) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean y()
  {
    try
    {
      boolean bool = this.p;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Object z()
  {
    return this.x;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.e
 * JD-Core Version:    0.7.0.1
 */