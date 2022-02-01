package com.tencent.luggage.wxa.nl;

import com.tencent.mm.plugin.appbrand.appcache.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "", "pkgInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "source", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE;", "(Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE;)V", "getPkgInfo", "()Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "getSource", "()Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class j$e
{
  @NotNull
  private final e a;
  @NotNull
  private final j.f b;
  
  public j$e(@NotNull e parame, @NotNull j.f paramf)
  {
    this.a = parame;
    this.b = paramf;
  }
  
  @NotNull
  public final e a()
  {
    return this.a;
  }
  
  @NotNull
  public final j.f b()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof e))
      {
        paramObject = (e)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.b;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Response(pkgInfo=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", source=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.j.e
 * JD-Core Version:    0.7.0.1
 */