package com.tencent.luggage.scanner.qbar;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/scanner/qbar/LuggageQBarPoint$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/luggage/scanner/qbar/LuggageQBarPoint;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/luggage/scanner/qbar/LuggageQBarPoint;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class c$a
  implements Parcelable.Creator<c>
{
  @NotNull
  public c a(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    return new c(paramParcel);
  }
  
  @NotNull
  public c[] a(int paramInt)
  {
    return new c[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.qbar.c.a
 * JD-Core Version:    0.7.0.1
 */