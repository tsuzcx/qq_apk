package com.tencent.mm.msgsubscription.ui;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.luggage.wxa.qz.r;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "onGlobalLayout"}, k=3, mv={1, 1, 16})
final class a$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  a$1(a parama) {}
  
  public final void onGlobalLayout()
  {
    Object localObject = a.e(this.a).getParent();
    if (localObject != null) {
      if (localObject != null)
      {
        localObject = (ViewGroup)localObject;
        int i = a.g(this.a);
        if ((i != 1) && (i != 3))
        {
          i = ((ViewGroup)localObject).getHeight() - com.tencent.luggage.wxa.qx.a.e(r.a(), 60);
          if (a.e(this.a).getHeight() > i)
          {
            a.e(this.a).getLayoutParams().height = Math.min(i, a.e(this.a).getHeight());
            a.e(this.a).requestLayout();
          }
        }
        else if (a.e(this.a).getLayoutParams().height != -2)
        {
          a.e(this.a).getLayoutParams().height = -2;
          a.e(this.a).requestLayout();
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.a.1
 * JD-Core Version:    0.7.0.1
 */