package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyDailyViewController;
import com.tencent.biz.pubaccount.readinjoy.common.KandianDailyReportUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.IEntranceButtonDataSource;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import org.json.JSONException;
import org.json.JSONObject;

public class DailyFeedsDiandianEntranceManager
{
  private static DailyFeedsDiandianEntranceManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyFeedsDiandianEntranceManager = null;
  private int jdField_a_of_type_Int = 0;
  private int b = 0;
  
  private DailyFeedsDiandianEntranceManager()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(218);
    if (localAladdinConfig != null)
    {
      this.jdField_a_of_type_Int = localAladdinConfig.getIntegerFromString("daily_diandian_icon_mode_pure", 0);
      this.b = localAladdinConfig.getIntegerFromString("daily_diandian_icon_mode_mix", 0);
      QLog.d("DailyFeedsDiandianEntranceManager", 1, "Daily entry pure : " + this.jdField_a_of_type_Int + ", mix : " + this.b);
    }
  }
  
  public static DailyFeedsDiandianEntranceManager a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyFeedsDiandianEntranceManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyFeedsDiandianEntranceManager == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyFeedsDiandianEntranceManager = new DailyFeedsDiandianEntranceManager();
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyFeedsDiandianEntranceManager;
    }
    finally {}
  }
  
  public static IEntranceButtonDataSource a(Bundle paramBundle)
  {
    paramBundle = paramBundle.getParcelable("daily_bottom_entry_data");
    if ((paramBundle instanceof IEntranceButtonDataSource)) {
      return (IEntranceButtonDataSource)paramBundle;
    }
    return null;
  }
  
  private String a()
  {
    int i = -1;
    int j = a();
    if (j == 2) {
      i = 5;
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("diandianfeeds_type", i);
        ((JSONObject)localObject).put("trigger_src", 1);
        ((JSONObject)localObject).put("channel_id", KandianDailyReportUtils.b());
        localObject = ((JSONObject)localObject).toString();
        return localObject;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      if (j == 3) {
        i = 6;
      } else if (j == 1) {
        i = RecommendFeedsDiandianEntranceManager.a().b();
      }
    }
    return "";
  }
  
  public static boolean a(Bundle paramBundle)
  {
    return paramBundle.containsKey("daily_bottom_entry_data");
  }
  
  public int a()
  {
    if (!ReadInJoyHelper.m())
    {
      QLog.d("DailyFeedsDiandianEntranceManager", 1, "getEntryMode | hide mode");
      return 0;
    }
    if (DailyModeConfigHandler.a(DailyModeConfigHandler.b()))
    {
      QLog.d("DailyFeedsDiandianEntranceManager", 1, "getEntryMode |  entryModeInNormalDaily : " + this.jdField_a_of_type_Int);
      return this.jdField_a_of_type_Int;
    }
    QLog.d("DailyFeedsDiandianEntranceManager", 1, "getEntryMode |  entryModeInMixDaily : " + this.b);
    return this.b;
  }
  
  public View.OnClickListener a(Activity paramActivity, View paramView, ReadInJoyDailyViewController paramReadInJoyDailyViewController)
  {
    switch (a())
    {
    case 1: 
    default: 
      return new DailyFeedsDiandianEntranceManager.3(this, paramActivity);
    case 3: 
      return new DailyFeedsDiandianEntranceManager.1(this, paramReadInJoyDailyViewController);
    case 0: 
      return null;
    }
    return new DailyFeedsDiandianEntranceManager.2(this, paramActivity);
  }
  
  public void a()
  {
    if (a() != 0) {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80094FE", "0X80094FE", 0, 0, "", "", "", a(), false);
    }
  }
  
  public boolean a()
  {
    return a() != 0;
  }
  
  public void b()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80094FF", "0X80094FF", 0, 0, "", "", "", a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.DailyFeedsDiandianEntranceManager
 * JD-Core Version:    0.7.0.1
 */