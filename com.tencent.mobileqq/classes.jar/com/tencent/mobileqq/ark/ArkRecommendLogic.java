package com.tencent.mobileqq.ark;

import android.os.Handler;

public class ArkRecommendLogic
{
  private static final ArkRecommendLogic.ArkWordSegmentThread jdField_a_of_type_ComTencentMobileqqArkArkRecommendLogic$ArkWordSegmentThread = new ArkRecommendLogic.ArkWordSegmentThread();
  private static volatile boolean jdField_a_of_type_Boolean = false;
  
  public static Handler a()
  {
    try
    {
      if (!jdField_a_of_type_Boolean)
      {
        jdField_a_of_type_Boolean = true;
        a().a().post(new ArkRecommendLogic.1());
      }
      Handler localHandler = jdField_a_of_type_ComTencentMobileqqArkArkRecommendLogic$ArkWordSegmentThread.a();
      return localHandler;
    }
    finally {}
  }
  
  public static ArkRecommendLogic.ArkWordSegmentThread a()
  {
    return jdField_a_of_type_ComTencentMobileqqArkArkRecommendLogic$ArkWordSegmentThread;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkRecommendLogic
 * JD-Core Version:    0.7.0.1
 */