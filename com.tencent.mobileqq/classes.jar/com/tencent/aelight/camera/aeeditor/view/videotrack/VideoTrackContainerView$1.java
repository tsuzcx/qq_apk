package com.tencent.aelight.camera.aeeditor.view.videotrack;

class VideoTrackContainerView$1
  implements Runnable
{
  VideoTrackContainerView$1(VideoTrackContainerView paramVideoTrackContainerView) {}
  
  public void run()
  {
    int i = this.this$0.getScrollX();
    if (VideoTrackContainerView.a(this.this$0) - i == 0)
    {
      if (VideoTrackContainerView.b(this.this$0) != null) {
        VideoTrackContainerView.b(this.this$0).a();
      }
    }
    else
    {
      VideoTrackContainerView.a(this.this$0, i);
      VideoTrackContainerView localVideoTrackContainerView = this.this$0;
      localVideoTrackContainerView.postDelayed(VideoTrackContainerView.c(localVideoTrackContainerView), 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.videotrack.VideoTrackContainerView.1
 * JD-Core Version:    0.7.0.1
 */