package com.tencent.luggage.opensdk;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/opensdk/QRCodeDisplayDialog$2", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class k$1
  implements View.OnAttachStateChangeListener
{
  public void onViewAttachedToWindow(@Nullable View paramView)
  {
    if (paramView != null)
    {
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      if (localLayoutParams != null)
      {
        int[] arrayOfInt = new int[2];
        Context localContext = paramView.getContext();
        Intrinsics.checkExpressionValueIsNotNull(localContext, "v.context");
        arrayOfInt[0] = l.a(localContext, 303.70001F);
        localContext = paramView.getContext();
        Intrinsics.checkExpressionValueIsNotNull(localContext, "v.context");
        arrayOfInt[1] = l.a(localContext, 326.70001F);
        localContext = this.a.getContext();
        Intrinsics.checkExpressionValueIsNotNull(localContext, "getContext()");
        Object localObject = this.a.getContext();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "getContext()");
        localObject = ((Context)localObject).getResources();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "getContext().resources");
        localObject = ((Resources)localObject).getDisplayMetrics();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "getContext().resources.displayMetrics");
        m.a(localContext, arrayOfInt, (DisplayMetrics)localObject);
        localLayoutParams.height = arrayOfInt[1];
        localLayoutParams.width = arrayOfInt[0];
        paramView.requestLayout();
      }
    }
  }
  
  public void onViewDetachedFromWindow(@Nullable View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.k.1
 * JD-Core Version:    0.7.0.1
 */