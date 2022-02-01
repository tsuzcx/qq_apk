package com.tencent.falco.utils;

public class LiveClientTypeUtil
{
  public static int getAppIdFromClientType(int paramInt)
  {
    if (paramInt > 1000) {
      return 0xFFFF & paramInt >> 4;
    }
    if ((paramInt != 401) && (paramInt != 402)) {}
    return 0;
  }
  
  public static int getAppInfoFromClientType(int paramInt)
  {
    if (paramInt > 1000) {
      return paramInt >> 20 & 0xF;
    }
    if ((paramInt != 401) && (paramInt != 402)) {}
    return 0;
  }
  
  public static int getClientIdFromClientType(int paramInt)
  {
    if (paramInt > 1000) {
      return paramInt & 0xF;
    }
    if (paramInt != 401)
    {
      if (paramInt != 402)
      {
        if (paramInt != 404) {
          return 0;
        }
        return 3;
      }
      return 1;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.utils.LiveClientTypeUtil
 * JD-Core Version:    0.7.0.1
 */