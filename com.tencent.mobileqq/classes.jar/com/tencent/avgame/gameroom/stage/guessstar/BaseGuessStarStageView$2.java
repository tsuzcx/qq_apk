package com.tencent.avgame.gameroom.stage.guessstar;

import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;

class BaseGuessStarStageView$2
  implements Runnable
{
  BaseGuessStarStageView$2(BaseGuessStarStageView paramBaseGuessStarStageView) {}
  
  public void run()
  {
    ThreadManager.getUIHandlerV2().removeCallbacks(this.this$0.u);
    if ((this.this$0.l != null) && (this.this$0.l.getVisibility() == 8)) {
      this.this$0.l.setVisibility(0);
    }
    ThreadManager.getUIHandlerV2().postDelayed(this.this$0.u, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessstar.BaseGuessStarStageView.2
 * JD-Core Version:    0.7.0.1
 */