package com.tencent.mobileqq.activity.recent.gamemsgbox;

import android.view.View;
import android.view.ViewStub;
import com.tencent.mobileqq.gamecenter.msginfo.GameDetailInfo;
import com.tencent.widget.XListView;

class GameMsgBoxFragment$4$1
  implements Runnable
{
  GameMsgBoxFragment$4$1(GameMsgBoxFragment.4 param4) {}
  
  public void run()
  {
    Object localObject = (ViewStub)GameMsgBoxFragment.e(this.a.this$0).findViewById(2131449337);
    GameMsgBoxFragment.f(this.a.this$0).setVisibility(8);
    if (GameMsgBoxFragment.g(this.a.this$0) == null) {
      GameMsgBoxFragment.a(this.a.this$0, (GameMsgBoxOpenSyncView)((ViewStub)localObject).inflate());
    }
    GameMsgBoxFragment.g(this.a.this$0).setVisibility(0);
    localObject = new GameDetailInfo();
    ((GameDetailInfo)localObject).l = this.a.this$0.getString(2131889882);
    GameMsgBoxFragment.g(this.a.this$0).setGameOpenSyncMsg(this.a.a, this.a.this$0.hashCode(), (GameDetailInfo)localObject, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgBoxFragment.4.1
 * JD-Core Version:    0.7.0.1
 */