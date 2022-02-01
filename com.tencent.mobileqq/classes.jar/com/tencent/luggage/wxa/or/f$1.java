package com.tencent.luggage.wxa.or;

import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.luggage.wxa.qz.o;
import java.lang.ref.WeakReference;

class f$1
  extends ContentObserver
{
  f$1(f paramf, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public boolean deliverSelfNotifications()
  {
    return true;
  }
  
  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    o.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: lock orientation settings changed! request now");
    if ((f.b(this.a) != null) && (f.c(this.a).get() != null))
    {
      o.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: need change");
      f localf = this.a;
      localf.a(f.a(localf, f.b(localf)), null);
      f.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.or.f.1
 * JD-Core Version:    0.7.0.1
 */