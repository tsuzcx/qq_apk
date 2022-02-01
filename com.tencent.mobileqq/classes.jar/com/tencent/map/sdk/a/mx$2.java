package com.tencent.map.sdk.a;

import com.tencent.tencentmap.mapsdk.maps.TencentMap.InfoWindowAdapter;

final class mx$2
  implements Runnable
{
  mx$2(mx parammx) {}
  
  public final void run()
  {
    TencentMap.InfoWindowAdapter localInfoWindowAdapter = null;
    if (this.a.a != null) {
      localInfoWindowAdapter = this.a.a.e;
    }
    this.a.d = mr.a(this.a.b.ay, this.a, localInfoWindowAdapter, this.a.c);
    this.a.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.mx.2
 * JD-Core Version:    0.7.0.1
 */