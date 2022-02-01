package com.huawei.hms.update.a.a;

public final class d
{
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN - " + paramInt;
    case 1000: 
      return "CHECK_OK";
    case 1201: 
      return "CHECK_FAILURE";
    case 1202: 
      return "CHECK_NO_UPDATE";
    case 1203: 
      return "CHECK_NO_SUPPORTED";
    case 2000: 
      return "DOWNLOAD_SUCCESS";
    case 2100: 
      return "DOWNLOADING";
    case 2101: 
      return "DOWNLOAD_CANCELED";
    case 2201: 
      return "DOWNLOAD_FAILURE";
    case 2203: 
      return "DOWNLOAD_NO_SPACE";
    case 2204: 
      return "DOWNLOAD_NO_STORAGE";
    }
    return "DOWNLOAD_HASH_ERROR";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.update.a.a.d
 * JD-Core Version:    0.7.0.1
 */