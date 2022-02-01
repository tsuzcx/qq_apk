package com.tencent.biz.qqstory.album.tools;

import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.mobileqq.pb.PBInt32Field;

public class GeoHashUtils$Gps
{
  private double a;
  private double b;
  
  public GeoHashUtils$Gps(double paramDouble1, double paramDouble2)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  public double a()
  {
    return this.a;
  }
  
  public double b()
  {
    return this.b;
  }
  
  public qqstory_struct.GpsMsg c()
  {
    qqstory_struct.GpsMsg localGpsMsg = new qqstory_struct.GpsMsg();
    localGpsMsg.setHasFlag(true);
    localGpsMsg.lat.set((int)(a() * 1000000.0D));
    localGpsMsg.lng.set((int)(b() * 1000000.0D));
    return localGpsMsg;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Gps)) {
      return false;
    }
    paramObject = (Gps)paramObject;
    return (paramObject.a == this.a) && (paramObject.b == this.b);
  }
  
  public int hashCode()
  {
    return "Gps".hashCode() + (int)(this.a * 1000000.0D) + (int)(this.b * 1000000.0D);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Gps{lat=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", lng=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.tools.GeoHashUtils.Gps
 * JD-Core Version:    0.7.0.1
 */