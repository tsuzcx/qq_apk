package com.tencent.mobileqq.activity.contact.troop;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.friends.intimate.IntimateInfoHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TroopWithCommonFriendsHelper
{
  private static HashMap<String, Integer> a = new HashMap();
  private static HashMap<String, Long> b = new HashMap();
  private static HashMap<String, List<TroopList>> c = new HashMap();
  private static HashMap<String, HashMap<String, Boolean>> d = new HashMap();
  
  public static byte a(QQAppInterface paramQQAppInterface, String paramString)
  {
    byte b2 = 0;
    byte b1 = b2;
    if (paramQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return 0;
      }
      paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      b1 = b2;
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.m(paramString);
        b1 = b2;
        if (paramQQAppInterface != null) {
          b1 = paramQQAppInterface.gender;
        }
      }
    }
    return b1;
  }
  
  public static int a(String paramString)
  {
    if (a.containsKey(paramString)) {
      return ((Integer)a.get(paramString)).intValue();
    }
    return 0;
  }
  
  public static List<CommonTroopData> a(ArrayList<TroopList> paramArrayList, QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    if (!paramArrayList.isEmpty())
    {
      if (paramQQAppInterface == null) {
        return localArrayList;
      }
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      int i = 0;
      while (i < paramArrayList.size())
      {
        String str = String.valueOf(((TroopList)paramArrayList.get(i)).a);
        TroopInfo localTroopInfo = paramQQAppInterface.g(str);
        if ((localTroopInfo != null) && (localTroopInfo.troopname != null) && (!localTroopInfo.troopname.isEmpty()))
        {
          CommonTroopData localCommonTroopData = new CommonTroopData();
          localCommonTroopData.c = localTroopInfo;
          localCommonTroopData.a = str;
          localCommonTroopData.b = ((TroopList)paramArrayList.get(i)).b;
          localArrayList.add(localCommonTroopData);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static void a(String paramString, int paramInt)
  {
    if ((paramInt > 0) && (!TextUtils.isEmpty(paramString))) {
      a.put(paramString, Integer.valueOf(paramInt));
    }
  }
  
  public static void a(String paramString, long paramLong)
  {
    if ((paramLong > 0L) && (!TextUtils.isEmpty(paramString))) {
      b.put(paramString, Long.valueOf(paramLong));
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, QQAppInterface paramQQAppInterface)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramString2);
      paramString2 = (ITroopMngHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER);
      if (paramString2 != null) {
        paramString2.a(paramString1, localArrayList, paramString3);
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put(paramString2, Boolean.valueOf(paramBoolean));
      d.put(paramString1, localHashMap);
    }
  }
  
  public static void a(String paramString, List<TroopList> paramList)
  {
    if (!TextUtils.isEmpty(paramString)) {
      c.put(paramString, paramList);
    }
  }
  
  public static boolean a(long paramLong, int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTroopWithCommonFriendsList,frienduin:");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("TroopWithCommonFriendsHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = String.valueOf(paramLong);
    paramQQAppInterface = (IntimateInfoHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER);
    if (!e((String)localObject))
    {
      paramQQAppInterface.a(a((String)localObject), f((String)localObject));
      if (QLog.isColorLevel()) {
        QLog.d("TroopWithCommonFriendsHelper", 2, "getTroopWithCommonFriendsList:EnableGetTroopList,false");
      }
      return false;
    }
    if ((paramLong > 0L) && (paramInt != 0))
    {
      paramQQAppInterface.b(paramLong, paramInt);
      return true;
    }
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = (HashMap)d.get(paramString1);
      if ((paramString1 != null) && (paramString1.containsKey(paramString2))) {
        return ((Boolean)paramString1.get(paramString2)).booleanValue();
      }
    }
    return true;
  }
  
  public static long b(String paramString)
  {
    if (b.containsKey(paramString)) {
      return ((Long)b.get(paramString)).longValue();
    }
    return 0L;
  }
  
  public static void c(String paramString)
  {
    if (a.containsKey(paramString)) {
      a.remove(paramString);
    }
  }
  
  public static void d(String paramString)
  {
    if (b.containsKey(paramString)) {
      b.remove(paramString);
    }
  }
  
  public static boolean e(String paramString)
  {
    long l1 = (System.currentTimeMillis() - b(paramString)) / 1000L;
    long l2 = a(paramString);
    if ((l1 < l2) && (l2 != 0L)) {
      return false;
    }
    c(paramString);
    d(paramString);
    g(paramString);
    return true;
  }
  
  public static List<TroopList> f(String paramString)
  {
    Object localObject = new ArrayList();
    if (c.containsKey(paramString)) {
      localObject = (List)c.get(paramString);
    }
    return localObject;
  }
  
  public static void g(String paramString)
  {
    if (c.containsKey(paramString)) {
      c.remove(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsHelper
 * JD-Core Version:    0.7.0.1
 */