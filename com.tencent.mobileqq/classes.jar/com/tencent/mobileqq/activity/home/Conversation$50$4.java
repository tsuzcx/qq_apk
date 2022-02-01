package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.activity.recent.bannerprocessor.MultiVideoBannerProcessor;
import com.tencent.mobileqq.banner.BannerManager;

class Conversation$50$4
  implements Runnable
{
  Conversation$50$4(Conversation.50 param50) {}
  
  public void run()
  {
    if (this.a.b.y != null)
    {
      this.a.b.y.b(MultiVideoBannerProcessor.a, 2000);
      this.a.b.y.a(-1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.50.4
 * JD-Core Version:    0.7.0.1
 */