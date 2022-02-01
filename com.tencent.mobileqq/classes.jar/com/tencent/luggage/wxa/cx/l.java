package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.util.g;
import com.tencent.luggage.wxa.ef.c;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/launch/WxaHostNativeExtraData;", "", "json", "", "(Ljava/lang/String;)V", "map", "", "(Ljava/util/Map;)V", "host_scene", "", "getHost_scene", "()I", "", "toJsonString", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class l
{
  private final Map<String, Object> a;
  
  public l(@NotNull String paramString)
  {
    this(c.b(new JSONObject(paramString)));
  }
  
  public l(@NotNull Map<String, ? extends Object> paramMap)
  {
    this.a = MapsKt.withDefaultMutable((Map)new HashMap(paramMap), (Function1)l.a.a);
  }
  
  @NotNull
  public final String a()
  {
    g.a(this.a);
    String str = new JSONObject(this.a).toString(0);
    Intrinsics.checkExpressionValueIsNotNull(str, "JSONObject(map).toString(0)");
    return str;
  }
  
  public final int b()
  {
    Object localObject2 = this.a.get("host_scene");
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof Integer)) {
      localObject1 = null;
    }
    localObject1 = (Integer)localObject1;
    if (localObject1 != null) {
      return ((Integer)localObject1).intValue();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.l
 * JD-Core Version:    0.7.0.1
 */