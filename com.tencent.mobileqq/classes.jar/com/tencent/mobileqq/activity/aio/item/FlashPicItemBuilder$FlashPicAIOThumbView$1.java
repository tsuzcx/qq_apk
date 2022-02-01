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
      StringBuilder localStringBuilder;
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("cache flashpic abumb exception:");
        localStringBuilder.append(localException);
        QLog.d("Q.hotchat", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder.FlashPicAIOThumbView.1
 * JD-Core Version:    0.7.0.1
 */