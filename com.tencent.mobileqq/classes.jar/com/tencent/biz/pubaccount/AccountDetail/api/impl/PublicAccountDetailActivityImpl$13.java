package com.tencent.biz.pubaccount.accountdetail.api.impl;

class PublicAccountDetailActivityImpl$13
  implements Runnable
{
  PublicAccountDetailActivityImpl$13(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl) {}
  
  public void run()
  {
    PublicAccountDetailActivityImpl localPublicAccountDetailActivityImpl = this.this$0;
    localPublicAccountDetailActivityImpl.saveAccountDetailToDBAndCache(localPublicAccountDetailActivityImpl.accountDetail);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.13
 * JD-Core Version:    0.7.0.1
 */