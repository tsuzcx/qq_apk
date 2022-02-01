package com.tencent.aelight.camera.ae.camera.ui;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class VideoStoryPiecesPart$20$1
  implements Runnable
{
  VideoStoryPiecesPart$20$1(VideoStoryPiecesPart.20 param20) {}
  
  public void run()
  {
    if ((VideoStoryPiecesPart.ai(this.a.this$0) != null) && (VideoStoryPiecesPart.s(this.a.this$0) != null))
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(VideoStoryPiecesPart.ai(this.a.this$0));
      int i = AIOUtils.b(36.0F, VideoStoryPiecesPart.s(this.a.this$0).getResources());
      localBitmapDrawable.setBounds(0, 0, i, i);
      VideoStoryPiecesPart.s(this.a.this$0).setImageDrawable(localBitmapDrawable);
      VideoStoryPiecesPart.c(this.a.this$0, true);
      return;
    }
    VideoStoryPiecesPart.c(this.a.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.20.1
 * JD-Core Version:    0.7.0.1
 */