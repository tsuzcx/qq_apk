package com.tencent.mm.plugin.appbrand.ui;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider$Padding;", "", "left", "", "top", "right", "bottom", "(IIII)V", "getBottom", "()I", "getLeft", "getRight", "getTop", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public final class h$a
{
  private final int a;
  private final int b;
  private final int c;
  private final int d;
  
  public h$a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }
  
  public final int a()
  {
    return this.a;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final int c()
  {
    return this.c;
  }
  
  public final int d()
  {
    return this.d;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.a == paramObject.a) && (this.b == paramObject.b) && (this.c == paramObject.c) && (this.d == paramObject.d)) {}
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
    return ((this.a * 31 + this.b) * 31 + this.c) * 31 + this.d;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Padding(left=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", top=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", right=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", bottom=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.h.a
 * JD-Core Version:    0.7.0.1
 */