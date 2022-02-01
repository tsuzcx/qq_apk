package com.tencent.luggage.wxa.nl;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION$SPECIFIED;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION;", "version", "", "(I)V", "getVersion", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toInt", "toLong", "", "toString", "", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class j$g$b
  extends j.g
{
  private final int a;
  
  public j$g$b(int paramInt)
  {
    super(null);
    this.a = paramInt;
  }
  
  public final int a()
  {
    return this.a;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if (this.a == paramObject.a) {}
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
    return this.a;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VERSION(");
    localStringBuilder.append(this.a);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.j.g.b
 * JD-Core Version:    0.7.0.1
 */