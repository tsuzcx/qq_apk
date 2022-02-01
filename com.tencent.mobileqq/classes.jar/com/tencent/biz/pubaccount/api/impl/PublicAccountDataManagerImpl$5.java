package com.tencent.biz.pubaccount.api.impl;

import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class PublicAccountDataManagerImpl$5
  implements Runnable
{
  PublicAccountDataManagerImpl$5(PublicAccountDataManagerImpl paramPublicAccountDataManagerImpl) {}
  
  public void run()
  {
    QLog.d("Q.contacttab.pub", 2, "preGetKandianSubscribe account info!");
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getPublicAccountDetailRequest(this.this$0.app, BaseApplication.getContext(), null, AppConstants.KANDIAN_SUBSCRIBE_UIN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountDataManagerImpl.5
 * JD-Core Version:    0.7.0.1
 */