package com.tencent.mobileqq.activity.recent;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Looper;
import android.provider.Settings.System;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photopreview.CountDownTimer;
import com.tencent.mobileqq.imcore.proxy.RecentRoute.TimeFormatterUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.HashMap;

public class TimeManager
{
  private static TimeManager mInstance;
  private StringBuffer dateStrBuf = new StringBuffer(25);
  private long mCacheTime;
  public CountDownTimer mCountDownTimer;
  private String mDateFormat = "yyyy-MM-dd";
  private HashMap<String, HashMap<String, String>> mTimeCache;
  private HashMap<String, Boolean> oneTimeTaskMap = new HashMap();
  
  private TimeManager()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    this.mTimeCache = new HashMap();
    initCacheTime();
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (localBaseApplication != null) {
      localObject1 = localBaseApplication.getContentResolver();
    }
    try
    {
      localObject1 = Settings.System.getString((ContentResolver)localObject1, "date_format");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
      for (this.mDateFormat = ((String)localObject1);; this.mDateFormat = "yyyy-MM-dd")
      {
        this.mCountDownTimer = new CountDownTimer(Looper.getMainLooper());
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
  
  private boolean checkCacheTime()
  {
    if (System.currentTimeMillis() >= this.mCacheTime)
    {
      initCacheTime();
      this.mTimeCache.clear();
      return false;
    }
    return true;
  }
  
  public static TimeManager getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new TimeManager();
      }
      return mInstance;
    }
    finally {}
  }
  
  private void initCacheTime()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, 1);
    localCalendar.set(10, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    this.mCacheTime = localCalendar.getTimeInMillis();
  }
  
  public boolean checkContainsKey(String paramString)
  {
    return this.oneTimeTaskMap.containsKey(paramString);
  }
  
  public String getDateFormat()
  {
    return this.mDateFormat;
  }
  
  public String getMsgDisplayTime(String arg1, long paramLong)
  {
    HashMap localHashMap = (HashMap)this.mTimeCache.get(???);
    if ((localHashMap == null) || (!checkCacheTime()))
    {
      localHashMap = new HashMap();
      this.mTimeCache.put(???, localHashMap);
      ??? = null;
    }
    for (;;)
    {
      String str = ???;
      if (??? == null) {}
      synchronized (this.dateStrBuf)
      {
        str = RecentRoute.TimeFormatterUtils.getRecentMessageDateTime(this.dateStrBuf, 1000L * paramLong, true, this.mDateFormat);
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "getMsgDisplayTime, " + this.dateStrBuf.toString() + "," + str);
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
  
  public void pauseCountDownTimer()
  {
    if (this.mCountDownTimer != null) {
      this.mCountDownTimer.pause();
    }
  }
  
  public void putToOneTimeTaskMap(String paramString, boolean paramBoolean)
  {
    this.oneTimeTaskMap.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public void resumeCountDownTimer()
  {
    if (this.mCountDownTimer != null) {
      this.mCountDownTimer.resume();
    }
  }
  
  public boolean setDateFormat(String paramString)
  {
    boolean bool = false;
    if (!TextUtils.equals(this.mDateFormat, paramString)) {
      if (TextUtils.isEmpty(paramString)) {
        break label43;
      }
    }
    label43:
    for (this.mDateFormat = paramString;; this.mDateFormat = "yyyy-MM-dd")
    {
      bool = true;
      if (this.mTimeCache != null) {
        this.mTimeCache.clear();
      }
      return bool;
    }
  }
  
  public void startCountDownTimer()
  {
    if (this.mCountDownTimer != null) {
      this.mCountDownTimer.start();
    }
  }
  
  public void stopCountDownTimer()
  {
    if (this.mCountDownTimer != null) {
      this.mCountDownTimer.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.TimeManager
 * JD-Core Version:    0.7.0.1
 */