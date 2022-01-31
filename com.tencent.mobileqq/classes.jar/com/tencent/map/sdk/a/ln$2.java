package com.tencent.map.sdk.a;

import android.os.Handler;
import com.tencent.map.lib.basemap.data.GeoPoint;

final class ln$2
  implements pd.a
{
  ln$2(ln paramln) {}
  
  public final int a()
  {
    if (this.a.b == null) {
      return 0;
    }
    return this.a.b.az.c;
  }
  
  public final void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {}
    while ((this.a.b == null) || (this.a.b.ad == null)) {
      return;
    }
    this.a.b.ad.postDelayed(paramRunnable, 100L);
  }
  
  public final GeoPoint b()
  {
    if (this.a.b == null) {
      return null;
    }
    return this.a.b.az.b();
  }
  
  public final float c()
  {
    if (this.a.b == null) {
      return 0.0F;
    }
    return this.a.b.az.g();
  }
  
  public final float d()
  {
    if (this.a.b == null) {
      return 0.0F;
    }
    return this.a.b.az.h();
  }
  
  public final float e()
  {
    if (this.a.b == null) {
      return 0.0F;
    }
    return this.a.w();
  }
  
  public final GeoPoint f()
  {
    if (this.a.b == null) {
      return null;
    }
    return this.a.b.n();
  }
  
  public final boolean g()
  {
    if (this.a.b == null) {
      return false;
    }
    return this.a.b.o.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.ln.2
 * JD-Core Version:    0.7.0.1
 */