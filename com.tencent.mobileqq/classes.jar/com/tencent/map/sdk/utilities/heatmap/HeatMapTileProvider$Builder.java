package com.tencent.map.sdk.utilities.heatmap;

import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.Collection;

public class HeatMapTileProvider$Builder
{
  private Collection<WeightedLatLng> a;
  private int b = 40;
  private Gradient c = HeatMapTileProvider.DEFAULT_GRADIENT;
  private double d = 0.6D;
  private HeatMapTileProvider.HeatTileGenerator e;
  private HeatMapTileProvider.OnHeatMapReadyListener f;
  
  public HeatMapTileProvider build()
  {
    if (this.a != null) {
      return new HeatMapTileProvider(this, (byte)0);
    }
    throw new IllegalStateException("No input data: you must use either .data or .weightedData before building");
  }
  
  public Builder data(Collection<LatLng> paramCollection)
  {
    return weightedData(HeatMapTileProvider.a(paramCollection));
  }
  
  public Builder gradient(Gradient paramGradient)
  {
    this.c = paramGradient;
    return this;
  }
  
  public Builder opacity(double paramDouble)
  {
    if ((paramDouble >= 0.0D) && (paramDouble <= 1.0D))
    {
      this.d = paramDouble;
      return this;
    }
    throw new IllegalArgumentException("Opacity must be in range [0, 1]");
  }
  
  public Builder radius(int paramInt)
  {
    if ((paramInt >= 10) && (paramInt <= 50))
    {
      this.b = paramInt;
      return this;
    }
    throw new IllegalArgumentException("Radius not within bounds.");
  }
  
  public Builder readyListener(HeatMapTileProvider.OnHeatMapReadyListener paramOnHeatMapReadyListener)
  {
    this.f = paramOnHeatMapReadyListener;
    return this;
  }
  
  public Builder tileGenerator(HeatMapTileProvider.HeatTileGenerator paramHeatTileGenerator)
  {
    this.e = paramHeatTileGenerator;
    return this;
  }
  
  public Builder weightedData(Collection<WeightedLatLng> paramCollection)
  {
    if (!paramCollection.isEmpty())
    {
      this.a = paramCollection;
      return this;
    }
    throw new IllegalArgumentException("No input points.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.utilities.heatmap.HeatMapTileProvider.Builder
 * JD-Core Version:    0.7.0.1
 */