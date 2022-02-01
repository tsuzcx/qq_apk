package com.tencent.luggage.wxa.fv;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/tdi/DemoIlinkActivateParams;", "", "()V", "<set-?>", "", "deviceId", "getDeviceId", "()Ljava/lang/String;", "setDeviceId", "(Ljava/lang/String;)V", "deviceId$delegate", "Ljava/util/Map;", "hostAppId", "getHostAppId", "setHostAppId", "hostAppId$delegate", "ilinkId", "getIlinkId", "setIlinkId", "ilinkId$delegate", "map", "", "", "productId", "getProductId", "()I", "setProductId", "(I)V", "productId$delegate", "toString", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class d
{
  private final Map<String, Object> b = MapsKt.withDefaultMutable((Map)new HashMap(), (Function1)d.a.a);
  @NotNull
  private final Map c;
  @NotNull
  private final Map d;
  @NotNull
  private final Map e;
  @NotNull
  private final Map f;
  
  public d()
  {
    Map localMap = this.b;
    this.c = localMap;
    this.d = localMap;
    this.e = localMap;
    this.f = localMap;
  }
  
  public final int a()
  {
    return ((Number)MapsKt.getOrImplicitDefaultNullable(this.c, a[0].getName())).intValue();
  }
  
  public final void a(int paramInt)
  {
    this.c.put(a[0].getName(), Integer.valueOf(paramInt));
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.d.put(a[1].getName(), paramString);
  }
  
  @NotNull
  public final String b()
  {
    return (String)MapsKt.getOrImplicitDefaultNullable(this.d, a[1].getName());
  }
  
  public final void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.e.put(a[2].getName(), paramString);
  }
  
  @NotNull
  public final String c()
  {
    return (String)MapsKt.getOrImplicitDefaultNullable(this.e, a[2].getName());
  }
  
  public final void c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.f.put(a[3].getName(), paramString);
  }
  
  @NotNull
  public final String d()
  {
    return (String)MapsKt.getOrImplicitDefaultNullable(this.f, a[3].getName());
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DemoIlinkActivateParams{");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fv.d
 * JD-Core Version:    0.7.0.1
 */