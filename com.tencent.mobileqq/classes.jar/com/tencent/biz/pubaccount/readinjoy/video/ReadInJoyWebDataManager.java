package com.tencent.biz.pubaccount.readinjoy.video;

import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyTimeUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.ViolaPicSerPreloadHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.UtilsForComponent;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCPicInfo;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.ViolaCreactPageObject;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CouponH5Data;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.BaseApplication;
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
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyWebDataManager
{
  public static int a;
  private static long jdField_a_of_type_Long = 0L;
  private static ReadInJoyWebDataManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoReadInJoyWebDataManager;
  public static String a;
  public static List<String> a;
  public static int b;
  public static String b;
  public static String c = "2";
  public static String d = "3";
  public static String e = "4";
  public static String f = "1";
  public static String g = "0";
  public static String h = "1";
  public static String i = "2";
  public static String j = "3";
  private static final String k = "QQ/8.5.5 Android/0.17 Android/" + Build.VERSION.RELEASE;
  private ViolaBaseView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView;
  private volatile HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private long b;
  private String l = "";
  private String m = "";
  private String n = "";
  private String o = "";
  private String p = "";
  
  static
  {
    jdField_a_of_type_Int = 404;
    jdField_b_of_type_Int = 200;
    jdField_a_of_type_JavaLangString = "https://sqimg.qq.com/qq_product_operations/kan/viola_biz/viola_service/viola_service.js?v_bid=3685&_rij_violaUrl=1";
    jdField_a_of_type_JavaUtilList = new ArrayList();
    jdField_b_of_type_JavaLangString = "1";
  }
  
  public static ReadInJoyWebDataManager a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoReadInJoyWebDataManager == null) {
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoReadInJoyWebDataManager = new ReadInJoyWebDataManager();
    }
    return jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoReadInJoyWebDataManager;
  }
  
  private Long a(ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo != null)) {
      return paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaLangLong;
    }
    return Long.valueOf(paramArticleInfo.mFeedId);
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
  
  private String a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = (QQAppInterface)ReadInJoyUtils.a();
    if (localObject == null) {
      return null;
    }
    localObject = ((QQAppInterface)localObject).getEntityManagerFactory(((QQAppInterface)localObject).getAccount()).createEntityManager();
    paramString1 = (CouponH5Data)((EntityManager)localObject).find(CouponH5Data.class, "mHost = ? AND mPath = ? AND mKey = ?", new String[] { paramString1, paramString2, paramString3 });
    ((EntityManager)localObject).close();
    if (paramString1 != null) {}
    for (paramString1 = paramString1.mData;; paramString1 = null) {
      return paramString1;
    }
  }
  
  private JSONArray a(List<SocializeFeedsInfo.PGCPicInfo> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      SocializeFeedsInfo.PGCPicInfo localPGCPicInfo = (SocializeFeedsInfo.PGCPicInfo)localIterator.next();
      if ((localPGCPicInfo.jdField_b_of_type_JavaLangString != null) || (localPGCPicInfo.c != null))
      {
        JSONObject localJSONObject = new JSONObject();
        if (localPGCPicInfo.jdField_b_of_type_JavaLangString != null)
        {
          paramList = localPGCPicInfo.jdField_b_of_type_JavaLangString;
          label74:
          localJSONObject.put("origin_url", paramList);
          if (localPGCPicInfo.c == null) {
            break label155;
          }
        }
        label155:
        for (paramList = localPGCPicInfo.c;; paramList = localPGCPicInfo.jdField_b_of_type_JavaLangString)
        {
          localJSONObject.put("thumbnail_url", paramList);
          localJSONObject.put("pic_width", localPGCPicInfo.jdField_a_of_type_Int);
          localJSONObject.put("pic_height", localPGCPicInfo.jdField_b_of_type_Int);
          localJSONArray.put(localJSONObject);
          break;
          paramList = localPGCPicInfo.c;
          break label74;
        }
      }
    }
    return localJSONArray;
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
            break label148;
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
      label148:
      a(localJSONArray.toString());
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, JSONObject paramJSONObject)
  {
    if (RIJFeedsType.a(paramArticleInfo))
    {
      paramJSONObject.put("isVideo", 1);
      if (paramArticleInfo.mVideoCoverUrl != null) {
        paramJSONObject.put("picurl", paramArticleInfo.mVideoCoverUrl.toString());
      }
      paramJSONObject.put("videoTimeTips", UtilsForComponent.a(paramArticleInfo.mVideoDuration));
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, JSONObject paramJSONObject, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((!paramBoolean3) && (paramBoolean2) && (paramArticleInfo.mSocialFeedInfo != null)) {}
    for (int i1 = 1; i1 == 0; i1 = 0) {
      return;
    }
    if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null)
    {
      if (!paramBoolean1) {
        break label378;
      }
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Int != 1) {
        break label372;
      }
      i1 = 1;
      paramJSONObject.put("isAccountApproved", i1);
    }
    label73:
    Object localObject;
    for (;;)
    {
      if ((paramBoolean2) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo != null))
      {
        paramJSONObject.put("originFeedsId", String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaLangLong));
        paramJSONObject.put("originFeedsType", paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.b);
        localObject = new JSONArray();
        paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.iterator();
        while (paramArticleInfo.hasNext())
        {
          SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)paramArticleInfo.next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("biuLevel_feeds_id", String.valueOf(localBiuCommentInfo.mFeedId));
          localJSONObject.put("biuLevel_feeds_type", localBiuCommentInfo.mFeedsType);
          localJSONObject.put("biuLevel_uin", new String(Base64Util.encode(Long.toString(localBiuCommentInfo.mUin.longValue()).getBytes(), 0)));
          localJSONObject.put("biuLevel_nick", "");
          localJSONObject.put("biuLevel_remark", "");
          if (ReadInJoyUtils.a() != null)
          {
            String str = ContactUtils.c((QQAppInterface)ReadInJoyUtils.a(), Long.toString(localBiuCommentInfo.mUin.longValue()), true);
            localJSONObject.put("biuLevel_nick", str);
            localJSONObject.put("biuLevel_remark", str);
          }
          localJSONObject.put("biuLevel_comment", localBiuCommentInfo.mBiuComment);
          localJSONObject.put("biuLevel_time", localBiuCommentInfo.mBiuTime);
          localJSONObject.put("op_type", localBiuCommentInfo.mOpType);
          ((JSONArray)localObject).put(localJSONObject);
        }
        label372:
        i1 = 0;
        break;
        label378:
        if (paramBoolean2)
        {
          localObject = Long.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long);
          paramJSONObject.put("uin", new String(Base64Util.encode(Long.toString(((Long)localObject).longValue()).getBytes(), 0)));
          paramJSONObject.put("nick", "");
          paramJSONObject.put("remark", "");
          if (ReadInJoyUtils.a() != null)
          {
            localObject = ContactUtils.c((QQAppInterface)ReadInJoyUtils.a(), Long.toString(((Long)localObject).longValue()), true);
            paramJSONObject.put("nick", localObject);
            paramJSONObject.put("remark", localObject);
          }
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Int != 1) {
            break label524;
          }
        }
      }
    }
    label524:
    for (i1 = 1;; i1 = 0)
    {
      paramJSONObject.put("isApproved", i1);
      break label73;
      break;
    }
    paramJSONObject.put("biuLevelList", localObject);
  }
  
  public static void a(String paramString)
  {
    AppRuntime localAppRuntime = ReadInJoyUtils.a();
    if (localAppRuntime == null) {
      return;
    }
    ThreadManager.post(new ReadInJoyWebDataManager.6(localAppRuntime, paramString), 5, null, true);
  }
  
  /* Error */
  private void a(String paramString1, ReadInJoyWebDataManager.H5DataCallback paramH5DataCallback, JSONObject paramJSONObject, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 197	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyUtils:a	()Lmqq/app/AppRuntime;
    //   3: checkcast 199	com/tencent/mobileqq/app/QQAppInterface
    //   6: astore 6
    //   8: aload 6
    //   10: ifnonnull +4 -> 14
    //   13: return
    //   14: new 253	org/json/JSONObject
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 455	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   22: astore 7
    //   24: aload 7
    //   26: ldc_w 457
    //   29: invokevirtual 460	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   32: astore 5
    //   34: aload 5
    //   36: astore_1
    //   37: aload 5
    //   39: invokestatic 466	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   42: ifne +24 -> 66
    //   45: aload 5
    //   47: ldc_w 468
    //   50: ldc_w 470
    //   53: invokevirtual 474	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   56: ldc_w 476
    //   59: ldc_w 478
    //   62: invokevirtual 474	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   65: astore_1
    //   66: aload_3
    //   67: ldc_w 457
    //   70: aload_1
    //   71: invokevirtual 260	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   74: pop
    //   75: aload 7
    //   77: ldc_w 480
    //   80: invokevirtual 460	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   83: astore 5
    //   85: aload 5
    //   87: invokestatic 466	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   90: ifeq +20 -> 110
    //   93: aload_2
    //   94: aload_3
    //   95: invokeinterface 485 2 0
    //   100: return
    //   101: astore_1
    //   102: aload_2
    //   103: aload_3
    //   104: invokeinterface 485 2 0
    //   109: return
    //   110: new 323	java/net/URL
    //   113: dup
    //   114: aload 4
    //   116: invokespecial 486	java/net/URL:<init>	(Ljava/lang/String;)V
    //   119: invokevirtual 489	java/net/URL:getHost	()Ljava/lang/String;
    //   122: astore_1
    //   123: aload 7
    //   125: ldc_w 491
    //   128: invokevirtual 460	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   131: astore 4
    //   133: aload 4
    //   135: invokestatic 466	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   138: ifne +474 -> 612
    //   141: aload_0
    //   142: aload 4
    //   144: aload_1
    //   145: invokespecial 494	com/tencent/biz/pubaccount/readinjoy/video/ReadInJoyWebDataManager:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   148: ifeq +43 -> 191
    //   151: aload 4
    //   153: astore_1
    //   154: aload_1
    //   155: invokestatic 466	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   158: ifeq +451 -> 609
    //   161: ldc_w 496
    //   164: astore_1
    //   165: aload 7
    //   167: ldc_w 498
    //   170: invokevirtual 460	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   173: astore 4
    //   175: aload 4
    //   177: invokestatic 466	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   180: ifeq +19 -> 199
    //   183: aload_2
    //   184: aload_3
    //   185: invokeinterface 485 2 0
    //   190: return
    //   191: aload_2
    //   192: aload_3
    //   193: invokeinterface 485 2 0
    //   198: return
    //   199: aload_0
    //   200: aload_1
    //   201: aload 5
    //   203: aload 4
    //   205: invokespecial 500	com/tencent/biz/pubaccount/readinjoy/video/ReadInJoyWebDataManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   208: astore 7
    //   210: aload 7
    //   212: invokestatic 466	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   215: ifeq +11 -> 226
    //   218: aload_2
    //   219: aload_3
    //   220: invokeinterface 485 2 0
    //   225: return
    //   226: new 502	java/io/File
    //   229: dup
    //   230: new 35	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   237: ldc_w 504
    //   240: invokestatic 510	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   243: checkcast 504	com/tencent/biz/pubaccount/api/IPublicAccountJavascriptInterface
    //   246: invokeinterface 513 1 0
    //   251: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: ldc_w 515
    //   257: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload 6
    //   262: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   265: invokestatic 520	com/tencent/mobileqq/utils/HexUtil:String2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   268: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: ldc_w 515
    //   274: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload_1
    //   278: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: ldc_w 515
    //   284: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload 5
    //   289: invokestatic 520	com/tencent/mobileqq/utils/HexUtil:String2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   292: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: ldc_w 515
    //   298: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: aload 4
    //   303: invokestatic 520	com/tencent/mobileqq/utils/HexUtil:String2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   306: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokespecial 521	java/io/File:<init>	(Ljava/lang/String;)V
    //   315: astore 5
    //   317: aload 5
    //   319: invokevirtual 524	java/io/File:exists	()Z
    //   322: ifne +22 -> 344
    //   325: aload_3
    //   326: ldc_w 526
    //   329: ldc_w 528
    //   332: invokevirtual 260	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   335: pop
    //   336: aload_2
    //   337: aload_3
    //   338: invokeinterface 485 2 0
    //   343: return
    //   344: aload_0
    //   345: monitorenter
    //   346: new 530	java/io/FileInputStream
    //   349: dup
    //   350: aload 5
    //   352: invokespecial 533	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   355: astore_1
    //   356: aload_1
    //   357: astore 4
    //   359: aload 5
    //   361: invokevirtual 535	java/io/File:length	()J
    //   364: l2i
    //   365: newarray byte
    //   367: astore 5
    //   369: aload_1
    //   370: astore 4
    //   372: aload_1
    //   373: aload 5
    //   375: invokevirtual 541	java/io/InputStream:read	([B)I
    //   378: pop
    //   379: aload_1
    //   380: astore 4
    //   382: aload_0
    //   383: new 156	java/lang/String
    //   386: dup
    //   387: aload 5
    //   389: invokespecial 387	java/lang/String:<init>	([B)V
    //   392: aload 7
    //   394: invokespecial 543	com/tencent/biz/pubaccount/readinjoy/video/ReadInJoyWebDataManager:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   397: astore 5
    //   399: aload 5
    //   401: ifnonnull +47 -> 448
    //   404: aload_1
    //   405: astore 4
    //   407: aload_3
    //   408: ldc_w 526
    //   411: ldc_w 545
    //   414: invokevirtual 260	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   417: pop
    //   418: aload_1
    //   419: astore 4
    //   421: aload_2
    //   422: aload_3
    //   423: invokeinterface 485 2 0
    //   428: aload_1
    //   429: astore 4
    //   431: aload_0
    //   432: monitorexit
    //   433: aload_1
    //   434: ifnull +181 -> 615
    //   437: aload_1
    //   438: invokevirtual 546	java/io/InputStream:close	()V
    //   441: return
    //   442: astore_1
    //   443: aload_1
    //   444: invokevirtual 549	java/io/IOException:printStackTrace	()V
    //   447: return
    //   448: aload_1
    //   449: astore 4
    //   451: aload_3
    //   452: ldc_w 551
    //   455: aload 5
    //   457: ldc_w 468
    //   460: ldc_w 470
    //   463: invokevirtual 474	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   466: ldc_w 476
    //   469: ldc_w 478
    //   472: invokevirtual 474	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   475: invokevirtual 260	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   478: pop
    //   479: aload_1
    //   480: astore 4
    //   482: aload_2
    //   483: aload_3
    //   484: invokeinterface 485 2 0
    //   489: aload_1
    //   490: astore 4
    //   492: aload_0
    //   493: monitorexit
    //   494: aload_1
    //   495: ifnull +120 -> 615
    //   498: aload_1
    //   499: invokevirtual 546	java/io/InputStream:close	()V
    //   502: return
    //   503: astore_1
    //   504: aload_1
    //   505: invokevirtual 549	java/io/IOException:printStackTrace	()V
    //   508: return
    //   509: astore 5
    //   511: aconst_null
    //   512: astore_1
    //   513: aload_1
    //   514: astore 4
    //   516: aload_0
    //   517: monitorexit
    //   518: aload_1
    //   519: astore 4
    //   521: aload 5
    //   523: athrow
    //   524: astore 4
    //   526: aload_1
    //   527: astore 4
    //   529: aload_3
    //   530: ldc_w 526
    //   533: ldc_w 553
    //   536: invokevirtual 260	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   539: pop
    //   540: aload_1
    //   541: astore 4
    //   543: aload_2
    //   544: aload_3
    //   545: invokeinterface 485 2 0
    //   550: aload_1
    //   551: ifnull +64 -> 615
    //   554: aload_1
    //   555: invokevirtual 546	java/io/InputStream:close	()V
    //   558: return
    //   559: astore_1
    //   560: aload_1
    //   561: invokevirtual 549	java/io/IOException:printStackTrace	()V
    //   564: return
    //   565: astore_1
    //   566: aconst_null
    //   567: astore 4
    //   569: aload 4
    //   571: ifnull +8 -> 579
    //   574: aload 4
    //   576: invokevirtual 546	java/io/InputStream:close	()V
    //   579: aload_1
    //   580: athrow
    //   581: astore 4
    //   583: aload 4
    //   585: invokevirtual 549	java/io/IOException:printStackTrace	()V
    //   588: goto -9 -> 579
    //   591: astore_1
    //   592: goto -23 -> 569
    //   595: astore_1
    //   596: aconst_null
    //   597: astore_1
    //   598: goto -72 -> 526
    //   601: astore 5
    //   603: aload 4
    //   605: astore_1
    //   606: goto -93 -> 513
    //   609: goto -444 -> 165
    //   612: goto -458 -> 154
    //   615: return
    //   616: astore_1
    //   617: aconst_null
    //   618: astore_1
    //   619: goto -496 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	622	0	this	ReadInJoyWebDataManager
    //   0	622	1	paramString1	String
    //   0	622	2	paramH5DataCallback	ReadInJoyWebDataManager.H5DataCallback
    //   0	622	3	paramJSONObject	JSONObject
    //   0	622	4	paramString2	String
    //   32	424	5	localObject1	Object
    //   509	13	5	localObject2	Object
    //   601	1	5	localObject3	Object
    //   6	255	6	localQQAppInterface	QQAppInterface
    //   22	371	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   0	8	101	org/json/JSONException
    //   14	34	101	org/json/JSONException
    //   37	66	101	org/json/JSONException
    //   66	100	101	org/json/JSONException
    //   110	123	101	org/json/JSONException
    //   123	151	101	org/json/JSONException
    //   154	161	101	org/json/JSONException
    //   165	190	101	org/json/JSONException
    //   191	198	101	org/json/JSONException
    //   199	225	101	org/json/JSONException
    //   226	343	101	org/json/JSONException
    //   437	441	101	org/json/JSONException
    //   443	447	101	org/json/JSONException
    //   498	502	101	org/json/JSONException
    //   504	508	101	org/json/JSONException
    //   554	558	101	org/json/JSONException
    //   560	564	101	org/json/JSONException
    //   574	579	101	org/json/JSONException
    //   579	581	101	org/json/JSONException
    //   583	588	101	org/json/JSONException
    //   437	441	442	java/io/IOException
    //   498	502	503	java/io/IOException
    //   346	356	509	finally
    //   521	524	524	java/io/IOException
    //   554	558	559	java/io/IOException
    //   344	346	565	finally
    //   574	579	581	java/io/IOException
    //   521	524	591	finally
    //   529	540	591	finally
    //   543	550	591	finally
    //   344	346	595	java/io/IOException
    //   359	369	601	finally
    //   372	379	601	finally
    //   382	399	601	finally
    //   407	418	601	finally
    //   421	428	601	finally
    //   431	433	601	finally
    //   451	479	601	finally
    //   482	489	601	finally
    //   492	494	601	finally
    //   516	518	601	finally
    //   110	123	616	java/net/MalformedURLException
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = (QQAppInterface)ReadInJoyUtils.a();
    if (localObject == null) {
      return;
    }
    localObject = ((QQAppInterface)localObject).getEntityManagerFactory(((QQAppInterface)localObject).getAccount()).createEntityManager();
    CouponH5Data localCouponH5Data = (CouponH5Data)((EntityManager)localObject).find(CouponH5Data.class, "mHost = ? AND mPath = ? AND mKey = ?", new String[] { paramString1, paramString2, paramString3 });
    if (localCouponH5Data == null) {
      ((EntityManager)localObject).persist(new CouponH5Data(paramString1, paramString2, paramString3, paramString4));
    }
    for (;;)
    {
      ((EntityManager)localObject).close();
      return;
      localCouponH5Data.mData = paramString4;
      ((EntityManager)localObject).update(localCouponH5Data);
    }
  }
  
  private void a(String paramString1, JSONObject paramJSONObject, String paramString2, ReadInJoyWebDataManager.HttpFetchBizCallback paramHttpFetchBizCallback)
  {
    ThreadManager.post(new ReadInJoyWebDataManager.5(this, paramString1, paramString2, paramHttpFetchBizCallback, paramJSONObject), 5, null, true);
  }
  
  /* Error */
  private void a(URL paramURL, String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: invokestatic 197	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyUtils:a	()Lmqq/app/AppRuntime;
    //   3: checkcast 199	com/tencent/mobileqq/app/QQAppInterface
    //   6: astore 9
    //   8: aload 9
    //   10: ifnonnull +4 -> 14
    //   13: return
    //   14: new 253	org/json/JSONObject
    //   17: dup
    //   18: aload_2
    //   19: invokespecial 455	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   22: astore 10
    //   24: aload 10
    //   26: ldc_w 457
    //   29: invokevirtual 460	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   32: astore 8
    //   34: aload 8
    //   36: astore 7
    //   38: aload 8
    //   40: invokestatic 466	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   43: ifne +25 -> 68
    //   46: aload 8
    //   48: ldc_w 468
    //   51: ldc_w 470
    //   54: invokevirtual 474	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   57: ldc_w 476
    //   60: ldc_w 478
    //   63: invokevirtual 474	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   66: astore 7
    //   68: aload 4
    //   70: ldc_w 457
    //   73: aload 7
    //   75: invokevirtual 260	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   78: pop
    //   79: getstatic 33	com/tencent/biz/pubaccount/readinjoy/video/ReadInJoyWebDataManager:jdField_a_of_type_Long	J
    //   82: ldc2_w 571
    //   85: lcmp
    //   86: ifle +20 -> 106
    //   89: new 574	com/tencent/biz/pubaccount/readinjoy/video/ReadInJoyWebDataManager$3
    //   92: dup
    //   93: aload_0
    //   94: aload_1
    //   95: aload_2
    //   96: aload_3
    //   97: aload 4
    //   99: invokespecial 576	com/tencent/biz/pubaccount/readinjoy/video/ReadInJoyWebDataManager$3:<init>	(Lcom/tencent/biz/pubaccount/readinjoy/video/ReadInJoyWebDataManager;Ljava/net/URL;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V
    //   102: invokestatic 580	com/tencent/mobileqq/app/ThreadManager:executeOnNetWorkThread	(Ljava/lang/Runnable;)V
    //   105: return
    //   106: aload 10
    //   108: ldc_w 480
    //   111: invokevirtual 460	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   114: astore_3
    //   115: aload_3
    //   116: invokestatic 466	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   119: ifne +435 -> 554
    //   122: aload 10
    //   124: ldc_w 498
    //   127: invokevirtual 460	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   130: astore 4
    //   132: aload 4
    //   134: invokestatic 466	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   137: ifne +417 -> 554
    //   140: aload 10
    //   142: ldc_w 551
    //   145: invokevirtual 460	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   148: astore 7
    //   150: aload 7
    //   152: invokestatic 466	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   155: ifne +399 -> 554
    //   158: aload_1
    //   159: invokevirtual 489	java/net/URL:getHost	()Ljava/lang/String;
    //   162: astore_1
    //   163: aload 10
    //   165: ldc_w 491
    //   168: invokevirtual 460	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   171: astore_2
    //   172: aload_2
    //   173: invokestatic 466	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   176: ifne +375 -> 551
    //   179: aload_0
    //   180: aload_2
    //   181: aload_1
    //   182: invokespecial 494	com/tencent/biz/pubaccount/readinjoy/video/ReadInJoyWebDataManager:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   185: ifeq +369 -> 554
    //   188: aload_2
    //   189: astore_1
    //   190: aload_1
    //   191: invokestatic 466	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   194: ifeq +354 -> 548
    //   197: ldc_w 496
    //   200: astore_1
    //   201: aload_0
    //   202: aload 7
    //   204: invokespecial 582	com/tencent/biz/pubaccount/readinjoy/video/ReadInJoyWebDataManager:b	(Ljava/lang/String;)Ljava/lang/String;
    //   207: astore_2
    //   208: aload_0
    //   209: aload_1
    //   210: aload_3
    //   211: aload 4
    //   213: aload_2
    //   214: invokespecial 584	com/tencent/biz/pubaccount/readinjoy/video/ReadInJoyWebDataManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   217: aload_0
    //   218: aload 7
    //   220: aload_2
    //   221: invokespecial 585	com/tencent/biz/pubaccount/readinjoy/video/ReadInJoyWebDataManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   224: astore 7
    //   226: new 502	java/io/File
    //   229: dup
    //   230: new 35	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   237: ldc_w 504
    //   240: invokestatic 510	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   243: checkcast 504	com/tencent/biz/pubaccount/api/IPublicAccountJavascriptInterface
    //   246: invokeinterface 513 1 0
    //   251: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: ldc_w 515
    //   257: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload 9
    //   262: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   265: invokestatic 520	com/tencent/mobileqq/utils/HexUtil:String2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   268: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokespecial 521	java/io/File:<init>	(Ljava/lang/String;)V
    //   277: astore_2
    //   278: aload_2
    //   279: invokevirtual 524	java/io/File:exists	()Z
    //   282: ifne +153 -> 435
    //   285: aload_2
    //   286: invokevirtual 588	java/io/File:mkdirs	()Z
    //   289: pop
    //   290: new 502	java/io/File
    //   293: dup
    //   294: aload_2
    //   295: aload_1
    //   296: invokespecial 591	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   299: astore_1
    //   300: aload_1
    //   301: invokevirtual 524	java/io/File:exists	()Z
    //   304: ifne +151 -> 455
    //   307: aload_1
    //   308: invokevirtual 588	java/io/File:mkdirs	()Z
    //   311: pop
    //   312: new 502	java/io/File
    //   315: dup
    //   316: aload_1
    //   317: aload_3
    //   318: invokestatic 520	com/tencent/mobileqq/utils/HexUtil:String2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   321: invokespecial 591	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   324: astore 8
    //   326: aload 8
    //   328: invokevirtual 524	java/io/File:exists	()Z
    //   331: ifne +144 -> 475
    //   334: aload 8
    //   336: invokevirtual 588	java/io/File:mkdirs	()Z
    //   339: pop
    //   340: aconst_null
    //   341: astore_2
    //   342: aconst_null
    //   343: astore_1
    //   344: aconst_null
    //   345: astore_3
    //   346: aload_0
    //   347: monitorenter
    //   348: aload_3
    //   349: astore_2
    //   350: new 502	java/io/File
    //   353: dup
    //   354: aload 8
    //   356: aload 4
    //   358: invokestatic 520	com/tencent/mobileqq/utils/HexUtil:String2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   361: invokespecial 591	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   364: astore 4
    //   366: aload_3
    //   367: astore_2
    //   368: aload 4
    //   370: invokevirtual 524	java/io/File:exists	()Z
    //   373: ifeq +11 -> 384
    //   376: aload_3
    //   377: astore_2
    //   378: aload 4
    //   380: invokevirtual 594	java/io/File:delete	()Z
    //   383: pop
    //   384: aload_3
    //   385: astore_2
    //   386: new 596	java/io/FileWriter
    //   389: dup
    //   390: aload 4
    //   392: invokespecial 597	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   395: astore_1
    //   396: aload_1
    //   397: aload 7
    //   399: invokevirtual 600	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   402: getstatic 33	com/tencent/biz/pubaccount/readinjoy/video/ReadInJoyWebDataManager:jdField_a_of_type_Long	J
    //   405: lstore 5
    //   407: aload 4
    //   409: invokevirtual 535	java/io/File:length	()J
    //   412: lload 5
    //   414: ladd
    //   415: putstatic 33	com/tencent/biz/pubaccount/readinjoy/video/ReadInJoyWebDataManager:jdField_a_of_type_Long	J
    //   418: aload_0
    //   419: monitorexit
    //   420: aload_1
    //   421: ifnull +133 -> 554
    //   424: aload_1
    //   425: invokevirtual 601	java/io/FileWriter:close	()V
    //   428: return
    //   429: astore_1
    //   430: aload_1
    //   431: invokevirtual 549	java/io/IOException:printStackTrace	()V
    //   434: return
    //   435: aload_2
    //   436: invokevirtual 604	java/io/File:isFile	()Z
    //   439: ifeq -149 -> 290
    //   442: aload_2
    //   443: invokevirtual 594	java/io/File:delete	()Z
    //   446: pop
    //   447: aload_2
    //   448: invokevirtual 588	java/io/File:mkdirs	()Z
    //   451: pop
    //   452: goto -162 -> 290
    //   455: aload_1
    //   456: invokevirtual 604	java/io/File:isFile	()Z
    //   459: ifeq -147 -> 312
    //   462: aload_1
    //   463: invokevirtual 594	java/io/File:delete	()Z
    //   466: pop
    //   467: aload_1
    //   468: invokevirtual 588	java/io/File:mkdirs	()Z
    //   471: pop
    //   472: goto -160 -> 312
    //   475: aload 8
    //   477: invokevirtual 604	java/io/File:isFile	()Z
    //   480: ifeq -140 -> 340
    //   483: aload 8
    //   485: invokevirtual 594	java/io/File:delete	()Z
    //   488: pop
    //   489: aload 8
    //   491: invokevirtual 588	java/io/File:mkdirs	()Z
    //   494: pop
    //   495: goto -155 -> 340
    //   498: astore_3
    //   499: aload_2
    //   500: astore_1
    //   501: aload_1
    //   502: astore_2
    //   503: aload_0
    //   504: monitorexit
    //   505: aload_1
    //   506: astore_2
    //   507: aload_3
    //   508: athrow
    //   509: astore_1
    //   510: aload_2
    //   511: ifnull +43 -> 554
    //   514: aload_2
    //   515: invokevirtual 601	java/io/FileWriter:close	()V
    //   518: return
    //   519: astore_1
    //   520: aload_1
    //   521: invokevirtual 549	java/io/IOException:printStackTrace	()V
    //   524: return
    //   525: astore_2
    //   526: aload_1
    //   527: ifnull +7 -> 534
    //   530: aload_1
    //   531: invokevirtual 601	java/io/FileWriter:close	()V
    //   534: aload_2
    //   535: athrow
    //   536: astore_1
    //   537: aload_1
    //   538: invokevirtual 549	java/io/IOException:printStackTrace	()V
    //   541: goto -7 -> 534
    //   544: astore_3
    //   545: goto -44 -> 501
    //   548: goto -347 -> 201
    //   551: goto -361 -> 190
    //   554: return
    //   555: astore_1
    //   556: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	557	0	this	ReadInJoyWebDataManager
    //   0	557	1	paramURL	URL
    //   0	557	2	paramString1	String
    //   0	557	3	paramString2	String
    //   0	557	4	paramJSONObject	JSONObject
    //   405	8	5	l1	long
    //   36	362	7	localObject1	Object
    //   32	458	8	localObject2	Object
    //   6	255	9	localQQAppInterface	QQAppInterface
    //   22	142	10	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   424	428	429	java/io/IOException
    //   350	366	498	finally
    //   368	376	498	finally
    //   378	384	498	finally
    //   386	396	498	finally
    //   503	505	498	finally
    //   346	348	509	java/io/IOException
    //   507	509	509	java/io/IOException
    //   514	518	519	java/io/IOException
    //   346	348	525	finally
    //   507	509	525	finally
    //   530	534	536	java/io/IOException
    //   396	420	544	finally
    //   0	8	555	org/json/JSONException
    //   14	34	555	org/json/JSONException
    //   38	68	555	org/json/JSONException
    //   68	105	555	org/json/JSONException
    //   106	188	555	org/json/JSONException
    //   190	197	555	org/json/JSONException
    //   201	290	555	org/json/JSONException
    //   290	312	555	org/json/JSONException
    //   312	340	555	org/json/JSONException
    //   424	428	555	org/json/JSONException
    //   430	434	555	org/json/JSONException
    //   435	452	555	org/json/JSONException
    //   455	472	555	org/json/JSONException
    //   475	495	555	org/json/JSONException
    //   514	518	555	org/json/JSONException
    //   520	524	555	org/json/JSONException
    //   530	534	555	org/json/JSONException
    //   534	536	555	org/json/JSONException
    //   537	541	555	org/json/JSONException
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    do
    {
      return false;
      if ((RIJItemViewType.f(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo != null))
      {
        switch ((int)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.b.longValue())
        {
        case 11: 
        default: 
          return false;
        }
        return true;
      }
    } while ((!RIJItemViewType.a(paramArticleInfo)) && (!RIJItemViewType.h(paramArticleInfo)));
    return true;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if (paramString2 == null) {}
    while ((!paramString2.equals(paramString1)) && ((paramString1.indexOf(".") <= 0) || (!paramString2.endsWith("." + paramString1)))) {
      return false;
    }
    return true;
  }
  
  private Long b(ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo != null)) {
      return paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.b;
    }
    return Long.valueOf(paramArticleInfo.mFeedType);
  }
  
  private String b()
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
  
  private String b(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes("UTF-8"));
      paramString = HexUtil.bytes2HexStr(localMessageDigest.digest());
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
  
  private String b(String paramString1, String paramString2)
  {
    return ThreeDes.b(paramString1, paramString2);
  }
  
  private void b(ArticleInfo paramArticleInfo, JSONObject paramJSONObject)
  {
    int i1 = 2;
    int i2;
    if (paramArticleInfo.mSocialFeedInfo != null)
    {
      paramJSONObject.put("timeTips", ReadInJoyTimeUtils.a(paramArticleInfo.mSocialFeedInfo.e, true));
      i2 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int;
      switch (i2)
      {
      case 3: 
      case 4: 
      case 7: 
      case 8: 
      default: 
        paramJSONObject.put("picShowType", 1);
      }
    }
    do
    {
      return;
      if (i2 == 6) {}
      for (;;)
      {
        paramJSONObject.put("picShowType", i1);
        paramJSONObject.put("isVideo", 1);
        if (paramArticleInfo.mVideoCoverUrl != null) {
          paramJSONObject.put("picurl", paramArticleInfo.mVideoCoverUrl.toString().replace("pubaccountimage:", ""));
        }
        paramJSONObject.put("videoTimeTips", UtilsForComponent.a(paramArticleInfo.mVideoDuration));
        return;
        i1 = 1;
      }
      if (i2 == 2) {}
      for (;;)
      {
        paramJSONObject.put("picShowType", i1);
        return;
        i1 = 1;
      }
      paramJSONObject.put("isMultiPic", 1);
    } while ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a.size() <= 0));
    paramJSONObject.put("multiPicUrls", a(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a));
  }
  
  private void b(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (c.equals(paramString1)))
    {
      paramString1 = b(paramString2);
      if (!paramString1.equals(this.o))
      {
        this.o = paramString1;
        this.p = paramString2;
      }
    }
  }
  
  private void b(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject)
  {
    try
    {
      ThreadManager.post(new ReadInJoyWebDataManager.2(this, new URL(paramString1), paramString2, paramString3, paramJSONObject), 5, null, false);
      return;
    }
    catch (MalformedURLException paramString1) {}
  }
  
  public static boolean b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
    if (localQQAppInterface == null) {}
    while (localQQAppInterface.getApp() == null) {
      return false;
    }
    if ((AppNetConnInfo.isWifiConn()) || ((AppNetConnInfo.isMobileConn()) && (AppNetConnInfo.getMobileInfo() == 3))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static long c()
  {
    long l1 = 0L;
    Object localObject = new File(((IPublicAccountJavascriptInterface)QRoute.api(IPublicAccountJavascriptInterface.class)).getDataPath());
    long l2;
    if (!((File)localObject).exists())
    {
      l2 = l1;
      return l2;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    for (;;)
    {
      l2 = l1;
      if (localArrayList.isEmpty()) {
        break;
      }
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
  }
  
  private String c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new String(Base64Util.decode(paramString, 0));
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = "https://q.qlogo.cn/g?b=qq&s=100&nk=" + paramString;
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        return "";
      }
    }
    return "";
  }
  
  public void a(ArticleInfo paramArticleInfo, boolean paramBoolean, String paramString)
  {
    int i1 = 1;
    if ((paramArticleInfo == null) || (!a(paramArticleInfo)))
    {
      this.n = "";
      return;
    }
    Boolean localBoolean1 = Boolean.valueOf(RIJItemViewType.f(paramArticleInfo));
    if ((RIJItemViewType.a(paramArticleInfo)) || (RIJItemViewType.h(paramArticleInfo))) {}
    Boolean localBoolean2;
    for (boolean bool = true;; bool = false)
    {
      localBoolean2 = Boolean.valueOf(bool);
      if ((localBoolean2.booleanValue()) || (localBoolean1.booleanValue())) {
        break;
      }
      this.n = "";
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("qqheadurl", c(Uri.parse(paramString).getQueryParameter("uin")));
        localJSONObject.put("feeds_id", String.valueOf(a(paramArticleInfo, paramBoolean)));
        localJSONObject.put("feedsType", b(paramArticleInfo, paramBoolean));
        localJSONObject.put("accountID", paramArticleInfo.mSubscribeID);
        localJSONObject.put("site", paramArticleInfo.mSubscribeName);
        localJSONObject.put("isAccountDerelict", TextUtils.isEmpty(paramArticleInfo.mSubscribeID));
        localJSONObject.put("isAccountApproved", "");
        localJSONObject.put("acticleid", paramArticleInfo.mArticleID);
        localJSONObject.put("articleurl", paramArticleInfo.mArticleContentUrl);
        localJSONObject.put("articleDesc", paramArticleInfo.mSummary);
        localJSONObject.put("title", paramArticleInfo.mTitle);
        localJSONObject.put("timeTips", ReadInJoyTimeUtils.b(paramArticleInfo.mTime));
        if (paramArticleInfo.mSinglePicture == null) {
          break label451;
        }
        paramString = paramArticleInfo.mSinglePicture.getFile();
        localJSONObject.put("picurl", paramString);
        if (paramArticleInfo.mShowBigPicture) {
          i1 = 2;
        }
        localJSONObject.put("picShowType", i1);
        a(paramArticleInfo, localJSONObject);
        a(paramArticleInfo, localJSONObject, localBoolean2.booleanValue(), localBoolean1.booleanValue(), paramBoolean);
        b(paramArticleInfo, localJSONObject);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyWebDataManager", 2, "jsonRetData(), retData=" + localJSONObject.toString());
        }
        this.n = localJSONObject.toString();
        this.jdField_b_of_type_Long = Long.parseLong(localJSONObject.getString("feeds_id"));
        return;
      }
      catch (JSONException paramArticleInfo)
      {
        this.n = "";
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReadInJoyWebDataManager", 2, "setSecondCommnetPageData JSONException" + paramArticleInfo.toString());
      return;
      label451:
      paramString = paramArticleInfo.mFirstPagePicUrl;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    boolean bool = true;
    if (!a(c)) {
      return;
    }
    ReadInJoyWebDataManager.7 local7 = null;
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
          local7 = new ReadInJoyWebDataManager.7(this);
          paramString = str + "&ispreload=1";
        }
        str = c;
        if (paramInt == 1)
        {
          a("get", paramString, localJSONObject, str, local7, Boolean.valueOf(bool));
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
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008221", "0X8008221", 0, 0, paramString1, paramString2, "", "", false);
  }
  
  public void a(String paramString1, String paramString2, ReadInJoyWebDataManager.H5DataCallback paramH5DataCallback)
  {
    JSONObject localJSONObject = new JSONObject();
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    new Thread(new ReadInJoyWebDataManager.4(this, paramString2, paramH5DataCallback, localJSONObject, paramString1)).start();
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008220", "0X8008220", 0, 0, paramString1, paramString2, paramString3, "", false);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new ReadInJoyWebDataManager.1(this, paramString1, paramString2, paramString3, paramJSONObject));
      return;
    }
    b(paramString1, paramString2, paramString3, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, JSONObject paramJSONObject, String paramString3)
  {
    a(paramString1, paramString2, paramJSONObject, paramString3, null, Boolean.valueOf(false));
  }
  
  public void a(String paramString1, String paramString2, JSONObject paramJSONObject, String paramString3, ReadInJoyWebDataManager.HttpFetchBizCallback paramHttpFetchBizCallback, Boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString2)) && (System.currentTimeMillis() - ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString2)).longValue() < 1800000L)) {
        a(paramString3, g, j);
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        a(paramString3, f, "");
        if (!paramBoolean.booleanValue()) {
          this.jdField_a_of_type_JavaUtilHashMap.put(paramString2, Long.valueOf(System.currentTimeMillis()));
        }
        if (paramString2.indexOf("?") != -1) {}
        for (paramString2 = paramString2 + "&g_tk=" + b(); "get".equals(paramString1); paramString2 = paramString2 + "?g_tk=" + b())
        {
          a(paramString2, paramJSONObject, paramString3, paramHttpFetchBizCallback);
          return;
        }
      }
    }
    QLog.w("ReadInJoyWebDataManager", 2, "httpFetchAsync mCgiLoadedMap cause mCgiLoadedMap is null ");
  }
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    if ((BaseApplication.getContext() == null) || (!ViolaPicSerPreloadHandler.a())) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView == null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView = new ViolaBaseView(BaseApplication.getContext());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(jdField_a_of_type_JavaLangString, null, new ViolaBaseView.ViolaCreactPageObject(jdField_a_of_type_JavaLangString, new JSONObject(), null, null));
      }
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("url", paramString);
        localJSONObject.put("param", paramJSONObject);
        paramString = new JSONObject();
        paramString.put("preloadViola", localJSONObject);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(paramString.toString());
        return;
      }
      catch (JSONException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.w("ReadInJoyWebDataManager", 2, "preLoadComCgi e " + paramString.getMessage());
  }
  
  public boolean a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
    if (localQQAppInterface == null) {
      return false;
    }
    if ((b()) && (ReadInJoyHelper.B(localQQAppInterface))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean a(String paramString)
  {
    if (!a())
    {
      if (!b()) {
        a(paramString, g, h);
      }
      for (;;)
      {
        return false;
        a(paramString, g, i);
      }
    }
    return true;
  }
  
  public void b()
  {
    this.n = "";
    this.l = "";
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.onActivityDestroy();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView = null;
    }
  }
  
  public void b(String paramString)
  {
    a(paramString, null);
  }
  
  public void c(String paramString)
  {
    if (!a(jdField_b_of_type_JavaLangString)) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("callid", "0");
      localJSONObject.put("host", "kandian.qq.com");
      localJSONObject.put("path", "kandian_homepage");
      localJSONObject.put("key", "kandian_homepage2_data_key_" + paramString);
      a("get", "https://kandian.qq.com/qz_kandian_social/kandian_ext/getPersonPage?pageNo=1&pageSize=20&is715=1&uin=" + paramString, localJSONObject, jdField_b_of_type_JavaLangString);
      return;
    }
    catch (Exception paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager
 * JD-Core Version:    0.7.0.1
 */