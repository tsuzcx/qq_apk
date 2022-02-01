package com.tencent.luggage.wxa.lt;

import com.tencent.luggage.wxa.jx.c;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$Entry;", "", "id", "", "type", "content", "", "priority", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "(IILjava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)V", "appId", "getAppId", "()Ljava/lang/String;", "getComponent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "componentRef", "Ljava/lang/ref/WeakReference;", "componentRef$annotations", "()V", "getContent", "getId", "()I", "getPriority", "()Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "triedCount", "getTriedCount", "setTriedCount", "(I)V", "getType", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class g$d
{
  private final WeakReference<c> a;
  @NotNull
  private final String b;
  private int c;
  private final int d;
  private final int e;
  @NotNull
  private final String f;
  @NotNull
  private final b.c g;
  
  public g$d(int paramInt1, int paramInt2, @NotNull String paramString, @NotNull b.c paramc, @NotNull c paramc1)
  {
    this.d = paramInt1;
    this.e = paramInt2;
    this.f = paramString;
    this.g = paramc;
    this.a = new WeakReference(paramc1);
    paramString = paramc1.getAppId();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "component.appId");
    this.b = paramString;
  }
  
  @NotNull
  public final String a()
  {
    return this.b;
  }
  
  public final void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  @Nullable
  public final c b()
  {
    return (c)this.a.get();
  }
  
  public final int c()
  {
    return this.c;
  }
  
  public final int d()
  {
    return this.d;
  }
  
  public final int e()
  {
    return this.e;
  }
  
  @NotNull
  public final String f()
  {
    return this.f;
  }
  
  @NotNull
  public final b.c g()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lt.g.d
 * JD-Core Version:    0.7.0.1
 */