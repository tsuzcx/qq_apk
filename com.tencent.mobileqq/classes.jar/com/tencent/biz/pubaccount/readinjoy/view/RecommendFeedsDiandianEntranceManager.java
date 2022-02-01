package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import bkwm;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import odq;
import org.json.JSONException;
import org.json.JSONObject;
import ozh;
import pay;
import pkm;
import pvx;
import sqm;
import tfc;

public class RecommendFeedsDiandianEntranceManager
{
  private static int jdField_a_of_type_Int = 1;
  private static RecommendFeedsDiandianEntranceManager.EntranceIconInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo;
  private static RecommendFeedsDiandianEntranceManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager;
  private static int b = bkwm.f();
  private long jdField_a_of_type_Long;
  private List<sqm> jdField_a_of_type_JavaUtilList;
  private int c = -1;
  
  private RecommendFeedsDiandianEntranceManager()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(216);
    if (localAladdinConfig != null) {
      jdField_a_of_type_Int = (int)(localAladdinConfig.getFloatFromString("diandian_icon_refresh_time_interval", 1.0F) * 60.0F * 1000.0F);
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    a("init");
    QLog.d("RecommendFeedsDiandianEntranceManager", 1, "entrance manager init sRefreshInterval : " + jdField_a_of_type_Int + "; feedsType : " + b + " ; curIconInfo : " + jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo);
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
  
  private static String a()
  {
    return (String)bkwm.a("KEY_ENTRANCE_SCHEMA", "");
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
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
    }
    return "mqqapi://readinjoy/open?src_type=internal&ispush=1&target=2&readinjoyNotDecodeUrl=1&version=1&channelid=70&channelname=看点关注&channelType=0&changeChannelOrder=true&moveChannelFromSource=0";
  }
  
  private String a(tfc paramtfc, int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("trigger_src", paramInt2);
      localJSONObject.put("click_area", paramInt1);
      if (paramtfc != null)
      {
        localJSONObject.put("column_id", paramtfc.jdField_a_of_type_Int);
        localJSONObject.put("rowkey", paramtfc.d);
        localJSONObject.put("video_report_info", paramtfc.e);
      }
      localJSONObject.put("diandianfeeds_type", 6);
    }
    catch (Exception paramtfc)
    {
      for (;;)
      {
        QLog.d("RecommendFeedsDiandianEntranceManager", 1, "getColumnDiandianR5 error! e=" + paramtfc);
      }
    }
    return localJSONObject.toString();
  }
  
  public static int b()
  {
    switch ()
    {
    default: 
      return 2130843133;
    case 4: 
      return 2130849330;
    }
    return 2130849297;
  }
  
  private RecommendFeedsDiandianEntranceManager.EntranceIconInfo b()
  {
    Object localObject = bkwm.a(pay.a().getCurrentUin());
    if (localObject != null) {
      try
      {
        localObject = ((SharedPreferences)localObject).getString("DianDianEntryIconInfo", "");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return null;
        }
        localObject = new JSONObject((String)localObject);
        RecommendFeedsDiandianEntranceManager.EntranceIconInfo localEntranceIconInfo = new RecommendFeedsDiandianEntranceManager.EntranceIconInfo();
        localEntranceIconInfo.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("icon_url", "");
        localEntranceIconInfo.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("feeds_type", 3);
        localEntranceIconInfo.c = ((JSONObject)localObject).optString("jump_schema", "");
        localEntranceIconInfo.b = ((JSONObject)localObject).optString("small_icon_url", "");
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
    }
    QLog.d("RecommendFeedsDiandianEntranceManager", 1, "getIconInfoFromSp entryInfo is null");
    return null;
  }
  
  private static boolean b()
  {
    return !TextUtils.isEmpty(a());
  }
  
  private void d()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo != null)
    {
      SharedPreferences localSharedPreferences = bkwm.a(pay.a().getCurrentUin());
      if (localSharedPreferences != null) {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("feeds_type", jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.jdField_a_of_type_Int);
          localJSONObject.put("icon_url", jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.jdField_a_of_type_JavaLangString);
          localJSONObject.put("small_icon_url", jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.b);
          localJSONObject.put("jump_schema", jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.c);
          if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$ExtraInfo != null) {}
          for (String str = jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$ExtraInfo.jdField_a_of_type_JavaLangString;; str = "")
          {
            localJSONObject.put("report_str", str);
            localJSONObject.put("use_gif", jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.jdField_a_of_type_Boolean);
            QLog.d("RecommendFeedsDiandianEntranceManager", 1, "saveIconInfo2Sp | jsonStr : " + localJSONObject.toString());
            localSharedPreferences.edit().putString("DianDianEntryIconInfo", localJSONObject.toString()).apply();
            return;
          }
          return;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  public int a()
  {
    return b;
  }
  
  public void a()
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    QLog.d("RecommendFeedsDiandianEntranceManager", 1, "checkAndReqRefreshDianDianIcon | request refresh icon info ,timeinterval : " + l);
    if (l < jdField_a_of_type_Int) {}
    while (((b != 3) && (b != 4)) || (pkm.a().a() == null)) {
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    pkm.a().a().b(b);
  }
  
  public void a(int paramInt)
  {
    odq.a(null, "CliOper", "", "", "0X80094FE", "0X80094FE", 0, 0, "", "", "", b(paramInt), false);
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
    pay.a(paramContext, jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.c);
    c();
  }
  
  public void a(RecommendFeedsDiandianEntranceManager.EntranceIconInfo paramEntranceIconInfo)
  {
    QLog.d("RecommendFeedsDiandianEntranceManager", 1, "handleDianDianIconRefresh | updateIconInfo : " + paramEntranceIconInfo);
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo = paramEntranceIconInfo;
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo != null)
    {
      b = jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.jdField_a_of_type_Int;
      QLog.d("RecommendFeedsDiandianEntranceManager", 1, "handleDianDianIconRefresh | sFeedsType update : " + b);
    }
    d();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      paramEntranceIconInfo = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramEntranceIconInfo.hasNext())
      {
        sqm localsqm = (sqm)paramEntranceIconInfo.next();
        ThreadManager.getUIHandler().post(new RecommendFeedsDiandianEntranceManager.1(this, localsqm));
      }
    }
  }
  
  public void a(String paramString)
  {
    int i = bkwm.f();
    QLog.d("RecommendFeedsDiandianEntranceManager", 1, "checkAndUpdateIconInfo | reason " + paramString + "; configFeedsType : " + i);
    paramString = b();
    if (paramString != null)
    {
      QLog.d("RecommendFeedsDiandianEntranceManager", 1, "checkAndUpdateIconInfo | spIconInfo : " + paramString);
      if (paramString.jdField_a_of_type_Int != i)
      {
        QLog.d("RecommendFeedsDiandianEntranceManager", 1, "checkAndUpdateIconInfo | spIconInfo updated");
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo = RecommendFeedsDiandianEntranceManager.EntranceIconInfo.a(i);
        b = jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.jdField_a_of_type_Int;
        d();
        return;
      }
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo = paramString;
      b = i;
      return;
    }
    if (a())
    {
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo = null;
      b = i;
      return;
    }
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo = RecommendFeedsDiandianEntranceManager.EntranceIconInfo.a(i);
    b = jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo.jdField_a_of_type_Int;
    QLog.d("RecommendFeedsDiandianEntranceManager", 1, "checkAndUpdateIconInfo | buildIconInfo with configFeedsType : " + i + " ; curIconInfo : " + jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$EntranceIconInfo);
  }
  
  public void a(sqm paramsqm)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramsqm != null) && (!this.jdField_a_of_type_JavaUtilList.contains(paramsqm))) {
      this.jdField_a_of_type_JavaUtilList.add(paramsqm);
    }
  }
  
  public void a(tfc paramtfc, int paramInt1, int paramInt2)
  {
    odq.a(null, "", "0X80094FF", "0X80094FF", 0, 0, "", "", "", a(paramtfc, paramInt1, paramInt2), false);
  }
  
  public boolean a()
  {
    int i = bkwm.f();
    return (i == 1) || (i == 2);
  }
  
  public String b(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      int i = b;
      String str = "0";
      int j = i;
      if (paramInt == 1)
      {
        if (this.c == 3) {
          i = 6;
        }
        str = ozh.b();
        j = i;
      }
      localJSONObject.put("diandianfeeds_type", j);
      localJSONObject.put("trigger_src", paramInt);
      localJSONObject.put("channel_id", str);
      str = localJSONObject.toString();
      return str;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public void b()
  {
    QLog.d("RecommendFeedsDiandianEntranceManager", 1, "onAccountChange");
    a("onAccountChange");
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!a()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        sqm localsqm = (sqm)localIterator.next();
        ThreadManager.getUIHandler().post(new RecommendFeedsDiandianEntranceManager.3(this, localsqm));
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void b(sqm paramsqm)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramsqm != null)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramsqm);
    }
  }
  
  public void c()
  {
    odq.a(null, "CliOper", "", "", "0X80094FF", "0X80094FF", 0, 0, "", "", "", b(0), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager
 * JD-Core Version:    0.7.0.1
 */