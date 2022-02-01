package com.tencent.luggage.wxa.ih;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/msgsubscription/ShowInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "showType", "", "title", "", "content", "(ILjava/lang/String;Ljava/lang/String;)V", "alertContent", "getAlertContent", "()Ljava/lang/String;", "setAlertContent", "(Ljava/lang/String;)V", "alertTitle", "getAlertTitle", "setAlertTitle", "getShowType", "()I", "setShowType", "(I)V", "describeContents", "writeToParcel", "", "flags", "Companion", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 1, 16})
public final class a
  implements Parcelable
{
  @JvmField
  @NotNull
  public static final Parcelable.Creator<a> CREATOR = (Parcelable.Creator)new a.b();
  public static final a.a a = new a.a(null);
  private int b;
  @NotNull
  private String c;
  @NotNull
  private String d;
  
  public a(int paramInt, @NotNull String paramString1, @NotNull String paramString2)
  {
    this.b = paramInt;
    this.c = paramString1;
    this.d = paramString2;
  }
  
  public a(@NotNull Parcel paramParcel)
  {
    this.b = paramParcel.readInt();
    String str = paramParcel.readString();
    if (str == null) {
      str = "";
    }
    this.c = str;
    paramParcel = paramParcel.readString();
    if (paramParcel == null) {
      paramParcel = "";
    }
    this.d = paramParcel;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ih.a
 * JD-Core Version:    0.7.0.1
 */