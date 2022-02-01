package com.tencent.mobileqq.activity;

import mqq.os.MqqHandler;

class QQIdentiferActivity$6
  implements Runnable
{
  QQIdentiferActivity$6(QQIdentiferActivity paramQQIdentiferActivity) {}
  
  public void run()
  {
    if (QQIdentiferActivity.access$500(this.this$0))
    {
      this.this$0.showSuccessResult();
      QQIdentiferActivity.access$700(this.this$0).sendEmptyMessageDelayed(3, QQIdentiferActivity.access$600(this.this$0));
      return;
    }
    QQIdentiferActivity localQQIdentiferActivity = this.this$0;
    localQQIdentiferActivity.showFailedResult(QQIdentiferActivity.access$800(localQQIdentiferActivity));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferActivity.6
 * JD-Core Version:    0.7.0.1
 */