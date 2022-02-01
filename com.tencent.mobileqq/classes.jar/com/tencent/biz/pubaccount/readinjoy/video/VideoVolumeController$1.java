package com.tencent.biz.pubaccount.readinjoy.video;

import android.media.AudioManager;
import com.tencent.qphone.base.util.QLog;
import seo;

public class VideoVolumeController$1
  implements Runnable
{
  public VideoVolumeController$1(seo paramseo) {}
  
  public void run()
  {
    if (seo.a(this.this$0)) {
      if (seo.a(this.this$0) != null) {
        seo.a(this.this$0).requestAudioFocus(null, 3, 2);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoVolumeController", 2, "mRequestOrAbandonAudioFocusCallBack isFocusAudio:" + seo.a(this.this$0));
      }
      return;
      if (seo.a(this.this$0) != null) {
        seo.a(this.this$0).abandonAudioFocus(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeController.1
 * JD-Core Version:    0.7.0.1
 */