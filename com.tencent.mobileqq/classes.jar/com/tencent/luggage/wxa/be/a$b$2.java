package com.tencent.luggage.wxa.be;

import com.tencent.luggage.wxa.qz.o;

class a$b$2
  implements d.f
{
  a$b$2(a.b paramb) {}
  
  public void a(boolean paramBoolean)
  {
    o.d("MicroMsg.AppBrandCameraView", "onRecordFinish error %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (a.h(this.a.a) == null)
    {
      o.d("MicroMsg.AppBrandCameraView", "onRecordFinish recordView is null");
      a.b.a(this.a, -1, "camera is null", null, null);
      return;
    }
    this.a.a.i();
    if (paramBoolean)
    {
      a.b.a(this.a, -1, "stop error", null, null);
      a.b.a(this.a);
      return;
    }
    if (a.x(this.a.a))
    {
      a.b.b(this.a);
      return;
    }
    a.b localb = this.a;
    a.b.a(localb, a.h(localb.a).c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.be.a.b.2
 * JD-Core Version:    0.7.0.1
 */