package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CouponH5Data;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ThreeDes;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mdh;
import mdi;
import mdk;
import mdm;
import mdo;
import mdp;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyWebDataManager
{
  public static int a;
  private static long jdField_a_of_type_Long;
  private static ReadInJoyWebDataManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoReadInJoyWebDataManager;
  public static String a;
  public static List a;
  public static int b;
  public static String b;
  public static String c = "3";
  public static String d = "4";
  public static String e = "1";
  public static String f = "0";
  public static String g = "1";
  public static String h = "2";
  public static String i = "3";
  private static final String j = "QQ/7.6.8 Android/0.17 Android/" + Build.VERSION.RELEASE;
  private volatile HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private long b;
  private String k = "";
  private String l = "";
  private String m = "";
  private String n = "";
  private String o = "";
  
  static
  {
    jdField_a_of_type_Int = 404;
    jdField_b_of_type_Int = 200;
    jdField_a_of_type_JavaUtilList = new ArrayList();
    jdField_a_of_type_JavaLangString = "1";
    jdField_b_of_type_JavaLangString = "2";
  }
  
  public static ReadInJoyWebDataManager a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoReadInJoyWebDataManager == null) {
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoReadInJoyWebDataManager = new ReadInJoyWebDataManager();
    }
    return jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoReadInJoyWebDataManager;
  }
  
  public static String a(String paramString)
  {
    long l1 = 5381L;
    int i1 = 0;
    while (i1 < paramString.length())
    {
      l1 += (l1 << 5 & 0x7FFFFFFF) + paramString.charAt(i1);
      i1 += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.w("ReadInJoyWebDataManager", 2, "getCSRFToken " + (l1 & 0x7FFFFFFF));
    }
    return String.valueOf(l1 & 0x7FFFFFFF);
  }
  
  private String a(String paramString1, String paramString2)
  {
    return ThreeDes.a(paramString1, paramString2);
  }
  
  public static void a()
  {
    for (;;)
    {
      JSONArray localJSONArray;
      synchronized (jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
        if (QLog.isColorLevel()) {
          QLog.w("ReadInJoyWebDataManager", 2, "addLog :TLogCache size :" + jdField_a_of_type_JavaUtilList.size());
        }
        if (jdField_a_of_type_JavaUtilList.size() <= 0) {
          return;
        }
        try
        {
          localJSONArray = new JSONArray();
          if (!localIterator.hasNext()) {
            break label145;
          }
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("postTime", System.currentTimeMillis() / 1000L);
          localJSONObject.put("logContent", localIterator.next());
          localJSONArray.put(localJSONObject);
          continue;
          jdField_a_of_type_JavaUtilList.clear();
        }
        catch (JSONException localJSONException) {}
        return;
      }
      label145:
      a(localJSONArray.toString());
    }
  }
  
  public static void a(String paramString)
  {
    AppRuntime localAppRuntime = ReadInJoyUtils.a();
    if (localAppRuntime == null) {
      return;
    }
    ThreadManager.post(new mdm(localAppRuntime, paramString), 5, null, true);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = (QQAppInterface)ReadInJoyUtils.a();
    if (localObject == null) {
      return;
    }
    localObject = ((QQAppInterface)localObject).getEntityManagerFactory(((QQAppInterface)localObject).getAccount()).createEntityManager();
    CouponH5Data localCouponH5Data = (CouponH5Data)((EntityManager)localObject).a(CouponH5Data.class, "mHost = ? AND mPath = ? AND mKey = ?", new String[] { paramString1, paramString2, paramString3 });
    if (localCouponH5Data == null) {
      ((EntityManager)localObject).a(new CouponH5Data(paramString1, paramString2, paramString3, paramString4));
    }
    for (;;)
    {
      ((EntityManager)localObject).a();
      return;
      localCouponH5Data.mData = paramString4;
      ((EntityManager)localObject).a(localCouponH5Data);
    }
  }
  
  private void a(String paramString1, JSONObject paramJSONObject, String paramString2, mdp parammdp)
  {
    ThreadManager.post(new mdk(this, paramString1, paramString2, parammdp, paramJSONObject), 5, null, true);
  }
  
  /* Error */
  private void a(URL paramURL, String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: invokestatic 234	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyUtils:a	()Lmqq/app/AppRuntime;
    //   3: checkcast 248	com/tencent/mobileqq/app/QQAppInterface
    //   6: astore 9
    //   8: aload 9
    //   10: ifnonnull +4 -> 14
    //   13: return
    //   14: new 184	org/json/JSONObject
    //   17: dup
    //   18: aload_2
    //   19: invokespecial 293	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   22: astore 10
    //   24: aload 10
    //   26: ldc_w 295
    //   29: invokevirtual 298	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   32: astore 8
    //   34: aload 8
    //   36: astore 7
    //   38: aload 8
    //   40: invokestatic 304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   43: ifne +25 -> 68
    //   46: aload 8
    //   48: ldc_w 306
    //   51: ldc_w 308
    //   54: invokevirtual 312	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   57: ldc_w 314
    //   60: ldc_w 316
    //   63: invokevirtual 312	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   66: astore 7
    //   68: aload 4
    //   70: ldc_w 295
    //   73: aload 7
    //   75: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   78: pop
    //   79: getstatic 111	com/tencent/biz/pubaccount/readinjoy/video/ReadInJoyWebDataManager:jdField_a_of_type_Long	J
    //   82: ldc2_w 317
    //   85: lcmp
    //   86: ifle +20 -> 106
    //   89: new 320	mdj
    //   92: dup
    //   93: aload_0
    //   94: aload_1
    //   95: aload_2
    //   96: aload_3
    //   97: aload 4
    //   99: invokespecial 322	mdj:<init>	(Lcom/tencent/biz/pubaccount/readinjoy/video/ReadInJoyWebDataManager;Ljava/net/URL;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V
    //   102: invokestatic 326	com/tencent/mobileqq/app/ThreadManager:executeOnNetWorkThread	(Ljava/lang/Runnable;)V
    //   105: return
    //   106: aload 10
    //   108: ldc_w 328
    //   111: invokevirtual 298	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   114: astore_3
    //   115: aload_3
    //   116: invokestatic 304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   119: ifne +422 -> 541
    //   122: aload 10
    //   124: ldc_w 330
    //   127: invokevirtual 298	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   130: astore 4
    //   132: aload 4
    //   134: invokestatic 304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   137: ifne +404 -> 541
    //   140: aload 10
    //   142: ldc_w 332
    //   145: invokevirtual 298	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   148: astore 7
    //   150: aload 7
    //   152: invokestatic 304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   155: ifne +386 -> 541
    //   158: aload_1
    //   159: invokevirtual 337	java/net/URL:getHost	()Ljava/lang/String;
    //   162: astore_1
    //   163: aload 10
    //   165: ldc_w 339
    //   168: invokevirtual 298	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   171: astore_2
    //   172: aload_2
    //   173: invokestatic 304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   176: ifne +362 -> 538
    //   179: aload_2
    //   180: aload_1
    //   181: invokestatic 342	com/tencent/biz/pubaccount/readinjoy/video/ReadInJoyWebDataManager:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   184: ifeq +357 -> 541
    //   187: aload_2
    //   188: astore_1
    //   189: aload_1
    //   190: astore_2
    //   191: aload_1
    //   192: invokestatic 304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   195: ifeq +7 -> 202
    //   198: ldc_w 344
    //   201: astore_2
    //   202: aload_0
    //   203: aload 7
    //   205: invokespecial 346	com/tencent/biz/pubaccount/readinjoy/video/ReadInJoyWebDataManager:b	(Ljava/lang/String;)Ljava/lang/String;
    //   208: astore_1
    //   209: aload_0
    //   210: aload_2
    //   211: aload_3
    //   212: aload 4
    //   214: aload_1
    //   215: invokespecial 348	com/tencent/biz/pubaccount/readinjoy/video/ReadInJoyWebDataManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   218: aload_0
    //   219: aload 7
    //   221: aload_1
    //   222: invokespecial 349	com/tencent/biz/pubaccount/readinjoy/video/ReadInJoyWebDataManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   225: astore 7
    //   227: new 351	java/io/File
    //   230: dup
    //   231: new 29	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   238: getstatic 354	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   241: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: ldc_w 356
    //   247: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload 9
    //   252: invokevirtual 251	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   255: invokestatic 359	com/tencent/mobileqq/utils/HexUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   258: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokespecial 360	java/io/File:<init>	(Ljava/lang/String;)V
    //   267: astore_1
    //   268: aload_1
    //   269: invokevirtual 363	java/io/File:exists	()Z
    //   272: ifne +153 -> 425
    //   275: aload_1
    //   276: invokevirtual 366	java/io/File:mkdirs	()Z
    //   279: pop
    //   280: new 351	java/io/File
    //   283: dup
    //   284: aload_1
    //   285: aload_2
    //   286: invokespecial 369	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   289: astore_1
    //   290: aload_1
    //   291: invokevirtual 363	java/io/File:exists	()Z
    //   294: ifne +151 -> 445
    //   297: aload_1
    //   298: invokevirtual 366	java/io/File:mkdirs	()Z
    //   301: pop
    //   302: new 351	java/io/File
    //   305: dup
    //   306: aload_1
    //   307: aload_3
    //   308: invokestatic 359	com/tencent/mobileqq/utils/HexUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   311: invokespecial 369	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   314: astore 8
    //   316: aload 8
    //   318: invokevirtual 363	java/io/File:exists	()Z
    //   321: ifne +144 -> 465
    //   324: aload 8
    //   326: invokevirtual 366	java/io/File:mkdirs	()Z
    //   329: pop
    //   330: aconst_null
    //   331: astore_2
    //   332: aconst_null
    //   333: astore_1
    //   334: aconst_null
    //   335: astore_3
    //   336: aload_0
    //   337: monitorenter
    //   338: aload_3
    //   339: astore_2
    //   340: new 351	java/io/File
    //   343: dup
    //   344: aload 8
    //   346: aload 4
    //   348: invokestatic 359	com/tencent/mobileqq/utils/HexUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   351: invokespecial 369	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   354: astore 4
    //   356: aload_3
    //   357: astore_2
    //   358: aload 4
    //   360: invokevirtual 363	java/io/File:exists	()Z
    //   363: ifeq +11 -> 374
    //   366: aload_3
    //   367: astore_2
    //   368: aload 4
    //   370: invokevirtual 372	java/io/File:delete	()Z
    //   373: pop
    //   374: aload_3
    //   375: astore_2
    //   376: new 374	java/io/FileWriter
    //   379: dup
    //   380: aload 4
    //   382: invokespecial 377	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   385: astore_1
    //   386: aload_1
    //   387: aload 7
    //   389: invokevirtual 380	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   392: getstatic 111	com/tencent/biz/pubaccount/readinjoy/video/ReadInJoyWebDataManager:jdField_a_of_type_Long	J
    //   395: lstore 5
    //   397: aload 4
    //   399: invokevirtual 382	java/io/File:length	()J
    //   402: lload 5
    //   404: ladd
    //   405: putstatic 111	com/tencent/biz/pubaccount/readinjoy/video/ReadInJoyWebDataManager:jdField_a_of_type_Long	J
    //   408: aload_0
    //   409: monitorexit
    //   410: aload_1
    //   411: ifnull +130 -> 541
    //   414: aload_1
    //   415: invokevirtual 385	java/io/FileWriter:close	()V
    //   418: return
    //   419: astore_1
    //   420: aload_1
    //   421: invokevirtual 388	java/io/IOException:printStackTrace	()V
    //   424: return
    //   425: aload_1
    //   426: invokevirtual 391	java/io/File:isFile	()Z
    //   429: ifeq -149 -> 280
    //   432: aload_1
    //   433: invokevirtual 372	java/io/File:delete	()Z
    //   436: pop
    //   437: aload_1
    //   438: invokevirtual 366	java/io/File:mkdirs	()Z
    //   441: pop
    //   442: goto -162 -> 280
    //   445: aload_1
    //   446: invokevirtual 391	java/io/File:isFile	()Z
    //   449: ifeq -147 -> 302
    //   452: aload_1
    //   453: invokevirtual 372	java/io/File:delete	()Z
    //   456: pop
    //   457: aload_1
    //   458: invokevirtual 366	java/io/File:mkdirs	()Z
    //   461: pop
    //   462: goto -160 -> 302
    //   465: aload 8
    //   467: invokevirtual 391	java/io/File:isFile	()Z
    //   470: ifeq -140 -> 330
    //   473: aload 8
    //   475: invokevirtual 372	java/io/File:delete	()Z
    //   478: pop
    //   479: aload 8
    //   481: invokevirtual 366	java/io/File:mkdirs	()Z
    //   484: pop
    //   485: goto -155 -> 330
    //   488: astore_3
    //   489: aload_2
    //   490: astore_1
    //   491: aload_1
    //   492: astore_2
    //   493: aload_0
    //   494: monitorexit
    //   495: aload_1
    //   496: astore_2
    //   497: aload_3
    //   498: athrow
    //   499: astore_1
    //   500: aload_2
    //   501: ifnull +40 -> 541
    //   504: aload_2
    //   505: invokevirtual 385	java/io/FileWriter:close	()V
    //   508: return
    //   509: astore_1
    //   510: aload_1
    //   511: invokevirtual 388	java/io/IOException:printStackTrace	()V
    //   514: return
    //   515: astore_2
    //   516: aload_1
    //   517: ifnull +7 -> 524
    //   520: aload_1
    //   521: invokevirtual 385	java/io/FileWriter:close	()V
    //   524: aload_2
    //   525: athrow
    //   526: astore_1
    //   527: aload_1
    //   528: invokevirtual 388	java/io/IOException:printStackTrace	()V
    //   531: goto -7 -> 524
    //   534: astore_3
    //   535: goto -44 -> 491
    //   538: goto -349 -> 189
    //   541: return
    //   542: astore_1
    //   543: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	544	0	this	ReadInJoyWebDataManager
    //   0	544	1	paramURL	URL
    //   0	544	2	paramString1	String
    //   0	544	3	paramString2	String
    //   0	544	4	paramJSONObject	JSONObject
    //   395	8	5	l1	long
    //   36	352	7	localObject1	Object
    //   32	448	8	localObject2	Object
    //   6	245	9	localQQAppInterface	QQAppInterface
    //   22	142	10	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   414	418	419	java/io/IOException
    //   340	356	488	finally
    //   358	366	488	finally
    //   368	374	488	finally
    //   376	386	488	finally
    //   493	495	488	finally
    //   336	338	499	java/io/IOException
    //   497	499	499	java/io/IOException
    //   504	508	509	java/io/IOException
    //   336	338	515	finally
    //   497	499	515	finally
    //   520	524	526	java/io/IOException
    //   386	410	534	finally
    //   0	8	542	org/json/JSONException
    //   14	34	542	org/json/JSONException
    //   38	68	542	org/json/JSONException
    //   68	105	542	org/json/JSONException
    //   106	187	542	org/json/JSONException
    //   191	198	542	org/json/JSONException
    //   202	280	542	org/json/JSONException
    //   280	302	542	org/json/JSONException
    //   302	330	542	org/json/JSONException
    //   414	418	542	org/json/JSONException
    //   420	424	542	org/json/JSONException
    //   425	442	542	org/json/JSONException
    //   445	462	542	org/json/JSONException
    //   465	485	542	org/json/JSONException
    //   504	508	542	org/json/JSONException
    //   510	514	542	org/json/JSONException
    //   520	524	542	org/json/JSONException
    //   524	526	542	org/json/JSONException
    //   527	531	542	org/json/JSONException
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    do
    {
      return false;
      if ((ReadInJoyBaseAdapter.c(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo != null))
      {
        switch ((int)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_b_of_type_JavaLangLong.longValue())
        {
        case 11: 
        default: 
          return false;
        }
        return true;
      }
    } while ((!ReadInJoyBaseAdapter.a(paramArticleInfo)) && (!ReadInJoyBaseAdapter.e(paramArticleInfo)));
    return true;
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    if (paramString2 == null) {}
    while ((!paramString2.equals(paramString1)) && ((paramString1.indexOf(".") <= 0) || (!paramString2.endsWith("." + paramString1)))) {
      return false;
    }
    return true;
  }
  
  private String b(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes("UTF-8"));
      paramString = HexUtil.a(localMessageDigest.digest());
      localMessageDigest.reset();
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      return "wronghash";
    }
    catch (NoSuchAlgorithmException paramString)
    {
      label33:
      break label33;
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (jdField_b_of_type_JavaLangString.equals(paramString1)))
    {
      paramString1 = b(paramString2);
      if (!paramString1.equals(this.n))
      {
        this.n = paramString1;
        this.o = paramString2;
      }
    }
  }
  
  private void b(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject)
  {
    try
    {
      ThreadManager.post(new mdi(this, new URL(paramString1), paramString2, paramString3, paramJSONObject), 5, null, false);
      return;
    }
    catch (MalformedURLException paramString1) {}
  }
  
  public static boolean b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
    if (localQQAppInterface == null) {
      return false;
    }
    if (localQQAppInterface.getApp() == null) {
      return false;
    }
    return (AppNetConnInfo.isWifiConn()) || ((AppNetConnInfo.isMobileConn()) && (AppNetConnInfo.getMobileInfo() == 3));
  }
  
  private static long c()
  {
    Object localObject = new File(PublicAccountJavascriptInterface.jdField_a_of_type_JavaLangString);
    if (!((File)localObject).exists()) {
      return 0L;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    long l1 = 0L;
    while (!localArrayList.isEmpty())
    {
      localObject = (File)localArrayList.remove(0);
      if (((File)localObject).isFile())
      {
        l1 = ((File)localObject).length() + l1;
      }
      else
      {
        localObject = ((File)localObject).listFiles();
        if (localObject != null)
        {
          int i2 = localObject.length;
          int i1 = 0;
          while (i1 < i2)
          {
            localArrayList.add(localObject[i1]);
            i1 += 1;
          }
        }
      }
    }
    return l1;
  }
  
  private String e()
  {
    Object localObject = (QQAppInterface)ReadInJoyUtils.a();
    if (localObject == null) {
      return "";
    }
    TicketManager localTicketManager = (TicketManager)((QQAppInterface)localObject).getManager(2);
    if (localTicketManager == null) {
      return "";
    }
    localObject = localTicketManager.getSkey(((QQAppInterface)localObject).getCurrentAccountUin());
    long l1 = 5381L;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return "";
    }
    int i1 = 0;
    while (i1 < ((String)localObject).length())
    {
      l1 += (l1 << 5 & 0x7FFFFFFF) + ((String)localObject).charAt(i1);
      i1 += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.w("ReadInJoyWebDataManager", 2, "getCSRFToken " + (l1 & 0x7FFFFFFF));
    }
    return String.valueOf(l1 & 0x7FFFFFFF);
  }
  
  public String a()
  {
    return this.k;
  }
  
  public String a(long paramLong)
  {
    if (this.jdField_b_of_type_Long == paramLong) {
      return this.m;
    }
    return "";
  }
  
  public void a(int paramInt)
  {
    if (!a(d)) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("callid", "0");
      localJSONObject.put("host", "kandian.qq.com");
      localJSONObject.put("path", "kandian_topic");
      localJSONObject.put("key", "kandian_topic_data_key_" + Integer.toString(paramInt));
      a("get", "https://kandian.qq.com/qz_kandian_up_video/kandian_up_video/GetSocicalTopic?pageCookies=&reqCount=20&sortType=2&isreport=0&topicid=" + Integer.toString(paramInt), localJSONObject, d);
      return;
    }
    catch (Exception localException) {}
  }
  
  /* Error */
  public void a(ArticleInfo paramArticleInfo, boolean paramBoolean, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_1
    //   4: istore 5
    //   6: aload_1
    //   7: ifnull +10 -> 17
    //   10: aload_1
    //   11: invokestatic 542	com/tencent/biz/pubaccount/readinjoy/video/ReadInJoyWebDataManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)Z
    //   14: ifne +10 -> 24
    //   17: aload_0
    //   18: ldc 95
    //   20: putfield 101	com/tencent/biz/pubaccount/readinjoy/video/ReadInJoyWebDataManager:m	Ljava/lang/String;
    //   23: return
    //   24: new 184	org/json/JSONObject
    //   27: dup
    //   28: invokespecial 185	org/json/JSONObject:<init>	()V
    //   31: astore 8
    //   33: aload_1
    //   34: getfield 545	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFeedType	I
    //   37: istore 4
    //   39: aload_1
    //   40: invokestatic 396	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter:c	(Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)Z
    //   43: invokestatic 550	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   46: astore 9
    //   48: aload_1
    //   49: invokestatic 419	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)Z
    //   52: ifne +1519 -> 1571
    //   55: aload_1
    //   56: invokestatic 421	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter:e	(Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)Z
    //   59: ifeq +815 -> 874
    //   62: goto +1509 -> 1571
    //   65: iload 7
    //   67: invokestatic 550	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   70: astore 10
    //   72: aload 10
    //   74: invokevirtual 553	java/lang/Boolean:booleanValue	()Z
    //   77: ifne +17 -> 94
    //   80: aload 9
    //   82: invokevirtual 553	java/lang/Boolean:booleanValue	()Z
    //   85: ifne +9 -> 94
    //   88: aload_0
    //   89: ldc 95
    //   91: putfield 101	com/tencent/biz/pubaccount/readinjoy/video/ReadInJoyWebDataManager:m	Ljava/lang/String;
    //   94: aload_3
    //   95: invokestatic 559	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   98: ldc_w 561
    //   101: invokevirtual 564	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   104: astore_3
    //   105: aload_3
    //   106: invokestatic 304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   109: istore 7
    //   111: iload 7
    //   113: ifne +52 -> 165
    //   116: new 122	java/lang/String
    //   119: dup
    //   120: aload_3
    //   121: iconst_0
    //   122: invokestatic 570	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   125: invokespecial 572	java/lang/String:<init>	([B)V
    //   128: astore_3
    //   129: aload_3
    //   130: invokestatic 304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   133: ifne +32 -> 165
    //   136: aload 8
    //   138: ldc_w 574
    //   141: new 29	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   148: ldc_w 576
    //   151: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_3
    //   155: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   164: pop
    //   165: iload_2
    //   166: ifeq +714 -> 880
    //   169: aload_1
    //   170: getfield 402	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   173: ifnull +707 -> 880
    //   176: aload_1
    //   177: getfield 402	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   180: getfield 407	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo;
    //   183: ifnull +697 -> 880
    //   186: aload 8
    //   188: ldc_w 578
    //   191: aload_1
    //   192: getfield 402	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   195: getfield 407	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo;
    //   198: getfield 580	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   201: invokestatic 583	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   204: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   207: pop
    //   208: aload 8
    //   210: ldc_w 585
    //   213: aload_1
    //   214: getfield 402	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   217: getfield 407	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo;
    //   220: getfield 412	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo:jdField_b_of_type_JavaLangLong	Ljava/lang/Long;
    //   223: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   226: pop
    //   227: aload 8
    //   229: ldc_w 587
    //   232: aload_1
    //   233: getfield 590	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSubscribeID	Ljava/lang/String;
    //   236: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   239: pop
    //   240: aload 8
    //   242: ldc_w 592
    //   245: aload_1
    //   246: getfield 595	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSubscribeName	Ljava/lang/String;
    //   249: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   252: pop
    //   253: aload 8
    //   255: ldc_w 597
    //   258: aload_1
    //   259: getfield 590	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSubscribeID	Ljava/lang/String;
    //   262: invokestatic 304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   265: invokevirtual 600	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   268: pop
    //   269: aload 8
    //   271: ldc_w 602
    //   274: ldc 95
    //   276: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   279: pop
    //   280: aload 8
    //   282: ldc_w 604
    //   285: aload_1
    //   286: getfield 607	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mArticleID	J
    //   289: invokevirtual 198	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   292: pop
    //   293: aload 8
    //   295: ldc_w 609
    //   298: aload_1
    //   299: getfield 612	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mArticleContentUrl	Ljava/lang/String;
    //   302: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   305: pop
    //   306: aload 8
    //   308: ldc_w 614
    //   311: aload_1
    //   312: getfield 617	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSummary	Ljava/lang/String;
    //   315: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   318: pop
    //   319: aload 8
    //   321: ldc_w 619
    //   324: aload_1
    //   325: getfield 622	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mTitle	Ljava/lang/String;
    //   328: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   331: pop
    //   332: aload 8
    //   334: ldc_w 624
    //   337: aload_1
    //   338: getfield 627	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mTime	J
    //   341: invokestatic 631	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyTimeUtils:b	(J)Ljava/lang/String;
    //   344: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   347: pop
    //   348: aload_1
    //   349: getfield 635	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSinglePicture	Ljava/net/URL;
    //   352: ifnull +558 -> 910
    //   355: aload_1
    //   356: getfield 635	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSinglePicture	Ljava/net/URL;
    //   359: invokevirtual 638	java/net/URL:getFile	()Ljava/lang/String;
    //   362: astore_3
    //   363: aload 8
    //   365: ldc_w 640
    //   368: aload_3
    //   369: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   372: pop
    //   373: aload_1
    //   374: getfield 644	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mShowBigPicture	Z
    //   377: ifeq +1200 -> 1577
    //   380: iconst_2
    //   381: istore 4
    //   383: aload 8
    //   385: ldc_w 646
    //   388: iload 4
    //   390: invokevirtual 649	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   393: pop
    //   394: aload_1
    //   395: ifnull +59 -> 454
    //   398: aload_1
    //   399: invokestatic 652	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyUtils:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   402: ifeq +52 -> 454
    //   405: aload 8
    //   407: ldc_w 654
    //   410: iconst_1
    //   411: invokevirtual 649	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   414: pop
    //   415: aload_1
    //   416: getfield 657	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mVideoCoverUrl	Ljava/net/URL;
    //   419: ifnull +19 -> 438
    //   422: aload 8
    //   424: ldc_w 640
    //   427: aload_1
    //   428: getfield 657	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mVideoCoverUrl	Ljava/net/URL;
    //   431: invokevirtual 658	java/net/URL:toString	()Ljava/lang/String;
    //   434: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   437: pop
    //   438: aload 8
    //   440: ldc_w 660
    //   443: aload_1
    //   444: getfield 663	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mVideoDuration	I
    //   447: invokestatic 667	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/UtilsForComponent:a	(I)Ljava/lang/String;
    //   450: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   453: pop
    //   454: iload_2
    //   455: ifne +625 -> 1080
    //   458: aload 9
    //   460: invokevirtual 553	java/lang/Boolean:booleanValue	()Z
    //   463: ifeq +617 -> 1080
    //   466: aload_1
    //   467: getfield 402	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   470: ifnull +610 -> 1080
    //   473: aload_1
    //   474: getfield 402	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   477: getfield 670	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$FeedsInfoUser;
    //   480: ifnull +43 -> 523
    //   483: aload 10
    //   485: invokevirtual 553	java/lang/Boolean:booleanValue	()Z
    //   488: ifeq +430 -> 918
    //   491: iload 6
    //   493: istore 4
    //   495: aload_1
    //   496: getfield 402	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   499: getfield 670	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$FeedsInfoUser;
    //   502: getfield 673	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$FeedsInfoUser:jdField_a_of_type_Int	I
    //   505: iconst_1
    //   506: if_icmpne +6 -> 512
    //   509: iconst_1
    //   510: istore 4
    //   512: aload 8
    //   514: ldc_w 602
    //   517: iload 4
    //   519: invokevirtual 649	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   522: pop
    //   523: aload 9
    //   525: invokevirtual 553	java/lang/Boolean:booleanValue	()Z
    //   528: ifeq +552 -> 1080
    //   531: aload_1
    //   532: getfield 402	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   535: getfield 407	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo;
    //   538: ifnull +542 -> 1080
    //   541: aload 8
    //   543: ldc_w 675
    //   546: aload_1
    //   547: getfield 402	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   550: getfield 407	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo;
    //   553: getfield 580	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   556: invokestatic 583	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   559: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   562: pop
    //   563: aload 8
    //   565: ldc_w 677
    //   568: aload_1
    //   569: getfield 402	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   572: getfield 407	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo;
    //   575: getfield 412	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo:jdField_b_of_type_JavaLangLong	Ljava/lang/Long;
    //   578: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   581: pop
    //   582: new 176	org/json/JSONArray
    //   585: dup
    //   586: invokespecial 177	org/json/JSONArray:<init>	()V
    //   589: astore_3
    //   590: aload_1
    //   591: getfield 402	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   594: getfield 407	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo;
    //   597: getfield 678	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   600: invokeinterface 166 1 0
    //   605: astore 9
    //   607: aload 9
    //   609: invokeinterface 182 1 0
    //   614: ifeq +456 -> 1070
    //   617: aload 9
    //   619: invokeinterface 204 1 0
    //   624: checkcast 680	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo
    //   627: astore 10
    //   629: new 184	org/json/JSONObject
    //   632: dup
    //   633: invokespecial 185	org/json/JSONObject:<init>	()V
    //   636: astore 11
    //   638: aload 11
    //   640: ldc_w 682
    //   643: aload 10
    //   645: getfield 683	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_JavaLangLong	Ljava/lang/Long;
    //   648: invokestatic 583	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   651: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   654: pop
    //   655: aload 11
    //   657: ldc_w 685
    //   660: aload 10
    //   662: getfield 686	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_Int	I
    //   665: invokevirtual 649	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   668: pop
    //   669: aload 11
    //   671: ldc_w 688
    //   674: new 122	java/lang/String
    //   677: dup
    //   678: aload 10
    //   680: getfield 689	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   683: invokevirtual 417	java/lang/Long:longValue	()J
    //   686: invokestatic 691	java/lang/Long:toString	(J)Ljava/lang/String;
    //   689: invokevirtual 693	java/lang/String:getBytes	()[B
    //   692: iconst_0
    //   693: invokestatic 697	com/tencent/mobileqq/utils/Base64Util:encode	([BI)[B
    //   696: invokespecial 572	java/lang/String:<init>	([B)V
    //   699: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   702: pop
    //   703: aload 11
    //   705: ldc_w 699
    //   708: ldc 95
    //   710: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   713: pop
    //   714: aload 11
    //   716: ldc_w 701
    //   719: ldc 95
    //   721: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   724: pop
    //   725: invokestatic 234	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyUtils:a	()Lmqq/app/AppRuntime;
    //   728: checkcast 248	com/tencent/mobileqq/app/QQAppInterface
    //   731: ifnull +48 -> 779
    //   734: invokestatic 234	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyUtils:a	()Lmqq/app/AppRuntime;
    //   737: checkcast 248	com/tencent/mobileqq/app/QQAppInterface
    //   740: aload 10
    //   742: getfield 689	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   745: invokevirtual 417	java/lang/Long:longValue	()J
    //   748: invokestatic 691	java/lang/Long:toString	(J)Ljava/lang/String;
    //   751: iconst_1
    //   752: invokestatic 706	com/tencent/mobileqq/utils/ContactUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Z)Ljava/lang/String;
    //   755: astore 12
    //   757: aload 11
    //   759: ldc_w 699
    //   762: aload 12
    //   764: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   767: pop
    //   768: aload 11
    //   770: ldc_w 701
    //   773: aload 12
    //   775: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   778: pop
    //   779: aload 11
    //   781: ldc_w 708
    //   784: aload 10
    //   786: getfield 709	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   789: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   792: pop
    //   793: aload 11
    //   795: ldc_w 711
    //   798: aload 10
    //   800: getfield 712	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_Int	I
    //   803: invokevirtual 649	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   806: pop
    //   807: aload 11
    //   809: ldc_w 714
    //   812: aload 10
    //   814: getfield 716	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:c	I
    //   817: invokevirtual 649	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   820: pop
    //   821: aload_3
    //   822: aload 11
    //   824: invokevirtual 210	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   827: pop
    //   828: goto -221 -> 607
    //   831: astore_1
    //   832: aload_0
    //   833: ldc 95
    //   835: putfield 101	com/tencent/biz/pubaccount/readinjoy/video/ReadInJoyWebDataManager:m	Ljava/lang/String;
    //   838: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   841: ifeq -818 -> 23
    //   844: ldc 140
    //   846: iconst_2
    //   847: new 29	java/lang/StringBuilder
    //   850: dup
    //   851: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   854: ldc_w 718
    //   857: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: aload_1
    //   861: invokevirtual 719	org/json/JSONException:toString	()Ljava/lang/String;
    //   864: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   870: invokestatic 721	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   873: return
    //   874: iconst_0
    //   875: istore 7
    //   877: goto -812 -> 65
    //   880: aload 8
    //   882: ldc_w 578
    //   885: aload_1
    //   886: getfield 724	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFeedId	J
    //   889: invokestatic 153	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   892: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   895: pop
    //   896: aload 8
    //   898: ldc_w 585
    //   901: iload 4
    //   903: invokevirtual 649	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   906: pop
    //   907: goto -680 -> 227
    //   910: aload_1
    //   911: getfield 727	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFirstPagePicUrl	Ljava/lang/String;
    //   914: astore_3
    //   915: goto -552 -> 363
    //   918: aload 9
    //   920: invokevirtual 553	java/lang/Boolean:booleanValue	()Z
    //   923: ifeq -400 -> 523
    //   926: aload_1
    //   927: getfield 402	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   930: getfield 670	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$FeedsInfoUser;
    //   933: getfield 728	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$FeedsInfoUser:jdField_a_of_type_Long	J
    //   936: invokestatic 731	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   939: astore_3
    //   940: aload 8
    //   942: ldc_w 561
    //   945: new 122	java/lang/String
    //   948: dup
    //   949: aload_3
    //   950: invokevirtual 417	java/lang/Long:longValue	()J
    //   953: invokestatic 691	java/lang/Long:toString	(J)Ljava/lang/String;
    //   956: invokevirtual 693	java/lang/String:getBytes	()[B
    //   959: iconst_0
    //   960: invokestatic 697	com/tencent/mobileqq/utils/Base64Util:encode	([BI)[B
    //   963: invokespecial 572	java/lang/String:<init>	([B)V
    //   966: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   969: pop
    //   970: aload 8
    //   972: ldc_w 733
    //   975: ldc 95
    //   977: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   980: pop
    //   981: aload 8
    //   983: ldc_w 735
    //   986: ldc 95
    //   988: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   991: pop
    //   992: invokestatic 234	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyUtils:a	()Lmqq/app/AppRuntime;
    //   995: checkcast 248	com/tencent/mobileqq/app/QQAppInterface
    //   998: ifnull +41 -> 1039
    //   1001: invokestatic 234	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyUtils:a	()Lmqq/app/AppRuntime;
    //   1004: checkcast 248	com/tencent/mobileqq/app/QQAppInterface
    //   1007: aload_3
    //   1008: invokevirtual 417	java/lang/Long:longValue	()J
    //   1011: invokestatic 691	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1014: iconst_1
    //   1015: invokestatic 706	com/tencent/mobileqq/utils/ContactUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Z)Ljava/lang/String;
    //   1018: astore_3
    //   1019: aload 8
    //   1021: ldc_w 733
    //   1024: aload_3
    //   1025: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1028: pop
    //   1029: aload 8
    //   1031: ldc_w 735
    //   1034: aload_3
    //   1035: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1038: pop
    //   1039: aload_1
    //   1040: getfield 402	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   1043: getfield 670	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$FeedsInfoUser;
    //   1046: getfield 673	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$FeedsInfoUser:jdField_a_of_type_Int	I
    //   1049: iconst_1
    //   1050: if_icmpne +533 -> 1583
    //   1053: iconst_1
    //   1054: istore 4
    //   1056: aload 8
    //   1058: ldc_w 737
    //   1061: iload 4
    //   1063: invokevirtual 649	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1066: pop
    //   1067: goto -544 -> 523
    //   1070: aload 8
    //   1072: ldc_w 739
    //   1075: aload_3
    //   1076: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1079: pop
    //   1080: aload_1
    //   1081: getfield 402	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   1084: ifnull +94 -> 1178
    //   1087: aload 8
    //   1089: ldc_w 624
    //   1092: aload_1
    //   1093: getfield 402	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   1096: getfield 741	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:e	I
    //   1099: i2l
    //   1100: iconst_1
    //   1101: invokestatic 744	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyTimeUtils:a	(JZ)Ljava/lang/String;
    //   1104: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1107: pop
    //   1108: aload_1
    //   1109: getfield 402	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   1112: getfield 745	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Int	I
    //   1115: istore 6
    //   1117: iload 6
    //   1119: tableswitch	default:+470 -> 1589, 1:+490->1609, 2:+490->1609, 3:+49->1168, 4:+49->1168, 5:+473->1592, 6:+473->1592, 7:+49->1168, 8:+49->1168, 9:+208->1327
    //   1169: iconst_5
    //   1170: ldc_w 646
    //   1173: iconst_1
    //   1174: invokevirtual 649	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1177: pop
    //   1178: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1181: ifeq +33 -> 1214
    //   1184: ldc 140
    //   1186: iconst_2
    //   1187: new 29	java/lang/StringBuilder
    //   1190: dup
    //   1191: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   1194: ldc_w 747
    //   1197: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1200: aload 8
    //   1202: invokevirtual 748	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1205: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1208: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1211: invokestatic 721	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1214: aload_0
    //   1215: aload 8
    //   1217: invokevirtual 748	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1220: putfield 101	com/tencent/biz/pubaccount/readinjoy/video/ReadInJoyWebDataManager:m	Ljava/lang/String;
    //   1223: aload_0
    //   1224: aload 8
    //   1226: ldc_w 578
    //   1229: invokevirtual 751	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1232: invokestatic 754	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   1235: invokevirtual 417	java/lang/Long:longValue	()J
    //   1238: putfield 517	com/tencent/biz/pubaccount/readinjoy/video/ReadInJoyWebDataManager:jdField_b_of_type_Long	J
    //   1241: return
    //   1242: aload 8
    //   1244: ldc_w 646
    //   1247: iload 4
    //   1249: invokevirtual 649	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1252: pop
    //   1253: aload 8
    //   1255: ldc_w 654
    //   1258: iconst_1
    //   1259: invokevirtual 649	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1262: pop
    //   1263: aload_1
    //   1264: getfield 657	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mVideoCoverUrl	Ljava/net/URL;
    //   1267: ifnull +27 -> 1294
    //   1270: aload 8
    //   1272: ldc_w 640
    //   1275: aload_1
    //   1276: getfield 657	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mVideoCoverUrl	Ljava/net/URL;
    //   1279: invokevirtual 658	java/net/URL:toString	()Ljava/lang/String;
    //   1282: ldc_w 756
    //   1285: ldc 95
    //   1287: invokevirtual 312	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1290: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1293: pop
    //   1294: aload 8
    //   1296: ldc_w 660
    //   1299: aload_1
    //   1300: getfield 663	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mVideoDuration	I
    //   1303: invokestatic 667	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/UtilsForComponent:a	(I)Ljava/lang/String;
    //   1306: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1309: pop
    //   1310: goto -132 -> 1178
    //   1313: aload 8
    //   1315: ldc_w 646
    //   1318: iload 4
    //   1320: invokevirtual 649	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1323: pop
    //   1324: goto -146 -> 1178
    //   1327: aload 8
    //   1329: ldc_w 758
    //   1332: iconst_1
    //   1333: invokevirtual 649	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1336: pop
    //   1337: aload_1
    //   1338: getfield 402	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   1341: getfield 761	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$PGCFeedsInfo;
    //   1344: ifnull -166 -> 1178
    //   1347: aload_1
    //   1348: getfield 402	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   1351: getfield 761	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$PGCFeedsInfo;
    //   1354: getfield 766	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$PGCFeedsInfo:a	Ljava/util/ArrayList;
    //   1357: ifnull -179 -> 1178
    //   1360: aload_1
    //   1361: getfield 402	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   1364: getfield 761	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$PGCFeedsInfo;
    //   1367: getfield 766	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$PGCFeedsInfo:a	Ljava/util/ArrayList;
    //   1370: invokevirtual 767	java/util/ArrayList:size	()I
    //   1373: ifle -195 -> 1178
    //   1376: aload_1
    //   1377: getfield 402	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   1380: getfield 761	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$PGCFeedsInfo;
    //   1383: getfield 766	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$PGCFeedsInfo:a	Ljava/util/ArrayList;
    //   1386: astore_1
    //   1387: new 176	org/json/JSONArray
    //   1390: dup
    //   1391: invokespecial 177	org/json/JSONArray:<init>	()V
    //   1394: astore_3
    //   1395: aload_1
    //   1396: invokeinterface 166 1 0
    //   1401: astore 9
    //   1403: aload 9
    //   1405: invokeinterface 182 1 0
    //   1410: ifeq +144 -> 1554
    //   1413: aload 9
    //   1415: invokeinterface 204 1 0
    //   1420: checkcast 769	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$PGCPicInfo
    //   1423: astore 10
    //   1425: aload 10
    //   1427: getfield 770	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$PGCPicInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1430: ifnonnull +11 -> 1441
    //   1433: aload 10
    //   1435: getfield 771	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$PGCPicInfo:c	Ljava/lang/String;
    //   1438: ifnull -35 -> 1403
    //   1441: new 184	org/json/JSONObject
    //   1444: dup
    //   1445: invokespecial 185	org/json/JSONObject:<init>	()V
    //   1448: astore 11
    //   1450: aload 10
    //   1452: getfield 770	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$PGCPicInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1455: ifnull +81 -> 1536
    //   1458: aload 10
    //   1460: getfield 770	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$PGCPicInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1463: astore_1
    //   1464: aload 11
    //   1466: ldc_w 773
    //   1469: aload_1
    //   1470: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1473: pop
    //   1474: aload 10
    //   1476: getfield 771	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$PGCPicInfo:c	Ljava/lang/String;
    //   1479: ifnull +66 -> 1545
    //   1482: aload 10
    //   1484: getfield 771	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$PGCPicInfo:c	Ljava/lang/String;
    //   1487: astore_1
    //   1488: aload 11
    //   1490: ldc_w 775
    //   1493: aload_1
    //   1494: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1497: pop
    //   1498: aload 11
    //   1500: ldc_w 777
    //   1503: aload 10
    //   1505: getfield 778	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$PGCPicInfo:jdField_a_of_type_Int	I
    //   1508: invokevirtual 649	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1511: pop
    //   1512: aload 11
    //   1514: ldc_w 777
    //   1517: aload 10
    //   1519: getfield 778	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$PGCPicInfo:jdField_a_of_type_Int	I
    //   1522: invokevirtual 649	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1525: pop
    //   1526: aload_3
    //   1527: aload 11
    //   1529: invokevirtual 210	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   1532: pop
    //   1533: goto -130 -> 1403
    //   1536: aload 10
    //   1538: getfield 771	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$PGCPicInfo:c	Ljava/lang/String;
    //   1541: astore_1
    //   1542: goto -78 -> 1464
    //   1545: aload 10
    //   1547: getfield 770	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$PGCPicInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1550: astore_1
    //   1551: goto -63 -> 1488
    //   1554: aload 8
    //   1556: ldc_w 780
    //   1559: aload_3
    //   1560: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1563: pop
    //   1564: goto -386 -> 1178
    //   1567: astore_3
    //   1568: goto -1403 -> 165
    //   1571: iconst_1
    //   1572: istore 7
    //   1574: goto -1509 -> 65
    //   1577: iconst_1
    //   1578: istore 4
    //   1580: goto -1197 -> 383
    //   1583: iconst_0
    //   1584: istore 4
    //   1586: goto -530 -> 1056
    //   1589: goto -421 -> 1168
    //   1592: iload 5
    //   1594: istore 4
    //   1596: iload 6
    //   1598: bipush 6
    //   1600: if_icmpne -358 -> 1242
    //   1603: iconst_2
    //   1604: istore 4
    //   1606: goto -364 -> 1242
    //   1609: iload 6
    //   1611: iconst_2
    //   1612: if_icmpne +9 -> 1621
    //   1615: iconst_2
    //   1616: istore 4
    //   1618: goto -305 -> 1313
    //   1621: iconst_1
    //   1622: istore 4
    //   1624: goto -311 -> 1313
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1627	0	this	ReadInJoyWebDataManager
    //   0	1627	1	paramArticleInfo	ArticleInfo
    //   0	1627	2	paramBoolean	boolean
    //   0	1627	3	paramString	String
    //   37	1586	4	i1	int
    //   4	1589	5	i2	int
    //   1	1612	6	i3	int
    //   65	1508	7	bool	boolean
    //   31	1524	8	localJSONObject1	JSONObject
    //   46	1368	9	localObject1	Object
    //   70	1476	10	localObject2	Object
    //   636	892	11	localJSONObject2	JSONObject
    //   755	19	12	str	String
    // Exception table:
    //   from	to	target	type
    //   24	62	831	org/json/JSONException
    //   65	94	831	org/json/JSONException
    //   94	111	831	org/json/JSONException
    //   116	165	831	org/json/JSONException
    //   169	227	831	org/json/JSONException
    //   227	363	831	org/json/JSONException
    //   363	380	831	org/json/JSONException
    //   383	394	831	org/json/JSONException
    //   398	438	831	org/json/JSONException
    //   438	454	831	org/json/JSONException
    //   458	491	831	org/json/JSONException
    //   495	509	831	org/json/JSONException
    //   512	523	831	org/json/JSONException
    //   523	607	831	org/json/JSONException
    //   607	779	831	org/json/JSONException
    //   779	828	831	org/json/JSONException
    //   880	907	831	org/json/JSONException
    //   910	915	831	org/json/JSONException
    //   918	1039	831	org/json/JSONException
    //   1039	1053	831	org/json/JSONException
    //   1056	1067	831	org/json/JSONException
    //   1070	1080	831	org/json/JSONException
    //   1080	1117	831	org/json/JSONException
    //   1168	1178	831	org/json/JSONException
    //   1178	1214	831	org/json/JSONException
    //   1214	1241	831	org/json/JSONException
    //   1242	1294	831	org/json/JSONException
    //   1294	1310	831	org/json/JSONException
    //   1313	1324	831	org/json/JSONException
    //   1327	1403	831	org/json/JSONException
    //   1403	1441	831	org/json/JSONException
    //   1441	1464	831	org/json/JSONException
    //   1464	1488	831	org/json/JSONException
    //   1488	1533	831	org/json/JSONException
    //   1536	1542	831	org/json/JSONException
    //   1545	1551	831	org/json/JSONException
    //   1554	1564	831	org/json/JSONException
    //   116	165	1567	java/lang/Exception
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, long paramLong1, long paramLong2, long paramLong3)
  {
    paramLong1 = paramBaseArticleInfo.mFeedType;
    if (QLog.isColorLevel()) {
      QLog.w("ReadInJoyWebDataManager", 2, "preLoadSocailCgi uin=" + Long.toString(paramLong2) + "&feeds_id=" + Long.toString(paramLong3) + "&feedsType=" + Long.toString(paramLong1));
    }
    if ((paramLong1 == 1L) || (paramLong1 == 4L) || (paramLong1 == 5L) || (paramLong1 == 11L) || (paramLong1 == 12L)) {}
    try
    {
      b(Long.toString(paramLong2));
      if (!a(c)) {
        return;
      }
      paramBaseArticleInfo = new JSONObject();
      paramBaseArticleInfo.put("callid", "0");
      paramBaseArticleInfo.put("host", "kandian.qq.com");
      paramBaseArticleInfo.put("path", "kandian_comment");
      paramBaseArticleInfo.put("key", "kandian_comment_GetSubDetailPage_key_" + Long.toString(paramLong2) + "_" + Long.toString(paramLong3));
      a("get", "https://kandian.qq.com/qz_kandian_social/kandian_ext/GetSubDetailPage?uin=" + Long.toString(paramLong2) + "&feeds_id=" + Long.toString(paramLong3) + "&feedsType=" + Long.toString(paramLong1), paramBaseArticleInfo, c);
      return;
    }
    catch (Exception paramBaseArticleInfo) {}
  }
  
  public void a(String paramString, int paramInt)
  {
    boolean bool = true;
    if (!a(jdField_b_of_type_JavaLangString)) {
      return;
    }
    mdo localmdo = null;
    for (;;)
    {
      try
      {
        String str = Integer.toString(paramInt);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("callid", "0");
        localJSONObject.put("host", "kandian.qq.com");
        localJSONObject.put("path", "kandian_messagebox");
        localJSONObject.put("key", "kandian_messagebox_data_key2_isNew_" + str + "_" + paramString);
        str = "https://kandian.qq.com/qz_kandian_social/kandian_ext/getMessageBox?readTimestamp=0&pageNo=1&pageSize=20&isBiuLevel=1&isNew=" + str;
        paramString = str;
        if (paramInt == 1)
        {
          localmdo = new mdo(this);
          paramString = str + "&ispreload=1";
        }
        str = jdField_b_of_type_JavaLangString;
        if (paramInt == 1)
        {
          a("get", paramString, localJSONObject, str, localmdo, Boolean.valueOf(bool));
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.w("ReadInJoyWebDataManager", 2, "preloadWebDataMessageBox:isNew " + paramInt);
          return;
        }
      }
      catch (Exception paramString)
      {
        return;
      }
      bool = false;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    PublicAccountReportUtils.a(null, "", "0X8008221", "0X8008221", 0, 0, paramString1, paramString2, "", "", false);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    PublicAccountReportUtils.a(null, "", "0X8008220", "0X8008220", 0, 0, paramString1, paramString2, paramString3, "", false);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new mdh(this, paramString1, paramString2, paramString3, paramJSONObject));
      return;
    }
    b(paramString1, paramString2, paramString3, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, JSONObject paramJSONObject, String paramString3)
  {
    a(paramString1, paramString2, paramJSONObject, paramString3, null, Boolean.valueOf(false));
  }
  
  public void a(String paramString1, String paramString2, JSONObject paramJSONObject, String paramString3, mdp parammdp, Boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString2)) && (System.currentTimeMillis() - ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString2)).longValue() < 1800000L)) {
        a(paramString3, f, i);
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        a(paramString3, e, "");
        if (!paramBoolean.booleanValue()) {
          this.jdField_a_of_type_JavaUtilHashMap.put(paramString2, Long.valueOf(System.currentTimeMillis()));
        }
        if (paramString2.indexOf("?") != -1) {}
        for (paramString2 = paramString2 + "&g_tk=" + e(); "get".equals(paramString1); paramString2 = paramString2 + "?g_tk=" + e())
        {
          a(paramString2, paramJSONObject, paramString3, parammdp);
          return;
        }
      }
    }
    QLog.w("ReadInJoyWebDataManager", 2, "httpFetchAsync mCgiLoadedMap cause mCgiLoadedMap is null ");
  }
  
  public boolean a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
    if (localQQAppInterface == null) {
      return false;
    }
    if ((b()) && (ReadInJoyHelper.q(localQQAppInterface))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean a(String paramString)
  {
    if (!a())
    {
      if (!b()) {
        a(paramString, f, g);
      }
      for (;;)
      {
        return false;
        a(paramString, f, h);
      }
    }
    return true;
  }
  
  public String b()
  {
    return this.m;
  }
  
  public void b()
  {
    this.m = "";
    this.k = "";
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public void b(String paramString)
  {
    if (!a(jdField_a_of_type_JavaLangString)) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("callid", "0");
      localJSONObject.put("host", "kandian.qq.com");
      localJSONObject.put("path", "kandian_homepage");
      localJSONObject.put("key", "kandian_homepage2_data_key_" + paramString);
      a("get", "https://kandian.qq.com/qz_kandian_social/kandian_ext/getPersonPage?pageNo=1&pageSize=20&is715=1&uin=" + paramString, localJSONObject, jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception paramString) {}
  }
  
  public String c()
  {
    return this.o;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager
 * JD-Core Version:    0.7.0.1
 */