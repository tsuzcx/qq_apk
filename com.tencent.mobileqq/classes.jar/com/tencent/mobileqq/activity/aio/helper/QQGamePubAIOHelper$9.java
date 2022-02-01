package com.tencent.mobileqq.activity.aio.helper;

import android.os.Handler;
import java.util.List;

class QQGamePubAIOHelper$9
  implements Runnable
{
  QQGamePubAIOHelper$9(QQGamePubAIOHelper paramQQGamePubAIOHelper) {}
  
  public void run()
  {
    QQGamePubAIOHelper.c().clear();
    if (QQGamePubAIOHelper.d() != null)
    {
      QQGamePubAIOHelper.d().removeCallbacksAndMessages(null);
      QQGamePubAIOHelper.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QQGamePubAIOHelper.9
 * JD-Core Version:    0.7.0.1
 */