package com.tencent.avgame.gameroom.stage.guessstar;

import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.avgame.gameroom.stage.IStageRecordPresenter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.util.Pair;
import java.util.ArrayList;

class BaseGuessStarStageView$1
  implements Runnable
{
  BaseGuessStarStageView$1(BaseGuessStarStageView paramBaseGuessStarStageView) {}
  
  public void run()
  {
    if ((this.this$0.q != null) && (this.this$0.r < this.this$0.q.size()))
    {
      if ((this.this$0.g != null) && (this.this$0.g.getVisibility() == 8))
      {
        this.this$0.g.setVisibility(0);
        this.this$0.f.setVisibility(0);
        this.this$0.e.setVisibility(0);
      }
      Object localObject = this.this$0;
      ((BaseGuessStarStageView)localObject).a((String)((Pair)((BaseGuessStarStageView)localObject).q.get(this.this$0.r)).second);
      if (this.this$0.d != null) {
        this.this$0.d.b(this.this$0.g);
      }
      if (this.this$0.r < this.this$0.q.size() - 1)
      {
        localObject = ThreadManager.getUIHandlerV2();
        ArrayList localArrayList = this.this$0.q;
        BaseGuessStarStageView localBaseGuessStarStageView = this.this$0;
        int i = localBaseGuessStarStageView.r + 1;
        localBaseGuessStarStageView.r = i;
        ((Handler)localObject).postDelayed(this, (((Integer)((Pair)localArrayList.get(i)).first).intValue() - ((Integer)((Pair)this.this$0.q.get(this.this$0.r - 1)).first).intValue()) * 1000);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessstar.BaseGuessStarStageView.1
 * JD-Core Version:    0.7.0.1
 */