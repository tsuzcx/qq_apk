package com.tencent.biz;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.biz.authorize.AbstractConfig;
import com.tencent.biz.authorize.FlatBuffersConfig;
import com.tencent.biz.authorize.JsonConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.flatbuffers.FlatBuffersParser;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kjd;
import kje;
import kjh;
import kji;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthorizeConfig
{
  public static volatile long a;
  protected static final ArrayMap a;
  protected static AuthorizeConfig a;
  public static final AtomicBoolean a;
  protected static final JSONArray a;
  public static final String[] a;
  public static volatile long b;
  public final Context a;
  public final SharedPreferences a;
  public FlatBuffersConfig a;
  public JsonConfig a;
  public final ConcurrentHashMap a;
  public final AtomicInteger a;
  public volatile JSONObject a;
  public final ConcurrentHashMap b;
  protected volatile JSONArray b;
  public volatile JSONObject b;
  protected volatile long c;
  public volatile JSONArray c;
  public volatile JSONObject c;
  protected volatile long d;
  protected volatile JSONObject d;
  protected volatile JSONObject e;
  protected volatile JSONObject f;
  protected volatile JSONObject g;
  public volatile JSONObject h;
  public volatile JSONObject i;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "skey", "pskey", "a1", "a2", "ptlogin2", "pt4_token" };
    jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap(jdField_a_of_type_ArrayOfJavaLangString.length);
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("skey", "[\"*.qq.com\",\"*.tenpay.com\"]");
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("pskey", "[\"game.qq.com\",\"kg.qq.com\",\"id.qq.com\",\"qzone.qq.com\",\"qzone.com\",\"openmobile.qq.com\", \"tenpay.com\", \"buluo.qq.com\"]");
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("a1", "[]");
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("a2", "[\"aq.qq.com\",\"weloan.tenpay.com\"]");
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("ptlogin2", "[\"http://ptlogin2.qq.com\",\"https://ssl.ptlogin2.qq.com\", \"https://ptlogin2.qq.com\"]");
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("pt4_token", "[\"gamecenter.qq.com\",\"imgcache.qq.com\",\"vip.qq.com\",\"haoma.qq.com\"]");
    jdField_a_of_type_OrgJsonJSONArray = new JSONArray();
    jdField_a_of_type_OrgJsonJSONArray.put("com.tencent.qqcomic.aiogift");
    jdField_a_of_type_Long = -1L;
    jdField_b_of_type_Long = -1L;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private AuthorizeConfig(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
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
    i();
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
        jdField_a_of_type_ComTencentBizAuthorizeConfig.g();
      }
      return jdField_a_of_type_ComTencentBizAuthorizeConfig;
    }
    finally {}
  }
  
  public static AuthorizeConfig a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentBizAuthorizeConfig == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizAuthorizeConfig == null) {
        jdField_a_of_type_ComTencentBizAuthorizeConfig = new AuthorizeConfig(paramContext);
      }
      jdField_a_of_type_ComTencentBizAuthorizeConfig.a();
      jdField_a_of_type_ComTencentBizAuthorizeConfig.a(true);
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
  
  private static String a(String paramString1, String paramString2, Set paramSet)
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
            paramSet = (Set)localObject1;
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
    //   0: new 260	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 261	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: astore_1
    //   10: new 263	java/util/zip/Inflater
    //   13: dup
    //   14: invokespecial 264	java/util/zip/Inflater:<init>	()V
    //   17: astore_3
    //   18: aload_2
    //   19: astore_1
    //   20: aload_3
    //   21: aload_0
    //   22: invokevirtual 268	java/util/zip/Inflater:setInput	([B)V
    //   25: aload_2
    //   26: astore_1
    //   27: sipush 1024
    //   30: newarray byte
    //   32: astore_0
    //   33: aload_2
    //   34: astore_1
    //   35: aload_3
    //   36: invokevirtual 271	java/util/zip/Inflater:finished	()Z
    //   39: ifne +56 -> 95
    //   42: aload_2
    //   43: astore_1
    //   44: aload_2
    //   45: aload_0
    //   46: iconst_0
    //   47: aload_3
    //   48: aload_0
    //   49: invokevirtual 275	java/util/zip/Inflater:inflate	([B)I
    //   52: invokevirtual 279	java/io/ByteArrayOutputStream:write	([BII)V
    //   55: goto -22 -> 33
    //   58: astore_1
    //   59: aload_2
    //   60: astore_0
    //   61: aload_1
    //   62: astore_2
    //   63: aload_0
    //   64: astore_1
    //   65: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +14 -> 82
    //   71: aload_0
    //   72: astore_1
    //   73: ldc 117
    //   75: iconst_2
    //   76: ldc 204
    //   78: aload_2
    //   79: invokestatic 282	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   82: aload_0
    //   83: ifnull +7 -> 90
    //   86: aload_0
    //   87: invokevirtual 285	java/io/ByteArrayOutputStream:close	()V
    //   90: ldc 204
    //   92: astore_0
    //   93: aload_0
    //   94: areturn
    //   95: aload_2
    //   96: astore_1
    //   97: aload_3
    //   98: invokevirtual 288	java/util/zip/Inflater:end	()V
    //   101: aload_2
    //   102: astore_1
    //   103: new 30	java/lang/String
    //   106: dup
    //   107: aload_2
    //   108: invokevirtual 292	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   111: invokespecial 294	java/lang/String:<init>	([B)V
    //   114: astore_3
    //   115: aload_3
    //   116: astore_0
    //   117: aload_2
    //   118: ifnull -25 -> 93
    //   121: aload_2
    //   122: invokevirtual 285	java/io/ByteArrayOutputStream:close	()V
    //   125: aload_3
    //   126: areturn
    //   127: astore_1
    //   128: aload_3
    //   129: astore_0
    //   130: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq -40 -> 93
    //   136: ldc 117
    //   138: iconst_2
    //   139: ldc 204
    //   141: aload_1
    //   142: invokestatic 282	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   145: aload_3
    //   146: areturn
    //   147: astore_0
    //   148: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   151: ifeq -61 -> 90
    //   154: ldc 117
    //   156: iconst_2
    //   157: ldc 204
    //   159: aload_0
    //   160: invokestatic 282	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   163: goto -73 -> 90
    //   166: astore_0
    //   167: aconst_null
    //   168: astore_1
    //   169: aload_1
    //   170: ifnull +7 -> 177
    //   173: aload_1
    //   174: invokevirtual 285	java/io/ByteArrayOutputStream:close	()V
    //   177: aload_0
    //   178: athrow
    //   179: astore_1
    //   180: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   183: ifeq -6 -> 177
    //   186: ldc 117
    //   188: iconst_2
    //   189: ldc 204
    //   191: aload_1
    //   192: invokestatic 282	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   195: goto -18 -> 177
    //   198: astore_0
    //   199: goto -30 -> 169
    //   202: astore_2
    //   203: aconst_null
    //   204: astore_0
    //   205: goto -142 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	paramArrayOfByte	byte[]
    //   9	35	1	localObject1	Object
    //   58	4	1	localThrowable1	java.lang.Throwable
    //   64	39	1	localObject2	Object
    //   127	15	1	localException1	Exception
    //   168	6	1	localObject3	Object
    //   179	13	1	localException2	Exception
    //   7	115	2	localObject4	Object
    //   202	1	2	localThrowable2	java.lang.Throwable
    //   17	129	3	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   10	18	58	java/lang/Throwable
    //   20	25	58	java/lang/Throwable
    //   27	33	58	java/lang/Throwable
    //   35	42	58	java/lang/Throwable
    //   44	55	58	java/lang/Throwable
    //   97	101	58	java/lang/Throwable
    //   103	115	58	java/lang/Throwable
    //   121	125	127	java/lang/Exception
    //   86	90	147	java/lang/Exception
    //   0	8	166	finally
    //   173	177	179	java/lang/Exception
    //   10	18	198	finally
    //   20	25	198	finally
    //   27	33	198	finally
    //   35	42	198	finally
    //   44	55	198	finally
    //   65	71	198	finally
    //   73	82	198	finally
    //   97	101	198	finally
    //   103	115	198	finally
    //   0	8	202	java/lang/Throwable
  }
  
  /* Error */
  private JSONArray a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: invokestatic 184	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +15 -> 21
    //   9: new 70	org/json/JSONArray
    //   12: dup
    //   13: invokespecial 72	org/json/JSONArray:<init>	()V
    //   16: astore 5
    //   18: aload 5
    //   20: areturn
    //   21: aload_0
    //   22: getfield 107	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   25: aload_1
    //   26: invokevirtual 301	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   29: checkcast 70	org/json/JSONArray
    //   32: astore 6
    //   34: aload 6
    //   36: astore 5
    //   38: aload 6
    //   40: ifnonnull -22 -> 18
    //   43: aload_0
    //   44: getfield 107	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   47: astore 8
    //   49: aload 8
    //   51: monitorenter
    //   52: aload_0
    //   53: getfield 107	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   56: aload_1
    //   57: invokevirtual 301	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   60: checkcast 70	org/json/JSONArray
    //   63: astore 5
    //   65: aload 5
    //   67: astore 6
    //   69: aload 5
    //   71: ifnonnull +139 -> 210
    //   74: aload_0
    //   75: getfield 148	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_ComTencentBizAuthorizeJsonConfig	Lcom/tencent/biz/authorize/JsonConfig;
    //   78: aload_1
    //   79: invokevirtual 303	com/tencent/biz/authorize/JsonConfig:a	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   82: astore 6
    //   84: aload 6
    //   86: ifnonnull +195 -> 281
    //   89: new 70	org/json/JSONArray
    //   92: dup
    //   93: getstatic 52	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_AndroidSupportV4UtilArrayMap	Landroid/support/v4/util/ArrayMap;
    //   96: aload_1
    //   97: invokevirtual 304	android/support/v4/util/ArrayMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   100: checkcast 30	java/lang/String
    //   103: invokespecial 307	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   106: astore 5
    //   108: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   111: ifeq +29 -> 140
    //   114: ldc 117
    //   116: iconst_2
    //   117: new 220	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   124: ldc_w 309
    //   127: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_1
    //   131: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 311	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: aload 5
    //   142: astore 6
    //   144: aload 5
    //   146: ifnonnull +44 -> 190
    //   149: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   152: ifeq +29 -> 181
    //   155: ldc 117
    //   157: iconst_2
    //   158: new 220	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   165: aload_1
    //   166: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: ldc_w 313
    //   172: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 311	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: new 70	org/json/JSONArray
    //   184: dup
    //   185: invokespecial 72	org/json/JSONArray:<init>	()V
    //   188: astore 6
    //   190: aload_0
    //   191: getfield 107	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   194: aload_1
    //   195: aload 6
    //   197: invokevirtual 314	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   200: pop
    //   201: aload_0
    //   202: getfield 109	com/tencent/biz/AuthorizeConfig:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   205: aload_1
    //   206: invokevirtual 317	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
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
    //   232: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   235: ifeq +151 -> 386
    //   238: ldc 117
    //   240: iconst_2
    //   241: new 220	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   248: ldc_w 319
    //   251: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload_1
    //   255: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: ldc_w 321
    //   261: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload 6
    //   266: invokevirtual 324	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   269: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokestatic 311	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   278: goto +108 -> 386
    //   281: ldc 34
    //   283: aload_1
    //   284: invokevirtual 200	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   287: istore 4
    //   289: iload 4
    //   291: ifeq +78 -> 369
    //   294: new 70	org/json/JSONArray
    //   297: dup
    //   298: getstatic 52	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_AndroidSupportV4UtilArrayMap	Landroid/support/v4/util/ArrayMap;
    //   301: ldc 34
    //   303: invokevirtual 304	android/support/v4/util/ArrayMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   306: checkcast 30	java/lang/String
    //   309: invokespecial 307	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   312: astore 5
    //   314: aload 5
    //   316: invokevirtual 328	org/json/JSONArray:length	()I
    //   319: istore_2
    //   320: iload_3
    //   321: iload_2
    //   322: if_icmpge +32 -> 354
    //   325: aload 6
    //   327: aload 5
    //   329: iload_3
    //   330: invokevirtual 332	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   333: invokevirtual 79	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   336: pop
    //   337: iload_3
    //   338: iconst_1
    //   339: iadd
    //   340: istore_3
    //   341: goto -21 -> 320
    //   344: aload 7
    //   346: invokevirtual 335	org/json/JSONException:printStackTrace	()V
    //   349: iconst_0
    //   350: istore_2
    //   351: goto -31 -> 320
    //   354: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   357: ifeq +12 -> 369
    //   360: ldc 117
    //   362: iconst_2
    //   363: ldc_w 337
    //   366: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   319	32	2	j	int
    //   1	340	3	k	int
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
  
  private boolean b()
  {
    boolean bool2 = false;
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
          break label121;
        }
        bool1 = "com.tencent.mobileqq".equals(MobileQQ.getMobileQQ().getProcessName());
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
        long l = System.currentTimeMillis() - jdField_b_of_type_Long;
        if (l < 0L) {
          break label126;
        }
        if (l >= 1800000L)
        {
          break label126;
          return bool1;
        }
      }
      int j = 0;
      break label128;
      label121:
      boolean bool1 = false;
      continue;
      label126:
      j = 1;
      label128:
      if (!bool1)
      {
        bool1 = bool2;
        if (j == 0) {}
      }
      else
      {
        bool1 = true;
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
        int j = localJSONObject.getJSONObject(paramString[0]).getInt("delay");
        return j;
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
  
  public Boolean a(String paramString, Boolean paramBoolean)
  {
    return Boolean.valueOf(b().optBoolean(paramString, paramBoolean.booleanValue()));
  }
  
  /* Error */
  public Boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +8 -> 9
    //   4: iconst_0
    //   5: invokestatic 445	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   8: areturn
    //   9: aload_1
    //   10: invokestatic 190	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   13: astore 5
    //   15: aload 5
    //   17: invokevirtual 194	android/net/Uri:getScheme	()Ljava/lang/String;
    //   20: astore 6
    //   22: ldc_w 448
    //   25: aload 6
    //   27: invokevirtual 200	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   30: ifeq +55 -> 85
    //   33: aload_1
    //   34: invokevirtual 359	java/lang/String:length	()I
    //   37: sipush 200
    //   40: if_icmple +42 -> 82
    //   43: aload_1
    //   44: iconst_0
    //   45: sipush 200
    //   48: invokevirtual 398	java/lang/String:substring	(II)Ljava/lang/String;
    //   51: astore_1
    //   52: ldc_w 450
    //   55: ldc_w 452
    //   58: aload_1
    //   59: ldc 204
    //   61: ldc 204
    //   63: ldc 204
    //   65: invokestatic 457	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   68: ldc 117
    //   70: iconst_1
    //   71: ldc_w 459
    //   74: invokestatic 311	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: iconst_0
    //   78: invokestatic 445	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   81: areturn
    //   82: goto -30 -> 52
    //   85: ldc 196
    //   87: aload 6
    //   89: invokevirtual 200	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   92: ifne +18 -> 110
    //   95: ldc 202
    //   97: aload 6
    //   99: invokevirtual 200	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   102: ifne +8 -> 110
    //   105: iconst_0
    //   106: invokestatic 445	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   109: areturn
    //   110: aload 5
    //   112: invokevirtual 210	android/net/Uri:getHost	()Ljava/lang/String;
    //   115: astore_1
    //   116: aload_1
    //   117: astore 5
    //   119: aload_1
    //   120: invokestatic 184	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   123: ifne +9 -> 132
    //   126: aload_1
    //   127: invokevirtual 213	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   130: astore 5
    //   132: aload_0
    //   133: getfield 461	com/tencent/biz/AuthorizeConfig:jdField_c_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   136: astore_1
    //   137: invokestatic 346	java/lang/System:currentTimeMillis	()J
    //   140: pop2
    //   141: aload_1
    //   142: ifnonnull +238 -> 380
    //   145: aload_0
    //   146: getfield 148	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_ComTencentBizAuthorizeJsonConfig	Lcom/tencent/biz/authorize/JsonConfig;
    //   149: invokevirtual 463	com/tencent/biz/authorize/JsonConfig:c	()Ljava/lang/String;
    //   152: astore 6
    //   154: aload 6
    //   156: ifnull +101 -> 257
    //   159: new 350	org/json/JSONObject
    //   162: dup
    //   163: aload 6
    //   165: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   168: astore 6
    //   170: aload 6
    //   172: astore_1
    //   173: aload_1
    //   174: ifnonnull +203 -> 377
    //   177: new 350	org/json/JSONObject
    //   180: dup
    //   181: ldc_w 465
    //   184: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   187: astore 6
    //   189: aload 6
    //   191: astore_1
    //   192: aload_0
    //   193: aload_1
    //   194: putfield 461	com/tencent/biz/AuthorizeConfig:jdField_c_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   197: aload_1
    //   198: ldc_w 467
    //   201: invokevirtual 470	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   204: astore 6
    //   206: aload 6
    //   208: invokevirtual 328	org/json/JSONArray:length	()I
    //   211: istore 4
    //   213: iconst_0
    //   214: istore_3
    //   215: iload_3
    //   216: iload 4
    //   218: if_icmpge +56 -> 274
    //   221: aload 6
    //   223: iload_3
    //   224: invokevirtual 332	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   227: aload 5
    //   229: invokestatic 472	com/tencent/biz/AuthorizeConfig:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   232: ifeq +33 -> 265
    //   235: iconst_1
    //   236: invokestatic 445	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   239: areturn
    //   240: astore 6
    //   242: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq +12 -> 257
    //   248: ldc 117
    //   250: iconst_2
    //   251: ldc_w 474
    //   254: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: goto -84 -> 173
    //   260: astore 6
    //   262: goto -70 -> 192
    //   265: iload_3
    //   266: iconst_1
    //   267: iadd
    //   268: istore_3
    //   269: goto -54 -> 215
    //   272: astore 5
    //   274: aload_1
    //   275: ldc_w 476
    //   278: invokevirtual 470	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   281: astore 5
    //   283: aload 5
    //   285: invokevirtual 328	org/json/JSONArray:length	()I
    //   288: istore 4
    //   290: iconst_0
    //   291: istore_3
    //   292: iload_3
    //   293: iload 4
    //   295: if_icmpge +30 -> 325
    //   298: aload 5
    //   300: iload_3
    //   301: invokevirtual 332	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   304: aload_2
    //   305: invokevirtual 200	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   308: ifeq +8 -> 316
    //   311: iconst_1
    //   312: invokestatic 445	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   315: areturn
    //   316: iload_3
    //   317: iconst_1
    //   318: iadd
    //   319: istore_3
    //   320: goto -28 -> 292
    //   323: astore 5
    //   325: aload_1
    //   326: ldc_w 478
    //   329: invokevirtual 470	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   332: astore_1
    //   333: aload_1
    //   334: invokevirtual 328	org/json/JSONArray:length	()I
    //   337: istore 4
    //   339: iconst_0
    //   340: istore_3
    //   341: iload_3
    //   342: iload 4
    //   344: if_icmpge +28 -> 372
    //   347: aload_1
    //   348: iload_3
    //   349: invokevirtual 332	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   352: aload_2
    //   353: invokevirtual 200	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   356: ifeq +8 -> 364
    //   359: iconst_1
    //   360: invokestatic 445	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   363: areturn
    //   364: iload_3
    //   365: iconst_1
    //   366: iadd
    //   367: istore_3
    //   368: goto -27 -> 341
    //   371: astore_1
    //   372: iconst_0
    //   373: invokestatic 445	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   376: areturn
    //   377: goto -185 -> 192
    //   380: goto -183 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	383	0	this	AuthorizeConfig
    //   0	383	1	paramString1	String
    //   0	383	2	paramString2	String
    //   214	154	3	j	int
    //   211	134	4	k	int
    //   13	215	5	localObject1	Object
    //   272	1	5	localJSONException1	JSONException
    //   281	18	5	localJSONArray	JSONArray
    //   323	1	5	localJSONException2	JSONException
    //   20	202	6	localObject2	Object
    //   240	1	6	localJSONException3	JSONException
    //   260	1	6	localJSONException4	JSONException
    // Exception table:
    //   from	to	target	type
    //   159	170	240	org/json/JSONException
    //   177	189	260	org/json/JSONException
    //   197	213	272	org/json/JSONException
    //   221	235	272	org/json/JSONException
    //   274	290	323	org/json/JSONException
    //   298	311	323	org/json/JSONException
    //   325	339	371	org/json/JSONException
    //   347	359	371	org/json/JSONException
  }
  
  public String a(String paramString)
  {
    return null;
  }
  
  public String a(String paramString1, String paramString2)
  {
    return b().optString(paramString1, paramString2);
  }
  
  public Set a(String paramString)
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
      int j;
      synchronized (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        localObject2 = (Set)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label232;
        }
        localObject2 = new HashSet(32);
        localObject1 = a(paramString);
        if ((localObject1 != null) && (((JSONArray)localObject1).length() != 0))
        {
          int k = ((JSONArray)localObject1).length();
          j = 0;
          if (j < k) {
            if ("skey".equals(paramString)) {
              ((Set)localObject2).add(b(((JSONArray)localObject1).optString(j, ""), "*."));
            } else {
              ((Set)localObject2).add(((JSONArray)localObject1).optString(j, ""));
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
      label232:
      return localObject1;
      j += 1;
    }
  }
  
  protected void a()
  {
    ThreadManager.executeOnSubThread(new kjd(this));
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
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
      localEditor.putString("qqVersion", "2013 7.6.0");
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
    String str = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("sp_cgi_whitelist", 4).getString("whitelist_config_json", null);
    if (!TextUtils.isEmpty(str)) {
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, "CgiConfig sp content: " + str);
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
    int k = ((JSONArray)localObject).length();
    int j = 0;
    while (j < k)
    {
      if (b(((JSONArray)localObject).optString(j), paramString)) {
        return true;
      }
      j += 1;
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return false;
    }
    Uri localUri = Uri.parse(paramString1);
    String str = localUri.getScheme();
    if ("file".equals(str))
    {
      if (paramString1.length() > 200) {
        paramString1 = paramString1.substring(0, 200);
      }
      for (;;)
      {
        TroopTechReportUtils.a("webview", "file_js", paramString1, "", "", "");
        QLog.e("AuthorizeConfig", 1, "action deprecated with file protocol");
        return false;
      }
    }
    if ((!"http".equals(str)) && (!"https".equals(str))) {
      return false;
    }
    if ("data.checkPermission".equals(paramString2)) {
      return paramString1.startsWith("http://qqweb.qq.com/m/whitelist/testing/");
    }
    if (paramString2.startsWith("CAPTCHA.")) {
      return true;
    }
    System.currentTimeMillis();
    int j = this.jdField_a_of_type_ComTencentBizAuthorizeJsonConfig.a(localUri.getHost(), paramString2);
    if (AbstractConfig.a(j)) {
      return true;
    }
    if (AbstractConfig.b(j)) {
      return false;
    }
    if ("publicAccountNew.config".equals(paramString2)) {
      return true;
    }
    if (PublicAccountH5AbilityPlugin.a(paramString1)) {
      return (!TextUtils.isEmpty(paramString2)) && (PublicAccountH5AbilityPlugin.a(paramString1, paramString2));
    }
    return false;
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    return SwiftWebViewUtils.a(paramJSONObject, "sonicWhiteList");
  }
  
  protected boolean a(boolean paramBoolean)
  {
    if (b())
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
      ThreadManager.executeOnNetWorkThread(new kje(this, paramBoolean));
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
  
  public void b()
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.remove("lastVersion");
    localEditor.commit();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
    a(false);
  }
  
  public boolean b(String paramString)
  {
    for (;;)
    {
      int j;
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          if ((this.jdField_b_of_type_OrgJsonJSONArray == null) && (!a()))
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
            if ((this.jdField_b_of_type_OrgJsonJSONArray.length() != 0) && (!TextUtils.isEmpty(str1)))
            {
              str1 = str1.toLowerCase();
              int k = this.jdField_b_of_type_OrgJsonJSONArray.length();
              j = 0;
              if (j < k)
              {
                String str2 = this.jdField_b_of_type_OrgJsonJSONArray.optString(j, "");
                if ((TextUtils.isEmpty(str2)) || ((!TextUtils.equals(str1, str2)) && (!str1.endsWith("." + str2)))) {
                  break label248;
                }
                if (!QLog.isColorLevel()) {
                  break label246;
                }
                QLog.d("AuthorizeConfig", 2, "CgiConfig hit , url: " + Util.b(paramString, new String[0]) + " domain: " + str2);
                break label246;
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
      label246:
      return true;
      label248:
      j += 1;
    }
  }
  
  public String c(String paramString)
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
  
  public void c()
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.i("AuthorizeConfig", 2, "readAndSaveX5Config from VasQuickUpdateManager.SCID_FUNCDEV_WEBVIEW.");
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject = VasQuickUpdateManager.a(localAppRuntime, "VASBiz_FuncDev_webview.json", false, null);
    int j;
    if ((localObject != null) && (localAppRuntime != null) && (localAppRuntime.isLogin()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AuthorizeConfig", 2, "receive X5Config data: " + ((JSONObject)localObject).toString());
      }
      localObject = ((JSONObject)localObject).optJSONArray("vipGrayConfig2");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        j = 0;
        if (j >= ((JSONArray)localObject).length()) {
          break label258;
        }
        JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(j);
        if ((localJSONObject == null) || (!SwiftWebViewUtils.a(localJSONObject, "X5Config"))) {
          break label251;
        }
        if (localJSONObject.optInt("mainThreadControl", 0) != 0) {}
      }
    }
    label258:
    for (bool = true;; bool = true)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AuthorizeConfig", 2, "readAndSaveX5Config isInitOnSubThread : " + bool);
      }
      localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localAppRuntime.getApplication().getSharedPreferences("sp_x5_config_" + (String)localObject, 4).edit().putBoolean("key_x5_init_sub_thread", bool).apply();
      return;
      label251:
      j += 1;
      break;
    }
  }
  
  public boolean c(String paramString)
  {
    Object localObject = Uri.parse(paramString);
    String str;
    int j;
    boolean bool;
    if ((localObject != null) && (((Uri)localObject).isHierarchical()))
    {
      if (this.h == null) {
        f();
      }
      if (this.h != null)
      {
        str = ((Uri)localObject).getHost();
        localObject = ((Uri)localObject).getPath();
        if (this.h == null) {
          break label272;
        }
        JSONArray localJSONArray = this.h.optJSONArray(str);
        if ((localJSONArray == null) || (localJSONArray.length() <= 0)) {
          break label272;
        }
        if (QLog.isColorLevel()) {
          QLog.i("AuthorizeConfig", 2, "isInSonicWhiteList, host: " + str + ", rules: " + localJSONArray.toString());
        }
        j = 0;
        if (j >= localJSONArray.length()) {
          break label272;
        }
        str = localJSONArray.optString(j);
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
        j += 1;
        break;
        QLog.e("AuthorizeConfig", 1, "mSonicWhiteListConfig is null! ");
        label272:
        bool = false;
      }
    }
  }
  
  public boolean c(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      localObject1 = paramString1;
      if (!"about:blank".equalsIgnoreCase(paramString1)) {}
    }
    else
    {
      localObject1 = "http://localhost/";
    }
    Object localObject3 = Uri.parse((String)localObject1);
    paramString1 = ((Uri)localObject3).getScheme();
    if ("file".equals(paramString1))
    {
      if (((String)localObject1).length() > 200) {}
      for (paramString1 = ((String)localObject1).substring(0, 200);; paramString1 = (String)localObject1)
      {
        TroopTechReportUtils.a("webview", "file_scheme", paramString1, "", "", "");
        QLog.e("AuthorizeConfig", 1, "action deprecated with file protocol");
        return false;
      }
    }
    if ((!"http".equals(paramString1)) && (!"https".equals(paramString1))) {
      return false;
    }
    Object localObject1 = this.i;
    System.currentTimeMillis();
    paramString1 = (String)localObject1;
    if (localObject1 == null) {}
    label235:
    for (;;)
    {
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
            JSONArray localJSONArray;
            continue;
            localObject3 = ((Uri)localObject3).getHost();
            Object localObject2 = localObject3;
            if (TextUtils.isEmpty((CharSequence)localObject3)) {
              break label235;
            }
            localObject2 = ((String)localObject3).toLowerCase();
            int m = localJSONArray.length();
            int j = 0;
            if (j >= m) {
              break label330;
            }
            localObject3 = localJSONArray.optString(j);
            if (b((String)localObject3, (String)localObject2)) {
              break label275;
            }
            for (;;)
            {
              j += 1;
              break;
              localObject3 = paramString1.optJSONArray((String)localObject3);
              if (localObject3 != null)
              {
                int n = ((JSONArray)localObject3).length();
                int k = 0;
                while (k < n)
                {
                  if (b(((JSONArray)localObject3).optString(k), paramString2)) {
                    return true;
                  }
                  k += 1;
                }
              }
            }
            return false;
          }
          this.i = paramString1;
          localJSONArray = paramString1.names();
          if (localJSONArray == null) {
            return false;
          }
        }
      }
      catch (JSONException paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AuthorizeConfig", 2, "Decode mSchemeConfig error");
        }
        paramString1 = (String)localObject1;
      }
    }
  }
  
  public String d(String paramString)
  {
    return a("p_skey", paramString, a("pskey"));
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AuthorizeConfig", 2, "readAndSaveX5PreloadWhiteListConfig from VasQuickUpdateManager.SCID_FUNCDEV_WEBVIEW.");
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    JSONObject localJSONObject = VasQuickUpdateManager.a((AppRuntime)localObject, "VASBiz_FuncDev_webview.json", false, null);
    if ((localJSONObject != null) && (localObject != null) && (((AppRuntime)localObject).isLogin()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AuthorizeConfig", 2, "receive X5PreloadWhiteList data: " + localJSONObject.toString());
      }
      localObject = localJSONObject.optJSONArray("x5PreloadWhiteList");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0)) {
        this.g = ((JSONArray)localObject).optJSONObject(0);
      }
    }
  }
  
  public boolean d(String paramString)
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
  
  public String e(String paramString)
  {
    return a("pt4_token", paramString, a("pt4_token"));
  }
  
  public void e()
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.i("AuthorizeConfig", 2, "readAndSaveSonicWhiteListConfig from VasQuickUpdateManager.SCID_FUNCDEV_WEBVIEW.");
    }
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1 = VasQuickUpdateManager.a((AppRuntime)localObject2, "VASBiz_FuncDev_webview.json", false, null);
    Object localObject3;
    if (localObject1 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AuthorizeConfig", 2, "receive WhiteListConfig data: " + ((JSONObject)localObject1).toString());
      }
      localObject1 = ((JSONObject)localObject1).optJSONArray("vipGrayConfig2");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
      {
        if (j >= ((JSONArray)localObject1).length()) {
          break label280;
        }
        localObject3 = ((JSONArray)localObject1).optJSONObject(j);
        if ((localObject3 == null) || (!a((JSONObject)localObject3))) {
          break label241;
        }
      }
    }
    label280:
    for (localObject1 = ((JSONObject)localObject3).optJSONObject("configs");; localObject1 = null)
    {
      localObject3 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
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
        this.h = ((JSONObject)localObject1);
        ((SharedPreferences.Editor)localObject2).apply();
        return;
        label241:
        j += 1;
        break;
        QLog.e("AuthorizeConfig", 1, "readAndSaveSonicWhiteListConfig encounter error!. so remove all sonic white list.");
        ((SharedPreferences.Editor)localObject2).remove("key_sonic_white_list_conifg");
      }
      QLog.d("AuthorizeConfig", 1, "readAndSaveSonicWhiteListConfig VasQuickUpdateManager.SCID_FUNCDEV_WEBVIEW is null");
      return;
    }
  }
  
  public boolean e(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = paramString;
      if (!"about:blank".equalsIgnoreCase(paramString)) {}
    }
    else
    {
      localObject = "http://localhost/";
    }
    Uri localUri = Uri.parse((String)localObject);
    paramString = localUri.getScheme();
    if ((!"http".equals(paramString)) && (!"https".equals(paramString))) {
      return false;
    }
    Object localObject = this.i;
    System.currentTimeMillis();
    paramString = (String)localObject;
    if (localObject == null) {}
    label167:
    label211:
    label222:
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
              break label167;
            }
            paramString = str.toLowerCase();
            int k = localJSONArray.length();
            int j = 0;
            if (j >= k) {
              break label222;
            }
            str = localJSONArray.optString(j);
            if ((str == null) || (!str.equals("*"))) {
              break label211;
            }
            while (!b(str, paramString))
            {
              j += 1;
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
  
  public String f(String paramString)
  {
    return a("a2", paramString, a("a2"));
  }
  
  public void f()
  {
    boolean bool = true;
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
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
        this.h = new JSONObject((String)localObject);
        if (this.h == null) {
          e();
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        localObject = new StringBuilder().append("loadSonicWhiteListConfigFromSp:  ");
        if (this.h == null) {
          break label176;
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
      label176:
      bool = false;
    }
  }
  
  public boolean f(String paramString)
  {
    i();
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      Object localObject1 = Uri.parse(paramString);
      Object localObject2 = ((Uri)localObject1).getScheme();
      if (("http".equals(localObject2)) || ("https".equals(localObject2)))
      {
        localObject1 = ((Uri)localObject1).getHost();
        localObject2 = this.jdField_d_of_type_OrgJsonJSONObject;
        if (QLog.isColorLevel()) {
          QLog.d("AuthorizeConfig", 1, "WebViewSwitchAio call canSwitchAIO url " + paramString + " config " + localObject2);
        }
        if ((localObject2 != null) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (((JSONObject)localObject2).optInt("enable", 0) == 1))
        {
          paramString = ((JSONObject)localObject2).optJSONArray("domains");
          if (paramString != null)
          {
            int j = paramString.length() - 1;
            while (j >= 0)
            {
              if (((String)localObject1).endsWith(paramString.optString(j))) {
                return true;
              }
              j -= 1;
            }
          }
        }
      }
    }
  }
  
  public void g()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject1 instanceof QQAppInterface)) {}
    while ((!((AppRuntime)localObject1).isLogin()) && (!"com.tencent.mobileqq".equals(MobileQQ.getMobileQQ().getProcessName()))) {
      return;
    }
    if (com.tencent.mobileqq.webprocess.WebAccelerateHelper.getInstance().getWebViewFeatureParams()[3].intValue() == 1)
    {
      TicketManager localTicketManager = (TicketManager)((AppRuntime)localObject1).getManager(2);
      Object localObject2 = a("pt4_token");
      String[] arrayOfString = new String[((Set)localObject2).size()];
      localObject2 = ((Set)localObject2).iterator();
      int j = 0;
      while (((Iterator)localObject2).hasNext())
      {
        arrayOfString[j] = String.format("(%d)%s", new Object[] { Integer.valueOf(134217728), (String)((Iterator)localObject2).next() });
        j += 1;
      }
      localObject1 = new kjh(this, localTicketManager, ((AppRuntime)localObject1).getAccount(), arrayOfString);
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        ((Runnable)localObject1).run();
        return;
      }
      ThreadManager.post((Runnable)localObject1, 8, null, true);
      return;
    }
    QLog.d("AuthorizeConfig", 1, "do not support preload.");
  }
  
  public boolean g(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    i();
    Object localObject = this.f;
    JSONArray localJSONArray = null;
    if (localObject != null) {
      localJSONArray = ((JSONObject)localObject).optJSONArray("validArkNames");
    }
    if (localObject != null)
    {
      localObject = localJSONArray;
      if (localJSONArray != null) {}
    }
    else
    {
      localObject = jdField_a_of_type_OrgJsonJSONArray;
    }
    int j = ((JSONArray)localObject).length() - 1;
    while (j >= 0)
    {
      if (paramString.equals(((JSONArray)localObject).optString(j))) {
        return true;
      }
      j -= 1;
    }
    return false;
  }
  
  public void h()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface))
    {
      QLog.d("AuthorizeConfig", 1, "WebViewSwitchAio main process loadFuncDevWebViewConfig");
      localObject1 = VasQuickUpdateManager.a((AppRuntime)localObject1, "VASBiz_FuncDev_webview.json", true, null);
    }
    while (localObject1 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 1, "WebViewSwitchAio loadFuncDevWebViewConfig return " + ((JSONObject)localObject1).toString());
      }
      Object localObject2 = ((JSONObject)localObject1).optJSONArray("WebViewSwitchAioConfig");
      if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0)) {
        this.jdField_d_of_type_OrgJsonJSONObject = ((JSONArray)localObject2).optJSONObject(0);
      }
      localObject2 = ((JSONObject)localObject1).optJSONArray("WebViewWhiteScreenDomains");
      if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0)) {
        this.e = ((JSONArray)localObject2).optJSONObject(0);
      }
      localObject1 = ((JSONObject)localObject1).optJSONArray("arkShareWhiteList");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0)) {
        this.f = ((JSONArray)localObject1).optJSONObject(0);
      }
      return;
      localObject2 = VasQuickUpdateManager.a((AppRuntime)localObject1, "VASBiz_FuncDev_webview.json", false, null);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        QLog.d("AuthorizeConfig", 1, "WebViewSwitchAio calling main process to download FuncDevWebViewConfig");
        localObject1 = DataFactory.a("download_FuncDev_webview", "", 0, null);
        WebIPCOperator.a().b((Bundle)localObject1);
        localObject1 = localObject2;
      }
    }
    QLog.d("AuthorizeConfig", 1, "WebViewSwitchAio loadFuncDevWebViewConfig return null");
  }
  
  public boolean h(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (this.g == null) {
      d();
    }
    Object localObject = this.g;
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
    int j = ((JSONArray)localObject).length() - 1;
    while (j >= 0)
    {
      if (b(((JSONArray)localObject).optString(j), paramString)) {
        return true;
      }
      j -= 1;
    }
    return false;
  }
  
  public void i()
  {
    try
    {
      long l = System.currentTimeMillis();
      if ((l - this.jdField_c_of_type_Long < 1800000L) && (this.jdField_d_of_type_OrgJsonJSONObject != null) && (this.f != null)) {
        return;
      }
      this.jdField_c_of_type_Long = l;
      ThreadManager.post(new kji(this), 5, null, false);
      return;
    }
    finally {}
  }
  
  public boolean i(String paramString)
  {
    i();
    Object localObject = this.e;
    if (QLog.isColorLevel()) {
      QLog.d("AuthorizeConfig", 1, "isInWhiteScreenWhiteList is called of domain " + paramString + " config " + localObject);
    }
    if ((localObject != null) && (!TextUtils.isEmpty(paramString)))
    {
      localObject = ((JSONObject)localObject).optJSONArray("domains");
      if (localObject != null)
      {
        int j = ((JSONArray)localObject).length() - 1;
        while (j >= 0)
        {
          if (paramString.endsWith(((JSONArray)localObject).optString(j))) {
            return true;
          }
          j -= 1;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.AuthorizeConfig
 * JD-Core Version:    0.7.0.1
 */