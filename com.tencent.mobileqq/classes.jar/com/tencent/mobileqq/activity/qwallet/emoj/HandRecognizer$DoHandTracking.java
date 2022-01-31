package com.tencent.mobileqq.activity.qwallet.emoj;

public class HandRecognizer$DoHandTracking
  implements Runnable
{
  public int goal_label;
  public HandRecognizer.OnPreviewFrameHandlerListener listener;
  
  public HandRecognizer$DoHandTracking(HandRecognizer paramHandRecognizer) {}
  
  public void run()
  {
    int i = -1;
    YtHandClassifyResult localYtHandClassifyResult = new YtHandClassifyResult();
    if (this.this$0.box.confidence >= 0.01D)
    {
      int j = this.this$0.doHandAlignment(this.this$0.box, this.this$0.box);
      i = j;
      if (j == 0)
      {
        i = j;
        if (this.this$0.box.confidence >= 0.9908F) {
          i = this.this$0.doHandClassifyWithGesture(this.this$0.box, this.goal_label, localYtHandClassifyResult);
        }
      }
    }
    if (i != 0) {
      this.this$0.box = new YtHandBox();
    }
    if (i != 0) {
      this.this$0.box = new YtHandBox();
    }
    i = (int)(localYtHandClassifyResult.confidence * 100.0F);
    if (this.listener != null) {
      this.listener.getHandRecognizeResult(i);
    }
    if (this.this$0.box.confidence >= 0.9908F) {
      this.this$0.doHandStable(this.this$0.box, this.this$0.stable_box);
    }
    this.this$0.isTracking = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.HandRecognizer.DoHandTracking
 * JD-Core Version:    0.7.0.1
 */