package com.tencent.beacon.b;

import android.content.Context;

public final class d
  extends com.tencent.beacon.a.f.a
{
  private Context f = null;
  private com.tencent.beacon.a.d.a.b g = null;
  
  public d(Context paramContext)
  {
    super(paramContext, 0, 102);
    this.f = paramContext;
  }
  
  public final com.tencent.beacon.a.d.a.b a()
  {
    if (this.g != null) {
      return this.g;
    }
    b localb;
    try
    {
      localb = b.a(this.f);
      if (localb != null) {
        break label47;
      }
      com.tencent.beacon.a.g.a.d("[qimei] qimeiInfo is null, return", new Object[0]);
      return null;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.a.g.a.a(localThrowable);
    }
    return this.g;
    label47:
    if (localb == null) {}
    Object localObject2;
    for (Object localObject1 = null;; localObject1 = localObject2)
    {
      localObject2 = com.tencent.beacon.a.e.a.a();
      int i = 3;
      int j = 2;
      if (localObject2 != null)
      {
        i = ((com.tencent.beacon.a.e.a)localObject2).l();
        j = ((com.tencent.beacon.a.e.a)localObject2).m();
      }
      localObject2 = new com.tencent.beacon.a.h.b();
      ((com.tencent.beacon.a.h.c)localObject1).a((com.tencent.beacon.a.h.b)localObject2);
      localObject1 = ((com.tencent.beacon.a.h.b)localObject2).b();
      localObject2 = com.tencent.beacon.a.c.b.a(this.c);
      this.g = com.tencent.beacon.a.a.a(this.a, (com.tencent.beacon.a.c.b)localObject2, (byte[])localObject1, j, i);
      break;
      localObject2 = new c();
      String str = localb.c();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      ((c)localObject2).b = ((String)localObject1);
      str = localb.e();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      ((c)localObject2).d = ((String)localObject1);
      str = localb.d();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      ((c)localObject2).c = ((String)localObject1);
      str = localb.f();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      ((c)localObject2).e = ((String)localObject1);
      str = localb.a();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      ((c)localObject2).a = ((String)localObject1);
      str = localb.j();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      ((c)localObject2).f = ((String)localObject1);
      str = localb.k();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      ((c)localObject2).g = ((String)localObject1);
      str = localb.g();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      ((c)localObject2).h = ((String)localObject1);
      ((c)localObject2).i = localb.h();
      str = localb.i();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      ((c)localObject2).j = ((String)localObject1);
      str = localb.l();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      ((c)localObject2).k = ((String)localObject1);
    }
  }
  
  public final void b(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.b.d
 * JD-Core Version:    0.7.0.1
 */