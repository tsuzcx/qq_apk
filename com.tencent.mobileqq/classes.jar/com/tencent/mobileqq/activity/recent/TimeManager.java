package com.tencent.mobileqq.activity.recent;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Looper;
import android.provider.Settings.System;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photopreview.CountDownTimer;
import com.tencent.mobileqq.imcore.proxy.basic.TimeFormatterUtilsProxy;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.HashMap;

public class TimeManager
{
  private static TimeManager jdField_a_of_type_ComTencentMobileqqActivityRecentTimeManager;
  private long jdField_a_of_type_Long;
  public CountDownTimer a;
  private String jdField_a_of_type_JavaLangString = "yyyy-MM-dd";
  private StringBuffer jdField_a_of_type_JavaLangStringBuffer = new StringBuffer(25);
  private HashMap<String, HashMap<String, String>> jdField_a_of_type_JavaUtilHashMap;
  private HashMap<String, Boolean> b = new HashMap();
  
  private TimeManager()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    d();
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (localBaseApplication != null) {
      localObject1 = localBaseApplication.getContentResolver();
    }
    try
    {
      localObject1 = Settings.System.getString((ContentResolver)localObject1, "date_format");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
      for (this.jdField_a_of_type_JavaLangString = ((String)localObject1);; this.jdField_a_of_type_JavaLangString = "yyyy-MM-dd")
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer = new CountDownTimer(Looper.getMainLooper());
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
  
  public static TimeManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityRecentTimeManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityRecentTimeManager == null) {
        jdField_a_of_type_ComTencentMobileqqActivityRecentTimeManager = new TimeManager();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityRecentTimeManager;
    }
    finally {}
  }
  
  private boolean a()
  {
    if (System.currentTimeMillis() >= this.jdField_a_of_type_Long)
    {
      d();
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      return false;
    }
    return true;
  }
  
  private void d()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, 1);
    localCalendar.set(10, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    this.jdField_a_of_type_Long = localCalendar.getTimeInMillis();
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(String arg1, long paramLong)
  {
    HashMap localHashMap = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(???);
    if ((localHashMap == null) || (!a()))
    {
      localHashMap = new HashMap();
      this.jdField_a_of_type_JavaUtilHashMap.put(???, localHashMap);
      ??? = null;
    }
    for (;;)
    {
      String str = ???;
      if (??? == null) {}
      synchronized (this.jdField_a_of_type_JavaLangStringBuffer)
      {
        str = TimeFormatterUtilsProxy.a(this.jdField_a_of_type_JavaLangStringBuffer, 1000L * paramLong, true, this.jdField_a_of_type_JavaLangString);
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "getMsgDisplayTime, " + this.jdField_a_of_type_JavaLangStringBuffer.toString() + "," + str);
        }
        localHashMap.put(String.valueOf(paramLong), str);
        return str;
        ??? = (String)localHashMap.get(String.valueOf(paramLong));
        if (??? == null) {
          localHashMap.clear();
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer.g();
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.b.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public boolean a(String paramString)
  {
    boolean bool = false;
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString)) {
      if (TextUtils.isEmpty(paramString)) {
        break label43;
      }
    }
    label43:
    for (this.jdField_a_of_type_JavaLangString = paramString;; this.jdField_a_of_type_JavaLangString = "yyyy-MM-dd")
    {
      bool = true;
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
      }
      return bool;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer.d();
    }
  }
  
  public boolean b(String paramString)
  {
    return this.b.containsKey(paramString);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.TimeManager
 * JD-Core Version:    0.7.0.1
 */