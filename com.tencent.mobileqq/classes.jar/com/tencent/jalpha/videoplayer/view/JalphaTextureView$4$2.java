package com.tencent.jalpha.videoplayer.view;

import com.tencent.jalpha.common.Logger;

class JalphaTextureView$4$2
  implements Runnable
{
  JalphaTextureView$4$2(JalphaTextureView.4 param4) {}
  
  public void run()
  {
    JalphaTextureView.access$1502(this.this$1.this$0, false);
    if (JalphaTextureView.access$1600(this.this$1.this$0) != null)
    {
      Logger.v(JalphaTextureView.access$000(this.this$1.this$0), "==============stopping need play file again");
      this.this$1.this$0.playFile(JalphaTextureView.access$1600(this.this$1.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.jalpha.videoplayer.view.JalphaTextureView.4.2
 * JD-Core Version:    0.7.0.1
 */