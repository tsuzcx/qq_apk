package com.tencent.mobileqq.ark;

import com.tencent.common.app.AppInterface;
import com.tencent.wordsegment.WordSegment;

final class ArkAiDictMgr$3
  implements Runnable
{
  ArkAiDictMgr$3(AppInterface paramAppInterface, ArkAiDictMgr.WordSegmentResult paramWordSegmentResult, String paramString) {}
  
  public void run()
  {
    ArkAiDictMgr.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    if (ArkAiDictMgr.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictMgr$WordSegmentResult.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictMgr$WordSegmentResult.jdField_a_of_type_ArrayOfJavaLangString = WordSegment.segment(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictMgr.3
 * JD-Core Version:    0.7.0.1
 */