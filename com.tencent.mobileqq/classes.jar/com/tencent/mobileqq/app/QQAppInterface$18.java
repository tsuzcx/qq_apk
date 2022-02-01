package com.tencent.mobileqq.app;

import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager;
import com.tencent.mobileqq.kandian.biz.pts.api.IOfflineUtils;
import com.tencent.mobileqq.qroute.QRoute;

class QQAppInterface$18
  implements Runnable
{
  QQAppInterface$18(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    AdvertisementVideoPreloadManager localAdvertisementVideoPreloadManager = (AdvertisementVideoPreloadManager)this.this$0.getManager(QQManagerFactory.PUBLIC_ACCOUNT_VIDEO_PRELOAD_MANAGER);
    if (localAdvertisementVideoPreloadManager != null) {
      localAdvertisementVideoPreloadManager.a(1);
    }
    this.this$0.setTalkbackSwitch();
    ((IOfflineUtils)QRoute.api(IOfflineUtils.class)).checkOfflineDirExist();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.18
 * JD-Core Version:    0.7.0.1
 */