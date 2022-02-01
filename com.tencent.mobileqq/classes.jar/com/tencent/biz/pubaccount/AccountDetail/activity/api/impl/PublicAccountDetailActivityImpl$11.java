package com.tencent.biz.pubaccount.AccountDetail.activity.api.impl;

import android.os.Handler;

class PublicAccountDetailActivityImpl$11
  implements Runnable
{
  PublicAccountDetailActivityImpl$11(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl) {}
  
  public void run()
  {
    this.this$0.postData = this.this$0.getMessageList(this.this$0, this.this$0.uin);
    this.this$0.mHandler.sendEmptyMessage(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.PublicAccountDetailActivityImpl.11
 * JD-Core Version:    0.7.0.1
 */