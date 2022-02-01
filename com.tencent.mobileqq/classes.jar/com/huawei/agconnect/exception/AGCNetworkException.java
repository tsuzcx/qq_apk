package com.huawei.agconnect.exception;

public class AGCNetworkException
  extends AGCException
{
  public static final int NETWORK_UNAVAILABLE = 0;
  public static final int SERVER_NOT_REACH = 1;
  
  public AGCNetworkException(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.agconnect.exception.AGCNetworkException
 * JD-Core Version:    0.7.0.1
 */