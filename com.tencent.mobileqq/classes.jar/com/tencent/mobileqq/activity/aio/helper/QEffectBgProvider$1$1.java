package com.tencent.mobileqq.activity.aio.helper;

import agmt;
import agmu;
import aueb;
import com.tencent.mobileqq.theme.effect.QEffectLottieImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.effect.QEffectView;

public class QEffectBgProvider$1$1
  implements Runnable
{
  public QEffectBgProvider$1$1(agmu paramagmu, aueb paramaueb) {}
  
  public void run()
  {
    QLog.i("QEffectBgProvider", 1, "set qeffect for 3D background effectId:" + this.jdField_a_of_type_Agmu.jdField_a_of_type_Int);
    agmt.a(this.jdField_a_of_type_Agmu.jdField_a_of_type_Agmt, System.currentTimeMillis());
    agmt.a(this.jdField_a_of_type_Agmu.jdField_a_of_type_Agmt).setSrc(QEffectLottieImageView.a(this.jdField_a_of_type_Aueb.a, -1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QEffectBgProvider.1.1
 * JD-Core Version:    0.7.0.1
 */