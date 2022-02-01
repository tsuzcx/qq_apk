package com.tencent.luggage.wxa.ea;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/LuggageServiceType;", "", "Landroid/os/Parcelable;", "(Ljava/lang/String;I)V", "describeContents", "", "serializeTo", "Landroid/content/Intent;", "intent", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "WASERVICE", "WAGAME", "NIL", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
@Parcelize
public enum g
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new g.b();
  public static final g.a d;
  
  static
  {
    g localg1 = new g("WASERVICE", 0);
    a = localg1;
    g localg2 = new g("WAGAME", 1);
    b = localg2;
    g localg3 = new g("NIL", 2);
    c = localg3;
    e = new g[] { localg1, localg2, localg3 };
    d = new g.a(null);
  }
  
  private g() {}
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeString(name());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ea.g
 * JD-Core Version:    0.7.0.1
 */