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
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private long jdField_a_of_type_Long;
  public CountDownTimer a;
  private String jdField_a_of_type_JavaLangString = "yyyy-MM-dd";
  private StringBuffer jdField_a_of_type_JavaLangStringBuffer = new StringBuffer(25);
  private HashMap<String, HashMap<String, String>> jdField_a_of_type_JavaUtilHashMap;
  private HashMap<String, Boolean> b = new HashMap();
  
  private TimeManager()
  {
    Object localObject = BaseApplication.getContext();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    d();
    if (localObject != null) {
      localObject = ((Context)localObject).getContentResolver();
    }
    try
    {
      localObject = Settings.System.getString((ContentResolver)localObject, "date_format");
    }
    catch (Exception localException)
    {
      label72:
      break label72;
    }
    localObject = null;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.jdField_a_of_type_JavaLangString = ((String)localObject);
    } else {
      this.jdField_a_of_type_JavaLangString = "yyyy-MM-dd";
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer = new CountDownTimer(Looper.getMainLooper());
  }
  
  public static TimeManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityRecentTimeManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqActivityRecentTimeManager == null) {
          jdField_a_of_type_ComTencentMobileqqActivityRecentTimeManager = new TimeManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqActivityRecentTimeManager;
  }
  
  private boolean a()
  {
    if (System.currentTimeMillis() >= this.jdField_a_of_type_Long)
    {
      d();
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        return false;
      }
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
  
  public String a(String paramString, long paramLong)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      Object localObject2 = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      Object localObject3;
      if ((localObject2 != null) && (a()))
      {
        localObject3 = (String)((HashMap)localObject2).get(String.valueOf(paramLong));
        paramString = (String)localObject2;
        ??? = localObject3;
        if (localObject3 == null)
        {
          ((HashMap)localObject2).clear();
          paramString = (String)localObject2;
          ??? = localObject3;
        }
      }
      else
      {
        localObject2 = new HashMap();
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject2);
        ??? = null;
        paramString = (String)localObject2;
      }
      if (??? == null) {
        synchronized (this.jdField_a_of_type_JavaLangStringBuffer)
        {
          localObject2 = TimeFormatterUtilsProxy.a(this.jdField_a_of_type_JavaLangStringBuffer, 1000L * paramLong, true, this.jdField_a_of_type_JavaLangString);
          if (QLog.isDevelopLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("getMsgDisplayTime, ");
            ((StringBuilder)localObject3).append(this.jdField_a_of_type_JavaLangStringBuffer.toString());
            ((StringBuilder)localObject3).append(",");
            ((StringBuilder)localObject3).append((String)localObject2);
            QLog.i("Q.recent", 4, ((StringBuilder)localObject3).toString());
          }
          paramString.put(String.valueOf(paramLong), localObject2);
          return localObject2;
        }
      }
      return ???;
    }
  }
  
  public void a()
  {
    CountDownTimer localCountDownTimer = this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer;
    if (localCountDownTimer != null) {
      localCountDownTimer.g();
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.b.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public boolean a(String arg1)
  {
    boolean bool;
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, ???))
    {
      if (!TextUtils.isEmpty(???)) {
        this.jdField_a_of_type_JavaLangString = ???;
      } else {
        this.jdField_a_of_type_JavaLangString = "yyyy-MM-dd";
      }
      bool = true;
    }
    else
    {
      bool = false;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
      }
      return bool;
    }
  }
  
  public void b()
  {
    CountDownTimer localCountDownTimer = this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer;
    if (localCountDownTimer != null) {
      localCountDownTimer.d();
    }
  }
  
  public boolean b(String paramString)
  {
    return this.b.containsKey(paramString);
  }
  
  public void c()
  {
    CountDownTimer localCountDownTimer = this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer;
    if (localCountDownTimer != null) {
      localCountDownTimer.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.TimeManager
 * JD-Core Version:    0.7.0.1
 */