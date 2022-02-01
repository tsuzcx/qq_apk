package com.tencent.luggage.wxa.eh;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/setting/entity/MMUserAvatarInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/luggage/setting/entity/MMUserAvatarInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/luggage/setting/entity/MMUserAvatarInfo;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class b$a
  implements Parcelable.Creator<b>
{
  @NotNull
  public b a(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    return new b(paramParcel);
  }
  
  @NotNull
  public b[] a(int paramInt)
  {
    return new b[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.eh.b.a
 * JD-Core Version:    0.7.0.1
 */