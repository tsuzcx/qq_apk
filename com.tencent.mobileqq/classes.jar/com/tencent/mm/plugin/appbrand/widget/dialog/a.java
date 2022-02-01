package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.qz.l;

final class a
  extends FrameLayout
{
  public a(@NonNull Context paramContext, @NonNull View paramView)
  {
    super(paramContext);
    addView(paramView);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if ((getParent() instanceof View))
    {
      i = paramInt2;
      if (((View)getParent()).getMeasuredHeight() > 0)
      {
        Context localContext = getContext();
        if (l.e(getContext())) {
          paramInt2 = 173;
        } else {
          paramInt2 = 24;
        }
        paramInt2 = com.tencent.luggage.wxa.qx.a.e(localContext, paramInt2);
        i = View.MeasureSpec.makeMeasureSpec(((View)getParent()).getMeasuredHeight() - paramInt2, -2147483648);
      }
    }
    super.onMeasure(paramInt1, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.a
 * JD-Core Version:    0.7.0.1
 */