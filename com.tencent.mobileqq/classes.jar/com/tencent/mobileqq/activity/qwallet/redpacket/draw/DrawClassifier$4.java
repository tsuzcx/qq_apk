package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import agpd;
import algd;
import algi;
import alhb;
import alil;
import com.tencent.qphone.base.util.QLog;

public class DrawClassifier$4
  implements Runnable
{
  public DrawClassifier$4(algd paramalgd, algi paramalgi, agpd paramagpd) {}
  
  public void run()
  {
    try
    {
      if (!algd.a(this.this$0))
      {
        if (QLog.isColorLevel()) {
          QLog.e("DrawClassifier", 2, "not init ok or already close to recog");
        }
        if (this.jdField_a_of_type_Algi != null) {
          this.jdField_a_of_type_Algi.a(false);
        }
      }
      long l = System.currentTimeMillis();
      boolean bool = algd.a(this.this$0).a(this.jdField_a_of_type_Agpd, algd.c(this.this$0), this.this$0.a, algd.a(this.this$0), algd.a(this.this$0));
      if (this.jdField_a_of_type_Algi != null) {
        this.jdField_a_of_type_Algi.a(bool);
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
          QLog.e("DrawClassifier", 2, "recognition throwable:" + alil.a(localThrowable));
        }
        localThrowable.printStackTrace();
      } while (this.jdField_a_of_type_Algi == null);
      this.jdField_a_of_type_Algi.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawClassifier.4
 * JD-Core Version:    0.7.0.1
 */