package com.tencent.mobileqq.apollo.game;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.game.ApolloGameConst;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class ApolloGameConfig
{
  static {}
  
  public static int a(String paramString)
  {
    int i = -1;
    SharedPreferences localSharedPreferences = ApolloGameUtil.a();
    if (localSharedPreferences != null) {
      i = localSharedPreferences.getInt(paramString, -1);
    }
    return i;
  }
  
  public static int a(String paramString, QQAppInterface paramQQAppInterface)
  {
    int j = -1;
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = (ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      int i;
      if ("aio.city.game".equals(paramString))
      {
        i = j;
        if (paramQQAppInterface != null)
        {
          if (!paramQQAppInterface.mIsNewStoreUser) {
            break label46;
          }
          i = ApolloGameConst.d;
        }
      }
      label46:
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return i;
              i = -1;
            }
            i = j;
          } while (!"drawer.game".equals(paramString));
          i = j;
        } while (paramQQAppInterface == null);
        i = j;
      } while (!paramQQAppInterface.mIsDrawerGameBoxUser);
      return ApolloGameConst.b;
    }
    QLog.e("ApolloGameConfig", 1, "app is null");
    return -1;
  }
  
  public static void a()
  {
    ThreadManager.post(new ApolloGameConfig.1(), 8, null, true);
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = ApolloGameUtil.a();
    if (localSharedPreferences != null)
    {
      localSharedPreferences.edit().putInt(paramString, paramInt).apply();
      return true;
    }
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = ApolloGameUtil.a();
    if (localSharedPreferences != null)
    {
      localSharedPreferences.edit().putString(paramString1, paramString2).apply();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameConfig
 * JD-Core Version:    0.7.0.1
 */