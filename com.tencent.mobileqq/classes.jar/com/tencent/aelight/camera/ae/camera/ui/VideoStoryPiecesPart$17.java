package com.tencent.aelight.camera.ae.camera.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.aelight.camera.aebase.QIMCameraUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;

class VideoStoryPiecesPart$17
  implements Runnable
{
  VideoStoryPiecesPart$17(VideoStoryPiecesPart paramVideoStoryPiecesPart) {}
  
  public void run()
  {
    try
    {
      VideoStoryPiecesPart.a(this.this$0, QIMCameraUtil.a(VideoStoryPiecesPart.j(this.this$0), true));
      if ((VideoStoryPiecesPart.a(this.this$0) != null) && (!VideoStoryPiecesPart.a(this.this$0).isRecycled())) {
        VideoStoryPiecesPart.a(this.this$0, ImageUtil.b(VideoStoryPiecesPart.a(this.this$0), ViewUtils.a(3.0F), VideoStoryPiecesPart.a(this.this$0).getWidth(), VideoStoryPiecesPart.a(this.this$0).getHeight()));
      }
      VideoStoryPiecesPart.k(this.this$0).runOnUiThread(new VideoStoryPiecesPart.17.1(this));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.17
 * JD-Core Version:    0.7.0.1
 */