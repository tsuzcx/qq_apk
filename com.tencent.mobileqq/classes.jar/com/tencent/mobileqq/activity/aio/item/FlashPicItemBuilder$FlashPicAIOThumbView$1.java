package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.qphone.base.util.QLog;

class FlashPicItemBuilder$FlashPicAIOThumbView$1
  implements Runnable
{
  FlashPicItemBuilder$FlashPicAIOThumbView$1(FlashPicItemBuilder.FlashPicAIOThumbView paramFlashPicAIOThumbView) {}
  
  public void run()
  {
    try
    {
      synchronized (GlobalImageCache.a) {}
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.hotchat", 2, "cache flashpic abumb exception:" + localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder.FlashPicAIOThumbView.1
 * JD-Core Version:    0.7.0.1
 */