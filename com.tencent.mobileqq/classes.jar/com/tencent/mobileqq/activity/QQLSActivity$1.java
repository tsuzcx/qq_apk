package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.utils.QQLSSensor;

class QQLSActivity$1
  implements Runnable
{
  QQLSActivity$1(QQLSActivity paramQQLSActivity) {}
  
  public void run()
  {
    QQLSActivity localQQLSActivity = this.this$0;
    localQQLSActivity.a = new QQLSSensor(localQQLSActivity.getApplicationContext(), this.this$0);
    this.this$0.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity.1
 * JD-Core Version:    0.7.0.1
 */