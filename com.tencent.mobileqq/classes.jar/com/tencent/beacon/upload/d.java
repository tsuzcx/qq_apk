package com.tencent.beacon.upload;

import android.content.Context;
import com.tencent.beacon.a.f;
import com.tencent.beacon.a.j;

public final class d
  extends a
{
  private Context f = null;
  private com.tencent.beacon.b.a.b g = null;
  
  public d(Context paramContext)
  {
    super(paramContext, 0, 102);
    this.f = paramContext;
  }
  
  public final com.tencent.beacon.b.a.b a()
  {
    com.tencent.beacon.d.a.b("QIMEIUploadDatas.getUploadRequestPackage() start", new Object[0]);
    if (this.g != null) {
      return this.g;
    }
    j localj;
    try
    {
      localj = j.a(this.f);
      if (localj != null) {
        break label56;
      }
      com.tencent.beacon.d.a.c("QIMEIInfo instance is null, return", new Object[0]);
      return null;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.d.a.a(localThrowable);
    }
    return this.g;
    label56:
    if (localj == null) {}
    Object localObject2;
    for (Object localObject1 = null;; localObject1 = localObject2)
    {
      localObject2 = com.tencent.beacon.a.b.b.a(this.c).e();
      int i = 3;
      int j = 2;
      if (localObject2 != null)
      {
        i = ((com.tencent.beacon.a.b.d)localObject2).k();
        j = ((com.tencent.beacon.a.b.d)localObject2).l();
      }
      localObject1 = ((com.tencent.beacon.b.c.a)localObject1).a();
      localObject2 = com.tencent.beacon.a.d.m();
      this.g = f.a(this.a, (com.tencent.beacon.a.d)localObject2, (byte[])localObject1, j, i);
      break;
      localObject2 = new com.tencent.beacon.b.c.a();
      String str = localj.c();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      ((com.tencent.beacon.b.c.a)localObject2).b = ((String)localObject1);
      str = localj.e();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      ((com.tencent.beacon.b.c.a)localObject2).d = ((String)localObject1);
      str = localj.d();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      ((com.tencent.beacon.b.c.a)localObject2).c = ((String)localObject1);
      str = localj.f();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      ((com.tencent.beacon.b.c.a)localObject2).e = ((String)localObject1);
      str = localj.a();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      ((com.tencent.beacon.b.c.a)localObject2).a = ((String)localObject1);
      str = localj.m();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      ((com.tencent.beacon.b.c.a)localObject2).f = ((String)localObject1);
      str = localj.q();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      ((com.tencent.beacon.b.c.a)localObject2).g = ((String)localObject1);
      str = localj.r();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      ((com.tencent.beacon.b.c.a)localObject2).h = ((String)localObject1);
      str = localj.g();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      ((com.tencent.beacon.b.c.a)localObject2).i = ((String)localObject1);
      ((com.tencent.beacon.b.c.a)localObject2).j = localj.h();
      ((com.tencent.beacon.b.c.a)localObject2).k = true;
      str = localj.p();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      ((com.tencent.beacon.b.c.a)localObject2).l = ((String)localObject1);
      str = localj.i();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      ((com.tencent.beacon.b.c.a)localObject2).m = ((String)localObject1);
      str = localj.j();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      ((com.tencent.beacon.b.c.a)localObject2).n = ((String)localObject1);
      str = localj.m();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      ((com.tencent.beacon.b.c.a)localObject2).o = ((String)localObject1);
      str = localj.k();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      ((com.tencent.beacon.b.c.a)localObject2).p = ((String)localObject1);
      str = localj.n();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      ((com.tencent.beacon.b.c.a)localObject2).q = ((String)localObject1);
      str = localj.l();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      ((com.tencent.beacon.b.c.a)localObject2).r = ((String)localObject1);
      str = localj.o();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      ((com.tencent.beacon.b.c.a)localObject2).s = ((String)localObject1);
    }
  }
  
  public final void b(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.upload.d
 * JD-Core Version:    0.7.0.1
 */