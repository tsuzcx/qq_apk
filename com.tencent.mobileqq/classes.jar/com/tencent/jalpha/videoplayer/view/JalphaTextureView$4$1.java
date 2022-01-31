package com.tencent.jalpha.videoplayer.view;

import com.tencent.jalpha.common.Logger;
import com.tencent.jalpha.videoplayer.interfaces.IVideoPLayListener;

class JalphaTextureView$4$1
  implements Runnable
{
  JalphaTextureView$4$1(JalphaTextureView.4 param4) {}
  
  public void run()
  {
    Logger.v(JalphaTextureView.access$000(this.this$1.this$0), "==============PlayView set gone");
    this.this$1.this$0.setVisibility(8);
    if (JalphaTextureView.access$300(this.this$1.this$0) != null) {
      JalphaTextureView.access$300(this.this$1.this$0).onEnd();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.jalpha.videoplayer.view.JalphaTextureView.4.1
 * JD-Core Version:    0.7.0.1
 */