package com.tencent.biz.pubaccount.readinjoy.video;

import android.media.AudioManager;
import com.tencent.qphone.base.util.QLog;
import qvo;

public class VideoVolumeController$1
  implements Runnable
{
  public VideoVolumeController$1(qvo paramqvo) {}
  
  public void run()
  {
    if (qvo.a(this.this$0)) {
      if (qvo.a(this.this$0) != null) {
        qvo.a(this.this$0).requestAudioFocus(null, 3, 2);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoVolumeController", 2, "mRequestOrAbandonAudioFocusCallBack isFocusAudio:" + qvo.a(this.this$0));
      }
      return;
      if (qvo.a(this.this$0) != null) {
        qvo.a(this.this$0).abandonAudioFocus(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeController.1
 * JD-Core Version:    0.7.0.1
 */