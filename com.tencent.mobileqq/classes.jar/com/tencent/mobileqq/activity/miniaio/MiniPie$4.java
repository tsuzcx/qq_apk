package com.tencent.mobileqq.activity.miniaio;

import com.tencent.qphone.base.util.QLog;

class MiniPie$4
  implements Runnable
{
  MiniPie$4(MiniPie paramMiniPie) {}
  
  public void run()
  {
    if (!this.this$0.jdField_a_of_type_Boolean) {
      MiniPie.a(this.this$0);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(this.this$0.jdField_a_of_type_JavaLangString, 2, "EmotionPanel already added");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniPie.4
 * JD-Core Version:    0.7.0.1
 */