package com.tencent.biz.pubaccount;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.mobileqq.app.QQAppInterface;

class PublicAccountUnfollowTask$1
  implements Runnable
{
  PublicAccountUnfollowTask$1(PublicAccountUnfollowTask paramPublicAccountUnfollowTask) {}
  
  public void run()
  {
    ReadInJoyLogicEngine.a().a().a(PublicAccountUnfollowTask.a(this.this$0).getAccount(), PublicAccountUnfollowTask.a(this.this$0), false, "", this.this$0, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountUnfollowTask.1
 * JD-Core Version:    0.7.0.1
 */