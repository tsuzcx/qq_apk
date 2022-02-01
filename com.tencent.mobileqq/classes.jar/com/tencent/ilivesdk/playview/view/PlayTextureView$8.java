package com.tencent.ilivesdk.playview.view;

import com.tencent.ilivesdk.playview.codec.VideoFileDecoder;
import com.tencent.ilivesdk.utils.LogUtils;

class PlayTextureView$8
  implements Runnable
{
  PlayTextureView$8(PlayTextureView paramPlayTextureView) {}
  
  public void run()
  {
    if ((PlayTextureView.access$2000(this.this$0) == true) && (PlayTextureView.access$2800(this.this$0) != null) && (PlayTextureView.access$1400(this.this$0) != null))
    {
      PlayTextureView.access$2302(this.this$0, PlayTextureView.access$2400(this.this$0));
      if (PlayTextureView.access$2800(this.this$0).createDecoder(PlayTextureView.access$1400(this.this$0), null) == 1)
      {
        LogUtils.i("Render|PlayTextureView", "===============soft decode create ok");
        PlayTextureView.access$2800(this.this$0).decode();
      }
    }
    else
    {
      return;
    }
    LogUtils.i("Render|PlayTextureView", "===============soft decode create failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.view.PlayTextureView.8
 * JD-Core Version:    0.7.0.1
 */