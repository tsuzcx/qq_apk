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
        if (paramQQAppInterface.b(paramString2, paramString1) == null) {
          return 3;
        }
        paramQQAppInterface = paramQQAppInterface.b(paramString2);
        if ((paramQQAppInterface != null) && (paramQQAppInterface.isTroopOwner(paramString1))) {
          return 0;
        }
        if ((paramQQAppInterface != null) && (paramQQAppInterface.isTroopAdmin(paramString1))) {
          return 1;
        }
        if (paramQQAppInterface != null) {
          return 2;
        }
        return -1;
      }
      return -1;
    }
    return -1;
  }
  
  public static int b(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    switch (a(paramAppInterface, paramString1, paramString2))
    {
    default: 
      return 4;
    case 0: 
      return 3;
    case 1: 
      return 2;
    case 2: 
      return 1;
    }
    return 0;
  }
  
  private static int c(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    if ((paramAppInterface instanceof TroopMemberUtil.ITroopMemberGetter)) {
      return ((TroopMemberUtil.ITroopMemberGetter)paramAppInterface).a(paramString1, paramString2);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.utils.TroopMemberUtil
 * JD-Core Version:    0.7.0.1
 */