package com.tencent.mm.plugin.appbrand.page;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.FrameLayout;
import com.tencent.luggage.wxa.qz.o;
import java.util.ConcurrentModificationException;

class av$1
  implements View.OnLayoutChangeListener
{
  av$1(av paramav) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (TextUtils.isEmpty(av.a(this.a).an())) {
      return;
    }
    if (av.b(this.a)) {}
    try
    {
      av.a(this.a).ag().removeOnLayoutChangeListener(this);
      return;
    }
    catch (ConcurrentModificationException paramView)
    {
      label42:
      break label42;
    }
    av.a(this.a).b(new av.1.1(this, this));
    return;
    o.d("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "pageArea onLayoutChange appId[%s], url[%s], frozen[%b]", new Object[] { av.a(this.a).getAppId(), av.a(this.a).an(), Boolean.valueOf(av.c(this.a)) });
    if (av.c(this.a))
    {
      av.a(this.a, true);
      return;
    }
    av.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.av.1
 * JD-Core Version:    0.7.0.1
 */