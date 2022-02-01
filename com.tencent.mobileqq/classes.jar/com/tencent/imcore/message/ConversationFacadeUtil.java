package com.tencent.imcore.message;

import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.persistence.service.ICommonFunctionPublishConfigService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class ConversationFacadeUtil
{
  public static void a(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    paramAppRuntime = (IConversationFacade)paramAppRuntime.getRuntimeService(IConversationFacade.class, "");
    int j = paramAppRuntime.getReadUnreadMark(paramString, paramInt);
    int i;
    if (!((ICommonFunctionPublishConfigService)QRoute.api(ICommonFunctionPublishConfigService.class)).isUseNewInvalidUnreadMarkThreshold()) {
      i = 10000;
    } else {
      i = 1;
    }
    if (j > i)
    {
      QLog.e("Q.unread.Facade", 1, new Object[] { "Invalid Unread Mark: ", Integer.valueOf(j) });
      paramAppRuntime.setUnreadMark(paramString, paramInt, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ConversationFacadeUtil
 * JD-Core Version:    0.7.0.1
 */