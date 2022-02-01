package com.tencent.luggage.wxa.fe;

import com.tencent.luggage.opensdk.d;
import com.tencent.luggage.opensdk.i;
import kotlin.Metadata;
import kotlin.Triple;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/jsapi/facial/JsApiCheckIsSupportFacialRecognition$FacialCapabilityDetector;", "", "()V", "checkIsSupport", "Lkotlin/Triple;", "", "", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class a$b
{
  public static final b a = new b();
  
  @NotNull
  public final Triple<Integer, String, Integer> a()
  {
    boolean bool = d.a();
    Integer localInteger = Integer.valueOf(0);
    if (!bool) {
      return new Triple(Integer.valueOf(10002), "No necessary model found", localInteger);
    }
    Triple localTriple = i.a.b();
    if (localTriple != null) {
      return localTriple;
    }
    return new Triple(localInteger, "ok", Integer.valueOf(1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fe.a.b
 * JD-Core Version:    0.7.0.1
 */