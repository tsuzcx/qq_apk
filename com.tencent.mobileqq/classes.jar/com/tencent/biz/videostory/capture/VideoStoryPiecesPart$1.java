package com.tencent.biz.videostory.capture;

import aciy;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;
import wut;

public class VideoStoryPiecesPart$1
  implements Runnable
{
  public VideoStoryPiecesPart$1(wut paramwut) {}
  
  public void run()
  {
    Drawable localDrawable = this.this$0.a.getResources().getDrawable(2130848018);
    int i = aciy.a(36.0F, this.this$0.a.getResources());
    localDrawable.setBounds(0, 0, i, i);
    wut.a(this.this$0).setImageDrawable(localDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.VideoStoryPiecesPart.1
 * JD-Core Version:    0.7.0.1
 */