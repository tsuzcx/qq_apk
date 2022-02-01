package com.tencent.biz.pubaccount.readinjoy.video;

import android.media.AudioManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class VideoVolumeControl$1
  implements Runnable
{
  VideoVolumeControl$1(VideoVolumeControl paramVideoVolumeControl) {}
  
  public void run()
  {
    if (VideoVolumeControl.a(this.this$0)) {
      if (VideoVolumeControl.a(this.this$0) != null)
      {
        VideoVolumeControl.a(this.this$0).requestAudioFocus(null, 3, 2);
        break label71;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "mRequestOrAbandonAudioFocusCallBack isFocusAudio:" + VideoVolumeControl.a(this.this$0));
      }
      label71:
      return;
      if (VideoVolumeControl.a(this.this$0) != null)
      {
        Iterator localIterator = VideoVolumeControl.a(this.this$0).keySet().iterator();
        Object localObject;
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject = (VideoPlayManager)localIterator.next();
            if ((localObject != null) && (((VideoPlayManager)localObject).b()) && (!((VideoPlayManager)localObject).a()))
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.w("Q.readinjoy.video.VideoVolumeControl", 2, "checkPlayState  IsPlaying & not Mute When abandonAudioFocus:" + localObject);
              return;
            }
          }
        }
        localIterator = VideoVolumeControl.b(this.this$0).keySet().iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject = (VideoFeedsPlayManager)localIterator.next();
            if ((localObject != null) && (((VideoFeedsPlayManager)localObject).d()) && (!((VideoFeedsPlayManager)localObject).c()))
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.w("Q.readinjoy.video.VideoVolumeControl", 2, "checkPlayState  IsPlaying & not Mute When abandonAudioFocus:" + localObject);
              return;
            }
          }
        }
        VideoVolumeControl.a(this.this$0).abandonAudioFocus(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl.1
 * JD-Core Version:    0.7.0.1
 */