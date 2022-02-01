package com.tencent.mobileqq.banner;

import android.os.Message;

class BannerManager$1
  implements Runnable
{
  BannerManager$1(BannerManager paramBannerManager, int paramInt, Message paramMessage) {}
  
  public void run()
  {
    BannerManager localBannerManager = this.this$0;
    int i = this.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_AndroidOsMessage == null) {}
    for (Message localMessage = null;; localMessage = Message.obtain(this.jdField_a_of_type_AndroidOsMessage))
    {
      localBannerManager.a(i, localMessage);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.banner.BannerManager.1
 * JD-Core Version:    0.7.0.1
 */