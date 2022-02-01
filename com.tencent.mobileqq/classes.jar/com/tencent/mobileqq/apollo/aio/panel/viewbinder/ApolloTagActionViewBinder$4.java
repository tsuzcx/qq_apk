package com.tencent.mobileqq.apollo.aio.panel.viewbinder;

import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class ApolloTagActionViewBinder$4
  implements Runnable
{
  ApolloTagActionViewBinder$4(ApolloTagActionViewBinder paramApolloTagActionViewBinder, String paramString) {}
  
  public void run()
  {
    ((ApolloDaoManagerServiceImpl)this.this$0.j.getRuntimeService(IApolloDaoManagerService.class, "all")).getActionIdListByPkgIdAndTagName(this.this$0.n, this.a, new ApolloTagActionViewBinder.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloTagActionViewBinder.4
 * JD-Core Version:    0.7.0.1
 */