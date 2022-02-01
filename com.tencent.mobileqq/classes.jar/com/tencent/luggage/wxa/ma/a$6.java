package com.tencent.luggage.wxa.ma;

import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;

class a$6
  implements e.e
{
  a$6(a parama) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 0) {
      return;
    }
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    paramInt1 = i;
    if (i > paramInt2) {
      paramInt1 = paramInt2;
    }
    paramInt1 = paramInt1 * a.J(this.a).getWidth() / paramInt2;
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)a.K(this.a).getLayoutParams();
    localLayoutParams.width = paramInt1;
    a.K(this.a).setLayoutParams(localLayoutParams);
    a.K(this.a).requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ma.a.6
 * JD-Core Version:    0.7.0.1
 */