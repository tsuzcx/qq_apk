package com.tencent.biz.pubaccount.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.NativeAd.report.AdSessionManager;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.GalleryReportedUtils;
import com.tencent.biz.pubaccount.readinjoy.common.KandianDailyReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.RIJXTabFrameUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.msgbox.RIJMsgBoxUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.RIJXTabNormalRedDotStore;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.ForeBackGround;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.UserOptInfo;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnSocialHeaderFollowClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo.RedPntInfoForReport;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public class ReadinjoyReportUtils
{
  public static int a;
  public static long a;
  public static String a;
  public static Map<Long, Pair<Long, Long>> a;
  private static boolean a;
  public static int b;
  public static final Map<Long, Map<Long, ReadinjoyReportUtils.ExposureReportItem>> b;
  private static boolean b;
  public static int c;
  public static int d;
  public static int e;
  public static int f;
  public static int g;
  public static volatile int h = 0;
  private static int i;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 2;
    c = 1;
    d = 2;
    e = 10;
    f = 11;
    g = 12;
    ReadinjoySPEventReport.ForeBackGround.a(new ReadinjoyReportUtils.1());
    jdField_a_of_type_Long = 0L;
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_b_of_type_JavaUtilMap = new HashMap();
    jdField_b_of_type_Boolean = true;
    i = 0;
  }
  
  public static int a()
  {
    switch ()
    {
    default: 
      return 1;
    case 1: 
      return 4;
    case 2: 
      return 3;
    }
    return 5;
  }
  
  public static int a(BaseArticleInfo paramBaseArticleInfo)
  {
    int k = 0;
    int j = k;
    if ((paramBaseArticleInfo instanceof ArticleInfo))
    {
      j = k;
      if (!RIJItemViewType.q((ArticleInfo)paramBaseArticleInfo)) {
        j = 1;
      }
    }
    return j;
  }
  
  public static RIJTransMergeKanDianReport.ReportR5Builder a(TemplateBean paramTemplateBean, String paramString)
  {
    if (paramTemplateBean == null) {
      return null;
    }
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
    if (paramTemplateBean != null)
    {
      paramTemplateBean = paramTemplateBean.getDataAttribute(paramString);
      if ((paramTemplateBean != null) && (paramTemplateBean.entrySet() != null))
      {
        paramTemplateBean = paramTemplateBean.entrySet().iterator();
        while ((paramTemplateBean != null) && (paramTemplateBean.hasNext()))
        {
          paramString = (Map.Entry)paramTemplateBean.next();
          localReportR5Builder.b((String)paramString.getKey(), paramString.getValue().toString());
        }
      }
    }
    return localReportR5Builder;
  }
  
  public static Pair<Long, Long> a(long paramLong)
  {
    if (jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong))) {
      return (Pair)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    }
    return null;
  }
  
  public static String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("version", VideoReporter.jdField_a_of_type_JavaLangString);
      localJSONObject.put("os", "1");
      localJSONObject.put("channel_id", KandianDailyReportUtils.b());
      return localJSONObject.toString();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "Other";
    case 2: 
      return "KDTAB";
    case 7: 
      return "4Tab";
    case 4: 
      return "MsgTab";
    case 3: 
      return "FromDTTab";
    case 5: 
      return "Lock";
    }
    return "Daily";
  }
  
  public static String a(long paramLong)
  {
    if ((DailyModeConfigHandler.a((int)paramLong)) || (ReadInJoyHelper.a(paramLong))) {
      return "0X8009CCB";
    }
    if (a(paramLong)) {
      return "0X8009356";
    }
    return "0X8009332";
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("network", GalleryReportedUtils.a(paramContext));
      localJSONObject.put("version", VideoReporter.jdField_a_of_type_JavaLangString);
      localJSONObject.put("os", "1");
      localJSONObject.put("ads_source", paramInt1);
      localJSONObject.put("card_pos ", paramInt2);
      localJSONObject.put("os", "1");
      localJSONObject.put("rowkey", paramString1);
      localJSONObject.put("feeds_type", paramInt3);
      localJSONObject.put("is_ugc_as_pgc", paramInt4);
      if (TextUtils.isEmpty(paramString2)) {
        localJSONObject.put("video_report_info", "");
      }
      for (;;)
      {
        return localJSONObject.toString();
        localJSONObject.put("video_report_info", paramString2);
      }
      return "";
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoyReportUtils", 2, "getSmallVideoPolymericR5Str:" + paramContext.toString());
      }
    }
  }
  
  public static String a(Context paramContext, long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, String paramString3)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("network", GalleryReportedUtils.a(paramContext));
      localJSONObject.put("channel_id", paramInt2);
      localJSONObject.put("version", VideoReporter.jdField_a_of_type_JavaLangString);
      localJSONObject.put("os", "1");
      localJSONObject.put("vid", paramString2);
      localJSONObject.put("rowkey", paramString1);
      localJSONObject.put("algorithm_id", paramLong2);
      localJSONObject.put("feeds_type", paramInt1);
      localJSONObject.put("star_logo", "0");
      localJSONObject.put("is_ugc_as_pgc", paramInt3);
      localJSONObject.put("r_session_id", jdField_a_of_type_JavaLangString);
      paramContext = a(paramLong1);
      if (paramContext != null)
      {
        localJSONObject.put("r_session_position", paramContext.first);
        localJSONObject.put("r_session_ispush", paramContext.second);
      }
      if (TextUtils.isEmpty(paramString3)) {
        localJSONObject.put("video_report_info", "");
      }
      for (;;)
      {
        if (DailyModeConfigHandler.c(paramInt2))
        {
          paramLong1 = ((Long)ReadInJoyHelper.a("readinjoy_daily_article_first_exposure_" + paramLong1, Long.valueOf(0L))).longValue();
          if (paramLong1 != 0L) {
            localJSONObject.put("daily_article_first_timestamp", paramLong1 + "");
          }
        }
        VideoReporter.a(localJSONObject);
        return localJSONObject.toString();
        localJSONObject.put("video_report_info", paramString3);
      }
      return "";
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoyReportUtils", 2, "getSmallVideoWrapperPolymericR5Str:" + paramContext.toString());
      }
    }
  }
  
  public static String a(ArticleInfo paramArticleInfo, String paramString, int paramInt)
  {
    String str = paramString;
    if (paramArticleInfo != null) {
      str = paramString + "&last_rowkey=" + paramArticleInfo.innerUniqueID + "&last_scene_type=" + paramInt;
    }
    return str;
  }
  
  public static String a(BaseArticleInfo paramBaseArticleInfo)
  {
    String str = "";
    if (paramBaseArticleInfo != null) {
      str = "" + paramBaseArticleInfo.innerUniqueID;
    }
    return str;
  }
  
  public static String a(TemplateBean paramTemplateBean, String paramString1, String paramString2)
  {
    if ((paramTemplateBean == null) || (paramString2 == null)) {}
    do
    {
      do
      {
        return null;
        paramTemplateBean = paramTemplateBean.getDataAttribute(paramString1);
      } while (paramTemplateBean == null);
      paramTemplateBean = paramTemplateBean.get(paramString2);
    } while (paramTemplateBean == null);
    return paramTemplateBean.toString();
  }
  
  public static Map<Long, ReadinjoyReportUtils.ExposureReportItem> a(int paramInt)
  {
    Map localMap1 = jdField_b_of_type_JavaUtilMap;
    long l = paramInt;
    try
    {
      Map localMap2 = a(l);
      jdField_b_of_type_JavaUtilMap.remove(Long.valueOf(paramInt));
      return localMap2;
    }
    finally {}
  }
  
  public static Map<Long, ReadinjoyReportUtils.ExposureReportItem> a(long paramLong)
  {
    synchronized (jdField_b_of_type_JavaUtilMap)
    {
      Map localMap1 = (Map)jdField_b_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      Object localObject1 = localMap1;
      if (localMap1 == null)
      {
        localObject1 = new HashMap();
        jdField_b_of_type_JavaUtilMap.put(Long.valueOf(paramLong), localObject1);
      }
      return localObject1;
    }
  }
  
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo, int paramInt, boolean paramBoolean, String paramString)
  {
    localJSONObject = new JSONObject();
    if (paramBaseArticleInfo != null) {}
    try
    {
      localJSONObject.put("app_type", c());
      localJSONObject.put("channel_id", paramBaseArticleInfo.mChannelID);
      localJSONObject.put("scene_type", paramInt);
      if (paramBoolean)
      {
        paramInt = 1;
        localJSONObject.put("is_intensify", paramInt);
        localJSONObject.put("feeds_type", RIJFeedsType.a(paramBaseArticleInfo));
        localJSONObject.put("rowkey", paramBaseArticleInfo.innerUniqueID);
        localJSONObject.put("puin", paramBaseArticleInfo.getSubscribeUin());
        if ((paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser == null)) {
          break label209;
        }
      }
      label209:
      for (long l = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;; l = 0L)
      {
        localJSONObject.put("ugcuin", l);
        localJSONObject.put("algorithm_id", paramBaseArticleInfo.mAlgorithmID);
        localJSONObject.put("button_type", paramBaseArticleInfo.showFollowButtonType);
        localJSONObject.put("last_rowkey", paramBaseArticleInfo.mArticleID);
        localJSONObject.put("comment_id", paramString);
        localJSONObject.put("kandian_mode_new", VideoReporter.a());
        return localJSONObject;
        paramInt = 0;
        break;
      }
      return localJSONObject;
    }
    catch (JSONException paramBaseArticleInfo)
    {
      QLog.d("ReadinjoyReportUtils", 1, paramBaseArticleInfo.getMessage());
    }
  }
  
  public static void a()
  {
    ArrayList localArrayList = new ArrayList();
    oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(1);
    localAttributeList.att_name.set("FolderStatus");
    localAttributeList.att_value.set(RIJKanDianFolderStatus.jdField_a_of_type_Int + "");
    localArrayList.add(localAttributeList);
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPushEffectEvent(10, localArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyReportUtils", 2, "reportKandianDelete  , foldStatus :  " + RIJKanDianFolderStatus.jdField_a_of_type_Int);
    }
  }
  
  public static void a(int paramInt)
  {
    i |= paramInt;
    ReadinjoySPEventReport.e(3);
  }
  
  public static void a(int paramInt1, int paramInt2, long paramLong, HashMap<String, Object> paramHashMap)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = RIJTransMergeKanDianReport.a();
    if (paramHashMap != null)
    {
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Object localObject = (Map.Entry)paramHashMap.next();
        String str = String.valueOf(((Map.Entry)localObject).getKey());
        localObject = String.valueOf(((Map.Entry)localObject).getValue());
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
          localReportR5Builder.b(str, (String)localObject);
        }
      }
    }
    paramHashMap = localReportR5Builder.a();
    QLog.d("ReadinjoyReportUtils", 1, "reportQualityDataDimension id = " + paramInt2 + " resultCode = " + paramInt1 + " cost = " + paramLong);
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyReportUtils", 2, "reportQualityDataDimension id = " + paramInt2 + " r5String = " + paramHashMap);
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800ACB9", "0X800ACB9", paramInt2, 0, String.valueOf(paramInt1), String.valueOf(paramLong), "", paramHashMap, false);
  }
  
  public static void a(int paramInt1, int paramInt2, Activity paramActivity, int paramInt3)
  {
    a(paramInt1, paramInt2, paramActivity, false, paramInt3);
  }
  
  public static void a(int paramInt1, int paramInt2, Activity paramActivity, boolean paramBoolean, int paramInt3)
  {
    QLog.d("ReadinjoyReportUtils", 2, " type : " + paramInt1);
    if (paramInt1 == 0) {}
    do
    {
      return;
      if ((!jdField_b_of_type_Boolean) && (3 == paramInt1))
      {
        a(true);
        return;
      }
    } while (paramInt2 == 40677);
    switch (paramInt1)
    {
    }
    for (paramBoolean = true;; paramBoolean = true)
    {
      a(paramInt2, paramActivity, paramBoolean, paramInt3);
      return;
    }
  }
  
  private static void a(int paramInt1, Activity paramActivity, boolean paramBoolean, int paramInt2)
  {
    ThreadManager.executeOnSubThread(new ReadinjoyReportUtils.3(paramInt1, paramActivity, paramBoolean, paramInt2));
  }
  
  public static void a(int paramInt1, ToServiceMsg paramToServiceMsg, int paramInt2, HashMap<String, Object> paramHashMap)
  {
    QLog.d("ReadinjoyReportUtils", 1, "reportQuality id = " + paramInt2);
    if (paramToServiceMsg == null)
    {
      QLog.e("ReadinjoyReportUtils", 1, "reportQuality req = null ");
      return;
    }
    long l = 0L;
    if (paramToServiceMsg.extraData != null) {
      l = System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey");
    }
    a(paramInt1, paramInt2, l, paramHashMap);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, Resources paramResources)
  {
    if ((paramInt == 1008) && (AppConstants.KANDIAN_DAILY_UIN.equals(paramString1)))
    {
      if (!Utils.a(paramString2, paramResources.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[3]))) {
        break label68;
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8009884", "0X8009884", 0, 0, "", "", "", a(), false);
    }
    label68:
    while (!Utils.a(paramString2, paramResources.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[2]))) {
      return;
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8009885", "0X8009885", 0, 0, "", "", "", a(), false);
  }
  
  public static void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((paramInt == 1008) && (AppConstants.KANDIAN_DAILY_UIN.equals(paramString)))
    {
      if (paramBoolean) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8009884", "0X8009884", 0, 0, "", "", "", a(), false);
      }
    }
    else {
      return;
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8009885", "0X8009885", 0, 0, "", "", "", a(), false);
  }
  
  public static void a(int paramInt1, boolean paramBoolean, long paramLong, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramBoolean, paramLong, paramInt2, paramInt3, true);
  }
  
  public static void a(int paramInt1, boolean paramBoolean1, long paramLong, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    a(paramInt1, paramBoolean1, paramLong, paramInt2, paramInt3, paramBoolean2, -1);
  }
  
  public static void a(int paramInt1, boolean paramBoolean1, long paramLong, int paramInt2, int paramInt3, boolean paramBoolean2, int paramInt4)
  {
    ArrayList localArrayList = new ArrayList();
    ReadinjoySPEventReport.a().jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport$UserOptInfo.a(paramBoolean1);
    Object localObject;
    oidb_cmd0x80a.AttributeList localAttributeList;
    long l;
    if (paramBoolean1)
    {
      ReadinjoySPEventReport.n();
      ReadinjoySPEventReport.ForeBackGround.a(4);
      localObject = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(1);
      ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("EnterType");
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(a(paramInt1));
      localArrayList.add(localObject);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(2);
      localAttributeList.att_name.set("FolderStatus");
      PBStringField localPBStringField = localAttributeList.att_value;
      if (paramInt1 == 0)
      {
        localObject = "1024";
        localPBStringField.set((String)localObject);
        localArrayList.add(localAttributeList);
        if (RIJKanDianFolderStatus.jdField_a_of_type_Int != 1)
        {
          localObject = new oidb_cmd0x80a.AttributeList();
          ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(3);
          ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("StrategyID");
          ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(RIJKanDianFolderStatus.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.b);
          localArrayList.add(localObject);
          localObject = new oidb_cmd0x80a.AttributeList();
          ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(4);
          ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("AlgorithmID");
          ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(RIJKanDianFolderStatus.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_JavaLangString);
          localArrayList.add(localObject);
          paramLong = NetConnInfoCenter.getServerTime();
          l = RIJKanDianFolderStatus.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_Long;
          localObject = new oidb_cmd0x80a.AttributeList();
          ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(5);
          ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("costtime");
          ((oidb_cmd0x80a.AttributeList)localObject).att_value.set("" + (paramLong - l));
          localArrayList.add(localObject);
        }
        localObject = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(6);
        ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("durationBeforeEnter");
        if (ReadinjoySPEventReport.a().d() <= 0L) {
          break label580;
        }
        paramLong = System.currentTimeMillis() - ReadinjoySPEventReport.a().d();
        label379:
        ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(paramLong + "");
        localArrayList.add(localObject);
        localAttributeList = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(7);
        ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("channelID");
        if (paramInt1 != 7) {
          break label591;
        }
        paramInt2 = RIJXTabNormalRedDotStore.a.a();
        label458:
        if (paramInt2 != -1) {
          break label1381;
        }
      }
    }
    for (;;)
    {
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(paramInt4 + "");
      localArrayList.add(localAttributeList);
      paramInt2 = 4;
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPushEffectEvent(paramInt2, localArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoyReportUtils", 2, "report kandian exit or enter ! from : " + paramInt1);
      }
      return;
      localObject = RIJKanDianFolderStatus.jdField_a_of_type_Int + "";
      break;
      label580:
      paramLong = System.currentTimeMillis() - ReadinjoySPEventReport.jdField_a_of_type_Long;
      break label379;
      label591:
      paramInt2 = paramInt4;
      break label458;
      if (paramBoolean2) {
        ReadinjoySPEventReport.ForeBackGround.a();
      }
      localObject = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(1);
      ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("ExitType");
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(a(paramInt1));
      localArrayList.add(localObject);
      localObject = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(2);
      ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("FolderStatus");
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(String.valueOf(paramInt2));
      localArrayList.add(localObject);
      localObject = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(3);
      ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("Time");
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(String.valueOf(ReadinjoySPEventReport.a(paramLong)));
      localArrayList.add(localObject);
      localObject = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(4);
      ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("OperationBitmap");
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(paramInt3 + "");
      localArrayList.add(localObject);
      if (RIJKanDianFolderStatus.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_Int != 1)
      {
        localObject = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(5);
        ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("StrategyID");
        ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(RIJKanDianFolderStatus.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.b);
        localArrayList.add(localObject);
        localObject = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(6);
        ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("AlgorithmID");
        ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(RIJKanDianFolderStatus.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_JavaLangString);
        localArrayList.add(localObject);
        paramLong = NetConnInfoCenter.getServerTime();
        l = RIJKanDianFolderStatus.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_Long;
        localObject = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(7);
        ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("costtime");
        ((oidb_cmd0x80a.AttributeList)localObject).att_value.set("" + (paramLong - l));
        localArrayList.add(localObject);
      }
      localObject = ReadinjoySPEventReport.a().b;
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(8);
      localAttributeList.att_name.set("staticDurationAfterEnter");
      if (((ReadinjoySPEventReport.UserOptInfo)localObject).jdField_a_of_type_Long > 0L)
      {
        paramLong = ((ReadinjoySPEventReport.UserOptInfo)localObject).jdField_a_of_type_Long - ((ReadinjoySPEventReport.UserOptInfo)localObject).d;
        label1075:
        localAttributeList.att_value.set(paramLong + "");
        localArrayList.add(localAttributeList);
        localAttributeList = new oidb_cmd0x80a.AttributeList();
        localAttributeList.att_id.set(9);
        localAttributeList.att_name.set("staticDurationBeforeExit");
        if (((ReadinjoySPEventReport.UserOptInfo)localObject).c <= 0L) {
          break label1376;
        }
      }
      label1376:
      for (paramLong = ((ReadinjoySPEventReport.UserOptInfo)localObject).e - ((ReadinjoySPEventReport.UserOptInfo)localObject).c;; paramLong = 0L)
      {
        localAttributeList.att_value.set(paramLong + "");
        localArrayList.add(localAttributeList);
        localAttributeList = new oidb_cmd0x80a.AttributeList();
        localAttributeList.att_id.set(10);
        localAttributeList.att_name.set("articleInfoList");
        localAttributeList.att_value.set(((ReadinjoySPEventReport.UserOptInfo)localObject).a());
        localArrayList.add(localAttributeList);
        localAttributeList = new oidb_cmd0x80a.AttributeList();
        localAttributeList.att_id.set(11);
        localAttributeList.att_name.set("scrollInfoList");
        localAttributeList.att_value.set(((ReadinjoySPEventReport.UserOptInfo)localObject).b());
        localArrayList.add(localAttributeList);
        localObject = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(12);
        ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("channelID");
        ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(paramInt4 + "");
        localArrayList.add(localObject);
        paramInt2 = 5;
        break;
        paramLong = 0L;
        break label1075;
      }
      label1381:
      paramInt4 = paramInt2;
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return;
    }
    Object localObject2 = "";
    Object localObject1;
    if ((RIJItemViewType.g(paramArticleInfo)) || (RIJItemViewType.i(paramArticleInfo)) || (RIJItemViewType.j(paramArticleInfo)) || (RIJItemViewType.k(paramArticleInfo)))
    {
      localObject1 = localObject2;
      if (paramArticleInfo.mSocialFeedInfo != null)
      {
        localObject1 = localObject2;
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo != null) {
          localObject1 = Long.toString(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long);
        }
      }
    }
    for (;;)
    {
      long l1 = paramArticleInfo.mFeedId;
      long l2 = paramArticleInfo.mArticleID;
      long l3 = paramArticleInfo.mStrategyId;
      int j = RIJItemViewType.d(paramArticleInfo);
      localObject2 = new JSONObject();
      try
      {
        RIJTransMergeKanDianReport.a((JSONObject)localObject2, paramArticleInfo);
        ((JSONObject)localObject2).put("touin", localObject1);
        ((JSONObject)localObject2).put("entry_mode", String.valueOf(j));
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009846", "0X8009846", 0, 0, String.valueOf(l1), String.valueOf(l2), String.valueOf(l3), ((JSONObject)localObject2).toString(), false);
        return;
        localObject1 = paramArticleInfo.mSubscribeID;
      }
      catch (Exception paramArticleInfo)
      {
        for (;;)
        {
          paramArticleInfo.printStackTrace();
        }
      }
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt, String paramString)
  {
    a(paramArticleInfo, paramInt, false, paramString);
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt, boolean paramBoolean, String paramString)
  {
    if (paramArticleInfo != null) {
      paramString = a(paramArticleInfo, paramInt, paramBoolean, paramString);
    }
    try
    {
      if (OnSocialHeaderFollowClickListener.a(paramArticleInfo)) {}
      for (paramInt = 2;; paramInt = 1)
      {
        paramString.put("click_type", paramInt);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800B1A7", "0X800B1A7", 0, 0, "", "", "", paramString.toString(), false);
        return;
      }
      return;
    }
    catch (JSONException paramArticleInfo)
    {
      QLog.d("ReadinjoyReportUtils", 1, paramArticleInfo.getMessage());
    }
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, int paramInt, boolean paramBoolean, String paramString)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.bindShowFollowButton)) {
      b(paramBaseArticleInfo, paramInt, paramBoolean, paramString);
    }
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, long paramLong)
  {
    if (((Long)ReadInJoyHelper.a("readinjoy_daily_article_first_exposure_" + paramBaseArticleInfo.mArticleID, Long.valueOf(0L))).longValue() == 0L) {
      ReadInJoyHelper.a("readinjoy_daily_article_first_exposure_" + paramBaseArticleInfo.mArticleID, Long.valueOf(System.currentTimeMillis() / 1000L));
    }
    synchronized (jdField_b_of_type_JavaUtilMap)
    {
      Map localMap2 = a(paramBaseArticleInfo.mChannelID);
      ReadinjoyReportUtils.ExposureReportItem localExposureReportItem = (ReadinjoyReportUtils.ExposureReportItem)localMap2.get(Long.valueOf(paramBaseArticleInfo.mArticleID));
      if (localExposureReportItem != null)
      {
        long l = paramLong;
        if (localExposureReportItem.jdField_a_of_type_Long > paramLong) {
          l = localExposureReportItem.jdField_a_of_type_Long;
        }
        localExposureReportItem.jdField_a_of_type_Long = l;
        return;
      }
      localExposureReportItem = new ReadinjoyReportUtils.ExposureReportItem(RIJTransMergeKanDianReport.a());
      localExposureReportItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
      localExposureReportItem.jdField_a_of_type_Long = paramLong;
      localMap2.put(Long.valueOf(paramBaseArticleInfo.mArticleID), localExposureReportItem);
    }
  }
  
  public static void a(TemplateBean paramTemplateBean, String paramString1, String paramString2)
  {
    if ((paramTemplateBean == null) || (paramString2 == null)) {}
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder;
    do
    {
      return;
      localReportR5Builder = a(paramTemplateBean, paramString1);
      paramTemplateBean = a(paramTemplateBean, paramString1, paramString2);
    } while (paramTemplateBean == null);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", paramTemplateBean, paramTemplateBean, 0, 0, "", "", "", localReportR5Builder.a(), false);
  }
  
  public static void a(RecentItemChatMsgData paramRecentItemChatMsgData)
  {
    if (!jdField_a_of_type_Boolean) {}
    while ((paramRecentItemChatMsgData == null) || (paramRecentItemChatMsgData.mUser == null) || (!AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(paramRecentItemChatMsgData.mUser.uin))) {
      return;
    }
    jdField_a_of_type_Boolean = false;
    ThreadManager.executeOnSubThread(new ReadinjoyReportUtils.4(paramRecentItemChatMsgData));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = (KandianMergeManager)paramQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
    localReportR5Builder.b();
    localReportR5Builder.e();
    Object localObject = paramQQAppInterface.a();
    paramQQAppInterface = "";
    int j;
    if (localObject != null)
    {
      j = ((KandianMsgBoxRedPntInfo)localObject).mMsgCnt;
      paramQQAppInterface = ((KandianMsgBoxRedPntInfo)localObject).mUin + "";
    }
    for (;;)
    {
      if (j > 0) {}
      try
      {
        localReportR5Builder.l(j);
        localReportR5Builder.b("message_reddot_style", RIJMsgBoxUtils.b());
        if (paramBoolean)
        {
          localObject = "0X8009A85";
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, paramQQAppInterface, (String)localObject, (String)localObject, 0, 0, "", "", "", localReportR5Builder.a(), false);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("ReadinjoyReportUtils", 2, localJSONException, new Object[0]);
          continue;
          String str = "0X8009A84";
        }
      }
      j = 0;
    }
  }
  
  public static void a(String paramString)
  {
    if (AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(paramString))
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800978D", "0X800978D", 0, 0, "", "", "", a(), false);
      ReadinjoySPEventReport.l();
    }
    while (!AppConstants.KANDIAN_DAILY_UIN.equals(paramString)) {
      return;
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8009886", "0X8009886", 0, 0, "", "", "", a(), false);
    ReadinjoySPEventReport.m();
  }
  
  public static void a(String paramString, boolean paramBoolean, long paramLong)
  {
    int j = 1;
    oidb_cmd0x80a.AttributeList localAttributeList1 = new oidb_cmd0x80a.AttributeList();
    localAttributeList1.att_id.set(1);
    localAttributeList1.att_name.set("BusiType");
    localAttributeList1.att_value.set(paramString);
    oidb_cmd0x80a.AttributeList localAttributeList2 = new oidb_cmd0x80a.AttributeList();
    localAttributeList2.att_id.set(2);
    localAttributeList2.att_name.set("HasRedPnt");
    Object localObject = localAttributeList2.att_value;
    if (paramBoolean) {}
    for (;;)
    {
      ((PBStringField)localObject).set(String.valueOf(j));
      localObject = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(3);
      ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("Time");
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(String.valueOf(ReadinjoySPEventReport.a(paramLong)));
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localAttributeList1);
      localArrayList.add(localAttributeList2);
      localArrayList.add(localObject);
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPushEffectEvent(2, localArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoyReportUtils", 2, "report dt entry ! busiName : " + paramString + " , redDot : " + paramBoolean);
      }
      return;
      j = 0;
    }
  }
  
  public static void a(List<ArticleInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    ArrayList localArrayList;
    do
    {
      return;
      if (Aladdin.getConfig(183).getIntegerFromString("allow_report", 0) == 0)
      {
        QLog.d("ReadinjoyReportUtils", 1, "reportRefreshArticleInfoFor64e config not allow!");
        return;
      }
      Collections.sort(paramList, new ReadinjoyReportUtils.5());
      localArrayList = new ArrayList();
      int j = 0;
      while (j < paramList.size())
      {
        ArticleInfo localArticleInfo = (ArticleInfo)paramList.get(j);
        ReportInfo localReportInfo = new ReportInfo();
        localReportInfo.mAlgorithmId = ((int)localArticleInfo.mAlgorithmID);
        localReportInfo.mStrategyId = localArticleInfo.mStrategyId;
        localReportInfo.mSourceArticleId = localArticleInfo.mArticleID;
        localReportInfo.mInnerId = localArticleInfo.innerUniqueID;
        localReportInfo.mServerContext = localArticleInfo.mServerContext;
        localReportInfo.mUin = ReadInJoyUtils.a();
        localReportInfo.mChannelId = 0;
        localReportInfo.replyUin = j;
        localReportInfo.replyID = (NetConnInfoCenter.getServerTime() + "");
        localReportInfo.mSource = 3;
        localReportInfo.mOperation = 57;
        localArrayList.add(localReportInfo);
        j += 1;
      }
    } while (localArrayList.size() <= 0);
    ReadInJoyLogicEngine.a().a(localArrayList);
  }
  
  public static void a(List<ArticleInfo> paramList, List<Long> paramList1, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList1 == null)) {
      return;
    }
    Collections.sort(paramList, new ReadinjoyReportUtils.2());
    paramList = paramList.iterator();
    label27:
    Map localMap;
    long l2;
    long l3;
    while (paramList.hasNext())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)paramList.next();
      if (paramList1.contains(Long.valueOf(localArticleInfo.mRecommendSeq)))
      {
        localMap = jdField_a_of_type_JavaUtilMap;
        l2 = localArticleInfo.mArticleID;
        l3 = jdField_a_of_type_Long;
        jdField_a_of_type_Long = l3 + 1L;
        if (!paramBoolean) {
          break label126;
        }
      }
    }
    label126:
    for (long l1 = 1L;; l1 = 0L)
    {
      localMap.put(Long.valueOf(l2), new Pair(Long.valueOf(l3), Long.valueOf(l1)));
      break label27;
      break;
    }
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    long l1 = 0L;
    jdField_a_of_type_Long = 0L;
    jdField_a_of_type_JavaUtilMap.clear();
    if (paramAppRuntime == null) {}
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      jdField_a_of_type_JavaLangString = String.valueOf(l1) + "_" + String.valueOf(l2);
      AdSessionManager.a().b();
      return;
      l1 = paramAppRuntime.getLongAccountUin();
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public static boolean a(long paramLong)
  {
    return (paramLong == 70L) || (paramLong == 41403L);
  }
  
  public static int b()
  {
    return i;
  }
  
  public static String b(long paramLong)
  {
    if ((DailyModeConfigHandler.a((int)paramLong)) || (ReadInJoyHelper.a(paramLong))) {
      return "0X8009CC9";
    }
    if (a(paramLong)) {
      return "0X8009355";
    }
    return "0X8007625";
  }
  
  public static void b()
  {
    i = 0;
  }
  
  public static void b(@NotNull BaseArticleInfo paramBaseArticleInfo, int paramInt, boolean paramBoolean, String paramString)
  {
    paramBaseArticleInfo = a(paramBaseArticleInfo, paramInt, paramBoolean, paramString);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800B1A6", "0X800B1A6", 0, 0, "", "", "", paramBaseArticleInfo.toString(), false);
  }
  
  public static int c()
  {
    if (RIJXTabFrameUtils.a.a()) {
      return jdField_a_of_type_Int;
    }
    if (ReadInJoyDailyFragment.a()) {
      return jdField_b_of_type_Int;
    }
    return c;
  }
  
  public static void c()
  {
    h = 1;
  }
  
  public static void d()
  {
    h = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadinjoyReportUtils
 * JD-Core Version:    0.7.0.1
 */