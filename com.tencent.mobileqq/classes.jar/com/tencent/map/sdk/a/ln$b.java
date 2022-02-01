package com.tencent.map.sdk.a;

import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.CancelableCallback;

final class ln$b
  implements ln.a
{
  private boolean b = false;
  
  public ln$b(ln paramln, boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public final void a()
  {
    if ((this.a.b.aq == 0) || (this.a.b.ar == 0)) {}
    do
    {
      return;
      this.a.b.F = null;
    } while ((this.a.b.aj == null) || (this.a.b.ak == null));
    Object localObject = new GeoPoint();
    float f;
    int i;
    int j;
    if ((this.a.b.am == 0) && (this.a.b.an == 0) && (this.a.b.ao == 0) && (this.a.b.ap == 0))
    {
      f = this.a.a(0, 0, 0, 0, this.a.b.aj, this.a.b.ak, (GeoPoint)localObject);
      TencentMap.CancelableCallback localCancelableCallback = this.a.b.D;
      i = ((GeoPoint)localObject).getLatitudeE6();
      j = ((GeoPoint)localObject).getLongitudeE6();
      if (!this.b) {
        break label409;
      }
      localObject = new pd();
      ((pd)localObject).c(0.0F);
      ((pd)localObject).d(0.0F);
      ((pd)localObject).b(i, j);
      ((pd)localObject).a(f);
      ((pd)localObject).a = this.a.h;
      ((pd)localObject).d = localCancelableCallback;
      this.a.b.az.a((nv)localObject);
    }
    for (;;)
    {
      this.a.b.aj = null;
      this.a.b.ak = null;
      this.a.b.am = 0;
      this.a.b.an = 0;
      this.a.b.ao = 0;
      this.a.b.ap = 0;
      this.a.b.D = null;
      return;
      f = this.a.a(this.a.b.am, this.a.b.an, this.a.b.ao, this.a.b.ap, this.a.b.aj, this.a.b.ak, (GeoPoint)localObject);
      break;
      label409:
      this.a.b.az.b(0.0F);
      this.a.b.az.a(0.0F);
      this.a.b.az.a(i, j);
      this.a.a(f, false, 0L, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ln.b
 * JD-Core Version:    0.7.0.1
 */