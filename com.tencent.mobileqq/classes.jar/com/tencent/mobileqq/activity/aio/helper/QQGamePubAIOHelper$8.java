package com.tencent.mobileqq.activity.aio.helper;

import android.os.Handler;
import java.util.List;

class QQGamePubAIOHelper$8
  implements Runnable
{
  QQGamePubAIOHelper$8(QQGamePubAIOHelper paramQQGamePubAIOHelper) {}
  
  public void run()
  {
    QQGamePubAIOHelper.a().clear();
    if (QQGamePubAIOHelper.a() != null)
    {
      QQGamePubAIOHelper.a().removeCallbacksAndMessages(null);
      QQGamePubAIOHelper.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QQGamePubAIOHelper.8
 * JD-Core Version:    0.7.0.1
 */