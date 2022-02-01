package android.content.res;

import android.util.DisplayMetrics;
import android.util.TypedValue;

public class XResources$DimensionReplacement
{
  private final int mUnit;
  private final float mValue;
  
  public XResources$DimensionReplacement(float paramFloat, int paramInt)
  {
    this.mValue = paramFloat;
    this.mUnit = paramInt;
  }
  
  public float getDimension(DisplayMetrics paramDisplayMetrics)
  {
    return TypedValue.applyDimension(this.mUnit, this.mValue, paramDisplayMetrics);
  }
  
  public int getDimensionPixelOffset(DisplayMetrics paramDisplayMetrics)
  {
    return (int)TypedValue.applyDimension(this.mUnit, this.mValue, paramDisplayMetrics);
  }
  
  public int getDimensionPixelSize(DisplayMetrics paramDisplayMetrics)
  {
    int i = (int)(TypedValue.applyDimension(this.mUnit, this.mValue, paramDisplayMetrics) + 0.5F);
    if (i != 0) {
      return i;
    }
    if (this.mValue == 0.0F) {
      return 0;
    }
    if (this.mValue > 0.0F) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.content.res.XResources.DimensionReplacement
 * JD-Core Version:    0.7.0.1
 */