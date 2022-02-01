package com.tencent.jalpha.videoplayer.view;

import android.os.Handler;
import com.tencent.jalpha.common.Logger;

class JalphaTextureView$4
  implements Runnable
{
  JalphaTextureView$4(JalphaTextureView paramJalphaTextureView) {}
  
  public void run()
  {
    JalphaTextureView.access$1200(this.this$0);
    JalphaTextureView.access$400(this.this$0).post(new JalphaTextureView.4.1(this));
    long l = System.currentTimeMillis();
    while (this.this$0.getVisibility() != 8)
    {
      Logger.v(JalphaTextureView.access$000(this.this$0), "==============PlayView wait set GONE");
      try
      {
        Thread.sleep(50L);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
      if (System.currentTimeMillis() - l > 3000L) {
        Logger.v(JalphaTextureView.access$000(this.this$0), "==============PlayView set GONE time out");
      }
    }
    Logger.v(JalphaTextureView.access$000(this.this$0), "==============PlayView set GONE over");
    JalphaTextureView.access$1302(this.this$0, false);
    JalphaTextureView.access$1402(this.this$0, false);
    if (JalphaTextureView.access$1500(this.this$0)) {
      JalphaTextureView.access$400(this.this$0).post(new JalphaTextureView.4.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.jalpha.videoplayer.view.JalphaTextureView.4
 * JD-Core Version:    0.7.0.1
 */