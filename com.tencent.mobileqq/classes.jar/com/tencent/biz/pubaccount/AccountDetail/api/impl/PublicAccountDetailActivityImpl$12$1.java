package com.tencent.biz.pubaccount.accountdetail.api.impl;

class PublicAccountDetailActivityImpl$12$1
  implements Runnable
{
  PublicAccountDetailActivityImpl$12$1(PublicAccountDetailActivityImpl.12 param12) {}
  
  public void run()
  {
    if (this.a.this$0.isFirst)
    {
      this.a.this$0.firstFetch();
      return;
    }
    PublicAccountDetailActivityImpl.access$1000(this.a.this$0);
    this.a.this$0.sendDetailInfoRequest();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.12.1
 * JD-Core Version:    0.7.0.1
 */