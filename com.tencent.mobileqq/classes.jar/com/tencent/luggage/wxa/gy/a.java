package com.tencent.luggage.wxa.gy;

import com.tencent.luggage.wxa.nt.d;
import com.tencent.luggage.wxa.nt.d.a;
import com.tencent.luggage.wxa.qz.o;

public class a
{
  private b a;
  private d b;
  private d.a c = new a.1(this);
  private b.a d = new a.2(this);
  private Object e = new Object();
  private final int f;
  private final int g;
  private final int h;
  private final double i;
  private String j;
  private String k;
  private a.a l;
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, double paramDouble, String paramString1, String paramString2)
  {
    this.f = paramInt2;
    this.g = paramInt3;
    this.h = paramInt5;
    this.i = paramDouble;
    this.a = new b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.j = paramString1;
    this.k = paramString2;
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    synchronized (this.e)
    {
      d locald = this.b;
      if (locald != null) {
        try
        {
          if (!this.b.a(false, paramArrayOfByte, paramInt)) {
            o.b("MicroMsg.RecorderPcm", "encode pcm fail!");
          }
        }
        catch (Exception paramArrayOfByte)
        {
          o.b("MicroMsg.RecorderPcm", "encodePcm fail length:%d exception:%s", new Object[] { Integer.valueOf(paramInt), paramArrayOfByte });
        }
      }
      return;
    }
  }
  
  private boolean a(String paramString)
  {
    if (this.a == null)
    {
      o.b("MicroMsg.RecorderPcm", paramString);
      return true;
    }
    return false;
  }
  
  private void f()
  {
    synchronized (this.e)
    {
      if (this.b != null)
      {
        this.b.a();
        this.b.b();
        this.b = null;
      }
      return;
    }
  }
  
  private boolean g()
  {
    Object localObject = this.j;
    boolean bool1 = false;
    o.d("MicroMsg.RecorderPcm", "initEncoder mFilePath:%s", new Object[] { localObject });
    localObject = this.b;
    if (localObject != null)
    {
      ((d)localObject).b();
      this.b = null;
    }
    this.b = com.tencent.luggage.wxa.nt.b.b(this.k);
    if (this.b == null)
    {
      o.b("MicroMsg.RecorderPcm", "mAudioEncoder init fail, return false");
      return false;
    }
    if (!com.tencent.luggage.wxa.ns.a.b(this.j))
    {
      o.b("MicroMsg.RecorderPcm", "prepare cache file fail");
      return false;
    }
    try
    {
      boolean bool2 = this.b.a(this.j, this.f, this.g, this.h);
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.RecorderPcm", localException, "init encoder fail", new Object[0]);
    }
    this.b.a(this.c);
    this.b.a(this.a.a());
    this.b.a(this.i);
    return bool1;
  }
  
  public void a(a.a parama)
  {
    this.l = parama;
  }
  
  public boolean a()
  {
    if (a("startRecord fail, recorder is null, return")) {
      return false;
    }
    if (!g())
    {
      o.b("MicroMsg.RecorderPcm", "initEncoder fail");
      return false;
    }
    this.a.a(this.d);
    boolean bool = this.a.b();
    o.d("MicroMsg.RecorderPcm", "startRecord:%b", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  public boolean b()
  {
    if (a("pauseRecord fail, recorder is null, return")) {
      return false;
    }
    return this.a.c();
  }
  
  public boolean c()
  {
    if (a("resumeRecord fail, recorder is null, return")) {
      return false;
    }
    return this.a.d();
  }
  
  public boolean d()
  {
    if (a("stopRecord fail, recorder is null, return")) {
      return false;
    }
    boolean bool = this.a.e();
    f();
    e();
    o.d("MicroMsg.RecorderPcm", "stopRecord:%b", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  public void e()
  {
    try
    {
      this.a.f();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gy.a
 * JD-Core Version:    0.7.0.1
 */