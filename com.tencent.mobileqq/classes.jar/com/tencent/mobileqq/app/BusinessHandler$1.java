package com.tencent.mobileqq.app;

class BusinessHandler$1
  implements Runnable
{
  BusinessHandler$1(BusinessHandler paramBusinessHandler, BusinessObserver paramBusinessObserver, int paramInt, boolean paramBoolean, Object paramObject) {}
  
  public void run()
  {
    this.val$destObserver.onUpdate(this.val$type, this.val$isSuccess, this.val$data);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.BusinessHandler.1
 * JD-Core Version:    0.7.0.1
 */