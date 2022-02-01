package com.tencent.mobileqq.activity.aio.helper;

import android.os.Handler;
import java.util.List;

class QQGamePubAIOHelper$9
  implements Runnable
{
  QQGamePubAIOHelper$9(QQGamePubAIOHelper paramQQGamePubAIOHelper) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QQGamePubAIOHelper.9
 * JD-Core Version:    0.7.0.1
 */