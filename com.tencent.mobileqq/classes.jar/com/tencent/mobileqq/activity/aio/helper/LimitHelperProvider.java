package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie;
import com.tencent.mobileqq.inputstatus.InputStatusHelper;
import com.tencent.mobileqq.qqexpand.chat.IAioColdPalaceHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.AioFriendTitleHelper;

public class LimitHelperProvider
  extends HelperProvider
{
  public LimitHelperProvider(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void a(LimitChatPie paramLimitChatPie)
  {
    a(16, new InputStatusHelper(paramLimitChatPie));
    a(45, new AioFriendTitleHelper(paramLimitChatPie));
    paramLimitChatPie = ((IAioColdPalaceHelper)QRoute.api(IAioColdPalaceHelper.class)).newAioHelperInstance(paramLimitChatPie);
    if ((paramLimitChatPie instanceof ILifeCycleHelper)) {
      a(77, (ILifeCycleHelper)paramLimitChatPie);
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    a((LimitChatPie)paramBaseChatPie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.LimitHelperProvider
 * JD-Core Version:    0.7.0.1
 */