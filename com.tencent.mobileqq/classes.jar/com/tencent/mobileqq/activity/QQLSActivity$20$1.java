package com.tencent.mobileqq.activity;

import com.tencent.qphone.base.util.QLog;

class QQLSActivity$20$1
  implements Runnable
{
  QQLSActivity$20$1(QQLSActivity.20 param20) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "do SmoothFinish at run");
    }
    QQLSActivity.g(this.a.a);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity.20.1
 * JD-Core Version:    0.7.0.1
 */