package com.tencent.ditto.area;

public class MeasureCacheable$CanvasMeasureCacheKey
{
  public Integer cacheKey;
  public int keyHeightMeasureSpec;
  public int keyWidthMeasureSpec;
  
  public MeasureCacheable$CanvasMeasureCacheKey(Integer paramInteger, int paramInt1, int paramInt2)
  {
    this.cacheKey = paramInteger;
    this.keyWidthMeasureSpec = paramInt1;
    this.keyHeightMeasureSpec = paramInt2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof CanvasMeasureCacheKey)) {
        return false;
      }
      paramObject = (CanvasMeasureCacheKey)paramObject;
    } while ((this.keyWidthMeasureSpec == paramObject.keyWidthMeasureSpec) && (this.keyHeightMeasureSpec == paramObject.keyHeightMeasureSpec) && (this.cacheKey != null) && (this.cacheKey.equals(paramObject.cacheKey)));
    return false;
  }
  
  public int hashCode()
  {
    int i = this.cacheKey.hashCode();
    i += i * 17 + this.keyWidthMeasureSpec;
    return i + (i * 17 + this.keyHeightMeasureSpec);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ditto.area.MeasureCacheable.CanvasMeasureCacheKey
 * JD-Core Version:    0.7.0.1
 */