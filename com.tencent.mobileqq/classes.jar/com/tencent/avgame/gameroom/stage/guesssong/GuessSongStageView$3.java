package com.tencent.avgame.gameroom.stage.guesssong;

import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;

class GuessSongStageView$3
  implements Runnable
{
  GuessSongStageView$3(GuessSongStageView paramGuessSongStageView) {}
  
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
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesssong.GuessSongStageView.3
 * JD-Core Version:    0.7.0.1
 */