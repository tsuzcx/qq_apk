package com.tencent.avgame.gameroom.stage.guesstext;

import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;

class GuessTextStageView$3
  implements Runnable
{
  GuessTextStageView$3(GuessTextStageView paramGuessTextStageView) {}
  
  public void run()
  {
    ThreadManager.getUIHandlerV2().removeCallbacks(this.this$0.d);
    if ((this.this$0.b != null) && (this.this$0.b.getVisibility() == 8)) {
      this.this$0.b.setVisibility(0);
    }
    ThreadManager.getUIHandlerV2().postDelayed(this.this$0.d, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesstext.GuessTextStageView.3
 * JD-Core Version:    0.7.0.1
 */