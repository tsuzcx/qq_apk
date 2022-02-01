package com.tencent.mm.plugin.appbrand.page;

import android.util.Log;
import com.tencent.luggage.wxa.oi.f;
import com.tencent.luggage.wxa.oi.f.a;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPullDownExtension;", "mPageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "mPullDownWrapper", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPullDownWebView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPullDownWebView;)V", "TAG", "", "enablePullDown", "", "enable", "", "enablePullDownRefresh", "getPullDownBackgroundColor", "", "requestDisallowInterceptTouchEvent", "disallow", "runOnUiThread", "block", "Lkotlin/Function0;", "setPullDownBackground", "style", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPullDownExtension$BackgroundTextStyle;", "color", "colorStr", "setPullDownBackgroundStyle", "setPullDownText", "text", "startPullDownRefresh", "stopPullDownRefresh", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public class aw
  implements f
{
  private final String a;
  private final u b;
  private final y c;
  
  public aw(@NotNull u paramu, @NotNull y paramy)
  {
    this.b = paramu;
    this.c = paramy;
    this.a = "Luggage.MPPageViewPullDownExtensionImpl";
  }
  
  public void a()
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppBrandPullDown invoke entered startPullDownRefresh appId:");
    localStringBuilder.append(this.b.getAppId());
    localStringBuilder.append(" url:");
    localStringBuilder.append(this.b.an());
    o.d(str, localStringBuilder.toString());
    if (!b(this).d())
    {
      str = a(this);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("runOnUiThread PageView destroyed, stack=");
      localStringBuilder.append(Log.getStackTraceString(new Throwable()));
      o.b(str, localStringBuilder.toString());
      return;
    }
    b(this).a((Runnable)new aw.g(this, this));
  }
  
  public void a(@NotNull f.a parama, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(parama, "style");
    if (!b(this).d())
    {
      parama = a(this);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("runOnUiThread PageView destroyed, stack=");
      localStringBuilder.append(Log.getStackTraceString(new Throwable()));
      o.b(parama, localStringBuilder.toString());
      return;
    }
    b(this).a((Runnable)new aw.c(this, this, parama, paramInt));
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "style");
    if (!b(this).d())
    {
      paramString = a(this);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("runOnUiThread PageView destroyed, stack=");
      localStringBuilder.append(Log.getStackTraceString(new Throwable()));
      o.b(paramString, localStringBuilder.toString());
      return;
    }
    b(this).a((Runnable)new aw.e(this, this, paramString));
  }
  
  public void a(@Nullable String paramString1, @Nullable String paramString2)
  {
    if (!b(this).d())
    {
      paramString1 = a(this);
      paramString2 = new StringBuilder();
      paramString2.append("runOnUiThread PageView destroyed, stack=");
      paramString2.append(Log.getStackTraceString(new Throwable()));
      o.b(paramString1, paramString2.toString());
      return;
    }
    b(this).a((Runnable)new aw.d(this, this, paramString1, paramString2));
  }
  
  public void a(boolean paramBoolean)
  {
    if (!b(this).d())
    {
      String str = a(this);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("runOnUiThread PageView destroyed, stack=");
      localStringBuilder.append(Log.getStackTraceString(new Throwable()));
      o.b(str, localStringBuilder.toString());
      return;
    }
    b(this).a((Runnable)new aw.b(this, this, paramBoolean));
  }
  
  public void b()
  {
    if (!b(this).d())
    {
      String str = a(this);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("runOnUiThread PageView destroyed, stack=");
      localStringBuilder.append(Log.getStackTraceString(new Throwable()));
      o.b(str, localStringBuilder.toString());
      return;
    }
    b(this).a((Runnable)new aw.h(this, this));
  }
  
  public void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    if (!b(this).d())
    {
      paramString = a(this);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("runOnUiThread PageView destroyed, stack=");
      localStringBuilder.append(Log.getStackTraceString(new Throwable()));
      o.b(paramString, localStringBuilder.toString());
      return;
    }
    b(this).a((Runnable)new aw.f(this, this, paramString));
  }
  
  public void b(boolean paramBoolean)
  {
    if (!b(this).d())
    {
      String str = a(this);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("runOnUiThread PageView destroyed, stack=");
      localStringBuilder.append(Log.getStackTraceString(new Throwable()));
      o.b(str, localStringBuilder.toString());
      return;
    }
    b(this).a((Runnable)new aw.a(this, this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.aw
 * JD-Core Version:    0.7.0.1
 */