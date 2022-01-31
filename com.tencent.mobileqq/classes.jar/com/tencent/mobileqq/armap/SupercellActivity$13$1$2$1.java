package com.tencent.mobileqq.armap;

class SupercellActivity$13$1$2$1
  implements Runnable
{
  SupercellActivity$13$1$2$1(SupercellActivity.13.1.2 param2) {}
  
  public void run()
  {
    SupercellActivity.access$2700(this.this$3.this$2.this$1.this$0);
    if (this.this$3.this$2.this$1.this$0.isHaveSurfaceTexture)
    {
      SupercellActivity.access$200(this.this$3.this$2.this$1.this$0);
      ARGLSurfaceView.setVideoSize(SupercellActivity.access$600(this.this$3.this$2.this$1.this$0), this.this$3.this$2.this$1.this$0.videoWidth, this.this$3.this$2.this$1.this$0.videoHeight);
    }
    SupercellActivity.access$2502(this.this$3.this$2.this$1.this$0, true);
    if (this.this$3.this$2.this$1.this$0.isStartPlayEnd)
    {
      SupercellActivity.access$000(this.this$3.this$2.this$1.this$0);
      return;
    }
    SupercellActivity.access$100(this.this$3.this$2.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.SupercellActivity.13.1.2.1
 * JD-Core Version:    0.7.0.1
 */