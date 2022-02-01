package com.tencent.luggage.wxa.da;

import com.tencent.luggage.wxa.ew.b;
import com.tencent.luggage.wxa.jj.j;
import com.tencent.luggage.wxa.ou.d;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/launch/task/WxaStartParams;", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "appId", "", "isGame", "", "versionType", "", "action", "Lcom/tencent/luggage/struct/LaunchContainerAction;", "statObject", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "referrer", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;", "(Ljava/lang/String;ZILcom/tencent/luggage/struct/LaunchContainerAction;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;)V", "getAction", "()Lcom/tencent/luggage/struct/LaunchContainerAction;", "getReferrer", "()Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;", "getStatObject", "()Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class h
  extends com.tencent.luggage.wxa.ea.h
{
  @NotNull
  private final b a;
  @Nullable
  private final d b;
  @Nullable
  private final j c;
  
  public h(@NotNull String paramString, boolean paramBoolean, int paramInt, @NotNull b paramb, @Nullable d paramd, @Nullable j paramj)
  {
    super(paramString, paramBoolean, paramInt);
    this.a = paramb;
    this.b = paramd;
    this.c = paramj;
  }
  
  @NotNull
  public final b a()
  {
    return this.a;
  }
  
  @Nullable
  public final d b()
  {
    return this.b;
  }
  
  @Nullable
  public final j c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.da.h
 * JD-Core Version:    0.7.0.1
 */