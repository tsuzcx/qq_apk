package com.tencent.luggage.wxa.jj;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/config/HalfScreenConfig$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig;", "data-model_release"}, k=1, mv={1, 1, 16})
public final class p$e
  implements Parcelable.Creator<p>
{
  @NotNull
  public p a(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    return new p(paramParcel);
  }
  
  @NotNull
  public p[] a(int paramInt)
  {
    return new p[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jj.p.e
 * JD-Core Version:    0.7.0.1
 */