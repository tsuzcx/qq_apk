package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.config.business.AIORelatedEmotionConfProcessor;
import com.tencent.mobileqq.config.business.QQSysAndEmojiConfProcessor;

class AIORelatedEmotionHelper$1
  implements Runnable
{
  AIORelatedEmotionHelper$1(AIORelatedEmotionHelper paramAIORelatedEmotionHelper) {}
  
  public void run()
  {
    AIORelatedEmotionConfProcessor.a();
    QQSysAndEmojiConfProcessor.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIORelatedEmotionHelper.1
 * JD-Core Version:    0.7.0.1
 */