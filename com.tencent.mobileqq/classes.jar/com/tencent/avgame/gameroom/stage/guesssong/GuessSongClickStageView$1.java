package com.tencent.avgame.gameroom.stage.guesssong;

import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.util.Pair;
import java.util.ArrayList;

class GuessSongClickStageView$1
  implements Runnable
{
  GuessSongClickStageView$1(GuessSongClickStageView paramGuessSongClickStageView) {}
  
  public void run()
  {
    if (this.this$0.r != null)
    {
      ThreadManager.getUIHandlerV2().removeCallbacks(this.this$0.y);
      if (this.this$0.s < this.this$0.r.size())
      {
        if ((this.this$0.g != null) && (this.this$0.g.getVisibility() == 8))
        {
          this.this$0.g.setVisibility(0);
          this.this$0.e.setVisibility(0);
        }
        Object localObject = this.this$0;
        ((GuessSongClickStageView)localObject).a((String)((Pair)((GuessSongClickStageView)localObject).r.get(this.this$0.s)).second);
        if (this.this$0.s < this.this$0.r.size() - 1)
        {
          localObject = ThreadManager.getUIHandlerV2();
          ArrayList localArrayList = this.this$0.r;
          GuessSongClickStageView localGuessSongClickStageView = this.this$0;
          int i = localGuessSongClickStageView.s + 1;
          localGuessSongClickStageView.s = i;
          ((Handler)localObject).postDelayed(this, (((Integer)((Pair)localArrayList.get(i)).first).intValue() - ((Integer)((Pair)this.this$0.r.get(this.this$0.s - 1)).first).intValue()) * 1000);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesssong.GuessSongClickStageView.1
 * JD-Core Version:    0.7.0.1
 */