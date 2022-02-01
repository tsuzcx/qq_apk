package com.tencent.aelight.camera.ae.camera.ui;

import android.text.TextUtils;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;

class VideoStoryPiecesPart$4
  implements Runnable
{
  VideoStoryPiecesPart$4(VideoStoryPiecesPart paramVideoStoryPiecesPart, String paramString) {}
  
  public void run()
  {
    if ((AECameraEntryManager.f(VideoStoryPiecesPart.b(this.this$0))) && (!TextUtils.isEmpty(this.a)) && (VideoStoryPiecesPart.t(this.this$0)) && (VideoStoryPiecesPart.u(this.this$0)))
    {
      VideoStoryPiecesPart.w(this.this$0);
      return;
    }
    VideoStoryPiecesPart.v(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.4
 * JD-Core Version:    0.7.0.1
 */