package com.tencent.imcore.message;

import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class ConversationFacadeUtil
{
  public static void a(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    paramAppRuntime = (IConversationFacade)paramAppRuntime.getRuntimeService(IConversationFacade.class, "");
    int i = paramAppRuntime.getReadUnreadMark(paramString, paramInt);
    if (i > 10000)
    {
      QLog.e("Q.unread.Facade", 1, new Object[] { "Invalid Unread Mark: ", Integer.valueOf(i) });
      paramAppRuntime.setUnreadMark(paramString, paramInt, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.imcore.message.ConversationFacadeUtil
 * JD-Core Version:    0.7.0.1
 */