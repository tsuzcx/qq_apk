package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.qphone.base.util.QLog;

class QQLSActivity$10
  extends MessageObserver
{
  QQLSActivity$10(QQLSActivity paramQQLSActivity) {}
  
  public void onPushReadedNotify(boolean paramBoolean, Object paramObject)
  {
    super.onPushReadedNotify(paramBoolean, paramObject);
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "PC has read onPushReadedNotify finish" + Thread.currentThread().getId());
    }
    QQLSActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity.10
 * JD-Core Version:    0.7.0.1
 */