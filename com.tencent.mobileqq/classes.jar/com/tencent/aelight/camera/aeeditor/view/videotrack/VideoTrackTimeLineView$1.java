package com.tencent.aelight.camera.aeeditor.view.videotrack;

import android.graphics.Bitmap;
import com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.IPlayTrackViewBitmapProvider;
import com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.VideoThumbProviderManager;
import com.tencent.qcircle.weseevideo.camera.mvauto.redo.CutModelKt;
import com.tencent.qcircle.weseevideo.camera.mvauto.redo.VideoResourceModelKt;

class VideoTrackTimeLineView$1
  implements IPlayTrackViewBitmapProvider
{
  VideoTrackTimeLineView$1(VideoTrackTimeLineView paramVideoTrackTimeLineView) {}
  
  public Bitmap getBitmap(long paramLong)
  {
    if (VideoTrackTimeLineView.a(this.a) == null) {
      return VideoThumbProviderManager.getInstance().getBitmapByTime(0L, null, "");
    }
    if (VideoTrackTimeLineView.a(this.a).getResource().getScaleDuration() == 0L) {
      paramLong = VideoTrackTimeLineView.a(this.a).getResource().getSelectTimeStart() + paramLong;
    } else {
      paramLong = ((float)VideoTrackTimeLineView.a(this.a).getResource().getSelectTimeStart() + (float)(paramLong * VideoTrackTimeLineView.a(this.a).getResource().getSelectTimeDuration()) * 1.0F / (float)VideoTrackTimeLineView.a(this.a).getResource().getScaleDuration());
    }
    return VideoThumbProviderManager.getInstance().getBitmapByTime(paramLong, this.a.getAssetPath(), VideoTrackTimeLineView.a(this.a).getResource().getPath());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.videotrack.VideoTrackTimeLineView.1
 * JD-Core Version:    0.7.0.1
 */