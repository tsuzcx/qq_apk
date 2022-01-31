package com.tencent.jalpha.videoplayer.view;

import android.os.Handler;
import android.util.Log;

class JalphaTextureView$5
  implements Runnable
{
  JalphaTextureView$5(JalphaTextureView paramJalphaTextureView, int paramInt) {}
  
  public void run()
  {
    JalphaTextureView.access$1200(this.this$0);
    JalphaTextureView.access$1302(this.this$0, false);
    JalphaTextureView.access$400(this.this$0).post(new JalphaTextureView.5.1(this));
    JalphaTextureView.access$1402(this.this$0, false);
    if (this.val$errorCode == -2) {
      Log.v(JalphaTextureView.access$000(this.this$0), "  need switch software decode ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.jalpha.videoplayer.view.JalphaTextureView.5
 * JD-Core Version:    0.7.0.1
 */