package com.tencent.luggage.wxa.dc;

import com.tencent.luggage.wxa.ob.b;
import com.tencent.luggage.wxa.qu.a;
import com.tencent.luggage.wxa.qw.ci;
import com.tencent.luggage.wxa.qw.cj;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/CgiGetRuntimeSession;", "", "()V", "TAG", "", "URL", "getRuntimeSessionId", "appId", "hostAppId", "scene", "", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class e
{
  public static final e a = new e();
  
  @NotNull
  public final String a(@NotNull String paramString1, @NotNull String paramString2, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "appId");
    Intrinsics.checkParameterIsNotNull(paramString2, "hostAppId");
    Object localObject = new ci();
    ((ci)localObject).a = paramString2;
    ((ci)localObject).b = paramInt;
    localObject = (cj)((b)com.tencent.luggage.wxa.ba.e.a(b.class)).a("/cgi-bin/mmbiz-bin/wxabusiness/getruntimesession", paramString1, (a)localObject, cj.class);
    if (localObject != null) {
      paramString1 = ((cj)localObject).a;
    } else {
      paramString1 = null;
    }
    if (paramString1 != null)
    {
      paramString1 = ((cj)localObject).a;
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "response.session_id");
      if (((CharSequence)paramString1).length() == 0) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if (paramInt == 0)
      {
        paramString1 = new StringBuilder();
        paramString1.append("host_appid: ");
        paramString1.append(paramString2);
        paramString1.append(" getSession_id ");
        paramString1.append(((cj)localObject).a);
        o.e("CgiGetRuntimeSession", paramString1.toString());
        paramString1 = ((cj)localObject).a;
        Intrinsics.checkExpressionValueIsNotNull(paramString1, "response.session_id");
        return paramString1;
      }
    }
    paramString1 = new StringBuilder();
    paramString1.append("host_appid: ");
    paramString1.append(paramString2);
    paramString1.append(" getSession_id fail ");
    paramString1.append(localObject);
    o.b("CgiGetRuntimeSession", paramString1.toString());
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.e
 * JD-Core Version:    0.7.0.1
 */