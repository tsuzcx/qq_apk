package com.tencent.falco.utils;

public class LiveClientTypeUtil
{
  public static int getAppIdFromClientType(int paramInt)
  {
    int i = 0;
    if (paramInt > 1000)
    {
      i = paramInt >> 4 & 0xFFFF;
      return i;
    }
    switch (paramInt)
    {
    }
    return 0;
  }
  
  public static int getAppInfoFromClientType(int paramInt)
  {
    int i = 0;
    if (paramInt > 1000)
    {
      i = paramInt >> 20 & 0xF;
      return i;
    }
    switch (paramInt)
    {
    }
    return 0;
  }
  
  public static int getClientIdFromClientType(int paramInt)
  {
    if (paramInt > 1000) {
      return paramInt & 0xF;
    }
    switch (paramInt)
    {
    case 403: 
    default: 
      return 0;
    case 401: 
      return 2;
    case 402: 
      return 1;
    }
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.utils.LiveClientTypeUtil
 * JD-Core Version:    0.7.0.1
 */