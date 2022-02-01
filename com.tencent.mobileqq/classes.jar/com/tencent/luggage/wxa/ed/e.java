package com.tencent.luggage.wxa.ed;

import android.content.res.Configuration;
import com.tencent.luggage.wxa.do.c;
import com.tencent.luggage.wxa.jj.a;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/sdk/runtime/IAppBrandWindowLayoutManager;", "C", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "", "init", "", "initConfig", "(Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;)V", "onAppConfigGot", "appConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandAppConfig;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onInitConfigUpdated", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public abstract interface e<C extends c>
{
  public abstract void a(@NotNull Configuration paramConfiguration);
  
  public abstract void a(@NotNull C paramC);
  
  public abstract void a(@NotNull a parama);
  
  public abstract void b(@NotNull C paramC);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ed.e
 * JD-Core Version:    0.7.0.1
 */