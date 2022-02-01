package com.tencent.luggage.wxa.da;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Process;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/launch/task/WxaFinishMessage;", "Lcom/tencent/luggage/sdk/processes/client/LuggageClientProcessMessage;", "Lcom/tencent/luggage/standalone_ext/Runtime;", "appId", "", "killTypeName", "(Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "describeContents", "", "runInLuggageProcess", "", "runtime", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
@Parcelize
public final class d
  extends com.tencent.luggage.wxa.eb.a<com.tencent.luggage.wxa.em.d>
{
  public static final Parcelable.Creator CREATOR = new d.b();
  @Deprecated
  public static final d.a a = new d.a(null);
  @NotNull
  private final String b;
  private final String c;
  
  public d(@NotNull String paramString1, @Nullable String paramString2)
  {
    super(paramString1);
    this.b = paramString1;
    this.c = paramString2;
  }
  
  @NotNull
  public String a()
  {
    return this.b;
  }
  
  public void a(@NotNull com.tencent.luggage.wxa.em.d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "runtime");
    com.tencent.luggage.wxa.ea.a locala = (com.tencent.luggage.wxa.ea.a)null;
    Object localObject = this.c;
    if (localObject != null) {
      locala = com.tencent.luggage.wxa.ea.a.valueOf((String)localObject);
    }
    if (locala == com.tencent.luggage.wxa.ea.a.f) {
      try
      {
        Process.killProcess(Process.myPid());
        return;
      }
      catch (Throwable localThrowable)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("runInLuggageProcess: handled throwable [");
        ((StringBuilder)localObject).append(localThrowable);
        ((StringBuilder)localObject).append(']');
        o.c("Luggage.task.WxaFinishMessage", ((StringBuilder)localObject).toString());
        paramd.E();
        return;
      }
    }
    paramd.E();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.da.d
 * JD-Core Version:    0.7.0.1
 */