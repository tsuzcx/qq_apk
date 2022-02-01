package com.tencent.luggage.wxa.ec;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.ea.c.a;
import com.tencent.luggage.wxa.ea.e;
import com.tencent.luggage.wxa.ea.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/main/LuggageRegisterTask;", "Lcom/tencent/luggage/sdk/processes/main/LuggageMainProcessTaskExt;", "rt", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "(Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;)V", "runtimeInfo", "Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "(Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;)V", "getRuntimeInfo", "()Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "describeContents", "", "runInMainProcess", "", "process", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
@Parcelize
public class f
  extends b
{
  public static final Parcelable.Creator CREATOR = new f.b();
  @Deprecated
  public static final f.a b = new f.a(null);
  @NotNull
  private final j c;
  
  public f(@NotNull j paramj)
  {
    super(paramj);
    this.c = paramj;
  }
  
  public f(@NotNull com.tencent.luggage.wxa.ed.d paramd)
  {
    this(c.a(paramd));
  }
  
  public void a(@NotNull com.tencent.luggage.wxa.ea.b<h> paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "process");
    String str = c().b();
    int i = c().c();
    if (paramb.a(str) == null)
    {
      paramb.a(new h(c().b(), c().d(), c().c()), c().f());
      return;
    }
    paramb = paramb.a(str);
    if (paramb == null) {
      Intrinsics.throwNpe();
    }
    paramb.a(e.c);
    paramb.a(i);
    com.tencent.luggage.wxa.ea.c.c.b().c(str);
  }
  
  @NotNull
  public j c()
  {
    return this.c;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    this.c.writeToParcel(paramParcel, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ec.f
 * JD-Core Version:    0.7.0.1
 */