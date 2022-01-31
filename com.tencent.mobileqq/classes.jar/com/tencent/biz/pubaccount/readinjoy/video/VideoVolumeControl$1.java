package com.tencent.biz.pubaccount.readinjoy.video;

import android.media.AudioManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import qtr;
import qvk;

public class VideoVolumeControl$1
  implements Runnable
{
  public VideoVolumeControl$1(qvk paramqvk) {}
  
  public void run()
  {
    if (qvk.a(this.this$0)) {
      if (qvk.a(this.this$0) != null)
      {
        qvk.a(this.this$0).requestAudioFocus(null, 3, 2);
        break label71;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "mRequestOrAbandonAudioFocusCallBack isFocusAudio:" + qvk.a(this.this$0));
      }
      label71:
      return;
      if (qvk.a(this.this$0) != null)
      {
        Iterator localIterator = qvk.a(this.this$0).keySet().iterator();
        Object localObject;
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject = (qtr)localIterator.next();
            if ((localObject != null) && (((qtr)localObject).b()) && (!((qtr)localObject).a()))
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.w("Q.readinjoy.video.VideoVolumeControl", 2, "checkPlayState  IsPlaying & not Mute When abandonAudioFocus:" + localObject);
              return;
            }
          }
        }
        localIterator = qvk.b(this.this$0).keySet().iterator();
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
        qvk.a(this.this$0).abandonAudioFocus(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl.1
 * JD-Core Version:    0.7.0.1
 */