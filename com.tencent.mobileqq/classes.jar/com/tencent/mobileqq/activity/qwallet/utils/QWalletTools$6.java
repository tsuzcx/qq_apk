package com.tencent.mobileqq.activity.qwallet.utils;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class QWalletTools$6
  implements View.OnTouchListener
{
  private float b = 1.0F;
  
  QWalletTools$6(float paramFloat) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.b = paramView.getAlpha();
      paramView.setAlpha(this.a);
    }
    for (;;)
    {
      return false;
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        paramView.setAlpha(this.b);
      }
      else if (paramMotionEvent.getAction() == 2)
      {
        int i = (int)paramMotionEvent.getRawX();
        int j = (int)paramMotionEvent.getRawY();
        if (!QWalletTools.a(paramView, i, j)) {
          paramView.setAlpha(1.0F);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.utils.QWalletTools.6
 * JD-Core Version:    0.7.0.1
 */