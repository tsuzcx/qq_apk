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
      Object localObject = new int[2];
      this.a.getLocationInWindow((int[])localObject);
      int[] arrayOfInt = new int[2];
      PkSeatView.a(this.a).b.getLocationInWindow(arrayOfInt);
      PkSeatView localPkSeatView = this.a;
      PkSeatView.a(localPkSeatView, new RoundEmptyRectRelativeLayout.ClipRoundRect(arrayOfInt[0] - localObject[0], arrayOfInt[1] - localObject[1], PkSeatView.a(localPkSeatView).b.getWidth(), PkSeatView.a(this.a).b.getHeight(), ViewUtils.a(12.0F)));
      localObject = this.a;
      ((PkSeatView)localObject).a(PkSeatView.a((PkSeatView)localObject));
      if (Build.VERSION.SDK_INT >= 16) {
        PkSeatView.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.PkSeatView.1
 * JD-Core Version:    0.7.0.1
 */