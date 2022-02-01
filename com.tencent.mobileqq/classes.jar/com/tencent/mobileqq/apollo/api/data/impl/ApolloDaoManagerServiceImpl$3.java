package com.tencent.mobileqq.apollo.api.data.impl;

import com.tencent.mobileqq.apollo.api.model.ApolloActionData;

class ApolloDaoManagerServiceImpl$3
  implements Runnable
{
  ApolloDaoManagerServiceImpl$3(ApolloDaoManagerServiceImpl paramApolloDaoManagerServiceImpl, int paramInt) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */