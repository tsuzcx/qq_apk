package com.tencent.luggage.wxa.ed;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/sdk/runtime/AppBrandCenterInsideWindowLayoutManager$onConfigurationChanged$1", "Lcom/tencent/luggage/sdk/runtime/AppBrandCenterInsideWindowLayoutManager$OnLayoutChangeListenerWithCounter;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "counter", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class a$e
  extends a.a
{
  public void a(@Nullable View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    if (paramInt9 == 10)
    {
      this.a.b().removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      return;
    }
    if ((paramInt1 == paramInt2) && (paramInt1 == paramInt4) && (paramInt1 == paramInt3)) {
      paramInt9 = 1;
    } else {
      paramInt9 = 0;
    }
    if ((paramInt1 == paramInt5) && (paramInt3 == paramInt7) && (paramInt4 == paramInt8) && (paramInt2 == paramInt6) && (paramInt9 == 0))
    {
      o.d("Luggage.AppBrandWindowLayoutManager", "onLayoutChange: no changed, ignore");
      return;
    }
    if (this.a.c() != null) {
      a.a(this.a, "onConfigurationChanged", false, 2, null);
    }
    this.a.b().removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ed.a.e
 * JD-Core Version:    0.7.0.1
 */