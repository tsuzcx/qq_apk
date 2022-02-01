package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.RobotChatPie;

public class RobotHelperProvider
  extends FriendHelperProvider
{
  public RobotHelperProvider(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void a(RobotChatPie paramRobotChatPie)
  {
    a(36, new RobotChatUIHelper(paramRobotChatPie));
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    a((RobotChatPie)paramBaseChatPie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.RobotHelperProvider
 * JD-Core Version:    0.7.0.1
 */