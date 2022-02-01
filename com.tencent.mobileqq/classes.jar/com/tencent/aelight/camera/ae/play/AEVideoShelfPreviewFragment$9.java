package com.tencent.aelight.camera.ae.play;

class AEVideoShelfPreviewFragment$9
  implements Runnable
{
  AEVideoShelfPreviewFragment$9(AEVideoShelfPreviewFragment paramAEVideoShelfPreviewFragment, int paramInt) {}
  
  public void run()
  {
    AEVideoShelfPreviewFragment localAEVideoShelfPreviewFragment = this.this$0;
    double d = this.val$progress;
    Double.isNaN(d);
    AEVideoShelfPreviewFragment.access$702(localAEVideoShelfPreviewFragment, d * 0.9D);
    d = (AEVideoShelfPreviewFragment.access$700(this.this$0) - AEVideoShelfPreviewFragment.access$1000(this.this$0)) * 90.0D / (90.0D - AEVideoShelfPreviewFragment.access$1000(this.this$0));
    AEVideoShelfPreviewFragment.access$800(this.this$0, (int)d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEVideoShelfPreviewFragment.9
 * JD-Core Version:    0.7.0.1
 */