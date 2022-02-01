package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.floatscr.ColorScreenConfig;
import com.tencent.mobileqq.vas.VasManager.CompleteListener;
import com.tencent.qq.effect.QEffectView;

class QEffectBgProvider$1
  implements VasManager.CompleteListener<ColorScreenConfig>
{
  QEffectBgProvider$1(QEffectBgProvider paramQEffectBgProvider, int paramInt) {}
  
  public void a(ColorScreenConfig paramColorScreenConfig, Object paramObject)
  {
    if (paramColorScreenConfig != null) {
      QEffectBgProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperQEffectBgProvider).postDelayed(new QEffectBgProvider.1.1(this, paramColorScreenConfig), 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QEffectBgProvider.1
 * JD-Core Version:    0.7.0.1
 */