package com.tencent.luggage.wxa.cq;

import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/jsapi/share/EventOnShareTimeline;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "fields", "", "", "", "<set-?>", "path", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "path$delegate", "Ljava/util/Map;", "title", "getTitle", "setTitle", "title$delegate", "dispatch", "", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class b
  extends ah
{
  public static final int CTRL_INDEX = 76;
  @NotNull
  public static final String NAME = "onShareTimeline";
  public static final b.a b = new b.a(null);
  private final Map<String, Object> c = MapsKt.withDefaultMutable((Map)new HashMap(), (Function1)b.b.a);
  @Nullable
  private final Map d;
  @Nullable
  private final Map e;
  
  public b()
  {
    Map localMap = this.c;
    this.d = localMap;
    this.e = localMap;
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
    o.d("Luggage.WXA.EventOnShareTimeline", localStringBuilder.toString());
    super.a();
  }
  
  public final void a(@Nullable String paramString)
  {
    this.d.put(a[0].getName(), paramString);
  }
  
  public final void b_(@Nullable String paramString)
  {
    this.e.put(a[1].getName(), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cq.b
 * JD-Core Version:    0.7.0.1
 */