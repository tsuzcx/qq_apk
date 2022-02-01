package com.tencent.luggage.wxa.dd;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.dx.a;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/account/MMDeviceID;", "Lcom/tencent/luggage/sdk/login/MMUserId;", "deviceId", "", "(Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
@Parcelize
public final class e
  implements a
{
  public static final Parcelable.Creator CREATOR = new e.a();
  @NotNull
  private final String a;
  
  public e(@NotNull String paramString)
  {
    this.a = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((e)this == paramObject) {
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
      paramObject = (e)paramObject;
      return !(Intrinsics.areEqual(this.a, paramObject.a) ^ true);
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.luggage.login.account.MMDeviceID");
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  @NotNull
  public String toString()
  {
    return this.a;
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeString(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dd.e
 * JD-Core Version:    0.7.0.1
 */