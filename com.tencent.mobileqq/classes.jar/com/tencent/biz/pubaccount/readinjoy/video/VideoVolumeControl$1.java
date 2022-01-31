package com.tencent.biz.pubaccount.readinjoy.video;

import android.media.AudioManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import rjg;
import rlb;

public class VideoVolumeControl$1
  implements Runnable
{
  public VideoVolumeControl$1(rlb paramrlb) {}
  
  public void run()
  {
    if (rlb.a(this.this$0)) {
      if (rlb.a(this.this$0) != null)
      {
        rlb.a(this.this$0).requestAudioFocus(null, 3, 2);
        break label71;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "mRequestOrAbandonAudioFocusCallBack isFocusAudio:" + rlb.a(this.this$0));
      }
      label71:
      return;
      if (rlb.a(this.this$0) != null)
      {
        Iterator localIterator = rlb.a(this.this$0).keySet().iterator();
        Object localObject;
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject = (rjg)localIterator.next();
            if ((localObject != null) && (((rjg)localObject).b()) && (!((rjg)localObject).a()))
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.w("Q.readinjoy.video.VideoVolumeControl", 2, "checkPlayState  IsPlaying & not Mute When abandonAudioFocus:" + localObject);
              return;
            }
          }
        }
        localIterator = rlb.b(this.this$0).keySet().iterator();
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
        rlb.a(this.this$0).abandonAudioFocus(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl.1
 * JD-Core Version:    0.7.0.1
 */