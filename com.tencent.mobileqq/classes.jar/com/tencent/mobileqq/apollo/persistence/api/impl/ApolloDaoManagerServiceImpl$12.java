package com.tencent.mobileqq.apollo.persistence.api.impl;

import com.tencent.common.app.AppInterface;

class ApolloDaoManagerServiceImpl$12
  implements Runnable
{
  ApolloDaoManagerServiceImpl$12(ApolloDaoManagerServiceImpl paramApolloDaoManagerServiceImpl) {}
  
  public void run()
  {
    if (ApolloDaoManagerServiceImpl.access$600(this.this$0) == null)
    {
      ApolloDaoManagerServiceImpl localApolloDaoManagerServiceImpl = this.this$0;
      ApolloDaoManagerServiceImpl.access$602(localApolloDaoManagerServiceImpl, localApolloDaoManagerServiceImpl.getApolloBaseInfo(ApolloDaoManagerServiceImpl.access$100(localApolloDaoManagerServiceImpl).getCurrentUin()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl.12
 * JD-Core Version:    0.7.0.1
 */