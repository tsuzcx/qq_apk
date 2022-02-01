package com.tencent.aelight.camera.aeeditor.view.videotrack;

import android.view.View;
import android.view.View.OnClickListener;

class VideoTrackContainerView$4
  implements View.OnClickListener
{
  VideoTrackContainerView$4(VideoTrackContainerView paramVideoTrackContainerView, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (!paramView.isSelected()) {
      paramView.setSelected(true);
    }
    if (VideoTrackContainerView.e(this.b) != null) {
      VideoTrackContainerView.e(this.b).a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.videotrack.VideoTrackContainerView.4
 * JD-Core Version:    0.7.0.1
 */