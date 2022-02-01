package com.tencent.ilivesdk.playview.view;

import android.os.Handler;
import com.tencent.ilivesdk.utils.LogUtils;

class PlayTextureView$6
  implements Runnable
{
  PlayTextureView$6(PlayTextureView paramPlayTextureView, int paramInt) {}
  
  public void run()
  {
    PlayTextureView.access$1800(this.this$0);
    PlayTextureView.access$1902(this.this$0, false);
    PlayTextureView.access$600(this.this$0).post(new PlayTextureView.6.1(this));
    PlayTextureView.access$2002(this.this$0, false);
    if ((this.val$errorCode == -2) && (PlayTextureView.access$000(this.this$0) == true))
    {
      LogUtils.i("Render|PlayTextureView", "  need switch software decode ");
      PlayTextureView.access$600(this.this$0).post(new PlayTextureView.6.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.view.PlayTextureView.6
 * JD-Core Version:    0.7.0.1
 */