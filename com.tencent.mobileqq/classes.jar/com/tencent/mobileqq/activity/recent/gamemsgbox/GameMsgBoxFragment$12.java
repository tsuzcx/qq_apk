package com.tencent.mobileqq.activity.recent.gamemsgbox;

import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import java.util.ArrayList;

class GameMsgBoxFragment$12
  implements Runnable
{
  GameMsgBoxFragment$12(GameMsgBoxFragment paramGameMsgBoxFragment) {}
  
  public void run()
  {
    if ((GameMsgBoxFragment.p(this.this$0) != null) && (GameMsgBoxFragment.p(this.this$0).getMode() == -1) && (GameMsgBoxFragment.q(this.this$0) != null))
    {
      ArrayList localArrayList = new ArrayList();
      GameMsgBoxFragment.q(this.this$0).a(0);
      GameMsgBoxFragment.q(this.this$0).a(localArrayList);
      GameMsgBoxFragment.b(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgBoxFragment.12
 * JD-Core Version:    0.7.0.1
 */