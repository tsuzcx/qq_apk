package com.tencent.mobileqq.ark;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.ArkAppInfo.AppDesc;
import com.tencent.ark.open.ArkAppInfo.AppDownloadInfo;
import com.tencent.ark.open.ArkAppInfo.ContextActionAppInfo;
import com.tencent.ark.open.ArkAppInfo.ContextWithMeta;
import com.tencent.ark.open.ArkAppInfo.MetaValue;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetEngineFactory;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.security.PublicKey;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkAppCGI
  implements INetEngineListener
{
  static int jdField_a_of_type_Int;
  private static PublicKey jdField_a_of_type_JavaSecurityPublicKey;
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern;
  private IHttpEngineService jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private final ArrayList<ArkAppCGI.QueryTask> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  static
  {
    if (!ArkAppCGI.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      jdField_a_of_type_Int = 0;
      jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("Last-Modified[ ]*=[ ]*\\[([^\\[\\]]+)\\]");
      return;
    }
  }
  
  public ArkAppCGI(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService == null)
    {
      NetEngineFactory localNetEngineFactory = (NetEngineFactory)paramQQAppInterface.getManager(QQManagerFactory.MGR_NET_ENGINE);
      this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService = ((IHttpEngineService)paramQQAppInterface.getRuntimeService(IHttpEngineService.class, "all"));
    }
  }
  
  private int a(String paramString)
  {
    int j = 5381;
    int i = 0;
    while (i < paramString.length())
    {
      j += (j << 5) + paramString.charAt(i);
      i += 1;
    }
    return 0x7FFFFFFF & j;
  }
  
  static long a(String paramString1, String paramString2, ArrayList<ArkAppInfo.ContextActionAppInfo> paramArrayList, JSONArray paramJSONArray)
  {
    long l2;
    if ((paramArrayList == null) || (paramJSONArray == null)) {
      l2 = 0L;
    }
    int j;
    int i;
    long l1;
    do
    {
      return l2;
      j = paramJSONArray.length();
      i = 0;
      l1 = 0L;
      l2 = l1;
    } while (i >= j);
    Object localObject = paramJSONArray.optJSONObject(i);
    if (localObject == null) {}
    for (;;)
    {
      i += 1;
      break;
      String str = ((JSONObject)localObject).optString("app", "");
      long l3 = ((JSONObject)localObject).optLong("id", 0L);
      if ((TextUtils.isEmpty(str)) || (l3 == 0L))
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("parseContextActionApp, invalid app info, app=%s, id=%d", new Object[] { str, Long.valueOf(l3) }));
      }
      else
      {
        l2 = l1;
        if (l3 > l1) {
          l2 = l3;
        }
        localObject = new ArkAppInfo.ContextActionAppInfo();
        ((ArkAppInfo.ContextActionAppInfo)localObject).context = paramString1;
        ((ArkAppInfo.ContextActionAppInfo)localObject).action = paramString2;
        ((ArkAppInfo.ContextActionAppInfo)localObject).appName = str;
        ((ArkAppInfo.ContextActionAppInfo)localObject).appID = l3;
        paramArrayList.add(localObject);
        l1 = l2;
      }
    }
  }
  
  private ArkAppInfo.ContextWithMeta a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    Object localObject1;
    Object localObject2;
    Object localObject3;
    String str1;
    try
    {
      paramArrayOfByte = new JSONObject(new String(paramArrayOfByte, "UTF-8"));
      localObject1 = paramArrayOfByte.getString("Ret");
      if (!((String)localObject1).equalsIgnoreCase("200"))
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("parseReply_QueryMetaByMessage: fail ret=%s", new Object[] { localObject1 }));
        return null;
      }
      localObject1 = paramArrayOfByte.getJSONObject("Data");
      if (localObject1 == null)
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_QueryMetaByMessage: Data is Empty");
        return null;
      }
      paramArrayOfByte = new ArkAppInfo.ContextWithMeta();
      paramArrayOfByte.context.context = ((JSONObject)localObject1).optString("Context");
      paramArrayOfByte.context.action = ((JSONObject)localObject1).optString("Action");
      localObject2 = ((JSONObject)localObject1).optJSONObject("MetaList");
      if (localObject2 != null)
      {
        localObject3 = ((JSONObject)localObject2).keys();
        while (((Iterator)localObject3).hasNext())
        {
          str1 = (String)((Iterator)localObject3).next();
          String str2 = ((JSONObject)localObject2).optString(str1);
          paramArrayOfByte.meta.metaList.put(str1, str2);
        }
      }
      localObject1 = ((JSONObject)localObject1).optJSONObject("MetaListEx");
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_QueryMetaByMessage: Exception:" + paramArrayOfByte.getMessage());
      return null;
    }
    if (localObject1 != null)
    {
      localObject2 = ((JSONObject)localObject1).keys();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        str1 = ((JSONObject)localObject1).optString((String)localObject3);
        paramArrayOfByte.meta.metaListEx.put(localObject3, str1);
      }
    }
    return paramArrayOfByte;
  }
  
  private ArkAppCGI.QueryAppInfoByAppNameBatchResult a(String paramString)
  {
    ArkAppCGI.QueryAppInfoByAppNameBatchResult localQueryAppInfoByAppNameBatchResult = new ArkAppCGI.QueryAppInfoByAppNameBatchResult();
    localQueryAppInfoByAppNameBatchResult.jdField_a_of_type_Int = 0;
    if (paramString == null) {
      ArkAppCenter.c("ArkApp.ArkAppCGI", "parserReply_queryAppInfoByAppNameBatch, data is empty");
    }
    for (;;)
    {
      return localQueryAppInfoByAppNameBatchResult;
      try
      {
        paramString = new JSONObject(paramString).optJSONObject("data");
        if (paramString == null)
        {
          ArkAppCenter.c("ArkApp.ArkAppCGI", "parserReply_queryAppInfoByAppNameBatch, 'data' not found");
          return localQueryAppInfoByAppNameBatchResult;
        }
      }
      catch (JSONException paramString)
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("ArkTemp.parserReply_queryAppInfoByAppNameBatch, exception: %s", new Object[] { paramString.getMessage() }));
        return localQueryAppInfoByAppNameBatchResult;
      }
      localQueryAppInfoByAppNameBatchResult.jdField_a_of_type_Int = paramString.optInt("updateInterval", 300);
      localQueryAppInfoByAppNameBatchResult.jdField_a_of_type_Int = Math.max(60, localQueryAppInfoByAppNameBatchResult.jdField_a_of_type_Int);
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
              ArkAppCenter.c("ArkApp.ArkAppCGI", "parserReply_queryAppInfoByAppNameBatch, 'app' not found");
            }
            else
            {
              int j = ((JSONObject)localObject1).optInt("ret", -1);
              Object localObject2 = ((JSONObject)localObject1).optString("msg", "");
              ArkAppCGI.QueryAppInfoResult localQueryAppInfoResult;
              if (j != 0)
              {
                localQueryAppInfoResult = new ArkAppCGI.QueryAppInfoResult();
                localQueryAppInfoResult.jdField_a_of_type_Int = j;
                localQueryAppInfoResult.jdField_a_of_type_JavaLangString = ((String)localObject2);
                localQueryAppInfoResult.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo = null;
                localQueryAppInfoByAppNameBatchResult.jdField_a_of_type_JavaUtilHashMap.put(str1, localQueryAppInfoResult);
              }
              else
              {
                localQueryAppInfoResult = new ArkAppCGI.QueryAppInfoResult();
                localQueryAppInfoResult.jdField_a_of_type_Int = 0;
                localQueryAppInfoResult.jdField_a_of_type_JavaLangString = ((String)localObject2);
                localQueryAppInfoResult.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo = new ArkAppInfo.AppDownloadInfo();
                localQueryAppInfoResult.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.desc = new ArkAppInfo.AppDesc();
                localObject2 = ((JSONObject)localObject1).optJSONObject("config");
                if (localObject2 != null)
                {
                  localQueryAppInfoResult.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.config = ArkAppConfigMgr.convertJsonToConfig((JSONObject)localObject2);
                  localQueryAppInfoResult.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.desc.isTempApp = ArkAppConfigMgr.isTemplateApp(localQueryAppInfoResult.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.config);
                }
                localQueryAppInfoResult.b = ((JSONObject)localObject1).optInt("state", 0);
                if (localQueryAppInfoResult.b == 0)
                {
                  ArkAppCenter.c("ArkApp.ArkAppCGI", "ArkTemp.parserReply_queryAppInfoByAppNameBatch, invalid 'state'");
                  localQueryAppInfoResult.jdField_a_of_type_Int = -1;
                  localQueryAppInfoByAppNameBatchResult.jdField_a_of_type_JavaUtilHashMap.put(str1, localQueryAppInfoResult);
                }
                else if (localQueryAppInfoResult.b == 1)
                {
                  localObject2 = ((JSONObject)localObject1).optString("ver", null);
                  String str2 = ((JSONObject)localObject1).optString("url", null);
                  String str3 = ((JSONObject)localObject1).optString("sign", null);
                  j = ((JSONObject)localObject1).optInt("updatePeriod", 0);
                  if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)))
                  {
                    ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("ArkTemp.parserReply_queryAppInfoByAppNameBatch, invalid app info, app=%s", new Object[] { str1 }));
                  }
                  else
                  {
                    localObject1 = Base64.decode(str3, 0);
                    if ((localObject1 == null) || (localObject1.length == 0))
                    {
                      ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("ArkTemp.parserReply_queryAppInfoByAppNameBatch, invalid sign, app=%s", new Object[] { str1 }));
                    }
                    else
                    {
                      localQueryAppInfoResult.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.downloadUrl = str2;
                      localQueryAppInfoResult.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.sign = ((byte[])localObject1);
                      localQueryAppInfoResult.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.updatePeriodByMinutes = j;
                      localQueryAppInfoResult.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.desc.name = str1;
                      localQueryAppInfoResult.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.desc.version = ((String)localObject2);
                    }
                  }
                }
                else
                {
                  localQueryAppInfoByAppNameBatchResult.jdField_a_of_type_JavaUtilHashMap.put(str1, localQueryAppInfoResult);
                }
              }
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private String a(String paramString1, String paramString2, ArkAppCGI.UrlParam... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new ArkAppCGI.UrlParam("QQVersion", "8.5.5"));
    localArrayList.add(new ArkAppCGI.UrlParam("Cmd", paramString1));
    localArrayList.add(new ArkAppCGI.UrlParam("Ver", paramString2));
    localArrayList.add(new ArkAppCGI.UrlParam("OS", "android"));
    localArrayList.add(new ArkAppCGI.UrlParam("Framework", ArkEnvironmentManager.GetSdkVersion()));
    localArrayList.add(new ArkAppCGI.UrlParam("MinFramework", ArkEnvironmentManager.GetMinSdkVersion()));
    paramString1 = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramString1 != null) {
      localArrayList.add(new ArkAppCGI.UrlParam("Uin", paramString1.getCurrentUin()));
    }
    if (paramVarArgs != null)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(paramVarArgs[i]);
        i += 1;
      }
    }
    paramString1 = new StringBuilder();
    paramString1.append(b());
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      paramString2 = localArrayList.iterator();
      while (paramString2.hasNext())
      {
        paramVarArgs = (ArkAppCGI.UrlParam)paramString2.next();
        try
        {
          paramString1.append(paramVarArgs.jdField_a_of_type_JavaLangString);
          paramString1.append('=');
          paramString1.append(URLEncoder.encode(paramVarArgs.jdField_b_of_type_JavaLangString, "UTF-8"));
          paramString1.append('&');
        }
        catch (Exception paramVarArgs)
        {
          paramVarArgs.printStackTrace();
        }
      }
      paramString1.setLength(paramString1.length() - 1);
    }
    return paramString1.toString();
  }
  
  private String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_QueryPackageNameByAppID: replyBuf is empty");
      return null;
    }
    Object localObject;
    try
    {
      paramArrayOfByte = new JSONObject(new String(paramArrayOfByte, "UTF-8"));
      str = paramArrayOfByte.getString("retcode");
      if (!str.equalsIgnoreCase("0"))
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_QueryPackageNameByAppID, reply fail, ret=" + str);
        return null;
      }
    }
    catch (JSONException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_QueryPackageNameByAppID, Json Exception:" + paramArrayOfByte.getMessage());
      return null;
      localObject = paramArrayOfByte.getJSONObject("result");
      paramArrayOfByte = ((JSONObject)localObject).getString("retcode");
      String str = ((JSONObject)localObject).getString("msg");
      localObject = ((JSONObject)localObject).getString("apk_name");
      if ((localObject == null) || (((String)localObject).length() <= 0))
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_QueryPackageNameByAppID, packageName is empty, retcode=" + paramArrayOfByte + str);
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_QueryPackageNameByAppID, Exception:" + paramArrayOfByte.getMessage());
      return null;
    }
    return localObject;
  }
  
  /* Error */
  private static PublicKey a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 479	com/tencent/mobileqq/ark/ArkAppCGI:jdField_a_of_type_JavaSecurityPublicKey	Ljava/security/PublicKey;
    //   6: ifnull +12 -> 18
    //   9: getstatic 479	com/tencent/mobileqq/ark/ArkAppCGI:jdField_a_of_type_JavaSecurityPublicKey	Ljava/security/PublicKey;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: new 481	java/security/spec/X509EncodedKeySpec
    //   21: dup
    //   22: ldc_w 483
    //   25: iconst_0
    //   26: invokestatic 374	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   29: invokespecial 486	java/security/spec/X509EncodedKeySpec:<init>	([B)V
    //   32: astore_0
    //   33: ldc_w 488
    //   36: invokestatic 494	java/security/KeyFactory:getInstance	(Ljava/lang/String;)Ljava/security/KeyFactory;
    //   39: aload_0
    //   40: invokevirtual 498	java/security/KeyFactory:generatePublic	(Ljava/security/spec/KeySpec;)Ljava/security/PublicKey;
    //   43: putstatic 479	com/tencent/mobileqq/ark/ArkAppCGI:jdField_a_of_type_JavaSecurityPublicKey	Ljava/security/PublicKey;
    //   46: getstatic 479	com/tencent/mobileqq/ark/ArkAppCGI:jdField_a_of_type_JavaSecurityPublicKey	Ljava/security/PublicKey;
    //   49: astore_0
    //   50: goto -37 -> 13
    //   53: astore_0
    //   54: ldc 122
    //   56: new 250	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   63: ldc_w 500
    //   66: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_0
    //   70: invokevirtual 261	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   73: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 140	com/tencent/mobileqq/ark/ArkAppCenter:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: goto -36 -> 46
    //   85: astore_0
    //   86: ldc 2
    //   88: monitorexit
    //   89: aload_0
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	38	0	localObject1	Object
    //   53	17	0	localException	Exception
    //   85	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   33	46	53	java/lang/Exception
    //   3	13	85	finally
    //   18	33	85	finally
    //   33	46	85	finally
    //   46	50	85	finally
    //   54	82	85	finally
  }
  
  private void a(ArkAppCGI.QueryTask paramQueryTask, ArkAppCGI.ITaskHttpResult arg2)
  {
    paramQueryTask.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI$ITaskHttpResult = ???;
    paramQueryTask.jdField_a_of_type_JavaIoByteArrayOutputStream = new ByteArrayOutputStream();
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramQueryTask);
      ??? = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (??? == null)
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", "runTask_retry, app is null, return");
        return;
      }
    }
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mReqUrl = paramQueryTask.jdField_a_of_type_JavaLangString;
    localHttpNetReq.mPrioty = 1;
    if (paramQueryTask.jdField_a_of_type_ArrayOfByte == null) {
      localHttpNetReq.mHttpMethod = 0;
    }
    for (;;)
    {
      localHttpNetReq.setUserData(paramQueryTask);
      localHttpNetReq.mReqProperties.put("Accept-Encoding", "identity");
      localHttpNetReq.mCallback = this;
      localHttpNetReq.mExcuteTimeLimit = 30L;
      localHttpNetReq.mOutStream = paramQueryTask.jdField_a_of_type_JavaIoByteArrayOutputStream;
      if (paramQueryTask.jdField_b_of_type_JavaLangString != null) {
        localHttpNetReq.mReqProperties.put("Cookie", paramQueryTask.jdField_b_of_type_JavaLangString);
      }
      if (paramQueryTask.jdField_a_of_type_Long >= 0L)
      {
        Object localObject = new SimpleDateFormat("E, d MMM y HH:mm:ss 'GMT'", Locale.US);
        ((SimpleDateFormat)localObject).setTimeZone(TimeZone.getTimeZone("GMT"));
        localObject = ((SimpleDateFormat)localObject).format(new Date(paramQueryTask.jdField_a_of_type_Long));
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localHttpNetReq.mReqProperties.put("If-Modified-Since", localObject);
        }
      }
      ThreadManager.post(new ArkAppCGI.8(this, ???, paramQueryTask, localHttpNetReq), 5, null, true);
      return;
      localHttpNetReq.mHttpMethod = 1;
      localHttpNetReq.mSendData = paramQueryTask.jdField_a_of_type_ArrayOfByte;
    }
  }
  
  private void a(ArkAppCGI.QueryTask paramQueryTask, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    new Handler(Looper.getMainLooper()).post(new ArkAppCGI.10(this, paramQueryTask, paramBoolean, paramArrayOfByte));
  }
  
  private void a(ArkAppCGI.QueryTask_GetContextActionAppList paramQueryTask_GetContextActionAppList)
  {
    paramQueryTask_GetContextActionAppList.jdField_a_of_type_JavaLangString = a("QueryContextActionApp", "1", new ArkAppCGI.UrlParam[] { new ArkAppCGI.UrlParam("Context", paramQueryTask_GetContextActionAppList.jdField_d_of_type_JavaLangString), new ArkAppCGI.UrlParam("Action", paramQueryTask_GetContextActionAppList.e), new ArkAppCGI.UrlParam("AppIDGray", Long.toString(paramQueryTask_GetContextActionAppList.jdField_c_of_type_Long)), new ArkAppCGI.UrlParam("AppID", Long.toString(paramQueryTask_GetContextActionAppList.b)) });
    paramQueryTask_GetContextActionAppList.jdField_a_of_type_Boolean = false;
    b(paramQueryTask_GetContextActionAppList, new ArkAppCGI.3(this));
  }
  
  private void a(ArkAppCGI.QueryTask_QueryMetaByMessage paramQueryTask_QueryMetaByMessage, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    int i;
    label31:
    Object localObject;
    ArkAppCGI.ArkAppCGICallback localArkAppCGICallback;
    if (!paramBoolean)
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("onQueryMetaByMessage, net fail, url=%s, err=%d, %s", new Object[] { paramQueryTask_QueryMetaByMessage.jdField_a_of_type_JavaLangString }));
      paramArrayOfByte = null;
      i = 0;
      if (i >= paramQueryTask_QueryMetaByMessage.jdField_b_of_type_JavaUtilArrayList.size()) {
        return;
      }
      localObject = paramQueryTask_QueryMetaByMessage.jdField_a_of_type_JavaUtilArrayList.get(i);
      localArkAppCGICallback = (ArkAppCGI.ArkAppCGICallback)paramQueryTask_QueryMetaByMessage.jdField_b_of_type_JavaUtilArrayList.get(i);
      if (localArkAppCGICallback != null) {
        if (paramArrayOfByte == null) {
          break label132;
        }
      }
    }
    label132:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localArkAppCGICallback.a(paramBoolean, paramArrayOfByte, localObject);
      i += 1;
      break label31;
      paramArrayOfByte = a(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("onQueryMetaByMessage, parseReply fail, url=%s", new Object[] { paramQueryTask_QueryMetaByMessage.jdField_a_of_type_JavaLangString }));
      }
      break;
    }
  }
  
  private void a(ArkAppCGI.QueryTask_QueryPackageNameByAppID paramQueryTask_QueryPackageNameByAppID, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    int i;
    label31:
    Object localObject;
    ArkAppCGI.ArkAppCGICallback localArkAppCGICallback;
    if (!paramBoolean)
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("onQueryPackageNameByAppID: fail, url=%s", new Object[] { paramQueryTask_QueryPackageNameByAppID.jdField_a_of_type_JavaLangString }));
      paramArrayOfByte = null;
      i = 0;
      if (i >= paramQueryTask_QueryPackageNameByAppID.jdField_b_of_type_JavaUtilArrayList.size()) {
        return;
      }
      localObject = paramQueryTask_QueryPackageNameByAppID.jdField_a_of_type_JavaUtilArrayList.get(i);
      localArkAppCGICallback = (ArkAppCGI.ArkAppCGICallback)paramQueryTask_QueryPackageNameByAppID.jdField_b_of_type_JavaUtilArrayList.get(i);
      if (localArkAppCGICallback != null) {
        if (paramArrayOfByte == null) {
          break label136;
        }
      }
    }
    label136:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localArkAppCGICallback.a(paramBoolean, paramArrayOfByte, paramQueryTask_QueryPackageNameByAppID.jdField_d_of_type_JavaLangString, localObject);
      i += 1;
      break label31;
      paramArrayOfByte = a(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("onQueryPackageNameByAppID: parseReply fail, url=%s", new Object[] { paramQueryTask_QueryPackageNameByAppID.jdField_a_of_type_JavaLangString }));
      }
      break;
    }
  }
  
  private void a(JSONArray paramJSONArray, ArrayList<String> paramArrayList)
  {
    if (paramJSONArray == null)
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", "parseUpdateAppList, nodeAppList is null");
      return;
    }
    int j = paramJSONArray.length();
    int i = 0;
    label21:
    String str;
    if (i < j)
    {
      str = paramJSONArray.optString(i, "");
      if (!TextUtils.isEmpty(str)) {
        break label73;
      }
      ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("parseUpdateAppList, node is not string, index=%d", new Object[] { Integer.valueOf(i) }));
    }
    for (;;)
    {
      i += 1;
      break label21;
      break;
      label73:
      if (!ArkAppMgr.isValidAppName(str)) {
        ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("parseUpdateAppList, invalid app name, index=%d, app=%s", new Object[] { Integer.valueOf(i), str }));
      } else if (paramArrayList.contains(str)) {
        ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("parseUpdateAppList, duplicate app name, index=%d, app=%s", new Object[] { Integer.valueOf(i), str }));
      } else {
        paramArrayList.add(str);
      }
    }
  }
  
  private void a(byte[] paramArrayOfByte, ArrayList<String> paramArrayList, ArrayList<ArkAppCGI.AIWordDictInfo> paramArrayList1)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (paramArrayList == null)) {
      ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_AppConfig: replyBuf is empty");
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
            a(paramArrayOfByte.optJSONArray("update_applist"), paramArrayList);
            b(paramArrayOfByte.optJSONArray("word_dict_list"), paramArrayList1);
            return;
          }
        }
      }
      catch (JSONException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_AppConfig, JSONException:" + paramArrayOfByte.getMessage());
        return;
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_AppConfig, UnsupportedEncodingException:" + paramArrayOfByte.getMessage());
      }
    }
  }
  
  private boolean a(String paramString, long paramLong, Object paramObject, ArkAppCGI.ArkAppCGICallback paramArkAppCGICallback)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ArkAppCGI.QueryTask localQueryTask = (ArkAppCGI.QueryTask)localIterator.next();
        if ((localQueryTask.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString)) && (localQueryTask.jdField_a_of_type_Long == paramLong))
        {
          localQueryTask.jdField_a_of_type_JavaUtilArrayList.add(paramObject);
          localQueryTask.jdField_b_of_type_JavaUtilArrayList.add(paramArkAppCGICallback);
          return true;
        }
      }
      return false;
    }
  }
  
  private static String b()
  {
    return String.format("https://%s/cgi-bin/arkappcgi?", new Object[] { ArkAppEnvConfig.a().d() });
  }
  
  private void b(ArkAppCGI.QueryTask paramQueryTask, ArkAppCGI.ITaskHttpResult arg2)
  {
    paramQueryTask.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI$ITaskHttpResult = ???;
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramQueryTask);
      ThreadManager.post(new ArkAppCGI.9(this, paramQueryTask), 5, null, true);
      return;
    }
  }
  
  private static void b(ArkAppCGI.QueryTask_CheckActionAppUpdate paramQueryTask_CheckActionAppUpdate, byte[] paramArrayOfByte)
  {
    if ((paramQueryTask_CheckActionAppUpdate == null) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    for (;;)
    {
      return;
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
        if (TextUtils.isEmpty(paramArrayOfByte))
        {
          ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_CheckActionAppUpdate, jsonString is empty");
          return;
        }
      }
      catch (Exception paramQueryTask_CheckActionAppUpdate)
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("parseReply_CheckActionAppUpdate, exception, msg=%s", new Object[] { paramQueryTask_CheckActionAppUpdate.getMessage() }));
        return;
      }
      int i;
      int j;
      try
      {
        paramArrayOfByte = new JSONObject(paramArrayOfByte);
        if (paramArrayOfByte == null)
        {
          ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_CheckActionAppUpdate, json is empty");
          return;
        }
      }
      catch (JSONException paramArrayOfByte)
      {
        for (;;)
        {
          ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("parseReply_CheckActionAppUpdate, exception=%s", new Object[] { paramArrayOfByte.getMessage() }));
          paramArrayOfByte = null;
        }
        i = paramArrayOfByte.optInt("ret", -1);
        if (i != 0)
        {
          ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("parseReply_CheckActionAppUpdate, ret is not 0, ret=%d, msg=%s", new Object[] { Integer.valueOf(i), paramArrayOfByte.optString("msg", "empty msg") }));
          return;
        }
        paramArrayOfByte = paramArrayOfByte.optJSONObject("data");
        if (paramArrayOfByte == null)
        {
          ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_CheckActionAppUpdate, 'data' is empty");
          return;
        }
        paramArrayOfByte = paramArrayOfByte.optJSONArray("actions");
        if (paramArrayOfByte == null)
        {
          ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_CheckActionAppUpdate, 'actions' is empty");
          return;
        }
        j = paramArrayOfByte.length();
        i = 0;
      }
      while (i < j)
      {
        Object localObject = paramArrayOfByte.getJSONObject(i);
        if (localObject != null)
        {
          String str = ((JSONObject)localObject).optString("action", "");
          boolean bool = ((JSONObject)localObject).optBoolean("update", false);
          if (!TextUtils.isEmpty(str))
          {
            int k = str.lastIndexOf('.');
            if (k >= 0)
            {
              localObject = str.substring(0, k);
              str = str.substring(k + 1);
              if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str))) {
                try
                {
                  ArkAppCGI.ActionAppUpdateInfo localActionAppUpdateInfo = new ArkAppCGI.ActionAppUpdateInfo();
                  localActionAppUpdateInfo.jdField_a_of_type_JavaLangString = ((String)localObject);
                  localActionAppUpdateInfo.jdField_b_of_type_JavaLangString = str;
                  localActionAppUpdateInfo.jdField_a_of_type_Boolean = bool;
                  paramQueryTask_CheckActionAppUpdate.jdField_b_of_type_JavaUtilArrayList.add(localActionAppUpdateInfo);
                }
                finally {}
              }
            }
          }
        }
        i += 1;
      }
    }
  }
  
  private void b(JSONArray paramJSONArray, ArrayList<ArkAppCGI.AIWordDictInfo> paramArrayList)
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
        break label60;
      }
      ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("parseDictList, node is not object, index=%d", new Object[] { Integer.valueOf(i) }));
    }
    for (;;)
    {
      i += 1;
      break label13;
      break;
      label60:
      int k = ((JSONObject)localObject).optInt("type", -1);
      String str1 = ((JSONObject)localObject).optString("name", "");
      String str2 = ((JSONObject)localObject).optString("url", "");
      localObject = ((JSONObject)localObject).optString("identifier", "");
      if ((k == -1) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty((CharSequence)localObject)))
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("parseDictList, node is invalid, index=%d", new Object[] { Integer.valueOf(i) }));
      }
      else
      {
        ArkAppCGI.AIWordDictInfo localAIWordDictInfo = new ArkAppCGI.AIWordDictInfo();
        localAIWordDictInfo.jdField_a_of_type_JavaLangString = str1;
        localAIWordDictInfo.jdField_a_of_type_Int = k;
        localAIWordDictInfo.jdField_b_of_type_JavaLangString = str2;
        localAIWordDictInfo.c = ((String)localObject);
        paramArrayList.add(localAIWordDictInfo);
      }
    }
  }
  
  private static boolean b(ArkAppCGI.QueryTask_GetContextActionAppList paramQueryTask_GetContextActionAppList, byte[] paramArrayOfByte)
  {
    if ((paramQueryTask_GetContextActionAppList == null) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return false;
    }
    Object localObject;
    try
    {
      localObject = new String(paramArrayOfByte, "UTF-8");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("parseReply_GetContextActionAppList, jsonString is empty, bufReplyLen=%d", new Object[] { Integer.valueOf(paramArrayOfByte.length) }));
        return false;
      }
    }
    catch (Exception paramQueryTask_GetContextActionAppList)
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("parseReply_GetContextActionAppList, fail, msg=%s", new Object[] { paramQueryTask_GetContextActionAppList.getMessage() }));
      return false;
    }
    try
    {
      paramArrayOfByte = new JSONObject((String)localObject);
      if (paramArrayOfByte == null)
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("parseReply_GetContextActionAppList, fail convert string to json, msg=%s", new Object[] { localObject }));
        return false;
      }
    }
    catch (JSONException paramArrayOfByte)
    {
      for (;;)
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("parseReply_GetContextActionAppList, fail convert string to json, msg=%s", new Object[] { paramArrayOfByte.getMessage() }));
        paramArrayOfByte = null;
      }
      int i = paramArrayOfByte.optInt("Ret", -1);
      if (i != 0)
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("parseReply_GetContextActionAppList, ret != 0, ret=%d", new Object[] { Integer.valueOf(i) }));
        return false;
      }
      paramArrayOfByte = paramArrayOfByte.optJSONObject("Data");
      if (paramArrayOfByte == null)
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("parseReply_GetContextActionAppList, 'Data' not exists", new Object[0]));
        return false;
      }
      localObject = paramArrayOfByte.optJSONArray("app");
      paramQueryTask_GetContextActionAppList.b = a(paramQueryTask_GetContextActionAppList.jdField_d_of_type_JavaLangString, paramQueryTask_GetContextActionAppList.e, paramQueryTask_GetContextActionAppList.jdField_c_of_type_JavaUtilArrayList, (JSONArray)localObject);
      localObject = paramArrayOfByte.optJSONArray("gray_app");
      paramQueryTask_GetContextActionAppList.jdField_c_of_type_Long = a(paramQueryTask_GetContextActionAppList.jdField_d_of_type_JavaLangString, paramQueryTask_GetContextActionAppList.e, paramQueryTask_GetContextActionAppList.jdField_d_of_type_JavaUtilArrayList, (JSONArray)localObject);
      paramQueryTask_GetContextActionAppList.jdField_a_of_type_Boolean = paramArrayOfByte.optBoolean("more", false);
    }
    return true;
  }
  
  private static String c()
  {
    try
    {
      String str = ArkEnvironmentManager.getInstance().getCacheDirectory() + "/tmp";
      new File(str).mkdirs();
      long l = System.currentTimeMillis();
      int i = jdField_a_of_type_Int + 1;
      jdField_a_of_type_Int = i;
      str = String.format("%s/%s", new Object[] { str, String.format("cgi_%d_%d", new Object[] { Long.valueOf(l), Integer.valueOf(i) }) });
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void a(ArkAppCGI.QueryTask_DownloadAppPackage paramQueryTask_DownloadAppPackage, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    int i;
    label31:
    Object localObject;
    ArkAppCGI.ArkAppCGICallback localArkAppCGICallback;
    if (!paramBoolean)
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("onDownloadAppPackage: net fail, url=%s", new Object[] { paramQueryTask_DownloadAppPackage.jdField_a_of_type_JavaLangString }));
      paramArrayOfByte = null;
      i = 0;
      if (i >= paramQueryTask_DownloadAppPackage.jdField_b_of_type_JavaUtilArrayList.size()) {
        return;
      }
      localObject = paramQueryTask_DownloadAppPackage.jdField_a_of_type_JavaUtilArrayList.get(i);
      localArkAppCGICallback = (ArkAppCGI.ArkAppCGICallback)paramQueryTask_DownloadAppPackage.jdField_b_of_type_JavaUtilArrayList.get(i);
      if (localArkAppCGICallback != null) {
        if (paramArrayOfByte == null) {
          break label146;
        }
      }
    }
    label146:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localArkAppCGICallback.a(paramBoolean, paramArrayOfByte, localObject);
      i += 1;
      break label31;
      if ((paramQueryTask_DownloadAppPackage.jdField_b_of_type_ArrayOfByte != null) && (a(paramQueryTask_DownloadAppPackage.jdField_a_of_type_JavaIoFile, paramQueryTask_DownloadAppPackage.jdField_b_of_type_ArrayOfByte))) {
        break;
      }
      ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("onDownloadAppPackage: verifyAppPackage fail, url=%s", new Object[] { paramQueryTask_DownloadAppPackage.jdField_a_of_type_JavaLangString }));
      paramArrayOfByte = null;
      break;
    }
  }
  
  protected void a(ArkAppCGI.QueryTask_DownloadWordData paramQueryTask_DownloadWordData, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < paramQueryTask_DownloadWordData.jdField_b_of_type_JavaUtilArrayList.size())
    {
      ArkAppCGI.ArkAppCGICallback localArkAppCGICallback = (ArkAppCGI.ArkAppCGICallback)paramQueryTask_DownloadWordData.jdField_b_of_type_JavaUtilArrayList.get(i);
      if (localArkAppCGICallback != null) {
        localArkAppCGICallback.a(paramBoolean, paramQueryTask_DownloadWordData.jdField_a_of_type_Long, paramArrayOfByte);
      }
      i += 1;
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      ArkAppCenter.c("ArkApp.ArkAppCGI", "ArkSafe,doReport=null");
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        } while (localObject == null);
        localObject = (ArkAppCenter)((QQAppInterface)localObject).getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER);
      } while (localObject == null);
      localObject = ((ArkAppCenter)localObject).a();
    } while (localObject == null);
    ArkAppCenter.c("ArkApp.ArkAppCGI", "ArkSafe,doReport=" + paramString);
    ((ArkAppSSO)localObject).a("ArkAppReport.URLCheck", paramString, 10000, 0, new ArkAppCGI.14(this));
  }
  
  public void a(String paramString, long paramLong, ArkAppCGI.ArkAppCGICallback paramArkAppCGICallback)
  {
    if (a(paramString, paramLong, null, paramArkAppCGICallback)) {
      return;
    }
    ArkAppCGI.QueryTask_DownloadWordData localQueryTask_DownloadWordData = new ArkAppCGI.QueryTask_DownloadWordData(null);
    localQueryTask_DownloadWordData.jdField_a_of_type_JavaLangString = paramString;
    localQueryTask_DownloadWordData.jdField_a_of_type_Long = paramLong;
    localQueryTask_DownloadWordData.jdField_b_of_type_JavaUtilArrayList.add(paramArkAppCGICallback);
    a(localQueryTask_DownloadWordData, new ArkAppCGI.4(this));
  }
  
  public void a(String paramString, Object paramObject, ArkAppCGI.ArkAppCGICallback paramArkAppCGICallback)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      if (paramArkAppCGICallback != null) {
        paramArkAppCGICallback.a(false, null, paramString, paramObject);
      }
    }
    Object localObject2;
    String str1;
    String str2;
    do
    {
      do
      {
        return;
        localObject1 = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject1 == null)
        {
          ArkAppCenter.c("ArkApp.ArkAppCGI", "queryPackageNameByAppID, app is null, return");
          return;
        }
        localObject2 = (TicketManager)((QQAppInterface)localObject1).getManager(2);
        str1 = ((TicketManager)localObject2).getPskey(((QQAppInterface)localObject1).getCurrentAccountUin(), "connect.qq.com");
        if ((str1 != null) && (str1.length() > 0)) {
          break;
        }
        ArkAppCenter.c("ArkApp.ArkAppCGI", "queryPackageNameByAppID, pskey is null, return");
      } while (paramArkAppCGICallback == null);
      paramArkAppCGICallback.a(false, null, paramString, paramObject);
      return;
      localObject2 = ((TicketManager)localObject2).getSkey(((QQAppInterface)localObject1).getCurrentAccountUin());
      str2 = String.format("https://cgi.connect.qq.com/qqconnectwebsite/v2/appinfo/apkname/get?appid=%s&token=%d", new Object[] { paramString, Integer.valueOf(a(str1)) });
    } while (a(str2, -1L, paramObject, paramArkAppCGICallback));
    ArkAppCGI.QueryTask_QueryPackageNameByAppID localQueryTask_QueryPackageNameByAppID = new ArkAppCGI.QueryTask_QueryPackageNameByAppID(null);
    for (Object localObject1 = ((QQAppInterface)localObject1).getCurrentAccountUin(); ((String)localObject1).length() < 10; localObject1 = "0" + (String)localObject1) {}
    localObject1 = "o" + (String)localObject1;
    localQueryTask_QueryPackageNameByAppID.jdField_b_of_type_JavaLangString = ("p_uin=" + (String)localObject1 + "; p_skey=" + str1 + "; uin=" + (String)localObject1 + "; skey=" + (String)localObject2);
    localQueryTask_QueryPackageNameByAppID.jdField_a_of_type_JavaLangString = str2;
    localQueryTask_QueryPackageNameByAppID.jdField_a_of_type_JavaUtilArrayList.add(paramObject);
    localQueryTask_QueryPackageNameByAppID.jdField_b_of_type_JavaUtilArrayList.add(paramArkAppCGICallback);
    localQueryTask_QueryPackageNameByAppID.jdField_d_of_type_JavaLangString = paramString;
    localQueryTask_QueryPackageNameByAppID.c = "https://connect.qq.com";
    b(localQueryTask_QueryPackageNameByAppID, new ArkAppCGI.11(this));
  }
  
  /* Error */
  public boolean a(File paramFile, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 999	com/tencent/mobileqq/ark/ArkAppCGI:a	()Ljava/security/PublicKey;
    //   3: astore 5
    //   5: aload 5
    //   7: ifnonnull +5 -> 12
    //   10: iconst_1
    //   11: ireturn
    //   12: sipush 1024
    //   15: newarray byte
    //   17: astore 6
    //   19: ldc_w 1001
    //   22: invokestatic 1006	java/security/Signature:getInstance	(Ljava/lang/String;)Ljava/security/Signature;
    //   25: astore 7
    //   27: aload 7
    //   29: aload 5
    //   31: invokevirtual 1010	java/security/Signature:initVerify	(Ljava/security/PublicKey;)V
    //   34: new 1012	java/io/BufferedInputStream
    //   37: dup
    //   38: new 1014	java/io/FileInputStream
    //   41: dup
    //   42: aload_1
    //   43: invokespecial 1017	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   46: invokespecial 1020	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   49: astore 5
    //   51: aload 5
    //   53: astore_1
    //   54: aload 5
    //   56: aload 6
    //   58: iconst_0
    //   59: sipush 1024
    //   62: invokevirtual 1024	java/io/BufferedInputStream:read	([BII)I
    //   65: istore_3
    //   66: iconst_m1
    //   67: iload_3
    //   68: if_icmpeq +111 -> 179
    //   71: aload 5
    //   73: astore_1
    //   74: aload 7
    //   76: aload 6
    //   78: iconst_0
    //   79: iload_3
    //   80: invokevirtual 1027	java/security/Signature:update	([BII)V
    //   83: goto -32 -> 51
    //   86: astore_1
    //   87: aload 5
    //   89: astore_2
    //   90: aload_1
    //   91: astore 5
    //   93: aload_2
    //   94: astore_1
    //   95: ldc 122
    //   97: new 250	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   104: ldc_w 1029
    //   107: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload 5
    //   112: invokevirtual 261	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   115: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: iconst_0
    //   122: anewarray 4	java/lang/Object
    //   125: invokestatic 134	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   128: invokestatic 140	com/tencent/mobileqq/ark/ArkAppCenter:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: aload_2
    //   132: ifnull -122 -> 10
    //   135: aload_2
    //   136: invokevirtual 1032	java/io/BufferedInputStream:close	()V
    //   139: iconst_1
    //   140: ireturn
    //   141: astore_1
    //   142: ldc 122
    //   144: new 250	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   151: ldc_w 1034
    //   154: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_1
    //   158: invokevirtual 261	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   161: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: iconst_0
    //   168: anewarray 4	java/lang/Object
    //   171: invokestatic 134	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   174: invokestatic 140	com/tencent/mobileqq/ark/ArkAppCenter:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   177: iconst_1
    //   178: ireturn
    //   179: aload 5
    //   181: astore_1
    //   182: aload 7
    //   184: aload_2
    //   185: invokevirtual 1038	java/security/Signature:verify	([B)Z
    //   188: istore 4
    //   190: iload 4
    //   192: ifeq +55 -> 247
    //   195: ldc_w 1040
    //   198: astore_2
    //   199: aload 5
    //   201: astore_1
    //   202: ldc 122
    //   204: new 250	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   211: ldc_w 1042
    //   214: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload_2
    //   218: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: iconst_0
    //   225: anewarray 4	java/lang/Object
    //   228: invokestatic 134	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   231: invokestatic 140	com/tencent/mobileqq/ark/ArkAppCenter:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   234: aload 5
    //   236: ifnull +8 -> 244
    //   239: aload 5
    //   241: invokevirtual 1032	java/io/BufferedInputStream:close	()V
    //   244: iload 4
    //   246: ireturn
    //   247: ldc_w 1044
    //   250: astore_2
    //   251: goto -52 -> 199
    //   254: astore_1
    //   255: ldc 122
    //   257: new 250	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   264: ldc_w 1034
    //   267: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: aload_1
    //   271: invokevirtual 261	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   274: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: iconst_0
    //   281: anewarray 4	java/lang/Object
    //   284: invokestatic 134	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   287: invokestatic 140	com/tencent/mobileqq/ark/ArkAppCenter:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   290: goto -46 -> 244
    //   293: astore_2
    //   294: aconst_null
    //   295: astore_1
    //   296: aload_1
    //   297: ifnull +7 -> 304
    //   300: aload_1
    //   301: invokevirtual 1032	java/io/BufferedInputStream:close	()V
    //   304: aload_2
    //   305: athrow
    //   306: astore_1
    //   307: ldc 122
    //   309: new 250	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   316: ldc_w 1034
    //   319: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload_1
    //   323: invokevirtual 261	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   326: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: iconst_0
    //   333: anewarray 4	java/lang/Object
    //   336: invokestatic 134	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   339: invokestatic 140	com/tencent/mobileqq/ark/ArkAppCenter:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   342: goto -38 -> 304
    //   345: astore_2
    //   346: goto -50 -> 296
    //   349: astore 5
    //   351: aconst_null
    //   352: astore_2
    //   353: goto -260 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	356	0	this	ArkAppCGI
    //   0	356	1	paramFile	File
    //   0	356	2	paramArrayOfByte	byte[]
    //   65	15	3	i	int
    //   188	57	4	bool	boolean
    //   3	237	5	localObject	Object
    //   349	1	5	localException	Exception
    //   17	60	6	arrayOfByte	byte[]
    //   25	158	7	localSignature	java.security.Signature
    // Exception table:
    //   from	to	target	type
    //   54	66	86	java/lang/Exception
    //   74	83	86	java/lang/Exception
    //   182	190	86	java/lang/Exception
    //   202	234	86	java/lang/Exception
    //   135	139	141	java/lang/Exception
    //   239	244	254	java/lang/Exception
    //   19	51	293	finally
    //   300	304	306	java/lang/Exception
    //   54	66	345	finally
    //   74	83	345	finally
    //   95	131	345	finally
    //   182	190	345	finally
    //   202	234	345	finally
    //   19	51	349	java/lang/Exception
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      ArkAppCenter.c("ArkApp.ArkAppCGI", "doVipReport()=null");
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        } while (localObject == null);
        localObject = (ArkAppCenter)((QQAppInterface)localObject).getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER);
      } while (localObject == null);
      localObject = ((ArkAppCenter)localObject).a();
    } while (localObject == null);
    ArkAppCenter.c("ArkApp.ArkAppCGI", "doVipReport()=" + paramString);
    ((ArkAppSSO)localObject).a("ArkAppReport.VIPReport", paramString, 10000, 0, new ArkAppCGI.15(this));
  }
  
  public void b(String paramString, long paramLong, ArkAppCGI.ArkAppCGICallback paramArkAppCGICallback)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramArkAppCGICallback == null) || (a(paramString, paramLong, null, paramArkAppCGICallback))) {
      return;
    }
    ArkAppCGI.QueryTask_DownloadWordData localQueryTask_DownloadWordData = new ArkAppCGI.QueryTask_DownloadWordData(null);
    localQueryTask_DownloadWordData.jdField_a_of_type_JavaLangString = paramString;
    localQueryTask_DownloadWordData.jdField_a_of_type_Long = paramLong;
    localQueryTask_DownloadWordData.jdField_b_of_type_JavaUtilArrayList.add(paramArkAppCGICallback);
    a(localQueryTask_DownloadWordData, new ArkAppCGI.12(this));
  }
  
  public void onResp(NetResp paramNetResp)
  {
    ArkAppCGI.QueryTask localQueryTask = (ArkAppCGI.QueryTask)paramNetResp.mReq.getUserData();
    boolean bool;
    if (paramNetResp.mResult == 0)
    {
      bool = true;
      if (!bool) {
        break label202;
      }
    }
    for (;;)
    {
      try
      {
        arrayOfByte = localQueryTask.jdField_a_of_type_JavaIoByteArrayOutputStream.toByteArray();
        if (paramNetResp.mHttpCode == 304)
        {
          bool = true;
          paramNetResp = (String)paramNetResp.mRespProperties.get("param_rspHeader");
          if (!TextUtils.isEmpty(paramNetResp))
          {
            paramNetResp = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramNetResp);
            if (!paramNetResp.find()) {}
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        try
        {
          byte[] arrayOfByte;
          paramNetResp = paramNetResp.group(1);
          SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("E,d MMM y HH:mm:ss 'GMT'", Locale.US);
          localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
          localQueryTask.jdField_a_of_type_Long = localSimpleDateFormat.parse(paramNetResp).getTime();
          a(localQueryTask, bool, arrayOfByte);
          return;
          bool = false;
          break;
          localOutOfMemoryError = localOutOfMemoryError;
          ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("ArkAppCGI.onResp, out of memory, msg=%s", new Object[] { localOutOfMemoryError.getMessage() }));
          localObject = null;
          bool = false;
        }
        catch (ParseException paramNetResp)
        {
          ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("lastModified time parse fail, url=%s", new Object[] { localQueryTask.jdField_a_of_type_JavaLangString }));
          continue;
        }
        continue;
      }
      label202:
      Object localObject = null;
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCGI
 * JD-Core Version:    0.7.0.1
 */