package com.huawei.hms.hatool;

public class f0
{
  public long a = 1800000L;
  public volatile boolean b = false;
  public f0.a c = null;
  
  public String a()
  {
    f0.a locala = this.c;
    if (locala == null)
    {
      y.f("hmsSdk", "getSessionName(): session not prepared. onEvent() must be called first.");
      return "";
    }
    return locala.a;
  }
  
  public void a(long paramLong)
  {
    f0.a locala = this.c;
    if (locala == null)
    {
      y.c("hmsSdk", "Session is first flush");
      this.c = new f0.a(this, paramLong);
      return;
    }
    locala.a(paramLong);
  }
  
  public boolean b()
  {
    f0.a locala = this.c;
    if (locala == null)
    {
      y.f("hmsSdk", "isFirstEvent(): session not prepared. onEvent() must be called first.");
      return false;
    }
    return locala.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.hatool.f0
 * JD-Core Version:    0.7.0.1
 */