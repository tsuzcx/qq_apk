package com.tencent.luggage.wxa.df;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.ilink.tdi.b.y;
import com.tencent.luggage.wxa.qu.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parceler;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class e$a
  implements Parcelable.Creator
{
  @NotNull
  public final Object createFromParcel(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "in");
    return new e(paramParcel.readInt(), paramParcel.readString(), (b.y)Enum.valueOf(b.y.class, paramParcel.readString()), (a)b.a.create(paramParcel), paramParcel.readString());
  }
  
  @NotNull
  public final Object[] newArray(int paramInt)
  {
    return new e[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.df.e.a
 * JD-Core Version:    0.7.0.1
 */