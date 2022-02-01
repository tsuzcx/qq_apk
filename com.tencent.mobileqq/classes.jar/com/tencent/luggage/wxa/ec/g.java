package com.tencent.luggage.wxa.ec;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.ea.c.a;
import com.tencent.luggage.wxa.ea.h;
import com.tencent.luggage.wxa.ed.d;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/main/LuggageRemoveTask;", "Lcom/tencent/luggage/sdk/processes/main/LuggageMainProcessTaskExt;", "rt", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "(Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;)V", "runtimeInfo", "Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "(Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;)V", "getRuntimeInfo", "()Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "describeContents", "", "runInMainProcess", "", "process", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
@Parcelize
public final class g
  extends b
{
  public static final Parcelable.Creator CREATOR = new g.a();
  @NotNull
  private final j b;
  
  public g(@NotNull j paramj)
  {
    super(paramj);
    this.b = paramj;
  }
  
  public g(@NotNull d paramd)
  {
    this(c.a(paramd));
  }
  
  public void a(@NotNull com.tencent.luggage.wxa.ea.b<h> paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "process");
    com.tencent.luggage.wxa.ea.c.c.b().a(c().b(), c().c(), (Function1)new g.b(paramb));
  }
  
  @NotNull
  public j c()
  {
    return this.b;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    this.b.writeToParcel(paramParcel, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ec.g
 * JD-Core Version:    0.7.0.1
 */