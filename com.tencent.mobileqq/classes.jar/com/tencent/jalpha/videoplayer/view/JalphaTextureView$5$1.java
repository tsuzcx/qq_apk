package com.tencent.jalpha.videoplayer.view;

import com.tencent.jalpha.videoplayer.interfaces.IVideoPLayListener;

class JalphaTextureView$5$1
  implements Runnable
{
  JalphaTextureView$5$1(JalphaTextureView.5 param5) {}
  
  public void run()
  {
    this.this$1.this$0.setVisibility(8);
    if (JalphaTextureView.access$300(this.this$1.this$0) != null) {
      JalphaTextureView.access$300(this.this$1.this$0).onError(this.this$1.val$errorCode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.jalpha.videoplayer.view.JalphaTextureView.5.1
 * JD-Core Version:    0.7.0.1
 */