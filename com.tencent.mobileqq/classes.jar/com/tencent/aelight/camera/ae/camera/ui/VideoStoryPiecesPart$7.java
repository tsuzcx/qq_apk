package com.tencent.aelight.camera.ae.camera.ui;

import android.text.TextUtils;
import com.tencent.aelight.camera.log.AEQLog;

class VideoStoryPiecesPart$7
  implements Runnable
{
  VideoStoryPiecesPart$7(VideoStoryPiecesPart paramVideoStoryPiecesPart) {}
  
  public void run()
  {
    AEQLog.b("VideoStoryPiecesPart", "receive template update event");
    if (!VideoStoryPiecesPart.y(this.this$0))
    {
      if (VideoStoryPiecesPart.z(this.this$0)) {
        return;
      }
      if ((TextUtils.isEmpty(VideoStoryPiecesPart.A(this.this$0))) || (!VideoStoryPiecesPart.t(this.this$0)) || (!VideoStoryPiecesPart.u(this.this$0))) {
        VideoStoryPiecesPart.v(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.7
 * JD-Core Version:    0.7.0.1
 */