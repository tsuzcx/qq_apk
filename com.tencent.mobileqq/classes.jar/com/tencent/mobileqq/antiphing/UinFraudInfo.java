package com.tencent.mobileqq.antiphing;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class UinFraudInfo
{
  private static UinFraudInfo a;
  private Map<Long, UinFraudInfo.FraudInfo> b = new HashMap();
  private Map<Long, Long> c = new HashMap();
  
  public static UinFraudInfo a()
  {
    if (a == null) {
      a = new UinFraudInfo();
    }
    return a;
  }
  
  public int a(long paramLong)
  {
    long l = System.currentTimeMillis();
    if (this.b.containsKey(Long.valueOf(paramLong)))
    {
      UinFraudInfo.FraudInfo localFraudInfo = (UinFraudInfo.FraudInfo)this.b.get(Long.valueOf(paramLong));
      if (l - localFraudInfo.b < 3600000L)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("AntiFraud", 4, "Found from local cache, the fraud flag is true");
        }
        return localFraudInfo.a;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("AntiFraud", 4, "Found from local cache, timestamp is out of data");
      }
      this.b.remove(Long.valueOf(paramLong));
      return 0;
    }
    if (this.c.containsKey(Long.valueOf(paramLong)))
    {
      if (l - ((Long)this.c.get(Long.valueOf(paramLong))).longValue() < 43200000L)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("AntiFraud", 4, "Found from local cache, the fraud flag is false");
        }
        return 0;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("AntiFraud", 4, "Found from local cache, timestamp is out of data");
      }
      this.c.remove(Long.valueOf(paramLong));
      return 0;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("AntiFraud", 4, "use default value, false");
    }
    return 0;
  }
  
  public void a(long paramLong, int paramInt)
  {
    long l = System.currentTimeMillis();
    UinFraudInfo.FraudInfo localFraudInfo = new UinFraudInfo.FraudInfo(this);
    localFraudInfo.a = paramInt;
    localFraudInfo.b = l;
    if (this.b.size() > 500) {
      this.b.clear();
    }
    this.b.put(Long.valueOf(paramLong), localFraudInfo);
    if (this.c.containsKey(Long.valueOf(paramLong))) {
      this.c.remove(Long.valueOf(paramLong));
    }
  }
  
  public boolean b(long paramLong)
  {
    long l = System.currentTimeMillis();
    if (this.b.containsKey(Long.valueOf(paramLong)))
    {
      if (l - ((UinFraudInfo.FraudInfo)this.b.get(Long.valueOf(paramLong))).b > 3600000L)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("AntiFraud", 4, "FraudUin, Found from local cache, timestamp is out of data");
        }
        this.b.remove(Long.valueOf(paramLong));
        return true;
      }
      return false;
    }
    if (this.c.containsKey(Long.valueOf(paramLong)))
    {
      if (l - ((Long)this.c.get(Long.valueOf(paramLong))).longValue() > 43200000L)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("AntiFraud", 4, "NonFraudUin, Found from local cache, timestamp is out of data");
        }
        this.c.remove(Long.valueOf(paramLong));
        return true;
      }
      return false;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("AntiFraud", 4, "Out of date, use default value, true!");
    }
    return true;
  }
  
  public void c(long paramLong)
  {
    long l = System.currentTimeMillis();
    if (this.c.size() > 500) {
      this.c.clear();
    }
    this.c.put(Long.valueOf(paramLong), Long.valueOf(l));
    if (this.b.containsKey(Long.valueOf(paramLong))) {
      this.b.remove(Long.valueOf(paramLong));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.antiphing.UinFraudInfo
 * JD-Core Version:    0.7.0.1
 */