package com.tencent.mobileqq.activity.aio.helper;

import affr;
import affs;
import arwr;
import com.tencent.mobileqq.theme.effect.QEffectLottieImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.effect.QEffectView;

public class QEffectBgProvider$1$1
  implements Runnable
{
  public QEffectBgProvider$1$1(affs paramaffs, arwr paramarwr) {}
  
  public void run()
  {
    QLog.i("QEffectBgProvider", 1, "set qeffect for 3D background effectId:" + this.jdField_a_of_type_Affs.jdField_a_of_type_Int);
    affr.a(this.jdField_a_of_type_Affs.jdField_a_of_type_Affr, System.currentTimeMillis());
    affr.a(this.jdField_a_of_type_Affs.jdField_a_of_type_Affr).setSrc(QEffectLottieImageView.a(this.jdField_a_of_type_Arwr.a, -1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QEffectBgProvider.1.1
 * JD-Core Version:    0.7.0.1
 */