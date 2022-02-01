package com.tencent.mobileqq.activity.aio.helper;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageButton;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;

class GameMsgChatHelper$1
  implements ViewTreeObserver.OnPreDrawListener
{
  GameMsgChatHelper$1(GameMsgChatHelper paramGameMsgChatHelper) {}
  
  public boolean onPreDraw()
  {
    GameMsgChatHelper.a(this.a, GameMsgChatHelper.a(this.a));
    GameMsgUtil.b(this.a.a.a().getAccount(), true);
    GameMsgChatHelper.a(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.GameMsgChatHelper.1
 * JD-Core Version:    0.7.0.1
 */