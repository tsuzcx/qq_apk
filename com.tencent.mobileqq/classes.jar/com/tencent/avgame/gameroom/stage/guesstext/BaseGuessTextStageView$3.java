package com.tencent.avgame.gameroom.stage.guesstext;

import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;

class BaseGuessTextStageView$3
  implements Runnable
{
  BaseGuessTextStageView$3(BaseGuessTextStageView paramBaseGuessTextStageView) {}
  
  public void run()
  {
    ThreadManager.getUIHandlerV2().removeCallbacks(this.this$0.p);
    if ((this.this$0.o != null) && (this.this$0.o.getVisibility() == 8)) {
      this.this$0.o.setVisibility(0);
    }
    ThreadManager.getUIHandlerV2().postDelayed(this.this$0.p, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesstext.BaseGuessTextStageView.3
 * JD-Core Version:    0.7.0.1
 */