package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.msginfo.GameDetailInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GameMsgChatPie$5
  implements View.OnClickListener
{
  GameMsgChatPie$5(GameMsgChatPie paramGameMsgChatPie, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    if (this.a) {
      this.b.bG();
    } else {
      GameMsgChatPie.m(this.b);
    }
    if (GameMsgChatPie.n(this.b) != null)
    {
      GameMsgChatPie.n(this.b).dismiss();
      GameMsgChatPie.a(this.b, null);
    }
    if (GameMsgChatPie.c(this.b) != null) {
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(GameMsgChatPie.c(this.b).c, "1", "145", "920", "92005", "208987", "1", "", "20", String.valueOf(GameMsgChatPie.c(this.b).j));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.5
 * JD-Core Version:    0.7.0.1
 */