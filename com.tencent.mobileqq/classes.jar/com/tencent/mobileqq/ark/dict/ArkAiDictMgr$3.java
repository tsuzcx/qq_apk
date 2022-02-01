package com.tencent.mobileqq.ark.dict;

import com.tencent.wordsegment.WordSegment;
import mqq.app.AppRuntime;

final class ArkAiDictMgr$3
  implements Runnable
{
  ArkAiDictMgr$3(AppRuntime paramAppRuntime, WordSegmentResult paramWordSegmentResult, String paramString) {}
  
  public void run()
  {
    ArkAiDictMgr.a(this.jdField_a_of_type_MqqAppAppRuntime);
    if (ArkAiDictMgr.a())
    {
      WordSegmentResult localWordSegmentResult = this.jdField_a_of_type_ComTencentMobileqqArkDictWordSegmentResult;
      localWordSegmentResult.jdField_a_of_type_Boolean = true;
      localWordSegmentResult.jdField_a_of_type_ArrayOfJavaLangString = WordSegment.segment(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.dict.ArkAiDictMgr.3
 * JD-Core Version:    0.7.0.1
 */