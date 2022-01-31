package com.tencent.lbssearch.object.param;

import com.tencent.map.sdk.a.fn;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class Geo2AddressParam
  implements ParamObject
{
  private LatLng a;
  private Geo2AddressParam.PoiOptions b;
  private boolean c = false;
  
  public Geo2AddressParam() {}
  
  public Geo2AddressParam(LatLng paramLatLng)
  {
    this.a = paramLatLng;
  }
  
  public fn buildParameters()
  {
    fn localfn = new fn();
    if (this.a != null) {
      localfn.b("location", this.a.latitude + "," + this.a.longitude);
    }
    if (this.c) {}
    for (String str = "1";; str = "0")
    {
      localfn.b("get_poi", str);
      if (this.b != null) {
        localfn.b("poi_options", this.b.toString());
      }
      return localfn;
    }
  }
  
  public boolean checkParams()
  {
    return this.a != null;
  }
  
  public Geo2AddressParam coord_type(CoordTypeEnum paramCoordTypeEnum)
  {
    return this;
  }
  
  public Geo2AddressParam getPoi(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }
  
  public Geo2AddressParam get_poi(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }
  
  public Geo2AddressParam location(LatLng paramLatLng)
  {
    this.a = paramLatLng;
    return this;
  }
  
  public Geo2AddressParam setPoiOptions(Geo2AddressParam.PoiOptions paramPoiOptions)
  {
    this.b = paramPoiOptions;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.lbssearch.object.param.Geo2AddressParam
 * JD-Core Version:    0.7.0.1
 */