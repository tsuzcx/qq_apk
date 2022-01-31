package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import java.util.TimerTask;
import muf;
import mug;
import muh;
import mui;
import org.json.JSONObject;

public class ReadInJoyGlobalReporter
{
  private static volatile ReadInJoyGlobalReporter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReadInJoyGlobalReporter;
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  public int a;
  public long a;
  final Object jdField_a_of_type_JavaLangObject = new Object();
  Timer jdField_a_of_type_JavaUtilTimer = null;
  TimerTask jdField_a_of_type_JavaUtilTimerTask = null;
  public mui a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = -1L;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 2;
  private long jdField_c_of_type_Long;
  private int d;
  private int e;
  private int f;
  
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
    this.jdField_a_of_type_Mui = null;
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
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyGlobalReporter", 2, "report time is =" + this.jdField_b_of_type_Long + ",isWeishi:" + this.jdField_b_of_type_Boolean);
    }
    if (NetConnInfoCenter.getServerTimeMillis() - this.jdField_a_of_type_Long < 3000L) {}
    while (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("folder_status", this.jdField_b_of_type_Int);
        localJSONObject.put("kandian_mode", "" + this.jdField_a_of_type_Int);
        localJSONObject.put("kandian_mode_new", VideoReporter.a());
        if (ArticleInfoModule.a())
        {
          String str1 = "1";
          localJSONObject.put("is_requesting_articles", str1);
          if (this.jdField_b_of_type_Boolean)
          {
            PublicAccountReportUtils.a(null, "", "0X8009296", "0X8009296", 0, 0, String.valueOf((NetConnInfoCenter.getServerTimeMillis() - this.jdField_b_of_type_Long) / 1000L), "", "", localJSONObject.toString(), false);
            return;
          }
          PublicAccountReportUtils.a(null, "", "0X80089D1", "0X80089D1", 0, 0, String.valueOf((NetConnInfoCenter.getServerTimeMillis() - this.jdField_b_of_type_Long) / 1000L), "", "", localJSONObject.toString(), false);
          return;
        }
      }
      catch (Exception localException)
      {
        return;
      }
      String str2 = "0";
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  protected void a(QQAppInterface arg1)
  {
    c();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilTimerTask == null) {
        this.jdField_a_of_type_JavaUtilTimerTask = new muf(this);
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
    b(paramQQAppInterface, paramLong, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    a(paramQQAppInterface);
    d();
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyGlobalReporter", 2, "setEnterTime(QQAppInterface app , long time , int mode , int status) , time =" + paramLong + "   local time = " + System.currentTimeMillis() + ",isWeishi:" + this.jdField_b_of_type_Boolean);
    }
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Int = paramInt1;
    if (a(paramQQAppInterface))
    {
      paramLong = a(paramQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.i("ReadInJoyGlobalReporter", 2, "Last heart time =" + paramLong + "  currect time=" + NetConnInfoCenter.getServerTimeMillis() + "  last entertime=" + this.jdField_b_of_type_Long);
      }
      if ((paramLong == -1L) || (Math.abs(NetConnInfoCenter.getServerTimeMillis() - paramLong) >= 15000L)) {
        break label249;
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
      b(paramQQAppInterface, this.jdField_b_of_type_Long, paramInt1, paramInt2);
      d();
      return;
      label249:
      if (QLog.isColorLevel()) {
        QLog.i("ReadInJoyGlobalReporter", 2, "report error , time is out ");
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
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
    return this.jdField_c_of_type_Long != -1L;
  }
  
  public void b()
  {
    c();
    e();
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    b();
    b(paramQQAppInterface, -1L, -1, -1);
    b(paramQQAppInterface, -1L);
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReadInJoyGlobalReporter = null;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = BaseApplicationImpl.sApplication.getSharedPreferences(jdField_a_of_type_JavaLangString + paramQQAppInterface, 0).edit();
    paramQQAppInterface.putLong(jdField_e_of_type_JavaLangString, paramLong);
    paramQQAppInterface.commit();
  }
  
  public void b(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = BaseApplicationImpl.sApplication.getSharedPreferences(jdField_a_of_type_JavaLangString + paramQQAppInterface, 0).edit();
    paramQQAppInterface.putLong(jdField_b_of_type_JavaLangString, paramLong);
    paramQQAppInterface.putInt(jdField_c_of_type_JavaLangString, paramInt2);
    paramQQAppInterface.putInt(jdField_d_of_type_JavaLangString, paramInt1);
    paramQQAppInterface.commit();
  }
  
  public void c()
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
  
  public void d()
  {
    if (this.jdField_a_of_type_Mui == null) {
      this.jdField_a_of_type_Mui = new mui(this, null);
    }
    mug localmug = new mug(this);
    if (AppSetting.d)
    {
      ThreadManager.executeOnSubThread(localmug, true);
      return;
    }
    localmug.run();
  }
  
  public void e()
  {
    muh localmuh = new muh(this);
    if (AppSetting.d)
    {
      ThreadManager.executeOnSubThread(localmuh, true);
      return;
    }
    localmuh.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.ReadInJoyGlobalReporter
 * JD-Core Version:    0.7.0.1
 */