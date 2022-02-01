package com.tencent.luggage.wxa.dc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/ITdiTransferAlertService$AlertParams;", "Landroid/os/Parcelable;", "alertTitle", "", "alertMsg", "(Ljava/lang/String;Ljava/lang/String;)V", "getAlertMsg", "()Ljava/lang/String;", "setAlertMsg", "(Ljava/lang/String;)V", "getAlertTitle", "setAlertTitle", "checkIsLegal", "", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
@Parcelize
public final class h$a
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new h.a.a();
  @Nullable
  private String a;
  @Nullable
  private String b;
  
  public h$a()
  {
    this(null, null, 3, null);
  }
  
  public h$a(@Nullable String paramString1, @Nullable String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public final boolean a()
  {
    CharSequence localCharSequence = (CharSequence)this.b;
    int i;
    if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    return i ^ 0x1;
  }
  
  @Nullable
  public final String b()
  {
    return this.a;
  }
  
  @Nullable
  public final String c()
  {
    return this.b;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b))) {}
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
    int j = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.b;
    if (str != null) {
      j = str.hashCode();
    }
    return i * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AlertParams(alertTitle=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", alertMsg=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.h.a
 * JD-Core Version:    0.7.0.1
 */