package com.tencent.biz.videostory.capture;

import android.app.Activity;
import android.graphics.Bitmap;
import bacm;
import bajq;
import bhdq;
import wut;

public class VideoStoryPiecesPart$9
  implements Runnable
{
  public VideoStoryPiecesPart$9(wut paramwut) {}
  
  public void run()
  {
    try
    {
      wut.a(this.this$0, bhdq.a(this.this$0.a, true));
      if ((wut.a(this.this$0) != null) && (!wut.a(this.this$0).isRecycled())) {
        wut.a(this.this$0, bacm.b(wut.a(this.this$0), bajq.a(3.0F), wut.a(this.this$0).getWidth(), wut.a(this.this$0).getHeight()));
      }
      this.this$0.a.runOnUiThread(new VideoStoryPiecesPart.9.1(this));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.VideoStoryPiecesPart.9
 * JD-Core Version:    0.7.0.1
 */