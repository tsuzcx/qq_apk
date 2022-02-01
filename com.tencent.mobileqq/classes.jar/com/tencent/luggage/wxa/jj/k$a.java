package com.tencent.luggage.wxa.jj;

import android.os.SystemClock;
import com.tencent.luggage.wxa.ef.d.a;
import com.tencent.luggage.wxa.pd.u;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"getByHeavyInvoke", "", "invoke"}, k=3, mv={1, 1, 16})
final class k$a
  extends Lambda
  implements Function0<String>
{
  public static final a a = new a();
  
  k$a()
  {
    super(0);
  }
  
  @NotNull
  public final String a()
  {
    long l1 = SystemClock.elapsedRealtime();
    String str = k.a(k.a);
    if ((str instanceof d.a))
    {
      localObject = ((d.a)str).a();
    }
    else if (str != null)
    {
      localObject = str.toString();
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    boolean bool = u.a();
    long l2 = SystemClock.elapsedRealtime() - l1;
    l1 = 32;
    StringBuilder localStringBuilder;
    if ((l2 > l1) && (bool))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("block main thread and skip ");
      localStringBuilder.append((int)(l2 / 16));
      localStringBuilder.append(" frames! runProfiled:log:");
      localStringBuilder.append("Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent try mmkv");
      localStringBuilder.append(" cost ");
      localStringBuilder.append(l2);
      localStringBuilder.append(" ms result:");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" isMainThread: ");
      localStringBuilder.append(bool);
      localStringBuilder.append(' ');
      o.c("Luggage.Utils.Profile", localStringBuilder.toString());
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("runProfiled:log:");
      localStringBuilder.append("Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent try mmkv");
      localStringBuilder.append(" cost ");
      localStringBuilder.append(l2);
      localStringBuilder.append(" ms result:");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" isMainThread: ");
      localStringBuilder.append(bool);
      localStringBuilder.append(' ');
      o.d("Luggage.Utils.Profile", localStringBuilder.toString());
    }
    Object localObject = (CharSequence)str;
    int i;
    if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0) {
      return str;
    }
    l2 = SystemClock.elapsedRealtime();
    str = k.b(k.a);
    if ((str instanceof d.a))
    {
      localObject = ((d.a)str).a();
    }
    else if (str != null)
    {
      localObject = str.toString();
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    bool = u.a();
    l2 = SystemClock.elapsedRealtime() - l2;
    if ((l2 > l1) && (bool))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("block main thread and skip ");
      localStringBuilder.append((int)(l2 / 16));
      localStringBuilder.append(" frames! runProfiled:log:");
      localStringBuilder.append("Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent by webkit");
      localStringBuilder.append(" cost ");
      localStringBuilder.append(l2);
      localStringBuilder.append(" ms result:");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" isMainThread: ");
      localStringBuilder.append(bool);
      localStringBuilder.append(' ');
      o.c("Luggage.Utils.Profile", localStringBuilder.toString());
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("runProfiled:log:");
      localStringBuilder.append("Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent by webkit");
      localStringBuilder.append(" cost ");
      localStringBuilder.append(l2);
      localStringBuilder.append(" ms result:");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" isMainThread: ");
      localStringBuilder.append(bool);
      localStringBuilder.append(' ');
      o.d("Luggage.Utils.Profile", localStringBuilder.toString());
    }
    if (str == null) {
      Intrinsics.throwNpe();
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jj.k.a
 * JD-Core Version:    0.7.0.1
 */