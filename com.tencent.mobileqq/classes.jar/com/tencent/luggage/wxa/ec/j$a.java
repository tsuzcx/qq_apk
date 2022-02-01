package com.tencent.luggage.wxa.ec;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.jj.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class j$a
  implements Parcelable.Creator
{
  @NotNull
  public final Object createFromParcel(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "in");
    int i = paramParcel.readInt();
    String str1 = paramParcel.readString();
    int j = paramParcel.readInt();
    boolean bool1;
    if (paramParcel.readInt() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    int k = paramParcel.readInt();
    String str2 = paramParcel.readString();
    String str3 = paramParcel.readString();
    h localh = (h)paramParcel.readParcelable(j.class.getClassLoader());
    boolean bool2;
    if (paramParcel.readInt() != 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    return new j(i, str1, j, bool1, k, str2, str3, localh, bool2, paramParcel.readLong(), paramParcel.readString());
  }
  
  @NotNull
  public final Object[] newArray(int paramInt)
  {
    return new j[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ec.j.a
 * JD-Core Version:    0.7.0.1
 */