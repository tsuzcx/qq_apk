package com.tencent.luggage.wxa.ds;

import android.view.View;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jx.f.b;
import com.tencent.luggage.wxa.jx.f.c;
import com.tencent.luggage.wxa.jx.f.d;
import com.tencent.luggage.wxa.jx.y;
import com.tencent.luggage.wxa.pp.n;
import com.tencent.luggage.wxa.pp.u.c;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/sdk/jsapi/component/page/AppBrandPageViewKeyboardHeightEmitter;", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandKeyboardListener$OnKeyboardStateChangedListener;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnForegroundListener;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnBackgroundListener;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnDestroyListener;", "mPageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "mEvent", "Lcom/tencent/mm/plugin/appbrand/jsapi/EventOnKeyboardHeightChange;", "mIsKeyboardShowing", "", "mRegistry", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandKeyboardListener;", "mSavedKeyboardHeight", "", "getHeight", "onBackground", "", "onDestroy", "onForeground", "onKeyboardStateChanged", "shown", "refreshHeight", "height", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class b
  implements f.b, f.c, f.d, u.c
{
  public static final b.a a = new b.a(null);
  private final y b;
  private int c;
  private com.tencent.luggage.wxa.pp.u d;
  private boolean e;
  private final com.tencent.mm.plugin.appbrand.page.u f;
  
  private b(com.tencent.mm.plugin.appbrand.page.u paramu)
  {
    this.f = paramu;
    this.b = new y();
  }
  
  @JvmStatic
  public static final void a(@NotNull com.tencent.mm.plugin.appbrand.page.u paramu)
  {
    a.a(paramu);
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    y localy = this.b;
    int i;
    if (paramBoolean) {
      i = this.c;
    } else {
      i = 0;
    }
    h localh = this.f.p();
    Intrinsics.checkExpressionValueIsNotNull(localh, "mPageView.service");
    y.a(localy, i, localh, this.f, null, 8, null);
  }
  
  public void b()
  {
    if (this.e)
    {
      localObject = this.b;
      h localh = this.f.p();
      Intrinsics.checkExpressionValueIsNotNull(localh, "mPageView.service");
      y.a((y)localObject, 0, localh, this.f, null, 8, null);
    }
    Object localObject = this.d;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.pp.u)localObject).b((u.c)this);
    }
  }
  
  public void c()
  {
    if (this.f.getContentView() != null)
    {
      Object localObject = this.f.getContentView();
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      this.d = n.c((View)localObject);
      localObject = this.d;
      if (localObject != null) {
        ((com.tencent.luggage.wxa.pp.u)localObject).a((u.c)this);
      }
    }
  }
  
  public void d()
  {
    com.tencent.luggage.wxa.pp.u localu = this.d;
    if (localu != null) {
      localu.b((u.c)this);
    }
  }
  
  public int getHeight()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ds.b
 * JD-Core Version:    0.7.0.1
 */