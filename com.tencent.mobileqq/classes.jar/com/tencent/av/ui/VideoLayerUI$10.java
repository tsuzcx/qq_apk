package com.tencent.av.ui;

class VideoLayerUI$10
  implements Runnable
{
  long a = 0L;
  
  VideoLayerUI$10(VideoLayerUI paramVideoLayerUI, long paramLong, GLVideoView paramGLVideoView, float paramFloat) {}
  
  public void run()
  {
    long l = this.a;
    this.a = (1L + l);
    if (l < this.b)
    {
      this.c.a(this.d, VideoLayerUI.e(this.this$0), VideoLayerUI.f(this.this$0));
      this.c.a(this, 10L);
      return;
    }
    this.c.a(0, 0, true);
    VideoLayerUI.a(this.this$0, -1);
    VideoLayerUI.b(this.this$0, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI.10
 * JD-Core Version:    0.7.0.1
 */