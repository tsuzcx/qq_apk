package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.ob.b;
import com.tencent.luggage.wxa.qu.a;
import com.tencent.luggage.wxa.qw.aa;
import com.tencent.luggage.wxa.qw.bd;
import com.tencent.luggage.wxa.qw.ni;
import com.tencent.luggage.wxa.qw.nj;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/launch/CgiWxaRuntimeHostAttrSync;", "", "()V", "CMDID", "", "TAG", "", "URL", "getWxaRuntimeHostAttrSync", "Lcom/tencent/mm/protocal/protobuf/WxaRuntimeHostAttrSyncResp;", "appId", "hostAppId", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class e
{
  public static final e a = new e();
  private static final String b = "CgiWxaRuntimeHostAttrSync";
  
  @JvmStatic
  @Nullable
  public static final nj a(@Nullable String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString2, "hostAppId");
    boolean bool = af.c(paramString2);
    Object localObject1 = null;
    if (bool)
    {
      o.b(b, "hostAppId is null, return");
      return null;
    }
    Object localObject2 = new ni();
    ((ni)localObject2).a = paramString2;
    localObject2 = (nj)((b)com.tencent.luggage.wxa.ba.e.a(b.class)).a("/cgi-bin/mmbiz-bin/wxaruntime/hostattrsync", paramString1, (a)localObject2, nj.class);
    String str = b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getWxaRuntimeHostAttrSync appId:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" hostAppId:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" response:");
    if (localObject2 != null)
    {
      paramString1 = ((nj)localObject2).z;
      if (paramString1 != null)
      {
        paramString1 = Integer.valueOf(paramString1.a);
        break label150;
      }
    }
    paramString1 = null;
    label150:
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" errMsg:");
    if (localObject2 != null)
    {
      paramString1 = ((nj)localObject2).z;
      if (paramString1 != null)
      {
        paramString1 = paramString1.b;
        break label190;
      }
    }
    paramString1 = null;
    label190:
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", ret:");
    paramString1 = localObject1;
    if (localObject2 != null)
    {
      paramString2 = ((nj)localObject2).a;
      paramString1 = localObject1;
      if (paramString2 != null) {
        paramString1 = Integer.valueOf(paramString2.a);
      }
    }
    localStringBuilder.append(paramString1);
    o.d(str, localStringBuilder.toString());
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.e
 * JD-Core Version:    0.7.0.1
 */