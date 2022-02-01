package com.tencent.mobileqq.apollo.view.pannel.viewbinder;

import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class ApolloTagActionViewBinder$4
  implements Runnable
{
  ApolloTagActionViewBinder$4(ApolloTagActionViewBinder paramApolloTagActionViewBinder, String paramString) {}
  
  public void run()
  {
    ApolloDaoManagerServiceImpl localApolloDaoManagerServiceImpl = (ApolloDaoManagerServiceImpl)this.this$0.a.getRuntimeService(IApolloDaoManagerService.class, "all");
    if (localApolloDaoManagerServiceImpl == null) {
      return;
    }
    localApolloDaoManagerServiceImpl.getActionIdListByPkgIdAndTagName(this.this$0.d, this.a, new ApolloTagActionViewBinder.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloTagActionViewBinder.4
 * JD-Core Version:    0.7.0.1
 */