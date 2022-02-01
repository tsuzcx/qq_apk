package com.tencent.mobileqq.apollo.aio.panel.viewbinder;

import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class ApolloTagActionViewBinder$1
  implements Runnable
{
  ApolloTagActionViewBinder$1(ApolloTagActionViewBinder paramApolloTagActionViewBinder) {}
  
  public void run()
  {
    ((ApolloDaoManagerServiceImpl)this.this$0.a.getRuntimeService(IApolloDaoManagerService.class, "all")).getTagListByPkgId(this.this$0.d, new ApolloTagActionViewBinder.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloTagActionViewBinder.1
 * JD-Core Version:    0.7.0.1
 */