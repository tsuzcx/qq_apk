package com.tencent.luggage.wxa.ih;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/msgsubscription/ShowInfo$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/ShowInfo;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/ShowInfo;", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 1, 16})
public final class a$b
  implements Parcelable.Creator<a>
{
  @NotNull
  public a a(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    return new a(paramParcel);
  }
  
  @NotNull
  public a[] a(int paramInt)
  {
    return new a[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ih.a.b
 * JD-Core Version:    0.7.0.1
 */