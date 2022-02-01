package com.tencent.mobileqq.ark;

import apmp;
import apmr;
import com.tencent.common.app.AppInterface;
import com.tencent.wordsegment.WordSegment;

public final class ArkAiDictMgr$3
  implements Runnable
{
  public ArkAiDictMgr$3(AppInterface paramAppInterface, apmr paramapmr, String paramString) {}
  
  public void run()
  {
    apmp.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    if (apmp.a())
    {
      this.jdField_a_of_type_Apmr.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Apmr.jdField_a_of_type_ArrayOfJavaLangString = WordSegment.segment(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictMgr.3
 * JD-Core Version:    0.7.0.1
 */