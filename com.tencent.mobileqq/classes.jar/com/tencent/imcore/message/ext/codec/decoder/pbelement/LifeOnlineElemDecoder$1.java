package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;

class LifeOnlineElemDecoder$1
  implements Runnable
{
  LifeOnlineElemDecoder$1(LifeOnlineElemDecoder paramLifeOnlineElemDecoder, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).preloadWebProcess(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.pbelement.LifeOnlineElemDecoder.1
 * JD-Core Version:    0.7.0.1
 */