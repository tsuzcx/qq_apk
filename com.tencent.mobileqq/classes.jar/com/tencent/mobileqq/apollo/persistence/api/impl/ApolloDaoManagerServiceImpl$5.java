package com.tencent.mobileqq.apollo.persistence.api.impl;

import com.tencent.mobileqq.apollo.model.ApolloActionData;

class ApolloDaoManagerServiceImpl$5
  implements Runnable
{
  ApolloDaoManagerServiceImpl$5(ApolloDaoManagerServiceImpl paramApolloDaoManagerServiceImpl, int paramInt) {}
  
  public void run()
  {
    ApolloActionData localApolloActionData = this.this$0.findActionById(this.a);
    if (localApolloActionData != null)
    {
      localApolloActionData.limitFree = 0;
      this.this$0.changeActionStatus(localApolloActionData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl.5
 * JD-Core Version:    0.7.0.1
 */