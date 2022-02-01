package com.tencent.luggage.wxa.mp;

import com.tencent.luggage.wxa.mo.g;

public class j
  extends c
{
  private j.a a = j.a.a;
  
  private void a(j.a parama)
  {
    try
    {
      this.a = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  private boolean l()
  {
    return j.1.a[this.a.ordinal()] == 1;
  }
  
  private boolean m()
  {
    int i = j.1.a[this.a.ordinal()];
    if (i != 1) {
      return i == 2;
    }
    return false;
  }
  
  private boolean n()
  {
    int i = j.1.a[this.a.ordinal()];
    if ((i != 1) && (i != 2)) {
      return i == 3;
    }
    return false;
  }
  
  private boolean o()
  {
    int i = j.1.a[this.a.ordinal()];
    if (i != 1) {
      return (i == 2) || (i == 3);
    }
    return false;
  }
  
  public g a(e.d paramd)
  {
    try
    {
      if (!l())
      {
        paramd = new g("can not start", new Object[0]);
        return paramd;
      }
      paramd = super.a(paramd);
      return paramd;
    }
    finally {}
  }
  
  protected void a()
  {
    super.a();
    a(j.a.b);
  }
  
  protected void a(String paramString, int paramInt1, int paramInt2)
  {
    super.a(paramString, paramInt1, paramInt2);
    a(j.a.d);
  }
  
  protected void b()
  {
    super.b();
    a(j.a.b);
  }
  
  protected void c()
  {
    super.c();
    a(j.a.c);
  }
  
  protected void g()
  {
    try
    {
      super.g();
      a(j.a.a);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public g h()
  {
    try
    {
      if (!m())
      {
        localg = new g("can not pause", new Object[0]);
        return localg;
      }
      g localg = super.h();
      return localg;
    }
    finally {}
  }
  
  public g i()
  {
    try
    {
      if (!n())
      {
        localg = new g("can not resume", new Object[0]);
        return localg;
      }
      g localg = super.i();
      return localg;
    }
    finally {}
  }
  
  public g j()
  {
    try
    {
      if (!o())
      {
        localg = new g("can not stop", new Object[0]);
        return localg;
      }
      g localg = super.j();
      return localg;
    }
    finally {}
  }
  
  public boolean k()
  {
    try
    {
      if ((this.a != j.a.a) && (this.a != j.a.d))
      {
        j.a locala1 = this.a;
        j.a locala2 = j.a.e;
        if (locala1 != locala2)
        {
          bool = true;
          break label43;
        }
      }
      boolean bool = false;
      label43:
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mp.j
 * JD-Core Version:    0.7.0.1
 */