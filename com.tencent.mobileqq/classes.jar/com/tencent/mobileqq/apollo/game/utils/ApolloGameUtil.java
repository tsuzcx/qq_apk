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
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.script.SpriteRscBuilder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
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
  public static int a = -1;
  private static SparseArray<Integer> jdField_a_of_type_AndroidUtilSparseArray;
  private static boolean jdField_a_of_type_Boolean = false;
  
  public static int a(int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
    ((StringBuilder)localObject1).append(String.valueOf(paramInt));
    ((StringBuilder)localObject1).append("/gameConfig.json");
    localObject1 = new File(((StringBuilder)localObject1).toString());
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
    ((StringBuilder)localObject2).append(String.valueOf(paramInt));
    ((StringBuilder)localObject2).append("/appConfig.json");
    localObject2 = new File(((StringBuilder)localObject2).toString());
    if (((File)localObject1).exists())
    {
      localObject1 = FileUtils.readFileContent((File)localObject1);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        try
        {
          localObject1 = new JSONObject((String)localObject1).optString("enterUrl");
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            if (((String)localObject1).contains("urlshare.cn")) {
              return 4;
            }
            boolean bool = ((String)localObject1).contains("_bkfv=5");
            if (bool) {
              return 5;
            }
            return 2;
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e("[cmshow]ApolloGameUtil", 1, localThrowable, new Object[0]);
        }
      }
      return 1;
    }
    if (((File)localObject2).exists()) {
      return 3;
    }
    return 1;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    Object localObject = a;
    int i;
    if (localObject == null)
    {
      a = new SparseArray();
      i = -2;
    }
    else
    {
      i = ((Integer)((SparseArray)localObject).get(paramInt1, Integer.valueOf(-2))).intValue();
    }
    if (i == -2)
    {
      localObject = new StringBuilder();
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
  
  public static int a(AppRuntime paramAppRuntime)
  {
    return ((IApolloManagerService)paramAppRuntime.getRuntimeService(IApolloManagerService.class, "all")).getApolloUserStatus();
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
  
  public static Activity a()
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
  
  public static SharedPreferences a()
  {
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "noLogin";
    }
    localObject2 = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp.game");
    localStringBuilder.append((String)localObject1);
    return ((BaseApplicationImpl)localObject2).getSharedPreferences(localStringBuilder.toString(), 0);
  }
  
  public static String a(int paramInt)
  {
    if (paramInt != 3) {
      return "gameConfig.json";
    }
    return "appConfig.json";
  }
  
  public static JSONObject a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      try
      {
        paramString = new JSONObject(paramString);
        long l = paramString.optLong("taskId");
        paramQQAppInterface = SpriteRscBuilder.a(paramQQAppInterface, paramString);
        if (paramQQAppInterface == null) {
          return null;
        }
        paramString = new JSONObject();
        paramString.put("ret", 0);
        paramString.put("actionInfo", paramQQAppInterface);
        paramString.put("taskId", l);
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloGameUtil", 2, new Object[] { "ReqAction,", paramString.toString() });
        }
        return paramString;
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.e("[cmshow]ApolloGameUtil", 1, paramQQAppInterface, new Object[0]);
      }
    }
    return null;
  }
  
  public static void a()
  {
    try
    {
      if (a == null) {
        break label26;
      }
      a.clear();
      a = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      label17:
      label26:
      break label17;
    }
    QLog.e("[cmshow]ApolloGameUtil", 1, "[releaseCache] clear err");
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
  
  public static void a(QQAppInterface paramQQAppInterface, StartCheckParam paramStartCheckParam)
  {
    if (paramQQAppInterface != null)
    {
      if (paramStartCheckParam == null) {
        return;
      }
      ThreadManager.post(new ApolloGameUtil.2(paramQQAppInterface, paramStartCheckParam), 5, null, true);
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 3) || (paramInt == 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.utils.ApolloGameUtil
 * JD-Core Version:    0.7.0.1
 */