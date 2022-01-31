package com.tencent.mapsdk.raster.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class PolylineOptions
{
  private float arrowGap = 90.0F;
  private String arrowTexture = "";
  private int color = -16777216;
  private int edgeColor = -983041;
  private float edgeWidth = 0.0F;
  private boolean isDottedLine = false;
  private boolean isGeodesic = false;
  private boolean isVisible = true;
  private final List<LatLng> points = new ArrayList();
  private float width = 10.0F;
  private float zIndex = 0.0F;
  
  public final PolylineOptions add(LatLng paramLatLng)
  {
    this.points.add(paramLatLng);
    return this;
  }
  
  public final PolylineOptions add(LatLng... paramVarArgs)
  {
    this.points.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public final PolylineOptions addAll(Iterable<LatLng> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      LatLng localLatLng = (LatLng)paramIterable.next();
      this.points.add(localLatLng);
    }
    return this;
  }
  
  public final PolylineOptions arrowGap(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      this.arrowGap = paramFloat;
    }
    return this;
  }
  
  public final PolylineOptions arrowTexture(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      this.arrowTexture = paramString;
    }
    return this;
  }
  
  public final PolylineOptions color(int paramInt)
  {
    this.color = paramInt;
    return this;
  }
  
  public final PolylineOptions edgeColor(int paramInt)
  {
    this.edgeColor = paramInt;
    return this;
  }
  
  public final PolylineOptions edgeWidth(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      this.edgeWidth = paramFloat;
    }
    return this;
  }
  
  public final PolylineOptions geodesic(boolean paramBoolean)
  {
    this.isGeodesic = paramBoolean;
    return this;
  }
  
  public final float getArrowGap()
  {
    return this.arrowGap;
  }
  
  public final String getArrowTexture()
  {
    return this.arrowTexture;
  }
  
  public final int getColor()
  {
    return this.color;
  }
  
  public final int getEdgeColor()
  {
    return this.edgeColor;
  }
  
  public final float getEdgeWidth()
  {
    return this.edgeWidth;
  }
  
  public final List<LatLng> getPoints()
  {
    return this.points;
  }
  
  public final float getWidth()
  {
    return this.width;
  }
  
  public final float getZIndex()
  {
    return this.zIndex;
  }
  
  public final boolean isDottedLine()
  {
    return this.isDottedLine;
  }
  
  public final boolean isGeodesic()
  {
    return this.isGeodesic;
  }
  
  public final boolean isVisible()
  {
    return this.isVisible;
  }
  
  public final PolylineOptions setDottedLine(boolean paramBoolean)
  {
    this.isDottedLine = paramBoolean;
    return this;
  }
  
  public final PolylineOptions visible(boolean paramBoolean)
  {
    this.isVisible = paramBoolean;
    return this;
  }
  
  public final PolylineOptions width(float paramFloat)
  {
    this.width = paramFloat;
    return this;
  }
  
  public final PolylineOptions zIndex(float paramFloat)
  {
    this.zIndex = paramFloat;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.PolylineOptions
 * JD-Core Version:    0.7.0.1
 */