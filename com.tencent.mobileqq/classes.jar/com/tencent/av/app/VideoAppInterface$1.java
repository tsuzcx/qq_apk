package com.tencent.av.app;

import com.tencent.av.avsdkconfig.QavSdkConfigHelper;
import com.tencent.av.business.config.MediaCodecChipConfigManager;
import com.tencent.qphone.base.util.QLog;

class VideoAppInterface$1
  implements Runnable
{
  VideoAppInterface$1(VideoAppInterface paramVideoAppInterface) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(VideoAppInterface.c(), 2, "Async load mediaCodecChipConfig.");
    }
    MediaCodecChipConfigManager.a().a();
    QavSdkConfigHelper.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.VideoAppInterface.1
 * JD-Core Version:    0.7.0.1
 */