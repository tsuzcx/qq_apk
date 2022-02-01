package com.tencent.mm.plugin.appbrand.appcache;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap$Namespace$MODULE;", "", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public final class ai$c$a
{
  @NotNull
  private final String a;
  
  public ai$c$a(@NotNull String paramString)
  {
    paramString = af.b(paramString);
    if (paramString == null) {
      Intrinsics.throwNpe();
    }
    this.a = paramString;
  }
  
  @NotNull
  public final String a()
  {
    return this.a;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool = paramObject instanceof a;
    Object localObject = null;
    if (!bool) {
      paramObject = null;
    }
    a locala = (a)paramObject;
    paramObject = localObject;
    if (locala != null) {
      paramObject = locala.a;
    }
    return Intrinsics.areEqual(paramObject, this.a);
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ai.c.a
 * JD-Core Version:    0.7.0.1
 */