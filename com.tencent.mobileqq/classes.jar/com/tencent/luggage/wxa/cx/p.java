package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.nn.a;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/launch/WxaLaunchInstanceId;", "", "wxaLaunchInstanceId", "", "(Ljava/lang/String;)V", "getWxaLaunchInstanceId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class p
{
  public static final p.a a = new p.a(null);
  @NotNull
  private final String b;
  
  public p(@NotNull String paramString)
  {
    this.b = paramString;
  }
  
  @JvmStatic
  @NotNull
  public static final String a(@NotNull a parama)
  {
    return a.a(parama);
  }
  
  @NotNull
  public final String a()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof p))
      {
        paramObject = (p)paramObject;
        if (Intrinsics.areEqual(this.b, paramObject.b)) {}
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
    String str = this.b;
    if (str != null) {
      return str.hashCode();
    }
    return 0;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WxaLaunchInstanceId(wxaLaunchInstanceId=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.p
 * JD-Core Version:    0.7.0.1
 */