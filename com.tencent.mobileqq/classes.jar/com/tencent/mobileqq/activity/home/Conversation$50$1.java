package com.tencent.mobileqq.activity.home;

import android.os.Message;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.activity.recent.bannerprocessor.MultiVideoBannerProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.BannerManager;

class Conversation$50$1
  implements Runnable
{
  Conversation$50$1(Conversation.50 param50, long paramLong) {}
  
  public void run()
  {
    if (this.b.b.y != null)
    {
      this.b.b.y.b(MultiVideoBannerProcessor.a, 2000);
      if (this.b.b.s().getAVNotifyCenter().e(this.a) == 2)
      {
        Message localMessage = new Message();
        localMessage.obj = Long.valueOf(this.a);
        this.b.b.y.a(MultiVideoBannerProcessor.a, localMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.50.1
 * JD-Core Version:    0.7.0.1
 */