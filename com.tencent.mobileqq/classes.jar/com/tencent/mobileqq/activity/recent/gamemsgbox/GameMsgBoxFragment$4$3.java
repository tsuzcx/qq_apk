package com.tencent.mobileqq.activity.recent.gamemsgbox;

import android.view.View;
import android.view.ViewStub;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.msginfo.GameDetailInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.XListView;

class GameMsgBoxFragment$4$3
  implements Runnable
{
  GameMsgBoxFragment$4$3(GameMsgBoxFragment.4 param4, GameDetailInfo paramGameDetailInfo, int paramInt, RecentUser paramRecentUser) {}
  
  public void run()
  {
    Object localObject = (ViewStub)GameMsgBoxFragment.i(this.d.this$0).findViewById(2131449337);
    GameMsgBoxFragment.f(this.d.this$0).setVisibility(8);
    if (GameMsgBoxFragment.g(this.d.this$0) == null) {
      GameMsgBoxFragment.a(this.d.this$0, (GameMsgBoxOpenSyncView)((ViewStub)localObject).inflate());
    }
    GameMsgBoxFragment.g(this.d.this$0).setVisibility(0);
    localObject = (IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class);
    GameMsgBoxFragment.g(this.d.this$0).setGameOpenSyncMsg(this.d.a, this.d.this$0.hashCode(), this.a, this.b, ((IGameMsgHelperApi)localObject).getRecentGameMsgDrawable(GameMsgBoxFragment.d(this.d.this$0), this.c.uin));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgBoxFragment.4.3
 * JD-Core Version:    0.7.0.1
 */