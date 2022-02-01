package com.tencent.mobileqq.app;

import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.utils.OfflineUtils;

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
    QQAppInterface.access$3100(this.this$0);
    OfflineUtils.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.18
 * JD-Core Version:    0.7.0.1
 */