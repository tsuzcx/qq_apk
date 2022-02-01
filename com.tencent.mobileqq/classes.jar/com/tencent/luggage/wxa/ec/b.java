package com.tencent.luggage.wxa.ec;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.ea.c;
import com.tencent.luggage.wxa.ea.c.a;
import com.tencent.luggage.wxa.ea.h;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/main/LuggageMainProcessTaskExt;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "runtimeInfo", "Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "(Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;)V", "getRuntimeInfo", "()Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "runInMainProcess", "", "process", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
@Parcelize
public class b
  extends com.tencent.mm.plugin.appbrand.ipc.b
{
  public static final Parcelable.Creator CREATOR = new b.b();
  @Deprecated
  public static final b.a a = new b.a(null);
  @NotNull
  private final j b;
  
  public b(@NotNull j paramj)
  {
    this.b = paramj;
  }
  
  public void a()
  {
    try
    {
      com.tencent.luggage.wxa.ea.b localb = c.c.b().b(c().a());
      o.d("Luggage.LuggageMainProcessTaskExt", "runInMainProcess: run [%s] by process [%d]", new Object[] { getClass().getSimpleName(), Integer.valueOf(c().a()) });
      try
      {
        a(localb);
        return;
      }
      catch (Throwable localThrowable)
      {
        o.b("Luggage.LuggageMainProcessTaskExt", "invoke[%s]: fatal error[%s][%s]\ndump processes[%s]\ndump origin invoke info[%s]", new Object[] { getClass().getCanonicalName(), localThrowable.getMessage(), localThrowable.getStackTrace(), c.c.b().f(), c() });
        throw localThrowable;
      }
      StringBuilder localStringBuilder;
      return;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("runInMainProcess: findProcess(index:");
      localStringBuilder.append(c().a());
      localStringBuilder.append(") get exception:");
      localStringBuilder.append(localArrayIndexOutOfBoundsException);
      o.b("Luggage.LuggageMainProcessTaskExt", localStringBuilder.toString());
    }
  }
  
  public void a(@NotNull com.tencent.luggage.wxa.ea.b<h> paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "process");
  }
  
  @NotNull
  public j c()
  {
    return this.b;
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    this.b.writeToParcel(paramParcel, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ec.b
 * JD-Core Version:    0.7.0.1
 */