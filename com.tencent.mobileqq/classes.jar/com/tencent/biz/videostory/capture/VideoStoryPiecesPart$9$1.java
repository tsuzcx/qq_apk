package com.tencent.biz.videostory.capture;

import aciy;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;
import wut;

class VideoStoryPiecesPart$9$1
  implements Runnable
{
  VideoStoryPiecesPart$9$1(VideoStoryPiecesPart.9 param9) {}
  
  public void run()
  {
    if ((wut.a(this.a.this$0) != null) && (wut.a(this.a.this$0) != null))
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(wut.a(this.a.this$0));
      int i = aciy.a(36.0F, wut.a(this.a.this$0).getResources());
      localBitmapDrawable.setBounds(0, 0, i, i);
      wut.a(this.a.this$0).setImageDrawable(localBitmapDrawable);
      wut.a(this.a.this$0).setEnabled(true);
      return;
    }
    wut.a(this.a.this$0).setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.VideoStoryPiecesPart.9.1
 * JD-Core Version:    0.7.0.1
 */