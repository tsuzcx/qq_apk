package com.huawei.secure.android.common.util;

class LogsUtil$a
  extends Throwable
{
  private static final long serialVersionUID = 7129050843360571879L;
  private String n;
  private Throwable o;
  private Throwable p;
  
  public LogsUtil$a(Throwable paramThrowable)
  {
    this.p = paramThrowable;
  }
  
  public void b(Throwable paramThrowable)
  {
    this.o = paramThrowable;
  }
  
  public Throwable getCause()
  {
    if (this.o == this) {
      return null;
    }
    return this.o;
  }
  
  public String getMessage()
  {
    return this.n;
  }
  
  public void setMessage(String paramString)
  {
    this.n = paramString;
  }
  
  public String toString()
  {
    if (this.p == null) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = this.p.getClass().getName();
      localObject = str;
    } while (this.n == null);
    Object localObject = str + ": ";
    if (this.n.startsWith((String)localObject)) {
      return this.n;
    }
    return (String)localObject + this.n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.util.LogsUtil.a
 * JD-Core Version:    0.7.0.1
 */