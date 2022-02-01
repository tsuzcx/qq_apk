package com.tencent.ark.open;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.open.security.ArkAppUrlChecker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkAppConfigMgr
{
  private static final String ALLOW_FORWARD = "*";
  public static final int DOWNLOAD_ICON_FAIL = 2;
  public static final int DOWNLOAD_ICON_FILE_ERROR = -1;
  public static final int DOWNLOAD_ICON_PARAM_ERROR = -2;
  public static final int DOWNLOAD_ICON_SUCESS = 1;
  private static final ArkEnvironmentManager ENV = ;
  private static final String ICON_TEMP_FILE_SUFFIX = "_tmp";
  private static final String JSON_KEY_APP_GLOBAL_URL_BLACK = "black";
  private static final String JSON_KEY_APP_GLOBAL_URL_CONFIG = "app_global_url_config";
  private static final String JSON_KEY_APP_GLOBAL_URL_WHITE = "white";
  private static final String JSON_KEY_ENTRY = "entry";
  private static final String JSON_KEY_FLAG = "flag";
  private static final String JSON_KEY_FORWARD_VIEWS = "fwdViews";
  private static final String JSON_KEY_ICON = "icon";
  private static final String JSON_KEY_NAME = "name";
  private static final String JSON_KEY_NAV = "nav";
  private static final String JSON_KEY_RES = "res";
  private static final String JSON_KEY_TEMPLATE = "temp";
  private static final String JSON_KEY_TEMPLATE_VIEW = "tempView";
  private static final String JSON_KEY_TYPE = "type";
  private static final String JSON_KEY_URLWHITELIST = "urlWhitelist";
  private static final String JSON_KEY_VER = "ver";
  private static final String JSON_KEY_VIEW = "view";
  private static final String JSON_KEY_VIEWS = "views";
  private static final String TAG = "ArkApp.ArkAppConfigMgr";
  public static Object lock = new Object();
  private static boolean sEnableAppConfig = true;
  private static volatile ArkAppConfigMgr sInstance;
  private HashMap<String, ArkAppInfo.AppConfig> mAppConfigCache = new HashMap(8);
  private HashMap<String, ArkAppUrlChecker> mAppUrlCheckerCache = new HashMap(8);
  private Map<String, ArkAppConfigMgr.DownloadIconTask> mDownloadIconTaskList = Collections.synchronizedMap(new HashMap());
  private ArrayList<ArkAppInfo.ArkWhiteUrlItem> mGlobalBlackList = null;
  private ArrayList<ArkAppInfo.ArkWhiteUrlItem> mGlobalWhiteList = null;
  public boolean mUrlCheckEnable = true;
  private ArrayList<String> mUrlDisableAppList = new ArrayList(4);
  
  private void checkAppIcon(String paramString, ArkAppInfo.AppConfig paramAppConfig)
  {
    ArkDispatchTask.getInstance().postToArkThread(new ArkAppConfigMgr.4(this, paramAppConfig, paramString));
  }
  
  public static String convertConfigToJsonString(ArkAppInfo.AppConfig paramAppConfig)
  {
    if (paramAppConfig == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ver", paramAppConfig.ver);
      localJSONObject.put("name", paramAppConfig.name);
      localJSONObject.put("icon", paramAppConfig.iconUrl);
      localJSONObject.put("entry", paramAppConfig.entry);
      localJSONObject.put("flag", paramAppConfig.flag);
      localJSONObject.put("type", paramAppConfig.type);
      if (paramAppConfig.urlWhitelist == null) {
        break label249;
      }
      localObject1 = new JSONObject();
      localObject2 = paramAppConfig.urlWhitelist.resourceList;
      if (localObject2 == null) {
        break label168;
      }
      localObject3 = new JSONArray();
      i = 0;
    }
    catch (JSONException paramAppConfig)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        Object localObject3;
        int i;
        ArkAppInfo.ArkWhiteUrlItem localArkWhiteUrlItem;
        label168:
        label249:
        ENV.logE("ArkApp.ArkAppConfigMgr", new Object[] { "ArkSafe.convert json exeption:", paramAppConfig.toString() });
        continue;
        i += 1;
        continue;
        i += 1;
        continue;
        i += 1;
        continue;
        i += 1;
      }
    }
    if (i < ((ArrayList)localObject2).size())
    {
      localArkWhiteUrlItem = (ArkAppInfo.ArkWhiteUrlItem)((ArrayList)localObject2).get(i);
      if (localArkWhiteUrlItem != null) {
        ((JSONArray)localObject3).put(localArkWhiteUrlItem.toString());
      }
    }
    else
    {
      ((JSONObject)localObject1).put("res", localObject3);
      localObject2 = paramAppConfig.urlWhitelist.navigationList;
      if (localObject2 != null)
      {
        localObject3 = new JSONArray();
        i = 0;
        if (i < ((ArrayList)localObject2).size())
        {
          localArkWhiteUrlItem = (ArkAppInfo.ArkWhiteUrlItem)((ArrayList)localObject2).get(i);
          if (localArkWhiteUrlItem == null) {
            break label489;
          }
          ((JSONArray)localObject3).put(localArkWhiteUrlItem.toString());
          break label489;
        }
        ((JSONObject)localObject1).put("nav", localObject3);
      }
      localJSONObject.put("urlWhitelist", localObject1);
      if ((paramAppConfig.views != null) && (paramAppConfig.views.size() > 0))
      {
        localObject1 = new JSONArray();
        i = 0;
        if (i < paramAppConfig.views.size())
        {
          localObject2 = (ArkAppInfo.AppTemplateView)paramAppConfig.views.get(i);
          if (localObject2 == null) {
            break label496;
          }
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("view", ((ArkAppInfo.AppTemplateView)localObject2).view);
          ((JSONObject)localObject3).put("temp", ((ArkAppInfo.AppTemplateView)localObject2).template);
          ((JSONObject)localObject3).put("tempView", ((ArkAppInfo.AppTemplateView)localObject2).templateView);
          ((JSONArray)localObject1).put(localObject3);
          break label496;
        }
        localJSONObject.put("views", localObject1);
      }
      if ((paramAppConfig.forwardViews != null) && (paramAppConfig.forwardViews.size() > 0))
      {
        localObject1 = new JSONArray();
        i = 0;
        if (i < paramAppConfig.forwardViews.size())
        {
          localObject2 = (String)paramAppConfig.forwardViews.get(i);
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label503;
          }
          ((JSONArray)localObject1).put(localObject2);
          break label503;
        }
        localJSONObject.put("fwdViews", localObject1);
      }
      return localJSONObject.toString();
    }
  }
  
  public static ArkAppInfo.AppConfig convertJsonToConfig(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      paramJSONObject = null;
      return paramJSONObject;
    }
    ArkAppInfo.AppConfig localAppConfig = new ArkAppInfo.AppConfig();
    for (;;)
    {
      int i;
      try
      {
        localAppConfig.ver = paramJSONObject.optLong("ver");
        localAppConfig.name = paramJSONObject.optString("name");
        localAppConfig.iconUrl = paramJSONObject.optString("icon");
        localAppConfig.entry = paramJSONObject.optLong("entry");
        localAppConfig.flag = paramJSONObject.optInt("flag");
        localAppConfig.type = paramJSONObject.optInt("type");
        Object localObject1 = paramJSONObject.optJSONObject("urlWhitelist");
        Object localObject2;
        Object localObject3;
        if (localObject1 != null)
        {
          localAppConfig.urlWhitelist = new ArkAppInfo.AppUrlWhiteList();
          localObject2 = ((JSONObject)localObject1).optJSONArray("res");
          if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
          {
            i = 0;
            if (i < ((JSONArray)localObject2).length())
            {
              localObject3 = convertWhiteUrlToItem(((JSONArray)localObject2).optString(i));
              if (localObject3 == null) {
                break label437;
              }
              localAppConfig.urlWhitelist.resourceList.add(localObject3);
              break label437;
            }
          }
          localObject1 = ((JSONObject)localObject1).optJSONArray("nav");
          if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
          {
            i = 0;
            if (i < ((JSONArray)localObject1).length())
            {
              localObject2 = convertWhiteUrlToItem(((JSONArray)localObject1).optString(i));
              if (localObject2 == null) {
                break label444;
              }
              localAppConfig.urlWhitelist.navigationList.add(localObject2);
              break label444;
            }
          }
        }
        localObject1 = paramJSONObject.optJSONArray("views");
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          localAppConfig.views = new ArrayList(((JSONArray)localObject1).length());
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            localObject2 = ((JSONArray)localObject1).optJSONObject(i);
            if (localObject2 == null) {
              break label451;
            }
            localObject3 = new ArkAppInfo.AppTemplateView();
            ((ArkAppInfo.AppTemplateView)localObject3).view = ((JSONObject)localObject2).optString("view");
            ((ArkAppInfo.AppTemplateView)localObject3).template = ((JSONObject)localObject2).optString("temp");
            ((ArkAppInfo.AppTemplateView)localObject3).templateView = ((JSONObject)localObject2).optString("tempView");
            localAppConfig.views.add(localObject3);
            break label451;
          }
        }
        localObject1 = paramJSONObject.optJSONArray("fwdViews");
        paramJSONObject = localAppConfig;
        if (localObject1 == null) {
          break;
        }
        paramJSONObject = localAppConfig;
        if (((JSONArray)localObject1).length() <= 0) {
          break;
        }
        localAppConfig.forwardViews = new ArrayList(((JSONArray)localObject1).length());
        i = 0;
        paramJSONObject = localAppConfig;
        if (i >= ((JSONArray)localObject1).length()) {
          break;
        }
        paramJSONObject = ((JSONArray)localObject1).optString(i);
        if (paramJSONObject != null) {
          localAppConfig.forwardViews.add(paramJSONObject);
        }
        i += 1;
        continue;
        i += 1;
      }
      catch (Exception paramJSONObject)
      {
        ENV.logI("ArkApp.ArkAppConfigMgr", new Object[] { "ArkSafe.convert json exception:", paramJSONObject.toString() });
        return localAppConfig;
      }
      label437:
      continue;
      label444:
      i += 1;
      continue;
      label451:
      i += 1;
    }
  }
  
  public static ArkAppInfo.ArkWhiteUrlItem convertWhiteUrlToItem(String paramString)
  {
    ArkAppInfo.ArkWhiteUrlItem localArkWhiteUrlItem = null;
    String str;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      str = removeSpecailChars(paramString);
      localArkWhiteUrlItem = new ArkAppInfo.ArkWhiteUrlItem();
      i = str.indexOf("/");
      if (i != -1) {
        break label58;
      }
      paramString = str;
      localArkWhiteUrlItem.ruleDomain = paramString;
      if (i != -1) {
        break label68;
      }
    }
    label58:
    label68:
    for (paramString = "";; paramString = str.substring(i, str.length()))
    {
      localArkWhiteUrlItem.rulePath = paramString;
      return localArkWhiteUrlItem;
      paramString = str.substring(0, i);
      break;
    }
  }
  
  public static String[] getAppTemplateAndView(ArkAppInfo.AppConfig paramAppConfig, String paramString)
  {
    if ((paramAppConfig != null) && (paramAppConfig.views != null) && (paramAppConfig.views.size() > 0) && (!TextUtils.isEmpty(paramString)))
    {
      int i = 0;
      while (i < paramAppConfig.views.size())
      {
        ArkAppInfo.AppTemplateView localAppTemplateView = (ArkAppInfo.AppTemplateView)paramAppConfig.views.get(i);
        if (paramString.equals(localAppTemplateView.view)) {
          return new String[] { localAppTemplateView.template, localAppTemplateView.templateView };
        }
        i += 1;
      }
    }
    return null;
  }
  
  public static ArkAppConfigMgr getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new ArkAppConfigMgr();
      }
      return sInstance;
    }
    finally {}
  }
  
  /* Error */
  private ArkAppInfo.AppConfig getLocalAppConfig(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: invokestatic 265	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +16 -> 22
    //   9: getstatic 107	com/tencent/ark/open/ArkAppConfigMgr:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   12: ldc 76
    //   14: ldc_w 358
    //   17: invokevirtual 361	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: aconst_null
    //   21: areturn
    //   22: getstatic 114	com/tencent/ark/open/ArkAppConfigMgr:lock	Ljava/lang/Object;
    //   25: astore 6
    //   27: aload 6
    //   29: monitorenter
    //   30: invokestatic 105	com/tencent/ark/ArkEnvironmentManager:getInstance	()Lcom/tencent/ark/ArkEnvironmentManager;
    //   33: pop
    //   34: invokestatic 365	com/tencent/ark/ArkEnvironmentManager:getAppConfigSharedPreferences	()Landroid/content/SharedPreferences;
    //   37: astore 4
    //   39: aload 4
    //   41: ifnull +188 -> 229
    //   44: aload 4
    //   46: aload_1
    //   47: aconst_null
    //   48: invokeinterface 371 3 0
    //   53: astore 4
    //   55: aload 4
    //   57: invokestatic 265	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   60: istore_2
    //   61: iload_2
    //   62: ifne +65 -> 127
    //   65: new 185	org/json/JSONObject
    //   68: dup
    //   69: aload 4
    //   71: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   74: invokestatic 376	com/tencent/ark/open/ArkAppConfigMgr:convertJsonToConfig	(Lorg/json/JSONObject;)Lcom/tencent/ark/open/ArkAppInfo$AppConfig;
    //   77: astore_3
    //   78: aload_0
    //   79: getfield 129	com/tencent/ark/open/ArkAppConfigMgr:mAppConfigCache	Ljava/util/HashMap;
    //   82: aload_1
    //   83: aload_3
    //   84: invokevirtual 379	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   87: pop
    //   88: aload_3
    //   89: getfield 215	com/tencent/ark/open/ArkAppInfo$AppConfig:urlWhitelist	Lcom/tencent/ark/open/ArkAppInfo$AppUrlWhiteList;
    //   92: ifnull +35 -> 127
    //   95: new 381	com/tencent/ark/open/security/ArkAppUrlChecker
    //   98: dup
    //   99: aload_3
    //   100: getfield 215	com/tencent/ark/open/ArkAppInfo$AppConfig:urlWhitelist	Lcom/tencent/ark/open/ArkAppInfo$AppUrlWhiteList;
    //   103: aload_0
    //   104: getfield 131	com/tencent/ark/open/ArkAppConfigMgr:mGlobalWhiteList	Ljava/util/ArrayList;
    //   107: aload_0
    //   108: getfield 133	com/tencent/ark/open/ArkAppConfigMgr:mGlobalBlackList	Ljava/util/ArrayList;
    //   111: invokespecial 384	com/tencent/ark/open/security/ArkAppUrlChecker:<init>	(Lcom/tencent/ark/open/ArkAppInfo$AppUrlWhiteList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V
    //   114: astore 5
    //   116: aload_0
    //   117: getfield 135	com/tencent/ark/open/ArkAppConfigMgr:mAppUrlCheckerCache	Ljava/util/HashMap;
    //   120: aload_1
    //   121: aload 5
    //   123: invokevirtual 379	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   126: pop
    //   127: aload 6
    //   129: monitorexit
    //   130: aload_0
    //   131: aload_1
    //   132: aload_3
    //   133: invokespecial 386	com/tencent/ark/open/ArkAppConfigMgr:checkAppIcon	(Ljava/lang/String;Lcom/tencent/ark/open/ArkAppInfo$AppConfig;)V
    //   136: getstatic 107	com/tencent/ark/open/ArkAppConfigMgr:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   139: ldc 76
    //   141: bipush 6
    //   143: anewarray 4	java/lang/Object
    //   146: dup
    //   147: iconst_0
    //   148: ldc_w 388
    //   151: aastore
    //   152: dup
    //   153: iconst_1
    //   154: aload_1
    //   155: aastore
    //   156: dup
    //   157: iconst_2
    //   158: ldc_w 390
    //   161: aastore
    //   162: dup
    //   163: iconst_3
    //   164: aload 4
    //   166: aastore
    //   167: dup
    //   168: iconst_4
    //   169: ldc_w 392
    //   172: aastore
    //   173: dup
    //   174: iconst_5
    //   175: aload_0
    //   176: invokespecial 157	com/tencent/ark/open/ArkAppConfigMgr:printEnvString	()Ljava/lang/String;
    //   179: aastore
    //   180: invokevirtual 323	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   183: aload_3
    //   184: areturn
    //   185: astore 5
    //   187: aconst_null
    //   188: astore_3
    //   189: getstatic 107	com/tencent/ark/open/ArkAppConfigMgr:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   192: ldc 76
    //   194: iconst_2
    //   195: anewarray 4	java/lang/Object
    //   198: dup
    //   199: iconst_0
    //   200: ldc_w 394
    //   203: aastore
    //   204: dup
    //   205: iconst_1
    //   206: aload 5
    //   208: invokevirtual 269	org/json/JSONException:toString	()Ljava/lang/String;
    //   211: aastore
    //   212: invokevirtual 323	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   215: goto -88 -> 127
    //   218: astore_1
    //   219: aload 6
    //   221: monitorexit
    //   222: aload_1
    //   223: athrow
    //   224: astore 5
    //   226: goto -37 -> 189
    //   229: aconst_null
    //   230: astore 4
    //   232: goto -177 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	this	ArkAppConfigMgr
    //   0	235	1	paramString	String
    //   60	2	2	bool	boolean
    //   1	188	3	localAppConfig	ArkAppInfo.AppConfig
    //   37	194	4	localObject1	Object
    //   114	8	5	localArkAppUrlChecker	ArkAppUrlChecker
    //   185	22	5	localJSONException1	JSONException
    //   224	1	5	localJSONException2	JSONException
    //   25	195	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   65	78	185	org/json/JSONException
    //   30	39	218	finally
    //   44	55	218	finally
    //   55	61	218	finally
    //   65	78	218	finally
    //   78	127	218	finally
    //   127	130	218	finally
    //   189	215	218	finally
    //   219	222	218	finally
    //   78	127	224	org/json/JSONException
  }
  
  public static boolean isTemplateApp(ArkAppInfo.AppConfig paramAppConfig)
  {
    if (paramAppConfig == null) {}
    while ((paramAppConfig.flag & 0x4) != 4) {
      return false;
    }
    return true;
  }
  
  private String printEnvString()
  {
    if (ArkEnvironmentManager.getInstance().isTestEnv()) {
      return "Test";
    }
    return "Product";
  }
  
  public static String removeSpecailChars(String paramString)
  {
    String str = "";
    int i;
    if (paramString != null)
    {
      paramString = paramString.trim();
      if ((TextUtils.isEmpty(paramString)) || (!paramString.contains("://"))) {
        return paramString;
      }
      i = paramString.indexOf("://");
      if (i + 3 > paramString.length()) {
        break label64;
      }
      i += 3;
    }
    for (;;)
    {
      str = paramString.substring(i, paramString.length());
      return str;
      label64:
      i = paramString.length();
    }
    return paramString;
  }
  
  /* Error */
  private void saveAppIconToFile(String paramString, boolean paramBoolean, byte[] arg3, ArkAppConfigMgr.DownloadIconTask paramDownloadIconTask)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifne +102 -> 103
    //   4: getstatic 107	com/tencent/ark/open/ArkAppConfigMgr:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   7: ldc 76
    //   9: ldc_w 414
    //   12: invokevirtual 361	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: aload 4
    //   17: ifnull +1012 -> 1029
    //   20: aload_0
    //   21: getfield 144	com/tencent/ark/open/ArkAppConfigMgr:mDownloadIconTaskList	Ljava/util/Map;
    //   24: astore_3
    //   25: aload_3
    //   26: monitorenter
    //   27: aload_0
    //   28: getfield 144	com/tencent/ark/open/ArkAppConfigMgr:mDownloadIconTaskList	Ljava/util/Map;
    //   31: aload 4
    //   33: getfield 419	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:url	Ljava/lang/String;
    //   36: invokeinterface 425 2 0
    //   41: pop
    //   42: aload_3
    //   43: monitorexit
    //   44: iconst_0
    //   45: istore 5
    //   47: iload 5
    //   49: aload 4
    //   51: getfield 428	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:callbackList	Ljava/util/ArrayList;
    //   54: invokevirtual 227	java/util/ArrayList:size	()I
    //   57: if_icmpge +972 -> 1029
    //   60: aload 4
    //   62: getfield 428	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:callbackList	Ljava/util/ArrayList;
    //   65: iload 5
    //   67: invokevirtual 231	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   70: checkcast 430	com/tencent/ark/open/ArkAppConfigMgr$IDownloadIconCallback
    //   73: astore_3
    //   74: aload_3
    //   75: ifnull +14 -> 89
    //   78: aload_3
    //   79: iconst_2
    //   80: aload_1
    //   81: ldc_w 337
    //   84: invokeinterface 434 4 0
    //   89: iload 5
    //   91: iconst_1
    //   92: iadd
    //   93: istore 5
    //   95: goto -48 -> 47
    //   98: astore_1
    //   99: aload_3
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    //   103: aconst_null
    //   104: astore 9
    //   106: aconst_null
    //   107: astore 7
    //   109: aconst_null
    //   110: astore 8
    //   112: aconst_null
    //   113: astore 11
    //   115: aconst_null
    //   116: astore 10
    //   118: new 436	java/io/File
    //   121: dup
    //   122: ldc_w 438
    //   125: iconst_2
    //   126: anewarray 4	java/lang/Object
    //   129: dup
    //   130: iconst_0
    //   131: invokestatic 105	com/tencent/ark/ArkEnvironmentManager:getInstance	()Lcom/tencent/ark/ArkEnvironmentManager;
    //   134: invokevirtual 441	com/tencent/ark/ArkEnvironmentManager:getAppIconDirectory	()Ljava/lang/String;
    //   137: aastore
    //   138: dup
    //   139: iconst_1
    //   140: aload_1
    //   141: aastore
    //   142: invokestatic 445	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   145: invokespecial 446	java/io/File:<init>	(Ljava/lang/String;)V
    //   148: astore 6
    //   150: aload 6
    //   152: invokevirtual 449	java/io/File:exists	()Z
    //   155: ifne +9 -> 164
    //   158: aload 6
    //   160: invokevirtual 452	java/io/File:mkdirs	()Z
    //   163: pop
    //   164: aload_0
    //   165: aload_1
    //   166: invokevirtual 455	com/tencent/ark/open/ArkAppConfigMgr:getAppIconFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   169: astore 6
    //   171: aload 9
    //   173: astore 8
    //   175: new 457	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 458	java/lang/StringBuilder:<init>	()V
    //   182: aload 6
    //   184: invokevirtual 462	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: ldc 22
    //   189: invokevirtual 462	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 463	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: astore 7
    //   197: aload 7
    //   199: astore 8
    //   201: new 465	java/io/FileOutputStream
    //   204: dup
    //   205: aload 7
    //   207: invokespecial 466	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   210: astore 9
    //   212: aload 9
    //   214: aload_3
    //   215: invokevirtual 470	java/io/FileOutputStream:write	([B)V
    //   218: getstatic 107	com/tencent/ark/open/ArkAppConfigMgr:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   221: ldc 76
    //   223: iconst_4
    //   224: anewarray 4	java/lang/Object
    //   227: dup
    //   228: iconst_0
    //   229: ldc_w 472
    //   232: aastore
    //   233: dup
    //   234: iconst_1
    //   235: aload_1
    //   236: aastore
    //   237: dup
    //   238: iconst_2
    //   239: ldc_w 474
    //   242: aastore
    //   243: dup
    //   244: iconst_3
    //   245: aload 7
    //   247: aastore
    //   248: invokevirtual 323	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   251: aload 9
    //   253: ifnull +29 -> 282
    //   256: aload 9
    //   258: invokevirtual 477	java/io/FileOutputStream:close	()V
    //   261: aload 7
    //   263: aload 6
    //   265: invokestatic 483	com/tencent/ark/open/ArkUtil:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   268: ifne +97 -> 365
    //   271: getstatic 107	com/tencent/ark/open/ArkAppConfigMgr:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   274: ldc 76
    //   276: ldc_w 485
    //   279: invokevirtual 361	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   282: aload 4
    //   284: ifnull +745 -> 1029
    //   287: aload_0
    //   288: getfield 144	com/tencent/ark/open/ArkAppConfigMgr:mDownloadIconTaskList	Ljava/util/Map;
    //   291: astore_3
    //   292: aload_3
    //   293: monitorenter
    //   294: aload_0
    //   295: getfield 144	com/tencent/ark/open/ArkAppConfigMgr:mDownloadIconTaskList	Ljava/util/Map;
    //   298: aload 4
    //   300: getfield 419	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:url	Ljava/lang/String;
    //   303: invokeinterface 425 2 0
    //   308: pop
    //   309: aload_3
    //   310: monitorexit
    //   311: iconst_0
    //   312: istore 5
    //   314: iload 5
    //   316: aload 4
    //   318: getfield 428	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:callbackList	Ljava/util/ArrayList;
    //   321: invokevirtual 227	java/util/ArrayList:size	()I
    //   324: if_icmpge +705 -> 1029
    //   327: aload 4
    //   329: getfield 428	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:callbackList	Ljava/util/ArrayList;
    //   332: iload 5
    //   334: invokevirtual 231	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   337: checkcast 430	com/tencent/ark/open/ArkAppConfigMgr$IDownloadIconCallback
    //   340: astore_3
    //   341: aload_3
    //   342: ifnull +14 -> 356
    //   345: aload_3
    //   346: iconst_2
    //   347: aload_1
    //   348: ldc_w 337
    //   351: invokeinterface 434 4 0
    //   356: iload 5
    //   358: iconst_1
    //   359: iadd
    //   360: istore 5
    //   362: goto -48 -> 314
    //   365: aload 4
    //   367: ifnull +662 -> 1029
    //   370: aload_0
    //   371: getfield 144	com/tencent/ark/open/ArkAppConfigMgr:mDownloadIconTaskList	Ljava/util/Map;
    //   374: astore_3
    //   375: aload_3
    //   376: monitorenter
    //   377: aload_0
    //   378: getfield 144	com/tencent/ark/open/ArkAppConfigMgr:mDownloadIconTaskList	Ljava/util/Map;
    //   381: aload 4
    //   383: getfield 419	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:url	Ljava/lang/String;
    //   386: invokeinterface 425 2 0
    //   391: pop
    //   392: aload_3
    //   393: monitorexit
    //   394: iconst_0
    //   395: istore 5
    //   397: iload 5
    //   399: aload 4
    //   401: getfield 428	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:callbackList	Ljava/util/ArrayList;
    //   404: invokevirtual 227	java/util/ArrayList:size	()I
    //   407: if_icmpge +622 -> 1029
    //   410: aload 4
    //   412: getfield 428	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:callbackList	Ljava/util/ArrayList;
    //   415: iload 5
    //   417: invokevirtual 231	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   420: checkcast 430	com/tencent/ark/open/ArkAppConfigMgr$IDownloadIconCallback
    //   423: astore_3
    //   424: aload_3
    //   425: ifnull +13 -> 438
    //   428: aload_3
    //   429: iconst_1
    //   430: aload_1
    //   431: aload 6
    //   433: invokeinterface 434 4 0
    //   438: iload 5
    //   440: iconst_1
    //   441: iadd
    //   442: istore 5
    //   444: goto -47 -> 397
    //   447: astore 6
    //   449: aload_3
    //   450: monitorexit
    //   451: aload 6
    //   453: athrow
    //   454: astore_3
    //   455: getstatic 107	com/tencent/ark/open/ArkAppConfigMgr:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   458: ldc 76
    //   460: iconst_2
    //   461: anewarray 4	java/lang/Object
    //   464: dup
    //   465: iconst_0
    //   466: ldc_w 487
    //   469: aastore
    //   470: dup
    //   471: iconst_1
    //   472: aload_3
    //   473: invokevirtual 320	java/lang/Exception:toString	()Ljava/lang/String;
    //   476: aastore
    //   477: invokevirtual 323	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   480: goto -198 -> 282
    //   483: astore_1
    //   484: aload_3
    //   485: monitorexit
    //   486: aload_1
    //   487: athrow
    //   488: astore 7
    //   490: aconst_null
    //   491: astore 6
    //   493: aload 8
    //   495: astore_3
    //   496: aload 10
    //   498: astore 8
    //   500: getstatic 107	com/tencent/ark/open/ArkAppConfigMgr:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   503: ldc 76
    //   505: iconst_2
    //   506: anewarray 4	java/lang/Object
    //   509: dup
    //   510: iconst_0
    //   511: ldc_w 487
    //   514: aastore
    //   515: dup
    //   516: iconst_1
    //   517: aload 7
    //   519: invokevirtual 320	java/lang/Exception:toString	()Ljava/lang/String;
    //   522: aastore
    //   523: invokevirtual 323	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   526: aload 8
    //   528: ifnull +28 -> 556
    //   531: aload 8
    //   533: invokevirtual 477	java/io/FileOutputStream:close	()V
    //   536: aload 6
    //   538: aload_3
    //   539: invokestatic 483	com/tencent/ark/open/ArkUtil:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   542: ifne +97 -> 639
    //   545: getstatic 107	com/tencent/ark/open/ArkAppConfigMgr:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   548: ldc 76
    //   550: ldc_w 485
    //   553: invokevirtual 361	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   556: aload 4
    //   558: ifnull +471 -> 1029
    //   561: aload_0
    //   562: getfield 144	com/tencent/ark/open/ArkAppConfigMgr:mDownloadIconTaskList	Ljava/util/Map;
    //   565: astore_3
    //   566: aload_3
    //   567: monitorenter
    //   568: aload_0
    //   569: getfield 144	com/tencent/ark/open/ArkAppConfigMgr:mDownloadIconTaskList	Ljava/util/Map;
    //   572: aload 4
    //   574: getfield 419	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:url	Ljava/lang/String;
    //   577: invokeinterface 425 2 0
    //   582: pop
    //   583: aload_3
    //   584: monitorexit
    //   585: iconst_0
    //   586: istore 5
    //   588: iload 5
    //   590: aload 4
    //   592: getfield 428	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:callbackList	Ljava/util/ArrayList;
    //   595: invokevirtual 227	java/util/ArrayList:size	()I
    //   598: if_icmpge +431 -> 1029
    //   601: aload 4
    //   603: getfield 428	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:callbackList	Ljava/util/ArrayList;
    //   606: iload 5
    //   608: invokevirtual 231	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   611: checkcast 430	com/tencent/ark/open/ArkAppConfigMgr$IDownloadIconCallback
    //   614: astore_3
    //   615: aload_3
    //   616: ifnull +14 -> 630
    //   619: aload_3
    //   620: iconst_2
    //   621: aload_1
    //   622: ldc_w 337
    //   625: invokeinterface 434 4 0
    //   630: iload 5
    //   632: iconst_1
    //   633: iadd
    //   634: istore 5
    //   636: goto -48 -> 588
    //   639: aload 4
    //   641: ifnull +388 -> 1029
    //   644: aload_0
    //   645: getfield 144	com/tencent/ark/open/ArkAppConfigMgr:mDownloadIconTaskList	Ljava/util/Map;
    //   648: astore 6
    //   650: aload 6
    //   652: monitorenter
    //   653: aload_0
    //   654: getfield 144	com/tencent/ark/open/ArkAppConfigMgr:mDownloadIconTaskList	Ljava/util/Map;
    //   657: aload 4
    //   659: getfield 419	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:url	Ljava/lang/String;
    //   662: invokeinterface 425 2 0
    //   667: pop
    //   668: aload 6
    //   670: monitorexit
    //   671: iconst_0
    //   672: istore 5
    //   674: iload 5
    //   676: aload 4
    //   678: getfield 428	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:callbackList	Ljava/util/ArrayList;
    //   681: invokevirtual 227	java/util/ArrayList:size	()I
    //   684: if_icmpge +345 -> 1029
    //   687: aload 4
    //   689: getfield 428	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:callbackList	Ljava/util/ArrayList;
    //   692: iload 5
    //   694: invokevirtual 231	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   697: checkcast 430	com/tencent/ark/open/ArkAppConfigMgr$IDownloadIconCallback
    //   700: astore 6
    //   702: aload 6
    //   704: ifnull +13 -> 717
    //   707: aload 6
    //   709: iconst_1
    //   710: aload_1
    //   711: aload_3
    //   712: invokeinterface 434 4 0
    //   717: iload 5
    //   719: iconst_1
    //   720: iadd
    //   721: istore 5
    //   723: goto -49 -> 674
    //   726: astore_3
    //   727: aload 6
    //   729: monitorexit
    //   730: aload_3
    //   731: athrow
    //   732: astore_3
    //   733: getstatic 107	com/tencent/ark/open/ArkAppConfigMgr:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   736: ldc 76
    //   738: iconst_2
    //   739: anewarray 4	java/lang/Object
    //   742: dup
    //   743: iconst_0
    //   744: ldc_w 487
    //   747: aastore
    //   748: dup
    //   749: iconst_1
    //   750: aload_3
    //   751: invokevirtual 320	java/lang/Exception:toString	()Ljava/lang/String;
    //   754: aastore
    //   755: invokevirtual 323	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   758: goto -202 -> 556
    //   761: astore_1
    //   762: aload_3
    //   763: monitorexit
    //   764: aload_1
    //   765: athrow
    //   766: astore_3
    //   767: aconst_null
    //   768: astore 6
    //   770: aload 11
    //   772: astore 9
    //   774: aload 9
    //   776: ifnull +29 -> 805
    //   779: aload 9
    //   781: invokevirtual 477	java/io/FileOutputStream:close	()V
    //   784: aload 7
    //   786: aload 6
    //   788: invokestatic 483	com/tencent/ark/open/ArkUtil:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   791: ifne +103 -> 894
    //   794: getstatic 107	com/tencent/ark/open/ArkAppConfigMgr:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   797: ldc 76
    //   799: ldc_w 485
    //   802: invokevirtual 361	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   805: aload 4
    //   807: ifnull +220 -> 1027
    //   810: aload_0
    //   811: getfield 144	com/tencent/ark/open/ArkAppConfigMgr:mDownloadIconTaskList	Ljava/util/Map;
    //   814: astore 6
    //   816: aload 6
    //   818: monitorenter
    //   819: aload_0
    //   820: getfield 144	com/tencent/ark/open/ArkAppConfigMgr:mDownloadIconTaskList	Ljava/util/Map;
    //   823: aload 4
    //   825: getfield 419	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:url	Ljava/lang/String;
    //   828: invokeinterface 425 2 0
    //   833: pop
    //   834: aload 6
    //   836: monitorexit
    //   837: iconst_0
    //   838: istore 5
    //   840: iload 5
    //   842: aload 4
    //   844: getfield 428	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:callbackList	Ljava/util/ArrayList;
    //   847: invokevirtual 227	java/util/ArrayList:size	()I
    //   850: if_icmpge +177 -> 1027
    //   853: aload 4
    //   855: getfield 428	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:callbackList	Ljava/util/ArrayList;
    //   858: iload 5
    //   860: invokevirtual 231	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   863: checkcast 430	com/tencent/ark/open/ArkAppConfigMgr$IDownloadIconCallback
    //   866: astore 6
    //   868: aload 6
    //   870: ifnull +15 -> 885
    //   873: aload 6
    //   875: iconst_2
    //   876: aload_1
    //   877: ldc_w 337
    //   880: invokeinterface 434 4 0
    //   885: iload 5
    //   887: iconst_1
    //   888: iadd
    //   889: istore 5
    //   891: goto -51 -> 840
    //   894: aload 4
    //   896: ifnull +133 -> 1029
    //   899: aload_0
    //   900: getfield 144	com/tencent/ark/open/ArkAppConfigMgr:mDownloadIconTaskList	Ljava/util/Map;
    //   903: astore 7
    //   905: aload 7
    //   907: monitorenter
    //   908: aload_0
    //   909: getfield 144	com/tencent/ark/open/ArkAppConfigMgr:mDownloadIconTaskList	Ljava/util/Map;
    //   912: aload 4
    //   914: getfield 419	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:url	Ljava/lang/String;
    //   917: invokeinterface 425 2 0
    //   922: pop
    //   923: aload 7
    //   925: monitorexit
    //   926: iconst_0
    //   927: istore 5
    //   929: iload 5
    //   931: aload 4
    //   933: getfield 428	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:callbackList	Ljava/util/ArrayList;
    //   936: invokevirtual 227	java/util/ArrayList:size	()I
    //   939: if_icmpge +90 -> 1029
    //   942: aload 4
    //   944: getfield 428	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:callbackList	Ljava/util/ArrayList;
    //   947: iload 5
    //   949: invokevirtual 231	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   952: checkcast 430	com/tencent/ark/open/ArkAppConfigMgr$IDownloadIconCallback
    //   955: astore 7
    //   957: aload 7
    //   959: ifnull +14 -> 973
    //   962: aload 7
    //   964: iconst_1
    //   965: aload_1
    //   966: aload 6
    //   968: invokeinterface 434 4 0
    //   973: iload 5
    //   975: iconst_1
    //   976: iadd
    //   977: istore 5
    //   979: goto -50 -> 929
    //   982: astore 6
    //   984: aload 7
    //   986: monitorexit
    //   987: aload 6
    //   989: athrow
    //   990: astore 6
    //   992: getstatic 107	com/tencent/ark/open/ArkAppConfigMgr:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   995: ldc 76
    //   997: iconst_2
    //   998: anewarray 4	java/lang/Object
    //   1001: dup
    //   1002: iconst_0
    //   1003: ldc_w 487
    //   1006: aastore
    //   1007: dup
    //   1008: iconst_1
    //   1009: aload 6
    //   1011: invokevirtual 320	java/lang/Exception:toString	()Ljava/lang/String;
    //   1014: aastore
    //   1015: invokevirtual 323	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1018: goto -213 -> 805
    //   1021: astore_1
    //   1022: aload 6
    //   1024: monitorexit
    //   1025: aload_1
    //   1026: athrow
    //   1027: aload_3
    //   1028: athrow
    //   1029: return
    //   1030: astore_3
    //   1031: aload 11
    //   1033: astore 9
    //   1035: aload 8
    //   1037: astore 7
    //   1039: goto -265 -> 774
    //   1042: astore_3
    //   1043: goto -269 -> 774
    //   1046: astore 9
    //   1048: aload 6
    //   1050: astore 7
    //   1052: aload_3
    //   1053: astore 6
    //   1055: aload 9
    //   1057: astore_3
    //   1058: aload 8
    //   1060: astore 9
    //   1062: goto -288 -> 774
    //   1065: astore 7
    //   1067: aload 6
    //   1069: astore_3
    //   1070: aconst_null
    //   1071: astore 6
    //   1073: aload 10
    //   1075: astore 8
    //   1077: goto -577 -> 500
    //   1080: astore 8
    //   1082: aload 6
    //   1084: astore_3
    //   1085: aload 7
    //   1087: astore 6
    //   1089: aload 8
    //   1091: astore 7
    //   1093: aload 10
    //   1095: astore 8
    //   1097: goto -597 -> 500
    //   1100: astore 10
    //   1102: aload 9
    //   1104: astore 8
    //   1106: aload 6
    //   1108: astore_3
    //   1109: aload 7
    //   1111: astore 6
    //   1113: aload 10
    //   1115: astore 7
    //   1117: goto -617 -> 500
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1120	0	this	ArkAppConfigMgr
    //   0	1120	1	paramString	String
    //   0	1120	2	paramBoolean	boolean
    //   0	1120	4	paramDownloadIconTask	ArkAppConfigMgr.DownloadIconTask
    //   45	933	5	i	int
    //   148	284	6	localObject1	Object
    //   447	5	6	localObject2	Object
    //   982	6	6	localObject4	Object
    //   990	59	6	localException1	Exception
    //   1053	59	6	localObject5	Object
    //   107	155	7	str	String
    //   488	297	7	localException2	Exception
    //   1065	21	7	localException3	Exception
    //   1091	25	7	localObject7	Object
    //   110	966	8	localObject8	Object
    //   1080	10	8	localException4	Exception
    //   1095	10	8	localObject9	Object
    //   104	930	9	localObject10	Object
    //   1046	10	9	localObject11	Object
    //   1060	43	9	localObject12	Object
    //   116	978	10	localObject13	Object
    //   1100	14	10	localException5	Exception
    //   113	919	11	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   27	44	98	finally
    //   99	101	98	finally
    //   377	394	447	finally
    //   449	451	447	finally
    //   256	282	454	java/lang/Exception
    //   370	377	454	java/lang/Exception
    //   397	424	454	java/lang/Exception
    //   428	438	454	java/lang/Exception
    //   451	454	454	java/lang/Exception
    //   294	311	483	finally
    //   484	486	483	finally
    //   118	164	488	java/lang/Exception
    //   164	171	488	java/lang/Exception
    //   653	671	726	finally
    //   727	730	726	finally
    //   531	556	732	java/lang/Exception
    //   644	653	732	java/lang/Exception
    //   674	702	732	java/lang/Exception
    //   707	717	732	java/lang/Exception
    //   730	732	732	java/lang/Exception
    //   568	585	761	finally
    //   762	764	761	finally
    //   118	164	766	finally
    //   164	171	766	finally
    //   908	926	982	finally
    //   984	987	982	finally
    //   779	805	990	java/lang/Exception
    //   899	908	990	java/lang/Exception
    //   929	957	990	java/lang/Exception
    //   962	973	990	java/lang/Exception
    //   987	990	990	java/lang/Exception
    //   819	837	1021	finally
    //   1022	1025	1021	finally
    //   175	197	1030	finally
    //   201	212	1030	finally
    //   212	251	1042	finally
    //   500	526	1046	finally
    //   175	197	1065	java/lang/Exception
    //   201	212	1080	java/lang/Exception
    //   212	251	1100	java/lang/Exception
  }
  
  public boolean canForward(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      ENV.logI("ArkApp.ArkAppConfigMgr", "ArkSafe.canForward appname is empty return false");
      return false;
    }
    ArkAppInfo.AppConfig localAppConfig = getAppConfig(paramString1);
    if (localAppConfig == null)
    {
      ENV.logI("ArkApp.ArkAppConfigMgr", new Object[] { "ArkSafe.canForward app:", paramString1, ",config is null return true" });
      return true;
    }
    if ((localAppConfig.forwardViews == null) || (localAppConfig.forwardViews.size() == 0))
    {
      ENV.logI("ArkApp.ArkAppConfigMgr", new Object[] { "ArkSafe.canForward app:", paramString1, ",config.forward view is null return true" });
      return true;
    }
    int i = 0;
    String str;
    boolean bool1;
    boolean bool2;
    if (i < localAppConfig.forwardViews.size())
    {
      str = (String)localAppConfig.forwardViews.get(i);
      if ("*".equals(str))
      {
        bool1 = false;
        bool2 = true;
      }
    }
    for (;;)
    {
      label155:
      boolean bool3;
      if (bool2) {
        bool3 = true;
      }
      for (;;)
      {
        ENV.logI("ArkApp.ArkAppConfigMgr", new Object[] { "ArkSafe.canForward app:", paramString1, ",view:", paramString2, ",canForward=", Boolean.valueOf(bool3), ",allowAll:", Boolean.valueOf(bool2), ",findView:", Boolean.valueOf(bool1) });
        return bool3;
        if ((!TextUtils.isEmpty(str)) && (str.equals(paramString2)))
        {
          bool1 = true;
          bool2 = false;
          break label155;
        }
        i += 1;
        break;
        if (bool1) {
          bool3 = true;
        } else {
          bool3 = false;
        }
      }
      bool1 = false;
      bool2 = false;
    }
  }
  
  public void cleanAllConfig()
  {
    ArkDispatchTask.getInstance().postToArkThread(new ArkAppConfigMgr.2(this));
  }
  
  public void downloadAppIcon(String paramString1, String paramString2, ArkAppConfigMgr.IDownloadIconCallback arg3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      ENV.logI("ArkApp.ArkAppConfigMgr", "ArkSafe.downloadAppIcon, app is null");
      return;
    }
    synchronized (this.mDownloadIconTaskList)
    {
      ArkAppConfigMgr.DownloadIconTask localDownloadIconTask = (ArkAppConfigMgr.DownloadIconTask)this.mDownloadIconTaskList.get(paramString2);
      if (localDownloadIconTask != null)
      {
        localDownloadIconTask.callbackList.add(???);
        ENV.logI("ArkApp.ArkAppConfigMgr", new Object[] { "ArkSafe.downloadAppIcon all ready in request app=", paramString1 });
        return;
      }
    }
    ??? = new ArkAppConfigMgr.DownloadIconTask(null);
    ((ArkAppConfigMgr.DownloadIconTask)???).url = paramString2;
    ((ArkAppConfigMgr.DownloadIconTask)???).callbackList.add(???);
    synchronized (this.mDownloadIconTaskList)
    {
      this.mDownloadIconTaskList.put(paramString2, ???);
      ArkAppCGIMgr.getInstance().downloadAppIcon(paramString2, ???, new ArkAppConfigMgr.3(this, paramString1));
      return;
    }
  }
  
  public ArkAppInfo.AppConfig getAppConfig(String paramString)
  {
    ArkAppInfo.AppConfig localAppConfig = null;
    if (!sEnableAppConfig)
    {
      ENV.logI("ArkApp.ArkAppConfigMgr", "ArkSafe.getAppConfig ServerConfig disable");
      return null;
    }
    synchronized (lock)
    {
      if (this.mAppConfigCache.containsKey(paramString)) {
        localAppConfig = (ArkAppInfo.AppConfig)this.mAppConfigCache.get(paramString);
      }
      if (localAppConfig == null) {
        return getLocalAppConfig(paramString);
      }
    }
    ENV.logI("ArkApp.ArkAppConfigMgr", new Object[] { "ArkTemp.ArkSafe.getAppConfig app=", paramString, ", cached config=", convertConfigToJsonString(localAppConfig), ", env=", printEnvString() });
    return localAppConfig;
  }
  
  public long getAppConfigVersion(String paramString)
  {
    long l = 0L;
    if (!sEnableAppConfig)
    {
      ENV.logI("ArkApp.ArkAppConfigMgr", "ArkSafe.getAppConfigVersion ServerConfig disable");
      return 0L;
    }
    ArkAppInfo.AppConfig localAppConfig = getAppConfig(paramString);
    if (localAppConfig != null) {
      l = localAppConfig.ver;
    }
    ENV.logI("ArkApp.ArkAppConfigMgr", new Object[] { "ArkSafe.getAppConfigVersion app=", paramString, ", cfgver=", Long.valueOf(l), ", env=", printEnvString() });
    return l;
  }
  
  public String getAppIconFilePath(String paramString)
  {
    ArkAppInfo.AppConfig localAppConfig = getAppConfig(paramString);
    if (localAppConfig == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(ArkEnvironmentManager.getInstance().getAppIconDirectory());
    localStringBuilder.append("/").append(paramString).append("/").append(localAppConfig.ver);
    return localStringBuilder.toString();
  }
  
  public ArrayList<String> getTemplateAppNameList()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (lock)
    {
      if ((this.mAppConfigCache != null) && (this.mAppConfigCache.size() > 0))
      {
        localObject2 = this.mAppConfigCache.entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          if ((localObject3 != null) && (((Map.Entry)localObject3).getKey() != null) && (((Map.Entry)localObject3).getValue() != null) && (isTemplateApp((ArkAppInfo.AppConfig)((Map.Entry)localObject3).getValue()))) {
            localArrayList.add(((Map.Entry)localObject3).getKey());
          }
        }
      }
    }
    Object localObject2 = ENV;
    Object localObject3 = printEnvString();
    if (localArrayList1 != null) {}
    for (??? = localArrayList1.toString();; ??? = "")
    {
      ((ArkEnvironmentManager)localObject2).logI("ArkApp.ArkAppConfigMgr", new Object[] { "ArkSafe.getTemplateAppList, env=", localObject3, ",template app=", ??? });
      return localArrayList1;
    }
  }
  
  public ArkAppUrlChecker getUrlChecker(String paramString)
  {
    ArkAppUrlChecker localArkAppUrlChecker1 = null;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    synchronized (lock)
    {
      if (this.mAppUrlCheckerCache.containsKey(paramString)) {
        localArkAppUrlChecker1 = (ArkAppUrlChecker)this.mAppUrlCheckerCache.get(paramString);
      }
      ArkAppUrlChecker localArkAppUrlChecker2 = localArkAppUrlChecker1;
      if (localArkAppUrlChecker1 == null)
      {
        ArkAppInfo.AppConfig localAppConfig = getAppConfig(paramString);
        localArkAppUrlChecker2 = localArkAppUrlChecker1;
        if (localAppConfig != null)
        {
          localArkAppUrlChecker2 = localArkAppUrlChecker1;
          if (localAppConfig.urlWhitelist != null)
          {
            localArkAppUrlChecker2 = new ArkAppUrlChecker(localAppConfig.urlWhitelist, this.mGlobalWhiteList, this.mGlobalBlackList);
            this.mAppUrlCheckerCache.put(paramString, localArkAppUrlChecker2);
          }
        }
      }
      return localArkAppUrlChecker2;
    }
  }
  
  public void initConfig()
  {
    ENV.logI("ArkApp.ArkAppConfigMgr", new Object[] { "ArkSafe.initConfig, env=", printEnvString() });
    ArkDispatchTask.getInstance().postToArkThread(new ArkAppConfigMgr.1(this));
  }
  
  public void initGlobalWhiteListAndUrlCheckStatus(boolean paramBoolean, ArrayList<String> paramArrayList, ConcurrentHashMap<String, ArrayList<String>> arg3)
  {
    Object localObject2 = ENV;
    if (paramArrayList != null) {}
    for (??? = paramArrayList.toString();; ??? = "null")
    {
      ((ArkEnvironmentManager)localObject2).logI("ArkApp.ArkAppConfigMgr", new Object[] { "ArkSafe.initGlobalWhiteListAndUrlCheckStatus.isUrlCheckEnable = ", Boolean.valueOf(paramBoolean), ",urlDisableAppList= ", ??? });
      setUrlCheckEnable(paramBoolean, paramArrayList);
      if (??? == null) {
        break label343;
      }
      ??? = (ArrayList)???.get("white");
      if (??? == null) {
        break label202;
      }
      paramArrayList = new ArrayList();
      ??? = ((ArrayList)???).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (String)((Iterator)???).next();
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = convertWhiteUrlToItem((String)localObject2);
          if (localObject2 != null) {
            paramArrayList.add(localObject2);
          }
        }
      }
    }
    if (paramArrayList.size() > 0) {}
    synchronized (lock)
    {
      this.mGlobalWhiteList = paramArrayList;
      ENV.logI("ArkApp.ArkAppConfigMgr", String.format("ArkSafe.initGlobalWhiteList white list:%s", new Object[] { this.mGlobalWhiteList.toString() }));
      label202:
      ??? = (ArrayList)???.get("black");
      if (??? == null) {
        break label333;
      }
      paramArrayList = new ArrayList();
      ??? = ???.iterator();
      while (???.hasNext())
      {
        ??? = (String)???.next();
        if (!TextUtils.isEmpty((CharSequence)???))
        {
          ??? = convertWhiteUrlToItem((String)???);
          if (??? != null) {
            paramArrayList.add(???);
          }
        }
      }
    }
    if (paramArrayList.size() > 0) {}
    for (;;)
    {
      synchronized (lock)
      {
        this.mGlobalBlackList = paramArrayList;
        ENV.logI("ArkApp.ArkAppConfigMgr", String.format("ArkSafe.initGlobalWhiteList black list:%s", new Object[] { this.mGlobalBlackList.toString() }));
        label333:
        initConfig();
        return;
      }
      label343:
      ENV.logD("ArkApp.ArkAppConfigMgr", String.format("ArkSafe.app global white and black is null", new Object[0]));
    }
  }
  
  public boolean isUrlCheckEnable(String paramString)
  {
    boolean bool = true;
    for (;;)
    {
      synchronized (this.mUrlDisableAppList)
      {
        if ((!TextUtils.isEmpty(paramString)) && (this.mUrlDisableAppList.size() > 0) && (this.mUrlDisableAppList.contains(paramString)))
        {
          ENV.logI("ArkApp.ArkAppConfigMgr", new Object[] { "ArkSafe.app.checkUrl.enable=false,app=", paramString });
          i = 0;
          if ((!this.mUrlCheckEnable) || (i == 0)) {
            break label90;
          }
          return bool;
        }
      }
      int i = 1;
      continue;
      label90:
      bool = false;
    }
  }
  
  public void saveAppConfig(String paramString, ArkAppInfo.AppConfig paramAppConfig)
  {
    if (!sEnableAppConfig) {
      ENV.logI("ArkApp.ArkAppConfigMgr", "ArkSafe.saveAppConfig ServerConfig disable");
    }
    while ((TextUtils.isEmpty(paramString)) || (paramAppConfig == null)) {
      return;
    }
    synchronized (lock)
    {
      this.mAppConfigCache.put(paramString, paramAppConfig);
      if (paramAppConfig.urlWhitelist != null)
      {
        Object localObject2 = new ArkAppUrlChecker(paramAppConfig.urlWhitelist, this.mGlobalWhiteList, this.mGlobalBlackList);
        this.mAppUrlCheckerCache.put(paramString, localObject2);
        paramAppConfig = convertConfigToJsonString(paramAppConfig);
        localObject2 = ArkEnvironmentManager.getAppConfigSharedPreferences();
        if (localObject2 != null) {
          ((SharedPreferences)localObject2).edit().putString(paramString, paramAppConfig).commit();
        }
        ENV.logI("ArkApp.ArkAppConfigMgr", new Object[] { "ArkTemp.ArkSafe.saveAppConfig, app=", paramString, ", cfg=", paramAppConfig, ", env=", printEnvString() });
        return;
      }
      this.mAppUrlCheckerCache.remove(paramString);
    }
  }
  
  public void setUrlCheckEnable(boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    this.mUrlCheckEnable = paramBoolean;
    this.mUrlDisableAppList = paramArrayList;
    ENV.logI("ArkApp.ArkAppConfigMgr", new Object[] { "ArkSafe.setUrlCheckEnable global=", Boolean.valueOf(this.mUrlCheckEnable) });
  }
  
  public void updateUrlCheckAndCleanAppUpdateTime(boolean paramBoolean, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    ArkEnvironmentManager localArkEnvironmentManager = ENV;
    String str;
    int i;
    if (paramArrayList1 != null)
    {
      str = paramArrayList1.toString();
      localArkEnvironmentManager.logI("ArkApp.ArkAppConfigMgr", new Object[] { "ArkSafe.updateUrlCheckAndCleanAppUpdateTimeisUrlCheckEnable = ", Boolean.valueOf(paramBoolean), ",urlDisableAppList= ", str });
      setUrlCheckEnable(paramBoolean, paramArrayList1);
      if ((paramArrayList2 == null) || (paramArrayList2.size() <= 0)) {
        break label193;
      }
      paramArrayList1 = paramArrayList2.iterator();
      i = 0;
      label75:
      if (!paramArrayList1.hasNext()) {
        break label171;
      }
      paramArrayList2 = (String)paramArrayList1.next();
      if (TextUtils.isEmpty(paramArrayList2)) {
        break label194;
      }
      ENV.logI("ArkApp.ArkAppConfigMgr", new Object[] { "ArkSafe.updateUrlCheckAndCleanAppUpdateTime get config clean app=", paramArrayList2 });
      if (!ArkAppMgr.isAppUpdateBefore(paramArrayList2)) {
        break label194;
      }
      ENV.logI("ArkApp.ArkAppConfigMgr", new Object[] { "ArkSafe.updateUrlCheckAndCleanAppUpdateTime force clean update time app =", paramArrayList2 });
      ArkAppMgr.putAppUpdateTime(paramArrayList2, 0L);
      i = 1;
    }
    label171:
    label193:
    label194:
    for (;;)
    {
      break label75;
      str = "null";
      break;
      if (i != 0)
      {
        ENV.logI("ArkApp.ArkAppConfigMgr", "ArkSafe.updateUrlCheckAndCleanAppUpdateTime force clean global");
        ArkAppMgr.getInstance().clearGlobalUpdateTime();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppConfigMgr
 * JD-Core Version:    0.7.0.1
 */