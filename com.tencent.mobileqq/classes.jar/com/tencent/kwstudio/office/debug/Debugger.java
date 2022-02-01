package com.tencent.kwstudio.office.debug;

import android.text.TextUtils;
import com.tencent.kwstudio.office.base.Global;
import com.tencent.kwstudio.office.base.Log;
import com.tencent.kwstudio.office.preview.IHostInterface;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

public final class Debugger
{
  private static final String CGI_RSP_IS_WHITE = "is_white_uin";
  private static final String CGI_RSP_RET_CODE = "retcode";
  private static final String CGI_URL_CONFIG_GET = "https://preview-report.docs.qq.com/online_docs_cgi/preview/config_get";
  private static final Map<String, List<IDebugger>> DEBUGGER_MAP = new HashMap();
  private static final String KEY_USER_ENABLE = "key_user_enable";
  private static final String KEY_WHITE_LIST = "key_white_list";
  private static final String TAG = "Debugger";
  private static volatile boolean sIsUserEnable = true;
  private static volatile boolean sIsWhiteList = true;
  
  static void active()
  {
    Noumenon.sHostInterface.queryPreferences(wrapKey("key_user_enable", "11"), true, false, new Debugger.PreferencesCallbackImpl("key_user_enable"));
    Noumenon.sHostInterface.queryPreferences(wrapKey("key_white_list", "11"), true, true, new Debugger.PreferencesCallbackImpl("key_white_list"));
  }
  
  public static void checkWhiteListFromRemote(String paramString)
  {
    Noumenon.sHostInterface.sendHttpRequest("https://preview-report.docs.qq.com/online_docs_cgi/preview/config_get", true, "", new Debugger.1(paramString));
  }
  
  public static void cleanCache(String paramString, Debugger.IDebugCallback paramIDebugCallback)
  {
    Global.getExecutor().execute(new Debugger.RunnableImpl(3, paramString, paramIDebugCallback, null));
  }
  
  public static void cleanPlugin(String paramString, Debugger.IDebugCallback paramIDebugCallback)
  {
    Global.getExecutor().execute(new Debugger.RunnableImpl(1, paramString, paramIDebugCallback, null));
  }
  
  private static IDebugger getDebugger(String paramString, int paramInt)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject = null;
    if (bool) {
      return null;
    }
    synchronized (DEBUGGER_MAP)
    {
      List localList = (List)DEBUGGER_MAP.get(paramString);
      paramString = localObject;
      if (localList != null) {
        if (paramInt >= localList.size()) {
          paramString = localObject;
        } else {
          paramString = (IDebugger)localList.get(paramInt);
        }
      }
      return paramString;
    }
  }
  
  private static int getDebuggersSize(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int i = 0;
    if (bool) {
      return 0;
    }
    synchronized (DEBUGGER_MAP)
    {
      paramString = (List)DEBUGGER_MAP.get(paramString);
      if (paramString != null) {
        i = paramString.size();
      }
      return i;
    }
  }
  
  public static String getVersionInfo(String paramString)
  {
    if (TextUtils.equals(paramString, "11"))
    {
      paramString = new StringBuilder();
      paramString.append("PoLib-");
      paramString.append(Noumenon.getLibVersion("1"));
      paramString.append("\nPrLib-");
      paramString.append(Noumenon.getLibVersion("11"));
      paramString.append("\nDoLib-");
      paramString.append(Noumenon.getLibVersion("12"));
      paramString.append("\nShLib-");
      paramString.append(Noumenon.getLibVersion("13"));
      paramString.append("\nSlLib-");
      paramString.append(Noumenon.getLibVersion("14"));
      paramString.append("\nViLib-");
      paramString.append(Noumenon.getLibVersion("15"));
      return paramString.toString();
    }
    return "";
  }
  
  public static boolean isUserEnable(String paramString)
  {
    return sIsUserEnable;
  }
  
  public static void setDebugger(String paramString, int paramInt, IDebugger paramIDebugger)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramIDebugger == null) {
        return;
      }
      synchronized (DEBUGGER_MAP)
      {
        List localList = (List)DEBUGGER_MAP.get(paramString);
        Object localObject = localList;
        if (localList == null)
        {
          localObject = new LinkedList();
          DEBUGGER_MAP.put(paramString, localObject);
        }
        int i = ((List)localObject).size();
        if (paramInt >= i) {
          while (i < paramInt + 1)
          {
            ((List)localObject).add(null);
            i += 1;
          }
        }
        ((List)localObject).set(paramInt, paramIDebugger);
        return;
      }
    }
  }
  
  private static void setInWhiteList(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (sIsWhiteList == paramBoolean) {
        return;
      }
      sIsWhiteList = paramBoolean;
      Noumenon.sHostInterface.commitPreferences(wrapKey("key_white_list", paramString), paramBoolean, true);
      return;
    }
    throw new IllegalArgumentException("moduleId should be no-null.");
  }
  
  public static void setUserEnable(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (sIsUserEnable == paramBoolean) {
        return;
      }
      sIsUserEnable = paramBoolean;
      Noumenon.sHostInterface.commitPreferences(wrapKey("key_user_enable", paramString), paramBoolean, false);
      return;
    }
    throw new IllegalArgumentException("moduleId should be no-null.");
  }
  
  public static boolean shouldDisable(String paramString)
  {
    boolean bool;
    if ((sIsUserEnable) && (sIsWhiteList)) {
      bool = false;
    } else {
      bool = true;
    }
    if (bool)
    {
      paramString = new StringBuilder();
      paramString.append("shouldDisable, userEnable=");
      paramString.append(sIsUserEnable);
      paramString.append(", whiteList=");
      paramString.append(sIsWhiteList);
      Log.w("Debugger", paramString.toString());
    }
    return bool;
  }
  
  public static void upgradePlugin(String paramString, Debugger.IDebugCallback paramIDebugCallback)
  {
    Global.getExecutor().execute(new Debugger.RunnableImpl(2, paramString, paramIDebugCallback, null));
  }
  
  private static String wrapKey(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append('_');
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.kwstudio.office.debug.Debugger
 * JD-Core Version:    0.7.0.1
 */