package com.tencent.mm.msgsubscription.ui;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$applyRotation$6", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 1, 16})
public final class a$h
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public void onGlobalLayout()
  {
    a.e(this.a).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
    a locala = this.a;
    a.a(locala, a.f(locala));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.a.h
 * JD-Core Version:    0.7.0.1
 */