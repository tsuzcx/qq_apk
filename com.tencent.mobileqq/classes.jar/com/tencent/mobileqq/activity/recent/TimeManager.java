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
  private static TimeManager b;
  private static final Object c = new Object();
  public CountDownTimer a;
  private long d;
  private HashMap<String, HashMap<String, String>> e;
  private String f = "yyyy-MM-dd";
  private HashMap<String, Boolean> g = new HashMap();
  private StringBuffer h = new StringBuffer(25);
  
  private TimeManager()
  {
    Object localObject = BaseApplication.getContext();
    this.e = new HashMap();
    f();
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
      this.f = ((String)localObject);
    } else {
      this.f = "yyyy-MM-dd";
    }
    this.a = new CountDownTimer(Looper.getMainLooper());
  }
  
  public static TimeManager a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new TimeManager();
        }
      }
      finally {}
    }
    return b;
  }
  
  private void f()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, 1);
    localCalendar.set(10, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    this.d = localCalendar.getTimeInMillis();
  }
  
  private boolean g()
  {
    if (System.currentTimeMillis() >= this.d)
    {
      f();
      synchronized (c)
      {
        this.e.clear();
        return false;
      }
    }
    return true;
  }
  
  public String a(String paramString, long paramLong)
  {
    synchronized (c)
    {
      Object localObject2 = (HashMap)this.e.get(paramString);
      Object localObject3;
      if ((localObject2 != null) && (g()))
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
        this.e.put(paramString, localObject2);
        ??? = null;
        paramString = (String)localObject2;
      }
      if (??? == null) {
        synchronized (this.h)
        {
          localObject2 = TimeFormatterUtilsProxy.a(this.h, 1000L * paramLong, true, this.f);
          if (QLog.isDevelopLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("getMsgDisplayTime, ");
            ((StringBuilder)localObject3).append(this.h.toString());
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
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.g.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public boolean a(String arg1)
  {
    boolean bool;
    if (!TextUtils.equals(this.f, ???))
    {
      if (!TextUtils.isEmpty(???)) {
        this.f = ???;
      } else {
        this.f = "yyyy-MM-dd";
      }
      bool = true;
    }
    else
    {
      bool = false;
    }
    synchronized (c)
    {
      if (this.e != null) {
        this.e.clear();
      }
      return bool;
    }
  }
  
  public String b()
  {
    return this.f;
  }
  
  public boolean b(String paramString)
  {
    return this.g.containsKey(paramString);
  }
  
  public void c()
  {
    CountDownTimer localCountDownTimer = this.a;
    if (localCountDownTimer != null) {
      localCountDownTimer.g();
    }
  }
  
  public void d()
  {
    CountDownTimer localCountDownTimer = this.a;
    if (localCountDownTimer != null) {
      localCountDownTimer.d();
    }
  }
  
  public void e()
  {
    CountDownTimer localCountDownTimer = this.a;
    if (localCountDownTimer != null) {
      localCountDownTimer.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.TimeManager
 * JD-Core Version:    0.7.0.1
 */