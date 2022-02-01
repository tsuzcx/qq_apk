package com.tencent.avgame.gameroom.overlay;

import android.widget.ImageView;
import com.tencent.avgame.gameroom.AVGameLottieHelper.LottieDrawableLoadedListener;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;

class OverlayView$4
  implements AVGameLottieHelper.LottieDrawableLoadedListener
{
  OverlayView$4(OverlayView paramOverlayView) {}
  
  public void a(LottieDrawable paramLottieDrawable)
  {
    if (paramLottieDrawable != null)
    {
      OverlayView.c(this.a, paramLottieDrawable);
      if (QLog.isColorLevel())
      {
        paramLottieDrawable = new StringBuilder();
        paramLottieDrawable.append("loadLottieAnim success needRecoverSelfHeadCheerLottie = ");
        paramLottieDrawable.append(OverlayView.h(this.a));
        QLog.d("OverlayView", 2, paramLottieDrawable.toString());
      }
      if (OverlayView.h(this.a))
      {
        OverlayView.g(this.a).setImageDrawable(OverlayView.i(this.a));
        OverlayView.i(this.a).playAnimation();
        OverlayView.d(this.a, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.overlay.OverlayView.4
 * JD-Core Version:    0.7.0.1
 */