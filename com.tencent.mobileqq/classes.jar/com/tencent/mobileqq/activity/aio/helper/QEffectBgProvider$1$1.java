package com.tencent.mobileqq.activity.aio.helper;

import acxv;
import acxw;
import aphb;
import com.tencent.mobileqq.theme.effect.QEffectLottieImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.effect.QEffectView;

public class QEffectBgProvider$1$1
  implements Runnable
{
  public QEffectBgProvider$1$1(acxw paramacxw, aphb paramaphb) {}
  
  public void run()
  {
    QLog.i("QEffectBgProvider", 1, "set qeffect for 3D background effectId:" + this.jdField_a_of_type_Acxw.jdField_a_of_type_Int);
    acxv.a(this.jdField_a_of_type_Acxw.jdField_a_of_type_Acxv, System.currentTimeMillis());
    acxv.a(this.jdField_a_of_type_Acxw.jdField_a_of_type_Acxv).setSrc(QEffectLottieImageView.a(this.jdField_a_of_type_Aphb.a, -1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QEffectBgProvider.1.1
 * JD-Core Version:    0.7.0.1
 */