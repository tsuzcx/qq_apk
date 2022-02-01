package com.tencent.biz.pubaccount.readinjoy.video;

import android.media.AudioManager;
import com.tencent.qphone.base.util.QLog;

class VideoVolumeController$1
  implements Runnable
{
  VideoVolumeController$1(VideoVolumeController paramVideoVolumeController) {}
  
  public void run()
  {
    if (VideoVolumeController.a(this.this$0)) {
      if (VideoVolumeController.a(this.this$0) != null) {
        VideoVolumeController.a(this.this$0).requestAudioFocus(null, 3, 2);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoVolumeController", 2, "mRequestOrAbandonAudioFocusCallBack isFocusAudio:" + VideoVolumeController.a(this.this$0));
      }
      return;
      if (VideoVolumeController.a(this.this$0) != null) {
        VideoVolumeController.a(this.this$0).abandonAudioFocus(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeController.1
 * JD-Core Version:    0.7.0.1
 */