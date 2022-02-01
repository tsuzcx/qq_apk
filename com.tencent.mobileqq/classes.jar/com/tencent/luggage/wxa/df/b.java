package com.tencent.luggage.wxa.df;

import android.os.Parcel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parceler;
import kotlinx.android.parcel.Parceler.DefaultImpls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/account/tdi/ipc/PBParceler;", "Lkotlinx/android/parcel/Parceler;", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "()V", "PARCELER", "Lcom/tencent/luggage/login/account/tdi/ipc/MMProtoBufTransfer;", "create", "parcel", "Landroid/os/Parcel;", "write", "", "flags", "", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class b
  implements Parceler<com.tencent.luggage.wxa.qu.a>
{
  public static final b a = new b();
  private static final a b = new a();
  
  @Nullable
  public com.tencent.luggage.wxa.qu.a a(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    Object localObject = b.a(paramParcel);
    paramParcel = localObject;
    if (!(localObject instanceof com.tencent.luggage.wxa.qu.a)) {
      paramParcel = null;
    }
    return (com.tencent.luggage.wxa.qu.a)paramParcel;
  }
  
  public void a(@Nullable com.tencent.luggage.wxa.qu.a parama, @NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    if (parama == null)
    {
      paramParcel.writeString(null);
      return;
    }
    b.a((Object)parama, paramParcel);
  }
  
  @NotNull
  public com.tencent.luggage.wxa.qu.a[] a(int paramInt)
  {
    return (com.tencent.luggage.wxa.qu.a[])Parceler.DefaultImpls.newArray(this, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.df.b
 * JD-Core Version:    0.7.0.1
 */