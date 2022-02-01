package com.tencent.mobileqq.activity.weather.webpage;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/weather/webpage/WaterfallArk;", "", "appName", "", "appMeta", "appVersion", "appView", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppMeta", "()Ljava/lang/String;", "setAppMeta", "(Ljava/lang/String;)V", "getAppName", "getAppVersion", "getAppView", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class WaterfallArk
{
  @NotNull
  private final String a;
  @NotNull
  private String b;
  @NotNull
  private final String c;
  @NotNull
  private final String d;
  
  public WaterfallArk(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
  }
  
  @NotNull
  public final String a()
  {
    return this.a;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.b = paramString;
  }
  
  @NotNull
  public final String b()
  {
    return this.b;
  }
  
  @NotNull
  public final String c()
  {
    return this.c;
  }
  
  @NotNull
  public final String d()
  {
    return this.d;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof WaterfallArk))
      {
        paramObject = (WaterfallArk)paramObject;
        if ((!Intrinsics.areEqual(this.a, paramObject.a)) || (!Intrinsics.areEqual(this.b, paramObject.b)) || (!Intrinsics.areEqual(this.c, paramObject.c)) || (!Intrinsics.areEqual(this.d, paramObject.d))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    int m = 0;
    String str = this.a;
    int i;
    int j;
    if (str != null)
    {
      i = str.hashCode();
      str = this.b;
      if (str == null) {
        break label95;
      }
      j = str.hashCode();
      label37:
      str = this.c;
      if (str == null) {
        break label100;
      }
    }
    label95:
    label100:
    for (int k = str.hashCode();; k = 0)
    {
      str = this.d;
      if (str != null) {
        m = str.hashCode();
      }
      return (k + (j + i * 31) * 31) * 31 + m;
      i = 0;
      break;
      j = 0;
      break label37;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "WaterfallArk(appName=" + this.a + ", appMeta=" + this.b + ", appVersion=" + this.c + ", appView=" + this.d + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.webpage.WaterfallArk
 * JD-Core Version:    0.7.0.1
 */