package com.tencent.mm.msgsubscription.ui;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "onGlobalLayout"}, k=3, mv={1, 1, 16})
final class a$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  a$2(a parama) {}
  
  public final void onGlobalLayout()
  {
    if (a.h(this.a).getHeight() > 0) {
      a.c(this.a).getLayoutParams().height = a.h(this.a).getHeight();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.a.2
 * JD-Core Version:    0.7.0.1
 */