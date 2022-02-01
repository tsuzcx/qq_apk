package com.tencent.luggage.wxa.iu;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/RemoveDataClass;", "Landroid/os/Parcelable;", "appID", "", "processIndex", "", "(Ljava/lang/String;I)V", "getAppID", "()Ljava/lang/String;", "getProcessIndex", "()I", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
@Parcelize
public final class u
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new u.a();
  @NotNull
  private final String a;
  private final int b;
  
  public u(@NotNull String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }
  
  @NotNull
  public final String a()
  {
    return this.a;
  }
  
  public final int b()
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
      if ((paramObject instanceof u))
      {
        paramObject = (u)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (this.b == paramObject.b)) {}
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
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return i * 31 + this.b;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RemoveDataClass(appID=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", processIndex=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.u
 * JD-Core Version:    0.7.0.1
 */