package com.tencent.aelight.camera.aeeditor.view.videotrack;

import android.graphics.Bitmap;
import com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.VideoThumbListener;
import com.tencent.tav.coremedia.CMTime;

class VideoTrackContainerView$14
  implements VideoThumbListener
{
  VideoTrackContainerView$14(VideoTrackContainerView paramVideoTrackContainerView) {}
  
  public void onThumbGenerated(Object paramObject, CMTime paramCMTime, Bitmap paramBitmap)
  {
    if ((paramObject instanceof String)) {
      this.a.a((String)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.videotrack.VideoTrackContainerView.14
 * JD-Core Version:    0.7.0.1
 */