package com.tencent.luggage.wxa.df;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.qu.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parceler;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class f$a
  implements Parcelable.Creator
{
  @NotNull
  public final Object createFromParcel(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "in");
    return new f(paramParcel.readInt(), paramParcel.readString(), (a)b.a.create(paramParcel));
  }
  
  @NotNull
  public final Object[] newArray(int paramInt)
  {
    return new f[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.df.f.a
 * JD-Core Version:    0.7.0.1
 */