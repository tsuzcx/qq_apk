package com.tencent.ilivesdk.playview.view;

import com.tencent.ilivesdk.playview.codec.VideoFileDecoder;
import com.tencent.ilivesdk.utils.LogUtils;

class PlayView$7
  implements Runnable
{
  PlayView$7(PlayView paramPlayView) {}
  
  public void run()
  {
    if ((PlayView.access$2000(this.this$0) == true) && (PlayView.access$2500(this.this$0) != null) && (PlayView.access$1400(this.this$0) != null) && (PlayView.access$2600(this.this$0) != null))
    {
      Object localObject = this.this$0;
      PlayView.access$2302((PlayView)localObject, PlayView.access$2700((PlayView)localObject));
      int i = PlayView.access$2500(this.this$0).createDecoder(PlayView.access$1400(this.this$0), PlayView.access$2600(this.this$0));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" ret =");
      ((StringBuilder)localObject).append(i);
      LogUtils.e("MediaPESdk|PlayView", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("===============hardware decode create return = ");
      ((StringBuilder)localObject).append(i);
      LogUtils.i("MediaPESdk|PlayView", ((StringBuilder)localObject).toString());
      if (i == 1)
      {
        PlayView.access$2500(this.this$0).decode();
        return;
      }
      LogUtils.e("MediaPESdk|PlayView", " 不开始解码。。。。 ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.view.PlayView.7
 * JD-Core Version:    0.7.0.1
 */