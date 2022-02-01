package com.tencent.map.sdk.a;

import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.sdk.engine.jni.JNI;

final class pf$21
  implements lw.a
{
  pf$21(pf parampf, boolean paramBoolean, float paramFloat1, float paramFloat2) {}
  
  public final void a()
  {
    if (pf.a(this.d) == 0L) {
      return;
    }
    if (this.a)
    {
      pf.b(this.d).nativeSetScreenCenterOffset(pf.a(this.d), this.b, this.c, true);
      return;
    }
    Object localObject = pf.c(this.d).h;
    DoublePoint localDoublePoint1 = ((fu)localObject).a(this.d.k());
    pf.b(this.d).nativeSetScreenCenterOffset(pf.a(this.d), this.b, this.c, false);
    DoublePoint localDoublePoint2 = ((fu)localObject).a(this.d.k());
    double d1 = localDoublePoint2.x;
    double d2 = localDoublePoint1.x;
    double d3 = localDoublePoint2.y;
    double d4 = localDoublePoint1.y;
    localObject = ((fu)localObject).a(new DoublePoint(localDoublePoint2.x + (d1 - d2), localDoublePoint2.y + (d3 - d4)));
    pf.b(this.d).nativeSetCenter(pf.a(this.d), (GeoPoint)localObject, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.pf.21
 * JD-Core Version:    0.7.0.1
 */