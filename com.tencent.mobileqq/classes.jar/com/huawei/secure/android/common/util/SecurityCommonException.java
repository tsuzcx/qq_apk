package com.huawei.secure.android.common.util;

public class SecurityCommonException
  extends Exception
{
  private static final long serialVersionUID = 1L;
  private String t;
  private String u;
  
  public SecurityCommonException() {}
  
  public SecurityCommonException(String paramString)
  {
    super(paramString);
    this.u = paramString;
  }
  
  public SecurityCommonException(String paramString1, String paramString2)
  {
    this.t = paramString1;
    this.u = paramString2;
  }
  
  public SecurityCommonException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public SecurityCommonException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
  
  public String getMsgDes()
  {
    return this.u;
  }
  
  public String getRetCd()
  {
    return this.t;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.secure.android.common.util.SecurityCommonException
 * JD-Core Version:    0.7.0.1
 */