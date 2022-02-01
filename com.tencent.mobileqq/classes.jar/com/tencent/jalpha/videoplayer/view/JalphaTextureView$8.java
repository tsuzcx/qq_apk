package com.tencent.jalpha.videoplayer.view;

import com.tencent.jalpha.videoplayer.interfaces.IVideoPLayListener;

class JalphaTextureView$8
  implements Runnable
{
  JalphaTextureView$8(JalphaTextureView paramJalphaTextureView) {}
  
  public void run()
  {
    if (JalphaTextureView.access$300(this.this$0) != null) {
      JalphaTextureView.access$300(this.this$0).onPlayAtTime(JalphaTextureView.access$700(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.jalpha.videoplayer.view.JalphaTextureView.8
 * JD-Core Version:    0.7.0.1
 */