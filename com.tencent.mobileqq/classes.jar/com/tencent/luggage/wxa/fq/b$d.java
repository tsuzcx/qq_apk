package com.tencent.luggage.wxa.fq;

import android.content.Context;
import android.net.Uri;
import com.tencent.luggage.wxa.cx.l;
import com.tencent.luggage.wxa.cx.q;
import com.tencent.luggage.wxa.cz.a.a;
import com.tencent.luggage.wxa.ou.d;
import com.tencent.luggage.wxa.qw.bt;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxaapi.LaunchWxaAppResult;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/wxaapi/internal/DemoScan$waitForQRCodeHandler$2$1", "Lcom/tencent/luggage/launch/link/AbsLinkOpener;", "handle", "", "context", "Landroid/content/Context;", "_appId", "", "username", "enterPath", "versionType", "", "version", "statObj", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "referrer", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;", "options", "Lcom/tencent/mm/modelappbrand/LaunchParamsOptional;", "handleResult", "url", "parsed", "Landroid/net/Uri;", "scene", "result", "Lcom/tencent/luggage/launch/link/AbsLinkOpener$HandleResult;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class b$d
  extends com.tencent.luggage.wxa.cz.a
{
  b$d(CancellableContinuation paramCancellableContinuation, bt parambt, long paramLong, Map paramMap, Context paramContext) {}
  
  public void a(@Nullable Context paramContext, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, int paramInt1, int paramInt2, @Nullable d paramd, @Nullable com.tencent.luggage.wxa.jj.j paramj, @Nullable com.tencent.luggage.wxa.ie.a parama)
  {
    paramd = paramString1;
    paramj = new StringBuilder();
    paramj.append("waitForQRCodeDataHandle AbsLinkOpener handle(appId:");
    paramj.append(paramString1);
    paramj.append(", username:");
    paramj.append(paramString2);
    paramj.append(", enterPath:");
    if (paramString3 != null) {
      paramString1 = paramString3;
    } else {
      paramString1 = "";
    }
    paramj.append(paramString1);
    paramj.append(", versionType:");
    paramj.append(paramInt1);
    paramj.append(", version:");
    paramj.append(paramInt2);
    paramj.append(')');
    o.d("Luggage.WXA.DemoScan", paramj.toString());
    paramString1 = (CharSequence)paramd;
    int i = 0;
    if ((paramString1 != null) && (paramString1.length() != 0)) {
      paramInt2 = 0;
    } else {
      paramInt2 = 1;
    }
    if (paramInt2 != 0)
    {
      paramString1 = (CharSequence)paramString2;
      if ((paramString1 != null) && (paramString1.length() != 0)) {
        paramInt2 = 0;
      } else {
        paramInt2 = 1;
      }
      if (paramInt2 == 0)
      {
        paramd = b.a(b.a, paramString2);
        paramString1 = (CharSequence)paramd;
        if (paramString1 != null)
        {
          paramInt2 = i;
          if (paramString1.length() != 0) {}
        }
        else
        {
          paramInt2 = 1;
        }
        if (paramInt2 != 0)
        {
          paramContext = (Continuation)this.a;
          paramString1 = new b.a.a(LaunchWxaAppResult.FailWxaAppIdSync);
          paramString2 = Result.Companion;
          paramContext.resumeWith(Result.constructor-impl(paramString1));
        }
      }
      else
      {
        paramContext = (Continuation)this.a;
        paramString1 = new b.a.a(LaunchWxaAppResult.FailQRCodeInvalid);
        paramString2 = Result.Companion;
        paramContext.resumeWith(Result.constructor-impl(paramString1));
        return;
      }
    }
    paramString1 = new com.tencent.luggage.wxa.ew.b();
    paramString1.a = paramd;
    paramString1.d = paramString3;
    paramString1.e = paramInt1;
    paramString1.j = this.c;
    paramString1.m = (b.a(b.a) ^ true);
    paramString2 = this.d;
    if ((paramString2 != null) && (!paramString2.isEmpty())) {
      paramString1.o = new l(this.d).a();
    }
    paramString2 = new d();
    paramString2.c = 1011;
    if (paramd == null) {
      Intrinsics.throwNpe();
    }
    j.a.a(paramd);
    com.tencent.luggage.wxa.ft.a.a(com.tencent.luggage.wxa.ft.a.a, this.c, paramd, paramInt1, null, 8, null);
    q.a(paramContext, paramString1, paramString2);
  }
  
  public void a(@Nullable String paramString, @Nullable Uri paramUri, int paramInt, @NotNull a.a parama)
  {
    Intrinsics.checkParameterIsNotNull(parama, "result");
    paramInt = c.a[parama.ordinal()];
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (paramInt != 3) {
        return;
      }
      b.a(b.a, 2131886880);
      paramString = (Continuation)this.a;
      paramUri = new b.a.a(LaunchWxaAppResult.FailQRCodeDevCodeExpired);
      parama = Result.Companion;
      paramString.resumeWith(Result.constructor-impl(paramUri));
      return;
    }
    b.a(b.a, 2131886837);
    paramString = (Continuation)this.a;
    paramUri = new b.a.a(LaunchWxaAppResult.FailQRCodeDevCodeAccessDenied);
    parama = Result.Companion;
    paramString.resumeWith(Result.constructor-impl(paramUri));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.b.d
 * JD-Core Version:    0.7.0.1
 */