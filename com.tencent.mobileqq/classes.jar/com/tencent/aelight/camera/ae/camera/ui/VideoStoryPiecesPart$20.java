package com.tencent.aelight.camera.ae.camera.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.aelight.camera.aebase.QIMCameraUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;

class VideoStoryPiecesPart$20
  implements Runnable
{
  VideoStoryPiecesPart$20(VideoStoryPiecesPart paramVideoStoryPiecesPart) {}
  
  public void run()
  {
    try
    {
      VideoStoryPiecesPart.a(this.this$0, QIMCameraUtil.a(VideoStoryPiecesPart.ah(this.this$0), true));
      if ((VideoStoryPiecesPart.ai(this.this$0) != null) && (!VideoStoryPiecesPart.ai(this.this$0).isRecycled())) {
        VideoStoryPiecesPart.a(this.this$0, ImageUtil.b(VideoStoryPiecesPart.ai(this.this$0), ViewUtils.dip2px(3.0F), VideoStoryPiecesPart.ai(this.this$0).getWidth(), VideoStoryPiecesPart.ai(this.this$0).getHeight()));
      }
      VideoStoryPiecesPart.aj(this.this$0).runOnUiThread(new VideoStoryPiecesPart.20.1(this));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.20
 * JD-Core Version:    0.7.0.1
 */