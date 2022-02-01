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
    a(109, new PATipsHelper(paramPublicAccountChatPie.bv()));
    PAAddFriendHelper localPAAddFriendHelper = new PAAddFriendHelper(paramPublicAccountChatPie.bv());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.PAHelperProvider
 * JD-Core Version:    0.7.0.1
 */