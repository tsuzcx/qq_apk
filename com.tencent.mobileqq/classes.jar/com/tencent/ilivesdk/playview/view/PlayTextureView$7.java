package com.tencent.ilivesdk.playview.view;

import com.tencent.ilivesdk.playview.codec.VideoFileDecoder;
import com.tencent.ilivesdk.utils.LogUtils;

class PlayTextureView$7
  implements Runnable
{
  PlayTextureView$7(PlayTextureView paramPlayTextureView) {}
  
  public void run()
  {
    if ((PlayTextureView.access$2000(this.this$0) == true) && (PlayTextureView.access$2500(this.this$0) != null) && (PlayTextureView.access$1400(this.this$0) != null) && (PlayTextureView.access$2600(this.this$0) != null))
    {
      Object localObject = this.this$0;
      PlayTextureView.access$2302((PlayTextureView)localObject, PlayTextureView.access$2700((PlayTextureView)localObject));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" mHardDecoder.createDecoder mFilepath =");
      ((StringBuilder)localObject).append(PlayTextureView.access$1400(this.this$0));
      LogUtils.i("Render|PlayTextureView", ((StringBuilder)localObject).toString());
      int i = PlayTextureView.access$2500(this.this$0).createDecoder(PlayTextureView.access$1400(this.this$0), PlayTextureView.access$2600(this.this$0));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" ret =");
      ((StringBuilder)localObject).append(i);
      LogUtils.i("Render|PlayTextureView", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("===============hardware decode create return = ");
      ((StringBuilder)localObject).append(i);
      LogUtils.i("Render|PlayTextureView", ((StringBuilder)localObject).toString());
      if (i == 1)
      {
        PlayTextureView.access$2500(this.this$0).decode();
        return;
      }
      LogUtils.i("Render|PlayTextureView", " 不开始解码。。。。 ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.view.PlayTextureView.7
 * JD-Core Version:    0.7.0.1
 */