package com.tencent.luggage.wxa.dj;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class c$a
  implements Parcelable.Creator
{
  @NotNull
  public final Object createFromParcel(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "in");
    int i = paramParcel.readInt();
    byte[] arrayOfByte = paramParcel.createByteArray();
    boolean bool1;
    if (paramParcel.readInt() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    int j = paramParcel.readInt();
    boolean bool2;
    if (paramParcel.readInt() != 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    return new c(i, arrayOfByte, bool1, j, bool2, paramParcel.readInt());
  }
  
  @NotNull
  public final Object[] newArray(int paramInt)
  {
    return new c[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dj.c.a
 * JD-Core Version:    0.7.0.1
 */