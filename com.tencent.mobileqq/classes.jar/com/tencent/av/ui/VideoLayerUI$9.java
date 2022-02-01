package com.tencent.av.ui;

class VideoLayerUI$9
  implements Runnable
{
  VideoLayerUI$9(VideoLayerUI paramVideoLayerUI, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int i;
    if ((VideoLayerUI.b(this.this$0)) && (this.a == VideoLayerUI.c(this.this$0)) && (this.b == VideoLayerUI.d(this.this$0))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      this.this$0.a("sliderWindowBigToSmallAnimation", this.a, this.b);
      return;
    }
    VideoLayerUI.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI.9
 * JD-Core Version:    0.7.0.1
 */