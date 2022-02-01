package com.tencent.luggage.wxa.dc;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.dd.i;
import com.tencent.luggage.wxa.nl.g;
import com.tencent.luggage.wxa.qw.aa;
import com.tencent.luggage.wxa.qw.dc;
import com.tencent.luggage.wxa.qw.dd;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.d;
import com.tencent.luggage.wxa.ro.h;
import com.tencent.mm.plugin.appbrand.appcache.ac;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/CgiGetWxaDebugInfo;", "", "()V", "CMDID", "", "ERR_INVALID_APPID", "ERR_MISS_DATA", "ERR_NO_DEVCODE", "ERR_NO_PERMISSION", "ERR_SYSTEM", "ERR__NOT_UPLOAD", "TAG", "", "URL", "flushWxaDebugInfo", "", "appId", "pkgType", "getWxaDebugInfo", "Lcom/tencent/mm/protocal/protobuf/GetWxaDebugInfoResp;", "isLast", "runPipeline", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class f
{
  public static final f a = new f();
  
  private final dd a(String paramString, boolean paramBoolean)
  {
    dc localdc = new dc();
    localdc.a = paramString;
    localdc.b = paramBoolean;
    dd localdd = (dd)((com.tencent.luggage.wxa.ob.b)e.a(com.tencent.luggage.wxa.ob.b.class)).a("/cgi-bin/mmbiz-bin/wxaapp/getwxadebuginfo", paramString, (com.tencent.luggage.wxa.qu.a)localdc, dd.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isLast:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" response:");
    localdc = null;
    if (localdd != null)
    {
      paramString = localdd.z;
      if (paramString != null)
      {
        paramString = Integer.valueOf(paramString.a);
        break label107;
      }
    }
    paramString = null;
    label107:
    localStringBuilder.append(paramString);
    localStringBuilder.append(' ');
    if (localdd != null)
    {
      paramString = localdd.z;
      if (paramString != null)
      {
        paramString = paramString.b;
        break label147;
      }
    }
    paramString = null;
    label147:
    localStringBuilder.append(paramString);
    localStringBuilder.append(" extJson:");
    paramString = localdc;
    if (localdd != null) {
      paramString = localdd.a;
    }
    localStringBuilder.append(paramString);
    o.d("CgiGetWxaDebugInfo", localStringBuilder.toString());
    return localdd;
  }
  
  @JvmStatic
  public static final boolean a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    if (i.a.g())
    {
      Object localObject2 = a(a, paramString, false, 2, null);
      Object localObject1;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((dd)localObject2).z.a != -12027) {}
      }
      else
      {
        localObject1 = a.a(paramString, true);
      }
      if (localObject1 != null)
      {
        if (((dd)localObject1).z.a != 0)
        {
          paramInt = ((dd)localObject1).z.a;
          if (paramInt != -12026)
          {
            if (paramInt != -12025)
            {
              if (paramInt != -12005)
              {
                if (paramInt != -10002)
                {
                  paramString = new StringBuilder();
                  paramString.append("fail: ret ");
                  paramString.append(((dd)localObject1).z.a);
                  throw ((Throwable)new com.tencent.luggage.wxa.cy.a(1, paramString.toString()));
                }
                throw ((Throwable)new com.tencent.luggage.wxa.cy.a(3, null, 2, null));
              }
              throw ((Throwable)new com.tencent.luggage.wxa.cy.a(4, null, 2, null));
            }
            throw ((Throwable)new com.tencent.luggage.wxa.cy.a(6, null, 2, null));
          }
          throw ((Throwable)new com.tencent.luggage.wxa.cy.a(5, null, 2, null));
        }
        Object localObject3 = new JSONObject(((dd)localObject1).a);
        localObject2 = ((JSONObject)localObject3).optString("downloadURL", "");
        localObject3 = ((JSONObject)localObject3).optString("checkSumMd5", "");
        boolean bool1 = ac.a().a(paramString, paramInt, (String)localObject2, (String)localObject3);
        boolean bool2 = g.a().a(paramString, paramInt, ((dd)localObject1).a);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("flushWxaDebugInfo ");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(" updated:");
        ((StringBuilder)localObject1).append(bool1);
        ((StringBuilder)localObject1).append(" extInfoUpdated:");
        ((StringBuilder)localObject1).append(bool2);
        o.d("CgiGetWxaDebugInfo", ((StringBuilder)localObject1).toString());
        return true;
      }
      o.b("CgiGetWxaDebugInfo", "wxaDebugInfo is null");
      throw ((Throwable)new com.tencent.luggage.wxa.cy.a(1, "fail: request fail"));
    }
    throw ((Throwable)new com.tencent.luggage.wxa.cy.a(2, null, 2, null));
  }
  
  @JvmStatic
  @NotNull
  public static final d<Boolean> b(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    paramString = h.a().c((com.tencent.luggage.wxa.rl.b)new f.a(paramString, paramInt));
    Intrinsics.checkExpressionValueIsNotNull(paramString, "QuickAccess.pipeline().`…\n            }\n        })");
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.f
 * JD-Core Version:    0.7.0.1
 */