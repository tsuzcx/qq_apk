package com.tencent.avgame.gameroom.overlay;

import android.widget.ImageView;
import com.tencent.avgame.gameroom.AVGameLottieHelper.LottieDrawableLoadedListener;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;

class OverlayView$2
  implements AVGameLottieHelper.LottieDrawableLoadedListener
{
  OverlayView$2(OverlayView paramOverlayView) {}
  
  public void a(LottieDrawable paramLottieDrawable)
  {
    if (paramLottieDrawable != null)
    {
      OverlayView.a(this.a, paramLottieDrawable);
      if (QLog.isColorLevel())
      {
        paramLottieDrawable = new StringBuilder();
        paramLottieDrawable.append("loadLottieAnim success needRecoverCardStarLottie = ");
        paramLottieDrawable.append(OverlayView.a(this.a));
        QLog.d("OverlayView", 2, paramLottieDrawable.toString());
      }
      if (OverlayView.a(this.a))
      {
        OverlayView.a(this.a).setImageDrawable(OverlayView.a(this.a));
        OverlayView.a(this.a).playAnimation();
        OverlayView.b(this.a, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.overlay.OverlayView.2
 * JD-Core Version:    0.7.0.1
 */