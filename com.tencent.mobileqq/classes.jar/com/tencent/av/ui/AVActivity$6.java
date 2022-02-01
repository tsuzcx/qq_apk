package com.tencent.av.ui;

import com.tencent.mobileqq.vas.vipav.VipFullScreenVideoView;

class AVActivity$6
  implements Runnable
{
  AVActivity$6(AVActivity paramAVActivity) {}
  
  public void run()
  {
    if (this.this$0.Y != null)
    {
      if (this.this$0.Y.isPlaying()) {
        this.this$0.Y.stopPlayback();
      }
      if ((this.this$0.K != null) && ((this.this$0.K instanceof DoubleVideoCtrlUI))) {
        ((DoubleVideoCtrlUI)this.this$0.K).b(false);
      }
      this.this$0.Y.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.6
 * JD-Core Version:    0.7.0.1
 */