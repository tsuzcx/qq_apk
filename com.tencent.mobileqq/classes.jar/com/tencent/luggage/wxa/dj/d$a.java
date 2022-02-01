package com.tencent.luggage.wxa.dj;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class d$a
  implements Parcelable.Creator
{
  @NotNull
  public final Object createFromParcel(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "in");
    int i = paramParcel.readInt();
    ArrayList localArrayList = new ArrayList(i);
    while (i != 0)
    {
      localArrayList.add((c)c.CREATOR.createFromParcel(paramParcel));
      i -= 1;
    }
    return new d(localArrayList);
  }
  
  @NotNull
  public final Object[] newArray(int paramInt)
  {
    return new d[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dj.d.a
 * JD-Core Version:    0.7.0.1
 */