package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.KandianDailyReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDianDianEntranceModule;
import com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.RIJColumnDataSource;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class RecommendFeedsDiandianEntranceManager
{
  private static int jdField_a_of_type_Int = 1;
  private static RecommendFeedsDiandianEntranceManager.EntranceIconInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo = null;
  private static RecommendFeedsDiandianEntranceManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager;
  private static int b;
  private long jdField_a_of_type_Long = 0L;
  private List<RecommendFeedsDiandianEntranceManager.OnEntryIconRefreshListener> jdField_a_of_type_JavaUtilList = null;
  private int c = -1;
  
  static
  {
    jdField_b_of_type_Int = ReadInJoyHelper.f();
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager = null;
  }
  
  private RecommendFeedsDiandianEntranceManager()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(216);
    if (localAladdinConfig != null) {
      jdField_a_of_type_Int = (int)(localAladdinConfig.getFloatFromString("diandian_icon_refresh_time_interval", 1.0F) * 60.0F * 1000.0F);
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    a("init");
    QLog.d("RecommendFeedsDiandianEntranceManager", 1, "entrance manager init sRefreshInterval : " + jdField_a_of_type_Int + "; feedsType : " + jdField_b_of_type_Int + " ; curIconInfo : " + jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo);
  }
  
  public static RecommendFeedsDiandianEntranceManager a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager = new RecommendFeedsDiandianEntranceManager();
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager;
    }
    finally {}
  }
  
  public static String a()
  {
    return (String)ReadInJoyHelper.a("KEY_ENTRANCE_SCHEMA", "");
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    default: 
      if (b())
      {
        String str = a();
        QLog.d("RecommendFeedsDiandianEntranceManager", 1, "hasEntranceStorageSchema: " + str);
        return str;
      }
      break;
    case 4: 
      return "https://buluo.qq.com/mobile/v2/buluoindex.html?_wv=16778243&_bid=128&_wwv=1&_wvSb=0&_nav_txtclr=00000&from=kdybrk&target=hot&_nav_titleclr=000000&_wvNlb=0xffffff";
    case 6: 
      return ReadInJoyHelper.b();
    }
    return "mqqapi://readinjoy/open?src_type=internal&ispush=1&target=2&readinjoyNotDecodeUrl=1&version=1&channelid=70&channelname=看点关注&channelType=0&changeChannelOrder=true&moveChannelFromSource=0";
  }
  
  private String a(RIJColumnDataSource paramRIJColumnDataSource, int paramInt1, int paramInt2, int paramInt3)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("trigger_src", paramInt2);
      localJSONObject.put("click_area", paramInt1);
      localJSONObject.put("channel_id", paramInt3);
      if (paramRIJColumnDataSource != null)
      {
        localJSONObject.put("column_id", paramRIJColumnDataSource.jdField_a_of_type_Int);
        localJSONObject.put("rowkey", paramRIJColumnDataSource.d);
        localJSONObject.put("video_report_info", paramRIJColumnDataSource.e);
      }
      localJSONObject.put("diandianfeeds_type", 6);
    }
    catch (Exception paramRIJColumnDataSource)
    {
      for (;;)
      {
        QLog.d("RecommendFeedsDiandianEntranceManager", 1, "getColumnDiandianR5 error! e=" + paramRIJColumnDataSource);
      }
    }
    return localJSONObject.toString();
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 4);
  }
  
  private RecommendFeedsDiandianEntranceManager.EntranceIconInfo b()
  {
    Object localObject = ReadInJoyHelper.a(RIJQQAppInterfaceUtil.a().getCurrentUin());
    if (localObject != null) {
      try
      {
        localObject = ((SharedPreferences)localObject).getString("DianDianEntryIconInfo", "");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return null;
        }
        localObject = new JSONObject((String)localObject);
        if (!a(((JSONObject)localObject).optInt("feeds_type", 3))) {
          break label187;
        }
        RecommendFeedsDiandianEntranceManager.EntranceIconInfo localEntranceIconInfo = new RecommendFeedsDiandianEntranceManager.EntranceIconInfo();
        localEntranceIconInfo.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("icon_url", "");
        localEntranceIconInfo.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("feeds_type", 3);
        localEntranceIconInfo.c = ((JSONObject)localObject).optString("jump_schema", "");
        localEntranceIconInfo.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("small_icon_url", "");
        localEntranceIconInfo.jdField_a_of_type_Boolean = ((JSONObject)localObject).optBoolean("use_gif", false);
        RecommendFeedsDiandianEntranceManager.ExtraInfo localExtraInfo = new RecommendFeedsDiandianEntranceManager.ExtraInfo();
        localExtraInfo.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("report_str", "");
        localEntranceIconInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$ExtraInfo = localExtraInfo;
        QLog.d("RecommendFeedsDiandianEntranceManager", 1, "getIconInfoFromSp entryInfo " + localEntranceIconInfo);
        return localEntranceIconInfo;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    } else {
      QLog.d("RecommendFeedsDiandianEntranceManager", 1, "getIconInfoFromSp entryInfo is null");
    }
    label187:
    return null;
  }
  
  private static boolean b()
  {
    return !TextUtils.isEmpty(a());
  }
  
  public static boolean b(int paramInt)
  {
    return paramInt == 6;
  }
  
  public static int c()
  {
    switch ()
    {
    case 3: 
    default: 
      return 2130849772;
    case 4: 
      return 2130849806;
    }
    return 2130843316;
  }
  
  private void d()
  {
    if ((jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo == null) || (!a(jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.jdField_a_of_type_Int))) {}
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      localSharedPreferences = ReadInJoyHelper.a(RIJQQAppInterfaceUtil.a().getCurrentUin());
    } while (localSharedPreferences == null);
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("feeds_type", jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.jdField_a_of_type_Int);
        localJSONObject.put("icon_url", jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.jdField_a_of_type_JavaLangString);
        localJSONObject.put("small_icon_url", jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.jdField_b_of_type_JavaLangString);
        localJSONObject.put("jump_schema", jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.c);
        if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$ExtraInfo != null)
        {
          String str1 = jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$ExtraInfo.jdField_a_of_type_JavaLangString;
          localJSONObject.put("report_str", str1);
          localJSONObject.put("use_gif", jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.jdField_a_of_type_Boolean);
          QLog.d("RecommendFeedsDiandianEntranceManager", 1, "saveIconInfo2Sp | jsonStr : " + localJSONObject.toString());
          localSharedPreferences.edit().putString("DianDianEntryIconInfo", localJSONObject.toString()).apply();
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      String str2 = "";
    }
  }
  
  public int a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo == null) {
      return -1;
    }
    return jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.jdField_b_of_type_Int;
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      int i = jdField_b_of_type_Int;
      String str = String.valueOf(paramInt2);
      paramInt2 = i;
      if (paramInt1 == 1)
      {
        paramInt2 = i;
        if (this.c == 3) {
          paramInt2 = 6;
        }
        str = KandianDailyReportUtils.b();
      }
      localJSONObject.put("diandianfeeds_type", paramInt2);
      localJSONObject.put("trigger_src", paramInt1);
      localJSONObject.put("channel_id", str);
      if (paramInt2 == 3) {
        localJSONObject.put("jump_to", a().a());
      }
      str = localJSONObject.toString();
      return str;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public void a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo != null) {
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo = null;
    }
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80094FE", "0X80094FE", 0, 0, "", "", "", a(paramInt1, paramInt2), false);
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo == null) {
      return;
    }
    QLog.d("RecommendFeedsDiandianEntranceManager", 1, "handleEntranceIconClick | entranceInfo " + jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo + ", feedsType : " + paramInt1);
    if (TextUtils.isEmpty(jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.c)) {
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.c = a(paramInt1);
    }
    ReadInJoyUtils.a(paramContext, jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.c);
  }
  
  public void a(RecommendFeedsDiandianEntranceManager.EntranceIconInfo paramEntranceIconInfo)
  {
    QLog.d("RecommendFeedsDiandianEntranceManager", 1, "handleDianDianIconRefresh | updateIconInfo : " + paramEntranceIconInfo);
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo = paramEntranceIconInfo;
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo != null)
    {
      jdField_b_of_type_Int = jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.jdField_a_of_type_Int;
      QLog.d("RecommendFeedsDiandianEntranceManager", 1, "handleDianDianIconRefresh | sFeedsType update : " + jdField_b_of_type_Int);
    }
    d();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      paramEntranceIconInfo = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramEntranceIconInfo.hasNext())
      {
        RecommendFeedsDiandianEntranceManager.OnEntryIconRefreshListener localOnEntryIconRefreshListener = (RecommendFeedsDiandianEntranceManager.OnEntryIconRefreshListener)paramEntranceIconInfo.next();
        ThreadManager.getUIHandler().post(new RecommendFeedsDiandianEntranceManager.1(this, localOnEntryIconRefreshListener));
      }
    }
  }
  
  public void a(RecommendFeedsDiandianEntranceManager.OnEntryIconRefreshListener paramOnEntryIconRefreshListener)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramOnEntryIconRefreshListener != null) && (!this.jdField_a_of_type_JavaUtilList.contains(paramOnEntryIconRefreshListener))) {
      this.jdField_a_of_type_JavaUtilList.add(paramOnEntryIconRefreshListener);
    }
  }
  
  public void a(RIJColumnDataSource paramRIJColumnDataSource, int paramInt1, int paramInt2, int paramInt3)
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80094FF", "0X80094FF", 0, 0, "", "", "", a(paramRIJColumnDataSource, paramInt1, paramInt2, paramInt3), false);
  }
  
  public void a(String paramString)
  {
    int i = ReadInJoyHelper.f();
    QLog.d("RecommendFeedsDiandianEntranceManager", 1, "checkAndUpdateIconInfo | reason " + paramString + "; configFeedsType : " + i);
    paramString = b();
    if (paramString != null)
    {
      QLog.d("RecommendFeedsDiandianEntranceManager", 1, "checkAndUpdateIconInfo | spIconInfo : " + paramString);
      if (paramString.jdField_a_of_type_Int != i)
      {
        QLog.d("RecommendFeedsDiandianEntranceManager", 1, "checkAndUpdateIconInfo | spIconInfo updated");
        if (a(i))
        {
          jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo = RecommendFeedsDiandianEntranceManager.EntranceIconInfo.a(i);
          d();
        }
      }
    }
    for (;;)
    {
      jdField_b_of_type_Int = i;
      return;
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo = paramString;
      continue;
      if (!a(i))
      {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo = null;
      }
      else
      {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo = RecommendFeedsDiandianEntranceManager.EntranceIconInfo.a(i);
        QLog.d("RecommendFeedsDiandianEntranceManager", 1, "checkAndUpdateIconInfo | buildIconInfo with configFeedsType : " + i + " ; curIconInfo : " + jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo);
      }
    }
  }
  
  public boolean a()
  {
    int i = ReadInJoyHelper.f();
    return (i == 1) || (i == 2);
  }
  
  public int b()
  {
    return jdField_b_of_type_Int;
  }
  
  public void b()
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    QLog.d("RecommendFeedsDiandianEntranceManager", 1, new Object[] { "checkAndReqRefreshDianDianIcon | request refresh icon info ,timeinterval : " + l, " RefreshInterval: " + jdField_a_of_type_Int, " LastExitTime: " + this.jdField_a_of_type_Long });
    if (l < jdField_a_of_type_Int) {}
    while ((!a(jdField_b_of_type_Int)) || (ReadInJoyLogicEngine.a().a() == null)) {
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ReadInJoyLogicEngine.a().a().b(jdField_b_of_type_Int);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80094FF", "0X80094FF", 0, 0, "", "", "", a(paramInt1, paramInt2), false);
  }
  
  public void b(RecommendFeedsDiandianEntranceManager.OnEntryIconRefreshListener paramOnEntryIconRefreshListener)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramOnEntryIconRefreshListener != null)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramOnEntryIconRefreshListener);
    }
  }
  
  public void c()
  {
    QLog.d("RecommendFeedsDiandianEntranceManager", 1, "onAccountChange");
    a("onAccountChange");
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!a()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        RecommendFeedsDiandianEntranceManager.OnEntryIconRefreshListener localOnEntryIconRefreshListener = (RecommendFeedsDiandianEntranceManager.OnEntryIconRefreshListener)localIterator.next();
        ThreadManager.getUIHandler().post(new RecommendFeedsDiandianEntranceManager.3(this, localOnEntryIconRefreshListener));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager
 * JD-Core Version:    0.7.0.1
 */