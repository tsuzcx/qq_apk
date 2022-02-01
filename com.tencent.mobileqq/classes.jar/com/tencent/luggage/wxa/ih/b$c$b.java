package com.tencent.luggage.wxa.ih;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData;", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 1, 16})
public final class b$c$b
  implements Parcelable.Creator<b.c>
{
  @NotNull
  public b.c a(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    return new b.c(paramParcel);
  }
  
  @NotNull
  public b.c[] a(int paramInt)
  {
    return new b.c[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ih.b.c.b
 * JD-Core Version:    0.7.0.1
 */