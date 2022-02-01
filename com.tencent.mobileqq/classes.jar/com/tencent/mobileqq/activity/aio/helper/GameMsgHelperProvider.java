package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie;

public class GameMsgHelperProvider
  extends StrangerHelperProvider
{
  public GameMsgHelperProvider(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void a(GameMsgChatPie paramGameMsgChatPie)
  {
    a(103, new GameMsgAppHelper(paramGameMsgChatPie));
    a(140, new GameMsgPopInfoHelper(paramGameMsgChatPie));
    a(141, new GameMsgSayHiHelper(paramGameMsgChatPie));
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    a((GameMsgChatPie)paramBaseChatPie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.GameMsgHelperProvider
 * JD-Core Version:    0.7.0.1
 */