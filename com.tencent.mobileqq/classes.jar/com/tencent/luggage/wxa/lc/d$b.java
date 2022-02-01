package com.tencent.luggage.wxa.lc;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.ii.a.c;
import com.tencent.luggage.wxa.ik.a.a;
import com.tencent.luggage.wxa.qz.o;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask;", "Lcom/tencent/mm/msgsubscription/util/CompatProcessTask;", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "username", "", "appid", "appType", "", "tmplIds", "", "type", "jsapi", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage;", "service", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "callbackId", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;ILcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage;Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;I)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "(Ljava/lang/String;I)V", "Ljava/lang/Integer;", "getSubscribeMsgListExecutor", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;", "getGetSubscribeMsgListExecutor", "()Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;", "setGetSubscribeMsgListExecutor", "(Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;)V", "isCgiRequestSuccess", "", "()Z", "setCgiRequestSuccess", "(Z)V", "requestResult", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "getRequestResult", "()Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "setRequestResult", "(Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;)V", "subscribeMsgExecutor", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor;", "getSubscribeMsgExecutor", "()Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor;", "setSubscribeMsgExecutor", "(Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor;)V", "callbackJsApi", "", "status", "retMap", "", "", "errorCode", "createGetSubscribeMsgListListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;", "createSubscribeMsgListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor$EventListener;", "describeContents", "onNetSceneEndCallback", "errType", "errCode", "errMsg", "result", "parseFromParcel", "p", "runInClientProcess", "runInMainProcess", "writeToParcel", "flags", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
final class d$b
  extends com.tencent.luggage.wxa.ik.b
  implements a.c
{
  @JvmField
  @NotNull
  public static final Parcelable.Creator<b> CREATOR = (Parcelable.Creator)new d.b.b();
  public static final d.b.a a = new d.b.a(null);
  @Nullable
  private com.tencent.luggage.wxa.ih.c b;
  private com.tencent.luggage.wxa.du.c c;
  private Integer d;
  private d e;
  @Nullable
  private b f;
  @Nullable
  private e g;
  private boolean h;
  private String i;
  private int j;
  
  public d$b(@NotNull Parcel paramParcel)
  {
    this((String)localObject, paramParcel.readInt());
    this.b = ((com.tencent.luggage.wxa.ih.c)paramParcel.readParcelable(com.tencent.luggage.wxa.ih.c.class.getClassLoader()));
    this.f = ((b)paramParcel.readParcelable(b.class.getClassLoader()));
    this.g = ((e)paramParcel.readParcelable(e.class.getClassLoader()));
    paramParcel = this.f;
    if (paramParcel == null) {
      Intrinsics.throwNpe();
    }
    localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    paramParcel.a(a(((b)localObject).e()));
    paramParcel = this.g;
    if (paramParcel == null) {
      Intrinsics.throwNpe();
    }
    paramParcel.a(j());
  }
  
  public d$b(@NotNull String paramString, int paramInt)
  {
    this.i = paramString;
    this.j = paramInt;
    this.h = true;
  }
  
  public d$b(@NotNull String paramString1, @NotNull String paramString2, int paramInt1, @NotNull List<String> paramList, int paramInt2, @NotNull d paramd, @NotNull com.tencent.luggage.wxa.du.c paramc, int paramInt3)
  {
    this(paramString1, paramInt2);
    this.e = paramd;
    this.c = paramc;
    this.d = Integer.valueOf(paramInt3);
    a.a.a(paramString1, paramString2);
    paramString2 = new b(paramString1, paramList, a(paramList), paramString2, paramInt1);
    paramString2.a((a.a)a.a);
    this.f = paramString2;
    paramString1 = new e(paramString1, j());
    paramString1.a((a.a)a.a);
    this.g = paramString1;
  }
  
  private final b.c a(List<String> paramList)
  {
    return (b.c)new d.b.c(this);
  }
  
  private final void a(String paramString, Map<String, ? extends Object> paramMap, int paramInt)
  {
    d.a locala = d.a;
    com.tencent.luggage.wxa.du.c localc = this.c;
    if (localc == null) {
      Intrinsics.throwNpe();
    }
    d locald = this.e;
    if (locald == null) {
      Intrinsics.throwNpe();
    }
    Integer localInteger = this.d;
    if (localInteger == null) {
      Intrinsics.throwNpe();
    }
    locala.a(localc, locald, localInteger.intValue(), paramString, paramMap, paramInt);
  }
  
  private final e.c j()
  {
    return (e.c)new d.b.d(this);
  }
  
  public void a()
  {
    Object localObject;
    if (this.j == 0)
    {
      localObject = this.f;
      if (localObject != null) {
        ((b)localObject).d();
      }
    }
    else
    {
      localObject = this.g;
      if (localObject != null) {
        ((e)localObject).b();
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, @NotNull String paramString, @Nullable com.tencent.luggage.wxa.ih.c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNetSceneEndCallback errType:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" errCode:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" result");
    localStringBuilder.append(paramc);
    o.d("JsApiRequestSubscribeMessage", localStringBuilder.toString());
    boolean bool;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    this.h = bool;
    this.b = paramc;
    e();
  }
  
  public void b()
  {
    try
    {
      if ((this.h) && (this.b != null))
      {
        Object localObject1;
        Object localObject3;
        if (this.j == 0)
        {
          localObject1 = this.b;
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
          if (((com.tencent.luggage.wxa.ih.c)localObject1).i() != 0)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("fail:");
            localObject3 = this.b;
            if (localObject3 == null) {
              Intrinsics.throwNpe();
            }
            ((StringBuilder)localObject1).append(((com.tencent.luggage.wxa.ih.c)localObject3).j());
            localObject1 = ((StringBuilder)localObject1).toString();
            localObject3 = this.b;
            if (localObject3 == null) {
              Intrinsics.throwNpe();
            }
            a(this, (String)localObject1, null, ((com.tencent.luggage.wxa.ih.c)localObject3).i(), 2, null);
            return;
          }
        }
        int k = this.j;
        com.tencent.luggage.wxa.ih.c localc;
        if (k == 0)
        {
          localObject1 = this.f;
          if (localObject1 != null)
          {
            localObject3 = this.c;
            if (localObject3 == null) {
              Intrinsics.throwNpe();
            }
            localObject3 = ((com.tencent.luggage.wxa.du.c)localObject3).getContext();
            Intrinsics.checkExpressionValueIsNotNull(localObject3, "service!!.context");
            localc = this.b;
            if (localc == null) {
              Intrinsics.throwNpe();
            }
            ((b)localObject1).a((Context)localObject3, localc);
          }
        }
        else
        {
          localObject1 = this.g;
          if (localObject1 != null)
          {
            localObject3 = this.c;
            if (localObject3 == null) {
              Intrinsics.throwNpe();
            }
            localObject3 = ((com.tencent.luggage.wxa.du.c)localObject3).getContext();
            Intrinsics.checkExpressionValueIsNotNull(localObject3, "service!!.context");
            localc = this.b;
            if (localc == null) {
              Intrinsics.throwNpe();
            }
            ((e)localObject1).a((Context)localObject3, localc);
          }
        }
        return;
      }
      if (this.j == 0) {
        a(this, "fail:Request list fail", null, 10002, 2, null);
      } else {
        a(this, "fail:Request subscribe fail", null, 10003, 2, null);
      }
      return;
    }
    finally
    {
      f();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @Nullable
  public final com.tencent.luggage.wxa.ih.c h()
  {
    return this.b;
  }
  
  @Nullable
  public final e i()
  {
    return this.g;
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lc.d.b
 * JD-Core Version:    0.7.0.1
 */