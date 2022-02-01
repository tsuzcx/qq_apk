package com.tencent.gdtad.basics.motivebrowsing;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/basics/motivebrowsing/MotiveBrowsingData;", "", "event", "", "script", "", "leftSecond", "(ILjava/lang/String;I)V", "getEvent", "()I", "getLeftSecond", "getScript", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "qqad-impl_release"}, k=1, mv={1, 1, 16})
public final class MotiveBrowsingData
{
  public static final MotiveBrowsingData.Companion a = new MotiveBrowsingData.Companion(null);
  private final int b;
  @NotNull
  private final String c;
  private final int d;
  
  public MotiveBrowsingData(int paramInt1, @NotNull String paramString, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramString;
    this.d = paramInt2;
  }
  
  public final int a()
  {
    return this.b;
  }
  
  @NotNull
  public final String b()
  {
    return this.c;
  }
  
  public final int c()
  {
    return this.d;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof MotiveBrowsingData))
      {
        paramObject = (MotiveBrowsingData)paramObject;
        if ((this.b == paramObject.b) && (Intrinsics.areEqual(this.c, paramObject.c)) && (this.d == paramObject.d)) {}
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
    int j = this.b;
    String str = this.c;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return (j * 31 + i) * 31 + this.d;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MotiveBrowsingData(event=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", script=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", leftSecond=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivebrowsing.MotiveBrowsingData
 * JD-Core Version:    0.7.0.1
 */