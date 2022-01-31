package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class YogaValue
{
  static final YogaValue UNDEFINED = new YogaValue((0.0F / 0.0F), YogaUnit.UNDEFINED);
  static final YogaValue ZERO = new YogaValue(0.0F, YogaUnit.POINT);
  public final YogaUnit unit;
  public final float value;
  
  @DoNotStrip
  YogaValue(float paramFloat, int paramInt)
  {
    this(paramFloat, YogaUnit.fromInt(paramInt));
  }
  
  public YogaValue(float paramFloat, YogaUnit paramYogaUnit)
  {
    this.value = paramFloat;
    this.unit = paramYogaUnit;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof YogaValue))
    {
      paramObject = (YogaValue)paramObject;
      bool1 = bool2;
      if (this.unit == paramObject.unit) {
        if (this.unit != YogaUnit.UNDEFINED)
        {
          bool1 = bool2;
          if (Float.compare(this.value, paramObject.value) != 0) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return Float.floatToIntBits(this.value) + this.unit.intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.facebook.yoga.YogaValue
 * JD-Core Version:    0.7.0.1
 */