package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.activity.recent.bannerprocessor.LoginDevicesBannerProcessor;
import com.tencent.mobileqq.banner.BannerManager;

class Conversation$41$3
  implements Runnable
{
  Conversation$41$3(Conversation.41 param41, int paramInt) {}
  
  public void run()
  {
    if (this.a == 1)
    {
      this.b.a.y.a(LoginDevicesBannerProcessor.a, 2, null);
      return;
    }
    this.b.a.y.b(LoginDevicesBannerProcessor.a, 2000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.41.3
 * JD-Core Version:    0.7.0.1
 */