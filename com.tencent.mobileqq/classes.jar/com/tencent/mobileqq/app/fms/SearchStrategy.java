package com.tencent.mobileqq.app.fms;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

public class SearchStrategy
{
  public static int a = 9999;
  public static long a = 863913600L;
  public static Integer[] a;
  public static int b = 2147483647;
  public static Integer[] b;
  public static int c = 3000;
  
  static
  {
    Integer localInteger = Integer.valueOf(1);
    jdField_a_of_type_ArrayOfJavaLangInteger = new Integer[] { Integer.valueOf(0), localInteger, Integer.valueOf(3000) };
    b = new Integer[] { localInteger, Integer.valueOf(4), Integer.valueOf(2), Integer.valueOf(3) };
  }
  
  public static boolean a(int paramInt)
  {
    Integer[] arrayOfInteger = jdField_a_of_type_ArrayOfJavaLangInteger;
    int j = arrayOfInteger.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfInteger[i].intValue() == paramInt) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    if (NetConnInfoCenter.getServerTime() - paramRecentUser.lastmsgtime >= jdField_a_of_type_Long) {
      return false;
    }
    if (!a(paramRecentUser.getType())) {
      return false;
    }
    return (paramRecentUser.getType() != 1) || (b(paramQQAppInterface.getTroopMask(paramRecentUser.uin)));
  }
  
  public static boolean b(int paramInt)
  {
    Integer[] arrayOfInteger = b;
    int j = arrayOfInteger.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfInteger[i].intValue() == paramInt) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.fms.SearchStrategy
 * JD-Core Version:    0.7.0.1
 */