package com.tencent.luggage.wxa.ec;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.ea.c.a;
import com.tencent.luggage.wxa.ed.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/main/LuggagePopRuntimeTask;", "Lcom/tencent/luggage/sdk/processes/main/LuggageMainProcessTaskExt;", "rt", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "(Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;)V", "runtimeInfo", "Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "(Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;)V", "getRuntimeInfo", "()Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "setRuntimeInfo", "describeContents", "", "runInMainProcess", "", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
@Parcelize
public final class e
  extends b
{
  public static final Parcelable.Creator CREATOR = new e.a();
  @NotNull
  private j b;
  
  public e(@NotNull j paramj)
  {
    super(paramj);
    this.b = paramj;
  }
  
  public e(@NotNull d paramd)
  {
    this(c.a(paramd));
  }
  
  public void a()
  {
    super.a();
    com.tencent.luggage.wxa.ea.c.c.b().c(c().b());
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
 * Qualified Name:     com.tencent.luggage.wxa.ec.e
 * JD-Core Version:    0.7.0.1
 */