package com.tencent.lbssearch.object.param;

import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class SearchParam$Nearby
  implements SearchParam.Boundary
{
  private LatLng a;
  private int b;
  private boolean c = true;
  
  public SearchParam$Nearby() {}
  
  public SearchParam$Nearby(LatLng paramLatLng, int paramInt)
  {
    this.a = paramLatLng;
    this.b = paramInt;
  }
  
  public Nearby autoExtend(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }
  
  public Nearby point(LatLng paramLatLng)
  {
    this.a = paramLatLng;
    return this;
  }
  
  public Nearby r(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("nearby(").append(this.a.latitude).append(",").append(this.a.longitude).append(",").append(this.b).append(",");
    if (this.c) {}
    for (int i = 1;; i = 0) {
      return i + ")";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.lbssearch.object.param.SearchParam.Nearby
 * JD-Core Version:    0.7.0.1
 */