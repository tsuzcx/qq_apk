package com.tencent.luggage.wxa.eh;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/setting/entity/MMUserAvatarInfo$MMUserAvatarItem$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/luggage/setting/entity/MMUserAvatarInfo$MMUserAvatarItem;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/luggage/setting/entity/MMUserAvatarInfo$MMUserAvatarItem;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class b$b$a
  implements Parcelable.Creator<b.b>
{
  @NotNull
  public b.b a(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    return new b.b(paramParcel);
  }
  
  @NotNull
  public b.b[] a(int paramInt)
  {
    return new b.b[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.eh.b.b.a
 * JD-Core Version:    0.7.0.1
 */