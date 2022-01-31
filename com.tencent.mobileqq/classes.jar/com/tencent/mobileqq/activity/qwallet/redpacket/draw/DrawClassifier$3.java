package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import addc;
import ahec;
import aheg;
import ahfa;
import ahiy;
import com.tencent.qphone.base.util.QLog;

public class DrawClassifier$3
  implements Runnable
{
  public DrawClassifier$3(ahec paramahec, aheg paramaheg, addc paramaddc) {}
  
  public void run()
  {
    try
    {
      if (!ahec.a(this.this$0))
      {
        if (QLog.isColorLevel()) {
          QLog.e("DrawClassifier", 2, "not init ok or already close to recog");
        }
        if (this.jdField_a_of_type_Aheg != null) {
          this.jdField_a_of_type_Aheg.a(false);
        }
      }
      long l = System.currentTimeMillis();
      boolean bool = ahec.a(this.this$0).a(this.jdField_a_of_type_Addc, ahec.b(this.this$0), this.this$0.a, ahec.a(this.this$0));
      if (this.jdField_a_of_type_Aheg != null) {
        this.jdField_a_of_type_Aheg.a(bool);
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
          QLog.e("DrawClassifier", 2, "recognition throwable:" + ahiy.a(localThrowable));
        }
        localThrowable.printStackTrace();
      } while (this.jdField_a_of_type_Aheg == null);
      this.jdField_a_of_type_Aheg.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawClassifier.3
 * JD-Core Version:    0.7.0.1
 */