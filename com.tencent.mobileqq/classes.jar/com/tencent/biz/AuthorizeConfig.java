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
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtilss;
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
  private final String jdField_a_of_type_JavaLangString = "faceUnblockCamera.startPTVActivity";
  private ArrayList<IAuthorizeConfigInjector> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  protected final ConcurrentHashMap<String, JSONArray> a;
  public final AtomicInteger a;
  WtTicketPromise jdField_a_of_type_OicqWlogin_sdkRequestWtTicketPromise = new AuthorizeConfig.3(this);
  protected volatile JSONArray a;
  protected volatile JSONObject a;
  private boolean jdField_a_of_type_Boolean = false;
  private final String jdField_b_of_type_JavaLangString = "https://mysec.qq.com/v2/account_control/index.html";
  private ArrayList<String> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  protected final ConcurrentHashMap<String, Set<String>> b;
  protected volatile JSONArray b;
  protected volatile JSONObject b;
  protected volatile long c;
  private final String c;
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
    this.jdField_c_of_type_JavaLangString = "qbizApi.getClientInfo";
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
    if (jdField_a_of_type_ComTencentBizAuthorizeConfig == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizAuthorizeConfig == null) {
        jdField_a_of_type_ComTencentBizAuthorizeConfig = new AuthorizeConfig(BaseApplication.getContext());
      }
      jdField_a_of_type_ComTencentBizAuthorizeConfig.a();
      if (!jdField_a_of_type_ComTencentBizAuthorizeConfig.a(true)) {
        jdField_a_of_type_ComTencentBizAuthorizeConfig.i();
      }
      return jdField_a_of_type_ComTencentBizAuthorizeConfig;
    }
    finally {}
  }
  
  public static AuthorizeConfig a(boolean paramBoolean)
  {
    if (jdField_a_of_type_ComTencentBizAuthorizeConfig == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizAuthorizeConfig == null) {
        jdField_a_of_type_ComTencentBizAuthorizeConfig = new AuthorizeConfig(BaseApplication.getContext());
      }
      jdField_a_of_type_ComTencentBizAuthorizeConfig.a();
      jdField_a_of_type_ComTencentBizAuthorizeConfig.a(paramBoolean);
      return jdField_a_of_type_ComTencentBizAuthorizeConfig;
    }
    finally {}
  }
  
  private static String a(String paramString1, String paramString2, Set<String> paramSet)
  {
    Object localObject1;
    Object localObject2;
    if (!TextUtils.isEmpty(paramString2))
    {
      localObject1 = Uri.parse(paramString2);
      localObject2 = ((Uri)localObject1).getScheme();
      if ((!"http".equals(localObject2)) && (!"https".equals(localObject2)))
      {
        localObject1 = "";
        return localObject1;
      }
      if (((Uri)localObject1).isHierarchical())
      {
        localObject1 = ((Uri)localObject1).getHost();
        if (localObject1 != null)
        {
          localObject1 = ((String)localObject1).toLowerCase();
          if (paramSet.contains(localObject1)) {
            paramSet = (Set<String>)localObject1;
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = paramSet;
      if (!QLog.isColorLevel()) {
        break;
      }
      if (!TextUtils.isEmpty(paramSet))
      {
        QLog.d("AuthorizeConfig", 2, paramSet + " need " + paramString1 + " which extract from " + paramString2);
        return paramSet;
        localObject2 = paramSet.iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          paramSet = (String)((Iterator)localObject2).next();
        } while (!((String)localObject1).endsWith("." + paramSet));
      }
      else
      {
        QLog.d("AuthorizeConfig", 2, paramString2 + " not need " + paramString1);
        return paramSet;
        paramSet = "";
      }
    }
  }
  
  /* Error */
  public static String a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 325	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 326	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: astore_1
    //   10: new 328	java/util/zip/Inflater
    //   13: dup
    //   14: invokespecial 329	java/util/zip/Inflater:<init>	()V
    //   17: astore_3
    //   18: aload_2
    //   19: astore_1
    //   20: aload_3
    //   21: aload_0
    //   22: invokevirtual 333	java/util/zip/Inflater:setInput	([B)V
    //   25: aload_2
    //   26: astore_1
    //   27: sipush 1024
    //   30: newarray byte
    //   32: astore_0
    //   33: aload_2
    //   34: astore_1
    //   35: aload_3
    //   36: invokevirtual 336	java/util/zip/Inflater:finished	()Z
    //   39: ifne +58 -> 97
    //   42: aload_2
    //   43: astore_1
    //   44: aload_2
    //   45: aload_0
    //   46: iconst_0
    //   47: aload_3
    //   48: aload_0
    //   49: invokevirtual 340	java/util/zip/Inflater:inflate	([B)I
    //   52: invokevirtual 344	java/io/ByteArrayOutputStream:write	([BII)V
    //   55: goto -22 -> 33
    //   58: astore_1
    //   59: aload_2
    //   60: astore_0
    //   61: aload_1
    //   62: astore_2
    //   63: aload_0
    //   64: astore_1
    //   65: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +15 -> 83
    //   71: aload_0
    //   72: astore_1
    //   73: ldc 166
    //   75: iconst_2
    //   76: ldc_w 267
    //   79: aload_2
    //   80: invokestatic 347	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   83: aload_0
    //   84: ifnull +7 -> 91
    //   87: aload_0
    //   88: invokevirtual 350	java/io/ByteArrayOutputStream:close	()V
    //   91: ldc_w 267
    //   94: astore_0
    //   95: aload_0
    //   96: areturn
    //   97: aload_2
    //   98: astore_1
    //   99: aload_3
    //   100: invokevirtual 353	java/util/zip/Inflater:end	()V
    //   103: aload_2
    //   104: astore_1
    //   105: new 41	java/lang/String
    //   108: dup
    //   109: aload_2
    //   110: invokevirtual 357	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   113: invokespecial 359	java/lang/String:<init>	([B)V
    //   116: astore_3
    //   117: aload_3
    //   118: astore_0
    //   119: aload_2
    //   120: ifnull -25 -> 95
    //   123: aload_2
    //   124: invokevirtual 350	java/io/ByteArrayOutputStream:close	()V
    //   127: aload_3
    //   128: areturn
    //   129: astore_1
    //   130: aload_3
    //   131: astore_0
    //   132: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   135: ifeq -40 -> 95
    //   138: ldc 166
    //   140: iconst_2
    //   141: ldc_w 267
    //   144: aload_1
    //   145: invokestatic 347	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   148: aload_3
    //   149: areturn
    //   150: astore_0
    //   151: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq -63 -> 91
    //   157: ldc 166
    //   159: iconst_2
    //   160: ldc_w 267
    //   163: aload_0
    //   164: invokestatic 347	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   167: goto -76 -> 91
    //   170: astore_0
    //   171: aconst_null
    //   172: astore_1
    //   173: aload_1
    //   174: ifnull +7 -> 181
    //   177: aload_1
    //   178: invokevirtual 350	java/io/ByteArrayOutputStream:close	()V
    //   181: aload_0
    //   182: athrow
    //   183: astore_1
    //   184: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   187: ifeq -6 -> 181
    //   190: ldc 166
    //   192: iconst_2
    //   193: ldc_w 267
    //   196: aload_1
    //   197: invokestatic 347	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   200: goto -19 -> 181
    //   203: astore_0
    //   204: goto -31 -> 173
    //   207: astore_2
    //   208: aconst_null
    //   209: astore_0
    //   210: goto -147 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	paramArrayOfByte	byte[]
    //   9	35	1	localObject1	Object
    //   58	4	1	localThrowable1	Throwable
    //   64	41	1	localObject2	Object
    //   129	16	1	localException1	Exception
    //   172	6	1	localObject3	Object
    //   183	14	1	localException2	Exception
    //   7	117	2	localObject4	Object
    //   207	1	2	localThrowable2	Throwable
    //   17	132	3	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   10	18	58	java/lang/Throwable
    //   20	25	58	java/lang/Throwable
    //   27	33	58	java/lang/Throwable
    //   35	42	58	java/lang/Throwable
    //   44	55	58	java/lang/Throwable
    //   99	103	58	java/lang/Throwable
    //   105	117	58	java/lang/Throwable
    //   123	127	129	java/lang/Exception
    //   87	91	150	java/lang/Exception
    //   0	8	170	finally
    //   177	181	183	java/lang/Exception
    //   10	18	203	finally
    //   20	25	203	finally
    //   27	33	203	finally
    //   35	42	203	finally
    //   44	55	203	finally
    //   65	71	203	finally
    //   73	83	203	finally
    //   99	103	203	finally
    //   105	117	203	finally
    //   0	8	207	java/lang/Throwable
  }
  
  /* Error */
  private JSONArray a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: invokestatic 247	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +15 -> 21
    //   9: new 364	org/json/JSONArray
    //   12: dup
    //   13: invokespecial 365	org/json/JSONArray:<init>	()V
    //   16: astore 5
    //   18: aload 5
    //   20: areturn
    //   21: aload_0
    //   22: getfield 145	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   25: aload_1
    //   26: invokevirtual 369	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   29: checkcast 364	org/json/JSONArray
    //   32: astore 6
    //   34: aload 6
    //   36: astore 5
    //   38: aload 6
    //   40: ifnonnull -22 -> 18
    //   43: aload_0
    //   44: getfield 145	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   47: astore 8
    //   49: aload 8
    //   51: monitorenter
    //   52: aload_0
    //   53: getfield 145	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   56: aload_1
    //   57: invokevirtual 369	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   60: checkcast 364	org/json/JSONArray
    //   63: astore 5
    //   65: aload 5
    //   67: astore 6
    //   69: aload 5
    //   71: ifnonnull +139 -> 210
    //   74: aload_0
    //   75: getfield 197	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_ComTencentBizAuthorizeJsonConfig	Lcom/tencent/biz/authorize/JsonConfig;
    //   78: aload_1
    //   79: invokevirtual 371	com/tencent/biz/authorize/JsonConfig:a	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   82: astore 6
    //   84: aload 6
    //   86: ifnonnull +195 -> 281
    //   89: new 364	org/json/JSONArray
    //   92: dup
    //   93: getstatic 63	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_AndroidSupportV4UtilArrayMap	Landroid/support/v4/util/ArrayMap;
    //   96: aload_1
    //   97: invokevirtual 372	android/support/v4/util/ArrayMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   100: checkcast 41	java/lang/String
    //   103: invokespecial 375	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   106: astore 5
    //   108: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   111: ifeq +29 -> 140
    //   114: ldc 166
    //   116: iconst_2
    //   117: new 283	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   124: ldc_w 377
    //   127: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_1
    //   131: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 379	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: aload 5
    //   142: astore 6
    //   144: aload 5
    //   146: ifnonnull +44 -> 190
    //   149: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   152: ifeq +29 -> 181
    //   155: ldc 166
    //   157: iconst_2
    //   158: new 283	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   165: aload_1
    //   166: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: ldc_w 381
    //   172: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 379	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: new 364	org/json/JSONArray
    //   184: dup
    //   185: invokespecial 365	org/json/JSONArray:<init>	()V
    //   188: astore 6
    //   190: aload_0
    //   191: getfield 145	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   194: aload_1
    //   195: aload 6
    //   197: invokevirtual 382	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   200: pop
    //   201: aload_0
    //   202: getfield 147	com/tencent/biz/AuthorizeConfig:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   205: aload_1
    //   206: invokevirtual 385	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   209: pop
    //   210: aload 8
    //   212: monitorexit
    //   213: aload 6
    //   215: areturn
    //   216: astore_1
    //   217: aload 8
    //   219: monitorexit
    //   220: aload_1
    //   221: athrow
    //   222: astore 7
    //   224: aload 6
    //   226: astore 5
    //   228: aload 7
    //   230: astore 6
    //   232: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   235: ifeq +151 -> 386
    //   238: ldc 166
    //   240: iconst_2
    //   241: new 283	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   248: ldc_w 387
    //   251: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload_1
    //   255: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: ldc_w 389
    //   261: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload 6
    //   266: invokevirtual 392	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   269: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokestatic 379	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   278: goto +108 -> 386
    //   281: ldc 45
    //   283: aload_1
    //   284: invokevirtual 263	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   287: istore 4
    //   289: iload 4
    //   291: ifeq +78 -> 369
    //   294: new 364	org/json/JSONArray
    //   297: dup
    //   298: getstatic 63	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_AndroidSupportV4UtilArrayMap	Landroid/support/v4/util/ArrayMap;
    //   301: ldc 45
    //   303: invokevirtual 372	android/support/v4/util/ArrayMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   306: checkcast 41	java/lang/String
    //   309: invokespecial 375	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   312: astore 5
    //   314: aload 5
    //   316: invokevirtual 396	org/json/JSONArray:length	()I
    //   319: istore_2
    //   320: iload_3
    //   321: iload_2
    //   322: if_icmpge +32 -> 354
    //   325: aload 6
    //   327: aload 5
    //   329: iload_3
    //   330: invokevirtual 400	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   333: invokevirtual 403	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   336: pop
    //   337: iload_3
    //   338: iconst_1
    //   339: iadd
    //   340: istore_3
    //   341: goto -21 -> 320
    //   344: aload 7
    //   346: invokevirtual 406	org/json/JSONException:printStackTrace	()V
    //   349: iconst_0
    //   350: istore_2
    //   351: goto -31 -> 320
    //   354: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   357: ifeq +12 -> 369
    //   360: ldc 166
    //   362: iconst_2
    //   363: ldc_w 408
    //   366: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   369: aload 6
    //   371: astore 5
    //   373: goto -233 -> 140
    //   376: astore 7
    //   378: goto -34 -> 344
    //   381: astore 6
    //   383: goto -151 -> 232
    //   386: goto -246 -> 140
    //   389: astore 7
    //   391: aconst_null
    //   392: astore 5
    //   394: goto -50 -> 344
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	397	0	this	AuthorizeConfig
    //   0	397	1	paramString	String
    //   319	32	2	i	int
    //   1	340	3	j	int
    //   287	3	4	bool	boolean
    //   16	377	5	localObject1	Object
    //   32	338	6	localObject2	Object
    //   381	1	6	localJSONException1	JSONException
    //   222	123	7	localJSONException2	JSONException
    //   376	1	7	localJSONException3	JSONException
    //   389	1	7	localJSONException4	JSONException
    //   47	171	8	localConcurrentHashMap	ConcurrentHashMap
    // Exception table:
    //   from	to	target	type
    //   52	65	216	finally
    //   74	84	216	finally
    //   89	108	216	finally
    //   108	140	216	finally
    //   149	181	216	finally
    //   181	190	216	finally
    //   190	210	216	finally
    //   210	213	216	finally
    //   217	220	216	finally
    //   232	278	216	finally
    //   281	289	216	finally
    //   294	314	216	finally
    //   314	320	216	finally
    //   325	337	216	finally
    //   344	349	216	finally
    //   354	369	216	finally
    //   89	108	222	org/json/JSONException
    //   314	320	376	org/json/JSONException
    //   108	140	381	org/json/JSONException
    //   294	314	389	org/json/JSONException
  }
  
  private JSONObject a()
  {
    JSONObject localJSONObject3 = this.jdField_a_of_type_OrgJsonJSONObject;
    System.currentTimeMillis();
    Object localObject = localJSONObject3;
    JSONObject localJSONObject1;
    if (localJSONObject3 == null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizAuthorizeJsonConfig.a();
      localJSONObject1 = localJSONObject3;
      if (localObject == null) {}
    }
    try
    {
      localJSONObject1 = new JSONObject((String)localObject);
      localObject = localJSONObject1;
      if (localJSONObject1 == null) {
        localObject = new JSONObject();
      }
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        JSONObject localJSONObject2 = localJSONObject3;
        if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "Decode mOfflineConfig  error");
          localJSONObject2 = localJSONObject3;
        }
      }
    }
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
    Object localObject3 = this.jdField_b_of_type_OrgJsonJSONObject;
    System.currentTimeMillis();
    Object localObject1 = localObject3;
    String str;
    if (localObject3 == null)
    {
      str = this.jdField_a_of_type_ComTencentBizAuthorizeJsonConfig.b();
      localObject1 = localObject3;
      if (str == null) {}
    }
    try
    {
      localObject1 = new JSONObject(str);
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new JSONObject();
      }
      this.jdField_b_of_type_OrgJsonJSONObject = ((JSONObject)localObject3);
      localObject1 = localObject3;
      return localObject1;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "Decode mExtraConfig error");
          localObject2 = localObject3;
        }
      }
    }
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while ("*".equals(paramString1));
      if (!"*.*".equals(paramString1)) {
        break;
      }
      bool1 = bool2;
    } while (paramString2.indexOf('.') != -1);
    return false;
    if (paramString1.startsWith("*")) {
      return paramString2.endsWith(paramString1.substring(1));
    }
    if (paramString1.endsWith("*")) {
      return paramString2.startsWith(paramString1.substring(0, paramString1.length() - 1));
    }
    return paramString2.equals(paramString1);
  }
  
  private boolean f()
  {
    boolean bool = false;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {
          return false;
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3) {
          return true;
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != -1) {
          break label122;
        }
        if (MobileQQ.sProcessId == 1)
        {
          i = 1;
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
          long l = System.currentTimeMillis() - jdField_b_of_type_Long;
          if (l < 0L) {
            break label127;
          }
          if (l < 1800000L) {
            break label117;
          }
          break label127;
          return bool;
        }
      }
      int i = 0;
      continue;
      label117:
      int j = 0;
      break label129;
      label122:
      i = 0;
      continue;
      label127:
      j = 1;
      label129:
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
    do
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
        while (AuthorizeConfigInjectUtil.jdField_b_of_type_JavaUtilArrayList == null) {}
      }
      catch (Throwable localThrowable)
      {
        QLog.e("AuthorizeConfig", 1, "initBusinessInjetor Fail,", localThrowable);
        return;
      }
    } while (AuthorizeConfigInjectUtil.jdField_b_of_type_JavaUtilArrayList.size() <= 0);
    this.jdField_a_of_type_ComTencentMobileqqWebviewAuthorizeIAuthorizeConfigDownloadInjector = ((IAuthorizeConfigDownloadInjector)((Class)AuthorizeConfigInjectUtil.jdField_b_of_type_JavaUtilArrayList.get(0)).newInstance());
  }
  
  public int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      JSONObject localJSONObject;
      do
      {
        return 0;
        paramString = paramString.split("\\?");
        localJSONObject = a();
      } while (!localJSONObject.has(paramString[0]));
      try
      {
        int i = localJSONObject.getJSONObject(paramString[0]).getInt("delay");
        return i;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("AuthorizeConfig", 2, "getCheckUpDelayTime error");
    return 0;
  }
  
  public long a()
  {
    if (-1L == this.jdField_d_of_type_Long) {
      this.jdField_d_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("publishSeq", 0L);
    }
    return this.jdField_d_of_type_Long;
  }
  
  /* Error */
  public Boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +8 -> 9
    //   4: iconst_0
    //   5: invokestatic 526	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   8: areturn
    //   9: aload_1
    //   10: invokestatic 253	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   13: astore 5
    //   15: aload 5
    //   17: invokevirtual 257	android/net/Uri:getScheme	()Ljava/lang/String;
    //   20: astore 6
    //   22: ldc_w 528
    //   25: aload 6
    //   27: invokevirtual 263	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   30: ifeq +78 -> 108
    //   33: getstatic 532	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   36: aconst_null
    //   37: invokevirtual 536	mqq/app/MobileQQ:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   40: astore_2
    //   41: aload_1
    //   42: invokevirtual 431	java/lang/String:length	()I
    //   45: sipush 200
    //   48: if_icmple +57 -> 105
    //   51: aload_1
    //   52: iconst_0
    //   53: sipush 200
    //   56: invokevirtual 452	java/lang/String:substring	(II)Ljava/lang/String;
    //   59: astore_1
    //   60: aload_2
    //   61: ldc_w 538
    //   64: ldc_w 540
    //   67: ldc_w 267
    //   70: ldc_w 542
    //   73: ldc_w 544
    //   76: iconst_0
    //   77: iconst_0
    //   78: aload_1
    //   79: ldc_w 267
    //   82: ldc_w 267
    //   85: ldc_w 267
    //   88: invokestatic 549	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   91: ldc 166
    //   93: iconst_1
    //   94: ldc_w 551
    //   97: invokestatic 379	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: iconst_0
    //   101: invokestatic 526	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   104: areturn
    //   105: goto -45 -> 60
    //   108: ldc_w 259
    //   111: aload 6
    //   113: invokevirtual 263	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   116: ifne +19 -> 135
    //   119: ldc_w 265
    //   122: aload 6
    //   124: invokevirtual 263	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   127: ifne +8 -> 135
    //   130: iconst_0
    //   131: invokestatic 526	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   134: areturn
    //   135: aload 5
    //   137: invokevirtual 273	android/net/Uri:getHost	()Ljava/lang/String;
    //   140: astore_1
    //   141: aload_1
    //   142: astore 5
    //   144: aload_1
    //   145: invokestatic 247	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   148: ifne +9 -> 157
    //   151: aload_1
    //   152: invokevirtual 276	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   155: astore 5
    //   157: aload_0
    //   158: getfield 553	com/tencent/biz/AuthorizeConfig:jdField_c_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   161: astore_1
    //   162: invokestatic 417	java/lang/System:currentTimeMillis	()J
    //   165: pop2
    //   166: aload_1
    //   167: ifnonnull +238 -> 405
    //   170: aload_0
    //   171: getfield 197	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_ComTencentBizAuthorizeJsonConfig	Lcom/tencent/biz/authorize/JsonConfig;
    //   174: invokevirtual 555	com/tencent/biz/authorize/JsonConfig:c	()Ljava/lang/String;
    //   177: astore 6
    //   179: aload 6
    //   181: ifnull +101 -> 282
    //   184: new 421	org/json/JSONObject
    //   187: dup
    //   188: aload 6
    //   190: invokespecial 422	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   193: astore 6
    //   195: aload 6
    //   197: astore_1
    //   198: aload_1
    //   199: ifnonnull +203 -> 402
    //   202: new 421	org/json/JSONObject
    //   205: dup
    //   206: ldc_w 557
    //   209: invokespecial 422	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   212: astore 6
    //   214: aload 6
    //   216: astore_1
    //   217: aload_0
    //   218: aload_1
    //   219: putfield 553	com/tencent/biz/AuthorizeConfig:jdField_c_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   222: aload_1
    //   223: ldc_w 559
    //   226: invokevirtual 562	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   229: astore 6
    //   231: aload 6
    //   233: invokevirtual 396	org/json/JSONArray:length	()I
    //   236: istore 4
    //   238: iconst_0
    //   239: istore_3
    //   240: iload_3
    //   241: iload 4
    //   243: if_icmpge +56 -> 299
    //   246: aload 6
    //   248: iload_3
    //   249: invokevirtual 400	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   252: aload 5
    //   254: invokestatic 564	com/tencent/biz/AuthorizeConfig:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   257: ifeq +33 -> 290
    //   260: iconst_1
    //   261: invokestatic 526	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   264: areturn
    //   265: astore 6
    //   267: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   270: ifeq +12 -> 282
    //   273: ldc 166
    //   275: iconst_2
    //   276: ldc_w 566
    //   279: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: goto -84 -> 198
    //   285: astore 6
    //   287: goto -70 -> 217
    //   290: iload_3
    //   291: iconst_1
    //   292: iadd
    //   293: istore_3
    //   294: goto -54 -> 240
    //   297: astore 5
    //   299: aload_1
    //   300: ldc_w 568
    //   303: invokevirtual 562	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   306: astore 5
    //   308: aload 5
    //   310: invokevirtual 396	org/json/JSONArray:length	()I
    //   313: istore 4
    //   315: iconst_0
    //   316: istore_3
    //   317: iload_3
    //   318: iload 4
    //   320: if_icmpge +30 -> 350
    //   323: aload 5
    //   325: iload_3
    //   326: invokevirtual 400	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   329: aload_2
    //   330: invokevirtual 263	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   333: ifeq +8 -> 341
    //   336: iconst_1
    //   337: invokestatic 526	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   340: areturn
    //   341: iload_3
    //   342: iconst_1
    //   343: iadd
    //   344: istore_3
    //   345: goto -28 -> 317
    //   348: astore 5
    //   350: aload_1
    //   351: ldc_w 570
    //   354: invokevirtual 562	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   357: astore_1
    //   358: aload_1
    //   359: invokevirtual 396	org/json/JSONArray:length	()I
    //   362: istore 4
    //   364: iconst_0
    //   365: istore_3
    //   366: iload_3
    //   367: iload 4
    //   369: if_icmpge +28 -> 397
    //   372: aload_1
    //   373: iload_3
    //   374: invokevirtual 400	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   377: aload_2
    //   378: invokevirtual 263	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   381: ifeq +8 -> 389
    //   384: iconst_1
    //   385: invokestatic 526	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   388: areturn
    //   389: iload_3
    //   390: iconst_1
    //   391: iadd
    //   392: istore_3
    //   393: goto -27 -> 366
    //   396: astore_1
    //   397: iconst_0
    //   398: invokestatic 526	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   401: areturn
    //   402: goto -185 -> 217
    //   405: goto -183 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	408	0	this	AuthorizeConfig
    //   0	408	1	paramString1	String
    //   0	408	2	paramString2	String
    //   239	154	3	i	int
    //   236	134	4	j	int
    //   13	240	5	localObject1	Object
    //   297	1	5	localJSONException1	JSONException
    //   306	18	5	localJSONArray	JSONArray
    //   348	1	5	localJSONException2	JSONException
    //   20	227	6	localObject2	Object
    //   265	1	6	localJSONException3	JSONException
    //   285	1	6	localJSONException4	JSONException
    // Exception table:
    //   from	to	target	type
    //   184	195	265	org/json/JSONException
    //   202	214	285	org/json/JSONException
    //   222	238	297	org/json/JSONException
    //   246	260	297	org/json/JSONException
    //   299	315	348	org/json/JSONException
    //   323	336	348	org/json/JSONException
    //   350	364	396	org/json/JSONException
    //   372	384	396	org/json/JSONException
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      JSONObject localJSONObject;
      do
      {
        return null;
        paramString = paramString.split("\\?");
        localJSONObject = a();
      } while (!localJSONObject.has(paramString[0]));
      try
      {
        paramString = localJSONObject.getJSONObject(paramString[0]).getString("bid");
        return paramString;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("AuthorizeConfig", 2, "getOfflineId error");
    return null;
  }
  
  public String a(String paramString1, String paramString2)
  {
    return b().optString(paramString1, paramString2);
  }
  
  public Set<String> a(String paramString)
  {
    Object localObject1;
    if (TextUtils.isEmpty(paramString)) {
      localObject1 = new HashSet();
    }
    Object localObject2;
    do
    {
      return localObject1;
      localObject2 = (Set)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      localObject1 = localObject2;
    } while (localObject2 != null);
    for (;;)
    {
      int i;
      synchronized (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        localObject2 = (Set)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label234;
        }
        localObject2 = new HashSet(32);
        localObject1 = a(paramString);
        if ((localObject1 != null) && (((JSONArray)localObject1).length() != 0))
        {
          int j = ((JSONArray)localObject1).length();
          i = 0;
          if (i < j) {
            if ("skey".equals(paramString)) {
              ((Set)localObject2).add(b(((JSONArray)localObject1).optString(i, ""), "*."));
            } else {
              ((Set)localObject2).add(((JSONArray)localObject1).optString(i, ""));
            }
          }
        }
      }
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject2);
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("AuthorizeConfig", 2, paramString + " domain white list: " + localObject2);
        localObject1 = localObject2;
      }
      label234:
      return localObject1;
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
    if (FlatBuffersParser.a()) {}
    for (paramString1 = this.jdField_a_of_type_ComTencentBizAuthorizeFlatBuffersConfig.a(localEditor, paramString1); paramString1 == null; paramString1 = this.jdField_a_of_type_ComTencentBizAuthorizeJsonConfig.a(localEditor, paramString1)) {
      return;
    }
    long l = this.jdField_d_of_type_Long;
    this.jdField_d_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("publishSeq", this.jdField_d_of_type_Long);
    QLog.i("AuthorizeConfig", 1, "update white list's publishSeq from " + l + " to " + this.jdField_d_of_type_Long + ".");
    if (TextUtils.isEmpty(paramString1))
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
      localEditor.putLong("lastUpdate", System.currentTimeMillis());
      localEditor.putString("qqVersion", "2013 8.5.5");
      localEditor.putString(paramString3, paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, "White list update completed as version=" + paramString2);
      }
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "webview_whitelist", "update_ok", 0, 1, 0, "", "", "", "");
    }
    for (;;)
    {
      localEditor.commit();
      g();
      i();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      return;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "webview_whitelist", "update_failed", 0, 1, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.e("AuthorizeConfig", 2, "Authorize config parse failed include: " + paramString1);
      }
    }
  }
  
  public boolean a()
  {
    String str = WebCgiWhiteListManager.a();
    if (!TextUtils.isEmpty(str)) {
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, "CgiConfig sp content: " + str);
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_OrgJsonJSONArray = new JSONArray(str);
        if (this.jdField_a_of_type_OrgJsonJSONArray == null) {
          break;
        }
        return true;
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("AuthorizeConfig", 2, "CgiConfig load exception: " + localJSONException.getMessage());
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, "CgiConfig sp content empty!");
      }
    }
    return false;
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
    if (paramString1 == null) {}
    Object localObject;
    do
    {
      while (!((Iterator)localObject).hasNext())
      {
        int i;
        do
        {
          String str;
          do
          {
            return false;
            localObject = Uri.parse(paramString1);
            str = ((Uri)localObject).getScheme();
            if ("file".equals(str))
            {
              paramString2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
              if (paramString1.length() > 200) {
                paramString1 = paramString1.substring(0, 200);
              }
              for (;;)
              {
                ReportController.b(paramString2, "dc00899", "Grp_tech_report", "", "webview", "file_js", 0, 0, paramString1, "", "", "");
                QLog.e("AuthorizeConfig", 1, "action deprecated with file protocol");
                return false;
              }
            }
          } while ((!"http".equals(str)) && (!"https".equals(str)));
          if ("data.checkPermission".equals(paramString2)) {
            return paramString1.startsWith("https://qqweb.qq.com/m/whitelist/testing/");
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
          if (("qbizApi.getClientInfo".equals(paramString2)) && (paramString1.startsWith("https://mysec.qq.com/v2/account_control/index.html"))) {
            return true;
          }
          System.currentTimeMillis();
          i = this.jdField_a_of_type_ComTencentBizAuthorizeJsonConfig.a(((Uri)localObject).getHost(), paramString2);
          if (AbstractConfig.a(i)) {
            return true;
          }
        } while (AbstractConfig.b(i));
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      }
    } while (!((IAuthorizeConfigInjector)((Iterator)localObject).next()).a(paramString1, paramString2));
    return true;
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    return SwiftWebViewUtilss.a(paramJSONObject, "sonicWhiteList");
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
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      JSONObject localJSONObject;
      do
      {
        return null;
        paramString = paramString.split("\\?");
        localJSONObject = a();
      } while (!localJSONObject.has(paramString[0]));
      try
      {
        paramString = localJSONObject.getJSONObject(paramString[0]).getString("duck");
        return paramString;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("AuthorizeConfig", 2, "getCheckUpType error");
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
    if (!TextUtils.isEmpty(str)) {
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, "AsyncCheckConfig sp content: " + str);
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_b_of_type_OrgJsonJSONArray = new JSONArray(str);
        if (this.jdField_b_of_type_OrgJsonJSONArray == null) {
          break;
        }
        return true;
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("AuthorizeConfig", 2, "AsyncCheckConfig load exception: " + localJSONException.getMessage());
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, "AsyncCheckConfig sp content empty!");
      }
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          if ((this.jdField_a_of_type_OrgJsonJSONArray == null) && (!a()))
          {
            if (QLog.isColorLevel())
            {
              QLog.d("AuthorizeConfig", 2, "CgiConfig loadfromsp fail , url: " + Util.b(paramString, new String[0]));
              return false;
            }
          }
          else
          {
            String str1 = Uri.parse(paramString).getHost();
            if ((this.jdField_a_of_type_OrgJsonJSONArray.length() != 0) && (!TextUtils.isEmpty(str1)))
            {
              str1 = str1.toLowerCase();
              int j = this.jdField_a_of_type_OrgJsonJSONArray.length();
              i = 0;
              if (i < j)
              {
                String str2 = this.jdField_a_of_type_OrgJsonJSONArray.optString(i, "");
                if ((TextUtils.isEmpty(str2)) || ((!TextUtils.equals(str1, str2)) && (!str1.endsWith("." + str2)))) {
                  break label250;
                }
                if (!QLog.isColorLevel()) {
                  break label248;
                }
                QLog.d("AuthorizeConfig", 2, "CgiConfig hit , url: " + Util.b(paramString, new String[0]) + " domain: " + str2);
                break label248;
              }
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
      label248:
      return true;
      label250:
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
      if (QLog.isColorLevel()) {
        QLog.i("AuthorizeConfig", 2, "receive X5Config data: " + ((JSONObject)localObject2).toString());
      }
      localObject2 = ((JSONObject)localObject2).optJSONArray("vipGrayConfig2");
      if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
      {
        int i = 0;
        boolean bool3 = true;
        boolean bool1 = true;
        if (i < ((JSONArray)localObject2).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject2).optJSONObject(i);
          boolean bool2 = bool3;
          boolean bool4 = bool1;
          if (localJSONObject != null)
          {
            if (SwiftWebViewUtilss.a(localJSONObject, "X5Config"))
            {
              if (localJSONObject.optInt("mainThreadControl", 0) != 0) {
                break label221;
              }
              bool1 = true;
            }
            label173:
            bool2 = bool3;
            bool4 = bool1;
            if (SwiftWebViewUtilss.a(localJSONObject, "X5Config"))
            {
              if (localJSONObject.optInt("enableQuic", 1) != 1) {
                break label226;
              }
              bool2 = true;
            }
          }
          for (bool4 = bool1;; bool4 = bool1)
          {
            i += 1;
            bool3 = bool2;
            bool1 = bool4;
            break;
            label221:
            bool1 = false;
            break label173;
            label226:
            bool2 = false;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("AuthorizeConfig", 2, "readAndSaveX5Config isInitOnSubThread : " + bool1 + ", enable quick: " + bool3);
        }
        localObject2 = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
        localObject1 = ((AppRuntime)localObject1).getApplication().getSharedPreferences("sp_x5_config_" + (String)localObject2, 4).edit();
        ((SharedPreferences.Editor)localObject1).putBoolean("key_x5_init_sub_thread", bool1);
        ((SharedPreferences.Editor)localObject1).putBoolean("key_x5_enable_quic", bool3);
        ((SharedPreferences.Editor)localObject1).apply();
      }
    }
  }
  
  public boolean c()
  {
    String str = WebCgiWhiteListManager.c();
    if (!TextUtils.isEmpty(str)) {
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, "SkipInputWarningConfig sp content: " + str);
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_c_of_type_OrgJsonJSONArray = new JSONArray(str);
        if (this.jdField_c_of_type_OrgJsonJSONArray == null) {
          break;
        }
        return true;
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("AuthorizeConfig", 2, "SkipInputWarningConfig load exception: " + localJSONException.getMessage());
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, "SkipInputWarningConfig sp content empty!");
      }
    }
    return false;
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
            if (QLog.isColorLevel())
            {
              QLog.d("AuthorizeConfig", 2, "AsyncCheckConfig loadfromsp fail , url: " + Util.b(paramString, new String[0]));
              return false;
            }
          }
          else
          {
            String str1 = Uri.parse(paramString).getHost();
            int j = this.jdField_b_of_type_OrgJsonJSONArray.length();
            if ((j != 0) && (!TextUtils.isEmpty(str1)))
            {
              str1 = str1.toLowerCase();
              i = 0;
              if (i < j)
              {
                String str2 = this.jdField_b_of_type_OrgJsonJSONArray.optString(i, "");
                if ((TextUtils.isEmpty(str2)) || ((!TextUtils.equals(str1, str2)) && (!str1.endsWith("." + str2)))) {
                  break label256;
                }
                if (!QLog.isColorLevel()) {
                  break label254;
                }
                QLog.d("AuthorizeConfig", 2, "AsyncCheckConfig hit , url: " + Util.b(paramString, new String[0]) + " domain: " + str2);
                break label254;
              }
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
      label254:
      return true;
      label256:
      i += 1;
    }
  }
  
  public boolean c(String paramString1, String paramString2)
  {
    Object localObject1;
    if (paramString1 != null)
    {
      localObject1 = paramString1;
      if (!"about:blank".equalsIgnoreCase(paramString1)) {}
    }
    else
    {
      localObject1 = "https://localhost/";
    }
    Object localObject2 = Uri.parse((String)localObject1);
    paramString1 = ((Uri)localObject2).getScheme();
    if ("file".equals(paramString1))
    {
      paramString2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (((String)localObject1).length() > 200)
      {
        paramString1 = ((String)localObject1).substring(0, 200);
        ReportController.b(paramString2, "dc00899", "Grp_tech_report", "", "webview", "file_scheme", 0, 0, paramString1, "", "", "");
        QLog.e("AuthorizeConfig", 1, "action deprecated with file protocol");
      }
    }
    for (;;)
    {
      return false;
      paramString1 = (String)localObject1;
      break;
      if ((!"http".equals(paramString1)) && (!"https".equals(paramString1))) {
        continue;
      }
      localObject1 = this.jdField_f_of_type_OrgJsonJSONObject;
      System.currentTimeMillis();
      paramString1 = (String)localObject1;
      if (localObject1 == null) {}
      try
      {
        paramString1 = this.jdField_a_of_type_ComTencentBizAuthorizeJsonConfig.a();
        if (paramString1 == null)
        {
          try
          {
            localObject1 = new JSONObject("{\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"*.wanggou.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"tel\",\"sms\",\"http\",\"https\",\"file\", \"mqqc2b\"]}");
            paramString1 = (String)localObject1;
          }
          catch (JSONException localJSONException)
          {
            label187:
            do
            {
              JSONArray localJSONArray;
              int k;
              int i;
              break label187;
              localObject2 = paramString1.optJSONArray((String)localObject2);
            } while (localObject2 == null);
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
          this.jdField_f_of_type_OrgJsonJSONObject = paramString1;
          localJSONArray = paramString1.names();
          if (localJSONArray == null) {
            continue;
          }
          localObject2 = ((Uri)localObject2).getHost();
          localObject1 = localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = ((String)localObject2).toLowerCase();
          }
          k = localJSONArray.length();
          i = 0;
          while (i < k)
          {
            localObject2 = localJSONArray.optString(i);
            if (b((String)localObject2, (String)localObject1)) {
              break label296;
            }
            i += 1;
          }
        }
      }
      catch (JSONException paramString1)
      {
        label296:
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AuthorizeConfig", 2, "Decode mSchemeConfig error");
          }
          paramString1 = (String)localObject1;
        }
      }
    }
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
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    JSONObject localJSONObject = VasUpdateUtil.a((AppRuntime)localObject, "VASBiz_FuncDev_webview.json", false, null);
    if ((localJSONObject != null) && (localObject != null) && (((AppRuntime)localObject).isLogin()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AuthorizeConfig", 2, "receive X5PreloadWhiteList data: " + localJSONObject.toString());
      }
      localObject = localJSONObject.optJSONArray("x5PreloadWhiteList");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0)) {
        this.jdField_d_of_type_OrgJsonJSONObject = ((JSONArray)localObject).optJSONObject(0);
      }
    }
  }
  
  public boolean d()
  {
    boolean bool = true;
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
        if (i == 1) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AuthorizeConfig", 2, "forceHttps enable check exception", localException);
      }
    }
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
            if (QLog.isColorLevel())
            {
              QLog.d("AuthorizeConfig", 2, "SkipInputWarningConfig loadfromsp fail , url: " + Util.b(paramString, new String[0]));
              return false;
            }
          }
          else
          {
            String str1 = Uri.parse(paramString).getHost();
            int j = this.jdField_c_of_type_OrgJsonJSONArray.length();
            if ((j != 0) && (!TextUtils.isEmpty(str1)))
            {
              str1 = str1.toLowerCase();
              i = 0;
              if (i < j)
              {
                String str2 = this.jdField_c_of_type_OrgJsonJSONArray.optString(i, "");
                if ((TextUtils.isEmpty(str2)) || ((!TextUtils.equals(str1, str2)) && (!str1.endsWith("." + str2)))) {
                  break label256;
                }
                if (!QLog.isColorLevel()) {
                  break label254;
                }
                QLog.d("AuthorizeConfig", 2, "SkipInputWarningConfig hit , url: " + Util.b(paramString, new String[0]) + " domain: " + str2);
                break label254;
              }
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
      label254:
      return true;
      label256:
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
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("AuthorizeConfig", 2, "readAndSaveSonicWhiteListConfig from VasQuickUpdateManager.SCID_FUNCDEV_WEBVIEW.");
    }
    Object localObject2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    Object localObject1 = VasUpdateUtil.a((AppRuntime)localObject2, "VASBiz_FuncDev_webview.json", false, null);
    Object localObject3;
    if (localObject1 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AuthorizeConfig", 2, "receive WhiteListConfig data: " + ((JSONObject)localObject1).toString());
      }
      localObject1 = ((JSONObject)localObject1).optJSONArray("vipGrayConfig2");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
      {
        if (i >= ((JSONArray)localObject1).length()) {
          break label282;
        }
        localObject3 = ((JSONArray)localObject1).optJSONObject(i);
        if ((localObject3 == null) || (!a((JSONObject)localObject3))) {
          break label243;
        }
      }
    }
    label282:
    for (localObject1 = ((JSONObject)localObject3).optJSONObject("configs");; localObject1 = null)
    {
      localObject3 = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
      localObject2 = ((AppRuntime)localObject2).getApplication().getSharedPreferences("sp_sonic_white_list_config_" + (String)localObject3, 4).edit();
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AuthorizeConfig", 2, "readAndSaveSonicWhiteListConfig: " + ((JSONObject)localObject1).toString());
        }
        ((SharedPreferences.Editor)localObject2).putString("key_sonic_white_list_conifg", ((JSONObject)localObject1).toString());
      }
      for (;;)
      {
        this.jdField_e_of_type_OrgJsonJSONObject = ((JSONObject)localObject1);
        ((SharedPreferences.Editor)localObject2).apply();
        return;
        label243:
        i += 1;
        break;
        QLog.e("AuthorizeConfig", 1, "readAndSaveSonicWhiteListConfig encounter error!. so remove all sonic white list.");
        ((SharedPreferences.Editor)localObject2).remove("key_sonic_white_list_conifg");
      }
      QLog.d("AuthorizeConfig", 1, "readAndSaveSonicWhiteListConfig VasQuickUpdateManager.SCID_FUNCDEV_WEBVIEW is null");
      return;
    }
  }
  
  /* Error */
  public boolean e()
  {
    // Byte code:
    //   0: invokestatic 927	com/tencent/biz/WebCgiWhiteListManager:b	()I
    //   3: istore_2
    //   4: iload_2
    //   5: iconst_1
    //   6: if_icmpne +141 -> 147
    //   9: iconst_1
    //   10: istore_1
    //   11: aload_0
    //   12: iload_1
    //   13: putfield 138	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_Int	I
    //   16: invokestatic 929	com/tencent/biz/WebCgiWhiteListManager:d	()Ljava/lang/String;
    //   19: astore_3
    //   20: aload_3
    //   21: invokestatic 247	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifne +167 -> 191
    //   27: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +29 -> 59
    //   33: ldc 166
    //   35: iconst_2
    //   36: new 283	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 931
    //   46: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_3
    //   50: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: aload_0
    //   60: new 364	org/json/JSONArray
    //   63: dup
    //   64: aload_3
    //   65: invokespecial 375	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   68: putfield 933	com/tencent/biz/AuthorizeConfig:jdField_d_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   71: invokestatic 935	com/tencent/biz/WebCgiWhiteListManager:e	()Ljava/lang/String;
    //   74: astore_3
    //   75: aload_3
    //   76: invokestatic 247	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   79: ifne +169 -> 248
    //   82: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   85: ifeq +29 -> 114
    //   88: ldc 166
    //   90: iconst_2
    //   91: new 283	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   98: ldc_w 937
    //   101: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_3
    //   105: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: aload_0
    //   115: new 364	org/json/JSONArray
    //   118: dup
    //   119: aload_3
    //   120: invokespecial 375	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   123: putfield 939	com/tencent/biz/AuthorizeConfig:jdField_e_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   126: iload_2
    //   127: iconst_m1
    //   128: if_icmpeq +138 -> 266
    //   131: aload_0
    //   132: getfield 933	com/tencent/biz/AuthorizeConfig:jdField_d_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   135: ifnull +131 -> 266
    //   138: aload_0
    //   139: getfield 939	com/tencent/biz/AuthorizeConfig:jdField_e_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   142: ifnull +124 -> 266
    //   145: iconst_1
    //   146: ireturn
    //   147: iconst_0
    //   148: istore_1
    //   149: goto -138 -> 11
    //   152: astore_3
    //   153: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq -85 -> 71
    //   159: ldc 166
    //   161: iconst_2
    //   162: new 283	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   169: ldc_w 941
    //   172: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload_3
    //   176: invokevirtual 392	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   179: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: goto -117 -> 71
    //   191: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq -123 -> 71
    //   197: ldc 166
    //   199: iconst_2
    //   200: ldc_w 943
    //   203: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: goto -135 -> 71
    //   209: astore_3
    //   210: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   213: ifeq -87 -> 126
    //   216: ldc 166
    //   218: iconst_2
    //   219: new 283	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   226: ldc_w 945
    //   229: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload_3
    //   233: invokevirtual 392	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   236: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   245: goto -119 -> 126
    //   248: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   251: ifeq -125 -> 126
    //   254: ldc 166
    //   256: iconst_2
    //   257: ldc_w 947
    //   260: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   263: goto -137 -> 126
    //   266: iconst_0
    //   267: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	this	AuthorizeConfig
    //   10	139	1	i	int
    //   3	126	2	j	int
    //   19	101	3	str	String
    //   152	24	3	localJSONException1	JSONException
    //   209	24	3	localJSONException2	JSONException
    // Exception table:
    //   from	to	target	type
    //   59	71	152	org/json/JSONException
    //   114	126	209	org/json/JSONException
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
            if (QLog.isColorLevel())
            {
              QLog.d("AuthorizeConfig", 2, "forceHttpsConfig loadfromsp fail , url: " + Util.b(paramString, new String[0]));
              return false;
            }
          }
          else
          {
            String str1 = Uri.parse(paramString).getHost();
            int j = this.jdField_d_of_type_OrgJsonJSONArray.length();
            if ((j != 0) && (!TextUtils.isEmpty(str1)))
            {
              str1 = str1.toLowerCase();
              i = 0;
              if (i < j)
              {
                String str2 = this.jdField_d_of_type_OrgJsonJSONArray.optString(i, "");
                if ((TextUtils.isEmpty(str2)) || ((!TextUtils.equals(str1, str2)) && (!str1.endsWith("." + str2)))) {
                  break label256;
                }
                if (!QLog.isColorLevel()) {
                  break label254;
                }
                QLog.d("AuthorizeConfig", 2, "forceHttpsConfig hit , url: " + Util.b(paramString, new String[0]) + " domain: " + str2);
                break label254;
              }
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
      label254:
      return true;
      label256:
      i += 1;
    }
  }
  
  public void f()
  {
    boolean bool = true;
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localObject == null) || (!((AppRuntime)localObject).isLogin()))
    {
      QLog.e("AuthorizeConfig", 1, "loadSonicWhiteListConfigFromSp, runtime is null or is not login!");
      return;
    }
    String str = ((AppRuntime)localObject).getAccount();
    localObject = ((AppRuntime)localObject).getApplication().getSharedPreferences("sp_sonic_white_list_config_" + str, 4).getString("key_sonic_white_list_conifg", null);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      try
      {
        this.jdField_e_of_type_OrgJsonJSONObject = new JSONObject((String)localObject);
        if (this.jdField_e_of_type_OrgJsonJSONObject == null) {
          e();
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        localObject = new StringBuilder().append("loadSonicWhiteListConfigFromSp:  ");
        if (this.jdField_e_of_type_OrgJsonJSONObject == null) {
          break label178;
        }
        QLog.i("AuthorizeConfig", 2, bool);
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("AuthorizeConfig", 2, "", localException);
        continue;
      }
      QLog.e("AuthorizeConfig", 1, "loadSonicWhiteListConfigFromSp is null!");
      continue;
      label178:
      bool = false;
    }
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
            if (QLog.isColorLevel())
            {
              QLog.d("AuthorizeConfig", 2, "forceHttpsExcludeConfig loadfromsp fail , url: " + Util.b(paramString, new String[0]));
              return false;
            }
          }
          else
          {
            String str1 = Uri.parse(paramString).getHost();
            int j = this.jdField_e_of_type_OrgJsonJSONArray.length();
            if ((j != 0) && (!TextUtils.isEmpty(str1)))
            {
              str1 = str1.toLowerCase();
              i = 0;
              if (i < j)
              {
                String str2 = this.jdField_e_of_type_OrgJsonJSONArray.optString(i, "");
                if ((TextUtils.isEmpty(str2)) || ((!TextUtils.equals(str1, str2)) && (!str1.endsWith("." + str2)))) {
                  break label256;
                }
                if (!QLog.isColorLevel()) {
                  break label254;
                }
                QLog.d("AuthorizeConfig", 2, "forceHttpsExcludeConfig hit , url: " + Util.b(paramString, new String[0]) + " domain: " + str2);
                break label254;
              }
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
      label254:
      return true;
      label256:
      i += 1;
    }
  }
  
  public void g()
  {
    long l = System.currentTimeMillis();
    if (l - jdField_e_of_type_Long < 86400000L) {
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 1, new Object[] { "cachePreloadPskeyList too often lastTime:", Long.valueOf(jdField_e_of_type_Long), " interval:", Long.valueOf(86400000L) });
      }
    }
    do
    {
      return;
      if (MobileQQ.sMobileQQ.waitAppRuntime(null).isLogin()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AuthorizeConfig", 2, "cachePreloadPskeyList is not login");
    return;
    if (((WVPreloadPskeyConfBean)QConfigManager.a().a(585)).jdField_a_of_type_Int == 1)
    {
      Object localObject3 = a("pskey");
      ArrayList localArrayList = new ArrayList(((Set)localObject3).size());
      ??? = new HashSet(20);
      Object localObject4 = WebViewConstant.jdField_a_of_type_ArrayOfJavaLangString;
      int j = localObject4.length;
      int i = 0;
      while (i < j)
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
      for (;;)
      {
        synchronized (jdField_a_of_type_JavaLangObject)
        {
          this.jdField_b_of_type_JavaUtilArrayList = localArrayList;
          if (QLog.isColorLevel())
          {
            if (this.jdField_b_of_type_JavaUtilArrayList != null)
            {
              i = this.jdField_b_of_type_JavaUtilArrayList.size();
              QLog.d("AuthorizeConfig", 2, new Object[] { "preloadPskey list:", Integer.valueOf(i), " waitPt4Token:", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
            }
          }
          else
          {
            if (this.jdField_a_of_type_Boolean) {
              break;
            }
            h();
            jdField_e_of_type_Long = l;
            this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("lastPreloadPskey", jdField_e_of_type_Long).commit();
            return;
          }
        }
        i = 0;
      }
    }
    QLog.d("AuthorizeConfig", 1, "do not support preloadPskey.");
  }
  
  public boolean g(String paramString)
  {
    Object localObject = Uri.parse(paramString);
    String str;
    int i;
    boolean bool;
    if ((localObject != null) && (((Uri)localObject).isHierarchical()))
    {
      if (this.jdField_e_of_type_OrgJsonJSONObject == null) {
        f();
      }
      if (this.jdField_e_of_type_OrgJsonJSONObject != null)
      {
        str = ((Uri)localObject).getHost();
        localObject = ((Uri)localObject).getPath();
        if (this.jdField_e_of_type_OrgJsonJSONObject == null) {
          break label273;
        }
        JSONArray localJSONArray = this.jdField_e_of_type_OrgJsonJSONObject.optJSONArray(str);
        if ((localJSONArray == null) || (localJSONArray.length() <= 0)) {
          break label273;
        }
        if (QLog.isColorLevel()) {
          QLog.i("AuthorizeConfig", 2, "isInSonicWhiteList, host: " + str + ", rules: " + localJSONArray.toString());
        }
        i = 0;
        if (i >= localJSONArray.length()) {
          break label273;
        }
        str = localJSONArray.optString(i);
        if ((str.equalsIgnoreCase((String)localObject)) || (str.equals("*"))) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AuthorizeConfig", 2, "isInSonicWhiteList: " + bool + ", url: " + Util.b(paramString, new String[0]));
      }
      return bool;
      if ((str.endsWith("*")) && (((String)localObject).startsWith(str.replace("/*", ""))))
      {
        bool = true;
      }
      else
      {
        i += 1;
        break;
        QLog.e("AuthorizeConfig", 1, "mSonicWhiteListConfig is null! ");
        label273:
        bool = false;
      }
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, "preloadPskey waiting");
      }
    }
    AppRuntime localAppRuntime;
    do
    {
      return;
      localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (localAppRuntime.isLogin()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AuthorizeConfig", 2, "preloadPskey is not login");
    return;
    TicketManager localTicketManager = (TicketManager)localAppRuntime.getManager(2);
    ArrayList localArrayList1 = new ArrayList(20);
    ArrayList localArrayList2 = new ArrayList();
    Object localObject2 = jdField_a_of_type_JavaLangObject;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.jdField_b_of_type_JavaUtilArrayList.size()) {
          if (i < 20) {
            localArrayList1.add(this.jdField_b_of_type_JavaUtilArrayList.get(i));
          } else {
            localArrayList2.add(this.jdField_b_of_type_JavaUtilArrayList.get(i));
          }
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, new Object[] { "preload:", Integer.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size()), " cur:", Integer.valueOf(localArrayList1.size()), " left:", Integer.valueOf(localArrayList2.size()) });
      }
      this.jdField_b_of_type_JavaUtilArrayList = localArrayList2;
      if (localArrayList1.size() == 0) {
        break;
      }
      localObject2 = new String[localArrayList1.size()];
      i = 0;
      while (i < localArrayList1.size())
      {
        localObject2[i] = String.format("(%d)%s", new Object[] { Integer.valueOf(1048576), localArrayList1.get(i) });
        i += 1;
      }
      AuthorizeConfig.4 local4 = new AuthorizeConfig.4(this, localTicketManager, localObject1.getAccount(), (String[])localObject2);
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        local4.run();
        return;
      }
      ThreadManager.post(local4, 8, null, true);
      return;
      i += 1;
    }
  }
  
  public boolean h(String paramString)
  {
    Object localObject = Uri.parse(paramString).getScheme();
    if ((!"http".equals(localObject)) && (!"https".equals(localObject))) {
      return false;
    }
    localObject = a("a1");
    paramString = Uri.parse(paramString).getHost();
    if (!TextUtils.isEmpty(paramString)) {
      paramString = paramString.toLowerCase();
    }
    for (;;)
    {
      if (((Set)localObject).contains(paramString)) {
        return true;
      }
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (b((String)((Iterator)localObject).next(), paramString)) {
          return true;
        }
      }
      return false;
    }
  }
  
  public void i()
  {
    long l = System.currentTimeMillis();
    if (l - jdField_f_of_type_Long < 21600000L) {
      QLog.d("AuthorizeConfig", 1, "preload too often");
    }
    do
    {
      return;
      synchronized (jdField_b_of_type_JavaLangObject)
      {
        if (l - jdField_f_of_type_Long < 21600000L)
        {
          QLog.d("AuthorizeConfig", 1, "preload too often");
          return;
        }
      }
      jdField_f_of_type_Long = l;
      ??? = MobileQQ.sMobileQQ.waitAppRuntime(null);
    } while ((MobileQQ.sProcessId != 1) || (!((AppRuntime)???).isLogin()));
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
      }
      for (;;)
      {
        this.jdField_a_of_type_Boolean = true;
        return;
        ThreadManager.post((Runnable)???, 8, null, true);
      }
    }
    QLog.d("AuthorizeConfig", 1, "do not support preload.");
  }
  
  public boolean i(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = paramString;
      if (!"about:blank".equalsIgnoreCase(paramString)) {}
    }
    else
    {
      localObject = "https://localhost/";
    }
    Uri localUri = Uri.parse((String)localObject);
    paramString = localUri.getScheme();
    if ((!"http".equals(paramString)) && (!"https".equals(paramString))) {
      return false;
    }
    Object localObject = this.jdField_f_of_type_OrgJsonJSONObject;
    System.currentTimeMillis();
    paramString = (String)localObject;
    if (localObject == null) {}
    label169:
    label213:
    label224:
    for (;;)
    {
      try
      {
        paramString = this.jdField_a_of_type_ComTencentBizAuthorizeJsonConfig.a();
        if (paramString == null)
        {
          try
          {
            localObject = new JSONObject("{\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"*.wanggou.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"tel\",\"sms\",\"http\",\"https\",\"file\", \"mqqc2b\"]}");
            paramString = (String)localObject;
          }
          catch (JSONException localJSONException)
          {
            JSONArray localJSONArray;
            continue;
            String str = localUri.getHost();
            paramString = str;
            if (TextUtils.isEmpty(str)) {
              break label169;
            }
            paramString = str.toLowerCase();
            int j = localJSONArray.length();
            int i = 0;
            if (i >= j) {
              break label224;
            }
            str = localJSONArray.optString(i);
            if ((str == null) || (!str.equals("*"))) {
              break label213;
            }
            while (!b(str, paramString))
            {
              i += 1;
              break;
            }
            return true;
            return false;
          }
          localJSONArray = paramString.names();
          if (localJSONArray == null) {
            return false;
          }
        }
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AuthorizeConfig", 2, "Decode mSchemeConfig error");
        }
        paramString = (String)localObject;
      }
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewAuthorizeIAuthorizeConfigDownloadInjector == null) {}
    for (;;)
    {
      return;
      JSONObject localJSONObject = this.jdField_a_of_type_ComTencentMobileqqWebviewAuthorizeIAuthorizeConfigDownloadInjector.a();
      if (localJSONObject == null) {
        break;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((IAuthorizeConfigInjector)localIterator.next()).a(localJSONObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.AuthorizeConfig
 * JD-Core Version:    0.7.0.1
 */