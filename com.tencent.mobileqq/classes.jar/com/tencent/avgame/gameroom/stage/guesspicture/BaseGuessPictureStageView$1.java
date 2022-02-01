package com.tencent.avgame.gameroom.stage.guesspicture;

import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.util.Pair;
import java.util.ArrayList;

class BaseGuessPictureStageView$1
  implements Runnable
{
  BaseGuessPictureStageView$1(BaseGuessPictureStageView paramBaseGuessPictureStageView) {}
  
  public void run()
  {
    if (this.this$0.u != null)
    {
      ThreadManager.getUIHandlerV2().removeCallbacks(this.this$0.x);
      if (this.this$0.v < this.this$0.u.size())
      {
        if ((this.this$0.m != null) && (this.this$0.m.getVisibility() == 8))
        {
          this.this$0.m.setVisibility(0);
          this.this$0.e.setVisibility(0);
          this.this$0.f.setVisibility(0);
        }
        Object localObject = this.this$0;
        ((BaseGuessPictureStageView)localObject).a((String)((Pair)((BaseGuessPictureStageView)localObject).u.get(this.this$0.v)).second);
        if (this.this$0.v < this.this$0.u.size() - 1)
        {
          localObject = ThreadManager.getUIHandlerV2();
          ArrayList localArrayList = this.this$0.u;
          BaseGuessPictureStageView localBaseGuessPictureStageView = this.this$0;
          int i = localBaseGuessPictureStageView.v + 1;
          localBaseGuessPictureStageView.v = i;
          ((Handler)localObject).postDelayed(this, (((Integer)((Pair)localArrayList.get(i)).first).intValue() - ((Integer)((Pair)this.this$0.u.get(this.this$0.v - 1)).first).intValue()) * 1000);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesspicture.BaseGuessPictureStageView.1
 * JD-Core Version:    0.7.0.1
 */