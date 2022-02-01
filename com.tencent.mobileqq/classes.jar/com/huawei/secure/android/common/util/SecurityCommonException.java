package com.huawei.secure.android.common.util;

public class SecurityCommonException
  extends Exception
{
  private static final long serialVersionUID = 1L;
  private String v;
  private String w;
  
  public SecurityCommonException() {}
  
  public SecurityCommonException(String paramString)
  {
    super(paramString);
    this.w = paramString;
  }
  
  public SecurityCommonException(String paramString1, String paramString2)
  {
    this.v = paramString1;
    this.w = paramString2;
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
    return this.w;
  }
  
  public String getRetCd()
  {
    return this.v;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.util.SecurityCommonException
 * JD-Core Version:    0.7.0.1
 */