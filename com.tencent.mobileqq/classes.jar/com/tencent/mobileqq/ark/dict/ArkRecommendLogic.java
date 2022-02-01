package com.tencent.mobileqq.ark.dict;

import android.os.Handler;

public class ArkRecommendLogic
{
  private static final ArkRecommendLogic.ArkWordSegmentThread a = new ArkRecommendLogic.ArkWordSegmentThread();
  private static volatile boolean b = false;
  
  public static Handler a()
  {
    try
    {
      if (!b)
      {
        b = true;
        b().a().post(new ArkRecommendLogic.1());
      }
      Handler localHandler = a.a();
      return localHandler;
    }
    finally {}
  }
  
  public static ArkRecommendLogic.ArkWordSegmentThread b()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.dict.ArkRecommendLogic
 * JD-Core Version:    0.7.0.1
 */