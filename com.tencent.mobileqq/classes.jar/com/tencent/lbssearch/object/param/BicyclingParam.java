package com.tencent.lbssearch.object.param;

import com.tencent.lbssearch.object.result.BicyclingResultObject;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class BicyclingParam
  extends RoutePlanningParam
{
  public BicyclingParam() {}
  
  public BicyclingParam(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    super(paramLatLng1, paramLatLng2);
  }
  
  public Class<?> getResultClass()
  {
    return BicyclingResultObject.class;
  }
  
  public String getUrl()
  {
    return "https://apis.map.qq.com/ws/direction/v1/bicycling";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.lbssearch.object.param.BicyclingParam
 * JD-Core Version:    0.7.0.1
 */