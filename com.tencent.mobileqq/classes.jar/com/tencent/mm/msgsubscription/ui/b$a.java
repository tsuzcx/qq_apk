package com.tencent.mm.msgsubscription.ui;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialogKt$onPreDrawOnce$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 1, 16})
public final class b$a
  implements ViewTreeObserver.OnPreDrawListener
{
  b$a(View paramView, Function0 paramFunction0) {}
  
  public boolean onPreDraw()
  {
    ViewTreeObserver localViewTreeObserver = this.a.getViewTreeObserver();
    Intrinsics.checkExpressionValueIsNotNull(localViewTreeObserver, "this@onPreDrawOnce.viewTreeObserver");
    if (localViewTreeObserver.isAlive()) {
      this.a.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
    }
    this.b.invoke();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.b.a
 * JD-Core Version:    0.7.0.1
 */