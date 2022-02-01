package com.tencent.ilivesdk.playview.view;

import android.os.Handler;
import com.tencent.ilivesdk.utils.LogUtils;

class PlayView$6
  implements Runnable
{
  PlayView$6(PlayView paramPlayView, int paramInt) {}
  
  public void run()
  {
    PlayView.access$1800(this.this$0);
    PlayView.access$1902(this.this$0, false);
    PlayView.access$600(this.this$0).post(new PlayView.6.1(this));
    PlayView.access$2002(this.this$0, false);
    if ((this.val$errorCode == -2) && (PlayView.access$000(this.this$0) == true))
    {
      LogUtils.i("MediaPESdk|PlayView", "  need switch software decode ");
      PlayView.access$600(this.this$0).post(new PlayView.6.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.view.PlayView.6
 * JD-Core Version:    0.7.0.1
 */