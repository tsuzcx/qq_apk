package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.GameBuddyChatPie;

public class GameBuddyHelperProvider
  extends HelperProvider
{
  public GameBuddyHelperProvider(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void a(GameBuddyChatPie paramGameBuddyChatPie)
  {
    paramGameBuddyChatPie = new GameBuddyAddFriendHelper(paramGameBuddyChatPie.b());
    a(113, paramGameBuddyChatPie);
    a(paramGameBuddyChatPie);
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    a((GameBuddyChatPie)paramBaseChatPie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.GameBuddyHelperProvider
 * JD-Core Version:    0.7.0.1
 */