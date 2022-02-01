package com.tencent.luggage.wxa.pp;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

final class x$g
  extends FrameLayout
  implements x.a
{
  private boolean a = false;
  
  public x$g(Context paramContext)
  {
    super(paramContext);
    LayoutInflater.from(paramContext).inflate(2131624246, this);
  }
  
  public void a(boolean paramBoolean)
  {
    int i;
    if (paramBoolean != this.a) {
      i = 1;
    } else {
      i = 0;
    }
    this.a = paramBoolean;
    if ((i != 0) && ((Build.VERSION.SDK_INT < 18) || (!isInLayout()))) {
      requestLayout();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.a) || (!isShown()))
    {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
      paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.x.g
 * JD-Core Version:    0.7.0.1
 */