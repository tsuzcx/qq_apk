package com.huawei.hms.framework.common;

class Logger$ThrowableWrapper
  extends Throwable
{
  private static final long serialVersionUID = 7129050843360571879L;
  private String message;
  private Throwable ownerThrowable;
  private Throwable thisCause;
  
  private Logger$ThrowableWrapper(Throwable paramThrowable)
  {
    this.ownerThrowable = paramThrowable;
  }
  
  private void setCause(Throwable paramThrowable)
  {
    this.thisCause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    if (this.thisCause == this) {
      return null;
    }
    return this.thisCause;
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public void setMessage(String paramString)
  {
    this.message = paramString;
  }
  
  public String toString()
  {
    if (this.ownerThrowable == null) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = this.ownerThrowable.getClass().getName();
      localObject = str;
    } while (this.message == null);
    Object localObject = str + ": ";
    if (this.message.startsWith((String)localObject)) {
      return this.message;
    }
    return (String)localObject + this.message;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.framework.common.Logger.ThrowableWrapper
 * JD-Core Version:    0.7.0.1
 */