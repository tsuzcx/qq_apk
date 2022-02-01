package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import aggc;
import akuo;
import akut;
import akvm;
import akww;
import com.tencent.qphone.base.util.QLog;

public class DrawClassifier$4
  implements Runnable
{
  public DrawClassifier$4(akuo paramakuo, akut paramakut, aggc paramaggc) {}
  
  public void run()
  {
    try
    {
      if (!akuo.a(this.this$0))
      {
        if (QLog.isColorLevel()) {
          QLog.e("DrawClassifier", 2, "not init ok or already close to recog");
        }
        if (this.jdField_a_of_type_Akut != null) {
          this.jdField_a_of_type_Akut.a(false);
        }
      }
      long l = System.currentTimeMillis();
      boolean bool = akuo.a(this.this$0).a(this.jdField_a_of_type_Aggc, akuo.c(this.this$0), this.this$0.a, akuo.a(this.this$0), akuo.a(this.this$0));
      if (this.jdField_a_of_type_Akut != null) {
        this.jdField_a_of_type_Akut.a(bool);
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
          QLog.e("DrawClassifier", 2, "recognition throwable:" + akww.a(localThrowable));
        }
        localThrowable.printStackTrace();
      } while (this.jdField_a_of_type_Akut == null);
      this.jdField_a_of_type_Akut.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawClassifier.4
 * JD-Core Version:    0.7.0.1
 */