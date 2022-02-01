package com.tencent.luggage.wxa.cq;

import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/jsapi/share/EventOnShareAppMessage;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "<set-?>", "", "desc", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "desc$delegate", "Ljava/util/Map;", "", "dynamic", "getDynamic", "()Z", "setDynamic", "(Z)V", "dynamic$delegate", "fields", "", "", "imgUrl", "getImgUrl", "setImgUrl", "imgUrl$delegate", "mode", "getMode", "setMode", "mode$delegate", "path", "getPath", "setPath", "path$delegate", "title", "getTitle", "setTitle", "title$delegate", "webViewUrl", "getWebViewUrl", "setWebViewUrl", "webViewUrl$delegate", "dispatch", "", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class a
  extends ah
{
  public static final int CTRL_INDEX = 75;
  @NotNull
  public static final String NAME = "onShareAppMessage";
  public static final a.a b = new a.a(null);
  private final Map<String, Object> c = MapsKt.withDefaultMutable((Map)new HashMap(), (Function1)a.b.a);
  @Nullable
  private final Map d;
  @Nullable
  private final Map e;
  @Nullable
  private final Map f;
  @Nullable
  private final Map g;
  @Nullable
  private final Map h;
  @NotNull
  private final Map i;
  @NotNull
  private final Map j;
  
  public a()
  {
    Map localMap = this.c;
    this.d = localMap;
    this.e = localMap;
    this.f = localMap;
    this.g = localMap;
    this.h = localMap;
    this.i = localMap;
    this.j = localMap;
  }
  
  public void a()
  {
    b(this.c);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dispatch with src:");
    localStringBuilder.append(e());
    localStringBuilder.append(", dest:");
    localStringBuilder.append(f());
    localStringBuilder.append(", data:");
    localStringBuilder.append(c());
    o.d("Luggage.WXA.EventOnShareAppMessage", localStringBuilder.toString());
    super.a();
  }
  
  public final void a(@Nullable String paramString)
  {
    this.d.put(a[0].getName(), paramString);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.j.put(a[6].getName(), Boolean.valueOf(paramBoolean));
  }
  
  public final void a_(@Nullable String paramString)
  {
    this.e.put(a[1].getName(), paramString);
  }
  
  public final void c(@Nullable String paramString)
  {
    this.f.put(a[2].getName(), paramString);
  }
  
  public final void d(@Nullable String paramString)
  {
    this.g.put(a[3].getName(), paramString);
  }
  
  public final void e(@Nullable String paramString)
  {
    this.h.put(a[4].getName(), paramString);
  }
  
  public final void f(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.i.put(a[5].getName(), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cq.a
 * JD-Core Version:    0.7.0.1
 */