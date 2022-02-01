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
      PlayTextureView.access$2302(this.this$0, PlayTextureView.access$2700(this.this$0));
      LogUtils.i("Render|PlayTextureView", " mHardDecoder.createDecoder mFilepath =" + PlayTextureView.access$1400(this.this$0));
      int i = PlayTextureView.access$2500(this.this$0).createDecoder(PlayTextureView.access$1400(this.this$0), PlayTextureView.access$2600(this.this$0));
      LogUtils.i("Render|PlayTextureView", " ret =" + i);
      LogUtils.i("Render|PlayTextureView", "===============hardware decode create return = " + i);
      if (i == 1) {
        PlayTextureView.access$2500(this.this$0).decode();
      }
    }
    else
    {
      return;
    }
    LogUtils.i("Render|PlayTextureView", " 不开始解码。。。。 ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.view.PlayTextureView.7
 * JD-Core Version:    0.7.0.1
 */