package com.tencent.lbssearch.object.param;

import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class DrivingParam$Travel$Point
{
  private LatLng a;
  private int b = -1;
  private int c = -1;
  private int d = -1;
  private int e = -1;
  private int f = 0;
  
  public DrivingParam$Travel$Point(LatLng paramLatLng)
  {
    this.a = paramLatLng;
  }
  
  public Point setAccuracy(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public Point setDirectionOfCar(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public Point setDirectionOfDevice(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public Point setSpeed(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  public Point setTime(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.a != null)
    {
      localStringBuilder.append(this.a.latitude).append(",");
      localStringBuilder.append(this.a.longitude).append(",");
    }
    localStringBuilder.append(this.b).append(",");
    localStringBuilder.append(this.c).append(",");
    localStringBuilder.append(this.d).append(",");
    localStringBuilder.append(this.e).append(",");
    localStringBuilder.append(this.f);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.lbssearch.object.param.DrivingParam.Travel.Point
 * JD-Core Version:    0.7.0.1
 */