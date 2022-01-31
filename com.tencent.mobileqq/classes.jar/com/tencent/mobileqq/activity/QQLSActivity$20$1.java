package com.tencent.mobileqq.activity;

import abuu;
import com.tencent.qphone.base.util.QLog;

public class QQLSActivity$20$1
  implements Runnable
{
  public QQLSActivity$20$1(abuu paramabuu) {}
  
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