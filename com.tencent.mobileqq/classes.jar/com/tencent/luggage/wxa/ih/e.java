package com.tencent.luggage.wxa.ih;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/msgsubscription/WordingInfo;", "Landroid/os/Parcelable;", "PopupTitle", "", "PopupAllow", "PopupCancel", "PopupBottom", "ExampleTitle", "AlwaysReject", "PopupDesc", "SendWording", "MultiRemind", "WxaMultiRemind", "SendBelowMsg", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAlwaysReject", "()Ljava/lang/String;", "getExampleTitle", "getMultiRemind", "getPopupAllow", "getPopupBottom", "getPopupCancel", "getPopupDesc", "getPopupTitle", "getSendBelowMsg", "getSendWording", "getWxaMultiRemind", "describeContents", "", "toString", "writeToParcel", "", "flags", "Companion", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 1, 16})
public final class e
  implements Parcelable
{
  @JvmField
  @NotNull
  public static final Parcelable.Creator<e> CREATOR = (Parcelable.Creator)new e.b();
  public static final e.a a = new e.a(null);
  @NotNull
  private final String b;
  @NotNull
  private final String c;
  @NotNull
  private final String d;
  @NotNull
  private final String e;
  @NotNull
  private final String f;
  @NotNull
  private final String g;
  @NotNull
  private final String h;
  @NotNull
  private final String i;
  @NotNull
  private final String j;
  @NotNull
  private final String k;
  @NotNull
  private final String l;
  
  public e(@NotNull Parcel paramParcel)
  {
    String str = paramParcel.readString();
    if (str == null) {
      str = "";
    }
    this.b = str;
    str = paramParcel.readString();
    if (str == null) {
      str = "";
    }
    this.c = str;
    str = paramParcel.readString();
    if (str == null) {
      str = "";
    }
    this.d = str;
    str = paramParcel.readString();
    if (str == null) {
      str = "";
    }
    this.e = str;
    str = paramParcel.readString();
    if (str == null) {
      str = "";
    }
    this.f = str;
    str = paramParcel.readString();
    if (str == null) {
      str = "";
    }
    this.g = str;
    str = paramParcel.readString();
    if (str == null) {
      str = "";
    }
    this.h = str;
    str = paramParcel.readString();
    if (str == null) {
      str = "";
    }
    this.i = str;
    str = paramParcel.readString();
    if (str == null) {
      str = "";
    }
    this.j = str;
    str = paramParcel.readString();
    if (str == null) {
      str = "";
    }
    this.k = str;
    paramParcel = paramParcel.readString();
    if (paramParcel == null) {
      paramParcel = "";
    }
    this.l = paramParcel;
  }
  
  public e(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, @NotNull String paramString6, @NotNull String paramString7, @NotNull String paramString8, @NotNull String paramString9, @NotNull String paramString10, @NotNull String paramString11)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramString5;
    this.g = paramString6;
    this.h = paramString7;
    this.i = paramString8;
    this.j = paramString9;
    this.k = paramString10;
    this.l = paramString11;
  }
  
  @NotNull
  public final String a()
  {
    return this.b;
  }
  
  @NotNull
  public final String b()
  {
    return this.c;
  }
  
  @NotNull
  public final String c()
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
  
  @NotNull
  public final String e()
  {
    return this.f;
  }
  
  @NotNull
  public final String f()
  {
    return this.g;
  }
  
  @NotNull
  public final String g()
  {
    return this.h;
  }
  
  @NotNull
  public final String h()
  {
    return this.i;
  }
  
  @NotNull
  public final String i()
  {
    return this.k;
  }
  
  @NotNull
  public final String j()
  {
    return this.l;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WordingInfo(PopupTitle='");
    localStringBuilder.append(this.b);
    localStringBuilder.append("', PopupAllow='");
    localStringBuilder.append(this.c);
    localStringBuilder.append("', PopupCancel='");
    localStringBuilder.append(this.d);
    localStringBuilder.append("', PopupBottom='");
    localStringBuilder.append(this.e);
    localStringBuilder.append("', ExampleTitle='");
    localStringBuilder.append(this.f);
    localStringBuilder.append("', AlwaysReject='");
    localStringBuilder.append(this.g);
    localStringBuilder.append("', PopupDesc='");
    localStringBuilder.append(this.h);
    localStringBuilder.append("', SendWording='");
    localStringBuilder.append(this.i);
    localStringBuilder.append("', MultiRemind='");
    localStringBuilder.append(this.j);
    localStringBuilder.append("', WxaMultiRemind='");
    localStringBuilder.append(this.k);
    localStringBuilder.append("')");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ih.e
 * JD-Core Version:    0.7.0.1
 */