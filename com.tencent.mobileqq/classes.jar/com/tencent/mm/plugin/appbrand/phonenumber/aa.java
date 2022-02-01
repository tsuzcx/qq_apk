package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.SharedPreferences.Editor;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.w;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReporter;", "", "()V", "TAG", "", "mmKv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMmKv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmKv$delegate", "Lkotlin/Lazy;", "sMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "Lkotlin/collections/HashMap;", "get", "appId", "init", "", "resotre", "save", "uninit", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class aa
{
  public static final aa a = new aa();
  private static final HashMap<String, z> b = new HashMap();
  private static final Lazy c = LazyKt.lazy((Function0)aa.a.a);
  
  private final w a()
  {
    return (w)c.getValue();
  }
  
  public final void a(@NotNull String paramString)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramString, "appId");
      z localz = new z(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 67108863, null);
      ((Map)b).put(paramString, localz);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void b(@NotNull String paramString)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramString, "appId");
      z localz = d(paramString);
      if (localz != null) {
        a.a().putString(paramString, localz.toString()).commit();
      }
      return;
    }
    finally {}
  }
  
  public final void c(@NotNull String paramString)
  {
    for (;;)
    {
      try
      {
        Intrinsics.checkParameterIsNotNull(paramString, "appId");
        localObject = a().getString(paramString, "");
        if (localObject != null)
        {
          Intrinsics.checkExpressionValueIsNotNull(localObject, "mmKv.getString(appId, \"\") ?: \"{}\"");
          if (((CharSequence)localObject).length() <= 0) {
            break label90;
          }
          i = 1;
          if (i != 0)
          {
            localObject = new z((String)localObject);
            ((Map)b).put(paramString, localObject);
          }
          return;
        }
      }
      finally {}
      Object localObject = "{}";
      continue;
      label90:
      int i = 0;
    }
  }
  
  @Nullable
  public final z d(@NotNull String paramString)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramString, "appId");
      paramString = (z)b.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void e(@NotNull String paramString)
  {
    for (;;)
    {
      try
      {
        Intrinsics.checkParameterIsNotNull(paramString, "appId");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("report ");
        localObject = d(paramString);
        if (localObject != null)
        {
          localObject = ((z)localObject).toString();
          localStringBuilder.append((String)localObject);
          o.f("MicroMsg.PhoneNumberReporter", localStringBuilder.toString());
          b.remove(paramString);
          a().remove(paramString).commit();
          return;
        }
      }
      finally {}
      Object localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.aa
 * JD-Core Version:    0.7.0.1
 */