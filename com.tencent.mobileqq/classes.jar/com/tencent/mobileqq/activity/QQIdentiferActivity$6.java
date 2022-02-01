package com.tencent.mobileqq.activity;

import mqq.os.MqqHandler;

class QQIdentiferActivity$6
  implements Runnable
{
  QQIdentiferActivity$6(QQIdentiferActivity paramQQIdentiferActivity) {}
  
  public void run()
  {
    if (QQIdentiferActivity.a(this.this$0))
    {
      this.this$0.d();
      QQIdentiferActivity.a(this.this$0).sendEmptyMessageDelayed(3, QQIdentiferActivity.a(this.this$0));
      return;
    }
    this.this$0.b(QQIdentiferActivity.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferActivity.6
 * JD-Core Version:    0.7.0.1
 */