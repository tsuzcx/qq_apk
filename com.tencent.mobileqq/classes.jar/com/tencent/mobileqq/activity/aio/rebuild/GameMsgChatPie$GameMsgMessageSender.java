package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.BaseMessageSender;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.msginfo.GameDetailInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.XEditTextEx;

class GameMsgChatPie$GameMsgMessageSender
  extends BaseMessageSender
{
  public GameMsgChatPie$GameMsgMessageSender(GameMsgChatPie paramGameMsgChatPie, AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  public void c()
  {
    if (GameMsgChatPie.c(this.d) == null) {
      return;
    }
    if (GameMsgChatPie.c(this.d) != null) {
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(GameMsgChatPie.c(this.d).c, "1", "145", "920", "92005", "206356", "", "", "20", "0");
    }
    try
    {
      if (this.d.Y.getText().toString().getBytes().length > GameMsgChatPie.c(this.d).p)
      {
        ChatActivityUtils.a(this.d.e, 2131889893, 1);
        return;
      }
      if (!this.d.bF()) {
        return;
      }
      if ((!GameMsgChatPie.l(this.d)) && (GameMsgChatPie.j(this.d) == 3) && (GameMsgChatPie.c(this.d) != null)) {
        ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(GameMsgChatPie.c(this.d).c, "1", "145", "920", "92005", "207647", "", "", "8", this.b.getCurrentAccountUin(), this.c.b, "");
      }
      GameMsgChatPie.c(this.d, true);
      super.c();
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.GameMsgMessageSender
 * JD-Core Version:    0.7.0.1
 */