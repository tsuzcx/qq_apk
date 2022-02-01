package com.tencent.luggage.wxa.lj;

import android.util.Base64;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.qz.o;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiEventOnNFCDiscovered;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "dispatch", "", "id", "", "techs", "", "", "data", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "setContext", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "Companion", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 1, 16})
public final class c
  extends ah
{
  public static final int CTRL_INDEX = 790;
  @NotNull
  public static final String NAME = "onNFCDiscovered";
  public static final c.a a = new c.a(null);
  
  @NotNull
  public c a(@Nullable com.tencent.luggage.wxa.jx.c paramc)
  {
    paramc = super.b(paramc);
    if (paramc != null) {
      return (c)paramc;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.JsApiEventOnNFCDiscovered");
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dispatch, data: ");
    localStringBuilder.append(c());
    o.e("MicroMsg.AppBrand.JsApiEventOnNFCDiscovered", localStringBuilder.toString());
    super.a();
  }
  
  public final void a(@Nullable byte[] paramArrayOfByte, @NotNull List<String> paramList, @Nullable HashMap<String, Object> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "techs");
    if (paramArrayOfByte == null) {
      paramArrayOfByte = new byte[0];
    }
    paramArrayOfByte = Base64.encode(paramArrayOfByte, 2);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "Base64.encode(id ?: ByteArray(0), Base64.NO_WRAP)");
    Charset localCharset = StandardCharsets.UTF_8;
    Intrinsics.checkExpressionValueIsNotNull(localCharset, "StandardCharsets.UTF_8");
    paramArrayOfByte = new String(paramArrayOfByte, localCharset);
    if (paramHashMap != null)
    {
      paramHashMap.put("id", paramArrayOfByte);
      paramHashMap.put("techs", paramList);
      if (paramHashMap != null)
      {
        paramArrayOfByte = (Map)paramHashMap;
        break label110;
      }
    }
    paramArrayOfByte = MapsKt.mapOf(new Pair[] { TuplesKt.to("id", paramArrayOfByte), TuplesKt.to("techs", paramList) });
    label110:
    b(paramArrayOfByte).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lj.c
 * JD-Core Version:    0.7.0.1
 */