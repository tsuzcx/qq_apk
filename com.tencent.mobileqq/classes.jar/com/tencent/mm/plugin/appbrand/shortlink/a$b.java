package com.tencent.mm.plugin.appbrand.shortlink;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/shortlink/AbsWxaShortLinkLauncher$WxaShortLinkLaunchParams;", "Landroid/os/Parcelable;", "appId", "", "path", "version", "", "versionType", "shortLink", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getPath", "getShortLink", "getVersion", "()I", "getVersionType", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
@Parcelize
public final class a$b
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new a.b.a();
  @NotNull
  private final String a;
  @NotNull
  private final String b;
  private final int c;
  private final int d;
  @NotNull
  private final String e;
  
  public a$b(@NotNull String paramString1, @NotNull String paramString2, int paramInt1, int paramInt2, @NotNull String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramString3;
  }
  
  @NotNull
  public final String a()
  {
    return this.a;
  }
  
  @NotNull
  public final String b()
  {
    return this.b;
  }
  
  public final int c()
  {
    return this.d;
  }
  
  @NotNull
  public final String d()
  {
    return this.e;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b)) && (this.c == paramObject.c) && (this.d == paramObject.d) && (Intrinsics.areEqual(this.e, paramObject.e))) {}
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
    String str = this.a;
    int k = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.b;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    int m = this.c;
    int n = this.d;
    str = this.e;
    if (str != null) {
      k = str.hashCode();
    }
    return (((i * 31 + j) * 31 + m) * 31 + n) * 31 + k;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WxaShortLinkLaunchParams(appId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", path=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", version=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", versionType=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", shortLink=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeString(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.shortlink.a.b
 * JD-Core Version:    0.7.0.1
 */