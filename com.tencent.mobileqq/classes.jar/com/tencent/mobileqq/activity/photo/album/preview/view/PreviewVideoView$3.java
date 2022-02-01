package com.tencent.mobileqq.activity.photo.album.preview.view;

import com.tencent.mobileqq.videoplatform.view.BaseVideoView;

class PreviewVideoView$3
  implements Runnable
{
  PreviewVideoView$3(PreviewVideoView paramPreviewVideoView) {}
  
  public void run()
  {
    PreviewVideoView.a(this.this$0, false);
    if ((PreviewVideoView.a(this.this$0) != null) && (PreviewVideoView.a(this.this$0).getCurPlayingPos() > 0L)) {
      PreviewVideoView.b(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.preview.view.PreviewVideoView.3
 * JD-Core Version:    0.7.0.1
 */