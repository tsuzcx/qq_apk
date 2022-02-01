package com.tencent.mobileqq.apollo.game;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.game.process.CmGameServerQIPCModule;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLifeCycle;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.model.ApolloGameData;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLDecoder;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class ApolloGameTool
{
  private static final String[] a = { "http", "https", "GameRes", "GameSandBox" };
  
  public static int a()
  {
    return 5894;
  }
  
  public static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    if ((paramInt != 1) && (paramInt != 2))
    {
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("main.js");
    }
    else
    {
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("main.lua");
    }
    return localStringBuilder.toString();
  }
  
  public static String a(int paramInt, AppRuntime paramAppRuntime)
  {
    if (!new File(a(paramInt)).exists())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("[getApolloGameLocalVersion], errInfo->game main.lua file not exists, gameId:");
      paramAppRuntime.append(paramInt);
      QLog.i("[cmshow]ApolloGameTool", 1, paramAppRuntime.toString());
      return "0.0";
    }
    if (paramAppRuntime == null) {
      return "0.0";
    }
    Object localObject1 = (ApolloDaoManagerServiceImpl)paramAppRuntime.getRuntimeService(IApolloDaoManagerService.class, "all");
    Object localObject2 = ((ApolloDaoManagerServiceImpl)localObject1).getApolloGameVer();
    if (((ConcurrentHashMap)localObject2).size() == 0) {
      ((ApolloDaoManagerServiceImpl)localObject1).readApolloGameVerFromFile();
    } else if (TextUtils.isEmpty((CharSequence)((ConcurrentHashMap)localObject2).get(Integer.valueOf(paramInt)))) {
      ((ApolloDaoManagerServiceImpl)localObject1).readApolloGameVerFromFile(paramInt);
    }
    localObject2 = (String)((ConcurrentHashMap)localObject2).get(Integer.valueOf(paramInt));
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      paramAppRuntime = paramAppRuntime.getApplication().getSharedPreferences("apollo_sp", 0);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("apollo_game_ver_");
      ((StringBuilder)localObject1).append(paramInt);
      localObject1 = paramAppRuntime.getString(((StringBuilder)localObject1).toString(), "0.0");
      QLog.i("[cmshow]ApolloGameTool", 1, "read game ver from sp");
    }
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("gameVer:");
      paramAppRuntime.append((String)localObject1);
      paramAppRuntime.append(",id:");
      paramAppRuntime.append(paramInt);
      QLog.d("[cmshow]ApolloGameTool", 2, paramAppRuntime.toString());
    }
    return localObject1;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    Object localObject1 = paramString1;
    boolean bool = TextUtils.isEmpty(paramString1);
    Object localObject5 = null;
    if (bool) {
      return null;
    }
    if (paramString1.length() > 4096)
    {
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("[urlToPath] too long ");
        paramString2.append(paramString1.substring(0, 100));
        QLog.d("[cmshow]ApolloGameTool", 2, paramString2.toString());
      }
      return null;
    }
    Object localObject3;
    try
    {
      localObject3 = URLDecoder.decode(paramString1, "UTF-8");
      localObject1 = localObject3;
      int i = ((String)localObject3).indexOf("://");
      if (i == -1) {
        return null;
      }
      paramString1 = (String)localObject3;
      if (paramBoolean)
      {
        localObject1 = localObject3;
        paramString1 = Uri.parse((String)localObject3);
        localObject1 = localObject3;
        localObject4 = paramString1.getHost();
        localObject1 = localObject3;
        j = paramString1.getPort();
        localObject2 = localObject3;
        if (j != 0)
        {
          localObject1 = localObject3;
          paramString1 = new StringBuilder();
          localObject1 = localObject3;
          paramString1.append(":");
          localObject1 = localObject3;
          paramString1.append(j);
          localObject1 = localObject3;
          localObject2 = ((String)localObject3).replace(paramString1.toString(), "");
        }
        paramString1 = (String)localObject2;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          localObject1 = localObject2;
          paramString1 = new StringBuilder();
          localObject1 = localObject2;
          paramString1.append((String)localObject4);
          localObject1 = localObject2;
          paramString1.append("/");
          localObject1 = localObject2;
          paramString1 = paramString1.toString();
          localObject1 = localObject2;
          if (((String)localObject2).contains(paramString1))
          {
            localObject1 = localObject2;
            paramString1 = ((String)localObject2).replace(paramString1, "");
          }
          else
          {
            localObject1 = localObject2;
            paramString1 = ((String)localObject2).replace((CharSequence)localObject4, "");
          }
        }
      }
      Object localObject2 = paramString1;
      localObject1 = paramString1;
      if (paramString1.contains("?"))
      {
        localObject1 = paramString1;
        j = paramString1.indexOf("?");
        if (j == 0) {
          return null;
        }
        localObject2 = paramString1;
        if (j != -1)
        {
          localObject1 = paramString1;
          localObject2 = paramString1.substring(0, j);
        }
      }
      localObject1 = localObject2;
      Object localObject4 = ((String)localObject2).substring(0, i);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        return null;
      }
      localObject1 = localObject2;
      Object localObject6 = a;
      localObject1 = localObject2;
      int j = localObject6.length;
      i = 0;
      for (;;)
      {
        paramString1 = (String)localObject2;
        localObject3 = localObject5;
        if (i >= j) {
          break label849;
        }
        localObject1 = localObject2;
        if (((String)localObject4).equals(localObject6[i])) {
          break;
        }
        i += 1;
      }
      localObject1 = localObject2;
      localObject6 = a(String.valueOf(paramInt));
      localObject1 = localObject2;
      paramString1 = new StringBuilder();
      localObject1 = localObject2;
      paramString1.append((String)localObject4);
      localObject1 = localObject2;
      paramString1.append("://");
      localObject1 = localObject2;
      paramString1 = ((String)localObject2).replace(paramString1.toString(), "");
      localObject4 = paramString1;
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramString2))
      {
        localObject1 = localObject2;
        localObject3 = new StringBuilder();
        localObject1 = localObject2;
        ((StringBuilder)localObject3).append(paramString2);
        localObject1 = localObject2;
        ((StringBuilder)localObject3).append("/");
        localObject1 = localObject2;
        ((StringBuilder)localObject3).append(paramString1);
        localObject1 = localObject2;
        localObject4 = ((StringBuilder)localObject3).toString();
      }
      localObject1 = localObject2;
      paramString1 = (String)localObject2;
      localObject3 = localObject5;
      if (!TextUtils.isEmpty((CharSequence)localObject6))
      {
        localObject1 = localObject2;
        paramString1 = (String)localObject2;
        localObject3 = localObject5;
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          localObject1 = localObject2;
          paramString1 = new StringBuilder();
          localObject1 = localObject2;
          paramString1.append((String)localObject6);
          localObject1 = localObject2;
          paramString1.append("/");
          localObject1 = localObject2;
          paramString1.append((String)localObject4);
          localObject1 = localObject2;
          paramString2 = new File(paramString1.toString());
          localObject1 = localObject2;
          localObject4 = new File((String)localObject6);
          localObject1 = localObject2;
          paramString1 = (String)localObject2;
          localObject3 = localObject5;
          if (paramString2.exists())
          {
            localObject1 = localObject2;
            paramString1 = (String)localObject2;
            localObject3 = localObject5;
            if (paramString2.isFile())
            {
              localObject1 = localObject2;
              paramString1 = ((File)localObject4).getCanonicalPath();
              localObject1 = localObject2;
              localObject3 = paramString2.getCanonicalPath();
              localObject1 = localObject2;
              if (!TextUtils.isEmpty(paramString1))
              {
                localObject1 = localObject2;
                if (!TextUtils.isEmpty((CharSequence)localObject3))
                {
                  localObject1 = localObject2;
                  if (((String)localObject3).startsWith(paramString1))
                  {
                    paramString1 = (String)localObject2;
                    break label849;
                  }
                }
              }
              localObject1 = localObject2;
              paramString1 = (String)localObject2;
              localObject3 = localObject5;
              if (QLog.isColorLevel())
              {
                localObject1 = localObject2;
                QLog.d("[cmshow]ApolloGameTool", 2, "[urlToPath] path leak");
                paramString1 = (String)localObject2;
                localObject3 = localObject5;
              }
            }
          }
        }
      }
    }
    catch (Throwable paramString1)
    {
      QLog.e("[cmshow]ApolloGameTool", 1, paramString1, new Object[0]);
      localObject3 = localObject5;
      paramString1 = (String)localObject1;
    }
    label849:
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("[urlToPath] ");
      paramString2.append(paramString1);
      paramString2.append(" ");
      paramString2.append((String)localObject3);
      QLog.d("[cmshow]ApolloGameTool", 2, paramString2.toString());
    }
    return localObject3;
  }
  
  public static void a(Activity paramActivity)
  {
    if (paramActivity != null)
    {
      if (paramActivity.isFinishing()) {
        return;
      }
      paramActivity = paramActivity.getWindow();
      if (paramActivity == null) {
        return;
      }
      paramActivity.getDecorView().setSystemUiVisibility(a());
    }
  }
  
  public static boolean a(@NonNull AppInterface paramAppInterface, @NonNull StartCheckParam paramStartCheckParam)
  {
    Object localObject = ((IApolloDaoManagerService)paramAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).findGameById(paramStartCheckParam.gameId);
    if (localObject == null) {
      return false;
    }
    paramStartCheckParam.game = ((ApolloGameData)localObject);
    paramStartCheckParam.startT = System.currentTimeMillis();
    paramStartCheckParam.version = a(paramStartCheckParam.gameId, paramAppInterface);
    paramAppInterface = CmGameServerQIPCModule.b().a(paramStartCheckParam.gameId);
    localObject = ApolloGameUtil.b();
    if (paramAppInterface != null) {
      paramAppInterface.a((Activity)localObject, paramStartCheckParam);
    }
    if (localObject == null) {}
    for (;;)
    {
      try
      {
        paramAppInterface = BaseApplicationImpl.getContext();
        paramAppInterface = new Intent(paramAppInterface, CmIslandActivity.class);
        paramAppInterface.setFlags(196608);
        paramAppInterface.putExtra("extra_startcheckparam", paramStartCheckParam);
        ((Activity)localObject).startActivity(paramAppInterface);
        return true;
      }
      catch (Exception paramAppInterface)
      {
        QLog.e("[cmshow]ApolloGameTool", 1, "[startIsland] exception=", paramAppInterface);
        return false;
      }
      paramAppInterface = (AppInterface)localObject;
    }
  }
  
  public static int b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        int i = new JSONObject(paramString).optInt("xyRootSrc");
        return i;
      }
      catch (Throwable paramString)
      {
        QLog.e("[cmshow]ApolloGameTool", 1, paramString, new Object[0]);
      }
    }
    return 0;
  }
  
  public static String b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public static void b()
  {
    ThreadManager.post(new ApolloGameTool.1(), 5, null, true);
  }
  
  public static SharedPreferences c()
  {
    int i;
    if (BaseApplicationImpl.sProcessId != 1) {
      i = 4;
    } else {
      i = 0;
    }
    return BaseApplicationImpl.getApplication().getSharedPreferences("apollo_game_res", i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameTool
 * JD-Core Version:    0.7.0.1
 */