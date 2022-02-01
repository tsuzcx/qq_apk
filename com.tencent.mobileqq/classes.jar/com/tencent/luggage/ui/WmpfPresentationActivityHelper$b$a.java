package com.tencent.luggage.ui;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class WmpfPresentationActivityHelper$b$a
  implements Parcelable.Creator
{
  @NotNull
  public final Object createFromParcel(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "in");
    return new WmpfPresentationActivityHelper.b(paramParcel.readInt(), paramParcel.readString(), paramParcel.readString());
  }
  
  @NotNull
  public final Object[] newArray(int paramInt)
  {
    return new WmpfPresentationActivityHelper.b[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WmpfPresentationActivityHelper.b.a
 * JD-Core Version:    0.7.0.1
 */