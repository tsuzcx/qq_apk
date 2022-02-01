package com.tencent.mobileqq.apollo.game;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.ThreadManager;

public class ApolloGameConfig
{
  static {}
  
  public static void a()
  {
    ThreadManager.post(new ApolloGameConfig.1(), 8, null, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameConfig
 * JD-Core Version:    0.7.0.1
 */