package com.tencent.mobileqq.armap;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;

class SupercellActivity$9$1$1
  implements Runnable
{
  SupercellActivity$9$1$1(SupercellActivity.9.1 param1) {}
  
  public void run()
  {
    try
    {
      this.this$2.this$1.this$0.isStartPlayEnd = true;
      this.this$2.this$1.this$0.isFristData = true;
      SupercellActivity.access$700(this.this$2.this$1.this$0).setOnFrameAvailableListener(null);
      SupercellActivity.access$200(this.this$2.this$1.this$0).removeCallbacks(SupercellActivity.access$1900(this.this$2.this$1.this$0));
      SupercellActivity.access$1800(this.this$2.this$1.this$0).setOnCompletionListener(null);
      SupercellActivity.access$700(this.this$2.this$1.this$0).release();
      SupercellActivity.access$1800(this.this$2.this$1.this$0).stop();
      SupercellActivity.access$1800(this.this$2.this$1.this$0).release();
      SupercellActivity.access$1802(this.this$2.this$1.this$0, null);
      SupercellActivity.access$000(this.this$2.this$1.this$0);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.SupercellActivity.9.1.1
 * JD-Core Version:    0.7.0.1
 */