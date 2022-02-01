package com.tencent.aelight.camera.aeeditor.view.videotrack;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.aelight.camera.aeeditor.view.transition.listener.OnTransitionListener;

class VideoTrackContainerView$5
  implements View.OnClickListener
{
  VideoTrackContainerView$5(VideoTrackContainerView paramVideoTrackContainerView) {}
  
  public void onClick(View paramView)
  {
    if (VideoTrackContainerView.a(this.a) == null) {
      return;
    }
    int i = VideoTrackContainerView.a(this.a, (ImageView)paramView);
    if (i == -1) {
      return;
    }
    VideoTrackContainerView.a(this.a, paramView);
    VideoTrackContainerView.a(this.a).a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.videotrack.VideoTrackContainerView.5
 * JD-Core Version:    0.7.0.1
 */