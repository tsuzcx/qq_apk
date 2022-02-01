package com.tencent.avgame.gameroom.stage.guesstext;

import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.util.Pair;
import java.util.ArrayList;

class BaseGuessTextStageView$4
  implements Runnable
{
  BaseGuessTextStageView$4(BaseGuessTextStageView paramBaseGuessTextStageView) {}
  
  public void run()
  {
    if (this.this$0.v != null)
    {
      ThreadManager.getUIHandlerV2().removeCallbacks(this.this$0.l);
      if (this.this$0.w < this.this$0.v.size())
      {
        if ((this.this$0.g != null) && (this.this$0.g.getVisibility() == 8))
        {
          this.this$0.g.setVisibility(0);
          this.this$0.d.setVisibility(0);
          this.this$0.e.setVisibility(0);
        }
        Object localObject = this.this$0;
        ((BaseGuessTextStageView)localObject).a((String)((Pair)((BaseGuessTextStageView)localObject).v.get(this.this$0.w)).second);
        if (this.this$0.w < this.this$0.v.size() - 1)
        {
          localObject = ThreadManager.getUIHandlerV2();
          ArrayList localArrayList = this.this$0.v;
          BaseGuessTextStageView localBaseGuessTextStageView = this.this$0;
          int i = localBaseGuessTextStageView.w + 1;
          localBaseGuessTextStageView.w = i;
          ((Handler)localObject).postDelayed(this, (((Integer)((Pair)localArrayList.get(i)).first).intValue() - ((Integer)((Pair)this.this$0.v.get(this.this$0.w - 1)).first).intValue()) * 1000);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesstext.BaseGuessTextStageView.4
 * JD-Core Version:    0.7.0.1
 */