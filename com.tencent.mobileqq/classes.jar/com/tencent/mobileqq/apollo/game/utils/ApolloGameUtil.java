package com.tencent.mobileqq.apollo.game.utils;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.apollo.aio.api.impl.CmShowAioMatcherImpl;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class ApolloGameUtil
{
  private static SparseArray<Integer> a = new SparseArray();
  
  public static int a(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      return 0;
    }
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_key_apollo_game_life");
    localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
    return localSharedPreferences.getInt(localStringBuilder.toString(), 0);
  }
  
  public static int a(AppRuntime paramAppRuntime, int paramInt, String paramString)
  {
    if (CmShowAioMatcherImpl.judgeSupported(paramInt, 1)) {
      return 1;
    }
    if (1 == paramInt)
    {
      if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramString)))
      {
        paramAppRuntime = (HotChatManager)paramAppRuntime.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
        if ((paramAppRuntime != null) && (paramAppRuntime.b(paramString))) {
          return 6;
        }
      }
      return 4;
    }
    if (3000 == paramInt) {
      return 5;
    }
    if (1036 == paramInt) {
      return 7;
    }
    return paramInt;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt != 3) {
      return "gameConfig.json";
    }
    return "appConfig.json";
  }
  
  public static void a()
  {
    a.clear();
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    a.put(paramInt1, Integer.valueOf(paramInt2));
  }
  
  @Deprecated
  public static void a(AppInterface paramAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloGameUtil", 2, new Object[] { "[saveGameCoinCount] app=", paramAppInterface, ", gameCoinCount=", Integer.valueOf(paramInt) });
    }
    if (paramAppInterface == null) {
      return;
    }
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 4).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_key_apollo_game_life");
    localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
    localEditor.putInt(localStringBuilder.toString(), paramInt).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    Object localObject = ((ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloGameVer();
    if (localObject != null) {
      ((ConcurrentHashMap)localObject).put(Integer.valueOf(paramInt), paramString);
    }
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0).edit();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("apollo_game_ver_");
    ((StringBuilder)localObject).append(paramInt);
    paramQQAppInterface.putString(((StringBuilder)localObject).toString(), paramString).commit();
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    int i = ((Integer)a.get(paramInt1, Integer.valueOf(-2))).intValue();
    if (i == -2)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
      ((StringBuilder)localObject).append(String.valueOf(paramInt1));
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(a(paramInt2));
      localObject = new File(((StringBuilder)localObject).toString());
      if (((File)localObject).exists()) {
        try
        {
          localObject = new JSONObject(FileUtils.readFileContent((File)localObject));
          if (((JSONObject)localObject).has("viewMode"))
          {
            paramInt2 = ((JSONObject)localObject).optInt("viewMode") - 1;
            a.put(paramInt1, Integer.valueOf(paramInt2));
            return paramInt2;
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e("[cmshow]ApolloGameUtil", 1, localThrowable, new Object[] { "[getGameViewMode]" });
        }
      }
      return -1;
    }
    return i;
  }
  
  public static Activity b()
  {
    Activity localActivity;
    if (SplashActivity.sWeakInstance != null) {
      localActivity = (Activity)SplashActivity.sWeakInstance.get();
    } else {
      localActivity = null;
    }
    Object localObject = localActivity;
    if (localActivity == null) {
      localObject = BaseActivity.sTopActivity;
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.utils.ApolloGameUtil
 * JD-Core Version:    0.7.0.1
 */