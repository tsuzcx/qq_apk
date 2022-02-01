package com.tencent.mobileqq.activity.miniaio;

import akaj;
import com.tencent.qphone.base.util.QLog;

public class MiniPie$4
  implements Runnable
{
  public MiniPie$4(akaj paramakaj) {}
  
  public void run()
  {
    if (!this.this$0.jdField_a_of_type_Boolean) {
      akaj.a(this.this$0);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(this.this$0.jdField_a_of_type_JavaLangString, 2, "EmotionPanel already added");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniPie.4
 * JD-Core Version:    0.7.0.1
 */