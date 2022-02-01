package com.huawei.hms.hatool;

import java.util.Calendar;
import java.util.UUID;

public class f0$a
{
  public String a = UUID.randomUUID().toString().replace("-", "");
  public boolean b;
  public long c;
  
  public f0$a(f0 paramf0, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    this.a = localStringBuilder.toString();
    this.c = paramLong;
    this.b = true;
    f0.a(paramf0, false);
  }
  
  public void a(long paramLong)
  {
    if (f0.a(this.d))
    {
      f0.a(this.d, false);
      b(paramLong);
      return;
    }
    if ((!b(this.c, paramLong)) && (!a(this.c, paramLong)))
    {
      this.c = paramLong;
      this.b = false;
      return;
    }
    b(paramLong);
  }
  
  public final boolean a(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    boolean bool = true;
    if (localCalendar1.get(1) == localCalendar2.get(1))
    {
      if (localCalendar1.get(6) != localCalendar2.get(6)) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public final void b(long paramLong)
  {
    y.c("hmsSdk", "getNewSession() session is flush!");
    this.a = UUID.randomUUID().toString();
    this.a = this.a.replace("-", "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    this.a = localStringBuilder.toString();
    this.c = paramLong;
    this.b = true;
  }
  
  public final boolean b(long paramLong1, long paramLong2)
  {
    return paramLong2 - paramLong1 >= f0.b(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.hatool.f0.a
 * JD-Core Version:    0.7.0.1
 */