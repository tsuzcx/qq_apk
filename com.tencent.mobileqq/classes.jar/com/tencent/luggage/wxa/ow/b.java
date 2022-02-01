package com.tencent.luggage.wxa.ow;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/WxaShortLinkInfo;", "Landroid/os/Parcelable;", "appId", "", "pageTitle", "path", "version", "", "versionType", "nickName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getNickName", "getPageTitle", "getPath", "getVersion", "()I", "getVersionType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
@Parcelize
public final class b
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new b.b();
  public static final b.a a = new b.a(null);
  @NotNull
  private final String b;
  @NotNull
  private final String c;
  @NotNull
  private final String d;
  private final int e;
  private final int f;
  @NotNull
  private final String g;
  
  public b(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, int paramInt1, int paramInt2, @NotNull String paramString4)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = paramString4;
  }
  
  @NotNull
  public final String a()
  {
    return this.b;
  }
  
  @NotNull
  public final String b()
  {
    return this.d;
  }
  
  public final int c()
  {
    return this.e;
  }
  
  public final int d()
  {
    return this.f;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @NotNull
  public final String e()
  {
    return this.g;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c)) && (Intrinsics.areEqual(this.d, paramObject.d)) && (this.e == paramObject.e) && (this.f == paramObject.f) && (Intrinsics.areEqual(this.g, paramObject.g))) {}
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
    int m = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.c;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.d;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    int n = this.e;
    int i1 = this.f;
    str = this.g;
    if (str != null) {
      m = str.hashCode();
    }
    return ((((i * 31 + j) * 31 + k) * 31 + n) * 31 + i1) * 31 + m;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WxaShortLinkInfo(\n");
    localStringBuilder.append("appId='");
    localStringBuilder.append(this.b);
    localStringBuilder.append("'\n");
    localStringBuilder.append("pageTitle='");
    localStringBuilder.append(this.c);
    localStringBuilder.append("'\n");
    localStringBuilder.append("path='");
    localStringBuilder.append(this.d);
    localStringBuilder.append("'\n");
    localStringBuilder.append("version=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\n');
    localStringBuilder.append("versionType=");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\n');
    localStringBuilder.append("nickName=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeString(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ow.b
 * JD-Core Version:    0.7.0.1
 */