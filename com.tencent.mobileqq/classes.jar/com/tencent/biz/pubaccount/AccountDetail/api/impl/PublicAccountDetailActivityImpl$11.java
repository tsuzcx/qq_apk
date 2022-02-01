package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.os.Handler;

class PublicAccountDetailActivityImpl$11
  implements Runnable
{
  PublicAccountDetailActivityImpl$11(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl) {}
  
  public void run()
  {
    PublicAccountDetailActivityImpl localPublicAccountDetailActivityImpl = this.this$0;
    localPublicAccountDetailActivityImpl.postData = localPublicAccountDetailActivityImpl.getMessageList(localPublicAccountDetailActivityImpl, localPublicAccountDetailActivityImpl.uin);
    this.this$0.mHandler.sendEmptyMessage(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.11
 * JD-Core Version:    0.7.0.1
 */