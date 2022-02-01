package com.tencent.mobileqq.activity.recent.msg;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

public class RecentUserAppearLogic
{
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramInt == 1) {
      return true;
    }
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = ((RecentUserManager)paramQQAppInterface.getManager(QQManagerFactory.RECENT_USER)).a(paramInt);
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.a();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.RecentUserAppearLogic
 * JD-Core Version:    0.7.0.1
 */