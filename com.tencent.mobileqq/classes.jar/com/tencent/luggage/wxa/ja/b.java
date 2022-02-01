package com.tencent.luggage.wxa.ja;

import android.graphics.Canvas;
import com.tencent.luggage.wxa.jh.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class b
  implements com.tencent.luggage.wxa.ji.b
{
  protected volatile int a = 0;
  protected volatile long b;
  protected volatile long c;
  protected volatile int d;
  protected volatile long e;
  protected volatile long f;
  private volatile boolean g;
  private JSONArray h;
  private volatile com.tencent.luggage.wxa.ji.c i;
  private d j;
  private c k;
  private com.tencent.luggage.wxa.ji.b l;
  private volatile String m;
  private volatile boolean n;
  private Runnable o = new b.1(this);
  private Runnable p = new b.2(this);
  private volatile long q;
  private volatile long r;
  private a s;
  private boolean t = true;
  private String u;
  
  public b(com.tencent.luggage.wxa.ji.b paramb)
  {
    this.l = paramb;
    this.j = new d(new b.a(paramb));
    this.k = new c();
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong1 != 0L)
    {
      this.e += paramLong3 - paramLong2;
      this.c += paramLong3 - paramLong1;
      this.d += 1;
    }
  }
  
  private boolean a(Canvas paramCanvas, JSONArray paramJSONArray)
  {
    this.g = false;
    if (paramJSONArray != null)
    {
      if (paramJSONArray.length() == 0) {
        return false;
      }
      long l1 = this.q;
      long l2 = System.nanoTime();
      this.j.b();
      int i1 = 0;
      while (i1 < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.optJSONObject(i1);
        if (localJSONObject != null) {
          try
          {
            this.k.a(this.j, paramCanvas, localJSONObject);
          }
          catch (Exception localException)
          {
            o.b("MicroMsg.DrawActionDelegateImpl", "drawAction error with method[%s], exception : %s", new Object[] { localJSONObject.optString("method"), localException });
          }
        }
        i1 += 1;
      }
      a(l1, l2, System.nanoTime());
      l1 = System.currentTimeMillis();
      if (!this.n) {
        this.f = l1;
      }
      return true;
    }
    return false;
  }
  
  private boolean b(Canvas paramCanvas)
  {
    this.j.a(true);
    if (this.i == null)
    {
      this.g = false;
      return false;
    }
    if ((this.i.c()) && (!this.i.d())) {
      return a(paramCanvas, this.i.a());
    }
    this.g = false;
    Object localObject;
    if (this.i == null) {
      localObject = null;
    } else {
      localObject = this.i.b();
    }
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return false;
      }
      long l1 = this.q;
      long l2 = System.nanoTime();
      this.j.b();
      localObject = ((List)localObject).iterator();
      try
      {
        while (((Iterator)localObject).hasNext())
        {
          com.tencent.luggage.wxa.jc.d locald = (com.tencent.luggage.wxa.jc.d)((Iterator)localObject).next();
          if (locald != null) {
            try
            {
              int i1 = locald.a;
              if (i1 != 1)
              {
                if (i1 != 2) {
                  o.c("MicroMsg.DrawActionDelegateImpl", "unknown arg type %d", new Object[] { Integer.valueOf(locald.a) });
                } else {
                  this.k.a(this.j, paramCanvas, locald.b);
                }
              }
              else
              {
                this.k.a(this.j, paramCanvas, locald.c);
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("please use draw obj ");
                localStringBuilder.append(locald.c.toString());
                throw new IllegalStateException(localStringBuilder.toString());
              }
            }
            catch (Exception localException)
            {
              o.b("MicroMsg.DrawActionDelegateImpl", "drawAction error, exception : %s", new Object[] { localException });
            }
          }
        }
        return false;
      }
      catch (Exception paramCanvas)
      {
        o.a("MicroMsg.DrawActionDelegateImpl", paramCanvas, "", new Object[0]);
        a(l1, l2, System.nanoTime());
        l1 = System.currentTimeMillis();
        if (!this.n) {
          this.f = l1;
        }
        return true;
      }
    }
  }
  
  private boolean c(Canvas paramCanvas)
  {
    this.j.a(false);
    return a(paramCanvas, this.h);
  }
  
  private void h()
  {
    if (this.r != 0L)
    {
      this.b += System.nanoTime() - this.r;
      this.r = 0L;
      this.a += 1;
      a locala = this.s;
      if (locala != null) {
        locala.a();
      }
    }
  }
  
  public void a(long paramLong)
  {
    this.q = paramLong;
    this.r = paramLong;
  }
  
  public void a(a parama)
  {
    this.s = parama;
  }
  
  public void a(Runnable paramRunnable)
  {
    if (equals(this.l)) {
      return;
    }
    t.a(paramRunnable);
  }
  
  public void a(String paramString)
  {
    this.m = paramString;
  }
  
  public void a(JSONArray paramJSONArray, com.tencent.luggage.wxa.ji.b.a parama)
  {
    this.l.a(new b.3(this, paramJSONArray, parama));
  }
  
  public boolean a()
  {
    return this.g;
  }
  
  public boolean a(Canvas paramCanvas)
  {
    if (this.t) {
      return c(paramCanvas);
    }
    return b(paramCanvas);
  }
  
  public void b() {}
  
  public void b(String paramString)
  {
    this.u = paramString;
  }
  
  public void b(JSONArray paramJSONArray, com.tencent.luggage.wxa.ji.b.a parama)
  {
    if (paramJSONArray != null)
    {
      if (paramJSONArray.length() == 0) {
        return;
      }
      this.l.a(new b.4(this, paramJSONArray, parama));
    }
  }
  
  public void c()
  {
    this.q = 0L;
    this.l.a(this.o);
  }
  
  public void d()
  {
    this.l.a(this.p);
  }
  
  public String e()
  {
    return this.m;
  }
  
  public d f()
  {
    return this.j;
  }
  
  public String g()
  {
    return this.u;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ja.b
 * JD-Core Version:    0.7.0.1
 */