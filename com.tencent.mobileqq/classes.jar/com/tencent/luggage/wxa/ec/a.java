package com.tencent.luggage.wxa.ec;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.ea.c;
import com.tencent.luggage.wxa.ea.c.a;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/main/LuggageInitTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "processName", "", "(Ljava/lang/String;)V", "runInMainProcess", "", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
@Parcelize
public final class a
  extends com.tencent.mm.plugin.appbrand.ipc.b
{
  public static final Parcelable.Creator CREATOR = new a.a();
  private final String a;
  
  public a(@NotNull String paramString)
  {
    this.a = paramString;
  }
  
  public void a()
  {
    Iterator localIterator = ((Iterable)c.c.b().a((Function1)new a.b(this))).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.luggage.wxa.ea.b)localIterator.next()).g();
    }
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeString(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ec.a
 * JD-Core Version:    0.7.0.1
 */