package com.tencent.mapsdk.raster.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class PolygonOptions
{
  private int fillColor = -16777216;
  private boolean isVisible = true;
  private final List<LatLng> points = new ArrayList();
  private int strokeColor = -16777216;
  private float strokeWidth = 10.0F;
  private float zIndex = 0.0F;
  
  public final PolygonOptions add(LatLng paramLatLng)
  {
    this.points.add(paramLatLng);
    return this;
  }
  
  public final PolygonOptions add(LatLng... paramVarArgs)
  {
    this.points.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public final PolygonOptions addAll(Iterable<LatLng> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      LatLng localLatLng = (LatLng)paramIterable.next();
      this.points.add(localLatLng);
    }
    return this;
  }
  
  public final PolygonOptions fillColor(int paramInt)
  {
    this.fillColor = paramInt;
    return this;
  }
  
  public final int getFillColor()
  {
    return this.fillColor;
  }
  
  public final List<LatLng> getPoints()
  {
    return this.points;
  }
  
  public final int getStrokeColor()
  {
    return this.strokeColor;
  }
  
  public final float getStrokeWidth()
  {
    return this.strokeWidth;
  }
  
  public final float getZIndex()
  {
    return this.zIndex;
  }
  
  public final boolean isVisible()
  {
    return this.isVisible;
  }
  
  public final PolygonOptions strokeColor(int paramInt)
  {
    this.strokeColor = paramInt;
    return this;
  }
  
  public final PolygonOptions strokeWidth(float paramFloat)
  {
    this.strokeWidth = paramFloat;
    return this;
  }
  
  public final PolygonOptions visible(boolean paramBoolean)
  {
    this.isVisible = paramBoolean;
    return this;
  }
  
  public final PolygonOptions zIndex(float paramFloat)
  {
    this.zIndex = paramFloat;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.PolygonOptions
 * JD-Core Version:    0.7.0.1
 */