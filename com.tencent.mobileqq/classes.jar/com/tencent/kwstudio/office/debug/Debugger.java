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
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      synchronized (DEBUGGER_MAP)
      {
        paramString = (List)DEBUGGER_MAP.get(paramString);
        if (paramString == null) {
          break label68;
        }
        if (paramInt >= paramString.size())
        {
          break label68;
          return paramString;
        }
      }
      paramString = (IDebugger)paramString.get(paramInt);
      continue;
      label68:
      paramString = null;
    }
  }
  
  private static int getDebuggersSize(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    for (;;)
    {
      synchronized (DEBUGGER_MAP)
      {
        paramString = (List)DEBUGGER_MAP.get(paramString);
        if (paramString == null)
        {
          i = 0;
          return i;
        }
      }
      int i = paramString.size();
    }
  }
  
  public static String getVersionInfo(String paramString)
  {
    if (TextUtils.equals(paramString, "11")) {
      return "PoLib-" + Noumenon.getLibVersion("1") + "\nPrLib-" + Noumenon.getLibVersion("11") + "\nDoLib-" + Noumenon.getLibVersion("12") + "\nShLib-" + Noumenon.getLibVersion("13") + "\nSlLib-" + Noumenon.getLibVersion("14") + "\nViLib-" + Noumenon.getLibVersion("15");
    }
    return "";
  }
  
  public static boolean isUserEnable(String paramString)
  {
    return sIsUserEnable;
  }
  
  public static void setDebugger(String paramString, int paramInt, IDebugger paramIDebugger)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramIDebugger == null)) {
      return;
    }
    for (;;)
    {
      Object localObject;
      synchronized (DEBUGGER_MAP)
      {
        localObject = (List)DEBUGGER_MAP.get(paramString);
        if (localObject == null)
        {
          localObject = new LinkedList();
          DEBUGGER_MAP.put(paramString, localObject);
          paramString = (String)localObject;
          int i = paramString.size();
          if (paramInt >= i) {
            if (i < paramInt + 1)
            {
              paramString.add(null);
              i += 1;
              continue;
            }
          }
          paramString.set(paramInt, paramIDebugger);
          return;
        }
      }
      paramString = (String)localObject;
    }
  }
  
  private static void setInWhiteList(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("moduleId should be no-null.");
    }
    if (sIsWhiteList == paramBoolean) {
      return;
    }
    sIsWhiteList = paramBoolean;
    Noumenon.sHostInterface.commitPreferences(wrapKey("key_white_list", paramString), paramBoolean, true);
  }
  
  public static void setUserEnable(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("moduleId should be no-null.");
    }
    if (sIsUserEnable == paramBoolean) {
      return;
    }
    sIsUserEnable = paramBoolean;
    Noumenon.sHostInterface.commitPreferences(wrapKey("key_user_enable", paramString), paramBoolean, false);
  }
  
  public static boolean shouldDisable(String paramString)
  {
    if ((!sIsUserEnable) || (!sIsWhiteList)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        Log.w("Debugger", "shouldDisable, userEnable=" + sIsUserEnable + ", whiteList=" + sIsWhiteList);
      }
      return bool;
    }
  }
  
  public static void upgradePlugin(String paramString, Debugger.IDebugCallback paramIDebugCallback)
  {
    Global.getExecutor().execute(new Debugger.RunnableImpl(2, paramString, paramIDebugCallback, null));
  }
  
  private static String wrapKey(String paramString1, String paramString2)
  {
    return paramString1 + '_' + paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.kwstudio.office.debug.Debugger
 * JD-Core Version:    0.7.0.1
 */