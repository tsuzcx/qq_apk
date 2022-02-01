package com.tencent.mobileqq.activity.aio.helper;

import agjk;
import agjl;
import auml;
import com.tencent.mobileqq.theme.effect.QEffectLottieImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.effect.QEffectView;

public class QEffectBgProvider$1$1
  implements Runnable
{
  public QEffectBgProvider$1$1(agjl paramagjl, auml paramauml) {}
  
  public void run()
  {
    QLog.i("QEffectBgProvider", 1, "set qeffect for 3D background effectId:" + this.jdField_a_of_type_Agjl.jdField_a_of_type_Int);
    agjk.a(this.jdField_a_of_type_Agjl.jdField_a_of_type_Agjk, System.currentTimeMillis());
    agjk.a(this.jdField_a_of_type_Agjl.jdField_a_of_type_Agjk).setSrc(QEffectLottieImageView.a(this.jdField_a_of_type_Auml.a, -1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QEffectBgProvider.1.1
 * JD-Core Version:    0.7.0.1
 */