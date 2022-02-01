package com.tencent.aelight.camera.ae.gif.video;

import android.graphics.Bitmap;
import com.tencent.view.RendererUtils;

class VideoGIFCreator$2
  implements Runnable
{
  VideoGIFCreator$2(VideoGIFCreator paramVideoGIFCreator, Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void run()
  {
    VideoGIFCreator localVideoGIFCreator = this.this$0;
    VideoGIFCreator.a(localVideoGIFCreator, new VideoGIFCreator.TextConfig(localVideoGIFCreator));
    VideoGIFCreator.j(this.this$0).a = RendererUtils.createTexture(this.a);
    VideoGIFCreator.j(this.this$0).b = this.b;
    VideoGIFCreator.j(this.this$0).c = this.c;
    VideoGIFCreator.j(this.this$0).d = this.d;
    VideoGIFCreator.j(this.this$0).e = this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.video.VideoGIFCreator.2
 * JD-Core Version:    0.7.0.1
 */