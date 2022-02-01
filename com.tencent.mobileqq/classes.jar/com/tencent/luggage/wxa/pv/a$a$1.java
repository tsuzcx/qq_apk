package com.tencent.luggage.wxa.pv;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;

class a$a$1
  extends View
{
  a$a$1(a.a parama, Context paramContext)
  {
    super(paramContext);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a.a.a(this.a, true);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    a.a.a(this.a, false);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (a.a.a(this.a) > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(a.a.a(this.a), 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pv.a.a.1
 * JD-Core Version:    0.7.0.1
 */