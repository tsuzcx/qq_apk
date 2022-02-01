package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie;

public class GameMsgHelperProvider
  extends HelperProvider
{
  public GameMsgHelperProvider(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void a(GameMsgChatPie paramGameMsgChatPie)
  {
    a(56, new GameMsgChatHelper(paramGameMsgChatPie));
    a(103, new GameMsgAppHelper(paramGameMsgChatPie));
    paramGameMsgChatPie = new GameMsgAddFriendHelper(paramGameMsgChatPie.b());
    a(113, paramGameMsgChatPie);
    a(paramGameMsgChatPie);
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    a((GameMsgChatPie)paramBaseChatPie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.GameMsgHelperProvider
 * JD-Core Version:    0.7.0.1
 */