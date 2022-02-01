package com.tencent.biz.pubaccount.weishi_new.event;

import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpPolicyEntities;

public class WSExpEvent
  extends WSSimpleBaseEvent
{
  private WSExpPolicyEntities mPolicyEntities;
  
  public WSExpEvent(WSExpPolicyEntities paramWSExpPolicyEntities)
  {
    this.mPolicyEntities = paramWSExpPolicyEntities;
  }
  
  public WSExpPolicyEntities getPolicyEntities()
  {
    return this.mPolicyEntities;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.event.WSExpEvent
 * JD-Core Version:    0.7.0.1
 */