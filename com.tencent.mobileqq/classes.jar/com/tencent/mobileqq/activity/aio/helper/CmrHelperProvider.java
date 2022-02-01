package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;

public class CmrHelperProvider
  extends FriendHelperProvider
{
  public CmrHelperProvider(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    a((BusinessCmrTmpChatPie)paramBaseChatPie);
  }
  
  public void a(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie)
  {
    CmrAddFriendHelper localCmrAddFriendHelper = new CmrAddFriendHelper(paramBusinessCmrTmpChatPie.bv());
    a(113, localCmrAddFriendHelper);
    a(95, new TempMsgBoxAIOHelper(paramBusinessCmrTmpChatPie));
    a(localCmrAddFriendHelper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.CmrHelperProvider
 * JD-Core Version:    0.7.0.1
 */