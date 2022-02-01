package com.tencent.mobileqq.activity.aio.item;

import android.graphics.Rect;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;

final class PokeItemHelper$2
  implements OnCompositionLoadedListener
{
  PokeItemHelper$2(DiniFlyAnimationView paramDiniFlyAnimationView, GivingHeartItemBuilder.Holder paramHolder, String paramString) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    this.a.setImageAssetDelegate(new PokeItemHelper.2.1(this));
    if (paramLottieComposition == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(PokeItemHelper.a, 2, "composition is null ,return");
      }
      return;
    }
    this.a.setComposition(paramLottieComposition);
    if ((this.b != null) && ("bubble".equals(this.c)))
    {
      paramLottieComposition = this.b.c.getCompRect();
      ViewGroup.LayoutParams localLayoutParams = this.b.c.getLayoutParams();
      int i = paramLottieComposition.width() * localLayoutParams.height / paramLottieComposition.height();
      this.b.c.getLayoutParams().width = i;
      this.b.c.setLayoutParams(localLayoutParams);
      this.b.c.setVisibility(0);
      this.b.b.clearAnimation();
      this.b.b.setVisibility(8);
      this.b.d.clearAnimation();
      this.b.d.setVisibility(8);
    }
    this.a.playAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PokeItemHelper.2
 * JD-Core Version:    0.7.0.1
 */