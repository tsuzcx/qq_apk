package com.tencent.ark.open;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.Logger;
import com.tencent.ark.open.appmanage.AppUpdateManager;
import com.tencent.ark.open.internal.ArkAppCGIMgr;
import com.tencent.ark.open.security.ArkAppUrlChecker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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
  private static final String JSON_KEY_TYPE = "type";
  private static final String JSON_KEY_URLWHITELIST = "urlWhitelist";
  private static final String JSON_KEY_VER = "ver";
  private static final String TAG = "ArkApp.ArkAppConfigMgr";
  public static final Object lock = new Object();
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
    for (;;)
    {
      int i;
      try
      {
        localJSONObject.put("ver", paramAppConfig.ver);
        localJSONObject.put("name", paramAppConfig.name);
        localJSONObject.put("icon", paramAppConfig.iconUrl);
        localJSONObject.put("entry", paramAppConfig.entry);
        localJSONObject.put("flag", paramAppConfig.flag);
        localJSONObject.put("type", paramAppConfig.type);
        Object localObject1;
        Object localObject2;
        if (paramAppConfig.urlWhitelist != null)
        {
          localObject1 = new JSONObject();
          localObject2 = paramAppConfig.urlWhitelist.resourceList;
          JSONArray localJSONArray;
          ArkAppInfo.ArkWhiteUrlItem localArkWhiteUrlItem;
          if (localObject2 != null)
          {
            localJSONArray = new JSONArray();
            i = 0;
            if (i < ((ArrayList)localObject2).size())
            {
              localArkWhiteUrlItem = (ArkAppInfo.ArkWhiteUrlItem)((ArrayList)localObject2).get(i);
              if (localArkWhiteUrlItem == null) {
                break label356;
              }
              localJSONArray.put(localArkWhiteUrlItem.toString());
              break label356;
            }
            ((JSONObject)localObject1).put("res", localJSONArray);
          }
          localObject2 = paramAppConfig.urlWhitelist.navigationList;
          if (localObject2 != null)
          {
            localJSONArray = new JSONArray();
            i = 0;
            if (i < ((ArrayList)localObject2).size())
            {
              localArkWhiteUrlItem = (ArkAppInfo.ArkWhiteUrlItem)((ArrayList)localObject2).get(i);
              if (localArkWhiteUrlItem == null) {
                break label363;
              }
              localJSONArray.put(localArkWhiteUrlItem.toString());
              break label363;
            }
            ((JSONObject)localObject1).put("nav", localJSONArray);
          }
          localJSONObject.put("urlWhitelist", localObject1);
        }
        if ((paramAppConfig.forwardViews != null) && (paramAppConfig.forwardViews.size() > 0))
        {
          localObject1 = new JSONArray();
          i = 0;
          if (i < paramAppConfig.forwardViews.size())
          {
            localObject2 = (String)paramAppConfig.forwardViews.get(i);
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              break label370;
            }
            ((JSONArray)localObject1).put(localObject2);
            break label370;
          }
          localJSONObject.put("fwdViews", localObject1);
        }
      }
      catch (JSONException paramAppConfig)
      {
        Logger.logE("ArkApp.ArkAppConfigMgr", new Object[] { "ArkSafe.convert json exeption:", paramAppConfig.toString() });
      }
      return localJSONObject.toString();
      label356:
      i += 1;
      continue;
      label363:
      i += 1;
      continue;
      label370:
      i += 1;
    }
  }
  
  public static ArkAppInfo.AppConfig convertJsonToConfig(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
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
        if (localObject1 != null)
        {
          localAppConfig.urlWhitelist = new ArkAppInfo.AppUrlWhiteList();
          Object localObject2 = ((JSONObject)localObject1).optJSONArray("res");
          if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
          {
            i = 0;
            if (i < ((JSONArray)localObject2).length())
            {
              ArkAppInfo.ArkWhiteUrlItem localArkWhiteUrlItem = convertWhiteUrlToItem(((JSONArray)localObject2).optString(i));
              if (localArkWhiteUrlItem == null) {
                break label313;
              }
              localAppConfig.urlWhitelist.resourceList.add(localArkWhiteUrlItem);
              break label313;
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
                break label320;
              }
              localAppConfig.urlWhitelist.navigationList.add(localObject2);
              break label320;
            }
          }
        }
        paramJSONObject = paramJSONObject.optJSONArray("fwdViews");
        if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
        {
          localAppConfig.forwardViews = new ArrayList(paramJSONObject.length());
          i = 0;
          if (i < paramJSONObject.length())
          {
            localObject1 = paramJSONObject.optString(i);
            if (localObject1 != null) {
              localAppConfig.forwardViews.add(localObject1);
            }
            i += 1;
            continue;
          }
        }
        return localAppConfig;
      }
      catch (Exception paramJSONObject)
      {
        Logger.logI("ArkApp.ArkAppConfigMgr", new Object[] { "ArkSafe.convert json exception:", paramJSONObject.toString() });
      }
      label313:
      i += 1;
      continue;
      label320:
      i += 1;
    }
  }
  
  public static ArkAppInfo.ArkWhiteUrlItem convertWhiteUrlToItem(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      String str = removeSpecialChars(paramString);
      ArkAppInfo.ArkWhiteUrlItem localArkWhiteUrlItem = new ArkAppInfo.ArkWhiteUrlItem();
      int i = str.indexOf("/");
      if (i == -1) {
        paramString = str;
      } else {
        paramString = str.substring(0, i);
      }
      localArkWhiteUrlItem.ruleDomain = paramString;
      if (i == -1) {
        paramString = "";
      } else {
        paramString = str.substring(i, str.length());
      }
      localArkWhiteUrlItem.rulePath = paramString;
      return localArkWhiteUrlItem;
    }
    return null;
  }
  
  public static ArkAppConfigMgr getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new ArkAppConfigMgr();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private ArkAppInfo.AppConfig getLocalAppConfig(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    Object localObject1 = null;
    if (bool)
    {
      Logger.logI("ArkApp.ArkAppConfigMgr", "ArkSafe.getLocalAppConfig,app=null");
      return null;
    }
    for (;;)
    {
      synchronized (lock)
      {
        ArkEnvironmentManager.getInstance();
        localObject4 = ArkEnvironmentManager.getAppConfigSharedPreferences();
        if (localObject4 != null)
        {
          localObject4 = ((SharedPreferences)localObject4).getString(paramString, null);
          bool = TextUtils.isEmpty((CharSequence)localObject4);
          Object localObject3;
          if (!bool) {
            try
            {
              ArkAppInfo.AppConfig localAppConfig = convertJsonToConfig(new JSONObject((String)localObject4));
              localObject1 = localAppConfig;
              this.mAppConfigCache.put(paramString, localAppConfig);
              localObject1 = localAppConfig;
              localObject2 = localAppConfig;
              if (localAppConfig.urlWhitelist != null)
              {
                localObject1 = localAppConfig;
                localObject2 = new ArkAppUrlChecker(localAppConfig.urlWhitelist, this.mGlobalWhiteList, this.mGlobalBlackList);
                localObject1 = localAppConfig;
                this.mAppUrlCheckerCache.put(paramString, localObject2);
                localObject2 = localAppConfig;
              }
            }
            catch (JSONException localJSONException)
            {
              Logger.logI("ArkApp.ArkAppConfigMgr", new Object[] { "getAppConfig, exception:", localJSONException.toString() });
              localObject3 = localObject1;
            }
          }
          checkAppIcon(paramString, localObject3);
          Logger.logI("ArkApp.ArkAppConfigMgr", new Object[] { "ArkSafe.getLocalAppConfig, app=", paramString, ", localCfg=", localObject4, ", env=", printEnvString() });
          return localObject3;
        }
      }
      Object localObject4 = null;
    }
  }
  
  private String printEnvString()
  {
    if (ArkEnvironmentManager.getInstance().isTestEnv()) {
      return "Test";
    }
    return "Product";
  }
  
  public static String removeSpecialChars(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    String str = paramString.trim();
    if (TextUtils.isEmpty(str)) {
      return str;
    }
    paramString = str;
    if (str.contains("://"))
    {
      int i = str.indexOf("://") + 3;
      if (i > str.length()) {
        i = str.length();
      }
      paramString = str.substring(i);
    }
    return paramString;
  }
  
  /* Error */
  private void saveAppIconToFile(String paramString, boolean paramBoolean, byte[] paramArrayOfByte, ArkAppConfigMgr.DownloadIconTask paramDownloadIconTask)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 7
    //   6: iconst_0
    //   7: istore 8
    //   9: iconst_0
    //   10: istore 5
    //   12: iload_2
    //   13: ifne +97 -> 110
    //   16: ldc 64
    //   18: ldc_w 382
    //   21: invokestatic 329	com/tencent/ark/Logger:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: aload 4
    //   26: ifnull +83 -> 109
    //   29: aload_0
    //   30: getfield 132	com/tencent/ark/open/ArkAppConfigMgr:mDownloadIconTaskList	Ljava/util/Map;
    //   33: astore_3
    //   34: aload_3
    //   35: monitorenter
    //   36: aload_0
    //   37: getfield 132	com/tencent/ark/open/ArkAppConfigMgr:mDownloadIconTaskList	Ljava/util/Map;
    //   40: aload 4
    //   42: getfield 387	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:url	Ljava/lang/String;
    //   45: invokeinterface 393 2 0
    //   50: pop
    //   51: aload_3
    //   52: monitorexit
    //   53: iload 5
    //   55: aload 4
    //   57: getfield 396	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:callbackList	Ljava/util/ArrayList;
    //   60: invokevirtual 214	java/util/ArrayList:size	()I
    //   63: if_icmpge +46 -> 109
    //   66: aload 4
    //   68: getfield 396	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:callbackList	Ljava/util/ArrayList;
    //   71: iload 5
    //   73: invokevirtual 218	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   76: checkcast 398	com/tencent/ark/open/ArkAppConfigMgr$IDownloadIconCallback
    //   79: astore_3
    //   80: aload_3
    //   81: ifnull +14 -> 95
    //   84: aload_3
    //   85: iconst_2
    //   86: aload_1
    //   87: ldc_w 314
    //   90: invokeinterface 402 4 0
    //   95: iload 5
    //   97: iconst_1
    //   98: iadd
    //   99: istore 5
    //   101: goto -48 -> 53
    //   104: astore_1
    //   105: aload_3
    //   106: monitorexit
    //   107: aload_1
    //   108: athrow
    //   109: return
    //   110: aconst_null
    //   111: astore 12
    //   113: aconst_null
    //   114: astore 14
    //   116: aconst_null
    //   117: astore 15
    //   119: new 404	java/io/File
    //   122: dup
    //   123: ldc_w 406
    //   126: iconst_2
    //   127: anewarray 4	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: invokestatic 93	com/tencent/ark/ArkEnvironmentManager:getInstance	()Lcom/tencent/ark/ArkEnvironmentManager;
    //   135: invokevirtual 409	com/tencent/ark/ArkEnvironmentManager:getAppIconDirectory	()Ljava/lang/String;
    //   138: aastore
    //   139: dup
    //   140: iconst_1
    //   141: aload_1
    //   142: aastore
    //   143: invokestatic 413	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   146: invokespecial 414	java/io/File:<init>	(Ljava/lang/String;)V
    //   149: astore 9
    //   151: aload 9
    //   153: invokevirtual 417	java/io/File:exists	()Z
    //   156: ifne +9 -> 165
    //   159: aload 9
    //   161: invokevirtual 420	java/io/File:mkdirs	()Z
    //   164: pop
    //   165: aload_0
    //   166: aload_1
    //   167: invokevirtual 423	com/tencent/ark/open/ArkAppConfigMgr:getAppIconFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   170: astore 9
    //   172: new 425	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 426	java/lang/StringBuilder:<init>	()V
    //   179: astore 10
    //   181: aload 10
    //   183: aload 9
    //   185: invokevirtual 430	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload 10
    //   191: ldc 22
    //   193: invokevirtual 430	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 10
    //   199: invokevirtual 431	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: astore 10
    //   204: aload 9
    //   206: astore 11
    //   208: aload 10
    //   210: astore 13
    //   212: aload 12
    //   214: astore 14
    //   216: new 433	java/io/FileOutputStream
    //   219: dup
    //   220: aload 10
    //   222: invokespecial 434	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   225: astore 12
    //   227: aload 12
    //   229: aload_3
    //   230: invokevirtual 438	java/io/FileOutputStream:write	([B)V
    //   233: ldc 64
    //   235: iconst_4
    //   236: anewarray 4	java/lang/Object
    //   239: dup
    //   240: iconst_0
    //   241: ldc_w 440
    //   244: aastore
    //   245: dup
    //   246: iconst_1
    //   247: aload_1
    //   248: aastore
    //   249: dup
    //   250: iconst_2
    //   251: ldc_w 442
    //   254: aastore
    //   255: dup
    //   256: iconst_3
    //   257: aload 10
    //   259: aastore
    //   260: invokestatic 296	com/tencent/ark/Logger:logI	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   263: aload 12
    //   265: invokevirtual 445	java/io/FileOutputStream:close	()V
    //   268: aload 10
    //   270: aload 9
    //   272: invokestatic 451	com/tencent/ark/open/ArkUtil:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   275: ifne +14 -> 289
    //   278: ldc 64
    //   280: ldc_w 453
    //   283: invokestatic 329	com/tencent/ark/Logger:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   286: goto +116 -> 402
    //   289: aload 4
    //   291: ifnull +87 -> 378
    //   294: aload_0
    //   295: getfield 132	com/tencent/ark/open/ArkAppConfigMgr:mDownloadIconTaskList	Ljava/util/Map;
    //   298: astore_3
    //   299: aload_3
    //   300: monitorenter
    //   301: aload_0
    //   302: getfield 132	com/tencent/ark/open/ArkAppConfigMgr:mDownloadIconTaskList	Ljava/util/Map;
    //   305: aload 4
    //   307: getfield 387	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:url	Ljava/lang/String;
    //   310: invokeinterface 393 2 0
    //   315: pop
    //   316: aload_3
    //   317: monitorexit
    //   318: iconst_0
    //   319: istore 5
    //   321: iload 5
    //   323: aload 4
    //   325: getfield 396	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:callbackList	Ljava/util/ArrayList;
    //   328: invokevirtual 214	java/util/ArrayList:size	()I
    //   331: if_icmpge +47 -> 378
    //   334: aload 4
    //   336: getfield 396	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:callbackList	Ljava/util/ArrayList;
    //   339: iload 5
    //   341: invokevirtual 218	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   344: checkcast 398	com/tencent/ark/open/ArkAppConfigMgr$IDownloadIconCallback
    //   347: astore_3
    //   348: aload_3
    //   349: ifnull +13 -> 362
    //   352: aload_3
    //   353: iconst_1
    //   354: aload_1
    //   355: aload 9
    //   357: invokeinterface 402 4 0
    //   362: iload 5
    //   364: iconst_1
    //   365: iadd
    //   366: istore 5
    //   368: goto -47 -> 321
    //   371: astore 9
    //   373: aload_3
    //   374: monitorexit
    //   375: aload 9
    //   377: athrow
    //   378: return
    //   379: astore_3
    //   380: ldc 64
    //   382: iconst_2
    //   383: anewarray 4	java/lang/Object
    //   386: dup
    //   387: iconst_0
    //   388: ldc_w 455
    //   391: aastore
    //   392: dup
    //   393: iconst_1
    //   394: aload_3
    //   395: invokevirtual 293	java/lang/Exception:toString	()Ljava/lang/String;
    //   398: aastore
    //   399: invokestatic 296	com/tencent/ark/Logger:logI	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   402: aload 4
    //   404: ifnull +470 -> 874
    //   407: aload_0
    //   408: getfield 132	com/tencent/ark/open/ArkAppConfigMgr:mDownloadIconTaskList	Ljava/util/Map;
    //   411: astore_3
    //   412: aload_3
    //   413: monitorenter
    //   414: aload_0
    //   415: getfield 132	com/tencent/ark/open/ArkAppConfigMgr:mDownloadIconTaskList	Ljava/util/Map;
    //   418: aload 4
    //   420: getfield 387	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:url	Ljava/lang/String;
    //   423: invokeinterface 393 2 0
    //   428: pop
    //   429: aload_3
    //   430: monitorexit
    //   431: iload 6
    //   433: istore 5
    //   435: iload 5
    //   437: aload 4
    //   439: getfield 396	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:callbackList	Ljava/util/ArrayList;
    //   442: invokevirtual 214	java/util/ArrayList:size	()I
    //   445: if_icmpge +429 -> 874
    //   448: aload 4
    //   450: getfield 396	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:callbackList	Ljava/util/ArrayList;
    //   453: iload 5
    //   455: invokevirtual 218	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   458: checkcast 398	com/tencent/ark/open/ArkAppConfigMgr$IDownloadIconCallback
    //   461: astore_3
    //   462: aload_3
    //   463: ifnull +14 -> 477
    //   466: aload_3
    //   467: iconst_2
    //   468: aload_1
    //   469: ldc_w 314
    //   472: invokeinterface 402 4 0
    //   477: iload 5
    //   479: iconst_1
    //   480: iadd
    //   481: istore 5
    //   483: goto -48 -> 435
    //   486: astore_1
    //   487: aload_3
    //   488: monitorexit
    //   489: aload_1
    //   490: athrow
    //   491: astore_3
    //   492: aload 9
    //   494: astore 11
    //   496: aload 10
    //   498: astore 9
    //   500: aload 12
    //   502: astore 14
    //   504: goto +376 -> 880
    //   507: astore 13
    //   509: aload 12
    //   511: astore 11
    //   513: aload 9
    //   515: astore 12
    //   517: aload 10
    //   519: astore_3
    //   520: aload 11
    //   522: astore 10
    //   524: aload 13
    //   526: astore 9
    //   528: goto +80 -> 608
    //   531: astore 11
    //   533: aload 9
    //   535: astore 12
    //   537: aload 10
    //   539: astore_3
    //   540: aload 15
    //   542: astore 10
    //   544: aload 11
    //   546: astore 9
    //   548: goto +60 -> 608
    //   551: astore_3
    //   552: aconst_null
    //   553: astore 10
    //   555: aload 9
    //   557: astore 11
    //   559: aload 10
    //   561: astore 9
    //   563: goto +317 -> 880
    //   566: astore 11
    //   568: aconst_null
    //   569: astore_3
    //   570: aload 9
    //   572: astore 12
    //   574: aload 15
    //   576: astore 10
    //   578: aload 11
    //   580: astore 9
    //   582: goto +26 -> 608
    //   585: astore_3
    //   586: aconst_null
    //   587: astore 11
    //   589: aload 11
    //   591: astore 9
    //   593: goto +287 -> 880
    //   596: astore 9
    //   598: aconst_null
    //   599: astore 12
    //   601: aload 12
    //   603: astore_3
    //   604: aload 15
    //   606: astore 10
    //   608: aload 12
    //   610: astore 11
    //   612: aload_3
    //   613: astore 13
    //   615: aload 10
    //   617: astore 14
    //   619: ldc 64
    //   621: iconst_2
    //   622: anewarray 4	java/lang/Object
    //   625: dup
    //   626: iconst_0
    //   627: ldc_w 455
    //   630: aastore
    //   631: dup
    //   632: iconst_1
    //   633: aload 9
    //   635: invokevirtual 293	java/lang/Exception:toString	()Ljava/lang/String;
    //   638: aastore
    //   639: invokestatic 296	com/tencent/ark/Logger:logI	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   642: aload 10
    //   644: ifnull +141 -> 785
    //   647: aload 10
    //   649: invokevirtual 445	java/io/FileOutputStream:close	()V
    //   652: aload_3
    //   653: aload 12
    //   655: invokestatic 451	com/tencent/ark/open/ArkUtil:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   658: ifne +14 -> 672
    //   661: ldc 64
    //   663: ldc_w 453
    //   666: invokestatic 329	com/tencent/ark/Logger:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   669: goto +116 -> 785
    //   672: aload 4
    //   674: ifnull +87 -> 761
    //   677: aload_0
    //   678: getfield 132	com/tencent/ark/open/ArkAppConfigMgr:mDownloadIconTaskList	Ljava/util/Map;
    //   681: astore_3
    //   682: aload_3
    //   683: monitorenter
    //   684: aload_0
    //   685: getfield 132	com/tencent/ark/open/ArkAppConfigMgr:mDownloadIconTaskList	Ljava/util/Map;
    //   688: aload 4
    //   690: getfield 387	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:url	Ljava/lang/String;
    //   693: invokeinterface 393 2 0
    //   698: pop
    //   699: aload_3
    //   700: monitorexit
    //   701: iconst_0
    //   702: istore 5
    //   704: iload 5
    //   706: aload 4
    //   708: getfield 396	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:callbackList	Ljava/util/ArrayList;
    //   711: invokevirtual 214	java/util/ArrayList:size	()I
    //   714: if_icmpge +47 -> 761
    //   717: aload 4
    //   719: getfield 396	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:callbackList	Ljava/util/ArrayList;
    //   722: iload 5
    //   724: invokevirtual 218	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   727: checkcast 398	com/tencent/ark/open/ArkAppConfigMgr$IDownloadIconCallback
    //   730: astore_3
    //   731: aload_3
    //   732: ifnull +13 -> 745
    //   735: aload_3
    //   736: iconst_1
    //   737: aload_1
    //   738: aload 12
    //   740: invokeinterface 402 4 0
    //   745: iload 5
    //   747: iconst_1
    //   748: iadd
    //   749: istore 5
    //   751: goto -47 -> 704
    //   754: astore 9
    //   756: aload_3
    //   757: monitorexit
    //   758: aload 9
    //   760: athrow
    //   761: return
    //   762: astore_3
    //   763: ldc 64
    //   765: iconst_2
    //   766: anewarray 4	java/lang/Object
    //   769: dup
    //   770: iconst_0
    //   771: ldc_w 455
    //   774: aastore
    //   775: dup
    //   776: iconst_1
    //   777: aload_3
    //   778: invokevirtual 293	java/lang/Exception:toString	()Ljava/lang/String;
    //   781: aastore
    //   782: invokestatic 296	com/tencent/ark/Logger:logI	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   785: aload 4
    //   787: ifnull +87 -> 874
    //   790: aload_0
    //   791: getfield 132	com/tencent/ark/open/ArkAppConfigMgr:mDownloadIconTaskList	Ljava/util/Map;
    //   794: astore_3
    //   795: aload_3
    //   796: monitorenter
    //   797: aload_0
    //   798: getfield 132	com/tencent/ark/open/ArkAppConfigMgr:mDownloadIconTaskList	Ljava/util/Map;
    //   801: aload 4
    //   803: getfield 387	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:url	Ljava/lang/String;
    //   806: invokeinterface 393 2 0
    //   811: pop
    //   812: aload_3
    //   813: monitorexit
    //   814: iload 7
    //   816: istore 5
    //   818: iload 5
    //   820: aload 4
    //   822: getfield 396	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:callbackList	Ljava/util/ArrayList;
    //   825: invokevirtual 214	java/util/ArrayList:size	()I
    //   828: if_icmpge +46 -> 874
    //   831: aload 4
    //   833: getfield 396	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:callbackList	Ljava/util/ArrayList;
    //   836: iload 5
    //   838: invokevirtual 218	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   841: checkcast 398	com/tencent/ark/open/ArkAppConfigMgr$IDownloadIconCallback
    //   844: astore_3
    //   845: aload_3
    //   846: ifnull +14 -> 860
    //   849: aload_3
    //   850: iconst_2
    //   851: aload_1
    //   852: ldc_w 314
    //   855: invokeinterface 402 4 0
    //   860: iload 5
    //   862: iconst_1
    //   863: iadd
    //   864: istore 5
    //   866: goto -48 -> 818
    //   869: astore_1
    //   870: aload_3
    //   871: monitorexit
    //   872: aload_1
    //   873: athrow
    //   874: return
    //   875: astore_3
    //   876: aload 13
    //   878: astore 9
    //   880: aload 14
    //   882: ifnull +151 -> 1033
    //   885: aload 14
    //   887: invokevirtual 445	java/io/FileOutputStream:close	()V
    //   890: aload 9
    //   892: aload 11
    //   894: invokestatic 451	com/tencent/ark/open/ArkUtil:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   897: ifne +14 -> 911
    //   900: ldc 64
    //   902: ldc_w 453
    //   905: invokestatic 329	com/tencent/ark/Logger:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   908: goto +125 -> 1033
    //   911: aload 4
    //   913: ifnull +94 -> 1007
    //   916: aload_0
    //   917: getfield 132	com/tencent/ark/open/ArkAppConfigMgr:mDownloadIconTaskList	Ljava/util/Map;
    //   920: astore 9
    //   922: aload 9
    //   924: monitorenter
    //   925: aload_0
    //   926: getfield 132	com/tencent/ark/open/ArkAppConfigMgr:mDownloadIconTaskList	Ljava/util/Map;
    //   929: aload 4
    //   931: getfield 387	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:url	Ljava/lang/String;
    //   934: invokeinterface 393 2 0
    //   939: pop
    //   940: aload 9
    //   942: monitorexit
    //   943: iconst_0
    //   944: istore 5
    //   946: iload 5
    //   948: aload 4
    //   950: getfield 396	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:callbackList	Ljava/util/ArrayList;
    //   953: invokevirtual 214	java/util/ArrayList:size	()I
    //   956: if_icmpge +51 -> 1007
    //   959: aload 4
    //   961: getfield 396	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:callbackList	Ljava/util/ArrayList;
    //   964: iload 5
    //   966: invokevirtual 218	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   969: checkcast 398	com/tencent/ark/open/ArkAppConfigMgr$IDownloadIconCallback
    //   972: astore 9
    //   974: aload 9
    //   976: ifnull +14 -> 990
    //   979: aload 9
    //   981: iconst_1
    //   982: aload_1
    //   983: aload 11
    //   985: invokeinterface 402 4 0
    //   990: iload 5
    //   992: iconst_1
    //   993: iadd
    //   994: istore 5
    //   996: goto -50 -> 946
    //   999: astore 10
    //   1001: aload 9
    //   1003: monitorexit
    //   1004: aload 10
    //   1006: athrow
    //   1007: return
    //   1008: astore 9
    //   1010: ldc 64
    //   1012: iconst_2
    //   1013: anewarray 4	java/lang/Object
    //   1016: dup
    //   1017: iconst_0
    //   1018: ldc_w 455
    //   1021: aastore
    //   1022: dup
    //   1023: iconst_1
    //   1024: aload 9
    //   1026: invokevirtual 293	java/lang/Exception:toString	()Ljava/lang/String;
    //   1029: aastore
    //   1030: invokestatic 296	com/tencent/ark/Logger:logI	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1033: aload 4
    //   1035: ifnull +94 -> 1129
    //   1038: aload_0
    //   1039: getfield 132	com/tencent/ark/open/ArkAppConfigMgr:mDownloadIconTaskList	Ljava/util/Map;
    //   1042: astore 9
    //   1044: aload 9
    //   1046: monitorenter
    //   1047: aload_0
    //   1048: getfield 132	com/tencent/ark/open/ArkAppConfigMgr:mDownloadIconTaskList	Ljava/util/Map;
    //   1051: aload 4
    //   1053: getfield 387	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:url	Ljava/lang/String;
    //   1056: invokeinterface 393 2 0
    //   1061: pop
    //   1062: aload 9
    //   1064: monitorexit
    //   1065: iload 8
    //   1067: istore 5
    //   1069: iload 5
    //   1071: aload 4
    //   1073: getfield 396	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:callbackList	Ljava/util/ArrayList;
    //   1076: invokevirtual 214	java/util/ArrayList:size	()I
    //   1079: if_icmpge +50 -> 1129
    //   1082: aload 4
    //   1084: getfield 396	com/tencent/ark/open/ArkAppConfigMgr$DownloadIconTask:callbackList	Ljava/util/ArrayList;
    //   1087: iload 5
    //   1089: invokevirtual 218	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1092: checkcast 398	com/tencent/ark/open/ArkAppConfigMgr$IDownloadIconCallback
    //   1095: astore 9
    //   1097: aload 9
    //   1099: ifnull +15 -> 1114
    //   1102: aload 9
    //   1104: iconst_2
    //   1105: aload_1
    //   1106: ldc_w 314
    //   1109: invokeinterface 402 4 0
    //   1114: iload 5
    //   1116: iconst_1
    //   1117: iadd
    //   1118: istore 5
    //   1120: goto -51 -> 1069
    //   1123: astore_1
    //   1124: aload 9
    //   1126: monitorexit
    //   1127: aload_1
    //   1128: athrow
    //   1129: goto +5 -> 1134
    //   1132: aload_3
    //   1133: athrow
    //   1134: goto -2 -> 1132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1137	0	this	ArkAppConfigMgr
    //   0	1137	1	paramString	String
    //   0	1137	2	paramBoolean	boolean
    //   0	1137	3	paramArrayOfByte	byte[]
    //   0	1137	4	paramDownloadIconTask	ArkAppConfigMgr.DownloadIconTask
    //   10	1109	5	i	int
    //   1	431	6	j	int
    //   4	811	7	k	int
    //   7	1059	8	m	int
    //   149	207	9	localObject1	Object
    //   371	122	9	localObject2	Object
    //   498	94	9	localObject3	Object
    //   596	38	9	localException1	Exception
    //   754	5	9	localObject4	Object
    //   878	124	9	localObject5	Object
    //   1008	17	9	localException2	Exception
    //   1042	83	9	localObject6	Object
    //   179	469	10	localObject7	Object
    //   999	6	10	localObject8	Object
    //   206	315	11	localObject9	Object
    //   531	14	11	localException3	Exception
    //   557	1	11	localObject10	Object
    //   566	13	11	localException4	Exception
    //   587	397	11	localObject11	Object
    //   111	628	12	localObject12	Object
    //   210	1	13	localObject13	Object
    //   507	18	13	localException5	Exception
    //   613	264	13	arrayOfByte	byte[]
    //   114	772	14	localObject14	Object
    //   117	488	15	localObject15	Object
    // Exception table:
    //   from	to	target	type
    //   36	53	104	finally
    //   105	107	104	finally
    //   301	318	371	finally
    //   373	375	371	finally
    //   263	286	379	java/lang/Exception
    //   294	301	379	java/lang/Exception
    //   321	348	379	java/lang/Exception
    //   352	362	379	java/lang/Exception
    //   375	378	379	java/lang/Exception
    //   414	431	486	finally
    //   487	489	486	finally
    //   227	263	491	finally
    //   227	263	507	java/lang/Exception
    //   216	227	531	java/lang/Exception
    //   172	204	551	finally
    //   172	204	566	java/lang/Exception
    //   119	165	585	finally
    //   165	172	585	finally
    //   119	165	596	java/lang/Exception
    //   165	172	596	java/lang/Exception
    //   684	701	754	finally
    //   756	758	754	finally
    //   647	669	762	java/lang/Exception
    //   677	684	762	java/lang/Exception
    //   704	731	762	java/lang/Exception
    //   735	745	762	java/lang/Exception
    //   758	761	762	java/lang/Exception
    //   797	814	869	finally
    //   870	872	869	finally
    //   216	227	875	finally
    //   619	642	875	finally
    //   925	943	999	finally
    //   1001	1004	999	finally
    //   885	908	1008	java/lang/Exception
    //   916	925	1008	java/lang/Exception
    //   946	974	1008	java/lang/Exception
    //   979	990	1008	java/lang/Exception
    //   1004	1007	1008	java/lang/Exception
    //   1047	1065	1123	finally
    //   1124	1127	1123	finally
  }
  
  public boolean canForward(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      Logger.logI("ArkApp.ArkAppConfigMgr", "ArkSafe.canForward appname is empty return false");
      return false;
    }
    ArkAppInfo.AppConfig localAppConfig = getAppConfig(paramString1);
    if (localAppConfig == null)
    {
      Logger.logI("ArkApp.ArkAppConfigMgr", new Object[] { "ArkSafe.canForward app:", paramString1, ",config is null return true" });
      return true;
    }
    if ((localAppConfig.forwardViews != null) && (localAppConfig.forwardViews.size() != 0))
    {
      int i = 0;
      while (i < localAppConfig.forwardViews.size())
      {
        String str = (String)localAppConfig.forwardViews.get(i);
        if ("*".equals(str))
        {
          bool1 = true;
          break label158;
        }
        if ((!TextUtils.isEmpty(str)) && (str.equals(paramString2)))
        {
          bool1 = false;
          bool2 = true;
          break label161;
        }
        i += 1;
      }
      boolean bool1 = false;
      label158:
      boolean bool2 = false;
      label161:
      if (bool1) {}
      while (bool2)
      {
        bool3 = true;
        break;
      }
      boolean bool3 = false;
      Logger.logI("ArkApp.ArkAppConfigMgr", new Object[] { "ArkSafe.canForward app:", paramString1, ",view:", paramString2, ",canForward=", Boolean.valueOf(bool3), ",allowAll:", Boolean.valueOf(bool1), ",findView:", Boolean.valueOf(bool2) });
      return bool3;
    }
    Logger.logI("ArkApp.ArkAppConfigMgr", new Object[] { "ArkSafe.canForward app:", paramString1, ",config.forward view is null return true" });
    return true;
  }
  
  public void cleanAllConfig()
  {
    ArkDispatchTask.getInstance().postToArkThread(new ArkAppConfigMgr.2(this));
  }
  
  public void downloadAppIcon(String paramString1, String paramString2, ArkAppConfigMgr.IDownloadIconCallback arg3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      synchronized (this.mDownloadIconTaskList)
      {
        ArkAppConfigMgr.DownloadIconTask localDownloadIconTask = (ArkAppConfigMgr.DownloadIconTask)this.mDownloadIconTaskList.get(paramString2);
        if (localDownloadIconTask != null)
        {
          localDownloadIconTask.callbackList.add(???);
          Logger.logI("ArkApp.ArkAppConfigMgr", new Object[] { "ArkSafe.downloadAppIcon all ready in request app=", paramString1 });
          return;
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
    }
    Logger.logI("ArkApp.ArkAppConfigMgr", "ArkSafe.downloadAppIcon, app is null");
  }
  
  public ArkAppInfo.AppConfig getAppConfig(String paramString)
  {
    boolean bool = sEnableAppConfig;
    ArkAppInfo.AppConfig localAppConfig = null;
    if (!bool)
    {
      Logger.logI("ArkApp.ArkAppConfigMgr", "ArkSafe.getAppConfig ServerConfig disable");
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
      Logger.logI("ArkApp.ArkAppConfigMgr", new Object[] { "ArkTemp.ArkSafe.getAppConfig app=", paramString, ", cached config=", convertConfigToJsonString(localAppConfig), ", env=", printEnvString() });
      return localAppConfig;
    }
  }
  
  public long getAppConfigVersion(String paramString)
  {
    boolean bool = sEnableAppConfig;
    long l = 0L;
    if (!bool)
    {
      Logger.logI("ArkApp.ArkAppConfigMgr", "ArkSafe.getAppConfigVersion ServerConfig disable");
      return 0L;
    }
    ArkAppInfo.AppConfig localAppConfig = getAppConfig(paramString);
    if (localAppConfig != null) {
      l = localAppConfig.ver;
    }
    Logger.logI("ArkApp.ArkAppConfigMgr", new Object[] { "ArkSafe.getAppConfigVersion app=", paramString, ", cfgver=", Long.valueOf(l), ", env=", printEnvString() });
    return l;
  }
  
  public String getAppIconFilePath(String paramString)
  {
    ArkAppInfo.AppConfig localAppConfig = getAppConfig(paramString);
    if (localAppConfig == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(ArkEnvironmentManager.getInstance().getAppIconDirectory());
    localStringBuilder.append("/");
    localStringBuilder.append(paramString);
    localStringBuilder.append("/");
    localStringBuilder.append(localAppConfig.ver);
    return localStringBuilder.toString();
  }
  
  public ArkAppUrlChecker getUrlChecker(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    ArkAppUrlChecker localArkAppUrlChecker1 = null;
    if (bool) {
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
    Logger.logI("ArkApp.ArkAppConfigMgr", new Object[] { "ArkSafe.initConfig, env=", printEnvString() });
    ArkDispatchTask.getInstance().postToArkThread(new ArkAppConfigMgr.1(this));
  }
  
  public void initGlobalWhiteListAndUrlCheckStatus(boolean paramBoolean, ArrayList<String> paramArrayList, ConcurrentHashMap<String, ArrayList<String>> arg3)
  {
    if (paramArrayList != null) {
      ??? = paramArrayList.toString();
    } else {
      ??? = "null";
    }
    Logger.logI("ArkApp.ArkAppConfigMgr", new Object[] { "ArkSafe.initGlobalWhiteListAndUrlCheckStatus.isUrlCheckEnable = ", Boolean.valueOf(paramBoolean), ",urlDisableAppList= ", ??? });
    setUrlCheckEnable(paramBoolean, paramArrayList);
    if (??? != null)
    {
      ??? = (ArrayList)???.get("white");
      if (??? != null)
      {
        paramArrayList = new ArrayList();
        ??? = ((ArrayList)???).iterator();
        while (((Iterator)???).hasNext())
        {
          Object localObject2 = (String)((Iterator)???).next();
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject2 = convertWhiteUrlToItem((String)localObject2);
            if (localObject2 != null) {
              paramArrayList.add(localObject2);
            }
          }
        }
        if (paramArrayList.size() > 0) {
          synchronized (lock)
          {
            this.mGlobalWhiteList = paramArrayList;
            Logger.logI("ArkApp.ArkAppConfigMgr", String.format("ArkSafe.initGlobalWhiteList white list:%s", new Object[] { this.mGlobalWhiteList.toString() }));
          }
        }
      }
      ??? = (ArrayList)???.get("black");
      if (??? != null)
      {
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
        if (paramArrayList.size() > 0) {
          synchronized (lock)
          {
            this.mGlobalBlackList = paramArrayList;
            Logger.logI("ArkApp.ArkAppConfigMgr", String.format("ArkSafe.initGlobalWhiteList black list:%s", new Object[] { this.mGlobalBlackList.toString() }));
          }
        }
      }
    }
    else
    {
      Logger.logD("ArkApp.ArkAppConfigMgr", String.format("ArkSafe.app global white and black is null", new Object[0]));
    }
    initConfig();
  }
  
  public boolean isUrlCheckEnable(String paramString)
  {
    for (;;)
    {
      synchronized (this.mUrlDisableAppList)
      {
        boolean bool1 = TextUtils.isEmpty(paramString);
        boolean bool2 = false;
        if ((!bool1) && (this.mUrlDisableAppList.size() > 0) && (this.mUrlDisableAppList.contains(paramString)))
        {
          Logger.logI("ArkApp.ArkAppConfigMgr", new Object[] { "ArkSafe.app.checkUrl.enable=false,app=", paramString });
          i = 0;
          bool1 = bool2;
          if (this.mUrlCheckEnable)
          {
            bool1 = bool2;
            if (i != 0) {
              bool1 = true;
            }
          }
          return bool1;
        }
      }
      int i = 1;
    }
  }
  
  public void saveAppConfig(String paramString, ArkAppInfo.AppConfig paramAppConfig)
  {
    if (!sEnableAppConfig)
    {
      Logger.logI("ArkApp.ArkAppConfigMgr", "ArkSafe.saveAppConfig ServerConfig disable");
      return;
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramAppConfig != null)) {
      synchronized (lock)
      {
        this.mAppConfigCache.put(paramString, paramAppConfig);
        if (paramAppConfig.urlWhitelist != null)
        {
          localObject2 = new ArkAppUrlChecker(paramAppConfig.urlWhitelist, this.mGlobalWhiteList, this.mGlobalBlackList);
          this.mAppUrlCheckerCache.put(paramString, localObject2);
        }
        else
        {
          this.mAppUrlCheckerCache.remove(paramString);
        }
        paramAppConfig = convertConfigToJsonString(paramAppConfig);
        Object localObject2 = ArkEnvironmentManager.getAppConfigSharedPreferences();
        if (localObject2 != null) {
          ((SharedPreferences)localObject2).edit().putString(paramString, paramAppConfig).commit();
        }
        Logger.logI("ArkApp.ArkAppConfigMgr", new Object[] { "ArkTemp.ArkSafe.saveAppConfig, app=", paramString, ", cfg=", paramAppConfig, ", env=", printEnvString() });
        return;
      }
    }
  }
  
  public void setUrlCheckEnable(boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    this.mUrlCheckEnable = paramBoolean;
    this.mUrlDisableAppList = paramArrayList;
    Logger.logI("ArkApp.ArkAppConfigMgr", new Object[] { "ArkSafe.setUrlCheckEnable global=", Boolean.valueOf(this.mUrlCheckEnable) });
  }
  
  public void updateUrlCheckAndCleanAppUpdateTime(boolean paramBoolean, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    String str;
    if (paramArrayList1 != null) {
      str = paramArrayList1.toString();
    } else {
      str = "null";
    }
    Logger.logI("ArkApp.ArkAppConfigMgr", new Object[] { "ArkSafe.updateUrlCheckAndCleanAppUpdateTimeisUrlCheckEnable = ", Boolean.valueOf(paramBoolean), ",urlDisableAppList= ", str });
    setUrlCheckEnable(paramBoolean, paramArrayList1);
    if ((paramArrayList2 != null) && (paramArrayList2.size() > 0))
    {
      paramArrayList1 = paramArrayList2.iterator();
      int i = 0;
      while (paramArrayList1.hasNext())
      {
        paramArrayList2 = (String)paramArrayList1.next();
        if (!TextUtils.isEmpty(paramArrayList2))
        {
          Logger.logI("ArkApp.ArkAppConfigMgr", new Object[] { "ArkSafe.updateUrlCheckAndCleanAppUpdateTime get config clean app=", paramArrayList2 });
          if (AppUpdateManager.isAppUpdateBefore(paramArrayList2))
          {
            Logger.logI("ArkApp.ArkAppConfigMgr", new Object[] { "ArkSafe.updateUrlCheckAndCleanAppUpdateTime force clean update time app =", paramArrayList2 });
            AppUpdateManager.putAppUpdateTime(paramArrayList2, 0L);
            i = 1;
          }
        }
      }
      if (i != 0)
      {
        Logger.logI("ArkApp.ArkAppConfigMgr", "ArkSafe.updateUrlCheckAndCleanAppUpdateTime force clean global");
        AppUpdateManager.getInstance().clearGlobalUpdateTime();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppConfigMgr
 * JD-Core Version:    0.7.0.1
 */