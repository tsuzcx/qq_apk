package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import java.util.TimerTask;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class ReadInJoyGlobalReporter
{
  private static volatile ReadInJoyGlobalReporter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReadInJoyGlobalReporter = null;
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  private static volatile int f = 0;
  public int a;
  public long a;
  ReadInJoyGlobalReporter.ScreenBroadcastReceiver jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReadInJoyGlobalReporter$ScreenBroadcastReceiver = null;
  final Object jdField_a_of_type_JavaLangObject = new Object();
  Timer jdField_a_of_type_JavaUtilTimer = null;
  TimerTask jdField_a_of_type_JavaUtilTimerTask = null;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = -1L;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 2;
  private long jdField_c_of_type_Long = 0L;
  private int d;
  private int e;
  private int g = 0;
  
  static
  {
    jdField_a_of_type_JavaLangString = "readinjoy_report";
    jdField_b_of_type_JavaLangString = "readinjoy_entertime";
    jdField_c_of_type_JavaLangString = "readinjoy_folderstatus";
    jdField_d_of_type_JavaLangString = "readinjoy_kandianmode";
    jdField_e_of_type_JavaLangString = "readinjoy_hearttime";
  }
  
  public ReadInJoyGlobalReporter()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
  }
  
  public static ReadInJoyGlobalReporter a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReadInJoyGlobalReporter == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReadInJoyGlobalReporter == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReadInJoyGlobalReporter = new ReadInJoyGlobalReporter();
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReadInJoyGlobalReporter;
    }
    finally {}
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReadInJoyGlobalReporter != null;
  }
  
  public static void c(int paramInt)
  {
    f = paramInt;
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public long a(QQAppInterface paramQQAppInterface)
  {
    long l = -1L;
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = BaseApplicationImpl.sApplication.getSharedPreferences(jdField_a_of_type_JavaLangString + paramQQAppInterface, 0);
    if (paramQQAppInterface != null) {
      l = paramQQAppInterface.getLong(jdField_e_of_type_JavaLangString, -1L);
    }
    return l;
  }
  
  protected String a()
  {
    return String.valueOf((NetConnInfoCenter.getServerTimeMillis() - this.jdField_b_of_type_Long) / 1000.0D);
  }
  
  @NotNull
  protected JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("folder_status", this.jdField_b_of_type_Int);
    localJSONObject.put("kandian_mode", "" + this.jdField_a_of_type_Int);
    localJSONObject.put("kandian_mode_new", VideoReporter.a());
    String str;
    if (ArticleInfoModule.b())
    {
      str = "1";
      localJSONObject.put("is_requesting_articles", str);
      localJSONObject.put("articles_request_type", ArticleInfoModule.a());
      if (!ArticleInfoModule.a()) {
        break label137;
      }
    }
    label137:
    for (int i = 1;; i = 0)
    {
      localJSONObject.put("hit_preload_cache", i);
      localJSONObject.put("os", 1);
      localJSONObject.put("version", VideoReporter.jdField_a_of_type_JavaLangString);
      localJSONObject.put("channel_id", f);
      return localJSONObject;
      str = "0";
      break;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyGlobalReporter", 2, "report time is =" + this.jdField_b_of_type_Long + ",isWeishi:" + this.jdField_b_of_type_Boolean);
    }
    if (NetConnInfoCenter.getServerTimeMillis() - this.jdField_a_of_type_Long < 3000L)
    {
      QLog.d("ReadInJoyGlobalReporter", 1, "too often");
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.d("ReadInJoyGlobalReporter", 1, "has report");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    try
    {
      JSONObject localJSONObject = a();
      if (this.jdField_b_of_type_Boolean) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009296", "0X8009296", 0, 0, String.valueOf((NetConnInfoCenter.getServerTimeMillis() - this.jdField_b_of_type_Long) / 1000.0D), "", "", localJSONObject.toString(), false);
      }
      for (;;)
      {
        ArticleInfoModule.a(false);
        ArticleInfoModule.a();
        return;
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80089D1", "0X80089D1", 0, 0, String.valueOf((NetConnInfoCenter.getServerTimeMillis() - this.jdField_b_of_type_Long) / 1000.0D), "", "", localJSONObject.toString(), false);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("ReadInJoyGlobalReporter", 1, localException.getMessage());
      }
    }
  }
  
  protected void a(QQAppInterface arg1)
  {
    f();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilTimerTask == null) {
        this.jdField_a_of_type_JavaUtilTimerTask = new ReadInJoyGlobalReporter.1(this);
      }
      if (this.jdField_a_of_type_JavaUtilTimer == null)
      {
        this.jdField_a_of_type_JavaUtilTimer = new Timer();
        this.jdField_a_of_type_JavaUtilTimer.schedule(this.jdField_a_of_type_JavaUtilTimerTask, 1000L, 10000L);
      }
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyGlobalReporter", 2, "setEnterTime(QQAppInterface app , long time) , time =" + paramLong + ",isWeishi:" + this.jdField_b_of_type_Boolean);
    }
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_Boolean = false;
    c(paramQQAppInterface, paramLong, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    a(paramQQAppInterface);
    g();
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyGlobalReporter", 2, "setEnterTime(QQAppInterface app , long time , int mode , int status) , time =" + paramLong + "   local time = " + System.currentTimeMillis() + ",isWeishi:" + this.jdField_b_of_type_Boolean);
    }
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = BaseApplicationImpl.sApplication.getSharedPreferences(jdField_a_of_type_JavaLangString + paramQQAppInterface, 0);
    if (paramQQAppInterface != null)
    {
      this.jdField_c_of_type_Long = paramQQAppInterface.getLong(jdField_b_of_type_JavaLangString, -1L);
      this.jdField_d_of_type_Int = paramQQAppInterface.getInt(jdField_d_of_type_JavaLangString, -1);
      this.jdField_e_of_type_Int = paramQQAppInterface.getInt(jdField_c_of_type_JavaLangString, -1);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyGlobalReporter", 2, "Load report time from sharedpreferences, time =" + this.jdField_c_of_type_Long);
    }
    if (this.jdField_c_of_type_Long != -1L) {
      bool = true;
    }
    return bool;
  }
  
  public void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    e();
    c(paramQQAppInterface, -1L, -1, -1);
    b(paramQQAppInterface, -1L);
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReadInJoyGlobalReporter = null;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    try
    {
      paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
      paramQQAppInterface = BaseApplicationImpl.sApplication.getSharedPreferences(jdField_a_of_type_JavaLangString + paramQQAppInterface, 0).edit();
      paramQQAppInterface.putLong(jdField_e_of_type_JavaLangString, paramLong);
      paramQQAppInterface.commit();
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    a(paramQQAppInterface, paramLong, paramInt1, paramInt2);
    if (a(paramQQAppInterface))
    {
      paramLong = a(paramQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.i("ReadInJoyGlobalReporter", 2, "Last heart time =" + paramLong + "  currect time=" + NetConnInfoCenter.getServerTimeMillis() + "  last entertime=" + this.jdField_b_of_type_Long);
      }
      if ((paramLong == -1L) || (Math.abs(NetConnInfoCenter.getServerTimeMillis() - paramLong) >= 15000L)) {
        break label191;
      }
      this.jdField_b_of_type_Long = this.jdField_c_of_type_Long;
      this.jdField_b_of_type_Int = this.jdField_e_of_type_Int;
      this.jdField_a_of_type_Int = this.jdField_d_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.i("ReadInJoyGlobalReporter", 2, "quite error,set enter time =" + this.jdField_b_of_type_Long);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      a(paramQQAppInterface);
      c(paramQQAppInterface, this.jdField_b_of_type_Long, paramInt1, paramInt2);
      g();
      return;
      label191:
      if (QLog.isColorLevel()) {
        QLog.i("ReadInJoyGlobalReporter", 2, "report error , time is out ");
      }
    }
  }
  
  public void c(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = BaseApplicationImpl.sApplication.getSharedPreferences(jdField_a_of_type_JavaLangString + paramQQAppInterface, 0).edit();
    paramQQAppInterface.putLong(jdField_b_of_type_JavaLangString, paramLong);
    paramQQAppInterface.putInt(jdField_c_of_type_JavaLangString, paramInt2);
    paramQQAppInterface.putInt(jdField_d_of_type_JavaLangString, paramInt1);
    paramQQAppInterface.commit();
  }
  
  public void e()
  {
    f();
    h();
  }
  
  public void f()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilTimerTask != null)
      {
        this.jdField_a_of_type_JavaUtilTimerTask.cancel();
        this.jdField_a_of_type_JavaUtilTimerTask = null;
      }
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
      return;
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReadInJoyGlobalReporter$ScreenBroadcastReceiver == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReadInJoyGlobalReporter$ScreenBroadcastReceiver = new ReadInJoyGlobalReporter.ScreenBroadcastReceiver(this, null);
    }
    ReadInJoyGlobalReporter.2 local2 = new ReadInJoyGlobalReporter.2(this);
    if (AppSetting.f)
    {
      ThreadManager.executeOnSubThread(local2, true);
      return;
    }
    local2.run();
  }
  
  public void h()
  {
    ReadInJoyGlobalReporter.3 local3 = new ReadInJoyGlobalReporter.3(this);
    if (AppSetting.f)
    {
      ThreadManager.executeOnSubThread(local3, true);
      return;
    }
    local3.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.ReadInJoyGlobalReporter
 * JD-Core Version:    0.7.0.1
 */