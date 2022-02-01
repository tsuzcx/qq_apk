package com.tencent.luggage.wxa.fp;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class i$a$b$a$a
  implements Parcelable.Creator
{
  @NotNull
  public final Object createFromParcel(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "in");
    return new i.a.b.a(paramParcel.readString(), paramParcel.readString(), paramParcel.readInt());
  }
  
  @NotNull
  public final Object[] newArray(int paramInt)
  {
    return new i.a.b.a[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fp.i.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */