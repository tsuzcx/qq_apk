package com.tencent.luggage.wxa.or;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref.IntRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandlerProxyImplKt$ensureGlobalLayoutAtRepeatCount$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public final class e$a
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  e$a(View paramView, Ref.IntRef paramIntRef, int paramInt, Function0 paramFunction0) {}
  
  public void onGlobalLayout()
  {
    Ref.IntRef localIntRef = this.b;
    localIntRef.element += 1;
    if (localIntRef.element < this.c) {
      return;
    }
    this.a.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
    this.d.invoke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.or.e.a
 * JD-Core Version:    0.7.0.1
 */