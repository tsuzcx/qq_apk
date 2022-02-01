package com.tencent.mobileqq.activity.aio.panel;

import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import mqq.os.MqqHandler;

class PEPanel$2
  implements OnCompositionLoadedListener
{
  PEPanel$2(PEPanel paramPEPanel, DiniFlyAnimationView paramDiniFlyAnimationView) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmo.PEPanel", 2, "composition is null ,return");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PokeEmo.PEPanel", 2, String.format(" playLottieAnim onCompositionLoaded done ", new Object[0]));
    }
    Rect localRect = paramLottieComposition.getBounds();
    int i = this.b.getResources().getDisplayMetrics().widthPixels;
    i = XPanelContainer.a;
    AIOUtils.b(40.0F, this.b.getResources());
    float f = this.b.getResources().getDisplayMetrics().widthPixels / localRect.width();
    PEPanel.a(this.b, paramLottieComposition.getDuration() * 6L / 10L);
    this.a.setComposition(paramLottieComposition);
    this.a.setScale(f);
    this.a.setScaleType(ImageView.ScaleType.FIT_XY);
    this.a.addAnimatorListener(PEPanel.b(this.b));
    this.a.addAnimatorUpdateListener(PEPanel.b(this.b));
    this.a.playAnimation();
    PEPanel.d(this.b).sendEmptyMessageDelayed(0, PEPanel.c(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PEPanel.2
 * JD-Core Version:    0.7.0.1
 */