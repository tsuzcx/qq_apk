package com.tencent.luggage.wxa.fe;

import com.tencent.luggage.wxa.jx.m;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/jsapi/facial/WxaFacialRecognitionVerifyAPIs;", "", "()V", "APIs", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "getAPIs", "()Ljava/util/List;", "APIs$delegate", "Lkotlin/Lazy;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class f
{
  public static final f a = new f();
  @NotNull
  private static final Lazy b = LazyKt.lazy((Function0)f.a.a);
  
  @NotNull
  public final List<m> a()
  {
    return (List)b.getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fe.f
 * JD-Core Version:    0.7.0.1
 */