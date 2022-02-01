package com.tencent.biz;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.authorize.AbstractConfig;
import com.tencent.biz.authorize.FlatBuffersConfig;
import com.tencent.biz.authorize.JsonConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.flatbuffers.FlatBuffersParser;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.WVPreloadPskeyConfBean;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.webview.authorize.IAuthorizeConfigDownloadInjector;
import com.tencent.mobileqq.webview.authorize.IAuthorizeConfigInjector;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.mobileqq.webview.util.WebViewConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Set<Ljava.lang.String;>;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.WtTicketPromise;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthorizeConfig
{
  protected static volatile long a;
  protected static final ArrayMap<String, String> a;
  protected static AuthorizeConfig a;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static final List<String> jdField_a_of_type_JavaUtilList;
  static final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  public static final String[] a;
  protected static volatile long b;
  private static final Object jdField_b_of_type_JavaLangObject = new Object();
  private static long e;
  private static long f;
  protected volatile int a;
  final Context jdField_a_of_type_AndroidContentContext;
  final SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  FlatBuffersConfig jdField_a_of_type_ComTencentBizAuthorizeFlatBuffersConfig;
  JsonConfig jdField_a_of_type_ComTencentBizAuthorizeJsonConfig;
  private IAuthorizeConfigDownloadInjector jdField_a_of_type_ComTencentMobileqqWebviewAuthorizeIAuthorizeConfigDownloadInjector;
  private ArrayList<IAuthorizeConfigInjector> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  protected final ConcurrentHashMap<String, JSONArray> a;
  public final AtomicInteger a;
  WtTicketPromise jdField_a_of_type_OicqWlogin_sdkRequestWtTicketPromise = new AuthorizeConfig.3(this);
  protected volatile JSONArray a;
  protected volatile JSONObject a;
  private boolean jdField_a_of_type_Boolean = false;
  private ArrayList<String> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  protected final ConcurrentHashMap<String, Set<String>> b;
  protected volatile JSONArray b;
  protected volatile JSONObject b;
  protected volatile long c;
  protected volatile JSONArray c;
  protected volatile JSONObject c;
  protected volatile long d;
  protected volatile JSONArray d;
  protected volatile JSONObject d;
  protected volatile JSONArray e;
  public volatile JSONObject e;
  protected volatile JSONObject f;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "skey", "pskey", "a1", "a2", "ptlogin2", "pt4_token" };
    jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap(jdField_a_of_type_ArrayOfJavaLangString.length);
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("skey", "[\"*.qq.com\",\"*.tenpay.com\"]");
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("pskey", "[\"game.qq.com\",\"kg.qq.com\",\"id.qq.com\",\"qzone.qq.com\",\"qzone.com\",\"openmobile.qq.com\", \"tenpay.com\", \"buluo.qq.com\", \"docs.qq.com\",\"ti.qq.com\",\"accounts.qq.com\"]");
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("a1", "[]");
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("a2", "[\"aq.qq.com\",\"weloan.tenpay.com\"]");
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("ptlogin2", "[\"http://ptlogin2.qq.com\",\"https://ssl.ptlogin2.qq.com\", \"https://ptlogin2.qq.com\"]");
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("pt4_token", "[\"gamecenter.qq.com\",\"imgcache.qq.com\",\"vip.qq.com\",\"haoma.qq.com\"]");
    jdField_a_of_type_Long = -1L;
    jdField_b_of_type_Long = -1L;
    jdField_a_of_type_JavaUtilList = Arrays.asList(new String[] { "ti.qq.com", "accounts.qq.com", "graph.qq.com" });
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private AuthorizeConfig(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
    this.jdField_a_of_type_Int = -1;
    this.jdField_d_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(jdField_a_of_type_ArrayOfJavaLangString.length);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(jdField_a_of_type_ArrayOfJavaLangString.length);
    if (QLog.isColorLevel()) {
      QLog.d("AuthorizeConfig", 2, "AuthorizeConfig init");
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("domainCmdRight", 4);
    this.jdField_a_of_type_ComTencentBizAuthorizeFlatBuffersConfig = new FlatBuffersConfig(this.jdField_a_of_type_AndroidContentSharedPreferences);
    this.jdField_a_of_type_ComTencentBizAuthorizeJsonConfig = new JsonConfig(this.jdField_a_of_type_AndroidContentSharedPreferences, this.jdField_a_of_type_ComTencentBizAuthorizeFlatBuffersConfig);
    this.jdField_a_of_type_ComTencentBizAuthorizeFlatBuffersConfig.a(this.jdField_a_of_type_ComTencentBizAuthorizeJsonConfig);
    FlatBuffersParser.f();
    l();
    k();
    jdField_e_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("lastPreloadPskey", 0L);
  }
  
  public static AuthorizeConfig a()
  {
    if (jdField_a_of_type_ComTencentBizAuthorizeConfig == null) {
      try
      {
        if (jdField_a_of_type_ComTencentBizAuthorizeConfig == null) {
          jdField_a_of_type_ComTencentBizAuthorizeConfig = new AuthorizeConfig(BaseApplication.getContext());
        }
      }
      finally {}
    }
    jdField_a_of_type_ComTencentBizAuthorizeConfig.a();
    if (!jdField_a_of_type_ComTencentBizAuthorizeConfig.a(true)) {
      jdField_a_of_type_ComTencentBizAuthorizeConfig.i();
    }
    return jdField_a_of_type_ComTencentBizAuthorizeConfig;
  }
  
  public static AuthorizeConfig a(boolean paramBoolean)
  {
    if (jdField_a_of_type_ComTencentBizAuthorizeConfig == null) {
      try
      {
        if (jdField_a_of_type_ComTencentBizAuthorizeConfig == null) {
          jdField_a_of_type_ComTencentBizAuthorizeConfig = new AuthorizeConfig(BaseApplication.getContext());
        }
      }
      finally {}
    }
    jdField_a_of_type_ComTencentBizAuthorizeConfig.a();
    jdField_a_of_type_ComTencentBizAuthorizeConfig.a(paramBoolean);
    return jdField_a_of_type_ComTencentBizAuthorizeConfig;
  }
  
  private static String a(String paramString1, String paramString2, Set<String> paramSet)
  {
    Object localObject1;
    if (!TextUtils.isEmpty(paramString2))
    {
      localObject1 = Uri.parse(paramString2);
      Object localObject2 = ((Uri)localObject1).getScheme();
      if ((!"http".equals(localObject2)) && (!"https".equals(localObject2))) {
        return "";
      }
      if (((Uri)localObject1).isHierarchical())
      {
        localObject1 = ((Uri)localObject1).getHost();
        if (localObject1 != null)
        {
          localObject1 = ((String)localObject1).toLowerCase();
          if (paramSet.contains(localObject1))
          {
            paramSet = (Set<String>)localObject1;
            break label149;
          }
          localObject2 = paramSet.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            paramSet = (String)((Iterator)localObject2).next();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(".");
            localStringBuilder.append(paramSet);
            if (((String)localObject1).endsWith(localStringBuilder.toString())) {
              break label149;
            }
          }
        }
      }
    }
    paramSet = "";
    label149:
    if (QLog.isColorLevel())
    {
      if (!TextUtils.isEmpty(paramSet))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramSet);
        ((StringBuilder)localObject1).append(" need ");
        ((StringBuilder)localObject1).append(paramString1);
        ((StringBuilder)localObject1).append(" which extract from ");
        ((StringBuilder)localObject1).append(paramString2);
        QLog.d("AuthorizeConfig", 2, ((StringBuilder)localObject1).toString());
        return paramSet;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(" not need ");
      ((StringBuilder)localObject1).append(paramString1);
      QLog.d("AuthorizeConfig", 2, ((StringBuilder)localObject1).toString());
    }
    return paramSet;
  }
  
  /* Error */
  public static String a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_1
    //   4: new 312	java/io/ByteArrayOutputStream
    //   7: dup
    //   8: invokespecial 313	java/io/ByteArrayOutputStream:<init>	()V
    //   11: astore_2
    //   12: new 315	java/util/zip/Inflater
    //   15: dup
    //   16: invokespecial 316	java/util/zip/Inflater:<init>	()V
    //   19: astore_1
    //   20: aload_1
    //   21: aload_0
    //   22: invokevirtual 320	java/util/zip/Inflater:setInput	([B)V
    //   25: sipush 1024
    //   28: newarray byte
    //   30: astore_0
    //   31: aload_1
    //   32: invokevirtual 323	java/util/zip/Inflater:finished	()Z
    //   35: ifne +17 -> 52
    //   38: aload_2
    //   39: aload_0
    //   40: iconst_0
    //   41: aload_1
    //   42: aload_0
    //   43: invokevirtual 327	java/util/zip/Inflater:inflate	([B)I
    //   46: invokevirtual 331	java/io/ByteArrayOutputStream:write	([BII)V
    //   49: goto -18 -> 31
    //   52: aload_1
    //   53: invokevirtual 334	java/util/zip/Inflater:end	()V
    //   56: new 40	java/lang/String
    //   59: dup
    //   60: aload_2
    //   61: invokevirtual 338	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   64: invokespecial 340	java/lang/String:<init>	([B)V
    //   67: astore_0
    //   68: aload_2
    //   69: invokevirtual 343	java/io/ByteArrayOutputStream:close	()V
    //   72: aload_0
    //   73: areturn
    //   74: astore_1
    //   75: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   78: ifeq +12 -> 90
    //   81: ldc 153
    //   83: iconst_2
    //   84: ldc 254
    //   86: aload_1
    //   87: invokestatic 346	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   90: aload_0
    //   91: areturn
    //   92: astore_0
    //   93: goto +69 -> 162
    //   96: astore_1
    //   97: aload_2
    //   98: astore_0
    //   99: aload_1
    //   100: astore_2
    //   101: goto +12 -> 113
    //   104: astore_0
    //   105: aload_1
    //   106: astore_2
    //   107: goto +55 -> 162
    //   110: astore_2
    //   111: aload_3
    //   112: astore_0
    //   113: aload_0
    //   114: astore_1
    //   115: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +14 -> 132
    //   121: aload_0
    //   122: astore_1
    //   123: ldc 153
    //   125: iconst_2
    //   126: ldc 254
    //   128: aload_2
    //   129: invokestatic 346	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   132: aload_0
    //   133: ifnull +26 -> 159
    //   136: aload_0
    //   137: invokevirtual 343	java/io/ByteArrayOutputStream:close	()V
    //   140: ldc 254
    //   142: areturn
    //   143: astore_0
    //   144: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +12 -> 159
    //   150: ldc 153
    //   152: iconst_2
    //   153: ldc 254
    //   155: aload_0
    //   156: invokestatic 346	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   159: ldc 254
    //   161: areturn
    //   162: aload_2
    //   163: ifnull +26 -> 189
    //   166: aload_2
    //   167: invokevirtual 343	java/io/ByteArrayOutputStream:close	()V
    //   170: goto +19 -> 189
    //   173: astore_1
    //   174: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   177: ifeq +12 -> 189
    //   180: ldc 153
    //   182: iconst_2
    //   183: ldc 254
    //   185: aload_1
    //   186: invokestatic 346	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   189: goto +5 -> 194
    //   192: aload_0
    //   193: athrow
    //   194: goto -2 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	paramArrayOfByte	byte[]
    //   3	50	1	localInflater	java.util.zip.Inflater
    //   74	13	1	localException1	Exception
    //   96	10	1	localThrowable1	Throwable
    //   114	9	1	arrayOfByte	byte[]
    //   173	13	1	localException2	Exception
    //   11	96	2	localObject1	Object
    //   110	57	2	localThrowable2	Throwable
    //   1	111	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   68	72	74	java/lang/Exception
    //   12	31	92	finally
    //   31	49	92	finally
    //   52	68	92	finally
    //   12	31	96	java/lang/Throwable
    //   31	49	96	java/lang/Throwable
    //   52	68	96	java/lang/Throwable
    //   4	12	104	finally
    //   115	121	104	finally
    //   123	132	104	finally
    //   4	12	110	java/lang/Throwable
    //   136	140	143	java/lang/Exception
    //   166	170	173	java/lang/Exception
  }
  
  private JSONArray a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new JSONArray();
    }
    Object localObject1 = (JSONArray)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject1 == null) {}
    for (;;)
    {
      Object localObject2;
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        localObject2 = (JSONArray)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = this.jdField_a_of_type_ComTencentBizAuthorizeJsonConfig.a(paramString);
          if (localObject2 == null)
          {
            try
            {
              JSONArray localJSONArray = new JSONArray((String)jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(paramString));
              localObject1 = localJSONArray;
              try
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("Load local default config for ");
                ((StringBuilder)localObject1).append(paramString);
                QLog.e("AuthorizeConfig", 2, ((StringBuilder)localObject1).toString());
                localObject1 = localJSONArray;
              }
              catch (JSONException localJSONException3)
              {
                localObject2 = localJSONArray;
              }
              localObject1 = localObject2;
            }
            catch (JSONException localJSONException4) {}
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Decode builtin ");
              ((StringBuilder)localObject1).append(paramString);
              ((StringBuilder)localObject1).append(" config failed ");
              ((StringBuilder)localObject1).append(localJSONException4.getMessage());
              QLog.e("AuthorizeConfig", 2, ((StringBuilder)localObject1).toString());
              localObject1 = localObject2;
            }
          }
          else
          {
            boolean bool = "pskey".equals(paramString);
            if (!bool) {
              break label441;
            }
            Object localObject3 = null;
            int j = 0;
            try
            {
              localObject1 = new JSONArray((String)jdField_a_of_type_AndroidSupportV4UtilArrayMap.get("pskey"));
              try
              {
                i = ((JSONArray)localObject1).length();
              }
              catch (JSONException localJSONException1) {}
              localJSONException2.printStackTrace();
            }
            catch (JSONException localJSONException2)
            {
              localObject1 = localObject3;
            }
            int i = 0;
            if (j < i)
            {
              ((JSONArray)localObject2).put(((JSONArray)localObject1).optString(j));
              j += 1;
              continue;
            }
            if (!QLog.isColorLevel()) {
              break label441;
            }
            QLog.d("AuthorizeConfig", 2, "p_skey need merge server and local config");
            break label441;
          }
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(paramString);
              ((StringBuilder)localObject1).append(" config is null, please check server and local configuration!");
              QLog.e("AuthorizeConfig", 2, ((StringBuilder)localObject1).toString());
            }
            localObject2 = new JSONArray();
          }
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject2);
          this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
          localObject1 = localObject2;
        }
        return localObject1;
      }
      return localObject1;
      label441:
      localObject1 = localObject2;
    }
  }
  
  private JSONObject a()
  {
    JSONObject localJSONObject2 = this.jdField_a_of_type_OrgJsonJSONObject;
    System.currentTimeMillis();
    Object localObject = localJSONObject2;
    if (localJSONObject2 == null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizAuthorizeJsonConfig.a();
      localJSONObject1 = localJSONObject2;
      if (localObject == null) {}
    }
    try
    {
      localJSONObject1 = new JSONObject((String)localObject);
    }
    catch (JSONException localJSONException)
    {
      label41:
      break label41;
    }
    JSONObject localJSONObject1 = localJSONObject2;
    if (QLog.isColorLevel())
    {
      QLog.d("AuthorizeConfig", 2, "Decode mOfflineConfig  error");
      localJSONObject1 = localJSONObject2;
    }
    localObject = localJSONObject1;
    if (localJSONObject1 == null) {
      localObject = new JSONObject();
    }
    return localObject;
  }
  
  private String b(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1.startsWith(paramString2)) {
      str = paramString1.substring(paramString2.length());
    }
    return str;
  }
  
  private JSONObject b()
  {
    Object localObject2 = this.jdField_b_of_type_OrgJsonJSONObject;
    System.currentTimeMillis();
    Object localObject1 = localObject2;
    String str;
    if (localObject2 == null)
    {
      str = this.jdField_a_of_type_ComTencentBizAuthorizeJsonConfig.b();
      localObject1 = localObject2;
      if (str == null) {}
    }
    try
    {
      localObject1 = new JSONObject(str);
    }
    catch (JSONException localJSONException)
    {
      label41:
      break label41;
    }
    localObject1 = localObject2;
    if (QLog.isColorLevel())
    {
      QLog.d("AuthorizeConfig", 2, "Decode mExtraConfig error");
      localObject1 = localObject2;
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new JSONObject();
    }
    this.jdField_b_of_type_OrgJsonJSONObject = ((JSONObject)localObject2);
    localObject1 = localObject2;
    return localObject1;
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    boolean bool2 = TextUtils.isEmpty(paramString1);
    boolean bool1 = false;
    if (!bool2)
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      if ("*".equals(paramString1)) {
        return true;
      }
      if ("*.*".equals(paramString1))
      {
        if (paramString2.indexOf('.') != -1) {
          bool1 = true;
        }
        return bool1;
      }
      if (paramString1.startsWith("*")) {
        return paramString2.endsWith(paramString1.substring(1));
      }
      if (paramString1.endsWith("*")) {
        return paramString2.startsWith(paramString1.substring(0, paramString1.length() - 1));
      }
      return paramString2.equals(paramString1);
    }
    return false;
  }
  
  private boolean f()
  {
    for (;;)
    {
      boolean bool;
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
      {
        i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
        bool = false;
        if (i == 1) {
          return false;
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3) {
          return true;
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != -1) {
          break label125;
        }
        if (MobileQQ.sProcessId == 1)
        {
          i = 1;
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
          long l = System.currentTimeMillis() - jdField_b_of_type_Long;
          if (l < 0L) {
            break label135;
          }
          if (l < 1800000L) {
            break label130;
          }
          break label135;
          return bool;
        }
      }
      int i = 0;
      continue;
      label125:
      i = 0;
      continue;
      label130:
      int j = 0;
      break label137;
      label135:
      j = 1;
      label137:
      if ((i != 0) || (j != 0)) {
        bool = true;
      }
    }
  }
  
  private boolean g()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((IAuthorizeConfigInjector)localIterator.next()).a()) {
        return true;
      }
    }
    return false;
  }
  
  private void l()
  {
    try
    {
      if (AuthorizeConfigInjectUtil.jdField_a_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = AuthorizeConfigInjectUtil.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          IAuthorizeConfigInjector localIAuthorizeConfigInjector = (IAuthorizeConfigInjector)((Class)localIterator.next()).newInstance();
          this.jdField_a_of_type_JavaUtilArrayList.add(localIAuthorizeConfigInjector);
        }
      }
      if ((AuthorizeConfigInjectUtil.jdField_b_of_type_JavaUtilArrayList != null) && (AuthorizeConfigInjectUtil.jdField_b_of_type_JavaUtilArrayList.size() > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewAuthorizeIAuthorizeConfigDownloadInjector = ((IAuthorizeConfigDownloadInjector)((Class)AuthorizeConfigInjectUtil.jdField_b_of_type_JavaUtilArrayList.get(0)).newInstance());
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AuthorizeConfig", 1, "initBusinessInjetor Fail,", localThrowable);
    }
  }
  
  public int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    paramString = paramString.split("\\?");
    JSONObject localJSONObject = a();
    if (localJSONObject.has(paramString[0])) {
      try
      {
        int i = localJSONObject.getJSONObject(paramString[0]).getInt("delay");
        return i;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("AuthorizeConfig", 2, "getCheckUpDelayTime error");
        }
      }
    }
    return 0;
  }
  
  public long a()
  {
    if (-1L == this.jdField_d_of_type_Long) {
      this.jdField_d_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("publishSeq", 0L);
    }
    return this.jdField_d_of_type_Long;
  }
  
  public Boolean a(String paramString1, String paramString2)
  {
    Object localObject1 = paramString1;
    int j = 0;
    Boolean localBoolean = Boolean.valueOf(false);
    if (localObject1 == null) {
      return localBoolean;
    }
    Object localObject2 = Uri.parse(paramString1);
    String str2 = ((Uri)localObject2).getScheme();
    if ("file".equals(str2))
    {
      localObject2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
      paramString2 = (String)localObject1;
      if (paramString1.length() > 200) {
        paramString2 = ((String)localObject1).substring(0, 200);
      }
      ReportController.b((AppRuntime)localObject2, "dc00899", "Grp_tech_report", "", "webview", "file_jump", 0, 0, paramString2, "", "", "");
      QLog.e("AuthorizeConfig", 1, "action deprecated with file protocol");
      return localBoolean;
    }
    if ((!"http".equals(str2)) && (!"https".equals(str2))) {
      return localBoolean;
    }
    paramString1 = ((Uri)localObject2).getHost();
    localObject2 = paramString1;
    if (!TextUtils.isEmpty(paramString1)) {
      localObject2 = paramString1.toLowerCase();
    }
    localObject1 = this.jdField_c_of_type_OrgJsonJSONObject;
    System.currentTimeMillis();
    paramString1 = (String)localObject1;
    if (localObject1 == null)
    {
      str2 = this.jdField_a_of_type_ComTencentBizAuthorizeJsonConfig.c();
      paramString1 = (String)localObject1;
      if (str2 == null) {}
    }
    try
    {
      paramString1 = new JSONObject(str2);
    }
    catch (JSONException paramString1)
    {
      try
      {
        localObject1 = new JSONObject("{\"host\": [\"*.qq.com\",\"*.tenpay.com\"]}");
        this.jdField_c_of_type_OrgJsonJSONObject = ((JSONObject)localObject1);
        paramString1 = (String)localObject1;
        try
        {
          localObject1 = paramString1.getJSONArray("host");
          k = ((JSONArray)localObject1).length();
          i = 0;
          while (i < k)
          {
            if (b(((JSONArray)localObject1).optString(i), (String)localObject2)) {
              return Boolean.valueOf(true);
            }
            i += 1;
          }
        }
        catch (JSONException localJSONException2)
        {
          int k;
          int i;
          label308:
          label326:
          label357:
          label374:
          String str1;
          break label308;
        }
        try
        {
          localObject1 = paramString1.getJSONArray("scheme");
          k = ((JSONArray)localObject1).length();
          i = 0;
          if (i < k)
          {
            if (((JSONArray)localObject1).optString(i).equals(paramString2)) {
              return Boolean.valueOf(true);
            }
            i += 1;
            break label326;
          }
        }
        catch (JSONException localJSONException3)
        {
          break label357;
        }
        try
        {
          paramString1 = paramString1.getJSONArray("scheme_a");
          k = paramString1.length();
          i = j;
          if (i < k)
          {
            if (paramString1.optString(i).equals(paramString2)) {
              return Boolean.valueOf(true);
            }
            i += 1;
            break label374;
          }
          return localBoolean;
        }
        catch (JSONException paramString1) {}
        paramString1 = paramString1;
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          str1 = paramString1;
        }
      }
    }
    paramString1 = (String)localObject1;
    if (QLog.isColorLevel())
    {
      QLog.d("AuthorizeConfig", 2, "Decode mJumpConfig error");
      paramString1 = (String)localObject1;
    }
    localObject1 = paramString1;
    if (paramString1 == null) {}
    return localBoolean;
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = paramString.split("\\?");
    JSONObject localJSONObject = a();
    if (localJSONObject.has(paramString[0])) {
      try
      {
        paramString = localJSONObject.getJSONObject(paramString[0]).getString("bid");
        return paramString;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("AuthorizeConfig", 2, "getOfflineId error");
        }
      }
    }
    return null;
  }
  
  public String a(String paramString1, String paramString2)
  {
    return b().optString(paramString1, paramString2);
  }
  
  public Set<String> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new HashSet();
    }
    Object localObject1 = (Set)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject1 == null) {}
    for (;;)
    {
      int i;
      synchronized (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        Object localObject2 = (Set)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = new HashSet(32);
          localObject1 = a(paramString);
          if ((localObject1 != null) && (((JSONArray)localObject1).length() != 0))
          {
            int j = ((JSONArray)localObject1).length();
            i = 0;
            if (i < j)
            {
              if ("skey".equals(paramString))
              {
                ((Set)localObject2).add(b(((JSONArray)localObject1).optString(i, ""), "*."));
                break label246;
              }
              ((Set)localObject2).add(((JSONArray)localObject1).optString(i, ""));
              break label246;
            }
          }
          this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject2);
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramString);
            ((StringBuilder)localObject1).append(" domain white list: ");
            ((StringBuilder)localObject1).append(localObject2);
            QLog.d("AuthorizeConfig", 2, ((StringBuilder)localObject1).toString());
            localObject1 = localObject2;
          }
        }
        return localObject1;
      }
      return localObject1;
      label246:
      i += 1;
    }
  }
  
  protected void a()
  {
    ThreadManager.executeOnSubThread(new AuthorizeConfig.1(this));
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    System.currentTimeMillis();
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    if (FlatBuffersParser.a()) {
      paramString1 = this.jdField_a_of_type_ComTencentBizAuthorizeFlatBuffersConfig.a(localEditor, paramString1);
    } else {
      paramString1 = this.jdField_a_of_type_ComTencentBizAuthorizeJsonConfig.a(localEditor, paramString1);
    }
    if (paramString1 == null) {
      return;
    }
    long l = this.jdField_d_of_type_Long;
    this.jdField_d_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("publishSeq", this.jdField_d_of_type_Long);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("update white list's publishSeq from ");
    localStringBuilder.append(l);
    localStringBuilder.append(" to ");
    localStringBuilder.append(this.jdField_d_of_type_Long);
    localStringBuilder.append(".");
    QLog.i("AuthorizeConfig", 1, localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString1))
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
      localEditor.putLong("lastUpdate", System.currentTimeMillis());
      localEditor.putString("qqVersion", "2013 8.7.0");
      localEditor.putString(paramString3, paramString2);
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("White list update completed as version=");
        paramString1.append(paramString2);
        QLog.d("AuthorizeConfig", 2, paramString1.toString());
      }
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "webview_whitelist", "update_ok", 0, 1, 0, "", "", "", "");
    }
    else
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "webview_whitelist", "update_failed", 0, 1, 0, "", "", "", "");
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("Authorize config parse failed include: ");
        paramString2.append(paramString1);
        QLog.e("AuthorizeConfig", 2, paramString2.toString());
      }
    }
    localEditor.commit();
    g();
    i();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public boolean a()
  {
    String str = WebCgiWhiteListManager.a();
    if (!TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("CgiConfig sp content: ");
        localStringBuilder.append(str);
        QLog.d("AuthorizeConfig", 2, localStringBuilder.toString());
      }
      try
      {
        this.jdField_a_of_type_OrgJsonJSONArray = new JSONArray(str);
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isColorLevel()) {
          break label124;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CgiConfig load exception: ");
      localStringBuilder.append(localJSONException.getMessage());
      QLog.d("AuthorizeConfig", 2, localStringBuilder.toString());
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("AuthorizeConfig", 2, "CgiConfig sp content empty!");
    }
    label124:
    return this.jdField_a_of_type_OrgJsonJSONArray != null;
  }
  
  public boolean a(String paramString)
  {
    Object localObject = Uri.parse(paramString).getScheme();
    if ((!"http".equals(localObject)) && (!"https".equals(localObject))) {
      return false;
    }
    localObject = Uri.parse(paramString).getHost();
    paramString = (String)localObject;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramString = ((String)localObject).toLowerCase();
    }
    localObject = a("skey");
    int j = ((JSONArray)localObject).length();
    int i = 0;
    while (i < j)
    {
      if (b(((JSONArray)localObject).optString(i), paramString)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    String str1 = paramString1;
    if (str1 == null) {
      return false;
    }
    Object localObject = Uri.parse(paramString1);
    String str2 = ((Uri)localObject).getScheme();
    if ("file".equals(str2))
    {
      localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
      paramString2 = str1;
      if (paramString1.length() > 200) {
        paramString2 = str1.substring(0, 200);
      }
      ReportController.b((AppRuntime)localObject, "dc00899", "Grp_tech_report", "", "webview", "file_js", 0, 0, paramString2, "", "", "");
      QLog.e("AuthorizeConfig", 1, "action deprecated with file protocol");
      return false;
    }
    if ((!"http".equals(str2)) && (!"https".equals(str2))) {
      return false;
    }
    if ("data.checkPermission".equals(paramString2)) {
      return str1.startsWith("https://qqweb.qq.com/m/whitelist/testing/");
    }
    if (paramString2.startsWith("CAPTCHA.")) {
      return true;
    }
    if ((paramString2.startsWith("login.openSmsPage")) && ("ti.qq.com".equals(((Uri)localObject).getHost()))) {
      return true;
    }
    if ("identification.loginVerify".equals(paramString2)) {
      return true;
    }
    if (("identification.identifyNoLogin".equals(paramString2)) && (jdField_a_of_type_JavaUtilList.contains(((Uri)localObject).getHost()))) {
      return true;
    }
    if ("faceUnblockCamera.startPTVActivity".equals(paramString2)) {
      return true;
    }
    if (("qbizApi.getClientInfo".equals(paramString2)) && (str1.startsWith("https://mysec.qq.com/v2/account_control/index.html"))) {
      return true;
    }
    System.currentTimeMillis();
    int i = this.jdField_a_of_type_ComTencentBizAuthorizeJsonConfig.a(((Uri)localObject).getHost(), paramString2);
    if (AbstractConfig.a(i)) {
      return true;
    }
    if (AbstractConfig.b(i)) {
      return false;
    }
    paramString1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramString1.hasNext()) {
      if (((IAuthorizeConfigInjector)paramString1.next()).a(str1, paramString2)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    return SwiftWebViewUtils.a(paramJSONObject, "sonicWhiteList");
  }
  
  protected boolean a(boolean paramBoolean)
  {
    if (f())
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
      ThreadManager.executeOnNetWorkThread(new AuthorizeConfig.2(this, paramBoolean));
      return true;
    }
    return false;
  }
  
  public String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = paramString.split("\\?");
    JSONObject localJSONObject = a();
    if (localJSONObject.has(paramString[0])) {
      try
      {
        paramString = localJSONObject.getJSONObject(paramString[0]).getString("duck");
        return paramString;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("AuthorizeConfig", 2, "getCheckUpType error");
        }
      }
    }
    return null;
  }
  
  public void b()
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.remove("lastVersion");
    localEditor.commit();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
    a(false);
  }
  
  public boolean b()
  {
    String str = WebCgiWhiteListManager.b();
    if (!TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("AsyncCheckConfig sp content: ");
        localStringBuilder.append(str);
        QLog.d("AuthorizeConfig", 2, localStringBuilder.toString());
      }
      try
      {
        this.jdField_b_of_type_OrgJsonJSONArray = new JSONArray(str);
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isColorLevel()) {
          break label124;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AsyncCheckConfig load exception: ");
      localStringBuilder.append(localJSONException.getMessage());
      QLog.d("AuthorizeConfig", 2, localStringBuilder.toString());
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("AuthorizeConfig", 2, "AsyncCheckConfig sp content empty!");
    }
    label124:
    return this.jdField_b_of_type_OrgJsonJSONArray != null;
  }
  
  public boolean b(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        boolean bool = TextUtils.isEmpty(paramString);
        if (!bool)
        {
          if ((this.jdField_a_of_type_OrgJsonJSONArray == null) && (!a()))
          {
            if (!QLog.isColorLevel()) {
              break label287;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("CgiConfig loadfromsp fail , url: ");
            ((StringBuilder)localObject1).append(Util.b(paramString, new String[0]));
            QLog.d("AuthorizeConfig", 2, ((StringBuilder)localObject1).toString());
            return false;
          }
          Object localObject1 = Uri.parse(paramString).getHost();
          if ((this.jdField_a_of_type_OrgJsonJSONArray.length() != 0) && (!TextUtils.isEmpty((CharSequence)localObject1)))
          {
            Object localObject2 = ((String)localObject1).toLowerCase();
            int j = this.jdField_a_of_type_OrgJsonJSONArray.length();
            i = 0;
            if (i < j)
            {
              localObject1 = this.jdField_a_of_type_OrgJsonJSONArray.optString(i, "");
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                break label291;
              }
              if (!TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject1))
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(".");
                localStringBuilder.append((String)localObject1);
                if (!((String)localObject2).endsWith(localStringBuilder.toString())) {
                  break label291;
                }
              }
              if (!QLog.isColorLevel()) {
                break label289;
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("CgiConfig hit , url: ");
              ((StringBuilder)localObject2).append(Util.b(paramString, new String[0]));
              ((StringBuilder)localObject2).append(" domain: ");
              ((StringBuilder)localObject2).append((String)localObject1);
              QLog.d("AuthorizeConfig", 2, ((StringBuilder)localObject2).toString());
              break label289;
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "CgiConfig check fail , url empty!");
          return false;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      return false;
      label287:
      return false;
      label289:
      return true;
      label291:
      i += 1;
    }
  }
  
  public String c(String paramString)
  {
    return a("p_skey", paramString, a("pskey"));
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AuthorizeConfig", 2, "readAndSaveX5Config from VasQuickUpdateManager.SCID_FUNCDEV_WEBVIEW.");
    }
    Object localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    Object localObject2 = VasUpdateUtil.a((AppRuntime)localObject1, "VASBiz_FuncDev_webview.json", false, null);
    if ((localObject2 != null) && (localObject1 != null) && (((AppRuntime)localObject1).isLogin()))
    {
      Object localObject3;
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("receive X5Config data: ");
        ((StringBuilder)localObject3).append(((JSONObject)localObject2).toString());
        QLog.i("AuthorizeConfig", 2, ((StringBuilder)localObject3).toString());
      }
      localObject2 = ((JSONObject)localObject2).optJSONArray("vipGrayConfig2");
      if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
      {
        int i = 0;
        boolean bool1 = true;
        boolean bool2;
        for (boolean bool3 = true; i < ((JSONArray)localObject2).length(); bool3 = bool2)
        {
          localObject3 = ((JSONArray)localObject2).optJSONObject(i);
          boolean bool4 = bool1;
          bool2 = bool3;
          if (localObject3 != null)
          {
            if (SwiftWebViewUtils.a((JSONObject)localObject3, "X5Config")) {
              if (((JSONObject)localObject3).optInt("mainThreadControl", 0) == 0) {
                bool1 = true;
              } else {
                bool1 = false;
              }
            }
            bool4 = bool1;
            bool2 = bool3;
            if (SwiftWebViewUtils.a((JSONObject)localObject3, "X5Config")) {
              if (((JSONObject)localObject3).optInt("enableQuic", 1) == 1)
              {
                bool2 = true;
                bool4 = bool1;
              }
              else
              {
                bool2 = false;
                bool4 = bool1;
              }
            }
          }
          i += 1;
          bool1 = bool4;
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("readAndSaveX5Config isInitOnSubThread : ");
          ((StringBuilder)localObject2).append(bool1);
          ((StringBuilder)localObject2).append(", enable quick: ");
          ((StringBuilder)localObject2).append(bool3);
          QLog.i("AuthorizeConfig", 2, ((StringBuilder)localObject2).toString());
        }
        localObject2 = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
        localObject1 = ((AppRuntime)localObject1).getApplication();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("sp_x5_config_");
        ((StringBuilder)localObject3).append((String)localObject2);
        localObject1 = ((MobileQQ)localObject1).getSharedPreferences(((StringBuilder)localObject3).toString(), 4).edit();
        ((SharedPreferences.Editor)localObject1).putBoolean("key_x5_init_sub_thread", bool1);
        ((SharedPreferences.Editor)localObject1).putBoolean("key_x5_enable_quic", bool3);
        ((SharedPreferences.Editor)localObject1).apply();
      }
    }
  }
  
  public boolean c()
  {
    String str = WebCgiWhiteListManager.c();
    if (!TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("SkipInputWarningConfig sp content: ");
        localStringBuilder.append(str);
        QLog.d("AuthorizeConfig", 2, localStringBuilder.toString());
      }
      try
      {
        this.jdField_c_of_type_OrgJsonJSONArray = new JSONArray(str);
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isColorLevel()) {
          break label124;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SkipInputWarningConfig load exception: ");
      localStringBuilder.append(localJSONException.getMessage());
      QLog.d("AuthorizeConfig", 2, localStringBuilder.toString());
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("AuthorizeConfig", 2, "SkipInputWarningConfig sp content empty!");
    }
    label124:
    return this.jdField_c_of_type_OrgJsonJSONArray != null;
  }
  
  public boolean c(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          if ((this.jdField_b_of_type_OrgJsonJSONArray == null) && (!b()))
          {
            if (!QLog.isColorLevel()) {
              break label289;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("AsyncCheckConfig loadfromsp fail , url: ");
            ((StringBuilder)localObject1).append(Util.b(paramString, new String[0]));
            QLog.d("AuthorizeConfig", 2, ((StringBuilder)localObject1).toString());
            return false;
          }
          Object localObject1 = Uri.parse(paramString).getHost();
          int j = this.jdField_b_of_type_OrgJsonJSONArray.length();
          if ((j != 0) && (!TextUtils.isEmpty((CharSequence)localObject1)))
          {
            Object localObject2 = ((String)localObject1).toLowerCase();
            i = 0;
            if (i < j)
            {
              localObject1 = this.jdField_b_of_type_OrgJsonJSONArray.optString(i, "");
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                break label293;
              }
              if (!TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject1))
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(".");
                localStringBuilder.append((String)localObject1);
                if (!((String)localObject2).endsWith(localStringBuilder.toString())) {
                  break label293;
                }
              }
              if (!QLog.isColorLevel()) {
                break label291;
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("AsyncCheckConfig hit , url: ");
              ((StringBuilder)localObject2).append(Util.b(paramString, new String[0]));
              ((StringBuilder)localObject2).append(" domain: ");
              ((StringBuilder)localObject2).append((String)localObject1);
              QLog.d("AuthorizeConfig", 2, ((StringBuilder)localObject2).toString());
              break label291;
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "AsyncCheckConfig check fail , url empty!");
          return false;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AuthorizeConfig", 2, "AsyncCheckConfig check exception", paramString);
        }
      }
      return false;
      label289:
      return false;
      label291:
      return true;
      label293:
      i += 1;
    }
  }
  
  public boolean c(String paramString1, String paramString2)
  {
    localObject1 = paramString1;
    if (localObject1 != null)
    {
      paramString1 = (String)localObject1;
      if (!"about:blank".equalsIgnoreCase((String)localObject1)) {}
    }
    else
    {
      paramString1 = "https://localhost/";
    }
    localUri = Uri.parse(paramString1);
    localObject1 = localUri.getScheme();
    if ("file".equals(localObject1))
    {
      localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
      paramString2 = paramString1;
      if (paramString1.length() > 200) {
        paramString2 = paramString1.substring(0, 200);
      }
      ReportController.b((AppRuntime)localObject1, "dc00899", "Grp_tech_report", "", "webview", "file_scheme", 0, 0, paramString2, "", "", "");
      QLog.e("AuthorizeConfig", 1, "action deprecated with file protocol");
      return false;
    }
    if ((!"http".equals(localObject1)) && (!"https".equals(localObject1))) {
      return false;
    }
    localObject2 = this.jdField_f_of_type_OrgJsonJSONObject;
    System.currentTimeMillis();
    localObject1 = localObject2;
    if (localObject2 == null) {}
    try
    {
      paramString1 = this.jdField_a_of_type_ComTencentBizAuthorizeJsonConfig.a();
    }
    catch (JSONException paramString1)
    {
      try
      {
        localObject1 = new JSONObject("{\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"*.wanggou.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"tel\",\"sms\",\"http\",\"https\",\"file\", \"mqqc2b\"]}");
        this.jdField_f_of_type_OrgJsonJSONObject = ((JSONObject)localObject1);
        JSONArray localJSONArray = ((JSONObject)localObject1).names();
        if (localJSONArray != null) {
          break label231;
        }
        return false;
        localObject2 = localUri.getHost();
        paramString1 = (String)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label255;
        }
        paramString1 = ((String)localObject2).toLowerCase();
        int k = localJSONArray.length();
        int i = 0;
        while (i < k)
        {
          localObject2 = localJSONArray.optString(i);
          if (b((String)localObject2, paramString1)) {
            for (;;)
            {
              localObject2 = ((JSONObject)localObject1).optJSONArray((String)localObject2);
              if (localObject2 != null)
              {
                int m = ((JSONArray)localObject2).length();
                int j = 0;
                while (j < m)
                {
                  if (b(((JSONArray)localObject2).optString(j), paramString2)) {
                    return true;
                  }
                  j += 1;
                }
              }
            }
          }
          i += 1;
        }
        return false;
        paramString1 = paramString1;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          String str = paramString1;
        }
      }
    }
    paramString1 = (String)localObject2;
    if (QLog.isColorLevel())
    {
      QLog.d("AuthorizeConfig", 2, "Decode mSchemeConfig error");
      paramString1 = (String)localObject2;
    }
    localObject1 = paramString1;
    if (paramString1 != null) {}
  }
  
  public String d(String paramString)
  {
    return a("pt4_token", paramString, a("pt4_token"));
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AuthorizeConfig", 2, "readAndSaveX5PreloadWhiteListConfig from VasQuickUpdateManager.SCID_FUNCDEV_WEBVIEW.");
    }
    Object localObject2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    Object localObject1 = VasUpdateUtil.a((AppRuntime)localObject2, "VASBiz_FuncDev_webview.json", false, null);
    if ((localObject1 != null) && (localObject2 != null) && (((AppRuntime)localObject2).isLogin()))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("receive X5PreloadWhiteList data: ");
        ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
        QLog.i("AuthorizeConfig", 2, ((StringBuilder)localObject2).toString());
      }
      localObject1 = ((JSONObject)localObject1).optJSONArray("x5PreloadWhiteList");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0)) {
        this.jdField_d_of_type_OrgJsonJSONObject = ((JSONArray)localObject1).optJSONObject(0);
      }
    }
  }
  
  public boolean d()
  {
    try
    {
      if ((this.jdField_a_of_type_Int == -1) && (!e()))
      {
        if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "forceHttpsConfig loadfromsp fail");
          return false;
        }
      }
      else
      {
        int i = this.jdField_a_of_type_Int;
        return i == 1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AuthorizeConfig", 2, "forceHttps enable check exception", localException);
      }
      return false;
    }
    return false;
  }
  
  public boolean d(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          if ((this.jdField_c_of_type_OrgJsonJSONArray == null) && (!c()))
          {
            if (!QLog.isColorLevel()) {
              break label289;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("SkipInputWarningConfig loadfromsp fail , url: ");
            ((StringBuilder)localObject1).append(Util.b(paramString, new String[0]));
            QLog.d("AuthorizeConfig", 2, ((StringBuilder)localObject1).toString());
            return false;
          }
          Object localObject1 = Uri.parse(paramString).getHost();
          int j = this.jdField_c_of_type_OrgJsonJSONArray.length();
          if ((j != 0) && (!TextUtils.isEmpty((CharSequence)localObject1)))
          {
            Object localObject2 = ((String)localObject1).toLowerCase();
            i = 0;
            if (i < j)
            {
              localObject1 = this.jdField_c_of_type_OrgJsonJSONArray.optString(i, "");
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                break label293;
              }
              if (!TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject1))
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(".");
                localStringBuilder.append((String)localObject1);
                if (!((String)localObject2).endsWith(localStringBuilder.toString())) {
                  break label293;
                }
              }
              if (!QLog.isColorLevel()) {
                break label291;
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("SkipInputWarningConfig hit , url: ");
              ((StringBuilder)localObject2).append(Util.b(paramString, new String[0]));
              ((StringBuilder)localObject2).append(" domain: ");
              ((StringBuilder)localObject2).append((String)localObject1);
              QLog.d("AuthorizeConfig", 2, ((StringBuilder)localObject2).toString());
              break label291;
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "SkipInputWarningConfig check fail , url empty!");
          return false;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AuthorizeConfig", 2, "SkipInputWarningConfig check exception", paramString);
        }
      }
      return false;
      label289:
      return false;
      label291:
      return true;
      label293:
      i += 1;
    }
  }
  
  public boolean d(@NonNull String paramString1, String paramString2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      IAuthorizeConfigInjector localIAuthorizeConfigInjector = (IAuthorizeConfigInjector)localIterator.next();
      if (localIAuthorizeConfigInjector.a().equals(paramString1)) {
        return localIAuthorizeConfigInjector.a(paramString2);
      }
    }
    return false;
  }
  
  public String e(String paramString)
  {
    return a("a2", paramString, a("a2"));
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AuthorizeConfig", 2, "readAndSaveSonicWhiteListConfig from VasQuickUpdateManager.SCID_FUNCDEV_WEBVIEW.");
    }
    Object localObject2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    int i = 0;
    Object localObject1 = VasUpdateUtil.a((AppRuntime)localObject2, "VASBiz_FuncDev_webview.json", false, null);
    if (localObject1 != null)
    {
      Object localObject3;
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("receive WhiteListConfig data: ");
        ((StringBuilder)localObject3).append(((JSONObject)localObject1).toString());
        QLog.i("AuthorizeConfig", 2, ((StringBuilder)localObject3).toString());
      }
      localObject1 = ((JSONObject)localObject1).optJSONArray("vipGrayConfig2");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
      {
        while (i < ((JSONArray)localObject1).length())
        {
          localObject3 = ((JSONArray)localObject1).optJSONObject(i);
          if ((localObject3 != null) && (a((JSONObject)localObject3)))
          {
            localObject1 = ((JSONObject)localObject3).optJSONObject("configs");
            break label153;
          }
          i += 1;
        }
        localObject1 = null;
        label153:
        localObject3 = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
        localObject2 = ((AppRuntime)localObject2).getApplication();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sp_sonic_white_list_config_");
        localStringBuilder.append((String)localObject3);
        localObject2 = ((MobileQQ)localObject2).getSharedPreferences(localStringBuilder.toString(), 4).edit();
        if (localObject1 != null)
        {
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("readAndSaveSonicWhiteListConfig: ");
            ((StringBuilder)localObject3).append(((JSONObject)localObject1).toString());
            QLog.i("AuthorizeConfig", 2, ((StringBuilder)localObject3).toString());
          }
          ((SharedPreferences.Editor)localObject2).putString("key_sonic_white_list_conifg", ((JSONObject)localObject1).toString());
        }
        else
        {
          QLog.e("AuthorizeConfig", 1, "readAndSaveSonicWhiteListConfig encounter error!. so remove all sonic white list.");
          ((SharedPreferences.Editor)localObject2).remove("key_sonic_white_list_conifg");
        }
        this.jdField_e_of_type_OrgJsonJSONObject = ((JSONObject)localObject1);
        ((SharedPreferences.Editor)localObject2).apply();
      }
    }
    else
    {
      QLog.d("AuthorizeConfig", 1, "readAndSaveSonicWhiteListConfig VasQuickUpdateManager.SCID_FUNCDEV_WEBVIEW is null");
    }
  }
  
  public boolean e()
  {
    int j = WebCgiWhiteListManager.b();
    boolean bool2 = false;
    int i;
    if (j == 1) {
      i = 1;
    } else {
      i = 0;
    }
    this.jdField_a_of_type_Int = i;
    String str1 = WebCgiWhiteListManager.d();
    StringBuilder localStringBuilder;
    if (!TextUtils.isEmpty(str1))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("forceHttpsConfig sp content: ");
        localStringBuilder.append(str1);
        QLog.d("AuthorizeConfig", 2, localStringBuilder.toString());
      }
      try
      {
        this.jdField_d_of_type_OrgJsonJSONArray = new JSONArray(str1);
      }
      catch (JSONException localJSONException1)
      {
        if (!QLog.isColorLevel()) {
          break label162;
        }
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("forceHttpsConfig load exception: ");
      localStringBuilder.append(localJSONException1.getMessage());
      QLog.d("AuthorizeConfig", 2, localStringBuilder.toString());
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("AuthorizeConfig", 2, "forceHttpsConfig sp content empty!");
    }
    label162:
    String str2 = WebCgiWhiteListManager.e();
    if (!TextUtils.isEmpty(str2))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("forceHttpsExcludeConfig sp content: ");
        localStringBuilder.append(str2);
        QLog.d("AuthorizeConfig", 2, localStringBuilder.toString());
      }
      try
      {
        this.jdField_e_of_type_OrgJsonJSONArray = new JSONArray(str2);
      }
      catch (JSONException localJSONException2)
      {
        if (!QLog.isColorLevel()) {
          break label300;
        }
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("forceHttpsExcludeConfig load exception: ");
      localStringBuilder.append(localJSONException2.getMessage());
      QLog.d("AuthorizeConfig", 2, localStringBuilder.toString());
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("AuthorizeConfig", 2, "forceHttpsExcludeConfig sp content empty!");
    }
    label300:
    boolean bool1 = bool2;
    if (j != -1)
    {
      bool1 = bool2;
      if (this.jdField_d_of_type_OrgJsonJSONArray != null)
      {
        bool1 = bool2;
        if (this.jdField_e_of_type_OrgJsonJSONArray != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean e(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          if ((this.jdField_d_of_type_OrgJsonJSONArray == null) && (!e()))
          {
            if (!QLog.isColorLevel()) {
              break label289;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("forceHttpsConfig loadfromsp fail , url: ");
            ((StringBuilder)localObject1).append(Util.b(paramString, new String[0]));
            QLog.d("AuthorizeConfig", 2, ((StringBuilder)localObject1).toString());
            return false;
          }
          Object localObject1 = Uri.parse(paramString).getHost();
          int j = this.jdField_d_of_type_OrgJsonJSONArray.length();
          if ((j != 0) && (!TextUtils.isEmpty((CharSequence)localObject1)))
          {
            Object localObject2 = ((String)localObject1).toLowerCase();
            i = 0;
            if (i < j)
            {
              localObject1 = this.jdField_d_of_type_OrgJsonJSONArray.optString(i, "");
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                break label293;
              }
              if (!TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject1))
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(".");
                localStringBuilder.append((String)localObject1);
                if (!((String)localObject2).endsWith(localStringBuilder.toString())) {
                  break label293;
                }
              }
              if (!QLog.isColorLevel()) {
                break label291;
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("forceHttpsConfig hit , url: ");
              ((StringBuilder)localObject2).append(Util.b(paramString, new String[0]));
              ((StringBuilder)localObject2).append(" domain: ");
              ((StringBuilder)localObject2).append((String)localObject1);
              QLog.d("AuthorizeConfig", 2, ((StringBuilder)localObject2).toString());
              break label291;
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "forceHttpsConfig check fail , url empty!");
          return false;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AuthorizeConfig", 2, "forceHttpsConfig check exception", paramString);
        }
      }
      return false;
      label289:
      return false;
      label291:
      return true;
      label293:
      i += 1;
    }
  }
  
  public void f()
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    boolean bool = true;
    if ((localObject != null) && (((AppRuntime)localObject).isLogin()))
    {
      String str = ((AppRuntime)localObject).getAccount();
      localObject = ((AppRuntime)localObject).getApplication();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("sp_sonic_white_list_config_");
      localStringBuilder2.append(str);
      str = ((MobileQQ)localObject).getSharedPreferences(localStringBuilder2.toString(), 4).getString("key_sonic_white_list_conifg", null);
      if (!TextUtils.isEmpty(str))
      {
        try
        {
          this.jdField_e_of_type_OrgJsonJSONObject = new JSONObject(str);
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            break label129;
          }
        }
        QLog.e("AuthorizeConfig", 2, "", localException);
      }
      else
      {
        QLog.e("AuthorizeConfig", 1, "loadSonicWhiteListConfigFromSp is null!");
      }
      label129:
      if (this.jdField_e_of_type_OrgJsonJSONObject == null) {
        e();
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("loadSonicWhiteListConfigFromSp:  ");
        if (this.jdField_e_of_type_OrgJsonJSONObject == null) {
          bool = false;
        }
        localStringBuilder1.append(bool);
        QLog.i("AuthorizeConfig", 2, localStringBuilder1.toString());
      }
      return;
    }
    QLog.e("AuthorizeConfig", 1, "loadSonicWhiteListConfigFromSp, runtime is null or is not login!");
  }
  
  public boolean f(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          if ((this.jdField_e_of_type_OrgJsonJSONArray == null) && (!e()))
          {
            if (!QLog.isColorLevel()) {
              break label289;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("forceHttpsExcludeConfig loadfromsp fail , url: ");
            ((StringBuilder)localObject1).append(Util.b(paramString, new String[0]));
            QLog.d("AuthorizeConfig", 2, ((StringBuilder)localObject1).toString());
            return false;
          }
          Object localObject1 = Uri.parse(paramString).getHost();
          int j = this.jdField_e_of_type_OrgJsonJSONArray.length();
          if ((j != 0) && (!TextUtils.isEmpty((CharSequence)localObject1)))
          {
            Object localObject2 = ((String)localObject1).toLowerCase();
            i = 0;
            if (i < j)
            {
              localObject1 = this.jdField_e_of_type_OrgJsonJSONArray.optString(i, "");
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                break label293;
              }
              if (!TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject1))
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(".");
                localStringBuilder.append((String)localObject1);
                if (!((String)localObject2).endsWith(localStringBuilder.toString())) {
                  break label293;
                }
              }
              if (!QLog.isColorLevel()) {
                break label291;
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("forceHttpsExcludeConfig hit , url: ");
              ((StringBuilder)localObject2).append(Util.b(paramString, new String[0]));
              ((StringBuilder)localObject2).append(" domain: ");
              ((StringBuilder)localObject2).append((String)localObject1);
              QLog.d("AuthorizeConfig", 2, ((StringBuilder)localObject2).toString());
              break label291;
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "forceHttpsExcludeConfig check fail , url empty!");
          return false;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AuthorizeConfig", 2, "forceHttpsExcludeConfig check exception", paramString);
        }
      }
      return false;
      label289:
      return false;
      label291:
      return true;
      label293:
      i += 1;
    }
  }
  
  public void g()
  {
    long l1 = System.currentTimeMillis();
    long l2 = jdField_e_of_type_Long;
    int j = 0;
    if (l1 - l2 < 86400000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 1, new Object[] { "cachePreloadPskeyList too often lastTime:", Long.valueOf(jdField_e_of_type_Long), " interval:", Long.valueOf(86400000L) });
      }
      return;
    }
    if (!MobileQQ.sMobileQQ.waitAppRuntime(null).isLogin())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, "cachePreloadPskeyList is not login");
      }
      return;
    }
    if (((WVPreloadPskeyConfBean)QConfigManager.a().a(585)).jdField_a_of_type_Int == 1)
    {
      Object localObject3 = a("pskey");
      ArrayList localArrayList = new ArrayList(((Set)localObject3).size());
      ??? = new HashSet(20);
      Object localObject4 = WebViewConstant.jdField_a_of_type_ArrayOfJavaLangString;
      int k = localObject4.length;
      int i = 0;
      while (i < k)
      {
        ((HashSet)???).add(localObject4[i]);
        i += 1;
      }
      localObject3 = ((Set)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        if (!((HashSet)???).contains(localObject4)) {
          localArrayList.add(localObject4);
        }
      }
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        this.jdField_b_of_type_JavaUtilArrayList = localArrayList;
        if (QLog.isColorLevel())
        {
          localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
          i = j;
          if (localArrayList != null) {
            i = localArrayList.size();
          }
          QLog.d("AuthorizeConfig", 2, new Object[] { "preloadPskey list:", Integer.valueOf(i), " waitPt4Token:", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
        }
        if (this.jdField_a_of_type_Boolean) {
          return;
        }
        h();
        jdField_e_of_type_Long = l1;
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("lastPreloadPskey", jdField_e_of_type_Long).commit();
        return;
      }
    }
    QLog.d("AuthorizeConfig", 1, "do not support preloadPskey.");
  }
  
  public boolean g(String paramString)
  {
    Object localObject2 = Uri.parse(paramString);
    Object localObject1;
    if ((localObject2 != null) && (((Uri)localObject2).isHierarchical()))
    {
      if (this.jdField_e_of_type_OrgJsonJSONObject == null) {
        f();
      }
      localObject1 = this.jdField_e_of_type_OrgJsonJSONObject;
      boolean bool2 = true;
      if (localObject1 != null)
      {
        localObject1 = ((Uri)localObject2).getHost();
        localObject2 = ((Uri)localObject2).getPath();
        if (this.jdField_e_of_type_OrgJsonJSONObject != null)
        {
          JSONArray localJSONArray = this.jdField_e_of_type_OrgJsonJSONObject.optJSONArray((String)localObject1);
          if ((localJSONArray != null) && (localJSONArray.length() > 0))
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("isInSonicWhiteList, host: ");
              localStringBuilder.append((String)localObject1);
              localStringBuilder.append(", rules: ");
              localStringBuilder.append(localJSONArray.toString());
              QLog.i("AuthorizeConfig", 2, localStringBuilder.toString());
            }
            int i = 0;
            while (i < localJSONArray.length())
            {
              localObject1 = localJSONArray.optString(i);
              bool1 = bool2;
              if (((String)localObject1).equalsIgnoreCase((String)localObject2)) {
                break label254;
              }
              if (((String)localObject1).equals("*"))
              {
                bool1 = bool2;
                break label254;
              }
              if ((((String)localObject1).endsWith("*")) && (((String)localObject2).startsWith(((String)localObject1).replace("/*", ""))))
              {
                bool1 = bool2;
                break label254;
              }
              i += 1;
            }
          }
        }
      }
      else
      {
        QLog.e("AuthorizeConfig", 1, "mSonicWhiteListConfig is null! ");
      }
    }
    boolean bool1 = false;
    label254:
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("isInSonicWhiteList: ");
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append(", url: ");
      ((StringBuilder)localObject1).append(Util.b(paramString, new String[0]));
      QLog.i("AuthorizeConfig", 2, ((StringBuilder)localObject1).toString());
    }
    return bool1;
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, "preloadPskey waiting");
      }
      return;
    }
    Object localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (!((AppRuntime)localObject1).isLogin())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, "preloadPskey is not login");
      }
      return;
    }
    TicketManager localTicketManager = (TicketManager)((AppRuntime)localObject1).getManager(2);
    ArrayList localArrayList1 = new ArrayList(20);
    ArrayList localArrayList2 = new ArrayList();
    Object localObject3 = jdField_a_of_type_JavaLangObject;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.jdField_b_of_type_JavaUtilArrayList.size())
        {
          if (i < 20) {
            localArrayList1.add(this.jdField_b_of_type_JavaUtilArrayList.get(i));
          } else {
            localArrayList2.add(this.jdField_b_of_type_JavaUtilArrayList.get(i));
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("AuthorizeConfig", 2, new Object[] { "preload:", Integer.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size()), " cur:", Integer.valueOf(localArrayList1.size()), " left:", Integer.valueOf(localArrayList2.size()) });
          }
          this.jdField_b_of_type_JavaUtilArrayList = localArrayList2;
          if (localArrayList1.size() == 0) {
            return;
          }
          localObject3 = new String[localArrayList1.size()];
          i = 0;
          if (i < localArrayList1.size())
          {
            localObject3[i] = String.format("(%d)%s", new Object[] { Integer.valueOf(1048576), localArrayList1.get(i) });
            i += 1;
            continue;
          }
          localObject1 = new AuthorizeConfig.4(this, localTicketManager, ((AppRuntime)localObject1).getAccount(), (String[])localObject3);
          if (Looper.myLooper() != Looper.getMainLooper())
          {
            ((Runnable)localObject1).run();
            return;
          }
          ThreadManager.post((Runnable)localObject1, 8, null, true);
          return;
        }
      }
      finally
      {
        continue;
        throw localObject2;
        continue;
        i += 1;
      }
    }
  }
  
  public boolean h(String paramString)
  {
    Object localObject = Uri.parse(paramString).getScheme();
    if ((!"http".equals(localObject)) && (!"https".equals(localObject))) {
      return false;
    }
    Set localSet = a("a1");
    localObject = Uri.parse(paramString).getHost();
    paramString = (String)localObject;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramString = ((String)localObject).toLowerCase();
    }
    if (localSet.contains(paramString)) {
      return true;
    }
    localObject = localSet.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (b((String)((Iterator)localObject).next(), paramString)) {
        return true;
      }
    }
    return false;
  }
  
  public void i()
  {
    long l = System.currentTimeMillis();
    if (l - jdField_f_of_type_Long < 21600000L)
    {
      QLog.d("AuthorizeConfig", 1, "preload too often");
      return;
    }
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      if (l - jdField_f_of_type_Long < 21600000L)
      {
        QLog.d("AuthorizeConfig", 1, "preload too often");
        return;
      }
      jdField_f_of_type_Long = l;
      ??? = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (MobileQQ.sProcessId != 1) {
        return;
      }
      if (!((AppRuntime)???).isLogin()) {
        return;
      }
      if (com.tencent.mobileqq.webprocess.WebAccelerateHelper.getInstance().getWebViewFeatureParams()[3].intValue() == 1)
      {
        TicketManager localTicketManager = (TicketManager)((AppRuntime)???).getManager(2);
        Object localObject3 = a("pt4_token");
        String[] arrayOfString = new String[((Set)localObject3).size()];
        localObject3 = ((Set)localObject3).iterator();
        int i = 0;
        while (((Iterator)localObject3).hasNext())
        {
          arrayOfString[i] = String.format("(%d)%s", new Object[] { Integer.valueOf(134217728), (String)((Iterator)localObject3).next() });
          i += 1;
        }
        ??? = new AuthorizeConfig.5(this, localTicketManager, ((AppRuntime)???).getAccount(), arrayOfString);
        if (Looper.myLooper() != Looper.getMainLooper()) {
          ((Runnable)???).run();
        } else {
          ThreadManager.post((Runnable)???, 8, null, true);
        }
        this.jdField_a_of_type_Boolean = true;
        return;
      }
      QLog.d("AuthorizeConfig", 1, "do not support preload.");
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public boolean i(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = paramString;
      if (!"about:blank".equalsIgnoreCase(paramString)) {}
    }
    else
    {
      localObject1 = "https://localhost/";
    }
    Uri localUri = Uri.parse((String)localObject1);
    paramString = localUri.getScheme();
    if ((!"http".equals(paramString)) && (!"https".equals(paramString))) {
      return false;
    }
    Object localObject2 = this.jdField_f_of_type_OrgJsonJSONObject;
    System.currentTimeMillis();
    Object localObject1 = localObject2;
    if (localObject2 == null) {}
    try
    {
      paramString = this.jdField_a_of_type_ComTencentBizAuthorizeJsonConfig.a();
    }
    catch (JSONException paramString)
    {
      label88:
      break label88;
    }
    paramString = (String)localObject2;
    if (QLog.isColorLevel())
    {
      QLog.d("AuthorizeConfig", 2, "Decode mSchemeConfig error");
      paramString = (String)localObject2;
    }
    localObject1 = paramString;
    if (paramString == null) {}
    try
    {
      localObject1 = new JSONObject("{\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"*.wanggou.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"tel\",\"sms\",\"http\",\"https\",\"file\", \"mqqc2b\"]}");
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        int j;
        int i;
        String str = paramString;
      }
    }
    localObject2 = ((JSONObject)localObject1).names();
    if (localObject2 == null) {
      return false;
    }
    localObject1 = localUri.getHost();
    paramString = (String)localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      paramString = ((String)localObject1).toLowerCase();
    }
    j = ((JSONArray)localObject2).length();
    i = 0;
    while (i < j)
    {
      localObject1 = ((JSONArray)localObject2).optString(i);
      if (((localObject1 != null) && (((String)localObject1).equals("*"))) || (!b((String)localObject1, paramString))) {
        i += 1;
      } else {
        return true;
      }
    }
    return false;
  }
  
  public void j()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewAuthorizeIAuthorizeConfigDownloadInjector;
    if (localObject == null) {
      return;
    }
    localObject = ((IAuthorizeConfigDownloadInjector)localObject).a();
    if (localObject != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((IAuthorizeConfigInjector)localIterator.next()).a((JSONObject)localObject);
      }
    }
    QLog.d("AuthorizeConfig", 1, "WebViewSwitchAio loadFuncDevWebViewConfig return null");
  }
  
  public boolean j(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (this.jdField_d_of_type_OrgJsonJSONObject == null) {
      d();
    }
    Object localObject = this.jdField_d_of_type_OrgJsonJSONObject;
    JSONArray localJSONArray = null;
    if (localObject != null) {
      localJSONArray = ((JSONObject)localObject).optJSONArray("domainList");
    }
    if (localObject != null)
    {
      localObject = localJSONArray;
      if (localJSONArray != null) {}
    }
    else
    {
      localObject = new JSONArray();
      ((JSONArray)localObject).put("*.vip.qq.com");
    }
    int i = ((JSONArray)localObject).length() - 1;
    while (i >= 0)
    {
      if (b(((JSONArray)localObject).optString(i), paramString)) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  public void k()
  {
    try
    {
      long l = System.currentTimeMillis();
      if ((l - this.jdField_c_of_type_Long < 1800000L) && (!g())) {
        return;
      }
      this.jdField_c_of_type_Long = l;
      ThreadManager.post(new AuthorizeConfig.6(this), 5, null, false);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.AuthorizeConfig
 * JD-Core Version:    0.7.0.1
 */