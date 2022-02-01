package com.tencent.lbssearch.object.param;

import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.map.sdk.a.fn;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public abstract class RoutePlanningParam
  implements ParamObject
{
  private LatLng a;
  private LatLng b;
  
  public RoutePlanningParam() {}
  
  public RoutePlanningParam(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    this.a = paramLatLng1;
    this.b = paramLatLng2;
  }
  
  protected static String a(LatLng paramLatLng)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLatLng.latitude);
    localStringBuilder.append(",");
    localStringBuilder.append(paramLatLng.longitude);
    return localStringBuilder.toString();
  }
  
  public fn buildParameters()
  {
    fn localfn = new fn();
    localfn.a("from", a(this.a));
    localfn.a("to", a(this.b));
    return localfn;
  }
  
  public boolean checkParams()
  {
    return (this.a != null) && (this.b != null);
  }
  
  public RoutePlanningParam from(LatLng paramLatLng)
  {
    this.a = paramLatLng;
    return this;
  }
  
  public abstract <T extends BaseObject> Class<T> getResultClass();
  
  public abstract String getUrl();
  
  public RoutePlanningParam to(LatLng paramLatLng)
  {
    this.b = paramLatLng;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.lbssearch.object.param.RoutePlanningParam
 * JD-Core Version:    0.7.0.1
 */