package com.huawei.hms.stats;

import java.util.Calendar;
import java.util.UUID;

class ao$a
{
  String a = UUID.randomUUID().toString().replace("-", "");
  boolean b;
  private long d;
  
  ao$a(ao paramao, long paramLong)
  {
    this.a = (this.a + "_" + paramLong);
    this.d = paramLong;
    this.b = true;
    ao.a(paramao, false);
  }
  
  private boolean a(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    return (localCalendar1.get(1) != localCalendar2.get(1)) || (localCalendar1.get(6) != localCalendar2.get(6));
  }
  
  private void b(long paramLong)
  {
    af.b("SessionWrapper", "getNewSession() session is flush!");
    this.a = UUID.randomUUID().toString();
    this.a = this.a.replace("-", "");
    this.a = (this.a + "_" + paramLong);
    this.d = paramLong;
    this.b = true;
  }
  
  private boolean b(long paramLong1, long paramLong2)
  {
    return paramLong2 - paramLong1 >= ao.b(this.c);
  }
  
  void a(long paramLong)
  {
    if (ao.a(this.c))
    {
      ao.a(this.c, false);
      b(paramLong);
      return;
    }
    if ((b(this.d, paramLong)) || (a(this.d, paramLong)))
    {
      b(paramLong);
      return;
    }
    this.d = paramLong;
    this.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.stats.ao.a
 * JD-Core Version:    0.7.0.1
 */