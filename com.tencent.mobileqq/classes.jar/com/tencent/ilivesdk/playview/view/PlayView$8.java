package com.tencent.ilivesdk.playview.view;

import com.tencent.ilivesdk.playview.codec.VideoFileDecoder;
import com.tencent.ilivesdk.utils.LogUtils;

class PlayView$8
  implements Runnable
{
  PlayView$8(PlayView paramPlayView) {}
  
  public void run()
  {
    if ((PlayView.access$2000(this.this$0) == true) && (PlayView.access$2800(this.this$0) != null) && (PlayView.access$1400(this.this$0) != null))
    {
      Object localObject = this.this$0;
      PlayView.access$2302((PlayView)localObject, PlayView.access$2400((PlayView)localObject));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" mSoftDecoder.createDecoder mFilepath =");
      ((StringBuilder)localObject).append(PlayView.access$1400(this.this$0));
      LogUtils.e("MediaPESdk|PlayView", ((StringBuilder)localObject).toString());
      if (PlayView.access$2800(this.this$0).createDecoder(PlayView.access$1400(this.this$0), null) == 1)
      {
        LogUtils.i("MediaPESdk|PlayView", "===============soft decode create ok");
        PlayView.access$2800(this.this$0).decode();
        return;
      }
      LogUtils.i("MediaPESdk|PlayView", "===============soft decode create failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.view.PlayView.8
 * JD-Core Version:    0.7.0.1
 */