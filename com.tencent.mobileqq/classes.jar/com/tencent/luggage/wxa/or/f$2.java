package com.tencent.luggage.wxa.or;

import android.app.Activity;
import com.tencent.luggage.wxa.oq.e.a;
import com.tencent.luggage.wxa.qz.o;

class f$2
  implements g.a
{
  f$2(f paramf, f.b paramb, Activity paramActivity) {}
  
  public void a()
  {
    o.b("MicroMsg.AppBrandDeviceOrientationHandler", "hy: activity not turn to correct orientation for long time, request[%s]", new Object[] { this.a });
    if (f.b.a(this.a) != null) {
      f.b.a(this.a).a(f.b.b(this.a), false);
    }
  }
  
  public void b()
  {
    o.e("MicroMsg.AppBrandDeviceOrientationHandler", "hy: trigger retry, request[%s]", new Object[] { this.a });
    if (!this.b.isDestroyed()) {
      f.a(this.c, this.b, f.b.b(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.or.f.2
 * JD-Core Version:    0.7.0.1
 */