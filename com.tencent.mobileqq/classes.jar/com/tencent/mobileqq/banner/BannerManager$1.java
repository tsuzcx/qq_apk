package com.tencent.mobileqq.banner;

import android.os.Message;

class BannerManager$1
  implements Runnable
{
  BannerManager$1(BannerManager paramBannerManager, int paramInt, Message paramMessage) {}
  
  public void run()
  {
    BannerManager localBannerManager = this.this$0;
    int i = this.a;
    Message localMessage = this.b;
    if (localMessage == null) {
      localMessage = null;
    } else {
      localMessage = Message.obtain(localMessage);
    }
    localBannerManager.a(i, localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.banner.BannerManager.1
 * JD-Core Version:    0.7.0.1
 */