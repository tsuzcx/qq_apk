package com.tencent.map.sdk.a;

import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.sdk.engine.jni.JNI;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions.Text;

public final class iq
{
  private int a;
  private pf b;
  
  public iq(pf parampf, GeoPoint[] paramArrayOfGeoPoint, PolylineOptions.Text paramText)
  {
    this.b = parampf;
    parampf = this.b;
    if (parampf == null) {
      return;
    }
    this.a = parampf.a(paramArrayOfGeoPoint, paramText);
  }
  
  public final void a()
  {
    pf localpf = this.b;
    if (localpf != null)
    {
      int i = this.a;
      if (i <= 0) {
        return;
      }
      try
      {
        localpf.y();
        long l = localpf.b;
        if (l == 0L) {
          return;
        }
        localpf.a.removeLineText(localpf.b, i);
        return;
      }
      finally
      {
        localpf.z();
      }
    }
  }
  
  public final void a(PolylineOptions.Text paramText)
  {
    pf localpf = this.b;
    if (localpf != null)
    {
      int i = this.a;
      if (i <= 0) {
        return;
      }
      try
      {
        localpf.y();
        long l = localpf.b;
        if (l == 0L) {
          return;
        }
        localpf.a.setLineTextStyle(localpf.b, i, paramText);
        return;
      }
      finally
      {
        localpf.z();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.iq
 * JD-Core Version:    0.7.0.1
 */