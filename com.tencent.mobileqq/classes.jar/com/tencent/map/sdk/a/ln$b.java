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
    if (this.a.b.aq != 0)
    {
      if (this.a.b.ar == 0) {
        return;
      }
      this.a.b.F = null;
      if (this.a.b.aj != null)
      {
        if (this.a.b.ak == null) {
          return;
        }
        Object localObject1 = new GeoPoint();
        float f;
        if ((this.a.b.am == 0) && (this.a.b.an == 0) && (this.a.b.ao == 0) && (this.a.b.ap == 0))
        {
          localObject2 = this.a;
          f = ((ln)localObject2).a(0, 0, 0, 0, ((ln)localObject2).b.aj, this.a.b.ak, (GeoPoint)localObject1);
        }
        else
        {
          localObject2 = this.a;
          f = ((ln)localObject2).a(((ln)localObject2).b.am, this.a.b.an, this.a.b.ao, this.a.b.ap, this.a.b.aj, this.a.b.ak, (GeoPoint)localObject1);
        }
        Object localObject2 = this.a.b.D;
        int i = ((GeoPoint)localObject1).getLatitudeE6();
        int j = ((GeoPoint)localObject1).getLongitudeE6();
        if (this.b)
        {
          localObject1 = new pd();
          ((pd)localObject1).c(0.0F);
          ((pd)localObject1).d(0.0F);
          ((pd)localObject1).b(i, j);
          ((pd)localObject1).a(f);
          ((pd)localObject1).a = this.a.h;
          ((pd)localObject1).d = ((TencentMap.CancelableCallback)localObject2);
          this.a.b.az.a((nv)localObject1);
        }
        else
        {
          this.a.b.az.b(0.0F);
          this.a.b.az.a(0.0F);
          this.a.b.az.a(i, j);
          this.a.a(f, false, 0L, null);
        }
        this.a.b.aj = null;
        this.a.b.ak = null;
        this.a.b.am = 0;
        this.a.b.an = 0;
        this.a.b.ao = 0;
        this.a.b.ap = 0;
        this.a.b.D = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ln.b
 * JD-Core Version:    0.7.0.1
 */