package com.tencent.mobileqq.activity.aio.helper;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageButton;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.qroute.QRoute;

class GameMsgChatHelper$1
  implements ViewTreeObserver.OnPreDrawListener
{
  GameMsgChatHelper$1(GameMsgChatHelper paramGameMsgChatHelper) {}
  
  public boolean onPreDraw()
  {
    GameMsgChatHelper localGameMsgChatHelper = this.a;
    GameMsgChatHelper.a(localGameMsgChatHelper, GameMsgChatHelper.a(localGameMsgChatHelper));
    ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).setAIOGameEntryShown(this.a.a.a().getAccount(), true);
    GameMsgChatHelper.a(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.GameMsgChatHelper.1
 * JD-Core Version:    0.7.0.1
 */