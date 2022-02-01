package com.tencent.biz.pubaccount.weishi_new.combo.bottomnav;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/bottomnav/WSBottomBarInfo;", "", "position", "", "barId", "", "selectedBarId", "barType", "barName", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "barIcon", "getBarIcon", "()Ljava/lang/String;", "setBarIcon", "(Ljava/lang/String;)V", "getBarId", "getBarName", "setBarName", "barStyle", "barStyle$annotations", "()V", "getBarStyle", "()I", "setBarStyle", "(I)V", "getBarType", "setBarType", "<set-?>", "", "isSelected", "()Z", "getPosition", "redNum", "getRedNum", "setRedNum", "getSelectedBarId", "setSelectedBarId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSBottomBarInfo
{
  private int a;
  @NotNull
  private String b;
  private int c;
  private final int d;
  @NotNull
  private final String e;
  @NotNull
  private String f;
  private int g;
  @NotNull
  private String h;
  
  public WSBottomBarInfo(int paramInt1, @NotNull String paramString1, @NotNull String paramString2, int paramInt2, @NotNull String paramString3)
  {
    this.d = paramInt1;
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramInt2;
    this.h = paramString3;
    this.b = "";
    this.c = 1;
  }
  
  public final void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.b = paramString;
  }
  
  public final boolean a()
  {
    return Intrinsics.areEqual(this.e, this.f);
  }
  
  public final int b()
  {
    return this.a;
  }
  
  public final void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.f = paramString;
  }
  
  @NotNull
  public final String c()
  {
    return this.b;
  }
  
  public final int d()
  {
    return this.c;
  }
  
  public final int e()
  {
    return this.d;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof WSBottomBarInfo))
      {
        paramObject = (WSBottomBarInfo)paramObject;
        if ((this.d == paramObject.d) && (Intrinsics.areEqual(this.e, paramObject.e)) && (Intrinsics.areEqual(this.f, paramObject.f)) && (this.g == paramObject.g) && (Intrinsics.areEqual(this.h, paramObject.h))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final String f()
  {
    return this.e;
  }
  
  public final int g()
  {
    return this.g;
  }
  
  @NotNull
  public final String h()
  {
    return this.h;
  }
  
  public int hashCode()
  {
    int m = this.d;
    String str = this.e;
    int k = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.f;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    int n = this.g;
    str = this.h;
    if (str != null) {
      k = str.hashCode();
    }
    return (((m * 31 + i) * 31 + j) * 31 + n) * 31 + k;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WSBottomBarInfo(position=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", barId=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", selectedBarId=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", barType=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", barName=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.bottomnav.WSBottomBarInfo
 * JD-Core Version:    0.7.0.1
 */