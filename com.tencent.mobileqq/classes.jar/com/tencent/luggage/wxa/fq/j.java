package com.tencent.luggage.wxa.fq;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.luggage.wxa.hj.e;
import com.tencent.luggage.wxa.hj.h;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxaapi.WxaAppCloseEventListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/WxaAppCloseEventLogic;", "", "()V", "KEY_APPID", "", "KEY_TIMESTAMP", "TAG", "sValidAppIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "sWxaAppCloseEventListener", "Ljava/util/HashSet;", "Lcom/tencent/luggage/wxaapi/WxaAppCloseEventListener;", "Lkotlin/collections/HashSet;", "add", "", "listenerAppBackToHost", "addWxaAppId", "appId", "isAppIdValid", "", "notifyClose", "timestamp", "", "notifyCloseByClientProcess", "remove", "removeWxaAppId", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class j
{
  public static final j a = new j();
  private static final HashSet<WxaAppCloseEventListener> b = new HashSet();
  private static final ArrayList<String> c = new ArrayList();
  
  private final void b(long paramLong, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("notifyClose timestamp:");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" appId:");
    ((StringBuilder)localObject).append(paramString);
    o.d("Luggage.WxaAppCloseEventLogic", ((StringBuilder)localObject).toString());
    if ((paramLong != 0L) && (!af.c(paramString)))
    {
      localObject = new ArrayList();
      try
      {
        ((ArrayList)localObject).addAll((Collection)b);
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((WxaAppCloseEventListener)((Iterator)localObject).next()).onWxaAppClose(paramLong, paramString);
        }
        b(paramString);
        return;
      }
      finally {}
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("timestamp:");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" appId:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" is error, return");
    o.c("Luggage.WxaAppCloseEventLogic", ((StringBuilder)localObject).toString());
  }
  
  public final void a(long paramLong, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("notifyCloseByClientProcess timestamp:");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" appId:");
    ((StringBuilder)localObject).append(paramString);
    o.d("Luggage.WxaAppCloseEventLogic", ((StringBuilder)localObject).toString());
    localObject = r.i();
    Bundle localBundle = new Bundle();
    localBundle.putLong("KEY_TIMESTAMP", paramLong);
    localBundle.putString("KEY_APPID", paramString);
    h.a((String)localObject, (Parcelable)localBundle, j.a.a.getClass(), (e)j.b.a);
  }
  
  public final void a(@Nullable WxaAppCloseEventListener paramWxaAppCloseEventListener)
  {
    if (paramWxaAppCloseEventListener != null) {}
    try
    {
      b.add(paramWxaAppCloseEventListener);
      paramWxaAppCloseEventListener = new StringBuilder();
      paramWxaAppCloseEventListener.append("add listener: ");
      paramWxaAppCloseEventListener.append(b.size());
      o.d("Luggage.WxaAppCloseEventLogic", paramWxaAppCloseEventListener.toString());
    }
    finally {}
  }
  
  public final void a(@NotNull String paramString)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramString, "appId");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addWxaAppId: ");
      localStringBuilder.append(paramString);
      o.d("Luggage.WxaAppCloseEventLogic", localStringBuilder.toString());
      c.add(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void b(@Nullable WxaAppCloseEventListener paramWxaAppCloseEventListener)
  {
    if (paramWxaAppCloseEventListener != null) {}
    try
    {
      b.remove(paramWxaAppCloseEventListener);
      paramWxaAppCloseEventListener = new StringBuilder();
      paramWxaAppCloseEventListener.append("remove listener: ");
      paramWxaAppCloseEventListener.append(b.size());
      o.d("Luggage.WxaAppCloseEventLogic", paramWxaAppCloseEventListener.toString());
    }
    finally {}
  }
  
  public final void b(@NotNull String paramString)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramString, "appId");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeWxaAppId: ");
      localStringBuilder.append(paramString);
      o.d("Luggage.WxaAppCloseEventLogic", localStringBuilder.toString());
      c.remove(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.j
 * JD-Core Version:    0.7.0.1
 */