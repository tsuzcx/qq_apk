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
    //   53	20	0	localException	java.lang.Exception
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
  
  protected void onDownloadAppPackage(ArkAppCGIMgr.QueryTask_DownloadAppPackage paramQueryTask_DownloadAppPackage, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    int i;
    label34:
    Object localObject;
    ArkAppCGIMgr.ArkAppCGICallback localArkAppCGICallback;
    if (!paramBoolean)
    {
      ENV.logI("ArkApp.ArkAppCGIMgr", String.format("onDownloadAppPackage: net fail, url=%s", new Object[] { paramQueryTask_DownloadAppPackage.url }));
      paramArrayOfByte = null;
      i = 0;
      if (i >= paramQueryTask_DownloadAppPackage.callback.size()) {
        return;
      }
      localObject = paramQueryTask_DownloadAppPackage.userdata.get(i);
      localArkAppCGICallback = (ArkAppCGIMgr.ArkAppCGICallback)paramQueryTask_DownloadAppPackage.callback.get(i);
      if (localArkAppCGICallback != null) {
        if (paramArrayOfByte == null) {
          break label152;
        }
      }
    }
    label152:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localArkAppCGICallback.onDownloadAppPackage(paramBoolean, paramArrayOfByte, localObject);
      i += 1;
      break label34;
      if ((paramQueryTask_DownloadAppPackage.appSign != null) && (verifyAppPackage(paramQueryTask_DownloadAppPackage.rspFile, paramQueryTask_DownloadAppPackage.appSign))) {
        break;
      }
      ENV.logI("ArkApp.ArkAppCGIMgr", String.format("onDownloadAppPackage: verifyAppPackage fail, url=%s", new Object[] { paramQueryTask_DownloadAppPackage.url }));
      paramArrayOfByte = null;
      break;
    }
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
  
  /* Error */
  public boolean verifyAppPackage(File paramFile, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 656	com/tencent/ark/open/ArkAppCGIMgr:getArkAppPackagePubliceKey	()Ljava/security/PublicKey;
    //   3: astore 5
    //   5: aload 5
    //   7: ifnonnull +5 -> 12
    //   10: iconst_1
    //   11: ireturn
    //   12: sipush 1024
    //   15: newarray byte
    //   17: astore 6
    //   19: ldc_w 658
    //   22: invokestatic 663	java/security/Signature:getInstance	(Ljava/lang/String;)Ljava/security/Signature;
    //   25: astore 7
    //   27: aload 7
    //   29: aload 5
    //   31: invokevirtual 667	java/security/Signature:initVerify	(Ljava/security/PublicKey;)V
    //   34: new 669	java/io/BufferedInputStream
    //   37: dup
    //   38: new 671	java/io/FileInputStream
    //   41: dup
    //   42: aload_1
    //   43: invokespecial 674	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   46: invokespecial 677	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   49: astore 5
    //   51: aload 5
    //   53: astore_1
    //   54: aload 5
    //   56: aload 6
    //   58: iconst_0
    //   59: sipush 1024
    //   62: invokevirtual 681	java/io/BufferedInputStream:read	([BII)I
    //   65: istore_3
    //   66: iconst_m1
    //   67: iload_3
    //   68: if_icmpeq +117 -> 185
    //   71: aload 5
    //   73: astore_1
    //   74: aload 7
    //   76: aload 6
    //   78: iconst_0
    //   79: iload_3
    //   80: invokevirtual 685	java/security/Signature:update	([BII)V
    //   83: goto -32 -> 51
    //   86: astore_1
    //   87: aload 5
    //   89: astore_2
    //   90: aload_1
    //   91: astore 5
    //   93: aload_2
    //   94: astore_1
    //   95: getstatic 40	com/tencent/ark/open/ArkAppCGIMgr:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   98: ldc 24
    //   100: new 85	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   107: ldc_w 687
    //   110: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload 5
    //   115: invokevirtual 279	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   118: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: iconst_0
    //   125: anewarray 4	java/lang/Object
    //   128: invokestatic 133	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   131: invokevirtual 234	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: aload_2
    //   135: ifnull -125 -> 10
    //   138: aload_2
    //   139: invokevirtual 690	java/io/BufferedInputStream:close	()V
    //   142: iconst_1
    //   143: ireturn
    //   144: astore_1
    //   145: getstatic 40	com/tencent/ark/open/ArkAppCGIMgr:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   148: ldc 24
    //   150: new 85	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   157: ldc_w 692
    //   160: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_1
    //   164: invokevirtual 279	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   167: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: iconst_0
    //   174: anewarray 4	java/lang/Object
    //   177: invokestatic 133	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   180: invokevirtual 234	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: iconst_1
    //   184: ireturn
    //   185: aload 5
    //   187: astore_1
    //   188: aload 7
    //   190: aload_2
    //   191: invokevirtual 696	java/security/Signature:verify	([B)Z
    //   194: istore 4
    //   196: iload 4
    //   198: ifeq +58 -> 256
    //   201: ldc_w 698
    //   204: astore_2
    //   205: aload 5
    //   207: astore_1
    //   208: getstatic 40	com/tencent/ark/open/ArkAppCGIMgr:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   211: ldc 24
    //   213: new 85	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   220: ldc_w 700
    //   223: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload_2
    //   227: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: iconst_0
    //   234: anewarray 4	java/lang/Object
    //   237: invokestatic 133	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   240: invokevirtual 234	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload 5
    //   245: ifnull +8 -> 253
    //   248: aload 5
    //   250: invokevirtual 690	java/io/BufferedInputStream:close	()V
    //   253: iload 4
    //   255: ireturn
    //   256: ldc_w 702
    //   259: astore_2
    //   260: goto -55 -> 205
    //   263: astore_1
    //   264: getstatic 40	com/tencent/ark/open/ArkAppCGIMgr:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   267: ldc 24
    //   269: new 85	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   276: ldc_w 692
    //   279: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload_1
    //   283: invokevirtual 279	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   286: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: iconst_0
    //   293: anewarray 4	java/lang/Object
    //   296: invokestatic 133	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   299: invokevirtual 234	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   302: goto -49 -> 253
    //   305: astore_2
    //   306: aconst_null
    //   307: astore_1
    //   308: aload_1
    //   309: ifnull +7 -> 316
    //   312: aload_1
    //   313: invokevirtual 690	java/io/BufferedInputStream:close	()V
    //   316: aload_2
    //   317: athrow
    //   318: astore_1
    //   319: getstatic 40	com/tencent/ark/open/ArkAppCGIMgr:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   322: ldc 24
    //   324: new 85	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   331: ldc_w 692
    //   334: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: aload_1
    //   338: invokevirtual 279	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   341: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   347: iconst_0
    //   348: anewarray 4	java/lang/Object
    //   351: invokestatic 133	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   354: invokevirtual 234	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   357: goto -41 -> 316
    //   360: astore_2
    //   361: goto -53 -> 308
    //   364: astore 5
    //   366: aconst_null
    //   367: astore_2
    //   368: goto -275 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	371	0	this	ArkAppCGIMgr
    //   0	371	1	paramFile	File
    //   0	371	2	paramArrayOfByte	byte[]
    //   65	15	3	i	int
    //   194	60	4	bool	boolean
    //   3	246	5	localObject	Object
    //   364	1	5	localException	java.lang.Exception
    //   17	60	6	arrayOfByte	byte[]
    //   25	164	7	localSignature	java.security.Signature
    // Exception table:
    //   from	to	target	type
    //   54	66	86	java/lang/Exception
    //   74	83	86	java/lang/Exception
    //   188	196	86	java/lang/Exception
    //   208	243	86	java/lang/Exception
    //   138	142	144	java/lang/Exception
    //   248	253	263	java/lang/Exception
    //   19	51	305	finally
    //   312	316	318	java/lang/Exception
    //   54	66	360	finally
    //   74	83	360	finally
    //   95	134	360	finally
    //   188	196	360	finally
    //   208	243	360	finally
    //   19	51	364	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppCGIMgr
 * JD-Core Version:    0.7.0.1
 */