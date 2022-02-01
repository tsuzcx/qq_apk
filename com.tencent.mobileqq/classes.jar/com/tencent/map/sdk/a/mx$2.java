package com.tencent.map.sdk.a;

import android.content.Context;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.InfoWindowAdapter;

final class mx$2
  implements Runnable
{
  mx$2(mx parammx) {}
  
  public final void run()
  {
    TencentMap.InfoWindowAdapter localInfoWindowAdapter;
    if (this.a.a != null) {
      localInfoWindowAdapter = this.a.a.e;
    } else {
      localInfoWindowAdapter = null;
    }
    mx localmx1 = this.a;
    Context localContext = localmx1.b.ay;
    mx localmx2 = this.a;
    localmx1.d = mr.a(localContext, localmx2, localInfoWindowAdapter, localmx2.c);
    this.a.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.mx.2
 * JD-Core Version:    0.7.0.1
 */