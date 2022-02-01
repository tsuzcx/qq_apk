package com.tencent.mm.plugin.appbrand.appcache;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap$Namespace$PLUGIN;", "", "provider", "", "(Ljava/lang/String;)V", "getProvider", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public final class ai$c$b
{
  @NotNull
  private final String a;
  
  public ai$c$b(@NotNull String paramString)
  {
    this.a = paramString;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool = paramObject instanceof b;
    Object localObject = null;
    if (!bool) {
      paramObject = null;
    }
    b localb = (b)paramObject;
    paramObject = localObject;
    if (localb != null) {
      paramObject = localb.a;
    }
    return Intrinsics.areEqual(paramObject, this.a);
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PLUGIN(provider=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ai.c.b
 * JD-Core Version:    0.7.0.1
 */