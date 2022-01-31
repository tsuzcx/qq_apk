package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import aezq;
import ajct;
import ajcx;
import ajdr;
import ajeu;
import com.tencent.qphone.base.util.QLog;

public class DrawClassifier$3
  implements Runnable
{
  public DrawClassifier$3(ajct paramajct, ajcx paramajcx, aezq paramaezq) {}
  
  public void run()
  {
    try
    {
      if (!ajct.a(this.this$0))
      {
        if (QLog.isColorLevel()) {
          QLog.e("DrawClassifier", 2, "not init ok or already close to recog");
        }
        if (this.jdField_a_of_type_Ajcx != null) {
          this.jdField_a_of_type_Ajcx.a(false);
        }
      }
      long l = System.currentTimeMillis();
      boolean bool = ajct.a(this.this$0).a(this.jdField_a_of_type_Aezq, ajct.b(this.this$0), this.this$0.a, ajct.a(this.this$0));
      if (this.jdField_a_of_type_Ajcx != null) {
        this.jdField_a_of_type_Ajcx.a(bool);
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
          QLog.e("DrawClassifier", 2, "recognition throwable:" + ajeu.a(localThrowable));
        }
        localThrowable.printStackTrace();
      } while (this.jdField_a_of_type_Ajcx == null);
      this.jdField_a_of_type_Ajcx.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawClassifier.3
 * JD-Core Version:    0.7.0.1
 */