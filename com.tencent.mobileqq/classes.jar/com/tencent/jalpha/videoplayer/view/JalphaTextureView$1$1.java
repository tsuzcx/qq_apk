package com.tencent.jalpha.videoplayer.view;

import com.tencent.jalpha.videoplayer.interfaces.IVideoPLayListener;

class JalphaTextureView$1$1
  implements Runnable
{
  JalphaTextureView$1$1(JalphaTextureView.1 param1) {}
  
  public void run()
  {
    if (JalphaTextureView.access$300(this.this$1.this$0) != null) {
      JalphaTextureView.access$300(this.this$1.this$0).onVideoSize(JalphaTextureView.access$100(this.this$1.this$0), JalphaTextureView.access$200(this.this$1.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.jalpha.videoplayer.view.JalphaTextureView.1.1
 * JD-Core Version:    0.7.0.1
 */