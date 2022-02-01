package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"}, k=3, mv={1, 1, 16})
public final class aw$g
  implements Runnable
{
  public aw$g(aw paramaw1, aw paramaw2) {}
  
  public final void run()
  {
    if (!aw.b(this.a).d())
    {
      o.b(aw.a(this.a), "runOnUiThread in ui-thread PageView destroyed");
      return;
    }
    Object localObject1 = aw.a(this.b);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("AppBrandPullDown OnUiThread startPullDownRefresh appId:");
    ((StringBuilder)localObject2).append(aw.b(this.b).getAppId());
    ((StringBuilder)localObject2).append(" url:");
    ((StringBuilder)localObject2).append(aw.b(this.b).an());
    o.d((String)localObject1, ((StringBuilder)localObject2).toString());
    try
    {
      localObject1 = aw.b(this.b).aj();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "mPageView.webView");
      if (((am)localObject1).getWebScrollY() != 0) {
        aw.b(this.b).aj().g();
      }
      aw.c(this.b).a(true);
      aw.c(this.b).b();
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      localObject2 = aw.a(this.b);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AppBrandPullDown OnUiThread startPullDownRefresh appId:");
      localStringBuilder.append(aw.b(this.b).getAppId());
      localStringBuilder.append(" url:");
      localStringBuilder.append(aw.b(this.b).an());
      localStringBuilder.append(" e:");
      localStringBuilder.append(localNullPointerException);
      o.b((String)localObject2, localStringBuilder.toString());
      throw ((Throwable)localNullPointerException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.aw.g
 * JD-Core Version:    0.7.0.1
 */