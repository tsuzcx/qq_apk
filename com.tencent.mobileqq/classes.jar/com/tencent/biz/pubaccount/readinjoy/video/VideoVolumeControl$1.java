package com.tencent.biz.pubaccount.readinjoy.video;

import android.media.AudioManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import qhp;
import qji;

public class VideoVolumeControl$1
  implements Runnable
{
  public VideoVolumeControl$1(qji paramqji) {}
  
  public void run()
  {
    if (qji.a(this.this$0)) {
      if (qji.a(this.this$0) != null)
      {
        qji.a(this.this$0).requestAudioFocus(null, 3, 2);
        break label71;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "mRequestOrAbandonAudioFocusCallBack isFocusAudio:" + qji.a(this.this$0));
      }
      label71:
      return;
      if (qji.a(this.this$0) != null)
      {
        Iterator localIterator = qji.a(this.this$0).keySet().iterator();
        Object localObject;
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject = (qhp)localIterator.next();
            if ((localObject != null) && (((qhp)localObject).a()))
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "checkPlayState  IsPlaying When abandonAudioFocus:" + localObject);
              return;
            }
          }
        }
        localIterator = qji.b(this.this$0).keySet().iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject = (VideoFeedsPlayManager)localIterator.next();
            if ((localObject != null) && (((VideoFeedsPlayManager)localObject).c()))
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "checkPlayState  IsPlaying When abandonAudioFocus:" + localObject);
              return;
            }
          }
        }
        qji.a(this.this$0).abandonAudioFocus(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl.1
 * JD-Core Version:    0.7.0.1
 */