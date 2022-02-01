package com.qwallet.temp.impl;

import android.app.Activity;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.AppRuntime;

class QWalletApiProxyImpl$2
  implements Runnable
{
  QWalletApiProxyImpl$2(QWalletApiProxyImpl paramQWalletApiProxyImpl, AppRuntime paramAppRuntime, Activity paramActivity) {}
  
  public void run()
  {
    try
    {
      if (((this.jdField_a_of_type_MqqAppAppRuntime instanceof AppInterface)) && (this.jdField_a_of_type_MqqAppAppRuntime.isLogin()) && (!((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isFollowUin((AppInterface)this.jdField_a_of_type_MqqAppAppRuntime, "2711679534")))
      {
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).followUin((AppInterface)this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_AndroidAppActivity, "2711679534", null, false, 6);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.qwallet.temp.impl.QWalletApiProxyImpl.2
 * JD-Core Version:    0.7.0.1
 */