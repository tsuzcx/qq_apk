package com.tencent.mobileqq.activity.aio.helper;

import agjm;
import android.os.Handler;
import java.util.List;

public class QQGamePubAIOHelper$8
  implements Runnable
{
  public QQGamePubAIOHelper$8(agjm paramagjm) {}
  
  public void run()
  {
    agjm.a().clear();
    if (agjm.a() != null)
    {
      agjm.a().removeCallbacksAndMessages(null);
      agjm.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QQGamePubAIOHelper.8
 * JD-Core Version:    0.7.0.1
 */