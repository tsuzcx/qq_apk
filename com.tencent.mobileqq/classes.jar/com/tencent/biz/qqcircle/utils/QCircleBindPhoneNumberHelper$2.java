package com.tencent.biz.qqcircle.utils;

import com.tencent.biz.qqcircle.QCirclePluginConfig;

final class QCircleBindPhoneNumberHelper$2
  implements Runnable
{
  public void run()
  {
    QCirclePluginConfig localQCirclePluginConfig = QCirclePluginConfig.a();
    if ((localQCirclePluginConfig != null) && (localQCirclePluginConfig.u() == 1)) {
      return;
    }
    QCircleBindPhoneNumberHelper.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleBindPhoneNumberHelper.2
 * JD-Core Version:    0.7.0.1
 */