package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.V8Object;
import com.tencent.luggage.wxa.qz.o;
import java.lang.ref.WeakReference;

public class t
  extends p
{
  private WeakReference<n> a = null;
  
  void a()
  {
    if (this.a != null) {
      t.b.a(t.b.a(), (n)this.a.get());
    }
  }
  
  protected void a(n paramn, V8Object paramV8Object)
  {
    int i;
    if (paramn != null) {
      i = paramn.hashCode();
    } else {
      i = 0;
    }
    o.d("MicroMsg.V8DirectApiSharedBufferLock", "hy: trigger setup worker %d", new Object[] { Integer.valueOf(i) });
    this.a = new WeakReference(paramn);
    paramV8Object.registerJavaMethod(new t.1(this, paramn), "lockSharedNativeBuffer");
    paramV8Object.registerJavaMethod(new t.2(this), "unlockSharedNativeBuffer");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.t
 * JD-Core Version:    0.7.0.1
 */