package com.tencent.biz.pubaccount.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import java.lang.ref.WeakReference;

class PublicAccountManagerImpl$4
  implements Runnable
{
  PublicAccountManagerImpl$4(PublicAccountManagerImpl paramPublicAccountManagerImpl) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.this$0.mApp.get();
    String str = this.this$0.mTempKey;
    boolean bool = this.this$0.mIsNewMenu;
    if ((this.this$0.mTempContext != null) && (this.this$0.mTempContext.get() != null) && (localQQAppInterface != null)) {
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new PublicAccountManagerImpl.4.1(this, 1, true, true, 0L, true, false, "PublicAccountManager", str, bool));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountManagerImpl.4
 * JD-Core Version:    0.7.0.1
 */