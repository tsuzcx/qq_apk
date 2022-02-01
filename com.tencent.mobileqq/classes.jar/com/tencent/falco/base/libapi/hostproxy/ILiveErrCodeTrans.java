package com.tencent.falco.base.libapi.hostproxy;

public class ILiveErrCodeTrans
{
  public static int a(int paramInt)
  {
    if (paramInt != 1004)
    {
      if (paramInt != 1006) {
        return 3;
      }
      return 2;
    }
    return 1;
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 7;
    case 1006: 
      return 6;
    case 1005: 
      return 5;
    case 1004: 
      return 4;
    case 1003: 
      return 3;
    case 1002: 
      return 2;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.libapi.hostproxy.ILiveErrCodeTrans
 * JD-Core Version:    0.7.0.1
 */