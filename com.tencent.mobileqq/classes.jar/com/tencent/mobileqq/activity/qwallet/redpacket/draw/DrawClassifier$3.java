package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import aevb;
import aiye;
import aiyi;
import aizc;
import ajaf;
import com.tencent.qphone.base.util.QLog;

public class DrawClassifier$3
  implements Runnable
{
  public DrawClassifier$3(aiye paramaiye, aiyi paramaiyi, aevb paramaevb) {}
  
  public void run()
  {
    try
    {
      if (!aiye.a(this.this$0))
      {
        if (QLog.isColorLevel()) {
          QLog.e("DrawClassifier", 2, "not init ok or already close to recog");
        }
        if (this.jdField_a_of_type_Aiyi != null) {
          this.jdField_a_of_type_Aiyi.a(false);
        }
      }
      long l = System.currentTimeMillis();
      boolean bool = aiye.a(this.this$0).a(this.jdField_a_of_type_Aevb, aiye.b(this.this$0), this.this$0.a, aiye.a(this.this$0));
      if (this.jdField_a_of_type_Aiyi != null) {
        this.jdField_a_of_type_Aiyi.a(bool);
      }
      if (QLog.isColorLevel()) {
        QLog.i("DrawClassifier", 2, "recognize cost:" + (System.currentTimeMillis() - l));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      do
      {
        if (QLog.isColorLevel()) {
          QLog.e("DrawClassifier", 2, "recognition throwable:" + ajaf.a(localThrowable));
        }
        localThrowable.printStackTrace();
      } while (this.jdField_a_of_type_Aiyi == null);
      this.jdField_a_of_type_Aiyi.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawClassifier.3
 * JD-Core Version:    0.7.0.1
 */