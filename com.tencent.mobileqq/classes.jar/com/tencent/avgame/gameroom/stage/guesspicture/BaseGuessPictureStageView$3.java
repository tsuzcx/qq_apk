package com.tencent.avgame.gameroom.stage.guesspicture;

import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;

class BaseGuessPictureStageView$3
  implements Runnable
{
  BaseGuessPictureStageView$3(BaseGuessPictureStageView paramBaseGuessPictureStageView) {}
  
  public void run()
  {
    ThreadManager.getUIHandlerV2().removeCallbacks(this.this$0.d);
    if ((this.this$0.a != null) && (this.this$0.a.getVisibility() == 8)) {
      this.this$0.a.setVisibility(0);
    }
    ThreadManager.getUIHandlerV2().postDelayed(this.this$0.d, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesspicture.BaseGuessPictureStageView.3
 * JD-Core Version:    0.7.0.1
 */