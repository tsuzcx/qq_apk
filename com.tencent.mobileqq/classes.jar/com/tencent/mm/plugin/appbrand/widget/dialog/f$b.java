package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.mm.plugin.appbrand.ui.MaxHeightRecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$changeListHeightByRotation$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class f$b
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  f$b(double paramDouble) {}
  
  public void onGlobalLayout()
  {
    double d1 = this.b;
    int k = 0;
    int j = 0;
    while (d1 > 0)
    {
      Object localObject = f.a(this.a).getLayoutManager();
      if (localObject != null)
      {
        localObject = ((RecyclerView.LayoutManager)localObject).getChildAt(j);
        if (localObject != null)
        {
          i = ((View)localObject).getMeasuredHeight();
          break label87;
        }
      }
      localObject = this.a.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
      int i = ((Context)localObject).getResources().getDimensionPixelSize(2131296909);
      label87:
      if (d1 < 1)
      {
        double d2 = i;
        Double.isNaN(d2);
        i = (int)(d2 * d1);
      }
      k += i;
      d1 -= 1.0D;
      j += 1;
    }
    f.a(this.a).setMaxHeight(k);
    f.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.f.b
 * JD-Core Version:    0.7.0.1
 */