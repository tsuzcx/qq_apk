package com.tencent.imcore.message;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.utils.ContactUtils;
import mqq.app.AppRuntime;

public class MessageRecordCursorCallback
  implements MessageRecordCursor.Callback
{
  public Object a(String paramString, AppRuntime paramAppRuntime)
  {
    return Integer.valueOf(((FriendsManager)paramAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER)).r(paramString));
  }
  
  public Object a(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    if (paramInt == 3000) {
      return ContactUtils.a((QQAppInterface)paramAppRuntime, paramString);
    }
    if (paramInt == 1) {
      return ((TroopManager)paramAppRuntime.getManager(QQManagerFactory.TROOP_MANAGER)).i(paramString);
    }
    return ContactUtils.a((QQAppInterface)paramAppRuntime, paramString);
  }
  
  public Object a(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    return ContactUtils.a((QQAppInterface)paramAppRuntime, paramString1, paramString2, 1, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.MessageRecordCursorCallback
 * JD-Core Version:    0.7.0.1
 */