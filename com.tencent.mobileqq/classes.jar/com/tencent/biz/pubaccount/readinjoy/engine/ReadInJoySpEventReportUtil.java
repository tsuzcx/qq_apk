package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoySpEventReportUtil
{
  private static final LbsManagerServiceOnLocationChangeListener jdField_a_of_type_ComTencentMobileqqSosoLocationLbsManagerServiceOnLocationChangeListener = new ReadInJoySpEventReportUtil.1("readinjoy_anti_cheating", false);
  private static boolean jdField_a_of_type_Boolean = false;
  
  private static int a()
  {
    String str1 = a();
    String str2 = (String)ReadInJoyHelper.a("readinjoy_sp_key_last_request_lbs_date", "");
    QLog.d("ReadInJoySpEventReportUtil", 1, new Object[] { "getToadyRequestLbsTime, today = ", str1, ", lastRequestLbsDate = ", str2 });
    if (str1.equals(str2)) {
      return ((Integer)ReadInJoyHelper.a("readinjoy_sp_key_toady_request_lbs_time", Integer.valueOf(0))).intValue();
    }
    return 0;
  }
  
  private static SosoLocation a()
  {
    SosoLbsInfo localSosoLbsInfo = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("readinjoy_anti_cheating");
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null)) {
      return localSosoLbsInfo.mLocation;
    }
    return null;
  }
  
  private static String a()
  {
    return new SimpleDateFormat("yyyy.MM.dd").format(new Date());
  }
  
  public static void a()
  {
    long l = System.currentTimeMillis();
    QLog.d("ReadInJoySpEventReportUtil", 1, new Object[] { "init, app launch time = ", Long.valueOf(l) });
    ReadInJoyHelper.a("readinjoy_sp_key_app_launch_time", Long.valueOf(l));
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    SosoLocation localSosoLocation = a();
    if (localSosoLocation != null) {}
    for (;;)
    {
      try
      {
        paramJSONObject.put("longitude", localSosoLocation.mLon02);
        paramJSONObject.put("latitude", localSosoLocation.mLat02);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ReadInJoySpEventReportUtil", 2, new Object[] { "json = ", paramJSONObject });
        return;
      }
      catch (JSONException localJSONException)
      {
        QLog.d("ReadInJoySpEventReportUtil", 1, "addLbsInfo e = ", localJSONException);
        continue;
      }
      b();
    }
  }
  
  private static boolean a()
  {
    Object localObject = (QQAppInterface)ReadInJoyUtils.a();
    if ((localObject == null) || (!((QQAppInterface)localObject).isLogin()))
    {
      QLog.d("ReadInJoySpEventReportUtil", 1, "isAbleToRequestLbs: NO, app is null or not login, do not request.");
      return false;
    }
    if (jdField_a_of_type_Boolean)
    {
      QLog.d("ReadInJoySpEventReportUtil", 1, "isAbleToRequestLbs: NO, isRequestingLbs.");
      return false;
    }
    if (a() != null)
    {
      QLog.d("ReadInJoySpEventReportUtil", 1, "isAbleToRequestLbs: NO, cache is valid, no need to request.");
      return false;
    }
    if ((SystemUtil.b()) && (RIJAppSetting.b((QQAppInterface)localObject)))
    {
      QLog.i("ReadInJoySpEventReportUtil", 1, "[isAbleToRequestLbs] NO, MUI and app in background.");
      return false;
    }
    localObject = BaseApplicationImpl.getApplication().getApplicationContext();
    if ((localObject != null) && (Build.VERSION.SDK_INT >= 23) && (((Context)localObject).checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0))
    {
      QLog.d("ReadInJoySpEventReportUtil", 1, "isAbleToRequestLbs: NO, no location permission.");
      return false;
    }
    localObject = Aladdin.getConfig(165);
    if (localObject != null)
    {
      int i = ((AladdinConfig)localObject).getIntegerFromString("lbs_switch", 1);
      QLog.d("ReadInJoySpEventReportUtil", 1, new Object[] { "lbsSwitch = ", Integer.valueOf(i) });
      if (i != 1)
      {
        QLog.d("ReadInJoySpEventReportUtil", 1, "isAbleToRequestLbs: NO, switch is OFF, do not request.");
        return false;
      }
      i = ((AladdinConfig)localObject).getIntegerFromString("lbs_request_interval", 2);
      long l1 = ((Long)ReadInJoyHelper.a("readinjoy_sp_key_app_launch_time", Long.valueOf(System.currentTimeMillis()))).longValue();
      long l2 = (System.currentTimeMillis() - l1) / 1000L / 60L;
      QLog.d("ReadInJoySpEventReportUtil", 1, new Object[] { "from app launch interval = ", Long.valueOf(l2), ", lbsRequestInterval = ", Integer.valueOf(i), ", appLaunchTime = ", Long.valueOf(l1) });
      if (l2 <= i)
      {
        QLog.d("ReadInJoySpEventReportUtil", 1, "isAbleToRequestLbs: NO, less than lbs request interval.");
        return false;
      }
      i = ((AladdinConfig)localObject).getIntegerFromString("lbs_day_limit", 1);
      int j = a();
      QLog.d("ReadInJoySpEventReportUtil", 1, new Object[] { "lbsDayLimit = ", Integer.valueOf(i), ", todayRequestTime = ", Integer.valueOf(j) });
      if (j >= i)
      {
        QLog.d("ReadInJoySpEventReportUtil", 1, "isAbleToRequestLbs: NO, over lbs day limit.");
        return false;
      }
    }
    QLog.d("ReadInJoySpEventReportUtil", 1, "isAbleToRequestLbs: YES !!!");
    return true;
  }
  
  private static void b()
  {
    if (a())
    {
      ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(jdField_a_of_type_ComTencentMobileqqSosoLocationLbsManagerServiceOnLocationChangeListener);
      jdField_a_of_type_Boolean = true;
      c();
    }
  }
  
  private static void c()
  {
    String str = a();
    Object localObject = (String)ReadInJoyHelper.a("readinjoy_sp_key_last_request_lbs_date", "");
    QLog.d("ReadInJoySpEventReportUtil", 1, new Object[] { "updateToadyRequestLbsTime, today = ", str, ", lastRequestLbsDate = ", localObject });
    if (str.equals(localObject))
    {
      localObject = (Integer)ReadInJoyHelper.a("readinjoy_sp_key_toady_request_lbs_time", Integer.valueOf(0));
      QLog.d("ReadInJoySpEventReportUtil", 1, new Object[] { "updateToadyRequestLbsTime, todayTime = ", localObject });
      ReadInJoyHelper.a("readinjoy_sp_key_toady_request_lbs_time", Integer.valueOf(((Integer)localObject).intValue() + 1));
    }
    for (;;)
    {
      ReadInJoyHelper.a("readinjoy_sp_key_last_request_lbs_date", str);
      return;
      QLog.d("ReadInJoySpEventReportUtil", 1, "updateToadyRequestLbsTime, first time today.");
      ReadInJoyHelper.a("readinjoy_sp_key_toady_request_lbs_time", Integer.valueOf(1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoySpEventReportUtil
 * JD-Core Version:    0.7.0.1
 */