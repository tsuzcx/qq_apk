package com.tencent.ad.tangram.views.button;

import com.tencent.ad.tangram.log.AdLog;

class AdButtonController$2
  implements Runnable
{
  AdButtonController$2(AdButtonController paramAdButtonController, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    AdLog.i("AdButtonController", String.format("updateValue status:%d progress:%d", new Object[] { Integer.valueOf(this.val$statusValue), Integer.valueOf(this.val$progressValue) }));
    AdButtonController.access$402(this.this$0, this.val$statusValue);
    AdButtonController.access$502(this.this$0, this.val$progressValue);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.button.AdButtonController.2
 * JD-Core Version:    0.7.0.1
 */