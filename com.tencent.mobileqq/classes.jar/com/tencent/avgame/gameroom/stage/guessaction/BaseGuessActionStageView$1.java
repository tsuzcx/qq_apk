package com.tencent.avgame.gameroom.stage.guessaction;

import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;

class BaseGuessActionStageView$1
  implements Runnable
{
  BaseGuessActionStageView$1(BaseGuessActionStageView paramBaseGuessActionStageView) {}
  
  public void run()
  {
    ThreadManager.getUIHandlerV2().removeCallbacks(this.this$0.p);
    if ((this.this$0.k != null) && (this.this$0.k.getVisibility() == 8)) {
      this.this$0.k.setVisibility(0);
    }
    ThreadManager.getUIHandlerV2().postDelayed(this.this$0.p, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessaction.BaseGuessActionStageView.1
 * JD-Core Version:    0.7.0.1
 */