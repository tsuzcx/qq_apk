package com.tencent.mobileqq.activity.aio.helper;

import afbc;
import afbd;
import arsi;
import com.tencent.mobileqq.theme.effect.QEffectLottieImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.effect.QEffectView;

public class QEffectBgProvider$1$1
  implements Runnable
{
  public QEffectBgProvider$1$1(afbd paramafbd, arsi paramarsi) {}
  
  public void run()
  {
    QLog.i("QEffectBgProvider", 1, "set qeffect for 3D background effectId:" + this.jdField_a_of_type_Afbd.jdField_a_of_type_Int);
    afbc.a(this.jdField_a_of_type_Afbd.jdField_a_of_type_Afbc, System.currentTimeMillis());
    afbc.a(this.jdField_a_of_type_Afbd.jdField_a_of_type_Afbc).setSrc(QEffectLottieImageView.a(this.jdField_a_of_type_Arsi.a, -1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QEffectBgProvider.1.1
 * JD-Core Version:    0.7.0.1
 */