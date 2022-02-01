package com.tencent.mobileqq.app;

import com.tencent.qphone.base.util.QLog;

class BusinessHandler$1
  implements Runnable
{
  BusinessHandler$1(BusinessHandler paramBusinessHandler, BusinessObserver paramBusinessObserver, int paramInt, boolean paramBoolean, Object paramObject) {}
  
  public void run()
  {
    try
    {
      this.val$destObserver.onUpdate(this.val$type, this.val$isSuccess, this.val$data);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("BusinessHandler", 2, "onUpdate fail", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.BusinessHandler.1
 * JD-Core Version:    0.7.0.1
 */