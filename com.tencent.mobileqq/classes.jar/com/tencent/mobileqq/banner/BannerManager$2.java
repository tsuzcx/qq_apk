package com.tencent.mobileqq.banner;

import android.os.Message;

class BannerManager$2
  implements Runnable
{
  BannerManager$2(BannerManager paramBannerManager, Message paramMessage, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Message localMessage = this.a;
    if (localMessage == null) {
      localMessage = null;
    } else {
      localMessage = Message.obtain(localMessage);
    }
    this.this$0.a(this.b, this.c);
    this.this$0.a(this.b, localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.banner.BannerManager.2
 * JD-Core Version:    0.7.0.1
 */