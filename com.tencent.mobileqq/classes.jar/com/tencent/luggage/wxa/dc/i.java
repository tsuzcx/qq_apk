package com.tencent.luggage.wxa.dc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.dx.a;
import com.tencent.luggage.wxa.gl.h;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/MMUIN;", "Lcom/tencent/luggage/sdk/login/MMUserId;", "uin", "", "(I)V", "getUin", "()I", "component1", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "data-model_release"}, k=1, mv={1, 1, 16})
@Parcelize
public final class i
  implements a
{
  public static final Parcelable.Creator CREATOR = new i.a();
  private final int a;
  
  public i(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((i)this == paramObject) {
      return true;
    }
    Class localClass2 = getClass();
    Class localClass1;
    if (paramObject != null) {
      localClass1 = paramObject.getClass();
    } else {
      localClass1 = null;
    }
    if ((Intrinsics.areEqual(localClass2, localClass1) ^ true)) {
      return false;
    }
    if (paramObject != null)
    {
      paramObject = (i)paramObject;
      return this.a == paramObject.a;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.luggage.login.MMUIN");
  }
  
  public int hashCode()
  {
    return this.a;
  }
  
  @NotNull
  public String toString()
  {
    return String.valueOf(new h(this.a).longValue());
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeInt(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.i
 * JD-Core Version:    0.7.0.1
 */