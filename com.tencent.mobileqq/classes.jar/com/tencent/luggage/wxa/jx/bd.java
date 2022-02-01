package com.tencent.luggage.wxa.jx;

import com.tencent.luggage.wxa.iu.h;
import com.tencent.mm.plugin.appbrand.page.u;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/WxaComponentAdapter;", "", "()V", "asPage", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "asService", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public final class bd
{
  public static final bd a = new bd();
  
  @JvmStatic
  @Nullable
  public static final u a(@Nullable c paramc)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramc != null)
    {
      if ((paramc instanceof u)) {
        return (u)paramc;
      }
      localObject1 = localObject2;
      if ((paramc instanceof h)) {
        localObject1 = ((h)paramc).v();
      }
    }
    return localObject1;
  }
  
  @JvmStatic
  @Nullable
  public static final h b(@Nullable c paramc)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramc != null)
    {
      if ((paramc instanceof u)) {
        return ((u)paramc).p();
      }
      localObject1 = localObject2;
      if ((paramc instanceof h)) {
        localObject1 = (h)paramc;
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.bd
 * JD-Core Version:    0.7.0.1
 */