package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;
import com.tencent.mobileqq.pushdialog.AIOPushDialogHelper;

public class StrangerHelperProvider
  extends HelperProvider
{
  public StrangerHelperProvider(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void a(StrangerChatPie paramStrangerChatPie)
  {
    a(42, new AIOPushDialogHelper(paramStrangerChatPie));
    a(95, new TempMsgBoxAIOHelper(paramStrangerChatPie));
    a(61, new StrangerQidianHelper(paramStrangerChatPie.b()));
    StrangerAddFriendHelper localStrangerAddFriendHelper = new StrangerAddFriendHelper(paramStrangerChatPie.b());
    a(113, localStrangerAddFriendHelper);
    a(localStrangerAddFriendHelper);
    a(130, new StrangerOnlineStatusHelper(paramStrangerChatPie.b()));
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    a((StrangerChatPie)paramBaseChatPie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.StrangerHelperProvider
 * JD-Core Version:    0.7.0.1
 */