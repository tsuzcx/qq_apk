package com.tencent.mobileqq.ark;

import aalv;
import aalw;
import aaly;
import aalz;
import aama;
import aamb;
import aamc;
import aamd;
import aame;
import aamf;
import aamg;
import aamh;
import aami;
import aamj;
import aamk;
import aaml;
import aamm;
import aamn;
import aamo;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.ark.ark;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetEngineFactory;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
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
  implements INetEngine.INetEngineListener
{
  static int jdField_a_of_type_Int;
  private static PublicKey jdField_a_of_type_JavaSecurityPublicKey;
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern;
  private INetEngine jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private final ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  static
  {
    if (!ArkAppCGI.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("Last-Modified[ ]*=[ ]*\\[([^\\[\\]]+)\\]");
      return;
    }
  }
  
  public ArkAppCGI(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = ((NetEngineFactory)paramQQAppInterface.getManager(20)).a(paramQQAppInterface, 0);
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
  
  static long a(String paramString1, String paramString2, ArrayList paramArrayList, JSONArray paramJSONArray)
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
        ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("parseContextActionApp, invalid app info, app=%s, id=%d", new Object[] { str, Long.valueOf(l3) }));
      }
      else
      {
        l2 = l1;
        if (l3 > l1) {
          l2 = l3;
        }
        localObject = new ArkAppInfo.ContextActionAppInfo();
        ((ArkAppInfo.ContextActionAppInfo)localObject).jdField_a_of_type_JavaLangString = paramString1;
        ((ArkAppInfo.ContextActionAppInfo)localObject).jdField_b_of_type_JavaLangString = paramString2;
        ((ArkAppInfo.ContextActionAppInfo)localObject).c = str;
        ((ArkAppInfo.ContextActionAppInfo)localObject).jdField_a_of_type_Long = l3;
        paramArrayList.add(localObject);
        l1 = l2;
      }
    }
  }
  
  private ArkAppCGI.QueryAppInfoByAppNameBatchResult a(String paramString)
  {
    ArkAppCGI.QueryAppInfoByAppNameBatchResult localQueryAppInfoByAppNameBatchResult = new ArkAppCGI.QueryAppInfoByAppNameBatchResult();
    localQueryAppInfoByAppNameBatchResult.jdField_a_of_type_Int = 0;
    if (paramString == null) {
      ArkAppCenter.b("ArkApp.ArkAppCGI", "parserReply_queryAppInfoByAppNameBatch, data is empty");
    }
    for (;;)
    {
      return localQueryAppInfoByAppNameBatchResult;
      Object localObject1;
      try
      {
        paramString = new JSONObject(paramString);
        localObject1 = paramString.optJSONObject("data");
        if (localObject1 == null)
        {
          ArkAppCenter.b("ArkApp.ArkAppCGI", "parserReply_queryAppInfoByAppNameBatch, 'data' not found");
          return localQueryAppInfoByAppNameBatchResult;
        }
      }
      catch (JSONException paramString)
      {
        ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("parserReply_queryAppInfoByAppNameBatch, exception: %s", new Object[] { paramString.getMessage() }));
        return localQueryAppInfoByAppNameBatchResult;
      }
      localQueryAppInfoByAppNameBatchResult.jdField_a_of_type_Int = paramString.optInt("updateInterval", 300);
      localQueryAppInfoByAppNameBatchResult.jdField_a_of_type_Int = Math.max(60, localQueryAppInfoByAppNameBatchResult.jdField_a_of_type_Int);
      paramString = ((JSONObject)localObject1).optJSONArray("apps");
      if (paramString != null)
      {
        int i = 0;
        while (i < paramString.length())
        {
          Object localObject2 = paramString.optJSONObject(i);
          if (localObject2 != null)
          {
            localObject1 = ((JSONObject)localObject2).optString("app");
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              ArkAppCenter.b("ArkApp.ArkAppCGI", "parserReply_queryAppInfoByAppNameBatch, 'app' not found");
            }
            else
            {
              int j = ((JSONObject)localObject2).optInt("ret", -1);
              String str1 = ((JSONObject)localObject2).optString("msg", "");
              ArkAppCGI.QueryAppInfoResult localQueryAppInfoResult;
              if (j != 0)
              {
                localQueryAppInfoResult = new ArkAppCGI.QueryAppInfoResult();
                localQueryAppInfoResult.jdField_a_of_type_Int = j;
                localQueryAppInfoResult.jdField_a_of_type_JavaLangString = str1;
                localQueryAppInfoResult.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDownloadInfo = null;
                localQueryAppInfoByAppNameBatchResult.jdField_a_of_type_JavaUtilHashMap.put(localObject1, localQueryAppInfoResult);
              }
              else
              {
                j = ((JSONObject)localObject2).optInt("state", 0);
                if (j == 0)
                {
                  ArkAppCenter.b("ArkApp.ArkAppCGI", "parserReply_queryAppInfoByAppNameBatch, invalid 'state'");
                  localQueryAppInfoResult = new ArkAppCGI.QueryAppInfoResult();
                  localQueryAppInfoResult.jdField_a_of_type_Int = -1;
                  localQueryAppInfoResult.jdField_a_of_type_JavaLangString = "state error";
                  localQueryAppInfoResult.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDownloadInfo = null;
                  localQueryAppInfoByAppNameBatchResult.jdField_a_of_type_JavaUtilHashMap.put(localObject1, localQueryAppInfoResult);
                }
                else
                {
                  localQueryAppInfoResult = new ArkAppCGI.QueryAppInfoResult();
                  localQueryAppInfoResult.jdField_a_of_type_Int = 0;
                  localQueryAppInfoResult.jdField_a_of_type_JavaLangString = str1;
                  localQueryAppInfoResult.b = j;
                  if (j == 1)
                  {
                    str1 = ((JSONObject)localObject2).optString("ver", null);
                    String str2 = ((JSONObject)localObject2).optString("url", null);
                    String str3 = ((JSONObject)localObject2).optString("sign", null);
                    j = ((JSONObject)localObject2).optInt("updatePeriod", 0);
                    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)))
                    {
                      ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("parserReply_queryAppInfoByAppNameBatch, invalid app info, app=%s", new Object[] { localObject1 }));
                    }
                    else
                    {
                      localObject2 = Base64.decode(str3, 0);
                      if ((localObject2 == null) || (localObject2.length == 0))
                      {
                        ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("parserReply_queryAppInfoByAppNameBatch, invalid sign, app=%s", new Object[] { localObject1 }));
                      }
                      else
                      {
                        localQueryAppInfoResult.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDownloadInfo = new ArkAppInfo.AppDownloadInfo();
                        localQueryAppInfoResult.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDownloadInfo.jdField_a_of_type_JavaLangString = str2;
                        localQueryAppInfoResult.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDownloadInfo.jdField_a_of_type_ArrayOfByte = ((byte[])localObject2);
                        localQueryAppInfoResult.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDownloadInfo.jdField_a_of_type_Int = j;
                        localQueryAppInfoResult.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDownloadInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc = new ArkAppInfo.AppDesc();
                        localQueryAppInfoResult.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDownloadInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.jdField_a_of_type_JavaLangString = ((String)localObject1);
                        localQueryAppInfoResult.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDownloadInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.jdField_b_of_type_JavaLangString = str1;
                      }
                    }
                  }
                  else
                  {
                    localQueryAppInfoByAppNameBatchResult.jdField_a_of_type_JavaUtilHashMap.put(localObject1, localQueryAppInfoResult);
                  }
                }
              }
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private String a(String paramString1, String paramString2, aamo... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new aamo("QQVersion", "7.6.0"));
    localArrayList.add(new aamo("Cmd", paramString1));
    localArrayList.add(new aamo("Ver", paramString2));
    localArrayList.add(new aamo("OS", "android"));
    localArrayList.add(new aamo("Framework", ArkAppCenter.g()));
    localArrayList.add(new aamo("MinFramework", ArkAppCenter.h()));
    paramString1 = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramString1 != null) {
      localArrayList.add(new aamo("Uin", paramString1.c()));
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
        paramVarArgs = (aamo)paramString2.next();
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
  
  private static String a(ArrayList paramArrayList)
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
        ArkAppCGI.AppNameVersion localAppNameVersion = (ArkAppCGI.AppNameVersion)paramArrayList.next();
        if (!TextUtils.isEmpty(localAppNameVersion.jdField_a_of_type_JavaLangString))
        {
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("app", localAppNameVersion.jdField_a_of_type_JavaLangString);
          if (TextUtils.isEmpty(localAppNameVersion.jdField_b_of_type_JavaLangString))
          {
            localJSONObject2.put("ver", "0.0.0.0");
            localJSONArray.put(localJSONObject2);
          }
          else
          {
            localJSONObject2.put("ver", localAppNameVersion.jdField_b_of_type_JavaLangString);
          }
        }
      }
      catch (JSONException paramArrayList)
      {
        ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("getAppUpdateReqString, exception: %s", new Object[] { paramArrayList.getMessage() }));
        return null;
      }
    }
    localJSONObject1.put("apps", localJSONArray);
    paramArrayList = localJSONObject1.toString();
    return paramArrayList;
  }
  
  private String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      ArkAppCenter.b("ArkApp.ArkAppCGI", "parseReply_QueryPackageNameByAppID: replyBuf is empty");
      return null;
    }
    Object localObject;
    try
    {
      paramArrayOfByte = new JSONObject(new String(paramArrayOfByte, "UTF-8"));
      str = paramArrayOfByte.getString("retcode");
      if (!str.equalsIgnoreCase("0"))
      {
        ArkAppCenter.b("ArkApp.ArkAppCGI", "parseReply_QueryPackageNameByAppID, reply fail, ret=" + str);
        return null;
      }
    }
    catch (JSONException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      ArkAppCenter.b("ArkApp.ArkAppCGI", "parseReply_QueryPackageNameByAppID, Json Exception:" + paramArrayOfByte.getMessage());
      return null;
      localObject = paramArrayOfByte.getJSONObject("result");
      paramArrayOfByte = ((JSONObject)localObject).getString("retcode");
      String str = ((JSONObject)localObject).getString("msg");
      localObject = ((JSONObject)localObject).getString("apk_name");
      if ((localObject == null) || (((String)localObject).length() <= 0))
      {
        ArkAppCenter.b("ArkApp.ArkAppCGI", "parseReply_QueryPackageNameByAppID, packageName is empty, retcode=" + paramArrayOfByte + str);
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      ArkAppCenter.b("ArkApp.ArkAppCGI", "parseReply_QueryPackageNameByAppID, Exception:" + paramArrayOfByte.getMessage());
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
    //   3: getstatic 418	com/tencent/mobileqq/ark/ArkAppCGI:jdField_a_of_type_JavaSecurityPublicKey	Ljava/security/PublicKey;
    //   6: ifnull +12 -> 18
    //   9: getstatic 418	com/tencent/mobileqq/ark/ArkAppCGI:jdField_a_of_type_JavaSecurityPublicKey	Ljava/security/PublicKey;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: new 420	java/security/spec/X509EncodedKeySpec
    //   21: dup
    //   22: ldc_w 422
    //   25: iconst_0
    //   26: invokestatic 241	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   29: invokespecial 425	java/security/spec/X509EncodedKeySpec:<init>	([B)V
    //   32: astore_0
    //   33: ldc_w 427
    //   36: invokestatic 433	java/security/KeyFactory:getInstance	(Ljava/lang/String;)Ljava/security/KeyFactory;
    //   39: aload_0
    //   40: invokevirtual 437	java/security/KeyFactory:generatePublic	(Ljava/security/spec/KeySpec;)Ljava/security/PublicKey;
    //   43: putstatic 418	com/tencent/mobileqq/ark/ArkAppCGI:jdField_a_of_type_JavaSecurityPublicKey	Ljava/security/PublicKey;
    //   46: getstatic 418	com/tencent/mobileqq/ark/ArkAppCGI:jdField_a_of_type_JavaSecurityPublicKey	Ljava/security/PublicKey;
    //   49: astore_0
    //   50: goto -37 -> 13
    //   53: astore_0
    //   54: ldc 108
    //   56: new 300	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   63: ldc_w 439
    //   66: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_0
    //   70: invokevirtual 414	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   73: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 345	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 126	com/tencent/mobileqq/ark/ArkAppCenter:b	(Ljava/lang/String;Ljava/lang/String;)V
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
  
  private static JSONArray a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return null;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        ArkAppCGI.ActionAppUpdateInfo localActionAppUpdateInfo = (ArkAppCGI.ActionAppUpdateInfo)paramArrayList.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("action", String.format("%s.%s", new Object[] { localActionAppUpdateInfo.jdField_a_of_type_JavaLangString, localActionAppUpdateInfo.jdField_b_of_type_JavaLangString }));
        localJSONObject.put("appid", localActionAppUpdateInfo.jdField_a_of_type_Long);
        localJSONObject.put("gray_appid", localActionAppUpdateInfo.jdField_b_of_type_Long);
        localJSONArray.put(localJSONObject);
      }
      return localJSONArray;
    }
    catch (Exception paramArrayList)
    {
      ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("_ActionAppUpdateListToJsonObject, fail, msg=%s", new Object[] { paramArrayList.getMessage() }));
      return null;
    }
  }
  
  private void a(aamh paramaamh, aamg arg2)
  {
    paramaamh.jdField_a_of_type_Aamg = ???;
    paramaamh.jdField_a_of_type_JavaIoByteArrayOutputStream = new ByteArrayOutputStream();
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramaamh);
      ??? = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (??? == null)
      {
        ArkAppCenter.b("ArkApp.ArkAppCGI", "runTask_retry, app is null, return");
        return;
      }
    }
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_JavaLangString = paramaamh.jdField_a_of_type_JavaLangString;
    localHttpNetReq.e = 1;
    if (paramaamh.jdField_a_of_type_ArrayOfByte == null) {
      localHttpNetReq.jdField_a_of_type_Int = 0;
    }
    for (;;)
    {
      localHttpNetReq.a(paramaamh);
      localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
      localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
      localHttpNetReq.jdField_c_of_type_Long = 30L;
      localHttpNetReq.jdField_a_of_type_JavaIoOutputStream = paramaamh.jdField_a_of_type_JavaIoByteArrayOutputStream;
      if (paramaamh.jdField_b_of_type_JavaLangString != null) {
        localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Cookie", paramaamh.jdField_b_of_type_JavaLangString);
      }
      if (paramaamh.jdField_a_of_type_Long >= 0L)
      {
        Object localObject = new SimpleDateFormat("E, d MMM y HH:mm:ss 'GMT'", Locale.US);
        ((SimpleDateFormat)localObject).setTimeZone(TimeZone.getTimeZone("GMT"));
        localObject = ((SimpleDateFormat)localObject).format(new Date(paramaamh.jdField_a_of_type_Long));
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("If-Modified-Since", localObject);
        }
      }
      ThreadManager.post(new aamf(this, ???, paramaamh, localHttpNetReq), 5, null, true);
      return;
      localHttpNetReq.jdField_a_of_type_Int = 1;
      localHttpNetReq.jdField_a_of_type_ArrayOfByte = paramaamh.jdField_a_of_type_ArrayOfByte;
    }
  }
  
  private void a(aamh paramaamh, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    new Handler(Looper.getMainLooper()).post(new aaly(this, paramaamh, paramBoolean, paramArrayOfByte));
  }
  
  private void a(aami paramaami, ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    do
    {
      return;
      paramArrayList = a(paramArrayList);
    } while (paramArrayList == null);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("context", paramArrayList);
      paramArrayList = a("CheckContextActionUpdate", (JSONObject)localObject);
      if (paramArrayList == null)
      {
        ArkAppCenter.b("ArkApp.ArkAppCGI", "_addSubTaskForCheckActionAppUpdate, createCmdDataForPostRequest fail.");
        return;
      }
    }
    catch (Exception paramaami)
    {
      ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("_addSubTaskForCheckActionAppUpdate, put 'context' fail, err=%s.", new Object[] { paramaami.getMessage() }));
      return;
    }
    localObject = new aamj(null);
    ((aamj)localObject).jdField_a_of_type_JavaLangString = b();
    ((aamj)localObject).jdField_a_of_type_ArrayOfByte = paramArrayList;
    paramaami.jdField_a_of_type_JavaUtilArrayList.add(localObject);
  }
  
  private void a(aamm paramaamm)
  {
    paramaamm.jdField_a_of_type_JavaLangString = a("QueryContextActionApp", "1", new aamo[] { new aamo("Context", paramaamm.jdField_d_of_type_JavaLangString), new aamo("Action", paramaamm.e), new aamo("AppIDGray", Long.toString(paramaamm.jdField_c_of_type_Long)), new aamo("AppID", Long.toString(paramaamm.jdField_b_of_type_Long)) });
    paramaamm.jdField_a_of_type_Boolean = false;
    b(paramaamm, new aamb(this));
  }
  
  private void a(aamn paramaamn, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    int i;
    label31:
    Object localObject;
    ArkAppCGI.ArkAppCGICallback localArkAppCGICallback;
    if (!paramBoolean)
    {
      ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("onQueryPackageNameByAppID: fail, url=%s", new Object[] { paramaamn.jdField_a_of_type_JavaLangString }));
      paramArrayOfByte = null;
      i = 0;
      if (i >= paramaamn.jdField_b_of_type_JavaUtilArrayList.size()) {
        return;
      }
      localObject = paramaamn.jdField_a_of_type_JavaUtilArrayList.get(i);
      localArkAppCGICallback = (ArkAppCGI.ArkAppCGICallback)paramaamn.jdField_b_of_type_JavaUtilArrayList.get(i);
      if (localArkAppCGICallback != null) {
        if (paramArrayOfByte == null) {
          break label136;
        }
      }
    }
    label136:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localArkAppCGICallback.a(paramBoolean, paramArrayOfByte, paramaamn.jdField_d_of_type_JavaLangString, localObject);
      i += 1;
      break label31;
      paramArrayOfByte = a(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("onQueryPackageNameByAppID: parseReply fail, url=%s", new Object[] { paramaamn.jdField_a_of_type_JavaLangString }));
      }
      break;
    }
  }
  
  private void a(JSONArray paramJSONArray, ArrayList paramArrayList)
  {
    if (paramJSONArray == null)
    {
      ArkAppCenter.b("ArkApp.ArkAppCGI", "parseUpdateAppList, nodeAppList is null");
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
      ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("parseUpdateAppList, node is not string, index=%d", new Object[] { Integer.valueOf(i) }));
    }
    for (;;)
    {
      i += 1;
      break label21;
      break;
      label73:
      if (!ArkLocalAppMgr.a(str)) {
        ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("parseUpdateAppList, invalid app name, index=%d, app=%s", new Object[] { Integer.valueOf(i), str }));
      } else if (paramArrayList.contains(str)) {
        ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("parseUpdateAppList, duplicate app name, index=%d, app=%s", new Object[] { Integer.valueOf(i), str }));
      } else {
        paramArrayList.add(str);
      }
    }
  }
  
  private void a(byte[] paramArrayOfByte, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (paramArrayList1 == null)) {
      ArkAppCenter.b("ArkApp.ArkAppCGI", "parseReply_AppConfig: replyBuf is empty");
    }
    for (;;)
    {
      return;
      paramArrayList1.clear();
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
        if (paramArrayOfByte != null)
        {
          paramArrayOfByte = new JSONObject(paramArrayOfByte);
          if (paramArrayOfByte != null)
          {
            a(paramArrayOfByte.optJSONArray("update_applist"), paramArrayList1);
            b(paramArrayOfByte.optJSONArray("word_dict_list"), paramArrayList2);
            return;
          }
        }
      }
      catch (JSONException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        ArkAppCenter.b("ArkApp.ArkAppCGI", "parseReply_AppConfig, JSONException:" + paramArrayOfByte.getMessage());
        return;
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        ArkAppCenter.b("ArkApp.ArkAppCGI", "parseReply_AppConfig, UnsupportedEncodingException:" + paramArrayOfByte.getMessage());
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
        aamh localaamh = (aamh)localIterator.next();
        if ((localaamh.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString)) && (localaamh.jdField_a_of_type_Long == paramLong))
        {
          localaamh.jdField_a_of_type_JavaUtilArrayList.add(paramObject);
          localaamh.jdField_b_of_type_JavaUtilArrayList.add(paramArkAppCGICallback);
          return true;
        }
      }
      return false;
    }
  }
  
  private byte[] a(String paramString, JSONObject paramJSONObject)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("cmd", paramString);
      paramString = paramJSONObject;
      if (paramJSONObject == null) {
        paramString = new JSONObject();
      }
      paramString.put("os", "android");
      paramJSONObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramJSONObject != null) {
        paramString.put("uin", paramJSONObject.c());
      }
      paramString.put("qq_ver", "7.6.0");
      paramString.put("sdk_ver", ArkAppCenter.g());
      paramString.put("min_sdk_ver", ArkAppCenter.h());
      localJSONObject.put("data", paramString);
      paramString = localJSONObject.toString().getBytes("UTF-8");
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("createCmdDataForPostRequest, fail, msg=%s", new Object[] { paramString.getMessage() }));
        paramString = null;
      }
    }
    return paramString;
  }
  
  private static String b()
  {
    return String.format("http://%s/cgi-bin/arkappcgi?", new Object[] { ArkAppEnvConfig.a().f() });
  }
  
  private void b(aamh paramaamh, aamg arg2)
  {
    paramaamh.jdField_a_of_type_Aamg = ???;
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramaamh);
      ThreadManager.post(new aalw(this, paramaamh), 5, null, true);
      return;
    }
  }
  
  private static void b(aami paramaami, byte[] paramArrayOfByte)
  {
    if ((paramaami == null) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    for (;;)
    {
      return;
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
        if (TextUtils.isEmpty(paramArrayOfByte))
        {
          ArkAppCenter.b("ArkApp.ArkAppCGI", "parseReply_CheckActionAppUpdate, jsonString is empty");
          return;
        }
      }
      catch (Exception paramaami)
      {
        ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("parseReply_CheckActionAppUpdate, exception, msg=%s", new Object[] { paramaami.getMessage() }));
        return;
      }
      int i;
      int j;
      try
      {
        paramArrayOfByte = new JSONObject(paramArrayOfByte);
        if (paramArrayOfByte == null)
        {
          ArkAppCenter.b("ArkApp.ArkAppCGI", "parseReply_CheckActionAppUpdate, json is empty");
          return;
        }
      }
      catch (JSONException paramArrayOfByte)
      {
        for (;;)
        {
          ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("parseReply_CheckActionAppUpdate, exception=%s", new Object[] { paramArrayOfByte.getMessage() }));
          paramArrayOfByte = null;
        }
        i = paramArrayOfByte.optInt("ret", -1);
        if (i != 0)
        {
          ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("parseReply_CheckActionAppUpdate, ret is not 0, ret=%d, msg=%s", new Object[] { Integer.valueOf(i), paramArrayOfByte.optString("msg", "empty msg") }));
          return;
        }
        paramArrayOfByte = paramArrayOfByte.optJSONObject("data");
        if (paramArrayOfByte == null)
        {
          ArkAppCenter.b("ArkApp.ArkAppCGI", "parseReply_CheckActionAppUpdate, 'data' is empty");
          return;
        }
        paramArrayOfByte = paramArrayOfByte.optJSONArray("actions");
        if (paramArrayOfByte == null)
        {
          ArkAppCenter.b("ArkApp.ArkAppCGI", "parseReply_CheckActionAppUpdate, 'actions' is empty");
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
                  paramaami.jdField_b_of_type_JavaUtilArrayList.add(localActionAppUpdateInfo);
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
  
  private void b(JSONArray paramJSONArray, ArrayList paramArrayList)
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
      ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("parseDictList, node is not object, index=%d", new Object[] { Integer.valueOf(i) }));
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
        ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("parseDictList, node is invalid, index=%d", new Object[] { Integer.valueOf(i) }));
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
  
  private static boolean b(aamm paramaamm, byte[] paramArrayOfByte)
  {
    if ((paramaamm == null) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return false;
    }
    Object localObject;
    try
    {
      localObject = new String(paramArrayOfByte, "UTF-8");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("parseReply_GetContextActionAppList, jsonString is empty, bufReplyLen=%d", new Object[] { Integer.valueOf(paramArrayOfByte.length) }));
        return false;
      }
    }
    catch (Exception paramaamm)
    {
      ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("parseReply_GetContextActionAppList, fail, msg=%s", new Object[] { paramaamm.getMessage() }));
      return false;
    }
    try
    {
      paramArrayOfByte = new JSONObject((String)localObject);
      if (paramArrayOfByte == null)
      {
        ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("parseReply_GetContextActionAppList, fail convert string to json, msg=%s", new Object[] { localObject }));
        return false;
      }
    }
    catch (JSONException paramArrayOfByte)
    {
      for (;;)
      {
        ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("parseReply_GetContextActionAppList, fail convert string to json, msg=%s", new Object[] { paramArrayOfByte.getMessage() }));
        paramArrayOfByte = null;
      }
      int i = paramArrayOfByte.optInt("Ret", -1);
      if (i != 0)
      {
        ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("parseReply_GetContextActionAppList, ret != 0, ret=%d", new Object[] { Integer.valueOf(i) }));
        return false;
      }
      paramArrayOfByte = paramArrayOfByte.optJSONObject("Data");
      if (paramArrayOfByte == null)
      {
        ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("parseReply_GetContextActionAppList, 'Data' not exists", new Object[0]));
        return false;
      }
      localObject = paramArrayOfByte.optJSONArray("app");
      paramaamm.jdField_b_of_type_Long = a(paramaamm.jdField_d_of_type_JavaLangString, paramaamm.e, paramaamm.jdField_c_of_type_JavaUtilArrayList, (JSONArray)localObject);
      localObject = paramArrayOfByte.optJSONArray("gray_app");
      paramaamm.jdField_c_of_type_Long = a(paramaamm.jdField_d_of_type_JavaLangString, paramaamm.e, paramaamm.jdField_d_of_type_JavaUtilArrayList, (JSONArray)localObject);
      paramaamm.jdField_a_of_type_Boolean = paramArrayOfByte.optBoolean("more", false);
    }
    return true;
  }
  
  private static String c()
  {
    try
    {
      String str = ArkAppCenter.c() + "/tmp";
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
  
  public void a(aamk paramaamk, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte;
    int i;
    label32:
    ArkAppCGI.ArkAppCGICallback localArkAppCGICallback;
    if (!paramBoolean)
    {
      ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("onDownloadAppPackage: net fail, url=%s", new Object[] { paramaamk.jdField_a_of_type_JavaLangString }));
      arrayOfByte = null;
      i = 0;
      if (i >= paramaamk.jdField_b_of_type_JavaUtilArrayList.size()) {
        return;
      }
      paramArrayOfByte = paramaamk.jdField_a_of_type_JavaUtilArrayList.get(i);
      localArkAppCGICallback = (ArkAppCGI.ArkAppCGICallback)paramaamk.jdField_b_of_type_JavaUtilArrayList.get(i);
      if (localArkAppCGICallback != null) {
        if (arrayOfByte == null) {
          break label148;
        }
      }
    }
    label148:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localArkAppCGICallback.a(paramBoolean, arrayOfByte, paramArrayOfByte);
      i += 1;
      break label32;
      if (paramaamk.jdField_b_of_type_ArrayOfByte != null)
      {
        arrayOfByte = paramArrayOfByte;
        if (a(paramArrayOfByte, paramaamk.jdField_b_of_type_ArrayOfByte)) {
          break;
        }
      }
      ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("onDownloadAppPackage: verifyAppPackage fail, url=%s", new Object[] { paramaamk.jdField_a_of_type_JavaLangString }));
      arrayOfByte = null;
      break;
    }
  }
  
  public void a(aaml paramaaml, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < paramaaml.jdField_b_of_type_JavaUtilArrayList.size())
    {
      ArkAppCGI.ArkAppCGICallback localArkAppCGICallback = (ArkAppCGI.ArkAppCGICallback)paramaaml.jdField_b_of_type_JavaUtilArrayList.get(i);
      if (localArkAppCGICallback != null) {
        localArkAppCGICallback.a(paramBoolean, paramaaml.jdField_a_of_type_Long, paramArrayOfByte);
      }
      i += 1;
    }
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    aamh localaamh = (aamh)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.a();
    boolean bool;
    if (paramNetResp.jdField_a_of_type_Int == 0)
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
        arrayOfByte = localaamh.jdField_a_of_type_JavaIoByteArrayOutputStream.toByteArray();
        if (paramNetResp.c == 304)
        {
          bool = true;
          paramNetResp = (String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("param_rspHeader");
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
          localaamh.jdField_a_of_type_Long = localSimpleDateFormat.parse(paramNetResp).getTime();
          a(localaamh, bool, arrayOfByte);
          return;
          bool = false;
          break;
          localOutOfMemoryError = localOutOfMemoryError;
          ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("ArkAppCGI.onResp, out of memory, msg=%s", new Object[] { localOutOfMemoryError.getMessage() }));
          localObject = null;
          bool = false;
        }
        catch (ParseException paramNetResp)
        {
          ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("lastModified time parse fail, url=%s", new Object[] { localaamh.jdField_a_of_type_JavaLangString }));
          continue;
        }
        continue;
      }
      label202:
      Object localObject = null;
    }
  }
  
  public void a(String paramString, long paramLong, ArkAppCGI.ArkAppCGICallback paramArkAppCGICallback)
  {
    if (a(paramString, paramLong, null, paramArkAppCGICallback)) {
      return;
    }
    aaml localaaml = new aaml(null);
    localaaml.jdField_a_of_type_JavaLangString = paramString;
    localaaml.jdField_a_of_type_Long = paramLong;
    localaaml.jdField_b_of_type_JavaUtilArrayList.add(paramArkAppCGICallback);
    a(localaaml, new aamc(this));
  }
  
  public void a(String paramString, Object paramObject, ArkAppCGI.ArkAppCGICallback paramArkAppCGICallback)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (a(paramString, -1L, paramObject, paramArkAppCGICallback)) {
      return;
    }
    aamh localaamh = new aamh(null);
    localaamh.jdField_a_of_type_JavaLangString = paramString;
    localaamh.jdField_a_of_type_JavaUtilArrayList.add(paramObject);
    localaamh.jdField_b_of_type_JavaUtilArrayList.add(paramArkAppCGICallback);
    b(localaamh, new aame(this));
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, Object paramObject, ArkAppCGI.ArkAppCGICallback paramArkAppCGICallback)
  {
    if (a(paramString, -1L, paramObject, paramArkAppCGICallback)) {
      return;
    }
    aamk localaamk = new aamk(null);
    localaamk.jdField_a_of_type_JavaLangString = paramString;
    localaamk.jdField_b_of_type_ArrayOfByte = paramArrayOfByte;
    localaamk.jdField_a_of_type_JavaUtilArrayList.add(paramObject);
    localaamk.jdField_b_of_type_JavaUtilArrayList.add(paramArkAppCGICallback);
    b(localaamk, new aamd(this));
  }
  
  public void a(ArrayList paramArrayList, Object paramObject, ArkAppCGI.ArkAppCGICallback paramArkAppCGICallback)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
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
        localObject = (ArkAppCenter)((QQAppInterface)localObject).getManager(120);
      } while (localObject == null);
      localObject = ((ArkAppCenter)localObject).a();
    } while (localObject == null);
    paramArrayList = a(paramArrayList);
    if (TextUtils.isEmpty(paramArrayList))
    {
      ArkAppCenter.b("ArkApp.ArkAppCGI", "queryAppInfoByAppNameBatch, request string is empty");
      return;
    }
    ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("queryAppInfoByAppNameBatch, sso request, req=%s", new Object[] { paramArrayList }));
    ((ArkAppSSO)localObject).a("ArkAppInfo.QueryAppInfo", paramArrayList, 10000, 0, new aalv(this, paramArkAppCGICallback, paramObject));
  }
  
  public boolean a(String paramString1, String paramString2, long paramLong1, long paramLong2, Object paramObject, ArkAppCGI.ArkAppCGICallback paramArkAppCGICallback)
  {
    boolean bool = false;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramArkAppCGICallback == null))
    {
      if (!jdField_a_of_type_Boolean) {
        throw new AssertionError();
      }
    }
    else
    {
      aamm localaamm = new aamm(null);
      localaamm.jdField_a_of_type_Boolean = false;
      localaamm.jdField_b_of_type_Long = paramLong2;
      localaamm.jdField_c_of_type_Long = paramLong1;
      localaamm.jdField_d_of_type_JavaLangString = paramString1;
      localaamm.e = paramString2;
      localaamm.jdField_a_of_type_JavaUtilArrayList.add(paramObject);
      localaamm.jdField_b_of_type_JavaUtilArrayList.add(paramArkAppCGICallback);
      a(localaamm);
      bool = true;
    }
    return bool;
  }
  
  public boolean a(ArrayList paramArrayList, Object paramObject, ArkAppCGI.ArkAppCGICallback paramArkAppCGICallback)
  {
    if (paramArrayList.isEmpty())
    {
      if (!jdField_a_of_type_Boolean) {
        throw new AssertionError();
      }
      return false;
    }
    aami localaami = new aami(null);
    localaami.jdField_a_of_type_JavaLangObject = paramObject;
    localaami.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI$ArkAppCGICallback = paramArkAppCGICallback;
    paramObject = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      paramObject.add((ArkAppCGI.ActionAppUpdateInfo)paramArrayList.next());
      if (paramObject.size() >= 20)
      {
        a(localaami, paramObject);
        paramObject.clear();
      }
    }
    if (!paramObject.isEmpty())
    {
      a(localaami, paramObject);
      paramObject.clear();
    }
    if (localaami.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      ArkAppCenter.b("ArkApp.ArkAppCGI", "queryActionAppNeedUpdate, subTask is empty, return.");
      return false;
    }
    paramArrayList = localaami.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramArrayList.hasNext()) {
      a((aamj)paramArrayList.next(), new aama(this, localaami));
    }
    return true;
  }
  
  public boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    PublicKey localPublicKey = a();
    if (localPublicKey == null) {
      return true;
    }
    try
    {
      Signature localSignature = Signature.getInstance("SHA1withRSA");
      localSignature.initVerify(localPublicKey);
      localSignature.update(paramArrayOfByte1);
      boolean bool = localSignature.verify(paramArrayOfByte2);
      return bool;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
      return true;
    }
    catch (Exception paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
    }
    return true;
  }
  
  public void b(String paramString, Object paramObject, ArkAppCGI.ArkAppCGICallback paramArkAppCGICallback)
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
          ArkAppCenter.b("ArkApp.ArkAppCGI", "queryPackageNameByAppID, app is null, return");
          return;
        }
        localObject2 = (TicketManager)((QQAppInterface)localObject1).getManager(2);
        str1 = ((TicketManager)localObject2).getPskey(((QQAppInterface)localObject1).getCurrentAccountUin(), "connect.qq.com");
        if ((str1 != null) && (str1.length() > 0)) {
          break;
        }
        ArkAppCenter.b("ArkApp.ArkAppCGI", "queryPackageNameByAppID, pskey is null, return");
      } while (paramArkAppCGICallback == null);
      paramArkAppCGICallback.a(false, null, paramString, paramObject);
      return;
      localObject2 = ((TicketManager)localObject2).getSkey(((QQAppInterface)localObject1).getCurrentAccountUin());
      str2 = String.format("http://cgi.connect.qq.com/qqconnectwebsite/v2/appinfo/apkname/get?appid=%s&token=%d", new Object[] { paramString, Integer.valueOf(a(str1)) });
    } while (a(str2, -1L, paramObject, paramArkAppCGICallback));
    aamn localaamn = new aamn(null);
    for (Object localObject1 = ((QQAppInterface)localObject1).getCurrentAccountUin(); ((String)localObject1).length() < 10; localObject1 = "0" + (String)localObject1) {}
    localObject1 = "o" + (String)localObject1;
    localaamn.jdField_b_of_type_JavaLangString = ("p_uin=" + (String)localObject1 + "; p_skey=" + str1 + "; uin=" + (String)localObject1 + "; skey=" + (String)localObject2);
    localaamn.jdField_a_of_type_JavaLangString = str2;
    localaamn.jdField_a_of_type_JavaUtilArrayList.add(paramObject);
    localaamn.jdField_b_of_type_JavaUtilArrayList.add(paramArkAppCGICallback);
    localaamn.jdField_d_of_type_JavaLangString = paramString;
    localaamn.c = "http://connect.qq.com";
    b(localaamn, new aalz(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCGI
 * JD-Core Version:    0.7.0.1
 */