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
      Object localObject = this.this$0;
      JalphaTextureView.access$1902((JalphaTextureView)localObject, JalphaTextureView.access$2000((JalphaTextureView)localObject));
      int i = JalphaTextureView.access$1700(this.this$0).createDecoder(JalphaTextureView.access$900(this.this$0), JalphaTextureView.access$1800(this.this$0));
      localObject = JalphaTextureView.access$000(this.this$0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" ret =");
      localStringBuilder.append(i);
      Logger.e((String)localObject, localStringBuilder.toString());
      localObject = JalphaTextureView.access$000(this.this$0);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("===============hardware decode create return = ");
      localStringBuilder.append(i);
      Logger.v((String)localObject, localStringBuilder.toString());
      if (i == 1)
      {
        JalphaTextureView.access$1700(this.this$0).decode();
        return;
      }
      Logger.e(JalphaTextureView.access$000(this.this$0), " 不开始解码。。。。 ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.jalpha.videoplayer.view.JalphaTextureView.6
 * JD-Core Version:    0.7.0.1
 */