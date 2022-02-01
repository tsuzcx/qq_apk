package com.tencent.av.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;

public class TroopMemberUtil
{
  public static int a(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      return a((QQAppInterface)paramAppInterface, paramString1, paramString2);
    }
    return c(paramAppInterface, paramString1, paramString2);
  }
  
  private static int a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (paramQQAppInterface != null)
      {
        if (paramQQAppInterface.g(paramString2, paramString1) == null) {
          return 3;
        }
        paramQQAppInterface = paramQQAppInterface.f(paramString2);
        if ((paramQQAppInterface != null) && (paramQQAppInterface.isTroopOwner(paramString1))) {
          return 0;
        }
        if ((paramQQAppInterface != null) && (paramQQAppInterface.isTroopAdmin(paramString1))) {
          return 1;
        }
        if (paramQQAppInterface != null) {
          return 2;
        }
      }
    }
    return -1;
  }
  
  public static int b(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    int j = a(paramAppInterface, paramString1, paramString2);
    int i = 3;
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3) {
            return 4;
          }
          return 0;
        }
        return 1;
      }
      i = 2;
    }
    return i;
  }
  
  private static int c(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    if ((paramAppInterface instanceof TroopMemberUtil.ITroopMemberGetter)) {
      return ((TroopMemberUtil.ITroopMemberGetter)paramAppInterface).a(paramString1, paramString2);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.TroopMemberUtil
 * JD-Core Version:    0.7.0.1
 */