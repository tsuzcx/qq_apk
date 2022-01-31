package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import acsj;
import agrn;
import agrr;
import agsl;
import agwj;
import com.tencent.qphone.base.util.QLog;

public class DrawClassifier$3
  implements Runnable
{
  public DrawClassifier$3(agrn paramagrn, agrr paramagrr, acsj paramacsj) {}
  
  public void run()
  {
    try
    {
      if (!agrn.a(this.this$0))
      {
        if (QLog.isColorLevel()) {
          QLog.e("DrawClassifier", 2, "not init ok or already close to recog");
        }
        if (this.jdField_a_of_type_Agrr != null) {
          this.jdField_a_of_type_Agrr.a(false);
        }
      }
      long l = System.currentTimeMillis();
      boolean bool = agrn.a(this.this$0).a(this.jdField_a_of_type_Acsj, agrn.b(this.this$0), this.this$0.a, agrn.a(this.this$0));
      if (this.jdField_a_of_type_Agrr != null) {
        this.jdField_a_of_type_Agrr.a(bool);
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
          QLog.e("DrawClassifier", 2, "recognition throwable:" + agwj.a(localThrowable));
        }
        localThrowable.printStackTrace();
      } while (this.jdField_a_of_type_Agrr == null);
      this.jdField_a_of_type_Agrr.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawClassifier.3
 * JD-Core Version:    0.7.0.1
 */