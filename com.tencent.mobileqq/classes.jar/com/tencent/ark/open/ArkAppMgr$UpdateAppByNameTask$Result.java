package com.tencent.ark.open;

public class ArkAppMgr$UpdateAppByNameTask$Result
{
  public static final int Fail = 0;
  public static final int NoUpdate = 2;
  public static final int Update = 1;
  
  public static String toString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "Unknown";
    case 0: 
      return "Fail";
    case 1: 
      return "Update";
    }
    return "NoUpdate";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppMgr.UpdateAppByNameTask.Result
 * JD-Core Version:    0.7.0.1
 */