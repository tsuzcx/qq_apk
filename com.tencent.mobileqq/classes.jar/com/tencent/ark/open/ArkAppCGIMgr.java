package com.tencent.ark.open;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ark;
import com.tencent.ark.open.delegate.ArkDelegateManager;
import com.tencent.ark.open.delegate.IArkDelegateNet;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.PublicKey;
import java.security.Signature;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkAppCGIMgr
{
  public static final int AppUpdateState_NeedUpdate = 1;
  public static final int AppUpdateState_NoUpdate = 2;
  public static final int AppUpdateState_None = 0;
  public static final int AppUpdateState_Offline = 3;
  private static final int DEFAULT_UPDATE_APP_INTERVAL = 300;
  private static final ArkEnvironmentManager ENV = ;
  private static final int MIN_UPDATE_APP_INTERVAL = 60;
  private static final int QUERY_APP_INFO_LIMIT;
  private static final String TAG = "ArkApp.ArkAppCGIMgr";
  static int _tempFileIndex;
  private static PublicKey mAppPackagePubKey;
  private final ArrayList<ArkAppCGIMgr.QueryTask> mTaskList = new ArrayList();
  
  static
  {
    if (ArkEnvironmentManager.getInstance().getDebugFlag()) {}
    for (int i = 2;; i = 10)
    {
      QUERY_APP_INFO_LIMIT = i;
      _tempFileIndex = 0;
      return;
    }
  }
  
  private static String createTempFilePath()
  {
    try
    {
      String str = ArkEnvironmentManager.getInstance().getCacheDirectory() + "/tmp";
      new File(str).mkdirs();
      long l = System.currentTimeMillis();
      int i = _tempFileIndex + 1;
      _tempFileIndex = i;
      str = String.format("%s/%s", new Object[] { str, String.format("cgi_%d_%d", new Object[] { Long.valueOf(l), Integer.valueOf(i) }) });
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static String getAppUpdateReqString(ArrayList<ArkAppCGIMgr.AppNameVersion> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return null;
    }
    JSONObject localJSONObject1;
    JSONArray localJSONArray;
    for (;;)
    {
      try
      {
        localJSONObject1 = new JSONObject();
        localJSONObject1.put("os", "android");
        localJSONObject1.put("platformVer", ark.arkGetPlatformVersion());
        localJSONObject1.put("minPlatformVer", ark.arkGetMinPlatformVersion());
        localJSONArray = new JSONArray();
        paramArrayList = paramArrayList.iterator();
        if (!paramArrayList.hasNext()) {
          break;
        }
        ArkAppCGIMgr.AppNameVersion localAppNameVersion = (ArkAppCGIMgr.AppNameVersion)paramArrayList.next();
        if (!TextUtils.isEmpty(localAppNameVersion.appName))
        {
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("app", localAppNameVersion.appName);
          if (TextUtils.isEmpty(localAppNameVersion.appVersion))
          {
            localJSONObject2.put("ver", "0.0.0.0");
            if (!TextUtils.isEmpty(localAppNameVersion.expectAppVersion)) {
              localJSONObject2.put("expectVersion", localAppNameVersion.expectAppVersion);
            }
            localJSONObject2.put("cfgver", ArkAppConfigMgr.getInstance().getAppConfigVersion(localAppNameVersion.appName));
            localJSONArray.put(localJSONObject2);
          }
          else
          {
            localJSONObject2.put("ver", localAppNameVersion.appVersion);
          }
        }
      }
      catch (JSONException paramArrayList)
      {
        ENV.logI("ArkApp.ArkAppCGIMgr", String.format("getAppUpdateReqString, exception: %s", new Object[] { paramArrayList.getMessage() }));
        return null;
      }
    }
    localJSONObject1.put("apps", localJSONArray);
    localJSONObject1.put("qqVer", ArkEnvironmentManager.getInstance().getQQVersion());
    localJSONObject1.put("supportTemplate", 1);
    paramArrayList = localJSONObject1.toString();
    return paramArrayList;
  }
  
  /* Error */
  private static PublicKey getArkAppPackagePubliceKey()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 252	com/tencent/ark/open/ArkAppCGIMgr:mAppPackagePubKey	Ljava/security/PublicKey;
    //   6: ifnull +12 -> 18
    //   9: getstatic 252	com/tencent/ark/open/ArkAppCGIMgr:mAppPackagePubKey	Ljava/security/PublicKey;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: new 254	java/security/spec/X509EncodedKeySpec
    //   21: dup
    //   22: ldc_w 256
    //   25: iconst_0
    //   26: invokestatic 262	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   29: invokespecial 265	java/security/spec/X509EncodedKeySpec:<init>	([B)V
    //   32: astore_0
    //   33: ldc_w 267
    //   36: invokestatic 272	java/security/KeyFactory:getInstance	(Ljava/lang/String;)Ljava/security/KeyFactory;
    //   39: aload_0
    //   40: invokevirtual 276	java/security/KeyFactory:generatePublic	(Ljava/security/spec/KeySpec;)Ljava/security/PublicKey;
    //   43: putstatic 252	com/tencent/ark/open/ArkAppCGIMgr:mAppPackagePubKey	Ljava/security/PublicKey;
    //   46: getstatic 252	com/tencent/ark/open/ArkAppCGIMgr:mAppPackagePubKey	Ljava/security/PublicKey;
    //   49: astore_0
    //   50: goto -37 -> 13
    //   53: astore_0
    //   54: getstatic 40	com/tencent/ark/open/ArkAppCGIMgr:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   57: ldc 24
    //   59: new 85	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   66: ldc_w 278
    //   69: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_0
    //   73: invokevirtual 279	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   76: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokevirtual 234	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: goto -39 -> 46
    //   88: astore_0
    //   89: ldc 2
    //   91: monitorexit
    //   92: aload_0
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	38	0	localObject1	Object
    //   53	20	0	localException	Exception
    //   88	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   33	46	53	java/lang/Exception
    //   3	13	88	finally
    //   18	33	88	finally
    //   33	46	88	finally
    //   46	50	88	finally
    //   54	85	88	finally
  }
  
  public static ArkAppCGIMgr getInstance()
  {
    return ArkAppCGIMgr.Holder.gInstance;
  }
  
  private boolean mergeRequestByUrl(String paramString, long paramLong, Object paramObject, ArkAppCGIMgr.ArkAppCGICallback paramArkAppCGICallback)
  {
    synchronized (this.mTaskList)
    {
      Iterator localIterator = this.mTaskList.iterator();
      while (localIterator.hasNext())
      {
        ArkAppCGIMgr.QueryTask localQueryTask = (ArkAppCGIMgr.QueryTask)localIterator.next();
        if ((localQueryTask.url.equalsIgnoreCase(paramString)) && (localQueryTask.lastModifiedTime == paramLong))
        {
          localQueryTask.userdata.add(paramObject);
          localQueryTask.callback.add(paramArkAppCGICallback);
          return true;
        }
      }
      return false;
    }
  }
  
  protected static void onDownloadAppPackage(ArkAppCGIMgr.QueryTask_DownloadAppPackage paramQueryTask_DownloadAppPackage, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte;
    int i;
    label34:
    ArkAppCGIMgr.ArkAppCGICallback localArkAppCGICallback;
    if (!paramBoolean)
    {
      ENV.logI("ArkApp.ArkAppCGIMgr", String.format("onDownloadAppPackage: net fail, url=%s", new Object[] { paramQueryTask_DownloadAppPackage.url }));
      arrayOfByte = null;
      i = 0;
      if (i >= paramQueryTask_DownloadAppPackage.callback.size()) {
        return;
      }
      paramArrayOfByte = paramQueryTask_DownloadAppPackage.userdata.get(i);
      localArkAppCGICallback = (ArkAppCGIMgr.ArkAppCGICallback)paramQueryTask_DownloadAppPackage.callback.get(i);
      if (localArkAppCGICallback != null) {
        if (arrayOfByte == null) {
          break label147;
        }
      }
    }
    label147:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localArkAppCGICallback.onDownloadAppPackage(paramBoolean, arrayOfByte, paramArrayOfByte);
      i += 1;
      break label34;
      if (paramQueryTask_DownloadAppPackage.appSign != null)
      {
        arrayOfByte = paramArrayOfByte;
        if (verifyAppPackage(paramArrayOfByte, paramQueryTask_DownloadAppPackage.appSign)) {
          break;
        }
      }
      ENV.logI("ArkApp.ArkAppCGIMgr", String.format("onDownloadAppPackage: verifyAppPackage fail, url=%s", new Object[] { paramQueryTask_DownloadAppPackage.url }));
      arrayOfByte = null;
      break;
    }
  }
  
  private void onHttpRequestResult(ArkAppCGIMgr.QueryTask paramQueryTask, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    new Handler(Looper.getMainLooper()).post(new ArkAppCGIMgr.5(this, paramQueryTask, paramBoolean, paramArrayOfByte));
  }
  
  private void parseDictList(JSONArray paramJSONArray, ArrayList<ArkAppCGIMgr.AIWordDictInfo> paramArrayList)
  {
    if (paramJSONArray == null) {
      return;
    }
    int j = paramJSONArray.length();
    int i = 0;
    label13:
    Object localObject;
    if (i < j)
    {
      localObject = paramJSONArray.optJSONObject(i);
      if (localObject != null) {
        break label63;
      }
      ENV.logI("ArkApp.ArkAppCGIMgr", String.format("parseDictList, node is not object, index=%d", new Object[] { Integer.valueOf(i) }));
    }
    for (;;)
    {
      i += 1;
      break label13;
      break;
      label63:
      int k = ((JSONObject)localObject).optInt("type", -1);
      String str1 = ((JSONObject)localObject).optString("name", "");
      String str2 = ((JSONObject)localObject).optString("url", "");
      localObject = ((JSONObject)localObject).optString("identifier", "");
      if ((k == -1) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty((CharSequence)localObject)))
      {
        ENV.logI("ArkApp.ArkAppCGIMgr", String.format("parseDictList, node is invalid, index=%d", new Object[] { Integer.valueOf(i) }));
      }
      else
      {
        ArkAppCGIMgr.AIWordDictInfo localAIWordDictInfo = new ArkAppCGIMgr.AIWordDictInfo();
        localAIWordDictInfo.name = str1;
        localAIWordDictInfo.type = k;
        localAIWordDictInfo.URL = str2;
        localAIWordDictInfo.identifier = ((String)localObject);
        paramArrayList.add(localAIWordDictInfo);
      }
    }
  }
  
  private void parseReply_AppConfig(byte[] paramArrayOfByte, ArrayList<String> paramArrayList, ArrayList<ArkAppCGIMgr.AIWordDictInfo> paramArrayList1)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (paramArrayList == null)) {
      ENV.logI("ArkApp.ArkAppCGIMgr", "parseReply_AppConfig: replyBuf is empty");
    }
    for (;;)
    {
      return;
      paramArrayList.clear();
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
        if (paramArrayOfByte != null)
        {
          paramArrayOfByte = new JSONObject(paramArrayOfByte);
          if (paramArrayOfByte != null)
          {
            parseUpdateAppList(paramArrayOfByte.optJSONArray("update_applist"), paramArrayList);
            parseDictList(paramArrayOfByte.optJSONArray("word_dict_list"), paramArrayList1);
            return;
          }
        }
      }
      catch (JSONException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        ENV.logI("ArkApp.ArkAppCGIMgr", "parseReply_AppConfig, JSONException:" + paramArrayOfByte.getMessage());
        return;
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        ENV.logI("ArkApp.ArkAppCGIMgr", "parseReply_AppConfig, UnsupportedEncodingException:" + paramArrayOfByte.getMessage());
      }
    }
  }
  
  private void parseUpdateAppList(JSONArray paramJSONArray, ArrayList<String> paramArrayList)
  {
    if (paramJSONArray == null)
    {
      ENV.logI("ArkApp.ArkAppCGIMgr", "parseUpdateAppList, nodeAppList is null");
      return;
    }
    int j = paramJSONArray.length();
    int i = 0;
    label24:
    String str;
    if (i < j)
    {
      str = paramJSONArray.optString(i, "");
      if (!TextUtils.isEmpty(str)) {
        break label80;
      }
      ENV.logI("ArkApp.ArkAppCGIMgr", String.format("parseUpdateAppList, node is not string, index=%d", new Object[] { Integer.valueOf(i) }));
    }
    for (;;)
    {
      i += 1;
      break label24;
      break;
      label80:
      if (!ArkAppMgr.isValidAppName(str)) {
        ENV.logI("ArkApp.ArkAppCGIMgr", String.format("parseUpdateAppList, invalid app name, index=%d, app=%s", new Object[] { Integer.valueOf(i), str }));
      } else if (paramArrayList.contains(str)) {
        ENV.logI("ArkApp.ArkAppCGIMgr", String.format("parseUpdateAppList, duplicate app name, index=%d, app=%s", new Object[] { Integer.valueOf(i), str }));
      } else {
        paramArrayList.add(str);
      }
    }
  }
  
  private ArkAppCGIMgr.QueryAppInfoByAppNameBatchResult parserReply_queryAppInfoByAppNameBatch(String paramString)
  {
    if (ArkEnvironmentManager.getInstance().getDebugFlag()) {
      ENV.logI("ArkApp.ArkAppCGIMgr", String.format("ArkTemp.ArkSafe.parserReply_queryAppInfoByAppNameBatch,config=%s", new Object[] { paramString }));
    }
    ArkAppCGIMgr.QueryAppInfoByAppNameBatchResult localQueryAppInfoByAppNameBatchResult = new ArkAppCGIMgr.QueryAppInfoByAppNameBatchResult();
    localQueryAppInfoByAppNameBatchResult.updateInterval = 0;
    if (paramString == null) {
      ENV.logI("ArkApp.ArkAppCGIMgr", "parserReply_queryAppInfoByAppNameBatch, data is empty");
    }
    for (;;)
    {
      return localQueryAppInfoByAppNameBatchResult;
      try
      {
        paramString = new JSONObject(paramString).optJSONObject("data");
        if (paramString == null)
        {
          ENV.logI("ArkApp.ArkAppCGIMgr", "parserReply_queryAppInfoByAppNameBatch, 'data' not found");
          return localQueryAppInfoByAppNameBatchResult;
        }
      }
      catch (JSONException paramString)
      {
        ENV.logI("ArkApp.ArkAppCGIMgr", String.format("ArkTemp.parserReply_queryAppInfoByAppNameBatch, exception: %s", new Object[] { paramString.getMessage() }));
        return localQueryAppInfoByAppNameBatchResult;
      }
      localQueryAppInfoByAppNameBatchResult.updateInterval = paramString.optInt("updateInterval", 300);
      localQueryAppInfoByAppNameBatchResult.updateInterval = Math.max(60, localQueryAppInfoByAppNameBatchResult.updateInterval);
      paramString = paramString.optJSONArray("apps");
      if (paramString != null)
      {
        int i = 0;
        while (i < paramString.length())
        {
          Object localObject1 = paramString.optJSONObject(i);
          if (localObject1 != null)
          {
            String str1 = ((JSONObject)localObject1).optString("app");
            if (TextUtils.isEmpty(str1))
            {
              ENV.logI("ArkApp.ArkAppCGIMgr", "parserReply_queryAppInfoByAppNameBatch, 'app' not found");
            }
            else
            {
              int j = ((JSONObject)localObject1).optInt("ret", -1);
              Object localObject2 = ((JSONObject)localObject1).optString("msg", "");
              ArkAppCGIMgr.QueryAppInfoResult localQueryAppInfoResult;
              if (j != 0)
              {
                localQueryAppInfoResult = new ArkAppCGIMgr.QueryAppInfoResult();
                localQueryAppInfoResult.retCode = j;
                localQueryAppInfoResult.msg = ((String)localObject2);
                localQueryAppInfoResult.info = null;
                localQueryAppInfoByAppNameBatchResult.resultList.put(str1, localQueryAppInfoResult);
              }
              else
              {
                localQueryAppInfoResult = new ArkAppCGIMgr.QueryAppInfoResult();
                localQueryAppInfoResult.retCode = 0;
                localQueryAppInfoResult.msg = ((String)localObject2);
                localQueryAppInfoResult.info = new ArkAppInfo.AppDownloadInfo();
                localQueryAppInfoResult.info.desc = new ArkAppInfo.AppDesc();
                localObject2 = ((JSONObject)localObject1).optJSONObject("config");
                if (localObject2 != null)
                {
                  localQueryAppInfoResult.info.config = ArkAppConfigMgr.convertJsonToConfig((JSONObject)localObject2);
                  localQueryAppInfoResult.info.desc.isTempApp = ArkAppConfigMgr.isTemplateApp(localQueryAppInfoResult.info.config);
                }
                localQueryAppInfoResult.state = ((JSONObject)localObject1).optInt("state", 0);
                if (localQueryAppInfoResult.state == 0)
                {
                  ENV.logI("ArkApp.ArkAppCGIMgr", "ArkTemp.parserReply_queryAppInfoByAppNameBatch, invalid 'state'");
                  localQueryAppInfoResult.retCode = -1;
                  localQueryAppInfoByAppNameBatchResult.resultList.put(str1, localQueryAppInfoResult);
                }
                else if (localQueryAppInfoResult.state == 1)
                {
                  localObject2 = ((JSONObject)localObject1).optString("ver", null);
                  String str2 = ((JSONObject)localObject1).optString("url", null);
                  String str3 = ((JSONObject)localObject1).optString("sign", null);
                  j = ((JSONObject)localObject1).optInt("updatePeriod", 0);
                  if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)))
                  {
                    ENV.logI("ArkApp.ArkAppCGIMgr", String.format("ArkTemp.parserReply_queryAppInfoByAppNameBatch, invalid app info, app=%s", new Object[] { str1 }));
                  }
                  else
                  {
                    localObject1 = Base64.decode(str3, 0);
                    if ((localObject1 == null) || (localObject1.length == 0))
                    {
                      ENV.logI("ArkApp.ArkAppCGIMgr", String.format("ArkTemp.parserReply_queryAppInfoByAppNameBatch, invalid sign, app=%s", new Object[] { str1 }));
                    }
                    else
                    {
                      localQueryAppInfoResult.info.downloadUrl = str2;
                      localQueryAppInfoResult.info.sign = ((byte[])localObject1);
                      localQueryAppInfoResult.info.updatePeriodByMinutes = j;
                      localQueryAppInfoResult.info.desc.name = str1;
                      localQueryAppInfoResult.info.desc.version = ((String)localObject2);
                    }
                  }
                }
                else
                {
                  localQueryAppInfoByAppNameBatchResult.resultList.put(str1, localQueryAppInfoResult);
                }
              }
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private void runTask(ArkAppCGIMgr.QueryTask paramQueryTask, ArkAppCGIMgr.ITaskHttpResult arg2)
  {
    paramQueryTask.onParseReply = ???;
    synchronized (this.mTaskList)
    {
      this.mTaskList.add(paramQueryTask);
      ArkDispatchTask.getInstance().postToArkThread(new ArkAppCGIMgr.4(this, paramQueryTask));
      return;
    }
  }
  
  /* Error */
  static boolean verifyAppPackage(File paramFile, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 590	java/io/File:exists	()Z
    //   4: istore 4
    //   6: iload 4
    //   8: ifne +58 -> 66
    //   11: iconst_0
    //   12: ifeq +11 -> 23
    //   15: new 592	java/lang/NullPointerException
    //   18: dup
    //   19: invokespecial 593	java/lang/NullPointerException:<init>	()V
    //   22: athrow
    //   23: iconst_0
    //   24: ireturn
    //   25: astore_0
    //   26: getstatic 40	com/tencent/ark/open/ArkAppCGIMgr:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   29: ldc 24
    //   31: new 85	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   38: ldc_w 595
    //   41: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_0
    //   45: invokevirtual 279	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   48: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: iconst_0
    //   55: anewarray 4	java/lang/Object
    //   58: invokestatic 133	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   61: invokevirtual 234	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: iconst_0
    //   65: ireturn
    //   66: new 597	java/io/BufferedInputStream
    //   69: dup
    //   70: new 599	java/io/FileInputStream
    //   73: dup
    //   74: aload_0
    //   75: invokespecial 602	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   78: invokespecial 605	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   81: astore 6
    //   83: aload 6
    //   85: astore 5
    //   87: aload_0
    //   88: invokevirtual 607	java/io/File:length	()J
    //   91: l2i
    //   92: newarray byte
    //   94: astore_0
    //   95: aload 6
    //   97: astore 5
    //   99: aload 6
    //   101: aload_0
    //   102: invokevirtual 611	java/io/BufferedInputStream:read	([B)I
    //   105: istore_3
    //   106: aload 6
    //   108: astore 5
    //   110: aload_0
    //   111: arraylength
    //   112: istore_2
    //   113: iload_3
    //   114: iload_2
    //   115: if_icmpeq +56 -> 171
    //   118: aload 6
    //   120: ifnull -97 -> 23
    //   123: aload 6
    //   125: invokevirtual 614	java/io/BufferedInputStream:close	()V
    //   128: iconst_0
    //   129: ireturn
    //   130: astore_0
    //   131: getstatic 40	com/tencent/ark/open/ArkAppCGIMgr:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   134: ldc 24
    //   136: new 85	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   143: ldc_w 595
    //   146: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_0
    //   150: invokevirtual 279	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   153: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: iconst_0
    //   160: anewarray 4	java/lang/Object
    //   163: invokestatic 133	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   166: invokevirtual 234	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: iconst_0
    //   170: ireturn
    //   171: aload 6
    //   173: astore 5
    //   175: aload_0
    //   176: aload_1
    //   177: invokestatic 337	com/tencent/ark/open/ArkAppCGIMgr:verifyAppPackage	([B[B)Z
    //   180: istore 4
    //   182: aload 6
    //   184: ifnull +8 -> 192
    //   187: aload 6
    //   189: invokevirtual 614	java/io/BufferedInputStream:close	()V
    //   192: iload 4
    //   194: ireturn
    //   195: astore_0
    //   196: getstatic 40	com/tencent/ark/open/ArkAppCGIMgr:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   199: ldc 24
    //   201: new 85	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   208: ldc_w 595
    //   211: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload_0
    //   215: invokevirtual 279	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   218: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: iconst_0
    //   225: anewarray 4	java/lang/Object
    //   228: invokestatic 133	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   231: invokevirtual 234	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   234: goto -42 -> 192
    //   237: astore_1
    //   238: aconst_null
    //   239: astore_0
    //   240: aload_0
    //   241: astore 5
    //   243: getstatic 40	com/tencent/ark/open/ArkAppCGIMgr:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   246: ldc 24
    //   248: new 85	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   255: ldc_w 616
    //   258: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload_1
    //   262: invokevirtual 279	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   265: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: iconst_0
    //   272: anewarray 4	java/lang/Object
    //   275: invokestatic 133	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   278: invokevirtual 234	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   281: aload_0
    //   282: ifnull +7 -> 289
    //   285: aload_0
    //   286: invokevirtual 614	java/io/BufferedInputStream:close	()V
    //   289: iconst_1
    //   290: ireturn
    //   291: astore_0
    //   292: getstatic 40	com/tencent/ark/open/ArkAppCGIMgr:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   295: ldc 24
    //   297: new 85	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   304: ldc_w 595
    //   307: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: aload_0
    //   311: invokevirtual 279	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   314: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: iconst_0
    //   321: anewarray 4	java/lang/Object
    //   324: invokestatic 133	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   327: invokevirtual 234	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   330: goto -41 -> 289
    //   333: astore_0
    //   334: aconst_null
    //   335: astore 5
    //   337: aload 5
    //   339: ifnull +8 -> 347
    //   342: aload 5
    //   344: invokevirtual 614	java/io/BufferedInputStream:close	()V
    //   347: aload_0
    //   348: athrow
    //   349: astore_1
    //   350: getstatic 40	com/tencent/ark/open/ArkAppCGIMgr:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   353: ldc 24
    //   355: new 85	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   362: ldc_w 595
    //   365: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: aload_1
    //   369: invokevirtual 279	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   372: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: iconst_0
    //   379: anewarray 4	java/lang/Object
    //   382: invokestatic 133	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   385: invokevirtual 234	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   388: goto -41 -> 347
    //   391: astore_0
    //   392: goto -55 -> 337
    //   395: astore_1
    //   396: aload 6
    //   398: astore_0
    //   399: goto -159 -> 240
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	402	0	paramFile	File
    //   0	402	1	paramArrayOfByte	byte[]
    //   112	4	2	i	int
    //   105	11	3	j	int
    //   4	189	4	bool	boolean
    //   85	258	5	localObject	Object
    //   81	316	6	localBufferedInputStream	java.io.BufferedInputStream
    // Exception table:
    //   from	to	target	type
    //   15	23	25	java/lang/Exception
    //   123	128	130	java/lang/Exception
    //   187	192	195	java/lang/Exception
    //   0	6	237	java/lang/Exception
    //   66	83	237	java/lang/Exception
    //   285	289	291	java/lang/Exception
    //   0	6	333	finally
    //   66	83	333	finally
    //   342	347	349	java/lang/Exception
    //   87	95	391	finally
    //   99	106	391	finally
    //   110	113	391	finally
    //   175	182	391	finally
    //   243	281	391	finally
    //   87	95	395	java/lang/Exception
    //   99	106	395	java/lang/Exception
    //   110	113	395	java/lang/Exception
    //   175	182	395	java/lang/Exception
  }
  
  static boolean verifyAppPackage(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 == null) {
      return false;
    }
    PublicKey localPublicKey = getArkAppPackagePubliceKey();
    if (localPublicKey == null) {
      return true;
    }
    try
    {
      Signature localSignature = Signature.getInstance("SHA1withRSA");
      localSignature.initVerify(localPublicKey);
      localSignature.update(paramArrayOfByte1);
      boolean bool = localSignature.verify(paramArrayOfByte2);
      ENV.logI("ArkApp.ArkAppCGIMgr", String.format("verifyAppPackage, verify result is " + bool, new Object[0]));
      return bool;
    }
    catch (Exception paramArrayOfByte1)
    {
      ENV.logI("ArkApp.ArkAppCGIMgr", String.format("verifyAppPackage, verify Exception:" + paramArrayOfByte1.getMessage(), new Object[0]));
    }
    return true;
  }
  
  public void downloadAppIcon(String paramString, Object paramObject, ArkAppCGIMgr.ArkAppCGICallback paramArkAppCGICallback)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramArkAppCGICallback != null))
    {
      ENV.logI("ArkApp.ArkAppCGIMgr", String.format("ArkSafe.downloadAppIcon:url=%s", new Object[] { paramString }));
      ArkAppCGIMgr.QueryTask localQueryTask = new ArkAppCGIMgr.QueryTask(null);
      localQueryTask.url = paramString;
      localQueryTask.callback.add(paramArkAppCGICallback);
      localQueryTask.userdata.add(paramObject);
      runTask(localQueryTask, new ArkAppCGIMgr.6(this));
    }
  }
  
  public void downloadAppPackage(String paramString, byte[] paramArrayOfByte, Object paramObject, ArkAppCGIMgr.ArkAppCGICallback paramArkAppCGICallback)
  {
    if (mergeRequestByUrl(paramString, -1L, paramObject, paramArkAppCGICallback)) {
      return;
    }
    ArkAppCGIMgr.QueryTask_DownloadAppPackage localQueryTask_DownloadAppPackage = new ArkAppCGIMgr.QueryTask_DownloadAppPackage(null);
    localQueryTask_DownloadAppPackage.url = paramString;
    localQueryTask_DownloadAppPackage.appSign = paramArrayOfByte;
    localQueryTask_DownloadAppPackage.userdata.add(paramObject);
    localQueryTask_DownloadAppPackage.callback.add(paramArkAppCGICallback);
    runTask(localQueryTask_DownloadAppPackage, new ArkAppCGIMgr.2(this));
  }
  
  public void getPredownloadAppList(String paramString, Object paramObject, ArkAppCGIMgr.ArkAppCGICallback paramArkAppCGICallback)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (mergeRequestByUrl(paramString, -1L, paramObject, paramArkAppCGICallback)) {
      return;
    }
    ArkAppCGIMgr.QueryTask localQueryTask = new ArkAppCGIMgr.QueryTask(null);
    localQueryTask.url = paramString;
    localQueryTask.userdata.add(paramObject);
    localQueryTask.callback.add(paramArkAppCGICallback);
    runTask(localQueryTask, new ArkAppCGIMgr.3(this));
  }
  
  public void queryAppInfoByAppNameBatch(ArrayList<ArkAppCGIMgr.AppNameVersion> paramArrayList, Object paramObject, ArkAppCGIMgr.ArkAppCGICallback paramArkAppCGICallback)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    paramArrayList = getAppUpdateReqString(paramArrayList);
    if (TextUtils.isEmpty(paramArrayList))
    {
      ENV.logI("ArkApp.ArkAppCGIMgr", "queryAppInfoByAppNameBatch, request string is empty");
      return;
    }
    ENV.logI("ArkApp.ArkAppCGIMgr", String.format("ArkTemp.queryAppInfoByAppNameBatch.sso request, req=%s", new Object[] { paramArrayList }));
    IArkDelegateNet localIArkDelegateNet = ArkDelegateManager.getInstance().getNetDelegate();
    if (localIArkDelegateNet != null)
    {
      localIArkDelegateNet.sendAppMsg("ArkAppInfo.QueryAppInfo", paramArrayList, 10000, 0, new ArkAppCGIMgr.1(this, paramArkAppCGICallback, paramObject));
      return;
    }
    ENV.logE("ArkApp.ArkAppCGIMgr", String.format("ArkTemp.queryAppInfoByAppNameBatch. sso request, req=%s", new Object[] { paramArrayList }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppCGIMgr
 * JD-Core Version:    0.7.0.1
 */