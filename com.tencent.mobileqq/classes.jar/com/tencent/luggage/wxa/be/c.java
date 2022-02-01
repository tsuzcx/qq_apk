package com.tencent.luggage.wxa.be;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.r;

class c
  implements d.d
{
  private final com.tencent.luggage.wxa.jx.c a;
  private final r b;
  private boolean c;
  private int d;
  
  public c(com.tencent.luggage.wxa.jx.c paramc)
  {
    this.a = paramc;
    this.b = ((r)this.a.getJsRuntime().a(r.class));
    this.d = -2147483648;
  }
  
  public int a(d paramd, int paramInt1, int paramInt2)
  {
    if (paramd == null)
    {
      o.c("MicroMsg.FrameDataCallbackHelper", "listenFrameChange recordView null");
      return -1;
    }
    if (this.b == null) {
      return -2;
    }
    int i = this.d;
    if (i != -2147483648)
    {
      o.d("MicroMsg.FrameDataCallbackHelper", "listenFrameChange destroy last one bufferId:%d", new Object[] { Integer.valueOf(i) });
      this.b.d(this.d);
    }
    this.d = this.b.f(paramInt1 * paramInt2 * 4);
    o.d("MicroMsg.FrameDataCallbackHelper", "listenFrameChange bufferId:%d height:%d width:%d", new Object[] { Integer.valueOf(this.d), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    this.c = true;
    paramd.a(this.b.e(this.d), this);
    return this.d;
  }
  
  public void a()
  {
    if (!this.c)
    {
      o.d("MicroMsg.FrameDataCallbackHelper", "onDateUpdate not need callback");
      return;
    }
    this.a.a(new c.a(this));
  }
  
  public void a(d paramd)
  {
    this.c = false;
    if (paramd != null) {
      paramd.a(null, null);
    }
    int i = this.d;
    if (i != -2147483648)
    {
      this.b.d(i);
      this.d = -2147483648;
    }
  }
  
  public void b(d paramd)
  {
    o.d("MicroMsg.FrameDataCallbackHelper", "onUIPause mNeedCallback:%b", new Object[] { Boolean.valueOf(this.c) });
    if (paramd == null)
    {
      o.c("MicroMsg.FrameDataCallbackHelper", "onUIPause recordView null");
      return;
    }
    paramd.a(null, null);
  }
  
  public void c(d paramd)
  {
    o.d("MicroMsg.FrameDataCallbackHelper", "onUIResume mNeedCallback:%b", new Object[] { Boolean.valueOf(this.c) });
    if (!this.c) {
      return;
    }
    if (paramd == null)
    {
      o.c("MicroMsg.FrameDataCallbackHelper", "onUIResume recordView null");
      return;
    }
    int i = this.d;
    if (i == -2147483648)
    {
      o.c("MicroMsg.FrameDataCallbackHelper", "onUIResume invalid mCurrentSharedBufferId");
      return;
    }
    r localr = this.b;
    if (localr == null)
    {
      o.c("MicroMsg.FrameDataCallbackHelper", "onUIResume mSharedBufferAddon null");
      return;
    }
    paramd.a(localr.e(i), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.be.c
 * JD-Core Version:    0.7.0.1
 */