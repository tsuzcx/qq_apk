package com.huawei.hms.framework.common;

import java.io.IOException;
import java.util.Arrays;
import org.json.JSONException;

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
    StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
    int i;
    if ((!(paramThrowable instanceof IOException)) && (!(paramThrowable instanceof JSONException))) {
      i = 20;
    } else {
      i = 8;
    }
    if (arrayOfStackTraceElement.length > i) {
      setStackTrace((StackTraceElement[])Arrays.copyOf(arrayOfStackTraceElement, i));
    } else {
      setStackTrace(arrayOfStackTraceElement);
    }
    setMessage(StringUtils.anonymizeMessage(paramThrowable.getMessage()));
  }
  
  private void setCause(Throwable paramThrowable)
  {
    this.thisCause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    Throwable localThrowable2 = this.thisCause;
    Throwable localThrowable1 = localThrowable2;
    if (localThrowable2 == this) {
      localThrowable1 = null;
    }
    return localThrowable1;
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
    Object localObject1 = this.ownerThrowable;
    if (localObject1 == null) {
      return "";
    }
    Object localObject2 = localObject1.getClass().getName();
    localObject1 = localObject2;
    if (this.message != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(": ");
      localObject1 = ((StringBuilder)localObject1).toString();
      if (this.message.startsWith((String)localObject1)) {
        return this.message;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(this.message);
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.common.Logger.ThrowableWrapper
 * JD-Core Version:    0.7.0.1
 */