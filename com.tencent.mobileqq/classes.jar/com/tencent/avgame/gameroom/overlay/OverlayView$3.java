package com.tencent.avgame.gameroom.overlay;

import android.widget.ImageView;
import com.tencent.avgame.gameroom.AVGameLottieHelper.LottieDrawableLoadedListener;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;

class OverlayView$3
  implements AVGameLottieHelper.LottieDrawableLoadedListener
{
  OverlayView$3(OverlayView paramOverlayView) {}
  
  public void a(LottieDrawable paramLottieDrawable)
  {
    if (paramLottieDrawable != null)
    {
      OverlayView.b(this.a, paramLottieDrawable);
      if (QLog.isColorLevel())
      {
        paramLottieDrawable = new StringBuilder();
        paramLottieDrawable.append("loadLottieAnim success needRecoverFriendHeadCheerLottie = ");
        paramLottieDrawable.append(OverlayView.e(this.a));
        QLog.d("OverlayView", 2, paramLottieDrawable.toString());
      }
      if (OverlayView.e(this.a))
      {
        OverlayView.g(this.a).setImageDrawable(OverlayView.f(this.a));
        OverlayView.f(this.a).playAnimation();
        OverlayView.c(this.a, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.overlay.OverlayView.3
 * JD-Core Version:    0.7.0.1
 */