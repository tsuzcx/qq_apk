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
    Throwable localThrowable2 = this.o;
    Throwable localThrowable1 = localThrowable2;
    if (localThrowable2 == this) {
      localThrowable1 = null;
    }
    return localThrowable1;
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
    Object localObject1 = this.p;
    if (localObject1 == null) {
      return "";
    }
    Object localObject2 = localObject1.getClass().getName();
    localObject1 = localObject2;
    if (this.n != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(": ");
      localObject1 = ((StringBuilder)localObject1).toString();
      if (this.n.startsWith((String)localObject1)) {
        return this.n;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(this.n);
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.util.LogsUtil.a
 * JD-Core Version:    0.7.0.1
 */