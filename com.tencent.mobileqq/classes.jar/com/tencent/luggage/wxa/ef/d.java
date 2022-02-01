package com.tencent.luggage.wxa.ef;

import android.os.SystemClock;
import com.tencent.luggage.wxa.pd.u;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/sdk/wxa_ktx/Profile;", "", "()V", "TAG", "", "runProfiled", "R", "logName", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "profileFunc", "Lkotlin/Function3;", "", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "run", "Ljava/lang/Runnable;", "Lkotlin/Function2;", "ProfileReturnObject", "luggage-commons_release"}, k=1, mv={1, 1, 16})
public final class d
{
  public static final d a = new d();
  
  @JvmStatic
  @Nullable
  public static final <R> R a(@NotNull String paramString, @NotNull Function0<? extends R> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "logName");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    long l = SystemClock.elapsedRealtime();
    Object localObject = paramFunction0.invoke();
    if ((localObject instanceof d.a))
    {
      paramFunction0 = ((d.a)localObject).a();
    }
    else if (localObject != null)
    {
      paramFunction0 = localObject.toString();
      if (paramFunction0 != null) {}
    }
    else
    {
      paramFunction0 = "";
    }
    boolean bool = u.a();
    l = SystemClock.elapsedRealtime() - l;
    if ((l > 32) && (bool))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("block main thread and skip ");
      localStringBuilder.append((int)(l / 16));
      localStringBuilder.append(" frames! runProfiled:log:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" cost ");
      localStringBuilder.append(l);
      localStringBuilder.append(" ms result:");
      localStringBuilder.append(paramFunction0);
      localStringBuilder.append(" isMainThread: ");
      localStringBuilder.append(bool);
      localStringBuilder.append(' ');
      o.c("Luggage.Utils.Profile", localStringBuilder.toString());
      return localObject;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("runProfiled:log:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" cost ");
    localStringBuilder.append(l);
    localStringBuilder.append(" ms result:");
    localStringBuilder.append(paramFunction0);
    localStringBuilder.append(" isMainThread: ");
    localStringBuilder.append(bool);
    localStringBuilder.append(' ');
    o.d("Luggage.Utils.Profile", localStringBuilder.toString());
    return localObject;
  }
  
  @JvmStatic
  @JvmOverloads
  @Nullable
  public static final String a(@NotNull String paramString, @NotNull Runnable paramRunnable)
  {
    return a(paramString, paramRunnable, null, 4, null);
  }
  
  @JvmStatic
  @JvmOverloads
  @Nullable
  public static final String a(@NotNull String paramString, @NotNull Runnable paramRunnable, @NotNull Function2<? super Long, ? super Long, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "logName");
    Intrinsics.checkParameterIsNotNull(paramRunnable, "run");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "profileFunc");
    long l = SystemClock.elapsedRealtime();
    paramRunnable.run();
    if (("" instanceof d.a))
    {
      paramRunnable = ((d.a)"").a();
    }
    else
    {
      paramRunnable = "".toString();
      if (paramRunnable == null) {
        paramRunnable = "";
      }
    }
    boolean bool = u.a();
    l = SystemClock.elapsedRealtime() - l;
    if ((l > 32) && (bool))
    {
      paramFunction2 = new StringBuilder();
      paramFunction2.append("block main thread and skip ");
      paramFunction2.append((int)(l / 16));
      paramFunction2.append(" frames! runProfiled:log:");
      paramFunction2.append(paramString);
      paramFunction2.append(" cost ");
      paramFunction2.append(l);
      paramFunction2.append(" ms result:");
      paramFunction2.append(paramRunnable);
      paramFunction2.append(" isMainThread: ");
      paramFunction2.append(bool);
      paramFunction2.append(' ');
      o.c("Luggage.Utils.Profile", paramFunction2.toString());
      return "";
    }
    paramFunction2 = new StringBuilder();
    paramFunction2.append("runProfiled:log:");
    paramFunction2.append(paramString);
    paramFunction2.append(" cost ");
    paramFunction2.append(l);
    paramFunction2.append(" ms result:");
    paramFunction2.append(paramRunnable);
    paramFunction2.append(" isMainThread: ");
    paramFunction2.append(bool);
    paramFunction2.append(' ');
    o.d("Luggage.Utils.Profile", paramFunction2.toString());
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ef.d
 * JD-Core Version:    0.7.0.1
 */