package com.huawei.hms.stats;

public class ao
{
  private long a = 1800000L;
  private long b = 30000L;
  private volatile boolean c = false;
  private volatile long d = 0L;
  private ao.a e = null;
  
  public String a()
  {
    if (this.e == null)
    {
      af.c("SessionWrapper", "getSessionName(): session not prepared. onEvent() must be called first.");
      return "";
    }
    return this.e.a;
  }
  
  void a(long paramLong)
  {
    if (this.e == null)
    {
      af.b("SessionWrapper", "Session is first flush");
      this.e = new ao.a(this, paramLong);
      return;
    }
    this.e.a(paramLong);
  }
  
  public boolean b()
  {
    if (this.e == null)
    {
      af.c("SessionWrapper", "isFirstEvent(): session not prepared. onEvent() must be called first.");
      return false;
    }
    return this.e.b;
  }
  
  public void c()
  {
    this.e = null;
    this.d = 0L;
    this.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.stats.ao
 * JD-Core Version:    0.7.0.1
 */