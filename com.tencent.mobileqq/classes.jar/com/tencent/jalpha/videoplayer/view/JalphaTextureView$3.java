package com.tencent.jalpha.videoplayer.view;

import com.tencent.jalpha.videoplayer.interfaces.IVideoPLayListener;

class JalphaTextureView$3
  implements Runnable
{
  JalphaTextureView$3(JalphaTextureView paramJalphaTextureView, int paramInt) {}
  
  public void run()
  {
    if (JalphaTextureView.access$300(this.this$0) != null) {
      JalphaTextureView.access$300(this.this$0).onError(this.val$errorCode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.jalpha.videoplayer.view.JalphaTextureView.3
 * JD-Core Version:    0.7.0.1
 */