package com.tencent.mobileqq.activity.aio.helper;

import adiu;
import adiv;
import apzg;
import com.tencent.mobileqq.theme.effect.QEffectLottieImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.effect.QEffectView;

public class QEffectBgProvider$1$1
  implements Runnable
{
  public QEffectBgProvider$1$1(adiv paramadiv, apzg paramapzg) {}
  
  public void run()
  {
    QLog.i("QEffectBgProvider", 1, "set qeffect for 3D background effectId:" + this.jdField_a_of_type_Adiv.jdField_a_of_type_Int);
    adiu.a(this.jdField_a_of_type_Adiv.jdField_a_of_type_Adiu, System.currentTimeMillis());
    adiu.a(this.jdField_a_of_type_Adiv.jdField_a_of_type_Adiu).setSrc(QEffectLottieImageView.a(this.jdField_a_of_type_Apzg.a, -1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QEffectBgProvider.1.1
 * JD-Core Version:    0.7.0.1
 */