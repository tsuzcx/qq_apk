package com.tencent.mobileqq.activity.recent.gamemsgbox;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.widget.AbsSlidingIndicator.OnTabListener;
import com.tencent.mobileqq.widget.SimpleSlidingIndicator;

class GameMsgBoxFragment$5
  implements AbsSlidingIndicator.OnTabListener
{
  GameMsgBoxFragment$5(GameMsgBoxFragment paramGameMsgBoxFragment, View paramView) {}
  
  public int a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.b.c(paramInt);
    }
    GameMsgBoxFragment.j(this.b);
    if (GameMsgBoxFragment.k(this.b).getCurrentPosition() == 0)
    {
      this.a.setVisibility(8);
      GameMsgBoxFragment.l(this.b).setVisibility(8);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgBoxFragment.5
 * JD-Core Version:    0.7.0.1
 */