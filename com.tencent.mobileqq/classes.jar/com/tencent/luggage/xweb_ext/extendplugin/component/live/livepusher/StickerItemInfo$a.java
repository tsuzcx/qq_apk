package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$Position;", "", "x1", "", "y1", "x2", "y2", "(DDDD)V", "getX1", "()D", "getX2", "getY1", "getY2", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class StickerItemInfo$a
{
  private final double a;
  private final double b;
  private final double c;
  private final double d;
  
  public StickerItemInfo$a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
    this.c = paramDouble3;
    this.d = paramDouble4;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((Double.compare(this.a, paramObject.a) == 0) && (Double.compare(this.b, paramObject.b) == 0) && (Double.compare(this.c, paramObject.c) == 0) && (Double.compare(this.d, paramObject.d) == 0)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    long l = Double.doubleToLongBits(this.a);
    int i = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.b);
    int j = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.c);
    int k = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.d);
    return ((i * 31 + j) * 31 + k) * 31 + (int)(l ^ l >>> 32);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Position(x1=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", y1=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", x2=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", y2=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo.a
 * JD-Core Version:    0.7.0.1
 */