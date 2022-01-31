package com.huawei.remoteLoader.client;

public class ARLoaderException
  extends Exception
{
  public static final int ERROR_PACKAGE_NOT_AVAILABLE = 1;
  public static final int ERROR_PACKAGE_OBSOLETE = 2;
  private final int errorCode;
  
  public ARLoaderException(int paramInt)
  {
    this.errorCode = paramInt;
  }
  
  private static final String errorCodeToString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "Unknown error";
    case 1: 
      return "Package not available";
    }
    return "Package obsolete";
  }
  
  public String toString()
  {
    String str = errorCodeToString(this.errorCode);
    return String.valueOf(str).length() + 17 + "LoaderException{" + str + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.huawei.remoteLoader.client.ARLoaderException
 * JD-Core Version:    0.7.0.1
 */