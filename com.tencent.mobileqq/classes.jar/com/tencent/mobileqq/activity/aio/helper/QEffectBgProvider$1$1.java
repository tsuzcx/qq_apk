package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.floatscr.ColorScreenConfig;
import com.tencent.mobileqq.theme.effect.QEffectLottieImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.effect.QEffectView;

class QEffectBgProvider$1$1
  implements Runnable
{
  QEffectBgProvider$1$1(QEffectBgProvider.1 param1, ColorScreenConfig paramColorScreenConfig) {}
  
  public void run()
  {
    QLog.i("QEffectBgProvider", 1, "set qeffect for 3D background effectId:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperQEffectBgProvider$1.jdField_a_of_type_Int);
    QEffectBgProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperQEffectBgProvider$1.jdField_a_of_type_ComTencentMobileqqActivityAioHelperQEffectBgProvider, System.currentTimeMillis());
    QEffectBgProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperQEffectBgProvider$1.jdField_a_of_type_ComTencentMobileqqActivityAioHelperQEffectBgProvider).setSrc(QEffectLottieImageView.a(this.jdField_a_of_type_ComTencentMobileqqFloatscrColorScreenConfig.a, -1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QEffectBgProvider.1.1
 * JD-Core Version:    0.7.0.1
 */