package com.tencent.luggage.wxa.ec;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.ed.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/main/LuggageUpdateTask;", "Lcom/tencent/luggage/sdk/processes/main/LuggageRegisterTask;", "rt", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "(Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;)V", "runtimeInfo", "Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "(Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;)V", "getRuntimeInfo", "()Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
@Parcelize
public final class i
  extends f
{
  public static final Parcelable.Creator CREATOR = new i.a();
  @NotNull
  private final j c;
  
  public i(@NotNull j paramj)
  {
    super(paramj);
    this.c = paramj;
  }
  
  public i(@NotNull d paramd)
  {
    this(c.a(paramd));
  }
  
  @NotNull
  public j c()
  {
    return this.c;
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    this.c.writeToParcel(paramParcel, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ec.i
 * JD-Core Version:    0.7.0.1
 */