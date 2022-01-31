package com.tencent.mapsdk.raster.model;

import com.tencent.mapsdk.rastercore.f.b;
import java.util.Iterator;

public class LatLngBounds
{
  private int mVersionCode;
  private LatLng northeast;
  private LatLng southwest;
  
  LatLngBounds(int paramInt, LatLng paramLatLng1, LatLng paramLatLng2)
  {
    paramLatLng1 = new Builder().include(paramLatLng1).include(paramLatLng2);
    this.southwest = new LatLng(paramLatLng1.mSouth, paramLatLng1.mWest);
    this.northeast = new LatLng(paramLatLng1.mNorth, paramLatLng1.mEast);
    this.mVersionCode = paramInt;
  }
  
  public LatLngBounds(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    this(1, paramLatLng1, paramLatLng2);
  }
  
  public static Builder builder()
  {
    return new Builder();
  }
  
  private boolean containsLatitude(double paramDouble)
  {
    return (this.southwest.getLatitude() <= paramDouble) && (paramDouble <= this.northeast.getLatitude());
  }
  
  private boolean containsLongitude(double paramDouble)
  {
    if (this.southwest.getLongitude() <= this.northeast.getLongitude()) {
      if ((this.southwest.getLongitude() > paramDouble) || (paramDouble > this.northeast.getLongitude())) {}
    }
    while ((this.southwest.getLongitude() <= paramDouble) || (paramDouble <= this.northeast.getLongitude()))
    {
      return true;
      return false;
    }
    return false;
  }
  
  private boolean intersect(LatLngBounds paramLatLngBounds)
  {
    if ((paramLatLngBounds == null) || (paramLatLngBounds.northeast == null) || (paramLatLngBounds.southwest == null) || (this.northeast == null) || (this.southwest == null)) {}
    double d1;
    double d2;
    double d3;
    double d4;
    double d5;
    double d6;
    double d7;
    double d8;
    double d9;
    double d10;
    double d11;
    double d12;
    double d13;
    double d14;
    double d15;
    double d16;
    do
    {
      return false;
      d1 = paramLatLngBounds.northeast.getLongitude();
      d2 = paramLatLngBounds.southwest.getLongitude();
      d3 = this.northeast.getLongitude();
      d4 = this.southwest.getLongitude();
      d5 = this.northeast.getLongitude();
      d6 = this.southwest.getLongitude();
      d7 = paramLatLngBounds.northeast.getLongitude();
      d8 = paramLatLngBounds.southwest.getLongitude();
      d9 = paramLatLngBounds.northeast.getLatitude();
      d10 = paramLatLngBounds.southwest.getLatitude();
      d11 = this.northeast.getLatitude();
      d12 = this.southwest.getLatitude();
      d13 = this.northeast.getLatitude();
      d14 = this.southwest.getLatitude();
      d15 = paramLatLngBounds.northeast.getLatitude();
      d16 = paramLatLngBounds.southwest.getLatitude();
    } while ((Math.abs(d1 + d2 - d3 - d4) >= d5 - d6 + d7 - d8) || (Math.abs(d9 + d10 - d11 - d12) >= d13 - d14 + d15 - d16));
    return true;
  }
  
  private static double longitudeDistanceHeadingEast(double paramDouble1, double paramDouble2)
  {
    return (paramDouble2 - paramDouble1 + 360.0D) % 360.0D;
  }
  
  private static double longitudeDistanceHeadingWest(double paramDouble1, double paramDouble2)
  {
    return (paramDouble1 - paramDouble2 + 360.0D) % 360.0D;
  }
  
  public boolean contains(LatLng paramLatLng)
  {
    return (containsLatitude(paramLatLng.getLatitude())) && (containsLongitude(paramLatLng.getLongitude()));
  }
  
  public boolean contains(LatLngBounds paramLatLngBounds)
  {
    if (paramLatLngBounds == null) {}
    while ((!contains(paramLatLngBounds.southwest)) || (!contains(paramLatLngBounds.northeast))) {
      return false;
    }
    return true;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof LatLngBounds)) {
        return false;
      }
      paramObject = (LatLngBounds)paramObject;
    } while ((this.southwest.equals(paramObject.southwest)) && (this.northeast.equals(paramObject.northeast)));
    return false;
  }
  
  public LatLng getNortheast()
  {
    return this.northeast;
  }
  
  public LatLng getSouthwest()
  {
    return this.southwest;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public final int hashCode()
  {
    return b.a(new Object[] { this.southwest, this.northeast });
  }
  
  public LatLngBounds including(LatLng paramLatLng)
  {
    double d4 = Math.min(this.southwest.getLatitude(), paramLatLng.getLatitude());
    double d5 = Math.max(this.northeast.getLatitude(), paramLatLng.getLatitude());
    double d2 = this.northeast.getLongitude();
    double d3 = this.southwest.getLongitude();
    double d1 = paramLatLng.getLongitude();
    if (!containsLongitude(d1)) {
      if (longitudeDistanceHeadingWest(d3, d1) >= longitudeDistanceHeadingEast(d2, d1)) {}
    }
    for (;;)
    {
      return new LatLngBounds(new LatLng(d4, d1), new LatLng(d5, d2));
      d2 = d1;
      d1 = d3;
      continue;
      d1 = d3;
    }
  }
  
  public boolean intersects(LatLngBounds paramLatLngBounds)
  {
    if (paramLatLngBounds == null) {}
    while ((!intersect(paramLatLngBounds)) && (!paramLatLngBounds.intersect(this))) {
      return false;
    }
    return true;
  }
  
  public final String toString()
  {
    return b.a(new String[] { b.a("southwest", this.southwest), b.a("northeast", this.northeast) });
  }
  
  public static final class Builder
  {
    private double mEast = (0.0D / 0.0D);
    private double mNorth = (-1.0D / 0.0D);
    private double mSouth = (1.0D / 0.0D);
    private double mWest = (0.0D / 0.0D);
    
    private boolean containsLongitude(double paramDouble)
    {
      if (this.mWest <= this.mEast) {
        if ((this.mWest > paramDouble) || (paramDouble > this.mEast)) {}
      }
      while ((this.mWest <= paramDouble) || (paramDouble <= this.mEast))
      {
        return true;
        return false;
      }
      return false;
    }
    
    public final LatLngBounds build()
    {
      return new LatLngBounds(new LatLng(this.mSouth, this.mWest), new LatLng(this.mNorth, this.mEast));
    }
    
    public final Builder include(LatLng paramLatLng)
    {
      this.mSouth = Math.min(this.mSouth, paramLatLng.getLatitude());
      this.mNorth = Math.max(this.mNorth, paramLatLng.getLatitude());
      double d = paramLatLng.getLongitude();
      if (Double.isNaN(this.mWest)) {
        this.mWest = d;
      }
      do
      {
        this.mEast = d;
        do
        {
          return this;
        } while (containsLongitude(d));
      } while (LatLngBounds.longitudeDistanceHeadingWest(this.mWest, d) >= LatLngBounds.longitudeDistanceHeadingEast(this.mEast, d));
      this.mWest = d;
      return this;
    }
    
    public final Builder include(Iterable<LatLng> paramIterable)
    {
      if (paramIterable != null)
      {
        paramIterable = paramIterable.iterator();
        while (paramIterable.hasNext()) {
          include((LatLng)paramIterable.next());
        }
      }
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.LatLngBounds
 * JD-Core Version:    0.7.0.1
 */