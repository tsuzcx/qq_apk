package com.tencent.avgame.gameroom.seat;

import android.os.Build.VERSION;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import com.tencent.avgame.ui.RoundEmptyRectRelativeLayout.ClipRoundRect;
import com.tencent.mobileqq.utils.ViewUtils;

class PkSeatView$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  PkSeatView$1(PkSeatView paramPkSeatView) {}
  
  public void onGlobalLayout()
  {
    if ((PkSeatView.a(this.a) != null) && (PkSeatView.a(this.a).b != null))
    {
      int[] arrayOfInt1 = new int[2];
      this.a.getLocationInWindow(arrayOfInt1);
      int[] arrayOfInt2 = new int[2];
      PkSeatView.a(this.a).b.getLocationInWindow(arrayOfInt2);
      PkSeatView.a(this.a, new RoundEmptyRectRelativeLayout.ClipRoundRect(arrayOfInt2[0] - arrayOfInt1[0], arrayOfInt2[1] - arrayOfInt1[1], PkSeatView.a(this.a).b.getWidth(), PkSeatView.a(this.a).b.getHeight(), ViewUtils.a(12.0F)));
      this.a.a(PkSeatView.a(this.a));
      if (Build.VERSION.SDK_INT >= 16) {
        PkSeatView.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.PkSeatView.1
 * JD-Core Version:    0.7.0.1
 */