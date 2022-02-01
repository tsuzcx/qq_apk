package com.tencent.mobileqq.apollo.view.pannel.viewbinder;

import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class ApolloTagActionViewBinder$1
  implements Runnable
{
  ApolloTagActionViewBinder$1(ApolloTagActionViewBinder paramApolloTagActionViewBinder) {}
  
  public void run()
  {
    ApolloDaoManagerServiceImpl localApolloDaoManagerServiceImpl = (ApolloDaoManagerServiceImpl)this.this$0.a.getRuntimeService(IApolloDaoManagerService.class, "all");
    if (localApolloDaoManagerServiceImpl == null) {
      return;
    }
    localApolloDaoManagerServiceImpl.getTagListByPkgId(this.this$0.d, new ApolloTagActionViewBinder.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloTagActionViewBinder.1
 * JD-Core Version:    0.7.0.1
 */