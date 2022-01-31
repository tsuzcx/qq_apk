package com.tencent.map.lib.basemap.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GeoPoint
  implements Parcelable
{
  public static final Parcelable.Creator<GeoPoint> CREATOR = new GeoPoint.1();
  private int mLatitudeE6;
  private int mLongitudeE6;
  
  public GeoPoint()
  {
    this.mLatitudeE6 = -85000001;
    this.mLongitudeE6 = -180000001;
  }
  
  public GeoPoint(int paramInt1, int paramInt2)
  {
    this.mLatitudeE6 = paramInt1;
    this.mLongitudeE6 = paramInt2;
  }
  
  private GeoPoint(Parcel paramParcel)
  {
    this.mLatitudeE6 = paramParcel.readInt();
    this.mLongitudeE6 = paramParcel.readInt();
  }
  
  public GeoPoint(GeoPoint paramGeoPoint)
  {
    this();
    this.mLatitudeE6 = paramGeoPoint.mLatitudeE6;
    this.mLongitudeE6 = paramGeoPoint.mLongitudeE6;
  }
  
  public static GeoPoint formString(String paramString)
  {
    GeoPoint localGeoPoint = new GeoPoint();
    if (paramString != null) {}
    try
    {
      paramString = paramString.split(",");
      if ((paramString != null) && (paramString.length == 2))
      {
        localGeoPoint.mLatitudeE6 = Integer.parseInt(paramString[0]);
        localGeoPoint.mLongitudeE6 = Integer.parseInt(paramString[1]);
      }
      return localGeoPoint;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return localGeoPoint;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof GeoPoint))
    {
      paramObject = (GeoPoint)paramObject;
      bool1 = bool2;
      if (this.mLatitudeE6 == paramObject.mLatitudeE6)
      {
        bool1 = bool2;
        if (this.mLongitudeE6 == paramObject.mLongitudeE6) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int getLatitudeE6()
  {
    return this.mLatitudeE6;
  }
  
  public int getLongitudeE6()
  {
    return this.mLongitudeE6;
  }
  
  public void setGeoPoint(GeoPoint paramGeoPoint)
  {
    this.mLatitudeE6 = paramGeoPoint.getLatitudeE6();
    this.mLongitudeE6 = paramGeoPoint.getLongitudeE6();
  }
  
  public void setLatitudeE6(int paramInt)
  {
    this.mLatitudeE6 = paramInt;
  }
  
  public void setLongitudeE6(int paramInt)
  {
    this.mLongitudeE6 = paramInt;
  }
  
  public String toString()
  {
    return this.mLatitudeE6 + "," + this.mLongitudeE6;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mLatitudeE6);
    paramParcel.writeInt(this.mLongitudeE6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.lib.basemap.data.GeoPoint
 * JD-Core Version:    0.7.0.1
 */