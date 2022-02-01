package com.tencent.aelight.camera.ae.camera.ui;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class VideoStoryPiecesPart$17$1
  implements Runnable
{
  VideoStoryPiecesPart$17$1(VideoStoryPiecesPart.17 param17) {}
  
  public void run()
  {
    if ((VideoStoryPiecesPart.a(this.a.this$0) != null) && (VideoStoryPiecesPart.a(this.a.this$0) != null))
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(VideoStoryPiecesPart.a(this.a.this$0));
      int i = AIOUtils.b(36.0F, VideoStoryPiecesPart.a(this.a.this$0).getResources());
      localBitmapDrawable.setBounds(0, 0, i, i);
      VideoStoryPiecesPart.a(this.a.this$0).setImageDrawable(localBitmapDrawable);
      VideoStoryPiecesPart.a(this.a.this$0).setEnabled(true);
      return;
    }
    VideoStoryPiecesPart.a(this.a.this$0).setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.17.1
 * JD-Core Version:    0.7.0.1
 */