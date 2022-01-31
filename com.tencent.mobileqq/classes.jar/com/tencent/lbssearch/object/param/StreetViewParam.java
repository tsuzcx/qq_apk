package com.tencent.lbssearch.object.param;

import android.text.TextUtils;
import com.tencent.map.sdk.a.fn;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class StreetViewParam
  implements ParamObject
{
  private String a;
  private LatLng b;
  private String c;
  private int d;
  
  public fn buildParameters()
  {
    fn localfn = new fn();
    if (this.b != null) {
      localfn.b("location", this.b.latitude + "," + this.b.longitude);
    }
    if (!TextUtils.isEmpty(this.c)) {
      localfn.b("poi", this.c);
    }
    if (!TextUtils.isEmpty(this.a)) {
      localfn.b("id", this.a);
    }
    if (this.d > 0) {
      localfn.b("radius", String.valueOf(this.d));
    }
    return localfn;
  }
  
  public boolean checkParams()
  {
    return (!TextUtils.isEmpty(this.a)) || (this.b != null) || (!TextUtils.isEmpty(this.c));
  }
  
  public StreetViewParam id(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public StreetViewParam location(LatLng paramLatLng)
  {
    this.b = paramLatLng;
    return this;
  }
  
  public StreetViewParam poi(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public StreetViewParam radius(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.lbssearch.object.param.StreetViewParam
 * JD-Core Version:    0.7.0.1
 */