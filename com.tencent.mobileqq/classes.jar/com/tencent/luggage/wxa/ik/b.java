package com.tencent.luggage.wxa.ik;

import android.os.Parcelable;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Deprecated(message="FOR REFACTOR ONLY")
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/msgsubscription/util/CompatProcessTask;", "Landroid/os/Parcelable;", "()V", "taskId", "", "getTaskId", "()Ljava/lang/String;", "taskId$delegate", "Lkotlin/Lazy;", "callback", "", "describeContents", "", "execAsync", "keepMe", "parseFromParcel", "p", "Landroid/os/Parcel;", "releaseMe", "runInClientProcess", "runInMainProcess", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 1, 16})
public abstract class b
  implements Parcelable
{
  @NotNull
  private final Lazy a = LazyKt.lazy((Function0)new b.c(this));
  
  public abstract void a();
  
  public void b() {}
  
  @NotNull
  public final String c()
  {
    return (String)this.a.getValue();
  }
  
  public final void d()
  {
    g localg = f.a;
    Runnable localRunnable = (Runnable)new b.b(this);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CompatProcessTask_");
    localStringBuilder.append(c());
    localg.a(localRunnable, localStringBuilder.toString());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void e()
  {
    g localg = f.a;
    Runnable localRunnable = (Runnable)new b.a(this);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CompatProcessTask_");
    localStringBuilder.append(c());
    localg.a(localRunnable, localStringBuilder.toString());
  }
  
  public final void f() {}
  
  public final void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ik.b
 * JD-Core Version:    0.7.0.1
 */