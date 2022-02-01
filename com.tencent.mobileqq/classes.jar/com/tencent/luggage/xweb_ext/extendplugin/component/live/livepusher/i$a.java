package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import androidx.annotation.IntRange;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$Color;", "", "colorR", "", "colorG", "colorB", "(III)V", "getColorB", "()I", "getColorG", "getColorR", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class i$a
{
  private final int a;
  private final int b;
  private final int c;
  
  public i$a(@IntRange(from=0L, to=255L) int paramInt1, @IntRange(from=0L, to=255L) int paramInt2, @IntRange(from=0L, to=255L) int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.a == paramObject.a) && (this.b == paramObject.b) && (this.c == paramObject.c)) {}
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
    return (this.a * 31 + this.b) * 31 + this.c;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Color(colorR=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", colorG=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", colorB=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.i.a
 * JD-Core Version:    0.7.0.1
 */