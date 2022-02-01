package com.tencent.gdtad.basics.motivevideo.elements;

import android.view.View;
import android.widget.RelativeLayout.LayoutParams;

class GdtMvViewAnimationAbs$2
  implements Runnable
{
  GdtMvViewAnimationAbs$2(GdtMvViewAnimationAbs paramGdtMvViewAnimationAbs, RelativeLayout.LayoutParams paramLayoutParams, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, View paramView) {}
  
  public void run()
  {
    Object localObject = this.a;
    ((RelativeLayout.LayoutParams)localObject).topMargin = (this.b + (int)(this.c * 1.0F));
    ((RelativeLayout.LayoutParams)localObject).leftMargin = (this.d + (int)(this.e * 1.0F));
    int i = this.f;
    if (i == -1)
    {
      i = ((RelativeLayout.LayoutParams)localObject).leftMargin;
    }
    else
    {
      int j = this.g;
      i = (int)(i * 1.0F) + j;
    }
    ((RelativeLayout.LayoutParams)localObject).rightMargin = i;
    localObject = this.h;
    if (localObject != null) {
      ((View)localObject).setLayoutParams(this.a);
    }
    GdtMvViewAnimationAbs.b(this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.elements.GdtMvViewAnimationAbs.2
 * JD-Core Version:    0.7.0.1
 */