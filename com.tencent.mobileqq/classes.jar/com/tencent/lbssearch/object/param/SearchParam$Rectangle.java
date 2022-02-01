package com.tencent.lbssearch.object.param;

import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class SearchParam$Rectangle
  implements SearchParam.Boundary
{
  private LatLng a;
  private LatLng b;
  
  public SearchParam$Rectangle() {}
  
  public SearchParam$Rectangle(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    this.a = paramLatLng1;
    this.b = paramLatLng2;
  }
  
  public Rectangle point(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    this.a = paramLatLng1;
    this.b = paramLatLng2;
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("rectangle(");
    localStringBuilder.append(this.a.latitude);
    localStringBuilder.append(",");
    localStringBuilder.append(this.a.longitude);
    localStringBuilder.append(",");
    localStringBuilder.append(this.b.latitude);
    localStringBuilder.append(",");
    localStringBuilder.append(this.b.longitude);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.lbssearch.object.param.SearchParam.Rectangle
 * JD-Core Version:    0.7.0.1
 */