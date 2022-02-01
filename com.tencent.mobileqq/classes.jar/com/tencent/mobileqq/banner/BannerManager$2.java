package com.tencent.mobileqq.banner;

import android.os.Message;

class BannerManager$2
  implements Runnable
{
  BannerManager$2(BannerManager paramBannerManager, Message paramMessage, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidOsMessage == null) {}
    for (Message localMessage = null;; localMessage = Message.obtain(this.jdField_a_of_type_AndroidOsMessage))
    {
      this.this$0.a(this.jdField_a_of_type_Int, this.b);
      this.this$0.a(this.jdField_a_of_type_Int, localMessage);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.banner.BannerManager.2
 * JD-Core Version:    0.7.0.1
 */