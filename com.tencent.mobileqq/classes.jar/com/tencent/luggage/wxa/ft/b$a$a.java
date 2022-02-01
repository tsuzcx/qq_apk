package com.tencent.luggage.wxa.ft;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/launch/WxaAppLaunchTraceEventDispatcher$TraceEvent$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/luggage/wxaapi/internal/launch/WxaAppLaunchTraceEventDispatcher$TraceEvent;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/luggage/wxaapi/internal/launch/WxaAppLaunchTraceEventDispatcher$TraceEvent;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class b$a$a
  implements Parcelable.Creator<b.a>
{
  @NotNull
  public b.a a(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "source");
    return new b.a(paramParcel);
  }
  
  @NotNull
  public b.a[] a(int paramInt)
  {
    return new b.a[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ft.b.a.a
 * JD-Core Version:    0.7.0.1
 */