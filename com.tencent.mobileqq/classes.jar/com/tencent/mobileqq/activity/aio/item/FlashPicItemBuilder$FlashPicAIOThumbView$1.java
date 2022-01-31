package com.tencent.mobileqq.activity.aio.item;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class FlashPicItemBuilder$FlashPicAIOThumbView$1
  implements Runnable
{
  FlashPicItemBuilder$FlashPicAIOThumbView$1(FlashPicItemBuilder.FlashPicAIOThumbView paramFlashPicAIOThumbView) {}
  
  public void run()
  {
    try
    {
      synchronized (BaseApplicationImpl.sImageCache) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder.FlashPicAIOThumbView.1
 * JD-Core Version:    0.7.0.1
 */