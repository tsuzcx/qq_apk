package com.tencent.jalpha.videoplayer.view;

import com.tencent.jalpha.common.Logger;
import com.tencent.jalpha.videoplayer.interfaces.IVideoFileDecoder;

class JalphaTextureView$6
  implements Runnable
{
  JalphaTextureView$6(JalphaTextureView paramJalphaTextureView) {}
  
  public void run()
  {
    if ((JalphaTextureView.access$1400(this.this$0)) && (JalphaTextureView.access$1700(this.this$0) != null) && (JalphaTextureView.access$900(this.this$0) != null) && (JalphaTextureView.access$1800(this.this$0) != null))
    {
      JalphaTextureView.access$1902(this.this$0, JalphaTextureView.access$2000(this.this$0));
      int i = JalphaTextureView.access$1700(this.this$0).createDecoder(JalphaTextureView.access$900(this.this$0), JalphaTextureView.access$1800(this.this$0));
      Logger.e(JalphaTextureView.access$000(this.this$0), " ret =" + i);
      Logger.v(JalphaTextureView.access$000(this.this$0), "===============hardware decode create return = " + i);
      if (i == 1) {
        JalphaTextureView.access$1700(this.this$0).decode();
      }
    }
    else
    {
      return;
    }
    Logger.e(JalphaTextureView.access$000(this.this$0), " 不开始解码。。。。 ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.jalpha.videoplayer.view.JalphaTextureView.6
 * JD-Core Version:    0.7.0.1
 */