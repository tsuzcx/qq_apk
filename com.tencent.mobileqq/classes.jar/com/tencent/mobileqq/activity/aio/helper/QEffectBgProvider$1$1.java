package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.floatscr.ColorScreenConfig;
import com.tencent.mobileqq.vas.theme.effect.QEffectLottieImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.effect.QEffectView;

class QEffectBgProvider$1$1
  implements Runnable
{
  QEffectBgProvider$1$1(QEffectBgProvider.1 param1, ColorScreenConfig paramColorScreenConfig) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("set qeffect for 3D background effectId:");
    localStringBuilder.append(this.b.a);
    QLog.i("QEffectBgProvider", 1, localStringBuilder.toString());
    QEffectBgProvider.a(this.b.b, System.currentTimeMillis());
    QEffectBgProvider.a(this.b.b).setSrc(QEffectLottieImageView.a(this.a.a, -1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QEffectBgProvider.1.1
 * JD-Core Version:    0.7.0.1
 */