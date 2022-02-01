package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.qw.fa;
import com.tencent.luggage.wxa.qw.fb;
import com.tencent.luggage.wxa.qw.gt;
import com.tencent.luggage.wxa.rl.b;
import com.tencent.luggage.wxa.ro.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/launch/CgiLaunchWxaApp;", "Lcom/tencent/luggage/login/CgiEx;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppRequest;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "()V", "URL", "", "getURL", "()Ljava/lang/String;", "<set-?>", "Ljava/lang/Class;", "responseClazz", "getResponseClazz", "()Ljava/lang/Class;", "setResponseClazz", "(Ljava/lang/Class;)V", "runPipeline", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "appId", "request", "clazz", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public abstract class c
  extends com.tencent.luggage.wxa.dc.c<fa, fb>
{
  @NotNull
  private final String a = "/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp";
  @NotNull
  private Class<fb> b = fb.class;
  
  @NotNull
  public d<fb> a(@Nullable String paramString, @NotNull fa paramfa, @NotNull Class<fb> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramfa, "request");
    Intrinsics.checkParameterIsNotNull(paramClass, "clazz");
    paramString = super.a(paramString, (gt)paramfa, paramClass).a((b)new c.a(paramfa));
    Intrinsics.checkExpressionValueIsNotNull(paramString, "super.runPipeline(appId,…xt response\n            }");
    return paramString;
  }
  
  @NotNull
  public String a()
  {
    return this.a;
  }
  
  @NotNull
  public final Class<fb> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.c
 * JD-Core Version:    0.7.0.1
 */