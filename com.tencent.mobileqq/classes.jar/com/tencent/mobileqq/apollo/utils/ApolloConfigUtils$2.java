package com.tencent.mobileqq.apollo.utils;

import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl;
import mqq.app.AppRuntime;

final class ApolloConfigUtils$2
  implements Runnable
{
  ApolloConfigUtils$2(AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    ApolloDaoManagerServiceImpl localApolloDaoManagerServiceImpl = (ApolloDaoManagerServiceImpl)this.a.getRuntimeService(IApolloDaoManagerService.class, "all");
    if (localApolloDaoManagerServiceImpl.mIsGameTabNotReady) {
      localApolloDaoManagerServiceImpl.updateGamePackageInfo(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloConfigUtils.2
 * JD-Core Version:    0.7.0.1
 */