package com.tencent.biz.pubaccount.accountdetail.api.impl;

class PublicAccountDetailActivityImpl$2
  implements Runnable
{
  PublicAccountDetailActivityImpl$2(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.waitingCount > 0) {
      this.this$0.showLoading(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.2
 * JD-Core Version:    0.7.0.1
 */