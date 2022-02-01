package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;

public class PAHelperProvider
  extends HelperProvider
{
  public PAHelperProvider(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void a(PublicAccountChatPie paramPublicAccountChatPie)
  {
    a(109, new PATipsHelper(paramPublicAccountChatPie.b()));
    PAAddFriendHelper localPAAddFriendHelper = new PAAddFriendHelper(paramPublicAccountChatPie.b());
    a(113, localPAAddFriendHelper);
    a(localPAAddFriendHelper);
    a(90, new QQGamePubAIOHelper(paramPublicAccountChatPie));
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    a((PublicAccountChatPie)paramBaseChatPie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.PAHelperProvider
 * JD-Core Version:    0.7.0.1
 */