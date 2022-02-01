package com.tencent.mobileqq.activity.recent.gamemsgbox;

import android.view.View;
import com.tencent.mobileqq.widget.SimpleSlidingIndicator;
import java.util.List;

class GameMsgBoxFragment$9
  implements Runnable
{
  GameMsgBoxFragment$9(GameMsgBoxFragment paramGameMsgBoxFragment, String[] paramArrayOfString, int[] paramArrayOfInt, boolean[] paramArrayOfBoolean, List paramList) {}
  
  public void run()
  {
    GameMsgBoxFragment.k(this.this$0).setTabData(this.a, this.b);
    int i = 0;
    for (;;)
    {
      localObject = this.a;
      if (i >= localObject.length) {
        break;
      }
      if (localObject[i].equals(GameMsgBoxFragment.m(this.this$0)))
      {
        if (i == 0)
        {
          GameMsgBoxFragment.k(this.this$0).setCurrentPosition(0, true);
          GameMsgBoxFragment.k(this.this$0).smoothScrollTo(0, GameMsgBoxFragment.k(this.this$0).getScrollY());
          this.this$0.c(0);
          break;
        }
        GameMsgBoxFragment.k(this.this$0).setCurrentPosition(i, true);
        this.this$0.c(i);
        break;
      }
      if (i == this.a.length - 1)
      {
        GameMsgBoxFragment.k(this.this$0).setCurrentPosition(0, true);
        GameMsgBoxFragment.k(this.this$0).smoothScrollTo(0, GameMsgBoxFragment.k(this.this$0).getScrollY());
        this.this$0.c(0);
      }
      i += 1;
    }
    i = 0;
    for (;;)
    {
      localObject = this.c;
      if (i >= localObject.length) {
        break;
      }
      if (localObject[i] != 0) {
        GameMsgBoxFragment.k(this.this$0).d(i + 1);
      }
      i += 1;
    }
    Object localObject = this.d;
    if ((localObject != null) && (((List)localObject).size() > 1))
    {
      GameMsgBoxFragment.o(this.this$0).findViewById(2131434000).setVisibility(0);
      return;
    }
    GameMsgBoxFragment.n(this.this$0).findViewById(2131434000).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgBoxFragment.9
 * JD-Core Version:    0.7.0.1
 */