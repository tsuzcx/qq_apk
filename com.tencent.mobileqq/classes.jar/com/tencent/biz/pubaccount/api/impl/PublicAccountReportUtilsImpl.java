package com.tencent.biz.pubaccount.api.impl;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJStudyModeUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.util.RIJBlackWhiteModeHelper;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class PublicAccountReportUtilsImpl
  implements IPublicAccountReportUtils
{
  public static final String TAG = "PublicAccountReportUtils";
  
  private static void addCommonInfo(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("version_standard", "8.5.5");
      paramJSONObject.put("version_detail", AppSetting.a(BaseApplicationImpl.getContext()));
      paramJSONObject.put("os_standard", "1");
      paramJSONObject.put("kandian_mode_new", VideoReporter.a());
      paramJSONObject.put("user_mode", RIJStudyModeUtils.a());
      if (RIJBlackWhiteModeHelper.a.a()) {}
      for (int i = 1;; i = 0)
      {
        paramJSONObject.put("is_black_white_mode", i);
        return;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("PublicAccountReportUtils", 1, "addCommonInfo error! msg=" + paramJSONObject);
    }
  }
  
  private static void addDebugInfo(JSONObject paramJSONObject) {}
  
  protected static String addExtraInfo(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      addCommonInfo((JSONObject)localObject);
      addWifiInfo((JSONObject)localObject);
      addDebugInfo((JSONObject)localObject);
      addKingCard((JSONObject)localObject);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      QLog.e("PublicAccountReportUtils", 1, "addExtraInfo error! msg=" + localException);
    }
    return paramString;
  }
  
  private static void addKingCard(JSONObject paramJSONObject)
  {
    try
    {
      if (CUKingCardHelper.a() == 1) {}
      for (String str = "1";; str = "0")
      {
        paramJSONObject.put("is_kind_card", str);
        return;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("PublicAccountReportUtils", 1, "addKingCard error! msg=" + paramJSONObject);
    }
  }
  
  private static void addMonitorForReport(String paramString1, String paramString2)
  {
    if ("0X8007625".equals(paramString1)) {
      ThreadManager.executeOnSubThread(new PublicAccountReportUtilsImpl.2(paramString2));
    }
  }
  
  private static void addWifiInfo(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("wifi_ssid", NetworkUtils.c(BaseApplicationImpl.getContext()));
      paramJSONObject.put("wifi_mac", MobileInfoUtil.a());
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("PublicAccountReportUtils", 1, "addWifiInfo error! msg=" + paramJSONObject);
    }
  }
  
  public static int getReportAccountType(AppInterface paramAppInterface, String paramString, AccountDetail paramAccountDetail)
  {
    int k = 1;
    if ((paramAppInterface == null) && (paramAccountDetail == null)) {}
    Object localObject;
    do
    {
      return 1;
      localObject = paramAccountDetail;
      if (paramAccountDetail == null)
      {
        paramAppInterface = (PublicAccountDataManager)paramAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
        localObject = paramAccountDetail;
        if (paramAppInterface != null)
        {
          paramAppInterface = paramAppInterface.a(paramString);
          localObject = paramAppInterface;
          if (QLog.isColorLevel())
          {
            QLog.d("PublicAccountReportUtils", 2, "getReportAccountType--> input accountdetail null");
            localObject = paramAppInterface;
          }
        }
      }
    } while (localObject == null);
    int j;
    int i;
    if (((AccountDetail)localObject).accountFlag < 0)
    {
      j = -9;
      i = k;
      switch (j)
      {
      default: 
        i = k;
      }
    }
    for (;;)
    {
      return i;
      j = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(((AccountDetail)localObject).accountFlag);
      break;
      i = 3;
      continue;
      i = 4;
      if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType2(((AccountDetail)localObject).accountFlag2) == -8L)
      {
        i = 8;
        continue;
        i = 5;
        continue;
        i = 6;
        continue;
        i = 7;
        continue;
        i = 9;
      }
    }
  }
  
  private static String reportClickInfoString(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    if ((paramString1 != null) && (paramString1.length() > 0)) {
      localStringBuilder.append(paramString1).append('|');
    }
    localStringBuilder.append(paramString2).append('|');
    localStringBuilder.append(paramString3).append('|');
    localStringBuilder.append(paramString4).append('|');
    localStringBuilder.append(paramString5).append('|');
    localStringBuilder.append(paramString6).append('|');
    return localStringBuilder.toString();
  }
  
  public String changeToUTF8(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      try
      {
        String str = URLEncoder.encode(paramString, "UTF-8");
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        return paramString;
      }
    }
  }
  
  public void doVideoDataReportWithFansInfoInR5(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean)
  {
    ThreadManager.post(new PublicAccountReportUtilsImpl.1(this, paramString7, paramString1, paramAppInterface, paramString2, paramString3, paramInt1, paramInt2, paramString4, paramString5, paramString6, paramBoolean), 5, null, true);
  }
  
  public void publicAccountReportClickEvent(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    addMonitorForReport(paramString3, paramString7);
    paramString7 = addExtraInfo(paramString7);
    paramString4 = changeToUTF8(paramString4);
    paramString5 = changeToUTF8(paramString5);
    paramString6 = changeToUTF8(paramString6);
    paramString7 = changeToUTF8(paramString7);
    ReportController.b(paramAppInterface, "dc01160", "Pb_account_lifeservice", paramString1, paramString2.toUpperCase(), paramString3.toUpperCase(), paramInt1, paramInt2, paramString4, paramString5, paramString6, paramString7);
  }
  
  public void publicAccountReportClickEvent(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean)
  {
    addMonitorForReport(paramString3, paramString7);
    paramString7 = addExtraInfo(paramString7);
    if (paramBoolean)
    {
      publicAccountReportClickEvent(paramAppInterface, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramString4, paramString5, paramString6, paramString7);
      return;
    }
    ReportController.b(paramAppInterface, "dc01160", "Pb_account_lifeservice", paramString1, paramString2.toUpperCase(), paramString3.toUpperCase(), paramInt1, paramInt2, paramString4, paramString5, paramString6, paramString7);
  }
  
  public void publicAccountReportClickEventForMigrate(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    addMonitorForReport(paramString5, paramString9);
    paramString9 = addExtraInfo(paramString9);
    paramString6 = changeToUTF8(paramString6);
    paramString7 = changeToUTF8(paramString7);
    paramString8 = changeToUTF8(paramString8);
    paramString9 = changeToUTF8(paramString9);
    ReportController.b(paramAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
    ReportController.b(paramAppInterface, "dc01160", "Pb_account_lifeservice", paramString3, paramString4.toUpperCase(), paramString5.toUpperCase(), paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public void publicAccountReportClickEventForMigrate(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9, boolean paramBoolean)
  {
    addMonitorForReport(paramString5, paramString9);
    paramString9 = addExtraInfo(paramString9);
    if (paramBoolean)
    {
      publicAccountReportClickEventForMigrate(paramAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
      return;
    }
    ReportController.b(paramAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
    ReportController.b(paramAppInterface, "dc01160", "Pb_account_lifeservice", paramString3, paramString4.toUpperCase(), paramString5.toUpperCase(), paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public void publicAccountSimpleReportWithR5(String paramString1, int paramInt, String paramString2)
  {
    QQAppInterface localQQAppInterface = null;
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    publicAccountReportClickEvent(localQQAppInterface, "", paramString1, paramString1, paramInt, 0, "", "", "", paramString2, false);
  }
  
  public void publicAccountSimpleReportWithR5(String paramString1, String paramString2)
  {
    publicAccountSimpleReportWithR5(paramString1, 0, paramString2);
  }
  
  public void reportFollowEvent(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    int i = getReportAccountType(paramAppInterface, String.valueOf(paramString), null);
    if ((i != 2) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(paramAppInterface, paramString) != -7)) {
      publicAccountReportClickEvent(null, paramString, "0X800827B", "0X800827B", 0, 0, "" + paramInt, "" + i, "", "", false);
    }
  }
  
  public void reportLabelsClick(ArticleInfo paramArticleInfo)
  {
    Object localObject1 = "";
    try
    {
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("folder_status", RIJKanDianFolderStatus.a);
      ((JSONObject)localObject2).put("feeds_source", RIJFeedsType.b(paramArticleInfo));
      ((JSONObject)localObject2).put("rowkey", paramArticleInfo.innerUniqueID);
      ((JSONObject)localObject2).put("feeds_type", "" + RIJFeedsType.a(paramArticleInfo));
      ((JSONObject)localObject2).put("kandian_mode", "" + RIJAppSetting.a());
      ((JSONObject)localObject2).put("tab_source", "" + RIJTransMergeKanDianReport.a());
      ((JSONObject)localObject2).put("topic_id", "" + paramArticleInfo.businessId);
      ((JSONObject)localObject2).put("algorithm_id", "" + paramArticleInfo.mAlgorithmID);
      ((JSONObject)localObject2).put("mark_type", "" + RIJFeedsType.a(paramArticleInfo));
      ((JSONObject)localObject2).put("channel_id", paramArticleInfo.mChannelID);
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject2;
        String str2;
        localJSONException.printStackTrace();
        continue;
        String str1 = paramArticleInfo.mArticleID + "";
      }
    }
    if ((RIJItemViewType.g(paramArticleInfo)) || (RIJItemViewType.i(paramArticleInfo)) || (RIJItemViewType.j(paramArticleInfo)) || (RIJItemViewType.k(paramArticleInfo)))
    {
      localObject2 = "0";
      str2 = "0X8008201";
      if (ReadinjoyReportUtils.a(paramArticleInfo.mChannelID)) {
        str2 = "0X8009362";
      }
      publicAccountReportClickEvent(null, RIJFeedsType.b(paramArticleInfo), str2, str2, 0, 0, String.valueOf(paramArticleInfo.mFeedId), (String)localObject2, "" + paramArticleInfo.mStrategyId, (String)localObject1, false);
      return;
    }
  }
  
  public void reportPAinfoToLighthouse(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    paramString1 = "kandian_" + paramString1;
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    HashMap localHashMap = new HashMap();
    localHashMap.put("department", "publicaccount");
    localHashMap.put("fromuin", str);
    localHashMap.put("touin", paramString2);
    localHashMap.put("d1", paramString3);
    localHashMap.put("d2", paramString4);
    localHashMap.put("d3", paramString5);
    localHashMap.put("d4", paramString6);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, paramString1, true, 0L, 0L, localHashMap, "");
    if (QLog.isColorLevel()) {
      QLog.d("reportPAinfoToLighthouse", 2, new Object[] { "reportPAinfoToLighthouse-->", "kandianT" + paramString1 + ", fromuin:" + str + ", touin:" + paramString2 + ", d1:" + paramString3 + ", d2:" + paramString4 + ", d3:" + paramString5 + ", d4:" + paramString6 });
    }
  }
  
  public void reportPubAccMsg(List<MessageRecord> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    for (;;)
    {
      return;
      long l = System.currentTimeMillis() / 1000L;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if (localMessageRecord.istroop == 1008) {
          if ((!TextUtils.isEmpty(localMessageRecord.getExtInfoFromExtStr("public_account_send_flag"))) && (!TextUtils.isEmpty(localMessageRecord.getExtInfoFromExtStr("public_account_msg_id"))) && (!TextUtils.equals(localMessageRecord.frienduin, localMessageRecord.selfuin))) {
            ThreadManager.post(new PublicAccountReportUtilsImpl.3(this, localMessageRecord.frienduin, localMessageRecord.selfuin, localMessageRecord.getExtInfoFromExtStr("public_account_msg_id"), localMessageRecord.time, l, localMessageRecord.getExtInfoFromExtStr("public_account_send_flag")), 5, null, false);
          } else if (QLog.isColorLevel()) {
            QLog.d("PublicAccountReportUtils", 2, "reportPubAccMsg exception, public_account_send_flag null || public_account_msg_id null || ");
          }
        }
      }
    }
  }
  
  public void videoDataReportWithFansInfoInR5(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean)
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      doVideoDataReportWithFansInfoInR5(paramAppInterface, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramString4, paramString5, paramString6, paramString7, paramBoolean);
      return;
    }
    paramAppInterface = new Intent("READINJOY_VIDEO_DATA_REPORT_WITH_FANS_INFO");
    paramAppInterface.putExtra("VIDEO_REPORT_TOUIN", paramString1);
    paramAppInterface.putExtra("VIDEO_REPORT_SUBACTION", paramString2);
    paramAppInterface.putExtra("VIDEO_REPORT_ACTION_NAME", paramString3);
    paramAppInterface.putExtra("VIDEO_REPORT_FROM_TYPE", paramInt1);
    paramAppInterface.putExtra("VIDEO_REPORT_RESULT", paramInt2);
    paramAppInterface.putExtra("VIDEO_REPORT_R2", paramString4);
    paramAppInterface.putExtra("VIDEO_REPORT_R3", paramString5);
    paramAppInterface.putExtra("VIDEO_REPORT_R4", paramString6);
    paramAppInterface.putExtra("VIDEO_REPORT_R5", paramString7);
    paramAppInterface.putExtra("VIDEO_REPORT_SHOULD_ENCODE", paramBoolean);
    BaseApplicationImpl.getApplication().sendBroadcast(paramAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountReportUtilsImpl
 * JD-Core Version:    0.7.0.1
 */