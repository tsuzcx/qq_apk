package com.tencent.luggage.wxa.dc;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.ob.b;
import com.tencent.luggage.wxa.qw.gt;
import com.tencent.luggage.wxa.qw.gu;
import com.tencent.luggage.wxa.ro.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/Cgi;", "REQUEST", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "RESPONSE", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "", "()V", "URL", "", "getURL", "()Ljava/lang/String;", "dispatcher", "Lcom/tencent/mm/plugin/appbrand/networking/ICgiService;", "getDispatcher", "()Lcom/tencent/mm/plugin/appbrand/networking/ICgiService;", "setDispatcher", "(Lcom/tencent/mm/plugin/appbrand/networking/ICgiService;)V", "runPipeline", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "appId", "request", "clazz", "Ljava/lang/Class;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;Ljava/lang/Class;)Lcom/tencent/mm/vending/pipeline/Pipeable;", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public abstract class a<REQUEST extends gt, RESPONSE extends gu>
{
  @Nullable
  private b a;
  
  @NotNull
  public d<RESPONSE> a(@Nullable String paramString, @NotNull REQUEST paramREQUEST, @NotNull Class<RESPONSE> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramREQUEST, "request");
    Intrinsics.checkParameterIsNotNull(paramClass, "clazz");
    b localb = this.a;
    if (localb == null) {
      localb = (b)e.a(b.class);
    }
    paramString = localb.b(a(), paramString, (com.tencent.luggage.wxa.qu.a)paramREQUEST, paramClass);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "(dispatcher ?: Luggage.c…L, appId, request, clazz)");
    return paramString;
  }
  
  @NotNull
  public abstract String a();
  
  public final void a(@Nullable b paramb)
  {
    this.a = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.a
 * JD-Core Version:    0.7.0.1
 */