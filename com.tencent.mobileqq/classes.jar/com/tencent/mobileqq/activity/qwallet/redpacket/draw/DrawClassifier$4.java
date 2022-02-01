package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import afkx;
import akdw;
import akeb;
import akeu;
import akgd;
import com.tencent.qphone.base.util.QLog;

public class DrawClassifier$4
  implements Runnable
{
  public DrawClassifier$4(akdw paramakdw, akeb paramakeb, afkx paramafkx) {}
  
  public void run()
  {
    try
    {
      if (!akdw.a(this.this$0))
      {
        if (QLog.isColorLevel()) {
          QLog.e("DrawClassifier", 2, "not init ok or already close to recog");
        }
        if (this.jdField_a_of_type_Akeb != null) {
          this.jdField_a_of_type_Akeb.a(false);
        }
      }
      long l = System.currentTimeMillis();
      boolean bool = akdw.a(this.this$0).a(this.jdField_a_of_type_Afkx, akdw.c(this.this$0), this.this$0.a, akdw.a(this.this$0), akdw.a(this.this$0));
      if (this.jdField_a_of_type_Akeb != null) {
        this.jdField_a_of_type_Akeb.a(bool);
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
          QLog.e("DrawClassifier", 2, "recognition throwable:" + akgd.a(localThrowable));
        }
        localThrowable.printStackTrace();
      } while (this.jdField_a_of_type_Akeb == null);
      this.jdField_a_of_type_Akeb.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawClassifier.4
 * JD-Core Version:    0.7.0.1
 */